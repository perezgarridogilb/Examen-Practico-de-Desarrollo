const express = require("express");

const routes = express.Router();

routes.get("/", (req, res) => {
  let cliente = {
    Nombre: "Juan",
    Apellidos: "Perez Hernandez",
    Nombre_Usuario: "Ju",
    Correo_Electronico: "jperez@hotmail.com",
    Contrasena: "juanitoperez"
  };
  return res.send({ cliente });
});
routes.post("/", (req, res) => {
  let {
    Nombre,
    Apellidos,
    Nombre_Usuario,
    Correo_Electronico,
    Contrasena
  } = req.body;
  console.log(req.body);

  let id = Math.floor(Math.random() * 1000);
  let cliente = {
    Nombre,
    Apellidos,
    Nombre_Usuario,
    Correo_Electronico,
    Contrasena
  };
  return res.send({ CVE_MENSAJE: id, status: "Creado Correctamente", cliente });
});

routes.put("/:id", (req, res) => {
  let ClienteDatos = { Edad: 50, Estatura: 1.8, Peso: 64, GEB: 1500 };
  const ClienteDatosAnt = ClienteDatos;

  let { id } = req.params;
  if (id !== "59") {
    return res.send({ mensaje: "Usuario no encontrado" });
  }
  let { Edad, Estatura, Peso, GEB } = req.body;

  let DatosActualizados = {
    Edad: ClienteDatos.Edad !== Edad ? Edad : ClienteDatos.Edad,
    Estatura:
      ClienteDatos.Estatura !== Estatura ? Estatura : ClienteDatos.Estatura,
    Peso: ClienteDatos.Peso !== Peso ? Peso : ClienteDatos.Peso,
    GEB: ClienteDatos.GEB !== GEB ? GEB : ClienteDatos.GEB
  };

  return res.send({ CVE_MENSAJE: id, ClienteDatosAnt, DatosActualizados });
});

module.exports = routes;
