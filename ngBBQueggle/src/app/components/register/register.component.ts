import { User } from './../../models/user';
import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Address } from 'src/app/models/address';

import { AddressService } from 'src/app/services/address.service';
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

  constructor(private userService: UserService, private addressService: AddressService) { }

  ngOnInit(): void {
    this.loadUser();
  }

  loadUser(): void {
    this.userService.index().subscribe(
      (data) => {
        this.users = data;


        console.log('RunListComponent.loadRun(): Runs retrieved');
      },
      (err) => {
        console.error('RunListComponent.loadRun(): retrieve failed');
        console.error(err);
      }
    );
  }

  showRun(user: User) {
    this.selected = user;
    this.editUser = Object.assign({}, this.selected);
    //"what the hell"
  }



  addUser(user: User) {
    this.userService.create(user).subscribe(
      (user) => {
        this.newUser = new User();

        this.loadUser();
        console.log('creation success!');
        // call index method on service
        window.alert('Run Created Successfully!');
      },
      (err) => {
        console.error('problem with addRun()');
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
        console.error('problem with updateRun() in run-list component');
      }
    );
  }

  // register(form: NgForm) {
  //   const user: User = new User();
  //   const address: Address = new Address();

  //   user.firstName = form.value.firstName;
  //   user.lastName = form.value.lastName;
  //   user.email = form.value.email;
  //   user.password = form.value.password;
  //   user.image = form.value.image;

  //   address.street = form.value.street;
  //   address.state = form.value.state;
  //   address.state = form.value.city;
  //   address.state = form.value.zip;



  }


