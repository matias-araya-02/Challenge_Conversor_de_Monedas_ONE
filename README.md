# Convertidor de Monedas 💰💵

Este proyecto es un convertidor de monedas que permite realizar conversiones entre diferentes divisas utilizando la API de [Exchangerate-API](https://www.exchangerate-api.com/). Para utilizarlo, debes obtener una API KEY registrándote en el sitio web. Una vez obtenida, puedes ingresar tu API KEY y comenzar a realizar conversiones de divisas entre USD, ARS y CLP.

## 🖥️ Instalación Local

1. Clonar o Descargar Proyecto:
   - [Descargar aquí](https://github.com/matias-araya-02/Challenge_Conversor_de_Monedas_ONE/archive/refs/heads/main.zip)

2. Abrir el proyecto en tu IDE preferido (IntelliJ IDEA u otro).

## 📂 Estructura del Proyecto

- 📄 `src/main/java/Main.java`: Clase principal que gestiona el flujo del programa y las opciones del menú.
- 📄 `src/main/java/BusquedaMoneda.java`: Clase encargada de hacer las solicitudes HTTP a la API de Exchangerate para obtener las tasas de cambio.
- 📄 `src/main/java/MonedaOmdb.java`: Clase que modela la respuesta de la API con las tasas de cambio.

## 🌐 Uso del Programa

1. **Agregar Dependencia de Gson**:
   - Debes agregar la librería Gson a tu proyecto. Puedes descargarla desde [aquí](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.10.1) en formato .jar.
   - Una vez descargado, agrégalo a tu proyecto en el módulo correspondiente:
      - Ve a `Dependencies` y agrega el archivo .jar descargado.

2. El programa solicita la API KEY para acceder a la API de Exchangerate.
3. Permite elegir entre las siguientes conversiones de divisas:
   - Dólar (USD) a Peso Argentino (ARS).
   - Dólar (USD) a Peso Chileno (CLP).
   - Peso Argentino (ARS) a Dólar (USD).
   - Peso Argentino (ARS) a Peso Chileno (CLP).
   - Peso Chileno (CLP) a Dólar (USD).
   - Peso Chileno (CLP) a Peso Argentino (ARS).
4. El usuario ingresa el monto a convertir, y el programa realiza la conversión con la tasa de cambio actual obtenida de la API.
5. Si la API no puede proporcionar la tasa de cambio solicitada, se muestra un mensaje de error.


## ⚠️ Validaciones

El programa realiza varias validaciones antes de ejecutar una conversión:
- Verifica si el usuario ingresó una opción de menú válida.
- Verifica que el monto ingresado para la conversión sea un número válido.
- Si la API no proporciona una tasa de cambio para la combinación de monedas seleccionadas, el programa genera un error específico indicando la falta de datos.

## 🧰 Tecnologías Implementadas

* [![Java 17](https://img.shields.io/badge/Java_17-007396?style=flat&logo=java&logoColor=white)](https://www.oracle.com/java/) *(Lenguaje de programación utilizado)*
* [![Gson](https://img.shields.io/badge/Gson-ff9800?style=flat&logo=google&logoColor=white)](https://github.com/google/gson) *(Librería para serializar y deserializar JSON)*
* [![Exchangerate-API](https://img.shields.io/badge/Exchangerate_API-0071C5?style=flat&logo=cashapp&logoColor=white)](https://www.exchangerate-api.com/) *(API utilizada para obtener las tasas de cambio en tiempo real)*

## 🟠 Uso de Postman

<p align="center">
  <img src="https://upload.wikimedia.org/wikipedia/commons/c/c2/Postman_%28software%29.png" alt="Postman Logo" width="400"/>
</p>

## 🧪 Uso de Postman para Probar la API

Puedes usar [Postman](https://www.postman.com/) para probar las solicitudes a la API de Exchangerate y ver las respuestas de forma clara. A continuación, te explico cómo hacerlo:

### Pasos para Consultar la API en Postman:

1. **Abrir Postman**: Si aún no lo tienes instalado, puedes descargarlo desde [aquí](https://www.postman.com/downloads/).

2. **Crear una nueva solicitud HTTP**:
   - Haz clic en **"New"** y selecciona **"HTTP Request"**.

3. **Elegir el método HTTP**:
   - Selecciona el método `GET` en el desplegable de métodos HTTP, ya que solo necesitas obtener las tasas de cambio actuales.

4. **Definir la URL**:
   - En el campo de la URL, introduce la siguiente dirección:
     ```
     https://v6.exchangerate-api.com/v6/TU_API_KEY/latest/USD
     ```
   - Reemplaza `TU_API_KEY` por la clave de tu API que obtuviste al registrarte en [Exchangerate-API](https://www.exchangerate-api.com/).
   - Este ejemplo consulta las tasas de cambio con el **USD (Dólar Estadounidense)** como divisa base. Si quisieras cambiar la divisa base, puedes modificar el último parámetro (`USD`) por la moneda deseada (por ejemplo, `ARS` para Peso Argentino o `CLP` para Peso Chileno).

5. **Enviar la solicitud**:
   - Haz clic en **"Send"** para enviar la solicitud a la API.
   
6. **Ver la respuesta**:
   - En la sección de respuesta, verás un JSON con la información de las tasas de cambio actuales. La estructura típica de la respuesta es la siguiente:
     ```json
        {
          "result": "success",
          "documentation": "https://www.exchangerate-api.com/docs",
          "terms_of_use": "https://www.exchangerate-api.com/terms",
          "time_last_update_utc": "Sat, 19 Oct 2024 00:00:02 +0000",
          "base_code": "USD",
          "conversion_rates": {
            "USD": 1,
            "CLP": 943.7214,
            "ARS": 983.83
             ...
          }
        }
     ```
   - Aquí puedes ver el valor de conversión de USD a ARS y CLP, entre otras monedas.

### Uso de los Datos en el Proyecto

El programa de conversión de monedas toma esta respuesta JSON y utiliza las tasas de cambio (`conversion_rates`) para convertir entre diferentes divisas. Dependiendo de la conversión seleccionada por el usuario (USD a ARS, ARS a CLP, etc.), se extrae la tasa correspondiente y se realiza la operación.


