export class User {
  id: number;
  firstName: string;
  lastName: string;
  username: string;
  password: string;
  email: string;
  enabled: boolean;
  role: string;
  image: string;

  constructor(
  id?: number,
  firstName?: string,
  lastName?: string,
  username?: string,
  password?: string,
  enabled?: boolean,
  email?: string,
  role?: string,
  image?: string

  ){
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.password = password;
    this.enabled = enabled;
    this.email = email;
    this.role = role;
    this.image = image;
  }
}
