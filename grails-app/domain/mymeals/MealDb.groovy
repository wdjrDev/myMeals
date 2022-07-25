package mymeals

class MealDb {
    Integer id
    Integer idMealDb
    String  mealName
    String  drinkAlternative
    String  category
    String  locale
    String  instructions
    String  mealThumb
    String  tags
    String  youtube
    String  ingredient_1
    String  ingredient_2
    String  ingredient_3
    String  ingredient_4
    String  ingredient_5
    String  ingredient_6
    String  ingredient_7
    String  ingredient_8
    String  ingredient_9
    String  ingredient_10
    String  ingredient_11
    String  ingredient_12
    String  ingredient_13
    String  ingredient_14
    String  ingredient_15
    String  ingredient_16
    String  ingredient_17
    String  ingredient_18
    String  ingredient_19
    String  ingredient_20
    String  measure_1
    String  measure_2
    String  measure_3
    String  measure_4
    String  measure_5
    String  measure_6
    String  measure_7
    String  measure_8
    String  measure_9
    String  measure_10
    String  measure_11
    String  measure_12
    String  measure_13
    String  measure_14
    String  measure_15
    String  measure_16
    String  measure_17
    String  measure_18
    String  measure_19
    String  measure_20
    String  menuSource
    String  imageSource
    Boolean creativeCommonsConfirmed
    String  version
    Date    dateCreated
    Date    lastUpdated


    static constraints = {
        id(nullable:false, unique: true, autoincrement:1)
        idMealDb(nullable:false, unique: true)
        mealName(nullable:false, size:5..30)
        drinkAlternative(maxSize:30)
        category(nullable:false, size:3..30)
        locale(nullable:false, size:3..30)
        instructions(nullable:false, maxSize: 2500)
        mealThumb(maxSize:100)
        tags(maxSize:100)
        youtube(maxSize: 100)
        ingredient_1(nullable:false,size:3..30)
        ingredient_2(maxSize:30)
        ingredient_3(maxSize:30)
        ingredient_4(maxSize:30)
        ingredient_5(maxSize:30)
        ingredient_6(maxSize:30)
        ingredient_7(maxSize:30)
        ingredient_8(maxSize:30)
        ingredient_9(maxSize:30)
        ingredient_10(maxSize:30)
        ingredient_11(maxSize:30)
        ingredient_12(maxSize:30)
        ingredient_13(maxSize:30)
        ingredient_14(maxSize:30)
        ingredient_15(maxSize:30)
        ingredient_16(maxSize:30)
        ingredient_17(maxSize:30)
        ingredient_18(maxSize:30)
        ingredient_19(maxSize:30)
        ingredient_20(maxSize:30)
        measure_1(maxSize:30)
        measure_2(maxSize:30)
        measure_3(maxSize:30)
        measure_4(maxSize:30)
        measure_5(maxSize:30)
        measure_6(maxSize:30)
        measure_7(maxSize:30)
        measure_8(maxSize:30)
        measure_9(maxSize:30)
        measure_10(maxSize:30)
        measure_11(maxSize:30)
        measure_12(maxSize:30)
        measure_13(maxSize:30)
        measure_14(maxSize:30)
        measure_15(maxSize:30)
        measure_16(maxSize:30)
        measure_17(maxSize:30)
        measure_18(maxSize:30)
        measure_19(maxSize:30)
        measure_20(maxSize:30)
        menuSource(maxSize:100)
        imageSource(maxSize:100)
        creativeCommonsConfirmed(nullable:false, default:false)
        version(nullable:false, size:1..5)
        dateCreated(nullable:false, default: new Date().toTimestamp())
        lastUpdated(nullable:false, default: new Date().toTimestamp())
    }
}
