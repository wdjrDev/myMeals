package mymeals

import grails.async.Promise
import grails.async.PromiseList
import groovy.json.JsonSlurper
import groovy.json.internal.LazyMap
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic

class MealSuggestionService {

    @CompileDynamic
    ArrayList getMealDataByUrl(String urlString) {
        ArrayList mealsList
        if(urlString) {
            try {
                LazyMap mealMap = new JsonSlurper().parseText(new URL(urlString).text)
                mealsList = mealMap.getAt("meals")
            } catch (Exception ex) {
                logback ex.cause
            } finally {
                return mealsList
            }
        }
        return mealsList
    }
    @CompileStatic
    ArrayList<MealSuggestion> getMealSuggestionList (ArrayList mealsList){
        ArrayList<MealSuggestion> mealSuggestionList = new ArrayList<>()
        if(mealsList && mealsList.size()>0) {
            println("the list size: ${mealsList.size()}")
            println("${mealsList.toString()}")
            mealsList.each { meal ->
                MealSuggestion mealSuggestion = new MealSuggestion()
                mealSuggestion.strMeal << meal.getAt('strMeal') ?: ''
                mealSuggestion.strMealThumb << (meal.getAt("strMealThumb") ?: '')
                mealSuggestion.idMeal << (meal.getAt("idMeal") ?: '')
                mealSuggestionList.add(mealSuggestion)
                println("iterate through meal ${mealSuggestionList.size()}")
            }
            println("inside if block ${mealSuggestionList.size()}")
        }
        println("outside if block ${mealSuggestionList.size()}")
        return mealSuggestionList
    }

    @CompileStatic
    ArrayList<MealSuggestion>getMealSuggestions (String url){
           def results = getMealSuggestionList(getMealDataByUrl(url))
        return results
    }
}
