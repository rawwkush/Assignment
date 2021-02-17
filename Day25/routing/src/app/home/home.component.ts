import { Component, OnInit } from '@angular/core';
import { ShareddataService } from '../shareddata.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  email: string = "none";
  constructor(private emailData: ShareddataService) { }

  ngOnInit(): void {
    this.email = this.emailData.getEmail();
  }

}
