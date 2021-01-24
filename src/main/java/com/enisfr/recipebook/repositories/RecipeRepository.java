package com.enisfr.recipebook.repositories;

import com.enisfr.recipebook.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
