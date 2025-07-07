"""
spring_client.py

Permet de communiquer avec le backend Spring Boot pour enregistrer des achats.

Constantes :
- SPRING_API_URL : URL de l’API Spring pour l’enregistrement des achats.

Fonctions :
- send_purchase_to_spring(user_id: int, purchases: List[UserPurchase])
    Envoie les achats d’un utilisateur à l’API Spring Boot sous forme de payload JSON.
"""
import datetime
from typing import List

import requests

from models import UserPurchase

# 8080
SPRING_API_URL = "http://my-spring-boot-app:8080/purchase"


# 8080
def send_purchase_to_spring(user_id: int, purchases: List[UserPurchase]):
    payload = {
        "line": [
            {
                "utilisateurId": user_id,
                "jeuId": p.game_id,
                "prix": p.rating
            }
            for p in purchases
        ],
        "date": datetime.date.today().isoformat(),
        "paid": False,
        "delivered": False,
        "archived": False
    }

    response = requests.post(SPRING_API_URL, json=payload)
    response.raise_for_status()
