import { TokenService } from "./services/token.service.js";
import { RouterService } from "./services/router.service.js";

const actions = {
  async logout() {
    await TokenService.logout();
    RouterService.push("/sign-in");
  },
  goHome() {
    RouterService.push("/home");
  },
};

const buttons = document.querySelectorAll(".button.action");

for (const button of buttons) {
  button.onclick = actions[button.dataset.action];
}
