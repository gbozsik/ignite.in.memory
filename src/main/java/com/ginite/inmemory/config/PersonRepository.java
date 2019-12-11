package com.ginite.inmemory.config;

import com.ginite.inmemory.domain.Person;
import org.apache.ignite.springdata20.repository.IgniteRepository;
import org.apache.ignite.springdata20.repository.config.RepositoryConfig;

@RepositoryConfig(cacheName = "baeldungCache")
public interface PersonRepository extends IgniteRepository<Person, Integer> {

    Person getPersonById(Integer id);
}
