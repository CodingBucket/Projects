package grails3_app

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserController {

    //static scaffold = User

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def login = {}

    def authentication = {
        def user = User.findUserNameAndPassword(params.userName, params.password)
        if(user){
            session.user = user
            flash.message = "Hellow ${user.userName}"
            redirect(action:"login")
        } else {
            flash.message = "Sorry user does not exist"
            redirect(action:"login")
        }
    }

    def logout = {
        flash.message = "Goodby ${session.user.userName}"
        session.user = null
        redirect(action:"login")
    }

    @Transactional
    def save() {
        def user = new User(params)
        user.save()
        render "Success!"
    }

    def current = {
        render "This is index page"
    }

}
