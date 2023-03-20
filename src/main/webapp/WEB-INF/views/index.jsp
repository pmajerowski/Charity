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
        <header class="header--main-page">
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
                    <li><a href="/form" class="btn btn--without-border active">Złóż darowiznę</a></li>
                    <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
                    <li><a href="#" class="btn btn--without-border">O nas</a></li>
                    <li><a href="#" class="btn btn--without-border">Fundacje i organizacje</a></li>
                    <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
                </ul>
            </nav>

            <div class="slogan container container--90">
                <div class="slogan--item">
                    <h1>
                        Zacznij pomagać!<br/>
                        Oddaj niechciane rzeczy w zaufane ręce
                    </h1>
                </div>
            </div>
        </header>

        <section class="stats">
            <div class="container container--85">
                <div class="stats--item">
                    <em>${bagsDonated}</em>

                    <h3>Oddanych worków</h3>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius est beatae,
                        quod accusamus illum tempora!</p>
                </div>

                <div class="stats--item">
                    <em>${donationsNumber}</em>
                    <h3>Przekazanych darów</h3>
                    <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Laboriosam magnam,
                        sint nihil cupiditate quas quam.</p>
                </div>

            </div>
        </section>

        <section class="steps">
            <h2>Wystarczą 4 proste kroki</h2>

            <div class="steps--container">
                <div class="steps--item">
                    <span class="icon icon--hands"></span>
                    <h3>Wybierz rzeczy</h3>
                    <p>ubrania, zabawki, sprzęt i inne</p>
                </div>
                <div class="steps--item">
                    <span class="icon icon--arrow"></span>
                    <h3>Spakuj je</h3>
                    <p>skorzystaj z worków na śmieci</p>
                </div>
                <div class="steps--item">
                    <span class="icon icon--glasses"></span>
                    <h3>Zdecyduj komu chcesz pomóc</h3>
                    <p>wybierz zaufane miejsce</p>
                </div>
                <div class="steps--item">
                    <span class="icon icon--courier"></span>
                    <h3>Zamów kuriera</h3>
                    <p>kurier przyjedzie w dogodnym terminie</p>
                </div>
            </div>

            <sec:authorize access="!isAuthenticated()">
                <a href="/register" class="btn btn--large">Załóż konto</a>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <a href="/form" class="btn btn--large">Złóż darowiznę</a>
            </sec:authorize>
        </section>

        <section class="about-us">
            <div class="about-us--text">
                <h2>O nas</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptas vitae animi rem pariatur incidunt libero
                    optio esse quisquam illo omnis.</p>
                <img src="<c:url value="resources/images/signature.svg"/>" class="about-us--text-signature" alt="Signature"/>
            </div>
            <div class="about-us--image"><img src="<c:url value="resources/images/about-us.jpg"/>" alt="People in circle"/>
            </div>
        </section>

        <section class="help">
            <h2>Komu pomagamy?</h2>

            <!-- SLIDE 1 -->
            <div class="help--slides active" data-id="1">
                <p>W naszej bazie znajdziesz listę zweryfikowanych Fundacji, z którymi współpracujemy.
                    Możesz sprawdzić czym się zajmują.</p>

                <ul class="help--slides-items">
                    <c:forEach items="${institutions}" var="institution" varStatus="status">

                            <c:if test="${status.index == 0 || status.index % 2 == 0}">
                                <li>
                            </c:if>

                                <div class="col">
                                    <div class="title">${institution.name}</div>
                                    <div class="subtitle">${institution.description}</div>
                                </div>

                            <c:if test="${status.index > 0 && status.index % 2 == 1}">
                                </li>
                            </c:if>

                    </c:forEach>
                </ul>

            </div>
        </section>

        <%--FOOTER--%>
        <jsp:include page="footer.jsp"/>

    <script src="<c:url value="resources/js/app.js"/>"></script>
    </body>
</html>
