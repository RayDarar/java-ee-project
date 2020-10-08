export class RouterService {
  static get url() {
    return location.pathname;
  }

  static get onEnterPage() {
    return RouterService.url.includes("sign-");
  }
  static get onIndexPage() {
    return RouterService.url == "/";
  }

  static push(url) {
    location.href = url;
  }

  static reload() {
    location.reload();
  }
}
