# Inventario API

Servicio REST para la gestión de inventario y cálculo de depreciación de activos de una compañía.

---

## Tecnologías utilizadas

- Java 21
- Spring Boot 3
- Maven
- Base de Datos H2 (en memoria)
- OpenAPI 3 + Swagger UI
- Docker
- Docker Compose
- Kubernetes (Minikube)

---

## Clonar el proyecto

```bash
git clone https://github.com/dicahica/inventario.git
cd inventario
```

Ejecución en ambiente local
Prerequisitos:
Java 21 instalado

Maven instalado

Construcción y ejecución:
```bash
mvn clean install
mvn spring-boot:run
```
Accesos importantes:
Swagger UI → http://localhost:8080/swagger-ui.html

H2 Console → http://localhost:8080/h2-console

Nota:
Para acceder a la consola H2:

JDBC URL: jdbc:h2:mem:testdb

Username: sa

Sin password

Instalación de Docker (si no lo tienes)
Windows:
Descargar e instalar Docker Desktop desde: https://www.docker.com/products/docker-desktop

Linux:

```bash
sudo apt-get update
sudo apt-get install docker.io
sudo systemctl start docker
sudo systemctl enable docker
```
Verificar versión:

```bash
docker --version
```
Ejecución con Docker
Prerequisitos:
Docker instalado

Construir la imagen Docker
```bash
docker build -t dicahica/inventario:latest .
```
Ejecutar contenedor
```bash
docker run -p 8080:8080 dicahica/inventario:latest
```
Accesos desde contenedor:
Swagger UI → http://localhost:8080/swagger-ui.html

H2 Console → http://localhost:8080/h2-console

Despliegue en Kubernetes
Prerequisitos:
Minikube o un cluster Kubernetes configurado

kubectl instalado y configurado

Crear los recursos Kubernetes:
```bash
kubectl apply -f k8s/deployment.yaml
kubectl apply -f k8s/service.yaml
```
Verificar los pods:
```bash
kubectl get pods
```
Obtener la URL pública (si usas Minikube):
```bash
minikube service inventario-service --url
```
Accede luego a:

Swagger UI → URL-OBTENIDA/swagger-ui.html

H2 Console → URL-OBTENIDA/h2-console