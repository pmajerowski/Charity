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
        <form:form action="" method="post" modelAttribute="appUser">
            <div class="form-group">
                <input type="email" name="email" placeholder="Email" />
            </div>
            <div class="form-group">
                <input type="password" name="password" placeholder="Hasło" />
                <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
            </div>

            <div class="form-group form-group--buttons">
                <button class="btn" type="submit">Zaloguj się</button>
                <a href="/register" class="btn btn--without-border">Załóż konto</a>
            </div>
        </form:form>
    </section>


    <%--FOOTER--%>
    <jsp:include page="footer.jsp"/>

    </body>
</html>

