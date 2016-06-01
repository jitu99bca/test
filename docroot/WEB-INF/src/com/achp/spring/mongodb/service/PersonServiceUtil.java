package com.achp.spring.mongodb.service;
import com.achp.spring.mongodb.mode.Person;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.core.MongoTemplate;

/*import org.springframework.data.mongodb.core.MongoTemplate;*/

public class PersonServiceUtil{
    public static final String COLLECTION_NAME = "person";
    public static void addPerson(Person person,MongoTemplate mongoTemplate) {
        if (!mongoTemplate.collectionExists(Person.class)) {
            mongoTemplate.createCollection(Person.class);
        }       
        person.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(person, COLLECTION_NAME);
    }
     
    public static List<Person> listPerson(MongoTemplate mongoTemplate) {
        return mongoTemplate.findAll(Person.class, COLLECTION_NAME);
    }
     
    public static void deletePerson(Person person,MongoTemplate mongoTemplate) {
        mongoTemplate.remove(person, COLLECTION_NAME);
    }
     
    public static void updatePerson(Person person,MongoTemplate mongoTemplate) {
        mongoTemplate.insert(person, COLLECTION_NAME);      
    }
}