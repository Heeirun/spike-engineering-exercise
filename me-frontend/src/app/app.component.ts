import { Component } from '@angular/core';
import { ConfigService,UserData } from './config.service';

@Component({
  selector: 'app-root',
  providers: [ConfigService],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'me-frontend';
  public output : string;
  // public configService : ConfigService;
  public resData : UserData;

  constructor(private configService: ConfigService) { }

  getData(){
    return this.configService.getBackEndTest().subscribe(
      res => {
        this.resData = res
        console.log(this.resData);
      }
    );
  }
}
