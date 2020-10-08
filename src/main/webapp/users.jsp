<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<% 
  String guestName = (String)session.getAttribute("guestName"); 
  String username = (String)session.getAttribute("username");
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>${guestName}</title>
    <link rel="stylesheet" href="./static/css/main.css" />
    <script type="module" src="./static/js/app.js" defer></script>
  </head>
  <body>
    <div id="app">
      <jsp:include page="./components/header.jsp" flush="true" />
      <jsp:include page="./components/navigation.jsp" flush="true" />
      <main class="main">
        <div class="posts">
          <c:forEach var="post" items="${posts}">
            <article class="post elevation-1 card">
              <header class="post__header">
                <p class="post__header-user">
                  ${post.user.firstName} ${post.user.lastName}
                </p>
                <p class="post__header-time">${post.creationDate}</p>
              </header>
              <p class="post__text">${post.text}</p>
              <div class="comments">
                <c:forEach var="comment" items="${post.comments}">
                  <div class="comment">
                    <hr class="hr" />
                    <header class="comment__header">
                      <p class="comment__header-user">
                        ${comment.user.firstName} ${comment.user.lastName}
                      </p>
                      <p class="comment__header-time">
                        ${comment.creationDate}
                      </p>
                    </header>
                    <form
                      action="delete-comment"
                      method="POST"
                      class="comment__text-wrapper"
                    >
                      <p class="comment__text">${comment.text}</p>
                      <c:if test="${comment.user.username == username}">
                        <button class="icon remove-icon" type="submit">
                          x
                        </button>
                        <input
                          type="hidden"
                          name="comment-id"
                          value="${comment.id}"
                        />
                      </c:if>
                    </form>
                  </div>
                </c:forEach>
              </div>
              <form
                action="create-comment"
                method="POST"
                class="add-comment-wrapper"
              >
                <input
                  type="text"
                  class="input"
                  placeholder="Your comment"
                  name="text"
                  maxlength="200"
                />
                <input type="hidden" name="post-id" value="${post.id}" />
                <button class="button">Add</button>
              </form>
            </article>
          </c:forEach>
        </div>
      </main>
    </div>
  </body>
</html>
