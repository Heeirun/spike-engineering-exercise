import { Component } from '@angular/core';
import { ConfigService } from './config.service';

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

  constructor() { }
}
