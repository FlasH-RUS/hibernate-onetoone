package com.example.hibernateplayground;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Child implements Serializable { // Required to be serializable by Hibernate

    private static final long serialVersionUID = 5750234865910588996L;

    @Id
    @OneToOne
    @JoinColumn(name = "PARENT_ID")
    private Parent parent;

    @Column(name = "CREATED_ON")
    private final Instant createdOn = Instant.now();

    // Bidirectional relationships are required to be updated explicitly
    Child(final Parent parent) {
        this.parent = parent;
    }

}
