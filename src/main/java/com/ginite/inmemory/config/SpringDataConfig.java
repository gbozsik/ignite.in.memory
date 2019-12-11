package com.ginite.inmemory.config;

import com.ginite.inmemory.domain.Person;
import com.ginite.inmemory.model.jolmodel.DatasetWrapper;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.ClientConfiguration;

import org.apache.ignite.springdata20.repository.config.EnableIgniteRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableIgniteRepositories
public class SpringDataConfig {

    @Bean
    public IgniteClient igniteInstance() {
        ClientConfiguration cfg = new ClientConfiguration().setAddresses("192.168.2.29:10800");
        IgniteClient igniteClient = Ignition.startClient(cfg);

//        cfg.setCacheConfiguration(cache);
        return Ignition.startClient(cfg);
    }

    @Bean
    public CacheConfiguration getPersonCache() {
        CacheConfiguration cache = new CacheConfiguration("baeldungCache");
        cache.setIndexedTypes(Integer.class, Person.class);
        return cache;
    }
}