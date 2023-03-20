<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">

<%--HEADER--%>
<jsp:include page="header.jsp" />

<body>
<header>
    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="/login" class="btn btn--small">Zaloguj</a></li>
            <li><a href="/register" class="btn btn--small">Załóż konto</a></li>
        </ul>

        <ul>
            <li><a href="/" class="btn btn--without-border active">Start</a></li>
            <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="#" class="btn btn--without-border">O nas</a></li>
            <li><a href="#" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>
</header>

<section class="login-page">
    <h2>Wprowadź nowe hasło</h2>

    <form:form id="form" action="/pass-reset-form" method="post" modelAttribute="appUser">
        <div class="form-group">

            <input type="password"
                   id="pass"
                   name="password"
                   placeholder="Nowe Hasło"
                   required/>
            <br>
            <span id="message" style="display: none; margin-top: 10px">
                    Hasło powinno mieć długość przynajmniej 8 znaków,<br> posiadać małe i duże litery, cyfrę i znak specjalny
                </span>
        </div>
        <div class="form-group">
            <input type="password" id="pass2" name="password2" placeholder="Powtórz hasło" /><br>
            <span id="pass-check" style="font-size: medium; color: #d65132" hidden="hidden">Podane hasła są różne</span>
        </div>

        <form:hidden path="email"/>
        <form:hidden path="id"/>
        <form:hidden path="firstName"/>
        <form:hidden path="lastName"/>
        <form:hidden path="roles" />
        <form:hidden path="enabled" />

        <div class="form-group form-group--buttons">
            <button class="btn" id="register_btn" type="submit" disabled>Potwierdź</button>
        </div>
    </form:form>

</section>

<%--FOOTER--%>
<jsp:include page="footer.jsp"/>
<script src="<c:url value="/resources/js/register.js"/>"></script>

</body>
</html>
