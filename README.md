[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/dnW0dm4q)
# Projet "Dice" - Gestion de lancés de dés avec Spring Boot

## Description
Le projet "Dice" est une application construite avec Spring Boot permettant de simuler des lancés de dés et de gérer un historique des résultats en base de données. Ce projet met en œuvre les concepts fondamentaux de Spring Boot, notamment l'injection de dépendances, les services RESTful, les entités JPA et les repositories.


## Étapes de réalisation

### 1. Création et Configuration du projet Spring Boot
- Création d'un projet Spring Boot avec les dépendances suivantes :
  - **Spring Web** : Pour créer des services REST.
  - **Spring Data JPA** : Pour la gestion des entités et des repositories.
  - **H2 Database** : Pour une base de données en mémoire.
  - **Lombok** (bonus) : Pour simplifier le code.
  - **Swagger** (bonus) : Pour documenter les endpoints.
- Configurration du port sur 8081.
- Configuration du nom de l'application (dice)

### 2. Création de la classe `Dice`
- Ajout des champs suivants :
  - **`nbFaces`** : Nombre de faces du dé.
- Ajout d'une méthode `roll()` pour lancer le dé et stocker le résultat.
- Ajout de l'annotation component pour permettre l'injection de dépendances.

### 3. Création de l'entité `DiceRollLog`
- Création de la class avec l'anotation `@Entity`, `@Getter`, `@Setter`, `@AllArgsConstructor`, `@Builder`, `@ToString`.
- Ajout des champs :
  - **`id`** : Identifiant unique avec l'annotation `@Id` et `@GeneratedValue`.
  - **`diceCount`** : Nombre de dés lancés.
  - **`results`** : Liste des valeurs obtenues avec l'annotation `@ElementCollection`.
  - **`timestamp`** : Horodatage du lancé avec l'annotation `@CreationTimestamp`.

### 4. Création du `Repository`
- Création de l'inteface `DiceRollLogRepository` étendant `JpaRepository`.
- Ajout de l'annotation `@Repository` pour permettre l'injection de dépendances.

### 5. Création du contrôleur REST pour lancer les dés
- Création de la class `DiceController` avec l'annotation `@RestController`.
- Ajoutez les endpoints suivants :
  - **`GET /dice/roll`** : Lancer un seul dé.
  - **`GET /dice/roll/{x}`** : Lancer x dés (x est un paramètre de l'URL requis).
  - **`GET /dice/log`** : Retourne l'historique des lancés.

### 6. Création du `Service`
- Créez de la class `DiceService` avec l'annotation `@Service`.
- Implémentation des méthodes :
- **`roll(int nbRoll)`** : Lancer un dé `nbRoll` fois et retourner les résultats. Avec enregistrement en base de données de l'historique.
- **`getLog()`** : Retourner l'historique des lancés.

### 7. (Bonus) Ajout de fonctionnalités avancées
- **Swagger** : Ajout de la documentation des endpoints avec Swagger via les annotations:
  - `@Tag` : Pour définir le groupe de contrôleurs.
  - `@Operation` : Pour définir une opération.
  - `@Paramameter` : Pour définir un paramètre.