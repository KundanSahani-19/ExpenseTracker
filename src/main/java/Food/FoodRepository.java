package Food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    /**
     * Finds a food item by its exact name match.
     *
     * @param name the exact name of the food item to search for
     * @return an Optional containing the found food item or empty if not found
     */
    Optional<Food> findByName(String name);

    /**
     * Finds all food items with price greater than the specified value.
     *
     * @param price the minimum price threshold (exclusive)
     * @return a list of food items meeting the price criteria
     */
    List<Food> findByPriceGreaterThan(double price);

    /**
     * Finds food items whose names contain the given keyword (case-insensitive).
     *
     * @param keyword the search term to look for in food names
     * @return a list of matching food items
     */
    List<Food> findByNameContainingIgnoreCase(String keyword);

    /**
     * Finds food items within a specified price range, ordered by price ascending.
     * Uses a custom JPQL query for the search.
     *
     * @param name the name parameter (note: appears to be incorrectly named for price range query)
     * @return a list of food items within the price range
     */
    @Query("select f from Food f where f.price BETWEEN ?1 AND ?2 ORDER BY f.price ASC ")
    List<Food> findFoodInPriceRange(String name);
}
