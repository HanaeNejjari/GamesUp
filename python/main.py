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
from fastapi import FastAPI, HTTPException
from fastapi.middleware.cors import CORSMiddleware

from knn_model import train_model
from models import UserData, UserPurchase, TrainingData, TrainingResponse
from recommendation import generate_recommendations
from schemas import RecommendationsResponse
from spring_client import send_purchase_to_spring

# Initialize the FastAPI app
app = FastAPI(debug=True)


# Define the API endpoints
@app.get("/")
async def root():
    return {"message": "API de recommandation en ligne"}


# Add health check endpoint
@app.get("/health")
async def health_check():
    return {"status": "ok"}


# Retourne jusqu'à 5 recommandations pour un utilisateur
@app.post(
    "/recommendations/",
    response_model=RecommendationsResponse,
    summary="Retourne jusqu'à 5 recommandations pour un utilisateur"
)
async def get_recommendations(data: UserData, save_purchase: bool = False):
    try:
        recs = generate_recommendations(data)

        if save_purchase:
            send_purchase_to_spring(
                user_id=data.user_id,
                purchases=[UserPurchase(game_id=r.game_id, rating=r.estimated_score) for r in recs]
            )

        return RecommendationsResponse(recommendations=recs)
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))


# entraîne le modèle KNN
@app.post("/train", response_model=TrainingResponse, summary="Entraîne le modèle KNN")
async def train(data: TrainingData):
    try:
        train_model(data)
        return TrainingResponse(message="Modèle KNN entraîné avec succès (simulation)")
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))


# CORS config
app.add_middleware(
    CORSMiddleware,
    allow_origins=["http://my-spring-boot-app:8080"],
    allow_methods=["*"],
    allow_headers=["*"],
)
