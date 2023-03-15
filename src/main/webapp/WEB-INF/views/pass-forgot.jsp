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
                <li class="highlighted"><a href="/register">Załóż konto</a></li>
            </ul>
            <ul>
                <li><a href="/" class="btn btn--without-border active">Start</a></li>
                <li><a href="index.html#steps" class="btn btn--without-border">O co chodzi?</a></li>
                <li><a href="index.html#about-us" class="btn btn--without-border">O nas</a></li>
                <li><a href="index.html#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
                <li><a href="index.html#contact" class="btn btn--without-border">Kontakt</a></li>
            </ul>
        </nav>
    </header>
    <section class="login-page">
        <h2>Podaj adres email, do którego przypisane jest konto. </h2>

        <form action="/pass_forgot/email" method="get">
            <c:if test="${no_email != null}">
                <div class="error form-group">
                    ${no_email}
                </div>
            </c:if>
            <c:if test="${param.error == 'token_expired'}">
                <div class="error form-group">
                        Link wygasł. Podaj email, aby wysłać ponownie.
                </div>
            </c:if>
            <c:if test="${param.error == 'error'}">
                <div class="error form-group">
                    Coś poszło nie tak, spróbuj ponownie.
                </div>
            </c:if>

            <h3>Na podany adres wyślemy link, dzięki któremu nadasz nowe hasło. </h3>
            <div class="form-group">
                <input type="email" name="email" placeholder="Email">
            </div>

            <div class="form-group">
                <button type="submit" class="btn">Wyślij</button>
            </div>
        </form>

    </section>


<%--FOOTER--%>
<jsp:include page="footer.jsp"/>
</body>
</html>