<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Sign In</title>
    <link rel="stylesheet" href="../static/css/main.css" />
    <script type="module" src="../static/js/app.js" defer></script>
  </head>
  <body>
    <div id="app">
      <jsp:include page="../components/header.jsp" />
      <jsp:include page="../components/navigation.jsp" />
      <main class="main">
        <form class="sign-in elevation-1 card" action="/sign-in" method="POST">
          <c:if test="${result == true}">
            <p class="error-message">Неверный логин или пароль, попробуйте заново</p>
          </c:if>
          <input
            type="text"
            name="username"
            placeholder="Username"
            class="input"
          />
          <input
            type="password"
            name="password"
            placeholder="Password"
            class="input"
          />
          <button class="button" type="submit">Sign-In</button>
          <a class="button button_text" href="sign-up">Go to Sign-Up</a>
        </form>
      </main>
    </div>
  </body>
</html>
