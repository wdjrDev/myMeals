package mymeals

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MealDbController {

    MealDbService mealDbService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond mealDbService.list(params), model:[mealDbCount: mealDbService.count()]
    }

    def show(Long id) {
        respond mealDbService.get(id)
    }

    def create() {
        respond new MealDb(params)
    }

    def save(MealDb mealDb) {
        if (mealDb == null) {
            notFound()
            return
        }

        try {
            mealDbService.save(mealDb)
        } catch (ValidationException e) {
            respond mealDb.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mealDb.label', default: 'MealDb'), mealDb.id])
                redirect mealDb
            }
            '*' { respond mealDb, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond mealDbService.get(id)
    }

    def update(MealDb mealDb) {
        if (mealDb == null) {
            notFound()
            return
        }

        try {
            mealDbService.save(mealDb)
        } catch (ValidationException e) {
            respond mealDb.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'mealDb.label', default: 'MealDb'), mealDb.id])
                redirect mealDb
            }
            '*'{ respond mealDb, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        mealDbService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'mealDb.label', default: 'MealDb'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mealDb.label', default: 'MealDb'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
