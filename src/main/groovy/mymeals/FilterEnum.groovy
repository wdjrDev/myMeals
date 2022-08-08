package mymeals


/**
 * All SuggestionFilter objects refer to MealSuggestion Objects and are transient objects for a user to pick from to get
 * a mealDb object which can be persisted once the user picks a specific MealSuggestion
 */

    enum FilterEnum {
        INGREDIENT('i', 'MainIngredient'),
        AREA('a', 'Locale'),
        CATEGORY('c', 'MealCategory'),
        RANDOM('r', 'RandomMeal')

        final String id
        final String desc
        static final Map map

        static {
            map = [:] as TreeMap
            values().each {filter ->
                map.put(filter.id, filter)
            }

        }

        private FilterEnum(String id, String desc) {
            this.id = id
            this.desc = desc
        }

        static getFilterEnum(id) {
            map[id]
        }
    }




