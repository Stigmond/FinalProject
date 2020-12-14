import { Pitmaster } from './pitmaster';
import { SideDish } from './side-dish';
import { Address } from './address';
import { MainDish } from './main-dish';
import { Style } from './style';
export class Restaurant {
  id: number;
  name: string;
  phoneNumber: string;
  description: string;
  website: string;
  logo: string;
  dineIn: boolean;
  hours: string;
  enabled: boolean;
  address: Address;
  sideDishes: SideDish[];
  mainDishes: MainDish[];
  styles: Style[];
  pitmaster: Pitmaster

  constructor(
  id?: number,
  name?: string,
  phoneNumber?: string,
  description?: string,
  website?: string,
  logo?: string,
  dineIn?: boolean,
  hours?: string,
  enabled?: boolean,
  address?: Address,
  sideDishes?: SideDish[],
  mainDishes?: MainDish[],
  styles?: Style[],
  pitmaster?: Pitmaster
  ){
    this.id = id;
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.description = description;
    this.website = website;
    this.logo = logo;
    this.dineIn = dineIn;
    this.hours = hours;
    this.enabled = enabled;
    this.address = address;
    this.sideDishes = sideDishes;
    this.mainDishes = mainDishes;
    this.styles = styles;
    this.pitmaster = pitmaster;
  }
}
