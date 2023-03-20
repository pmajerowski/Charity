<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="pl">

    <%--HEADER--%>
    <jsp:include page="header.jsp" />
    <body>
    <header class="header--form-page">
        <nav class="container container--70">
            <ul class="nav--actions">
                <sec:authorize access="isAuthenticated()">
                    <li class="logged-user">
                        Witaj ${user.firstName}
                        <ul class="dropdown">
                            <li><a href="#">Profil</a></li>
                            <li><a href="#">Moje zbiórki</a></li>
                            <li><a href="#" id="logout-link">Wyloguj</a></li>

                            <form id="logout-form" action="/logout" method="POST" style="display: none;">
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            </form>
                        </ul>
                    </li>
                </sec:authorize>
            </ul>

            <ul>
                <li><a href="/" class="btn btn--without-border active">Start</a></li>
                <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
                <li><a href="#" class="btn btn--without-border">O nas</a></li>
                <li><a href="#" class="btn btn--without-border">Fundacje i organizacje</a></li>
                <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
            </ul>
        </nav>

        <div class="slogan container container--90">
            <h2>
                Dziękujemy za przesłanie formularza! Wszelkie
                informacje o odbiorze otrzymasz w wiadomości e-mail.
            </h2>
        </div>
    </header>

    <%--FOOTER--%>
    <jsp:include page="footer.jsp"/>

    <script src="<c:url value="resources/js/app.js"/>"></script>
    </body>
</html>