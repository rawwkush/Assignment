import { Component, OnInit } from '@angular/core';
import { ShareddataService } from '../shareddata.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email: string = "";

  constructor(private emailData: ShareddataService) { }

  ngOnInit(): void {
  }

  saveEmail() {
    //this.email = this.emailData.getEmail();
    this.emailData.setEmail(this.email);
    alert("logged in");
  }

}
