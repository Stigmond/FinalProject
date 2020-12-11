import { Address } from './address';
import { Review } from './review';

export class User {
  id: number;
  firstName: string;
  lastName: string;
  username: string;
  password: string;
  email: string;
  image: string;
  role: string;
  enabled: boolean;
  address: Address;
  reviews: Review [];

  constructor(
  id?: number,
  firstName?: string,
  lastName?: string,
  username?: string,
  password?: string,
  email?: string,
  image?: string,
  role?: string,
  enabled?: boolean,
  address?: Address,
  reviews?: Review []

  ){
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.password = password;
    this.email = email;
    this.image = image;
    this.role = role;
    this.enabled = enabled;
    this.address = address;
    this.reviews = reviews;
  }
}
