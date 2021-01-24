package com.enisfr.recipebook.bootstrap;

import com.enisfr.recipebook.domain.*;
import com.enisfr.recipebook.repositories.CategoryRepository;
import com.enisfr.recipebook.repositories.RecipeRepository;
import com.enisfr.recipebook.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
        log.debug("Loading Bootstrap data");
    }
    private List<Recipe> getRecipes() {
        List<Recipe> recipeList = new ArrayList<>(2);

        //get Unit of Measures
        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");
        if (!eachUomOptional.isPresent()) {
            throw new RuntimeException("Expected OUM not found");
        }

        Optional<UnitOfMeasure> tablespoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
        if (!tablespoonUomOptional.isPresent()) {
            throw new RuntimeException("Expected OUM not found");
        }

        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        if (!teaSpoonUomOptional.isPresent()) {
            throw new RuntimeException("Expected OUM not found");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");
        if (!dashUomOptional.isPresent()) {
            throw new RuntimeException("Expected OUM not found");
        }

        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");
        if (!cupUomOptional.isPresent()) {
            throw new RuntimeException("Expected OUM not found");
        }

        Optional<UnitOfMeasure> pinchUomOptional = unitOfMeasureRepository.findByDescription("Pinch");
        if (!pinchUomOptional.isPresent()) {
            throw new RuntimeException("Expected OUM not found");
        }

        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");
        if (!pintUomOptional.isPresent()) {
            throw new RuntimeException("Expected OUM not found");
        }

        Optional<UnitOfMeasure> ounceUomOptional = unitOfMeasureRepository.findByDescription("Ounce");
        if (!ounceUomOptional.isPresent()) {
            throw new RuntimeException("Expected OUM not found");
        }

        // get Optionals
        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tablespoonUom = tablespoonUomOptional.get();
        UnitOfMeasure teaSpoonUom = teaSpoonUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure cupUom = cupUomOptional.get();
        UnitOfMeasure pinchUom = pinchUomOptional.get();
        UnitOfMeasure pintUom = pintUomOptional.get();
        UnitOfMeasure ounceUom = ounceUomOptional.get();

        // get Categories

        Optional<Category> turkishCategoryOptional = categoryRepository.findByDescription("Turkish");
        if (!turkishCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category not found");
        }

        Optional<Category> germanCategoryOptional = categoryRepository.findByDescription("German");
        if (!germanCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category not found");
        }

        Optional<Category> greekCategoryOptional = categoryRepository.findByDescription("Greek");
        if (!greekCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category not found");
        }

        Optional<Category> frenchCategoryOptional = categoryRepository.findByDescription("French");
        if (!frenchCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category not found");
        }

        // get Optionals
        Category turkishCategory = turkishCategoryOptional.get();
        Category germanCategory = germanCategoryOptional.get();
        Category greekCategory = greekCategoryOptional.get();
        Category frenchCategory = frenchCategoryOptional.get();

        // Guacamole Recipe
        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("In a medium bowl, mash together the avocados, lime juice, and salt. " +
                "Mix in onion, cilantro, tomatoes, and garlic. Stir in cayenne pepper. Refrigerate 1 hour " +
                "for best flavor, or serve immediately.");
        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("Upgrade your cutting boards using our guide to the best cutting boards on the market, " +
                "then use them to prepare our favorite recipes.");
        guacRecipe.setNotes(guacNotes);
        guacRecipe.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), eachUom));
        guacRecipe.addIngredient(new Ingredient("kosher salt", new BigDecimal(".5"), teaSpoonUom));
        guacRecipe.addIngredient(new Ingredient("lime juice", new BigDecimal(2), tablespoonUom));
        guacRecipe.addIngredient(new Ingredient("minced red onion", new BigDecimal(".5"), tablespoonUom));
        guacRecipe.addIngredient(new Ingredient("serrano chilies", new BigDecimal(".5"), eachUom));
        guacRecipe.addIngredient(new Ingredient("cilantro", new BigDecimal(".5"), tablespoonUom));
        guacRecipe.addIngredient(new Ingredient("black pepper", new BigDecimal(".5"), dashUom));
        guacRecipe.addIngredient(new Ingredient("ripe tomato", new BigDecimal(".5"), eachUom));
        guacRecipe.getCategories().add(turkishCategory);
        guacRecipe.getCategories().add(greekCategory);

        recipeList.add(guacRecipe);


        //Yummy Tacos
        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDescription("Spicy Taco");
        tacosRecipe.setCookTime(9);
        tacosRecipe.setPrepTime(20);
        tacosRecipe.setDifficulty(Difficulty.MODERATE);

        tacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n"
        );

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvu7Q0MJ");

        tacosRecipe.setNotes(tacoNotes);


        tacosRecipe.addIngredient(new Ingredient("Anchor Chili Powder", new BigDecimal(2), tablespoonUom));
        tacosRecipe.addIngredient(new Ingredient("Dried Oregano", new BigDecimal(1), teaSpoonUom));
        tacosRecipe.addIngredient(new Ingredient("Dried Cumin", new BigDecimal(1), teaSpoonUom));
        tacosRecipe.addIngredient(new Ingredient("Sugar", new BigDecimal(1), teaSpoonUom));
        tacosRecipe.addIngredient(new Ingredient("Salt", new BigDecimal(".5"), teaSpoonUom));
        tacosRecipe.addIngredient(new Ingredient("Clove of Garlic, Choppedr", new BigDecimal(1), eachUom));
        tacosRecipe.addIngredient(new Ingredient("finely grated orange zestr", new BigDecimal(1), tablespoonUom));
        tacosRecipe.addIngredient(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tablespoonUom));
        tacosRecipe.addIngredient(new Ingredient("Olive Oil", new BigDecimal(2), tablespoonUom));
        tacosRecipe.addIngredient(new Ingredient("small corn tortillasr", new BigDecimal(8), eachUom));
        tacosRecipe.addIngredient(new Ingredient("packed baby arugula", new BigDecimal(3), cupUom));
        tacosRecipe.addIngredient(new Ingredient("medium ripe avocados, slic", new BigDecimal(2), eachUom));
        tacosRecipe.addIngredient(new Ingredient("radishes, thinly sliced", new BigDecimal(4), eachUom));
        tacosRecipe.addIngredient(new Ingredient("cherry tomatoes, halved", new BigDecimal(".5"), pintUom));
        tacosRecipe.addIngredient(new Ingredient("red onion, thinly sliced", new BigDecimal(".25"), eachUom));
        tacosRecipe.addIngredient(new Ingredient("Roughly chopped cilantro", new BigDecimal(4), eachUom));
        tacosRecipe.addIngredient(new Ingredient("cup sour cream thinned with 1/4 cup milk", new BigDecimal(4), cupUom));
        tacosRecipe.addIngredient(new Ingredient("lime, cut into wedges", new BigDecimal(4), eachUom));

        tacosRecipe.getCategories().add(germanCategory);
        tacosRecipe.getCategories().add(frenchCategory);
        tacosRecipe.getCategories().add(turkishCategory);

        recipeList.add(tacosRecipe);
        return recipeList;

    }

}
