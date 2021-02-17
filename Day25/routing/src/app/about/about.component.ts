import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ShareddataService } from '../shareddata.service';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  data: any = "none";
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.data = this.http.get("https://jsonplaceholder.typicode.com/users");
  }

}
