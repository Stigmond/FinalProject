import { User } from './../../models/user';
import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Address } from 'src/app/models/address';

import { AddressService } from 'src/app/services/address.service';


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
    this.loadAddress();
  }

  loadUser(): void {
    this.userService.index().subscribe(
      (data) => {
        this.users = data;
        console.log('registerComponent.loadUser(): User retrieved');
      },
      (err) => {
        console.error('registerComponent.loadUse(): retrieve failed');
        console.error(err);
      }
    );
  }

    showUser(user: User) {
    this.selected = user;
    this.editUser = Object.assign({}, this.selected);
  }

    addUser(user: User) {
    this.userService.create(user).subscribe(
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
        console.error('problem with updateRun() in run-list component');
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
        console.error('problem with updateAddress() in run-list component');
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


