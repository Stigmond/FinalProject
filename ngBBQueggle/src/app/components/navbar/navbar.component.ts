import { Component, OnInit } from '@angular/core';
import { throwError } from 'rxjs';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
import { UserService } from 'src/app/services/user.service';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  public isCollapsed = true;

  user = new User();
  selected: User;


  constructor(
    private auth: AuthService,
    private userService: UserService
  ) { }


  ngOnInit(): void {
  }

  loggedIn(): boolean {
    return this.auth.checkLogin();
  }


  getById(id: number) {

    this.userService.findById(id).subscribe(
      data => {
        this.user = data;
        this.selected = this.user;
        // this.editedUser = this.user;
        // this.editedAddress = this.user.address;
        console.log(data);
      },
      err => {
        console.error(err);
        return throwError('Unable to load User');
      }
      );
    }

}
