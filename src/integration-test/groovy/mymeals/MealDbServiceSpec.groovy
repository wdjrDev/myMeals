package mymeals

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MealDbServiceSpec extends Specification {

    MealDbService mealDbService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new MealDb(...).save(flush: true, failOnError: true)
        //new MealDb(...).save(flush: true, failOnError: true)
        //MealDb mealDb = new MealDb(...).save(flush: true, failOnError: true)
        //new MealDb(...).save(flush: true, failOnError: true)
        //new MealDb(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //mealDb.id
    }

    void "test get"() {
        setupData()

        expect:
        mealDbService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<MealDb> mealDbList = mealDbService.list(max: 2, offset: 2)

        then:
        mealDbList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        mealDbService.count() == 5
    }

    void "test delete"() {
        Long mealDbId = setupData()

        expect:
        mealDbService.count() == 5

        when:
        mealDbService.delete(mealDbId)
        sessionFactory.currentSession.flush()

        then:
        mealDbService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        MealDb mealDb = new MealDb()
        mealDbService.save(mealDb)

        then:
        mealDb.id != null
    }
}
