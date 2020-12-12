import { StyleService } from './../../services/style.service';
import { SauceService } from './../../services/sauce.service';
import { Sauce } from './../../models/sauce';
import { MainDish } from './../../models/main-dish';
import { SideDishService } from './../../services/sidedish.service';
import { Component, OnInit } from '@angular/core';
import { Restaurant } from 'src/app/models/restaurant';
import { SideDish } from 'src/app/models/side-dish';
import { Address } from 'src/app/models/address';
import { FormGroup, FormBuilder, Validators, FormArray, FormControl } from '@angular/forms';
import { createArrayBindingPattern } from 'typescript';
import { Style } from 'src/app/models/style';
import { MainDishService } from 'src/app/services/maindish.service';


@Component({
  selector: 'app-add-restaurant',
  templateUrl: './add-restaurant.component.html',
  styleUrls: ['./add-restaurant.component.css']
})
export class AddRestaurantComponent implements OnInit {

  sideDishesArray: SideDish[];
  mainDishesArray: MainDish[];
  // saucesArray: Sauce[];
  stylesArray: Style[];


  newRestaurant: Restaurant = new Restaurant();
  newAddress: Address = new Address();



  constructor(private styleServ: StyleService, private sideDishServ: SideDishService, private mainDishServ: MainDishService, private sauceServ: SauceService, private formBuilder: FormBuilder) {


   }

  ngOnInit(): void {
    this.index();

  }

  index(): void{
    this.sideDishServ.index().subscribe(
      good=>{
        this.sideDishesArray = good;
        console.log(this.sideDishesArray);

      },
      error=>{
        console.error('failed to load index of side dishes()');
        console.error(error);
      }
    );

    this.mainDishServ.index().subscribe(
      good=>{
        this.mainDishesArray = good;
        console.log(this.mainDishesArray);

      },
      error=>{
        console.error('failed to load index of main dishes()');
        console.error(error);
      }
    );

    // this.sauceServ.index().subscribe(
    //   good=>{
    //     this.saucesArray = good;
    //     console.log(this.saucesArray);

    //   },
    //   error=>{
    //     console.error('failed to load index of sauces()');
    //     console.error(error);
    //   }
    // );

    this.styleServ.index().subscribe(
      good=>{
        this.stylesArray = good;
        console.log(this.stylesArray);

      },
      error=>{
        console.error('failed to load index of styles()');
        console.error(error);
      }
    );


  }








}


