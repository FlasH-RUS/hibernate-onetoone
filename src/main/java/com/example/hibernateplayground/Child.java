package com.example.hibernateplayground;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Child {

    @Id
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "PARENT_ID")
    @Setter(AccessLevel.PACKAGE)
    private Parent parent;

    @Column(name = "CREATED_ON")
    private final Instant createdOn = Instant.now();

    Child(final Parent parent) { // Bidirectional relationships are required to be updated explicitly
        this.parent = parent;
    }

}
