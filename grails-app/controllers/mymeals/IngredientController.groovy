package mymeals

import grails.config.Config
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*


class IngredientController {

    IngredientService ingredientService
    UrlBuilderService urlBuilderService
   // AsyncMealSuggestionService mealSuggestionService
    MealSuggestionService mealSuggestionService



    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(params) {
        ArrayList<Ingredient> ingredientList=ingredientService.list(params)
        return [ingredientList:ingredientList, count:ingredientService.count()]

    }
    def list(params){
        ArrayList<Ingredient> ingredientList=ingredientService.list(params)
        return ingredientList
    }

    //@todo move the urlBuilderService out into the Meal Suggestion Service just pass the suggestionRequest bean to the gsp
    def show(Long id) {
        Ingredient ingredient = Ingredient.get(id)
        SuggestionRequest suggestionRequest = new SuggestionRequest()
        suggestionRequest.setId(FilterEnum.INGREDIENT.id.toString())
        suggestionRequest.setName(ingredient.name.toString())
        suggestionRequest.setFilterName(FilterEnum.INGREDIENT.desc.toString())
        println "suggestionRequest: id:${suggestionRequest.id} name: ${suggestionRequest.name} filterName: ${suggestionRequest.filterName} "
        String url = urlBuilderService.getUrlBySuggestionRequest(suggestionRequest)
        ArrayList mealList = mealSuggestionService.getMealDataByUrl(url)
println("${mealList.collect()}")
            //ArrayList<MealSuggestion>mealSuggestionList = mealSuggestionService.getMealSuggestions(url)
        return [ingredient:ingredient, suggestionUrl:url]
    }


    def create() {
        respond new Ingredient(params)
    }

    def save(Ingredient ingredient) {
        if (ingredient == null) {
            notFound()
            return
        }

        try {
            Config config = grailsApplication.config
            ingredient.lastUpdated = new Date().toTimestamp()
            ingredient.version = config.getProperty('info.app.version',  "0.1")
            ingredientService.save(ingredient)
        } catch (ValidationException e) {
            respond ingredient.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: ingredient.label, default: 'Ingredient'), ingredient.id])
                redirect ingredient
            }
            '*' { respond ingredient, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond ingredientService.get(id)
    }

    def update(Ingredient ingredient) {
        if (ingredient == null) {
            notFound()
            return
        }

        try {
            ingredientService.save(ingredient)
        } catch (ValidationException e) {
            respond ingredient.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ingredient.label', default: 'Ingredient'), ingredient.id])
                redirect ingredient
            }
            '*'{ respond ingredient, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        ingredientService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ingredient.label', default: 'Ingredient'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'ingredient.label', default: 'Ingredient'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
