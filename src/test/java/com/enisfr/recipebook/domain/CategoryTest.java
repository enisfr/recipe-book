package com.enisfr.recipebook.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryTest {

    Category category;


    @BeforeEach
    public void setUp() {
        category = new Category();
    }

    @Test
    void getId() {
        Long id = 35L;
        category.setId(id);
        assertEquals(id, category.getId());
    }

    @Test
    void getDescription() {
    }

    @Test
    void getRecipes() {
    }
}
