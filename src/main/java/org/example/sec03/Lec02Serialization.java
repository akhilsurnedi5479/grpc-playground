package org.example.sec03;

import org.example.models.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lec02Serialization {
    private static final Logger log = LoggerFactory.getLogger(Lec01Scalar.class);
    private static final Path  PATH = Path.of("person.out");

    public static void main(String[] args) throws IOException {

        var person = Person.newBuilder()
                .setLastName("sam")
                .setAge(12)
                .setEmail("same@gmail.com")
                .setEmployed(true)
                .setSalary(1000.4567)
                .setBankAccountNumber(123435243524242345L)
                .setBalance(-10000)
                .build();
        log.info("Person : {}", person);

        serialize(person);
        log.info("{} ",deserialize());
        log.info("equals: {}", person.equals(deserialize()));


    }

    public static  void  serialize(Person person) throws IOException {
        try(var stream = Files.newOutputStream(PATH)){
            person.writeTo(stream);
        }
        //person.writeTo(Files.newOutputStream(PATH));
    }
    public static Person deserialize() throws IOException {
        try(var stream = Files.newInputStream(PATH)){
            return Person.parseFrom(stream);
        }
        //return Person.parseFrom(Files.newInputStream(PATH));
    }
}
