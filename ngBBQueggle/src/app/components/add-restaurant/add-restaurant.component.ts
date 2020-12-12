import { RestaurantService } from 'src/app/services/restaurant.service';
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

  stylesForm: FormGroup;
  sideDishesForm: FormGroup;
  mainDishesForm: FormGroup;

  sideDishesArray: SideDish[];
  mainDishesArray: MainDish[];
  // saucesArray: Sauce[];
  stylesArray: Style[];

  newRestaurant: Restaurant = new Restaurant();
  newAddress: Address = new Address();


  constructor(private restService: RestaurantService, private styleServ: StyleService, private sideDishServ: SideDishService, private mainDishServ: MainDishService, private sauceServ: SauceService, private formBuilder: FormBuilder) {
    this.stylesForm = this.formBuilder.group({
      selectedStyles: this.formBuilder.array([], [Validators.required])
    })

    this.sideDishesForm = this.formBuilder.group({
      selectedSides: this.formBuilder.array([], [Validators.required])
    })

    this.mainDishesForm = this.formBuilder.group({
      selectedMains: this.formBuilder.array([], [Validators.required])
    })
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

  onStyleCheckboxChange(e) {
    const styleList: FormArray = this.stylesForm.get('selectedStyles') as FormArray;

    if (e.target.checked) {
      styleList.push(new FormControl(e.target.value));
    } else {
       const index = styleList.controls.findIndex(x => x.value === e.target.value);
       styleList.removeAt(index);
    }
  }

  onSideCheckboxChange(e) {
    const sideList: FormArray = this.sideDishesForm.get('selectedSides') as FormArray;

    if (e.target.checked) {
      sideList.push(new FormControl(e.target.value));
    } else {
       const index = sideList.controls.findIndex(x => x.value === e.target.value);
       sideList.removeAt(index);
    }
  }

  onMainCheckboxChange(e) {
    const mainList: FormArray = this.mainDishesForm.get('selectedMains') as FormArray;

    if (e.target.checked) {
      mainList.push(new FormControl(e.target.value));
    } else {
       const index = mainList.controls.findIndex(x => x.value === e.target.value);
       mainList.removeAt(index);
    }
  }

  submit(){

    console.log(this.newAddress);
    this.newAddress.enabled = true;
    this.newRestaurant.enabled = false;
    this.newRestaurant.address = this.newAddress;
    console.log(this.newRestaurant);
    console.log(this.stylesForm.value);
    console.log(this.sideDishesForm.value);
    console.log(this.mainDishesForm.value);

    this.restService.create(this.newRestaurant).subscribe(
      (success) => {
        console.log(success);
        console.log('creation success!');
        window.alert('Restaurant Created Successfully!');
      },
      (fail) => {
        console.error('problem with adding Restaurant');
      }
    );





  }


}


