# Spring Boot JPA Hibernate one-to-one hibernate playground
The project is just a playground to figure out the correct way to work with one-to-one mappings in Spring Boot JPA + Hibernate.

## Setup
- Spring Boot 1.5.12.RELEASE
- H2 as a DB
- 2 entities ([Parent](src/main/java/com/example/hibernateplayground/Parent.java) and [Child](src/main/java/com/example/hibernateplayground/Child.java)) to set up the one-to-one relationship
- A Data JPA test ([OneToOneIntegrationTest](src/test/java/com/example/hibernateplayground/OneToOneIntegrationTest.java)) to make sure everything works as expected

## Process
Each approach will have a corresponding branch depicting the approach itself, its pitfalls, etc. both documented in code (as comments) and here (see the link below).

Current branch detailed description is available [here](Branch.md).
