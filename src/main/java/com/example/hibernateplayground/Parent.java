package com.example.hibernateplayground;

import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;

@Entity
@Getter
public class Parent {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "CREATED_ON")
    private final Instant createdOn = Instant.now();

    // optional = false results in null generated ID exceptions for Child - should be enforced by DB itself if needed
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "parent", fetch = FetchType.LAZY)
    private final Child child = new Child(this);

}
