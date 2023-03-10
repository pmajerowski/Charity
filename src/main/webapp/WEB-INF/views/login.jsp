<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
    <%--HEADER--%>
    <jsp:include page="header.jsp"/>
    <body>
        <header>
            <nav class="container container--70">
                <ul class="nav--actions">
                    <li><a href="/login">Zaloguj</a></li>
                    <li class="highlighted"><a href="#">Załóż konto</a></li>
                </ul>
                <ul>
                    <li><a href="index.html" class="btn btn--without-border active">Start</a></li>
                    <li><a href="index.html#steps" class="btn btn--without-border">O co chodzi?</a></li>
                    <li><a href="index.html#about-us" class="btn btn--without-border">O nas</a></li>
                    <li><a href="index.html#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
                    <li><a href="index.html#contact" class="btn btn--without-border">Kontakt</a></li>
                </ul>
            </nav>
        </header>

        <section class="login-page">
            <h2>Zaloguj się</h2>

            <c:url value="/login" var="loginUrl"/>
            <form action="${loginUrl}" method="post">
                <c:if test="${param.error != null}">
                    <p class="ui-state-error-text">
                        Invalid username and password.
                    </p>
                </c:if>
                <c:if test="${param.logout != null}">
                    <p class="ui-state-error">
                        You have been logged out.
                    </p>
                </c:if>
                <div class="form-group">
                    <input type="text" id="username" name="username" placeholder="Email"/>
                </div>
                <div class="form-group">
                    <input type="password" id="password" name="password" placeholder="Password"/>
                </div>
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
                <div class="form-group form-group--buttons">
                    <a href="login.html" class="btn">Zaloguj się</a>
                    <button class="btn btn--without-border" type="submit">Załóż konto</button>
                </div>
            </form>
        </section>
        <%--FOOTER--%>
        <jsp:include page="footer.jsp"/>
    </body>
</html>