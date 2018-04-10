package com.example.hibernateplayground;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OneToOneIntegrationTest {

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void shouldSaveWithEmptyChild() {
        // given
        final Parent parent = new Parent();

        // when
        parentRepository.save(parent);
    }

    @Test
    public void shouldLoadWithEmptyChild() {
        // given
        final Parent parent = new Parent();
        parentRepository.saveAndFlush(parent);
        entityManager.clear();

        // when
        final Parent loaded = parentRepository.findOne(parent.getId());

        // then
        assertThat(loaded.getChild(), is(nullValue()));
    }

    @Test
    public void shouldSaveWithChild() {
        // given
        final Parent parent = new Parent();
        parent.setChild(new Child());

        // when
        parentRepository.save(parent);
    }

    @Test
    public void shouldLoadWithChild() {
        // given
        final Parent parent = new Parent();
        parent.setChild(new Child());
        parentRepository.saveAndFlush(parent);
        entityManager.clear();

        // when
        final Parent loaded = parentRepository.findOne(parent.getId());

        // then
        assertThat(loaded.getChild(), is(notNullValue()));
    }

    @Test
    public void shouldDeleteWithEmptyChild() throws Exception {
        // given
        final Parent parent = new Parent();
        parentRepository.saveAndFlush(parent);
        entityManager.clear();

        // when
        parentRepository.delete(parent.getId());
    }

    @Test
    public void shouldDeleteWithChild() throws Exception {
        // given
        final Parent parent = new Parent();
        parent.setChild(new Child());
        parentRepository.saveAndFlush(parent);
        entityManager.clear();

        // when
        parentRepository.delete(parent.getId());

        // then
        assertThat(childRepository.findAll(), is(empty()));
    }

}
