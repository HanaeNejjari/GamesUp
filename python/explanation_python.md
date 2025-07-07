# GameUp - API de recommandation (FastAPI)

Cette API Python a été développée dans le cadre du projet GamesUp. Elle fournit des recommandations de jeux à partir des
interactions passées des utilisateurs, en utilisant un algorithme KNN simple.

## Objectifs

- Fournir un système de recommandations personnalisées pour les utilisateurs du site GamesUp.
- Implémenter une API REST avec FastAPI, prête à être utilisée par une application Spring.
- Permettre l'entraînement d'un modèle KNN à partir de données structurées.
- Conteneuriser l'application pour un déploiement simplifié.

## Fonctionnalités

- Endpoint `/` : vérifie que l’API est en ligne.
- Endpoint `/health` : check technique pour communication avec d'autres services.
- Endpoint `/recommendations` (POST) : retourne des recommandations pour un utilisateur donné.
- Endpoint `/train` (POST) : permet d’entraîner le modèle KNN à partir de données utilisateur-jeu.
- Structure de projet organisée selon les bonnes pratiques (modularité, SOLID).
- Support de Docker et Docker Compose.

## Structure du projet

- requirements.txt : Liste des dépendances Python nécessaires au projet.
- schemas.py : Définit les schémas de données (par exemple, Recommendation, RecommendationsResponse) utilisés pour la
  validation et la structuration des données.
- spring_client.py : Contient la fonction send_purchase_to_spring pour communiquer avec un service externe (probablement
  Spring Boot).
- knn_model.py : Implémente les fonctions liées au modèle KNN, comme get_recommendations_for_user et train_model, pour
  la recommandation.
- main.py : Point d’entrée principal de l’application, avec les routes API (get_recommendations, health_check, root,
  train).
- script_test_reco.py : Script de test pour les recommandations.
- exemple_data.csv : Fichier de données d’exemple, probablement utilisé pour l’entraînement ou les tests.
- models.py : Définit les modèles de données utilisés dans l’application (Interaction, Recommendation,
  RecommendationsResponse, TrainingData, UserData, UserPurchase).
- data_loader.py : Contient la fonction load_training_data pour charger les données d’entraînement.
- readme.md : Documentation du projet.
- Dockerfile : Fichier de configuration pour la création d’une image Docker.
- recommendation.py : Contient la logique pour générer des recommandations (fonction generate_recommendations).

