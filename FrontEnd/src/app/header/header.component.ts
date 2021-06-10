import { AuthService } from './../service/auth.service';
import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../service/token-storage.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  username!: string;

  token = '';

  constructor(private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
  }

  isLoggedIn():boolean{
    this.token = this.tokenStorageService.getToken();
    if(this.token == '{}')
    {
      return false;
      
    }else{    
      const user = this.tokenStorageService.getUser();
      this.username = user.username;
      return true;
    }
}

  logout(): void {
    this.tokenStorageService.signOut();
  }

}
