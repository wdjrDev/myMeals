<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'ingredient.label', default: 'Ingredient')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-ingredient" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="edit-ingredient" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.ingredient}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.ingredient}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.ingredient}" method="PUT">
                <g:hiddenField name="version" value="${this.ingredient?.version}" />
                <fieldset class="form">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-1">
                                <div class='fieldcontain required'>
                                    <div>Name</div>
                                    <span class='required-indicator'>*</span>
                                    <g:textField name="name" value="${this.ingredient?.name}" />
                                </div>
                            </div>
                            <div class="col-lg-auto">
                                <div class='fieldcontain required'>
                                    <h2>Description</h2>
                                    <span class='required-indicator'>*</span>
                                    <g:textArea name="description" @class = "form-control" value="${this.ingredient?.description}" rows="5" cols="160" />
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <f:all bean="ingredient"/>
                        </div>
                    </div>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
