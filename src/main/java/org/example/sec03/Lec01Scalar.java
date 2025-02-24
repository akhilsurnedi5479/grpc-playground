package org.example.sec03;

import org.example.models.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec01Scalar {
    private static final Logger log = LoggerFactory.getLogger(Lec01Scalar.class);

    public static void main(String[] args) {

        var person = Person.newBuilder()
                .setLastName("sam")
                .setAge(12)
                .setEmail("same@gmail.com")
                .setEmployed(true)
                .setSalary(1000.4567)
                //.setBankAccountNumber(123435243524242345L)
                .setBalance(-10000)
                .build();

        log.info("Person : {}",person);
    }
}
