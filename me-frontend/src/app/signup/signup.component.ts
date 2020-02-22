import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  public username: string;
  public password: string;
  public aboutMe: string;
  public myClasses: string;
  public futureGoals: string;
  public funStuff: string;
  public otherStuff: string;
  public interestingLinks: string;

  constructor() { }

  ngOnInit() {

  }

  createAccount(){
    console.log(this.username);
    console.log(this.password);
    console.log(this.aboutMe);
    console.log(this.myClasses);
    console.log(this.futureGoals);
    console.log(this.funStuff);
    console.log(this.otherStuff);
    console.log(this.interestingLinks);

  }

}
