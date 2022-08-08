package mymeals

import grails.async.*


class AsyncMealSuggestionService {

    @DelegateAsync MealSuggestionService mealSuggestionService
    Promise<List<MealSuggestion>> getMealSuggestions (String url) {
        Promises.task {
            mealSuggestionService.getMealSuggestions(url)
        }
    }
}
