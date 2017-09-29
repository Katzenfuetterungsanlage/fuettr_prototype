
export interface IUser {
  htlid: string;
  surname: string;
  firstname?: string;
}

export class User implements IUser {

  private _htlid: string;
  private _surname: string;
  private _firstname: string;

  public constructor(user: IUser) {
    if (!user ||
        typeof(user.htlid) !== 'string' || user.htlid.length < 1 ||
        typeof(user.surname) !== 'string' || user.surname.length < 1 ||
        (user.firstname && typeof(user.firstname) !== 'string')
    ) {
      throw new Error('Illegal Argument');
    }
    this._htlid = user.htlid;
    this._surname = user.surname;
    this._firstname = user.firstname;
  }

  public get htlid (): string {
    return this._htlid;
  }

  public get surname (): string {
    return this._surname;
  }

  public get firstname (): string {
    return this._firstname;
  }

  public toObject (): IUser {
    const rv: IUser = {
      htlid: this._htlid,
      surname: this._surname
    }
    if (this._firstname) {
      rv.firstname = this._firstname;
    }
    return rv;
  }

}

export interface IUserLogin {
  htlid: string;
  password: string;
  stayLoggedIn: boolean;
}
