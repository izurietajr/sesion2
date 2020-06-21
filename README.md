# Proyecto LAB 273

Servidor Node seguro

Clonar el repo e instalar las dependencias con el comando `npm install`, iniciar el servidor con el comando `node app.js` e 
ir a `http://localhost:8080` para el servidor http.

Las urls para probar los endpoints se encuantran en el archivo `urls.js`.

Para probar el protocolo https, usar el comando curl con el atributo -k

```
curl -k https://localhost:8443
```

Los pasos seguidos para la creación de los certificados ssl se encuentra en [certificados](./credentials/credentials.md)

