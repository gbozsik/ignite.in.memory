package com.ginite.inmemory.config;

import com.ginite.inmemory.domain.Person;
import com.ginite.inmemory.model.jolmodel.DatasetWrapper;
import org.apache.ignite.Ignition;
import org.apache.ignite.client.ClientCache;
import org.apache.ignite.client.ClientException;
import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.configuration.ClientConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfig {


    public ClientConfiguration getClientconfig() {
        ClientConfiguration cfg = new ClientConfiguration().setAddresses("192.168.2.29:10800");
        try {

            IgniteClient igniteClient = Ignition.startClient(cfg);
            return cfg;
        } catch (
                ClientException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.format("Unexpected failure: %s\n", e);
        }
        return null;
    }

    public ClientCache<Integer, DatasetWrapper> getDatasetWrapperCache() {
        try (IgniteClient igniteClient = Ignition.startClient(getClientconfig())) {

            final String CACHE_NAME = "datasetWrapperCache";
            ClientCache<Integer, DatasetWrapper> cache = igniteClient.getOrCreateCache(CACHE_NAME);
            System.out.format(">>> Created cache [%s].\n", CACHE_NAME);
            return cache;
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

}
