package grails3_app

class ProjectController {

    def index = {
        render "This is index page"
    }

    def current = {

        // Get data from list table using List model.
        def projectName = Project.list();
        def dueDate = "3/3/2017"

        // Data set to the view page
        [projects:projectName, date:dueDate]
    }
}
