package mymeals

import groovy.transform.CompileStatic

@CompileStatic
class UrlBuilderService {

    def getUrlBySuggestionRequest(SuggestionRequest suggestionRequest) {
        println("...building Url based upon suggestion for:${suggestionRequest.filterName}")
        println("and id for:${suggestionRequest.id}")
        println( "and name...${suggestionRequest.name}")
        String url
        String val = suggestionRequest.id
        switch(val){
            case ['i','a','c', 'inList']:
                url ="https://www.themealdb.com/api/json/v1/1/filter.php?${suggestionRequest.id}=${suggestionRequest.name}"
                break;
            default:
                url= "https://www.themealdb.com/api/json/v1/1/random.php"
        }
        return url
    }
}
