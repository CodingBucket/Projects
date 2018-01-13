package grails3_app

class User {

    String userName
    String password
    String fullName

    static constraints = {
        userName blank: false, unique: true
        password blank:false, password: true
        fullName blank:false
    }
}
