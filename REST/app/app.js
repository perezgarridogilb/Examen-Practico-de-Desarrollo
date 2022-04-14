/* ------------------------------------------------------------------------------------------- */
/* -----------------------LIBRERIAS E IMPORTACIONES Y CONFIGURACIONES------------------------- */
const express = require("express");
const bodyparser = require("body-parser");
const {
  rutasprueba
} = require("./routes");
/* ------------------------------------------------------------------------------------------- */
/* ------------------------------------------------------------------------------------------- */
const app = express();

//Codificalo a JSON
app.use(bodyparser.urlencoded({ extended: false }));
app.use(bodyparser.json());

//Para evitar problemas con las peticiones
app.use(function(req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header(
    "Access-Control-Allow-Headers",
    "Origin, X-Requested-With, Content-Type, Accept, Authorization,token_public_conekta"
  );
  res.header(
    "Access-Control-Allow-Methods",
    "GET,PUT,POST,DELETE,PATCH,OPTIONS"
  );

  next();
});

//* RUTAS A USARSE */
app.use("/NutriNET/Cliente/", rutasprueba);


module.exports = app;
