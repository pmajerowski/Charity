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
                    <li><a href="/login" class="btn btn--small">Zaloguj</a></li>
                    <li><a href="/register" class="btn btn--small">Załóż konto</a></li>
                </ul>
                <ul>
                    <li><a href="/" class="btn btn--without-border">Start</a></li>
                    <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
                    <li><a href="#" class="btn btn--without-border">O nas</a></li>
                    <li><a href="#" class="btn btn--without-border">Fundacje i organizacje</a></li>
                    <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
                </ul>
            </nav>
        </header>

        <section class="login-page">
            <h2>Zaloguj się</h2>

            <form action="/login" method="post">
                <c:if test="${param.error != null}">
                    <div class="error form-group">
                        Błędny email lub hasło
                    </div>
                </c:if>

                <div class="form-group">
                    <input type="text" id="username" name="username" placeholder="Email"/>
                </div>
                <div class="form-group">
                    <input type="password" id="password" name="password" placeholder="Hasło"/>
                </div>
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
                <div class="form-group form-group--buttons">
                    <button class="btn" type="submit">Zaloguj się</button>
                    <a href="/pass_forgot" class="btn btn--without-border">Zapomniałæm hasła</a>
                </div>
            </form>
        </section>
        <%--FOOTER--%>
        <jsp:include page="footer.jsp"/>
    </body>
</html>