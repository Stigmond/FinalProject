import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userLogin: User = new User();

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  login(user: User): void{
  console.log("Logging in user: ");
  console.log(user);
  this.authService.login(user.username, user.password).subscribe(
    next => {
      console.log('RegisterComponent.register(): user logged in, routing to /todo.');
      this.router.navigateByUrl('/home');
    },
    error => {
      console.error('RegisterComponent.register(): error logging in.');
    }
  );
  }
}
