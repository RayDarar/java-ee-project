const wrapper = document.querySelector(".make-post-wrapper");
const button = wrapper.querySelector(".add-icon");

button.onclick = (e) => {
  e.stopPropagation();

  wrapper.classList.toggle("make-post-wrapper_hidden");
  button.innerHTML = wrapper.classList.contains("make-post-wrapper_hidden") ? "+" : "x";
};
