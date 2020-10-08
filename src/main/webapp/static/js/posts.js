const wrapper = document.querySelector(".make-post-wrapper");
const button = wrapper.querySelector(".add-icon");

button.onclick = (e) => {
  e.stopPropagation();

  wrapper.classList.toggle("make-post-wrapper_hidden");
  button.innerHTML = wrapper.classList.contains("make-post-wrapper_hidden")
    ? "+"
    : "x";
};

const posts = document.querySelectorAll(".post");

for (const post of posts) {
  const button = post.querySelector(".remove-icon");
  if (!button) continue;

  button.onclick = async () => {
    const body = new FormData();
    body.append("post-id", +post.dataset.id);
    await fetch("/posts", {
      method: "DELETE",
      body,
    });

    RouterService.reload();
  };
}
