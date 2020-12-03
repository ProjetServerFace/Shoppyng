# Project Shoppyng

Site d'achat Vente en ligne

Le but du projet et de mettre entre place une application simple de gestion de panier en rajoutant l'authentification afin de pouvoir récupérer l'utilisateur qui a créer le panier. sans utilisation de base de donnes.


### Choix techniques

Dans ce projet nous avons utilisé les technologies suivantes : 

* [Spring Boot] : Permet de simplifier le démarrage, le développement et le déploiement des applications Spring (Contient un serveur embarqué [Tomcat]).
* [Spring Security] : Framework de sécurité léger qui fournit une authentification et un support d’autorisation afin de sécuriser les applications Spring.

### Compilation et exécution

Pour compiler le projet
```sh
mvn clean install
```

Dans ce projet les tests pouvait pointer vers une BD embarqué de test initialisé via flyway par exemple. 
Etant donnes qu'on ne peut pas utiliser de BD, des class Mock ont était mis en place

J'ai mis en place des
 * tests d'intégration 
 * Test Unitaire : Comme complement des tests d'integration.

ça serait intéréssant aussi de mettre en place des tests fonctionnel (Cucumber) que je vais rajouter dans une autre version


[Spring Security]:https://spring.io/projects/spring-security
[Spring Boot]:http://projects.spring.io/spring-boot/
