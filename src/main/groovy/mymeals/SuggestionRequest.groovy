package mymeals

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString


@EqualsAndHashCode(includes=['id','name','filterName'])
@ToString(includeNames=true)
@CompileStatic
class SuggestionRequest {
    /*
    The data object Object id
     */
    String id
    /*
    The name to be filtered on
     */
    String name
    /*
    The FilterEnum description
     */
    String filterName
}
