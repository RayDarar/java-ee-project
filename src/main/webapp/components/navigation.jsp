<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
  String username = (String)session.getAttribute("username");
%>
<nav class="nav">
  <div class="actions elevation-2 card">
    <button class="button action" data-action="goHome">My Blog</button>
    <button class="button action" data-action="logout">Logout</button>
  </div>
  <div class="users elevation-2 card">
    <h3 class="users__title">Users on site:</h3>
    <c:forEach var="user" items="${users}">
      <c:if test="${user.username != username}">
        <form action="users" method="GET" class="user">
          <input type="hidden" name="guest-name" value="${user.username}">
          <button class="button button_text" type="submit">${user.firstName} ${user.lastName}</button>
        </form>
      </c:if>
    </c:forEach>
  </div>
</nav>