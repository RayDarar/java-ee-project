<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <% String
message = pageContext.getException().getMessage(); %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Error</title>
    <link rel="stylesheet" href="../static/css/main.css" />
  </head>
  <body>
    <div id="app">
      <jsp:include page="../components/header.jsp" />
      <jsp:include page="../components/navigation.jsp" />
      <main class="main handler">
        <h2>400</h2>

        <p>Something went wrong...</p>

        <p>Exception: <%= message %></p>
        <button class="button" onclick="history.back()">Back</button>
      </main>
    </div>
  </body>
</html>
