# 🖨️ Impression Pro - Online Printing Platform

## 📌 Description

**Impression Pro** est un prototype de plateforme web d'impression en ligne développé dans le cadre d'un test technique Full Stack.

Fonctionnalités principales :

- ✅ Authentification utilisateur avec JWT
- ✅ Upload de fichiers PDF
- ✅ Détection automatique du nombre de pages
- ✅ Stockage PDF avec Supabase Storage
- ✅ Choix du mode d'impression (Noir & Blanc / Couleur)
- ✅ Calcul automatique du prix
- ✅ Création et gestion des commandes


---

# 🎥 Démonstration

Vidéo de démonstration :

➡️ Ajouter votre lien vidéo ici


---

# 🏗️ Architecture Git



Impression-Projet

│
├── main
│ └── README.md
│
├── Front
│ └── Angular Application
│
└── BackEnd
└── Spring Boot Application



---

# 🌐 Frontend (Branch Front)

Application développée avec :

- Angular
- TypeScript
- Angular Material
- Reactive Forms
- HTTP Client
- CSS Responsive


Fonctionnalités :

- Page connexion
- Upload PDF
- Affichage nombre de pages
- Choix impression
- Calcul prix automatique
- Validation commande
- Notifications utilisateur


Lancer le frontend :


```bash
git checkout Front

npm install

ng serve

Application :

http://localhost:4200
⚙️ Backend (Branch BackEnd)

API REST développée avec :

Java 17
Spring Boot
Spring Security
JWT Authentication
Spring Data JPA
Hibernate
PostgreSQL
Supabase

Lancer le backend :

git checkout BackEnd

mvn spring-boot:run

API :

http://localhost:8080
🗄️ Base de données

La base de données utilisée est :

Supabase PostgreSQL

Tables principales :

User

Gestion des utilisateurs :

id
email
password
Document

Gestion des fichiers PDF :

id
fileName
filePath
pages
user_id
Order

Gestion des commandes :

id
mode
price
document_id
user_id
📂 Stockage PDF

Les fichiers PDF sont stockés avec :

Supabase Storage

Workflow :

Utilisateur

    ↓

Upload PDF

    ↓

Spring Boot API

    ↓

Supabase Storage

    ↓

URL enregistrée dans PostgreSQL

Informations sauvegardées :

Nom du fichier
URL du document
Nombre de pages
Utilisateur propriétaire
🔐 Authentification

Sécurité basée sur :

JWT (JSON Web Token)

Processus :

Login utilisateur

        ↓

Validation email/password

        ↓

Génération JWT Token

        ↓

Accès aux routes protégées

Les mots de passe sont sécurisés avec :

BCrypt Password Encoder
🖨️ Gestion des commandes

Tarification :

Mode	Prix
Noir & Blanc	0.20 DH / page
Couleur	1 DH / page

Exemple :

5 pages couleur

5 × 1 DH = 5 DH
🔌 API principales
Authentication

Inscription :

POST /api/auth/register

Connexion :

POST /api/auth/login
Documents

Upload PDF :

POST /api/files/upload
Orders

Créer une commande :

POST /api/orders
