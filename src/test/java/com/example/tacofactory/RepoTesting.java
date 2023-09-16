package com.example.tacofactory;


import com.example.tacofactory.model.Ingredient;
import com.example.tacofactory.service.IngredientService;
import jakarta.validation.constraints.AssertTrue;
import lombok.NoArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.Assert;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class RepoTesting {
    @Autowired
    private IngredientService ingredientService;

    @Test
    public void TestSavingAnIngredient(){
        Ingredient sauce =
        Ingredient.builder().id("MRNR").name("Marinara sauce").type(Ingredient.Type.SAUCE).build();
        boolean saved = ingredientService.save(sauce);
        if(saved){
            Assertions.assertThat(saved);
        }
    }

    @Test
    public void TestFetchingIngredientsOfType(){
        Ingredient sauce =
                Ingredient.builder().id("MRNR").name("Marinara sauce").type(Ingredient.Type.SAUCE).build();
        boolean saved = ingredientService.save(sauce);
        Iterable<Ingredient> ings = ingredientService.getByType(Ingredient.Type.SAUCE);

        Assertions.assertThat(ings).hasSizeGreaterThan(0);

    }
}
