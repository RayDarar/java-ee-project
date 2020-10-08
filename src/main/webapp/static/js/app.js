import { TokenService } from "./services/token.service.js";
import { RouterService } from "./services/router.service.js";
import "./actions.js";
import "./posts.js";
import "./comments.js";

async function main() {
  const result = await TokenService.checkToken();
  if (result && RouterService.onEnterPage) {
    RouterService.push("/home");
  } else if (!result && !RouterService.onEnterPage) {
    RouterService.push("/sign-in");
  }
}

main();
