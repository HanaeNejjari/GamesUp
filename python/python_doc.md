# Documentation des modules Python de GameUp

---

## `main.py`

```python
"""
main.py

API FastAPI pour le système de recommandation GameUp.

Endpoints :
- GET / : Vérifie que l’API est en ligne.
- GET /health : Check technique pour la communication avec d'autres services.
- POST /recommendations/ : Retourne jusqu'à 5 recommandations pour un utilisateur donné.
- POST /train : Entraîne le modèle KNN à partir de données utilisateur-jeu.

CORS activé pour l’application Spring Boot.
"""
```

---

## `recommendation.py`

```python
"""
recommendation.py

Contient la fonction principale pour générer les recommandations à partir des données utilisateur.

Fonctions :
- generate_recommendations(user_data: UserData) -> List[Recommendation]
    Appelle le modèle KNN pour obtenir les recommandations brutes (des dicts),
    puis les convertit en objets Recommendation pour correspondre au schéma.
"""
```

---

## `knn_model.py`

```python
"""
knn_model.py

Implémente le modèle KNN pour la recommandation de jeux.

Fonctions :
- train_model(training_data: TrainingData)
    Entraîne le modèle KNN à partir des interactions utilisateur-jeu.
    Stocke le modèle et la matrice utilisateur-jeu.

- get_recommendations_for_user(user_data: UserData) -> List[dict]
    Retourne les 5 meilleures recommandations pour un utilisateur donné,
    en se basant sur les utilisateurs les plus proches (KNN).
"""
```

---

## `models.py`

```python
"""
models.py

Définit les modèles de données utilisés dans l’application.

Classes :
- TrainingResponse : Réponse pour l'entraînement du modèle.
- UserPurchase : Achat utilisateur (game_id, rating).
- UserData : Données utilisateur (user_id, achats).
- Interaction : Interaction utilisateur-jeu (user_id, game_id, rating).
- TrainingData : Données d'entraînement (liste d'interactions).
- Recommendation : Recommandation (game_id, estimated_score).
- RecommendationsResponse : Réponse contenant une liste de recommandations.
"""
```

---

## `schemas.py`

```python
"""
schemas.py

Définit les schémas de données pour la validation et la structuration des réponses API.

Classes :
- Recommendation : Schéma d'une recommandation (game_id, estimated_score).
- RecommendationsResponse : Schéma d'une réponse contenant une liste de recommandations.
"""
```

---

## `data_loader.py`

```python
"""
data_loader.py

Fonction utilitaire pour charger les données d'entraînement à partir d'un fichier CSV.

Fonctions :
- load_training_data(file_path) -> pd.DataFrame
    Charge un fichier CSV contenant les données d'utilisateur, jeux, etc.
"""
```

---

## `spring_client.py`

```python
"""
spring_client.py

Permet de communiquer avec le backend Spring Boot pour enregistrer des achats.

Constantes :
- SPRING_API_URL : URL de l’API Spring pour l’enregistrement des achats.

Fonctions :
- send_purchase_to_spring(user_id: int, purchases: List[UserPurchase])
    Envoie les achats d’un utilisateur à l’API Spring Boot sous forme de payload JSON.
"""
```

---

**Remarque** :

- Les modules sont organisés de façon modulaire et respectent les bonnes pratiques Python (séparation des modèles,
  schémas, logique métier, utilitaires).
- Les docstrings peuvent être enrichis avec des exemples d’utilisation ou des descriptions de paramètres pour une
  documentation Sphinx/MkDocs dont je n'ai pas eu le temps de faire.
