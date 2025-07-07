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
from typing import List

from pydantic import BaseModel


class TrainingResponse(BaseModel):
    message: str


# Define the UserPurchase model
class UserPurchase(BaseModel):
    game_id: int
    rating: float


# Define the UserData model
class UserData(BaseModel):
    user_id: int
    purchases: List[UserPurchase]


# Define the Interaction model
class Interaction(BaseModel):
    user_id: int
    game_id: int
    rating: float


# Define the TrainingData model
class TrainingData(BaseModel):
    interactions: List[Interaction]


# Define the Recommendation model
class Recommendation(BaseModel):
    game_id: int
    estimated_score: float


# Define the RecommendationsResponse model
class RecommendationsResponse(BaseModel):
    recommendations: List[Recommendation]
