export interface Version {
  version: string;
}

export interface Warning {
  warning: string;
  id: number;
}

export interface Warnings {
  warnings: Warning[];
}

export interface AckWarn {
  id: number;
}

export interface Error {
  error: string;
  id: number;
}

export interface Errors {
  errors: Error[];
}

export interface AckErr {
  id: number;
}

export interface Times {
  time1: string;
  time1_active: boolean;
  time2: string;
  time2_active: boolean;
  time3: string;
  time3_active: boolean;
  time4: string;
  time4_active: boolean;
}

export interface Status {
  last_time: string;
  next_time: string;
  next_time_in: string;
  machine_state: string;
}

export interface Info {
  serialnumber: string;
  internal: string;
  wlanState: string;
}

export interface Ip {
  ip: string;
}

export interface Positions {
  motor1: string;
  motor2: string;
  sensor1: string;
  sensor2: string;
}

