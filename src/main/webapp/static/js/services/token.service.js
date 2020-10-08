export class TokenService {
  static async checkToken() {
    try {
      const result = await fetch("/session");
      return result.status == 200;
    } catch (error) {
      return false;
    }
  }
}
