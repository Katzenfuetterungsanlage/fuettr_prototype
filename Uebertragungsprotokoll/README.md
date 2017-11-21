# Übertragungsprotokoll

## Inhaltsverzeichnis

* [Server zu Client Kommunikation](#server-zu-client-kommunikation)
    * [1.1 Maschinenstatus](#11-maschinenstatus)
        * [Möglichkeitenbaum](#möglichkeitenbaum)
        * [Beispiel](#beispiel)
    * [1.2 Fütterungszeiten](#12-fütterungszeiten)
        * [Möglichkeitenbaum](#möglichkeitenbaum-1)
        * [Beispiel](#beispiel-1)
    * [1.3 Geräteinformationen](#13-geräteinformationen)
        * [Möglichkeitenbaum](#möglichkeitenbaum-2)
        * [Beispiel](#beispiel-2)
    * [1.4 Positions-info](#14-positions-info)
        * [Möglichkeitenbaum](#möglichkeitenbaum-3)
        * [Beispiel](#beispiel-3)
    * [1.5 Warnungen](#15-warnungen)
        * [Möglichkeitenbaum](#möglichkeitenbaum-4)
        * [Beispiel](#beispiel-4)
    * [1.6 Errors](#16-errors)
        * [Möglichkeitenbaum](#möglichkeitenbaum-5)
        * [Beispiel](#beispiel-5)
* [Client zu Server Kommunikation](#client-zu-server-kommunikation)

## Server zu Client Kommunikation

### 1.1 Maschinenstatus

| last_time | next_time | next_time_in | machine_state |
|-----------|-----------|--------------|---------------|
|   string  |  string   |    string    |    string     |

#### Möglichkeitenbaum

- last_time
    - 00:00 - 23:59
    - --:--
- next_time
    - 00:00 - 23:59
    - --:--
- next_time_in
    - 00:00 -23:59
    - --:--
- machine_state
    - An
    - Aus

#### Beispiel: 
```JSON
{  
    "last_time" : "10:10",  
    "next_time" : "11:11",
    "next_time_in" : "00:10",
    "machine_state" : "Aus"
}
```

### 1.2 Fütterungszeiten

| time1  | time2  | time3  | time4  | time1_active | time2_active | time3_active | time4_active |
|--------|--------|--------|--------|--------------|--------------|--------------|--------------|
| string | string | string | string |   boolean    |   boolean    |   boolean    |   boolean    |

#### Möglichkeitenbaum

- time1
    - 00:00 - 23:59
- time2
    - 00:00 - 23:59
- time3
    - 00:00 - 23:59
- time4
    - 00:00 - 23:59
- time1_active
    - true/false
- time2_active
    - true/false
- time3_active
    - true/false
- time4_active
    - true/false

#### Beispiel:
```JSON
{  
    "time1":"11:11",
    "time2":"12:12",
    "time3":"13:13",
    "time4":"",
    "time1_active":true,
    "time2_active":false,
    "time3_active":true,
    "time4_active":false
}
```

### 1.3 Geräteinformationen

| serialnumber | internal | wlanState |
|--------------|----------|-----------|
|   string     |  string  |   string  |

#### Möglichkeitenbaum

- serialnumber
    - #000000 - #FFFFFF
- internal
    - Raspberry Pi 3 Model B
    - Raspberry Pi 2 Model B
    - ...
- wlanState
    - nicht verbunden
    - verbunden
    - ausgeschalten

#### Beispiel:
```JSON
{  
    "serialnumber" : "#000001",
    "internal" : "Raspberry Pi 3 Model B",
    "wlanState" : "disconnected"
}
```

### 1.4 Positions-info

#### Möglichkeitenbaum

#### Beispiel:

### 1.5 Warnungen

| warnings |
|----------|
|warning[ ]|

| warning |  id  |
|---------|------|
| string  |number|

#### Möglichkeitenbaum

- warnings
    - warning
        - string
        - 1 - 65535

#### Beispiel
```JSON
{
    "warnings": [{
        "warning" : "Füllstand niedrig",
        "id": 65535
    },{
        "warning" : "Füllstand leer",
        "id": 5168
    }]
}
```

### 1.6 Errors

| errors |
|--------|
|error[ ]|

|error |  id  |
|------|------|
|string|number|

#### Möglichkeitenbaum

- errors
    - error
        - string
        - 1 - 65535

#### Beispiel
```JSON
{
    "errors": [{
        "error": "Motor 2 blockiert",
        "id": 51644
    }]
}
```
## Client zu Server Kommunikation
