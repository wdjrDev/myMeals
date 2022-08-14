<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'ingredient.label', default: 'Ingredient')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-ingredient" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="show-ingredient" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
        </div>
        <div class="container" >
            <div class="row">
                <div class="col-sm-3">
                    <div>${this.ingredient.name}</div>
                    <img alt="${this.ingredient.name}" src="https://www.themealdb.com/images/ingredients/${this.ingredient.name}.png" width="200" height="200"/>
                    <div>Type: ${this.ingredient.type}</div>
                </div>
                <g:if test="${mealSuggestions}">
                    <g:each status="i" var="mealSuggestion" in="${mealSuggestions}">
                        <div class="col-sm-3">
                                <g:if test="${(i % 2) == 1}">
                                    <br>
                                        <a href="https://www.themealdb.com/api/json/v1/1/lookup.php?i=${mealSuggestion.idMeal}">
                                            <div>${mealSuggestion.strMeal}</div>
                                            <img alt="${mealSuggestion.strMeal}" src="${mealSuggestion.strMealThumb}" width="200" height="200"/>
                                        </a>
                                    </br>
                                </g:if>
                        </div>
                        <div class="col-sm-3">
                                <g:if test="${(i % 2) == 0}">
                                    <br>
                                        <a href="https://www.themealdb.com/api/json/v1/1/lookup.php?i=${mealSuggestion.idMeal}">
                                            <div>${mealSuggestion.strMeal}</div>
                                            <img alt="${mealSuggestion.strMeal}" src="${mealSuggestion.strMealThumb}" width="200" height="200"/>
                                        </a>
                                    </br>
                                </g:if>
                        </div>
                    </g:each>
                </g:if>
                <div class="col-sm-auto">
                </div>
            </div>
        </div>
        <div>
            <g:form resource="${this.ingredient}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.ingredient}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>

    </body>
</html>
