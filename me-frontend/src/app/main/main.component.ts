import { Component, OnInit } from '@angular/core';
import { ConfigService,UserData } from '../config.service';


@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {

  public resData: UserData;
  public username: string;
  public password: string;
  public aboutMe: string;
  public myClasses: string;
  public futureGoals: string;
  public funStuff: string;
  public otherStuff: string;
  public interestingLinks: string;

  constructor(public configService: ConfigService) { }
  
  ngOnInit() {
    this.configService.getUser().subscribe(
      res => {
        this.username = res.username;
        this.password = res.password;
        this.aboutMe = res.aboutMe;
        this.myClasses = res.myClasses;
        this.futureGoals = res.futureGoals;
        this.funStuff = res.funStuff;
        this.otherStuff = res.otherStuff;
        this.interestingLinks = res.interestingLinks;
        console.log(this.resData);
      }
    );
  }


}
