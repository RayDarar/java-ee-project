<%
  String message = pageContext.getException().getMessage();
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <h1>400</h1>

    <p>Exception: <%= message %></p>
    <button onclick="history.back()">Back</button>
  </body>
</html>
