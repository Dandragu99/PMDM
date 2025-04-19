package com.uax.almacenamiento.dao

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.uax.almacenamiento.database.DBHelper
import com.uax.almacenamiento.model.User

// Este user DAO va a necesitar un contexto
class UserDAO(var context:Context) {
    // Aquí lo que necesito son funciones
    fun insertUser(user: User){
        // Aquí necesitaré la conexion de la base de datos
        val database: SQLiteDatabase = DBHelper(context,"users_db",null,1).writableDatabase
        /* Creo la variable database ¿Que necesito para ello? Pues el DBHelper pero para utilizar el DBHelper
        * le tengo que dar un contexto ya que me lo pide de antes, un nombre, un factory que puede ser null y la version la que sea
        * en principio 1. Pero para la BD tengo dos opciones modo lectura o modo escritura. Writable en esta caso*/




        // Para evitar un inyeccion SQL - lo mejor es utilizar querys parametizadas
        val content: ContentValues = ContentValues()
        content.put("name",user.name)
        content.put("name",user.age)
        database.insert("users",null,content)
        /*Aqui lo que hace es crear una variable de tipo ContentValues la cual cuando haces un insert
        * coge el dato y lo reparte en las idiferentes columnas
        *
        * ¿Cuando quiero llamar a este método?(insertUser)
        * Cuando pulsemos el botón
        * Para poder insertar el usuario necesito ejecutar el método
        * Y para ejecutar el método necesito el userDAO que en su construccion me crea un contexto
        * que me permite llegar a la base de datos. Cogerán los datos de cada uno de los usuario que insert y los
        * meterá en la base de datos. --> Vamos con el mainActivity
        * */
    }
}