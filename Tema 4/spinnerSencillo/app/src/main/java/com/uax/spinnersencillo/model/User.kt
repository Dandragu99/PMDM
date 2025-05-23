package com.uax.spinnersencillo.model

import java.io.Serializable
// Paso 12: Dentro damos valores y lo tipamos como Serializable
// Paso 13: En en el Login
class User(var mail: String, var pass: String): Serializable