package mymeals

import groovy.json.JsonSlurper
import groovy.json.internal.LazyMap
import groovy.transform.CompileDynamic

class MealSuggestionService {

    @CompileDynamic
    ArrayList getMealSuggestionsByUrl(String urlString) {
        ArrayList<MealSuggestion> mealSuggestions
        if(urlString) {
            try {
                LazyMap mealMap = new JsonSlurper().parseText(new URL(urlString).text)
                ArrayList<Map> listOfMaps = mealMap.getAt("meals")
                mealSuggestions = new ArrayList<MealSuggestion>(listOfMaps.size())
                listOfMaps.each{ map ->
                    MealSuggestion mealSuggestion = new MealSuggestion(idMeal:map.idMeal,strMeal: map.strMeal,strMealThumb: map.strMealThumb)
                    mealSuggestions.add(mealSuggestion)
                }

            } catch (Exception ex) {
                logback ex.cause
            } finally {
                return mealSuggestions
            }
        }
        return mealSuggestions
    }
}
