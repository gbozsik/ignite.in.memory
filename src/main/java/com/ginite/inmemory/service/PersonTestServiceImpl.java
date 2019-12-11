package com.ginite.inmemory.service;

import com.ginite.inmemory.config.DatasourceConfig;
import com.ginite.inmemory.config.PersonRepository;
import com.ginite.inmemory.domain.Person;
import com.ginite.inmemory.model.jolmodel.DatasetWrapper;
import org.apache.ignite.Ignition;
import org.apache.ignite.client.ClientCache;
import org.apache.ignite.client.ClientException;
import org.apache.ignite.client.IgniteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class PersonTestServiceImpl {

    @Autowired
    private DatasourceConfig datasourceConfig;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private PersonRepository personRepository;

    LocalDateTime startOfInsert = LocalDateTime.now();

    public void insertDatasetWrapper() {
        playWithDatasetWrapper();
    }

    Integer key = 1;

    public void playWithDatasetWrapper() {

        try (IgniteClient igniteClient = Ignition.startClient(datasourceConfig.getClientconfig())) {
            System.out.println();
            System.out.println(">>> Thin client put-get example started.");
            final String CACHE_NAME = "put-get-example";
            ClientCache<Integer, DatasetWrapper> cache = igniteClient.getOrCreateCache(CACHE_NAME);
            System.out.format(">>> Created cache [%s].\n", CACHE_NAME);

            DatasetWrapper datasetWrapper = conversionService.getDatasetWrapper();
            LocalDateTime startOfInsert = LocalDateTime.now();
//            DatasetWrapper cachedVal = cache.get(key);
            Duration duration = Duration.between(startOfInsert, LocalDateTime.now());
            System.out.println("Insertion time: " + duration);

//            System.out.format(">>> Loaded [%s] from the cache.\n", cachedVal.toString());
        } catch (
                ClientException e) {
            System.err.println(e.getMessage());
//            Duration duration = Duration.between(startOfInsert, LocalDateTime.now());
//            System.out.println("Insertion time: " + duration);
        } catch (
                Exception e) {
            System.err.format("Unexpected failure: %s\n", e);
//            Duration duration = Duration.between(startOfInsert, LocalDateTime.now());
//            System.out.println("Insertion time: " + duration);
        }
    }

    public DatasetWrapper readFromCache() {
        try (IgniteClient igniteClient = Ignition.startClient(datasourceConfig.getClientconfig())) {
            final String CACHE_NAME = "put-get-example";
            ClientCache<Integer, DatasetWrapper> cache = igniteClient.getOrCreateCache(CACHE_NAME);
            System.out.format(">>> Created cache [%s].\n", CACHE_NAME);
//            System.out.println(cache.get(key).toString());
            Duration duration = Duration.between(startOfInsert, LocalDateTime.now());
            System.out.println("Read time: " + duration);
            return cache.get(key);
        } catch (
                ClientException e) {
            System.err.println(e.getMessage());
            return null;
        } catch (
                Exception e) {
            System.err.format("Unexpected failure: %s\n", e);
            return null;
        }
    }

    public void playWithPerson() {
        Person person = new Person(1, 1, "John", 33);
        personRepository.save(person);
        Person personFromDb = personRepository.getPersonById(1);
        System.out.println("person fromDB: " + personFromDb);
    }
}
