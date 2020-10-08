function run() {
  const wrapper = document.querySelector(".make-post-wrapper");
  if (!wrapper) return;
  const button = wrapper.querySelector(".add-icon");
  if (!button) return;

  button.onclick = (e) => {
    e.stopPropagation();

    wrapper.classList.toggle("make-post-wrapper_hidden");
    button.innerHTML = wrapper.classList.contains("make-post-wrapper_hidden")
      ? "+"
      : "x";
  };
}

run();
