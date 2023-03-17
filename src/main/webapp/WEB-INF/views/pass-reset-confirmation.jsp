<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pl">

<%--HEADER--%>
<jsp:include page="header.jsp" />
<body>
<header class="header--form-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="/login" class="btn btn--small">Zaloguj</a></li>
            <li><a href="/register" class="btn btn--small">Załóż konto</a></li>
        </ul>
        <ul>
            <li><a href="/" class="btn btn--without-border active">Start</a></li>
            <li><a href="index.html#steps" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="index.html#about-us" class="btn btn--without-border">O nas</a></li>
            <li><a href="index.html#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="index.html#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>

    <div class="slogan container container--90">
        <h2>
            Aby zresetować hasło użyj linku z wiadomości email.
        </h2>
    </div>
</header>

<%--FOOTER--%>
<jsp:include page="footer.jsp"/>

<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>