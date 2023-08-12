# SuperDuperMarkt

## Before getting started
Die Anwendung benötigt Java 17 um zu laufen.

Als Stichtag wird immer der aktuelle Tag angenommen.

## Build
Um die Anwendung zu bauen, muss in der Base-Directory folgender Befehl ausgeführt werden: 
```
mvn clean install
```

Um die Anwendung zu starten, muss folgender Befehl ausgeführt werden:
```
java -jar SuperDuperMarkt-0.0.1.jar
```

## How to use it
Nach dem Starten der Anwendung stehen folgende Befehle zur Auswahl:

### Produkte des Sortiments und deren Startwerte
```
shell:>get all
---------------------------------------------------------
Alle Artikel:
---------------------------------------------------------
| Bezeichnung     | Preis  | Qualität  | Verfallsdatum  |
---------------------------------------------------------
| Bio Wein        | 4.99   | 30        | -              |
| Tilsiter        | 2.99   | 60        | 31.08.2023     |
| Birnen          | 1.49   | 80        | 19.08.2023     |
| Bio Milch 3,5%  | 1.19   | 90        | 02.09.2023     |
```

### Eine Übersicht aller Produkte für den übergebenen Tag
Wird kein Tag übergeben wird immer vom heutigen Tag ausgegangen:

```
shell:>get for
---------------------------------------------------------
Alle Artikel für : 12.08.2023
---------------------------------------------------------
| Bezeichnung     | Preis  | Qualität  | Entsorgen      |
---------------------------------------------------------
| Bio Wein        | 4.99   | 30        | false          |
| Tilsiter        | 8.99   | 60        | false          |
| Birnen          | 9.49   | 80        | false          |
| Bio Milch 3,5%  | 10.19  | 90        | false          |
```

Wird ein Tag übergeben, werden die Daten entsprechend berechnet:
```
shell:>get for 21.08.2023
---------------------------------------------------------
Alle Artikel für : 21.08.2023
---------------------------------------------------------
| Bezeichnung     | Preis  | Qualität  | Entsorgen      |
---------------------------------------------------------
| Bio Wein        | 4.99   | 30        | false          |
| Tilsiter        | 8.09   | 51        | false          |
| Birnen          | 9.49   | 80        | false          |
| Bio Milch 3,5%  | 10.19  | 90        | false          |
```