package org.example.sec03;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import org.example.models.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec03PerformanceTest {
    private static final Logger log = LoggerFactory.getLogger(Lec03PerformanceTest.class);
    private static final ObjectMapper mapper = new ObjectMapper();
    public static void main(String[] args) {
        var protoPerson = Person.newBuilder()
                .setLastName("sam")
                .setAge(12)
                .setEmail("same@gmail.com")
                .setEmployed(true)
                .setSalary(1000.4567)
                .setBankAccountNumber(123435243524242345L)
                .setBalance(-10000)
                .build();

        var jsonPerson = new JsonPerson("sam,",12,"same@gmail.com",true,1000.4567,123435243524242345L,
                -1000);

        for(int i =0;i<5;i++){
            runTest("json",()->json(jsonPerson));
            runTest("proto",()->proto(protoPerson));
        }

    }


    private static void proto(Person person) {
        try{
            var bytes = person.toByteArray();
            log.info("proto bytes len: {}",bytes.length);
            Person.parseFrom(bytes);
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
    }


    private static void json(JsonPerson person) {
        try {
            var bytes = mapper.writeValueAsBytes(person);
            log.info("json bytes len: {}",bytes.length);
            mapper.readValue(bytes, JsonPerson.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void runTest(String testName, Runnable runnable){
        var start = System.currentTimeMillis();

        for(int i =0;i<5000000;i++){
            runnable.run();
        }
        var end = System.currentTimeMillis();
        log.info("time taken for {} - {}ms",testName,(end-start));

    }
}
