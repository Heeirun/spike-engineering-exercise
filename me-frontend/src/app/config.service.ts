import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class ConfigService {
  constructor(private http: HttpClient) { }

  public getUser() {
      console.log("Service call")
      return this.http.get<UserData>("http://localhost:8080/user");
  }
}

export interface UserData {
  "id": number,
  "aboutMe": string,
  "myClasses": string,
  "futureGoals": string,
  "funStuff": string,
  "otherStuff": string,
  "interestingLinks": string,
  "username": string,
  "password": string
}