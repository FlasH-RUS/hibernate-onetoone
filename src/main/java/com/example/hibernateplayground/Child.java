package com.example.hibernateplayground;

import java.time.Instant;

import lombok.Getter;

@Getter
public class Child {

    private Parent parent;

    private final Instant createdOn = Instant.now();

}
