import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getMealType();
}

class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian Meal";
    }
}

class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan Meal";
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto Meal";
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealType() {
        return "High-Protein Meal";
    }
}

class Meal<T extends MealPlan> {
    private String mealName;
    private T mealType;
    
    public Meal(String mealName, T mealType) {
        this.mealName = mealName;
        this.mealType = mealType;
    }
    
    public void displayMeal() {
        System.out.println("Meal: " + mealName + ", Type: " + mealType.getMealType());
    }
}

class MealPlanGenerator {
    private List<Meal<? extends MealPlan>> meals = new ArrayList<>();
    
    public void addMeal(Meal<? extends MealPlan> meal) {
        meals.add(meal);
    }
    
    public void displayMeals() {
        for (Meal<? extends MealPlan> meal : meals) {
            meal.displayMeal();
        }
    }
    
    public static <T extends MealPlan> void validateMeal(T meal) {
        System.out.println("Validating meal: " + meal.getMealType());
    }
}

public class MealPlanSystem {
    public static void main(String[] args) {
        MealPlanGenerator mealPlanGenerator = new MealPlanGenerator();
        
        Meal<VegetarianMeal> vegMeal = new Meal<>("Grilled Veggies", new VegetarianMeal());
        Meal<VeganMeal> veganMeal = new Meal<>("Tofu Stir Fry", new VeganMeal());
        Meal<KetoMeal> ketoMeal = new Meal<>("Keto Chicken", new KetoMeal());
        Meal<HighProteinMeal> proteinMeal = new Meal<>("Protein Bowl", new HighProteinMeal());
        
        mealPlanGenerator.addMeal(vegMeal);
        mealPlanGenerator.addMeal(veganMeal);
        mealPlanGenerator.addMeal(ketoMeal);
        mealPlanGenerator.addMeal(proteinMeal);
        
        System.out.println("\n--- Meal Plan ---");
        mealPlanGenerator.displayMeals();
        
        MealPlanGenerator.validateMeal(new VegetarianMeal());
        MealPlanGenerator.validateMeal(new VeganMeal());
        MealPlanGenerator.validateMeal(new KetoMeal());
        MealPlanGenerator.validateMeal(new HighProteinMeal());
    }
}
