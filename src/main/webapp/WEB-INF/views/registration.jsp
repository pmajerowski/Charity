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
        <h2>Załóż konto</h2>

        <c:if test="${not empty userDTO.error}">
            <div class="error form-group">${userDTO.error}</div>
        </c:if>
        <form:form action="/register" method="post" modelAttribute="userDTO">
            <div class="form-group">
                <input type="text" name="firstName" placeholder="Imię" minlength="2" maxlength="40" required/>
            </div>
            <div class="form-group">
                <input type="text" name="lastName" placeholder="Nazwisko" minlength="2" maxlength="40" required/>
            </div>
            <div class="form-group">
                <input type="email" name="username" placeholder="Email" required/>
            </div>
            <div class="form-group">
                <input type="password" id="pass" name="password" placeholder="Hasło" required/>
            </div>
            <div class="form-group">
                <input type="password" id="pass2" name="password2" placeholder="Powtórz hasło" />
                <span id="pass-check" style="font-size: large; color: #d65132" hidden="hidden">Podane hasła są różne</span>
            </div>

            <div class="form-group form-group--buttons">
                <button class="btn" id="register_btn" type="submit">Załóż konto</button>
            </div>
        </form:form>
    </section>

    <%--FOOTER--%>
    <jsp:include page="footer.jsp"/>
    <script src="<c:url value="resources/js/register.js"/>"></script>

    </body>
</html>
