package mymeals
import grails.converters.JSON
import grails.gorm.PagedResultList

import java.text.SimpleDateFormat
import grails.gorm.transactions.Transactional


class IngredientService {

    SuggestionRequest suggestionRequest


    //index : list all data of object from domain Object
    //return a PagedResultList
    @Transactional(readOnly = true)
    def index(params) {
        def results = list(params)
        //PagedResultList<Ingredient>results = Ingredient.list(max: 5, offset: 0, sort: "name", order: "asc")
        return results
    }

/**
    Returns a sortable Paged Result list
   Params:
    max - The maximum number to list
    offset - The offset from the first result to list from
    order - How to order the list, either "desc" or "asc"
    sort - The property name to sort by
    ignoreCase - Whether to ignore the case when sorting. Default is true.
    fetch - The fetch policy for the object’s associations as a Map
    readOnly - true if returned objects should not be automatically dirty-checked (simlar to read())
    fetchSize - number of rows fetched by the underlying JDBC driver per round trip
    flushMode - Hibernate FlushMode override, defaults to FlushMode.AUTO
    timeout - query timeout in seconds
**/
    @Transactional(readOnly = true)
    def list(params){
        def count = Ingredient.count() ?:0
        def max = params.max ?: 10
        def offset = params.offset ?: 0
        String sort = params.sort ?: "name"
        String order = params.order ?: "asc"
        String ignoreCase= params.ignoreCase ?: true
        ArrayList<Ingredient> ingredients = Ingredient.listOrderByName(max: max, offset: offset, order: order, count:count, ignoreCase:ignoreCase)
        return ingredients
    }
/**
    def getPaginatedList(list, max, offset) {
        max = Math.min(max ?: 5, 100)
        offset = offset?:0
        int total = list.size()
        int upperLimit = (offset+max (greaterThanEqualto) total?total:offset+max)-1
        return offset (lessThan) total ? list.getAt(offset..upperLimit) : []
    }
**/
    //show : get data of object from domain Object based on id
    def show(params) {
        Ingredient ingredient = Ingredient.get(params.id as Long)
        return ingredient
    }


    // The number of elements in the ingredient domain
    def count (){
        return Ingredient.count() ?:0
    }

    //create
    @Transactional
    def save(params){
       /// def objectJSON = request.JSON
        def ingredient = new Ingredient(params)
       // ingredient.properties = objectJSON
        ingredient.properties = params
        ingredient.save(flush: true)

        //render ingredient as JSON
    }

    //update base on Id
    def update(params) {
        //def objectJSON = request.JSON
        def ingredient = Ingredient.get(params.id as Long)
        //ingredient.properties = objectJSON
        ingredient.save(flush: true)
       // render ingredient as JSON
    }

    //
    @Transactional
    def  delete(params){
        def ingredient = Ingredient.get(params.id as Long)
        ingredient.delete(flush: true)
       // render domainName as JSON
    }

}
