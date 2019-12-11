package com.ginite.inmemory.domain;

import lombok.ToString;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.io.Serializable;

@ToString
public class Person implements Serializable {

    public Person(int id, int _key, String name, int age) {
        this.id = id;
        this._key = _key;
        this.name = name;
        this.age = age;
    }

    @QuerySqlField(index = true)
    int id;

    @QuerySqlField(index = true)
    int _key;

    @QuerySqlField(index = true)
    String name;

    @QuerySqlField(index = true)
    int age;
}
