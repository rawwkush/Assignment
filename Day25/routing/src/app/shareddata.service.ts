import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ShareddataService {

  email: string = "none"
  constructor() { }

  getEmail() {
    return this.email;
  }
  setEmail(email: string) {
    this.email = email;
  }
}
