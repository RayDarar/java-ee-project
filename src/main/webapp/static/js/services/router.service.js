export class RouterService {
  static get url() {
    return location.pathname;
  }

  static get onEnterPage() {
    return RouterService.url.includes("sign-");
  }

  static push(url) {
    location.href = url;
  }
}