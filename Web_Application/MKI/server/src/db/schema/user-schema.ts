import * as mongoose from 'mongoose';

// ******************************************************
// * Database Schemas
// ******************************************************

// then nested schema must be declared first

const loginLogoutSchemaConfig = {
  at:      { type: Number, required: true },
  socket:  { type: String, required: true }
}
const loginLogoutSchema = new mongoose.Schema(loginLogoutSchemaConfig);

const userSchemaConfig = {
  htlid:     { type: String, required: true, unique: true, index: true },
  surname:   { type: String, required: true },
  firstname: { type: String },
  password:  { type: String },
  login:     { type: [ loginLogoutSchema ] },
  logout:    { type: [ loginLogoutSchema ] },
  createdAt: { type: Number },
  savedAt:   { type: Number }
}

export const userSchema = new mongoose.Schema(userSchemaConfig);


// ******************************************************
// * Interfaces
// ******************************************************

export interface IUserLoginLogout {
  at: number,
  socket: string
}

export interface IUser {
  htlid: string,
  surname: string,
  firstname?: string,
  password?: string,
  passwordHash?: string,
  login?: IUserLoginLogout,
  logout?: IUserLoginLogout
}

export interface IUserRecord  {
  id?: string,
  createdAt?: number,
  savedAt?: number
  htlid: string,
  surname: string,
  firstname?: string,
  password?: string,
  login?: IUserLoginLogout,
  logout?: IUserLoginLogout
}

// ******************************************************
// * Interface for database records
// ******************************************************

export interface IUserDocument extends mongoose.Document, IUserRecord {}

