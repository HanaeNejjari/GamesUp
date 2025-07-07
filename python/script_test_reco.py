import requests

# Base URL
BASE_URL = "http://my-spring-boot-app:8000"

# Entraînement du modèle
print(">> Entraînement du modèle...")
train_payload = {
    "interactions": [
        {"user_id": 1, "game_id": 101, "rating": 4.5},
        {"user_id": 1, "game_id": 102, "rating": 5.0},
        {"user_id": 1, "game_id": 103, "rating": 3.0},
        {"user_id": 2, "game_id": 101, "rating": 4.0},
        {"user_id": 2, "game_id": 104, "rating": 4.5},
        {"user_id": 2, "game_id": 105, "rating": 2.5},
        {"user_id": 3, "game_id": 103, "rating": 5.0},
        {"user_id": 3, "game_id": 106, "rating": 3.5},
        {"user_id": 3, "game_id": 107, "rating": 4.0}
    ]
}
response = requests.post(f"{BASE_URL}/train", json=train_payload)
print(response.status_code, response.json())

print(">> Recommandations pour l'utilisateur 1...")
recommendation_payload = {
    "user_id": 1,
    "purchases": [
        {"game_id": 101, "rating": 4.5},
        {"game_id": 102, "rating": 5.0},
        {"game_id": 103, "rating": 3.0}
    ]
}
response = requests.post(f"{BASE_URL}/recommendations/?save_purchase=false", json=recommendation_payload)
print(response.status_code, response.json())
