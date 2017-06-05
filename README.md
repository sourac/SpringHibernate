# SpringHibernate

Here i'm using the spring boot to remove the boilerplate code we usually do when we do the crud operation using hibernate.
Spring boot proviedes us the minimal configuration and maximum code funtionality.

Here i'm doing crud operation and hibernate as a jpa implementation.

application.properties in src/main/resource help us to provide the configuration details easily.

#here SpringBootHibernate is the name of the database used. with the database username and password.
spring.datasource.url=jdbc:mysql://localhost:3306/SpringBootHibernate
spring.datasource.username=root
spring.datasource.password=carinov

#show log for each query
spring.jpa.show-sql=true

#hibernate dll auto (create, create-drop, update)
spring.jpa.hibernate.ddl-auto=update

server.port=84

Download the project and import as maven project.
Then Do maven clean and install.
Also In your mysql create a database named "SpringBootHibernate".
and provide the username and password for the connection.
just like mentioneda above in the file.
