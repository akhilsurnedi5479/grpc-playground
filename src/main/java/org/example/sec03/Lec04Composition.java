package org.example.sec03;

import org.example.models.sec03.Address;
import org.example.models.sec03.School;
import org.example.models.sec03.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec04Composition {
    private static final Logger log = LoggerFactory.getLogger(Lec04Composition.class);

    public static void main(String[] args) {
        var address = Address.newBuilder()
                .setStreet("123 Main st")
                .setCity("atlanta")
                .setState("GA")
                .build();
        var student = Student.newBuilder()
                .setName("sam")
                .setAddress(address)
                .build();

        var school = School.newBuilder()
                .setId(1)
                .setName("high school")
                .setAddress(address.toBuilder().setStreet("222 main street")) // set has it own build method so we dont need to specify it
                .build();

        log.info("school: {}",school);
        log.info("student: {} ",student);
    }
}
