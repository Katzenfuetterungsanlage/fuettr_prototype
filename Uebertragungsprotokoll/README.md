# Übertragungsprotokoll

## 1.1 Maschinenstatus

| last_time | next_time | next_time_in | machine_state |
|-----------|-----------|--------------|---------------|
|   string  |  string   |    string    |    string     |

### Möglichkeitenbaum

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

### Beispiel: 
```JSON
{  
    "last_time" : "10:10",  
    "next_time" : "11:11",
    "next_time_in" : "00:10",
    "machine_state" : "Aus"
}
```

## 1.2 Fütterungszeiten

| time1  | time2  | time3  | time4  |
|--------|--------|--------|--------|
| string | string | string | string |

### Möglichkeitenbaum

- time1
    - 00:00 - 23:59
- time2
    - 00:00 - 23:59
- time3
    - 00:00 - 23:59
- time4
    - 00:00 - 23:59

### Beispiel:
```JSON
{  
    "time1" : "10:10",
    "time2" : "11:11",
    "time3" : "12:12",
    "time4" : "--:--"
}
```

## 1.3 Geräteinformationen

| serialnumber | internal | wlanState | ipaddress |
|--------------|----------|-----------|-----------|
|   string     |  string  |   string  |   string  |

### Möglichkeitenbaum

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

### Beispiel:
```JSON
{  
    "serialnumber" : "#000001",
    "internal" : "Raspberry Pi 3 Model B",
    "wlanState" : "disconnected",
    "ipaddress" : "185.192.15.21"
}
```

## 1.4 Warnungen

| warnings |
|----------|
|warning[] |

### Möglichkeitenbaum

- warnings
    - warning
        - string

### Beispiel
```JSON
{
    "warnings": [{
        "warning" : "Füllstand niedrig",
    },{
        "warning" : "Füllstand leer"
    }]
}
```

## 1.5 Errors

| errors |
|--------|
|error[] |

### Möglichkeitenbaum

- errors
    - error
        - string

### Beispiel
```JSON
{
    "errors": [{
        "error": "Motor 2 blockiert"
    }]
}
```
