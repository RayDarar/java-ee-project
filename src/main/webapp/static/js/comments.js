function run() {
  const commentForms = document.querySelectorAll(".add-comment-wrapper");
  if (!commentForms) return;

  for (const commentForm of commentForms) {
    commentForm.onsubmit = (e) => {
      const postId = document.querySelector('input[name="post-id"]');

      postId.value = +e.target.parentNode.dataset.id;
    };
  }
}

run();
