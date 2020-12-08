export class Address {
  id: number;
  street: string;
  city: string;
  state: string;
  zip: string;
  enabled: boolean;

  constructor(
    id?: number,
    street?: string,
    city?: string,
    state?: string,
    zip?: string,
    enabled?: boolean,
  ){
    this.id = id;
    this.street = street;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.enabled = enabled;
  }
}
