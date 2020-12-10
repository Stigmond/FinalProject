// import { User } from './../../models/user';
// import { UserService } from './../../services/user.service';
// import { Component, OnInit } from '@angular/core';
// import { NgForm } from '@angular/forms';
// import { Address } from 'src/app/models/address';
// import { User } from 'src/app/models/user';
// import { AddressService } from 'src/app/services/address.service';
// import { Router } from '@angular/router';

// @Component({
//   selector: 'app-register',
//   templateUrl: './register.component.html',
//   styleUrls: ['./register.component.css']
// })
// export class RegisterComponent implements OnInit {

//   newUser: User = new User();
//   createdAddress: Address = new Address();

//   constructor(private userService: UserService, private addressService: AddressService, private router: Router) { }

//   ngOnInit(): void {
//   }

//   addUser() {
//     this.Service.register(this.newUser).subscribe(
//       (run) => {
//         this.newRun = new Run();

//         this.loadRun();
//         console.log('creation success!');
//         // call index method on service
//         window.alert('Run Created Successfully!');
//       },
//       (err) => {
//         console.error('problem with addRun()');
//       }
//     );
//   }

//   // register(form: NgForm) {
//   //   const user: User = new User();
//   //   const address: Address = new Address();

//   //   user.firstName = form.value.firstName;
//   //   user.lastName = form.value.lastName;
//   //   user.email = form.value.email;
//   //   user.password = form.value.password;
//   //   user.image = form.value.image;

//   //   address.street = form.value.street;
//   //   address.state = form.value.state;
//   //   address.state = form.value.city;
//   //   address.state = form.value.zip;



//   }

// }
