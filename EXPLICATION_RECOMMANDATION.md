# Mise en place du système de recommandation dans GameUp

## 1. Fichiers référencés et leur rôle

| Fichier / Dossier                                       | Rôle                                                                                      |
|---------------------------------------------------------|-------------------------------------------------------------------------------------------|
| `src/main/java/org/nejjari/hanae/gameup/entity/`        | Entités JPA représentant les tables de la base de données (ex : `GameEntity`).            |
| `src/main/java/org/nejjari/hanae/gameup/dto/`           | DTOs (Data Transfer Objects) pour l’échange de données entre couches.                     |
| `src/main/java/org/nejjari/hanae/gameup/mapper/`        | Mappers pour convertir entités <-> DTOs.                                                  |
| `src/main/java/org/nejjari/hanae/gameup/repository/`    | Interfaces Spring Data JPA pour l’accès aux données (ex : `GameRepository`).              |
| `src/main/java/org/nejjari/hanae/gameup/business/`      | Logique métier (services, ex : `GameService`, `UserService`, etc.).                       |
| `src/main/java/org/nejjari/hanae/gameup/web/`           | Contrôleurs REST exposant les endpoints de l’application.                                 |
| `python/recommendation.py`                              | Fonction principale pour générer les recommandations à partir des données utilisateur.     |
| `python/knn_model.py` *(présumé opération et entrainé)* | Logique du modèle KNN pour calculer les recommandations.                                  |
| `python/models.py`, `python/schemas.py`                 | Schémas de données (UserData, Recommendation) utilisés dans le système de reco.           |
| `src/test/resources/train.json`                         | Données d’entraînement : interactions utilisateur-jeu (user_id, game_id, rating).         |
| `exemple_data.csv` *(présumé vrai)*                     | Exemples de données pour tests ou entraînement.                                           |
| `pom.xml`                                               | Fichier de configuration Maven : dépendances, plugins, gestion du build et des tests.      |
| `*.plantuml`                                            | Diagrammes UML (architecture, séquence, classes, etc.) pour documenter le projet.         |
| `Dockerfile` (Java & Python)                            | Conteneurisation des applications Java et Python pour faciliter le déploiement et l'intégration. |

---

## 2. Explication du fonctionnement

1. **Collecte et gestion des données**  
   - Les entités Java (ex : `GameEntity`, `UserEntity`) modélisent la base de données.
   - Les repositories (ex : `GameRepository`) permettent d’accéder aux données via Spring Data JPA.
   - Les DTOs (ex : `PurchaseDto`) servent à transférer les données entre la couche métier et la couche web.
   - Les interactions utilisateurs-jeux sont stockées dans `train.json` pour alimenter le moteur de recommandation.

2. **Logique métier et exposition**  
   - Les services (ex : `GameService`, `UserService`) orchestrent la logique métier et appellent les repositories.
   - Les mappers convertissent les entités en DTOs et inversement.
   - Les contrôleurs REST exposent les endpoints pour interagir avec le frontend ou d’autres systèmes.

3. **Système de recommandation**  
   - Le backend Java peut appeler le module Python (via REST, subprocess, etc.) pour obtenir des recommandations personnalisées.
   - Le module Python utilise un modèle KNN pour proposer des jeux pertinents à l’utilisateur.

4. **Documentation et architecture**  
   - Les fichiers `.plantuml` servent à générer des diagrammes UML pour documenter l’architecture, les flux de données, les séquences d’appel, etc.
   - De même pour les fichiers api.json qui contiennent les api complétes dans un format open source, récupérer depuis les swaggers des deux back séparément.
   - De plus, les fichiers de couverture, de rapports de tests et aussi de la documentation des sources au format Javadoc. pour Java et au format markdown pour Python.

5. **Conteneurisation et déploiement**  
   - Les deux `Dockerfile` permettent de conteneuriser séparément l’application Java (Spring Boot) et le service Python de recommandation, facilitant ainsi le déploiement, l’intégration et la scalabilité via Docker Compose ou Kubernetes.

6. **Gestion des dépendances et du build**  
   - Le fichier `pom.xml` gère toutes les dépendances Java (Spring Boot, JPA, Lombok, etc.), les plugins de build, et la configuration des tests.

---

## 3. Bonnes et mauvaises pratiques

### Bonnes pratiques

- **Architecture en couches** : séparation claire entre entités, repositories, services, mappers, contrôleurs.
- **Utilisation de Spring Data JPA** : facilite l’accès aux données et la maintenance.
- **DTOs et mappers** : évitent l’exposition directe des entités et facilitent l’évolution du modèle.
- **Tests présents** : dossiers de test et ressources d’entraînement versionnées.
- **Gestion centralisée des dépendances** : via `pom.xml` pour Java et `requirements.txt` pour Python.
- **Documentation JavaDoc** et **diagrammes UML** : facilitent la compréhension et la maintenance.
- **Utilisation de fichiers `.plantuml`** : permet de générer et maintenir à jour la documentation technique.
- **Conteneurisation** : les `Dockerfile` assurent la portabilité et la reproductibilité des environnements.

### Mauvaises pratiques ou points d’amélioration

- **Couplage Java/Python** : l’intégration doit être bien encapsulée (API REST dédiée recommandée).
- **Validation des données** : s’assurer que la validation est robuste côté Java (DTOs, contrôleurs) et Python.
- **Automatisation des tests** : renforcer la couverture de tests, notamment pour la partie recommandation (coté Python).
- **Gestion des erreurs et logs** : à surveiller lors des appels inter-langages.
- **Sécurité** : attention à la sécurisation des endpoints et des échanges inter-systèmes.
- **Mise à jour de la documentation UML** : veiller à ce que les fichiers `.plantuml` reflètent bien l’état du code.
- **Optimisation des images Docker** : s’assurer que les Dockerfile produisent des images légères et sécurisées.

---

## 4. Respect des principes SOLID

| Principe | Respecté ? | Explication |
|----------|------------|-------------|
| **S** (Single Responsibility) | ✅ | Chaque classe/module a une responsabilité claire (entité, service, mapper, etc.). |
| **O** (Open/Closed)           | 🟡 | Les services et repositories sont ouverts à l’extension, mais l’intégration reco pourrait être mieux abstraite. |
| **L** (Liskov Substitution)   | ✅ | Les interfaces (SuperRepository, SuperMapper) permettent la substitution sans effet de bord. |
| **I** (Interface Segregation) | ✅ | Les interfaces sont spécifiques et non surchargées. |
| **D** (Dependency Inversion)  | 🟡 | L’appel au moteur de reco Python pourrait être abstrait via une interface Java (ex : `RecommendationService`). |

---

## 5. Conseils et bonnes pratiques pour la suite

- **Automatiser les tests** pour toutes les couches, y compris la recommandation (coté python).
- **Documenter l’architecture d’intégration** Java/Python (README, diagramme `.plantuml`).
- **Gérer les dépendances Python** (`requirements.txt`, environnement virtuel).
- **Prévoir la scalabilité** (base de données, moteur plus performant si besoin).
- **Sécuriser les échanges** entre Java et Python (validation, authentification, gestion des erreurs).
- **Maintenir à jour les diagrammes UML** pour qu’ils reflètent l’architecture réelle du projet.
- **Optimiser les Dockerfile** pour des images plus légères et sécurisées.

---

## Résumé

Le projet GameUp est structuré selon une architecture moderne et modulaire, avec une séparation claire des responsabilités, une bonne utilisation des outils Spring Boot et Python, une documentation technique via JavaDoc et PlantUML, et une conteneurisation facilitant le déploiement. Quelques points d’amélioration subsistent, notamment sur l’intégration Java/Python, la validation des données, l’automatisation des tests, la synchronisation de la documentation UML avec le code, et l’optimisation des images Docker. Les principes SOLID sont globalement respectés, mais l’abstraction de la couche de recommandation pourrait être renforcée pour une meilleure maintenabilité et évolutivité.

