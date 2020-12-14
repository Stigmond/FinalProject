import { User } from 'src/app/models/user';

import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Address } from 'src/app/models/address';

import { AddressService } from 'src/app/services/address.service';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  selected = null;

  editUser = null;
  editAddress = null;

  newUser: User = new User();
  newAddress: Address = new Address();

  users: User[] = [];
  addresses: Address[] = [];

  constructor(private authService: AuthService,
     private router: Router,
     private userService: UserService,
     private addressService: AddressService) { }

  ngOnInit(): void {
    this.loadUser();
    this.loadAddress();
  }

  loadUser(): void {
    this.userService.index().subscribe(
      (data) => {
        this.users = data;
        console.log('registerComponent.loadUser(): User retrieved');
      },
      (err) => {
        console.error('registerComponent.loadUser(): retrieve failed');
        console.error(err);
      }
    );
  }

    showUser(user: User) {
    this.selected = user;
    this.editUser = Object.assign({}, this.selected);
  }

    addUser() {
      console.log(this.newUser);
      this.newAddress.enabled = true;
      this.newUser.enabled = true;
      console.log(this.newAddress);

      this.newUser.role = "ROLE_USER";
      this.newUser.address = this.newAddress;
      this.userService.create(this.newUser).subscribe(
      (user) => {
        this.newUser = new User();
        this.loadUser();
        console.log('creation success!');
        window.alert('User Created Successfully!');
      },
      (err) => {
        console.error('problem with addUser()');
      }
    );
  }

  updateUser(editUser: User) {
    this.userService.update(editUser.id,editUser).subscribe(
      (data) => {
        this.loadUser();
        this.selected = null;
        window.alert('Run Updated Successfully');
      },
      (err) => {
        console.error('problem with updateRun() in register component');
      }
    );
  }

  loadAddress(): void {
    this.addressService.index().subscribe(
      (data) => {
        this.addresses = data;
        console.log('registerComponent.loadAddress(): User retrieved');
      },
      (err) => {
        console.error('registerComponent.loadAddress(): retrieve failed');
        console.error(err);
      }
    );
  }

  showAddress(user: User) {
    this.selected = user;
    this.editUser = Object.assign({}, this.selected);
  }

  addAddress(address: Address) {
    this.addressService.create(address).subscribe(
      (address) => {
        this.newAddress = new Address();
        this.loadAddress();
        console.log('creation success!');
        window.alert('Address Created Successfully!');
      },
      (err) => {
        console.error('problem with addAddress()');
      }
    );
  }

  updateAddress(editAddress: Address) {
    this.addressService.update(editAddress).subscribe(
      (data) => {
        this.loadAddress();
        this.selected = null;
        window.alert('Address Updated Successfully');
      },
      (err) => {
        console.error('problem with updateAddress() in register component');
      }
    );
  }

  register(user: User): void {
    console.log("Registering user:");
    console.log(user,user.address);
    this.authService.register(user).subscribe(
      data => {
        console.log('RegisterComponent.register(): user registered.');
        this.authService.login(user.username, user.password).subscribe(
          next => {
            console.log('RegisterComponent.register(): user logged in, routing to /home.');
            this.router.navigateByUrl('/home');
          },
          error => {
            console.error('RegisterComponent.register(): error logging in.');
          }
        );
      },
      err => {
        console.error('RegisterComponent.register(): error registering.');
        console.error(err);
      }
    );

  }


  }


