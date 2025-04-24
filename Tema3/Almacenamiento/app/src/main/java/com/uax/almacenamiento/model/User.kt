package com.uax.almacenamiento.model

/*Este es el modelo, esto es con lo que voy a trbajar
* Cada modelo, necesita una clase asociada a el: Que se va a encargar de hacer transacciones con la
* base de datos, delete insert upgrade
*
* Y para ello voy a crear un DAO- Data Acces Operation
* Todas las operaciones de la base de datos.
* */

class User(var name : String, var age: Int)
