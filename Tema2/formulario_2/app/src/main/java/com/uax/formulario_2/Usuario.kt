package com.uax.formulario_2

import java.io.Serializable

// El serializable sirve para que no vaya todo en conjunto sino que primero se haga el correo
// y luego la contraseña
class Usuario (var correo: String, var pass: String) : Serializable
