# GameUp - Guide de démarrage

## Prérequis

- **Docker** doit être installé sur votre machine.
  - [Installer Docker Desktop (Windows/Mac)](https://www.docker.com/products/docker-desktop/)
  - [Installer Docker Engine (Linux)](https://docs.docker.com/engine/install/)

## Démarrage du projet

### Sous Windows

1. Ouvrez un terminal (cmd ou PowerShell).
2. Placez-vous dans le dossier du projet GameUp.
3. Exécutez le script :
   ```
   start.bat
   ```

### Sous Linux/Unix/Mac

1. Ouvrez un terminal.
2. Placez-vous dans le dossier du projet GameUp.
3. Rendez le script exécutable si besoin :
   ```sh
   chmod +x start.sh
   ```
4. Exécutez le script :
   ```sh
   ./start.sh
   ```

## Ce que fait le script

- Il lance les conteneurs Docker nécessaires (backend Java Spring Boot, API Python de recommandation, etc.).
- Il s’assure que tous les services sont accessibles pour le développement ou les tests.

## Remarques

- Assurez-vous que les ports requis (ex : 8080 pour Spring Boot, 8000 pour FastAPI) sont libres.
- Pour arrêter les services, arrêtez les conteneurs via Docker Desktop ou depuis le terminal Docker.

---

Pour toute question, consultez la documentation du projet ou n'hésitez à me contacter.
