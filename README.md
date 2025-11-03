SpringApplication.run(WebappApplication.class, args);
``` :contentReference[oaicite:0]{index=0}

---

###  **HomeController**
Håndterer visning og ændring af madvarer.

#### Vises når man besøger `/` (forsiden)
```java
@GetMapping("/")
public String home(...)
``` :contentReference[oaicite:1]{index=1}
- Filtrerer madvarer efter kategori og søgning
- Sender resultat til HTML-view
- Laver tom form til oprettelse

#### Redigering `/edit/{id}`
```java
@GetMapping("/edit/{id}")
``` :contentReference[oaicite:2]{index=2}
- Henter en vare og fylder formularen med data

#### Gem / opret `/save`
```java
@PostMapping("/save")
``` :contentReference[oaicite:3]{index=3}
- Gemmer ny eller opdateret vare

#### Slet `/delete/{id}`
```java
@PostMapping("/delete/{id}")
``` :contentReference[oaicite:4]{index=4}
- Fjerner varen fra hukommelsen

---

###  **InMemoryFoodRepository**
Fungerer som database.

- Opretter data ved start (`@PostConstruct`)
- Gemmer data i `Map`

Eksempel:
```java
save(new FoodItem(null, "Grøn salatboks", ...));
``` :contentReference[oaicite:5]{index=5}

Gemmet ved hjælp af UUID:
```java
item.setId(UUID.randomUUID().toString());
``` :contentReference[oaicite:6]{index=6}

Indeholder også lille validering, så tomme felter ikke crasher appen.

---

###  **FoodItem model**
Din data-struktur for madvarer:

```java
private String id;
private String name;
private String category;
private Integer qty;
private Double kg;
private Double price;
private LocalDateTime pickup;
private String desc;
``` :contentReference[oaicite:7]{index=7}

---

###  **CSS**
Styrer layout, farver og responsive design.  
Fx tema-farver og grid-layout til input felter.

---

## ✨ **Kort sagt**
| Funktion | Fil |
|---|---|
Start app | `WebappApplication.java` |
Vis liste, søg, filter | `HomeController.java` |
Opret/rediger/slet | `HomeController.java` |
Midlertidig database | `InMemoryFoodRepository.java` |
Data model | `FoodItem.java` |
Styling | `.css` |

---

## Hvad du nu ved
- Controller styrer logikken 
- Repository gemmer data 
- Model definerer felterne 
- View (HTML + CSS) viser dem 

---

## Bonus-tip
Hvis du vil gøre systemet **rigtigt produktionsklart**, næste skridt kunne være:

- Tilføje RIGTIG database (MySQL / PostgreSQL)
- Validation i formularer
- Login system for brugere
