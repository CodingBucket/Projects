<!DOCTYPE html>
<html>

    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>

    <body>

        <a href="#create-user" class="skip" tabindex="-1">
            <g:message code="default.link.skip.label" default="Skip to content&hellip;"/>
        </a>

        <div class="nav" role="navigation">
            <ul>

            </ul>
        </div>

        <div id="create-user" class="content scaffold-create" role="main">


            <g:form controller="user" action="save">

                <label>User Name: </label>
                <g:textField name="userName"/><br/>

                <label>Password: </label>
                <g:textField name="password" type="password"/><br/>

                <g:actionSubmit value="Submit"/>

            </g:form>

        </div>

    </body>
</html>
