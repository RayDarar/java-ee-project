<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home Page</title>
    <link rel="stylesheet" href="./static/css/main.css" />
    <script type="module" src="./static/js/app.js" defer></script>
  </head>
  <body>
    <div id="app">
      <jsp:include page="./components/header.jsp" />
      <jsp:include page="./components/navigation.jsp" />
      <main class="main"></main>
    </div>
  </body>
</html>
