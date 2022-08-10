package mymeals

import grails.async.*


class AsyncMealSuggestionService {

    @DelegateAsync MealSuggestionService mealSuggestionService
    Promise<List<MealSuggestion>> getMealSuggestionsByUrl (String url) {
        Promises.task {
            mealSuggestionService.getMealSuggestionsByUrl(url)
        }
    }
}
