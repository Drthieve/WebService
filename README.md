# Web Service (REST & SOAP)

Projet JAX-RS et JAX-WS REST et SOAP E-Commerce Web Service.

# 📦 Fonctionnalités
Ce service web offre un large éventail de fonctionnalités, notamment :

-Filtrage
-CRUD
-Gestion d'exceptions personnalisées
-Support SOAP 1.2

# ⚙ Technologies used
* JAX-RS (Jersey : Framework Java pour les services web RESTful.)
* JAX-WS (Metro : Framework Java pour les services web SOAP.)
* JSON-B : API Java pour mapper des objets Java en JSON
* JAX-B : API Java pour la liaison de données entre des documents XML et des objets Java.
* Maven : Déploiement de logiciels Java.
* Tomcat : Serveur web et de conteneur de servlets
* Intellij IDEA Ultimate
* SOAP-UI

# 🛠 Exécuter avec Maven

Pour exécuter le service web :

Modifier la configuration de Tomcat dans pom.xml.
Déployer l'application en utilisant la commande Maven suivante :

```
mvn install
mvn clean compile tomcat:redeploy

```
Pour utiliser l'API RESTful, assurez-vous de modifier la variable {{host}} dans les variables d'environnement de la collection Postman pour correspondre au port choisi pour votre déploiement Tomcat.
Pour l'utilisation de l'API SOAP, importez le projet dans SOAP UI.

**MySQL**

Créez un schéma de base de données et fournissez le nom d'utilisateur et le mot de passe dans persistence.xml.
Exécutez DatabasePopulator.java pour peupler la base de données avec des données de test.

👷‍♂️ Contributeurs
Ce projet est rendu possible grâce à la contribution de :
-Youssef SOUISSI
-Shems BAHRI
