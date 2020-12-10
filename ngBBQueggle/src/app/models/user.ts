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

  constructor(
  id?: number,
  firstName?: string,
  lastName?: string,
  username?: string,
  password?: string,
  email?: string,
  image?: string,
  role?: string,
  enabled?: boolean

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
  }
}
