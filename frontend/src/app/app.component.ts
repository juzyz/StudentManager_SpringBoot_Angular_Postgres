import { Component } from '@angular/core';
import { StorageService } from './authentication/storage/storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})

export class AppComponent {
  title = 'angular-frontend';


  isUserLoggedIn = false;
  setUserLoggedIn(): any {
    this.isUserLoggedIn = StorageService.isUserLoggedIn();
  }


  logout(): any {
    StorageService.logout(); 
  }


}
