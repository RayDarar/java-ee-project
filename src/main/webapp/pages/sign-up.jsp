<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Sign Up</title>
    <link rel="stylesheet" href="../static/css/main.css" />
    <script type="module" src="../static/js/app.js" defer></script>
  </head>
  <body>
    <div id="app">
      <jsp:include page="../components/header.jsp" />
      <jsp:include page="../components/navigation.jsp" />
      <main class="main">
        <form class="sign-in elevation-1 card" action="sign-up" method="POST">
          <c:choose>
            <c:when test="${result.equals('bad-fields')}">
              <p class="error-message">Please, fill every field</p>
            </c:when>
            <c:when test="${result.equals('user-exists')}">
              <p class="error-message">Given username already exists in the system</p>
            </c:when>
          </c:choose>
          <input
            type="text"
            name="username"
            placeholder="Username"
            class="input"
            required
          />
          <input
            type="password"
            name="password"
            placeholder="Password"
            class="input"
            required
          />
          <input
            type="text"
            name="firstName"
            placeholder="First Name"
            class="input"
            required
          />
          <input
            type="text"
            name="lastName"
            placeholder="Last Name"
            class="input"
            required
          />
          <button class="button" type="submit">Sign-Up</button>
          <a class="button button_text" href="sign-in">Go to Sign-In</a>
        </form>
      </main>
    </div>
  </body>
</html>
