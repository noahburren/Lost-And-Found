# Lost & Found – Quarkus Backend

Dies ist das Backend der *Lost & Found* Web-Applikation.  
Die Anwendung ermöglicht es Benutzer:innen, verlorene Gegenstände zu melden, gefundene Items zu erfassen und Kontaktanfragen zu verwalten.  
Zusätzlich beinhaltet das Projekt eine einfache Benutzerverwaltung mit JWT-Authentifizierung.

Das Projekt basiert auf **Quarkus**, dem Supersonic Subatomic Java Framework.  
Weitere Infos: https://quarkus.io

---

## 🚀 Features

### ✔ Benutzerverwaltung
- Signup inkl. Passwort-Hashing (BCrypt)
- Rollenvergabe:
  - **Admin** → Name = „Noah Burren“
  - **User** → alle anderen
- Login via JWT (SmallRye JWT)

### ✔ Kategorien
- Kategorien abrufen
- Kategorien erstellen

### ✔ Items (found / lost)
- Items erstellen
- Alle Items abrufen

### ✔ Kontaktanfragen
- Kontaktanfragen zu Items erstellen
- Alle Kontaktanfragen abrufen

### ✔ Authentifizierung & Autorisierung
- Login-Endpoint → JWT
- Rollenvalidierung via `@RolesAllowed`
- Swagger-UI unterstützt JWT-Bearer Tokens

---

## 🧪 REST-API Übersicht (Swagger UI)

Teste alle Endpoints direkt unter:

http://localhost:8080/q/swagger-ui


---

## 🔑 Wichtige Endpunkte

| Endpunkt | Methode | Beschreibung | Auth |
|----------|---------|--------------|------|
| `/auth/login` | POST | Login, gibt JWT Token zurück | ❌ |
| `/users/signup` | POST | Registriert neuen User | ❌ |
| `/users` | GET | Gibt alle User zurück | ✔ Admin |
| `/users/email/{email}` | GET | Findet User nach Email | Admin |
<<<<<<< HEAD
| `/items` | GET | Alle Items abrufen | ✔ Admin & User |
=======
| `/items` | GET | Alle Items abrufen | ✔ Admin & ✔ User |
>>>>>>> 4b4d7983c9b8d3fdbbd79f2e6f07e38087062c92
| `/items` | POST | Neues Item erstellen | ✔ Admin & User |
| `/categories` | GET | Kategorien abrufen | ✔ Admin & User |
| `/categories` | POST | Kategorie erstellen | ✔ Admin & User |
| `/contact-requests` | GET | Alle Kontaktanfragen abrufen | ✔ Admin & User |
| `/contact-requests` | POST | Neue Kontaktanfrage erstellen | ✔ Admin & User |

---

## 🖥 Anwendung starten

Dev-Mode mit Live-Reload:

```bash
./mvnw quarkus:dev$
```
Dev-UI:

```bash
./mvnw quarkus:dev
```
Build (JAR)
```bash
./mvnw package
```
Run:
```bash
java -jar target/quarkus-app/quarkus-run.jar
```
---

## 🛠 Technologien
- Java 21
- Quarkus
- RESTEasy Reactive
- Hibernate ORM Panache
- SmallRye JWT
- OpenAPI
- PostgreSQL
- Docker / DevContainer
- BCrypt Passwort-Hashing
---

## 🧪 Testdaten (Seeder)

Beim Start werden automatisch folgende Testbenutzer erstellt:

| Name         | Email             | Passwort | Rolle |
|--------------|-------------------|----------|--------|
| Noah Burren  | noah@example.com  | 1234     | Admin  |
| Levi Fuchs   | levi@example.com  | 1234     | User   |
| Random Dude  | random@example.com| 1234     | User   |

## 🧪 Unit-Test Fälle für UserService / AuthService

| Name des Tests | Parameter | Erwartetes Resultat |
|----------------|-----------|----------------------|
| signup_shouldCreateAdminForNoah | name = "Noah Burren", email, password | User wird mit Rolle **Admin** erstellt |
| signup_shouldCreateNormalUser | name ≠ "Noah Burren", email, password | User wird mit Rolle **User** erstellt |
| signup_shouldHashPassword | name, email, password="1234" | Gespeichertes Passwort ist **nicht** "1234", sondern ein BCrypt-Hash |
| login_shouldReturnTokenForValidCredentials | email + korrektes Passwort | JWT Token wird zurückgegeben |
| login_shouldFailForInvalidPassword | email + falsches Passwort | 401 Invalid password |
| login_shouldFailForUnknownEmail | email nicht in DB | 401 User not found |
