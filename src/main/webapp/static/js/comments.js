import { RouterService } from "./services/router.service.js";

function run() {
  const commentForms = document.querySelectorAll(".add-comment-wrapper");
  if (!commentForms) return;

  for (const commentForm of commentForms) {
    commentForm.onsubmit = (e) => {
      const postId = document.querySelector('input[name="post-id"]');

      postId.value = +e.target.parentNode.dataset.id;
    };
  }

  const comments = document.querySelectorAll(".comment");
  if (!comments) return;

  for (const comment of comments) {
    const button = comment.querySelector(".remove-icon");
    if (!button) continue;

    button.onclick = async () => {
      const body = new FormData();
      body.append("comment-id", +comment.dataset.id);
      await fetch("/comments", {
        method: "DELETE",
        body,
      });

      RouterService.reload();
    };
  }
}

run();
