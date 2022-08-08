package mymeals

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString


@EqualsAndHashCode(includes=['idMeal','strMeal','strMealThumb'])
@ToString(includeNames=true)
@CompileStatic
class MealSuggestion {
    /**
     * String strMeal maps to the strMeal object response from themealdb.com/api/json/ API
    **/
    String strMeal
    /**
     *  String strMealThumb maps to the strMealThumb object response from themealdb.com/api/json/ API
     */
    String strMealThumb
    /**
     * int idMeal maps to the idMeal response from the themealdb.com/api/json/ API
     */
    String idMeal
}
