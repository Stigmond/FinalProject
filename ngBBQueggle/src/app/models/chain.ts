import { NgIf } from '@angular/common';

export class Chain {
  id: number;
  name: string;
  logo: string;
  website: string;

  constructor(
    id?: number,
    name?: string,
    logo?: string,
    website?: string,
  ){
    this.id = id;
    this.name = name;
    this.logo = logo;
    this.website = website;
  }
}
