package org.example.sec02;

import org.example.models.sec02.Person;
import org.example.sec01.SimpleProtoDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Comparision {
    private static final Logger log = LoggerFactory.getLogger(Comparision.class);

    public static void main(String[] args) {

        //create person1
        var person1 = createPerson();

        //create person2
        var person2 = createPerson();

        //compare
        log.info("equals {}", person1.equals(person2));
        log.info("== {}", (person1 == person2));

        //mutable? No

        //create another instance with diff values
        var person3 = person1.toBuilder().setName("mike").build();
        log.info("equals {}", person1.equals(person3));
        log.info("== {}", (person1 == person3));


        //null?
        //var person4 = person1.toBuilder().setName(null).build();
        //log.info("person4: {}", person4);

        //Instead of null we use clear method
        var person5 = person1.toBuilder().clearName().build();
        log.info("person5: {}", person5);


    }

    private static Person createPerson(){
        return Person.newBuilder()
                .setName("sam")
                .setAge(20)
                .build();
    }

}
