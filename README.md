# Online E-commerce Web Service (REST & SOAP)

Bienvenue dans le projet JAX-RS et JAX-WS REST et SOAP E-Commerce Web Service ! Ce projet vise à fournir un service web robuste pour les opérations de commerce électronique, en offrant à la fois des fonctionnalités RESTful et SOAP.

# 🏛 Architecture
Ce projet suit une architecture en couches pour assurer la modularité et la maintenabilité. Il utilise à la fois JAX-RS et JAX-WS pour fournir des interfaces d'API RESTful et SOAP qui sont des présentations différentes de la même couche de service principale.

#📦 Fonctionnalités
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

Si vous utilisez une base de données MySQL :

Créez un schéma de base de données et fournissez le nom d'utilisateur et le mot de passe dans persistence.xml.
Hibernate créera automatiquement les tables pour vous.
Exécutez DatabasePopulator.java pour peupler la base de données avec des données de test.

👷‍♂️ Contributeurs
Ce projet est rendu possible grâce à la contribution de :
-Youssef SOUISSI
-Shems BAHRI
