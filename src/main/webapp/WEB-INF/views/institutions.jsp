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
<header class="header--main-page--admin">
    <nav class="container container--70">
        <ul class="nav--actions">
            <sec:authorize access="!isAuthenticated()">
                <li><a href="/login" class="btn btn--small">Zaloguj</a></li>
                <li><a href="/register" class="btn btn--small">Załóż konto</a></li>
            </sec:authorize>
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
            <li><a href="/admin/institutions" class="btn btn--without-border">Instytucje</a></li>
            <li><a href="#" class="btn btn--without-border">Administratorzy</a></li>
            <li><a href="#" class="btn btn--without-border">Użytkownicy</a></li>

        </ul>
    </nav>
    <section>
        <h2>Zarządzaj instytucjami</h2>
        <table class="container-table">
            <thead>
                <tr>
                    <td>
                        <a href="/admin/institutions/add" class="btn">Dodaj instytucję</a>
                    </td>
                </tr>
            </thead>

            <c:forEach items="${institutions}" var="inst">

                    <tr>
                        <td>
                            <div class="title">${inst.name}</div>
                            <div class="subtitle">${inst.description}</div>
                        </td>
                        <td>
                            <a class="btn--small btn--highlighted" href="admin/institution/${inst.id}">Szczegóły</a>
                            <a class="btn--small btn--highlighted" href="#">Edytuj</a>
                            <a class="btn--small btn--highlighted" href="#">Usuń</a>
                        </td>
                    </tr>

            </c:forEach>

        </table>
    </section>
</header>

</body>


<%--FOOTER--%>
<jsp:include page="footer.jsp"/>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>