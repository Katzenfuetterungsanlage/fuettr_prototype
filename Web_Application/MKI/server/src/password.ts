import * as passwordHash from 'password-hash';

export interface Options extends passwordHash.Options {
  algorithm?: 'md5' | 'sha1' | 'sha256' | 'sha512';
}

export function generate (password: string, options?: Options): string {
  return passwordHash.generate(password, options);
}

export function verify (password: string, hashedPassword: string): boolean {
  return passwordHash.verify(password, hashedPassword);
}


export function isHashed (password: string): boolean {
  return passwordHash.isHashed(password);
}
