import { Component, OnInit } from '@angular/core';
import { ConfigService,UserData } from '../config.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor( public configService: ConfigService ) { }

  public username: string;
  public password: string;
  public resData: UserData;

  ngOnInit() {

  }

  getCredentials() {
    console.log(this.username);
    console.log(this.password);
    return this.configService.getUser().subscribe(
      res => {
        this.resData = res
        console.log(this.resData);
      }
    );
  } 
}

