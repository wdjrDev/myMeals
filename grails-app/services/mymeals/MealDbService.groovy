package mymeals

import grails.gorm.services.Service

@Service(MealDb)
interface MealDbService {

    MealDb get(Serializable id)

    List<MealDb> list(Map args)

    Long count()

    void delete(Serializable id)

    MealDb save(MealDb mealDb)

}