package grails3_app

class Book {

    String name
    String description

    static constraints = {
        name blank: false, unique: true
    }
}
