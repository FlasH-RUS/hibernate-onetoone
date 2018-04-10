package com.example.hibernateplayground;

import java.time.Instant;

import lombok.Getter;

@Getter
public class Parent {

    private final Instant createdOn = Instant.now();

    private Child child;

}
