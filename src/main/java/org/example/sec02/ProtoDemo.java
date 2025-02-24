package org.example.sec02;

import org.example.models.sec02.Person;
import org.example.sec01.SimpleProtoDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoDemo {
    private static final Logger log = LoggerFactory.getLogger(ProtoDemo.class);

    public static void main(String[] args) {
        var person = Person.newBuilder()
                .setName("sam")
                .setAge(20)
                .build();

        log.info("{}", person);
    }
}
