package com.enisfr.recipebook.services;

import com.enisfr.recipebook.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
