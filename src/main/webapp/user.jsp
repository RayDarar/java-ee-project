<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <ul>
      <c:forEach var="user" items="${users}">
        <li>${user.id} || ${user.name}</li>
      </c:forEach>
    </ul>
  </body>
</html>
