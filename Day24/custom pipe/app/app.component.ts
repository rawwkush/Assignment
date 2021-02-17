import { Component } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title: string = 'Here is interpolations';
  cities: string[] = ["city", "delhi", "earth", "mars"];
  islogin: boolean = true;
}
