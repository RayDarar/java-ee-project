import { TokenService } from "./services/token.service.js";
import { RouterService } from "./services/router.service.js";

function main() {
  const tokenResult = TokenService.checkToken();
  // check token
  if (!tokenResult && !RouterService.onEnterPage) {
    // got to sign-in
    RouterService.push("/sign-in");
  } else if (tokenResult && RouterService.onEnterPage) {
    RouterService.push("/");
  }
}

main();
