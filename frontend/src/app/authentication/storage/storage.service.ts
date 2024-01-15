import { Injectable } from '@angular/core';


const USER = "c_user";
const TOKEN = "c_token";

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  constructor() { }

  public saveUser(user: any) {
    window.localStorage.removeItem(USER);
    window.localStorage.setItem(USER, JSON.stringify(user));
  }

  saveToken(token: string) {
    window.localStorage.removeItem(TOKEN);
    window.localStorage.setItem(TOKEN, token);
  }

  static getToken() {
    if (window != null) {
      return window.localStorage.getItem(TOKEN);
    }
    return null;
  }

  static isUserLoggedIn(): boolean {
    if (this.getToken() == null) {
      return false;
    }
    return true;
  }

  static logout(): any {
    // localStorage.removeItem('c_user');
    // localStorage.removeItem('c_token');
    localStorage.clear();
  }
}
