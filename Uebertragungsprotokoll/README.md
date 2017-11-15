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
    * [1.4 Warnungen](#14-warnungen)
        * [Möglichkeitenbaum](#möglichkeitenbaum-3)
        * [Beispiel](#beispiel-3)
    * [1.5 Errors](15-errors)
        * [Möglichkeitenbaum](#möglichkeitenbaum-4)
        * [Beispiel](#beispiel-4)
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

| time1  | time2  | time3  | time4  |
|--------|--------|--------|--------|
| string | string | string | string |

#### Möglichkeitenbaum

- time1
    - 00:00 - 23:59
- time2
    - 00:00 - 23:59
- time3
    - 00:00 - 23:59
- time4
    - 00:00 - 23:59

#### Beispiel:
```JSON
{  
    "time1" : "10:10",
    "time2" : "11:11",
    "time3" : "12:12",
    "time4" : "--:--"
}
```

### 1.3 Geräteinformationen

| serialnumber | internal | wlanState | ipaddress |
|--------------|----------|-----------|-----------|
|   string     |  string  |   string  |   string  |

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
- ipaddress
    - 0.0.0.0 - 255.255.255.255

#### Beispiel:
```JSON
{  
    "serialnumber" : "#000001",
    "internal" : "Raspberry Pi 3 Model B",
    "wlanState" : "disconnected",
    "ipaddress" : "185.192.15.21"
}
```

### 1.4 Warnungen

| warnings |
|----------|
|warning[] |

#### Möglichkeitenbaum

- warnings
    - warning
        - string

#### Beispiel
```JSON
{
    "warnings": [{
        "warning" : "Füllstand niedrig",
    },{
        "warning" : "Füllstand leer"
    }]
}
```

### 1.5 Errors

| errors |
|--------|
|error[] |

#### Möglichkeitenbaum

- errors
    - error
        - string

#### Beispiel
```JSON
{
    "errors": [{
        "error": "Motor 2 blockiert"
    }]
}
```
## Client zu Server Kommunikation
