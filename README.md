# 🖨️ Impression Pro - Online Printing Platform

## 📌 Description

**Impression Pro**

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

Lancer le frontend :


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



La base de données utilisée est :

Supabase PostgreSQL

Tables principales :

User
Order
Document

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
