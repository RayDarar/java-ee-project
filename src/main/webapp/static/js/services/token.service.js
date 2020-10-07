export class TokenService {
  static checkToken() {
    const token = TokenService.getToken();

    if (!token) return false;
    return true;
  }

  static getToken() {
    return localStorage.getItem("token");
  }
}
