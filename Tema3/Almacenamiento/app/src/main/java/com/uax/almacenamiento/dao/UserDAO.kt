package com.uax.almacenamiento.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.uax.almacenamiento.database.DBHelper
import com.uax.almacenamiento.model.User

// Este user DAO va a necesitar un contexto
class UserDAO(var context:Context) {
    // Aquí lo que necesito son funciones
    fun insertUser(user: User) {
        // Aquí necesitaré la conexion de la base de datos
        val database: SQLiteDatabase = DBHelper(context, "users_db", null, 1).writableDatabase
        /* Creo la variable database ¿Que necesito para ello? Pues el DBHelper pero para utilizar el DBHelper
        * le tengo que dar un contexto ya que me lo pide de antes, un nombre, un factory que puede ser null y la version la que sea
        * en principio 1. Pero para la BD tengo dos opciones modo lectura o modo escritura. Writable en esta caso*/


        // Para evitar un inyeccion SQL - lo mejor es utilizar querys parametizadas
        val content: ContentValues = ContentValues()
        content.put("name", user.name)
        content.put("name", user.age)
        database.insert("users", null, content)
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
    fun deleteUser(name: String) {
        val database: SQLiteDatabase = DBHelper(context, "users_db", null, 1).writableDatabase
        // Me creo la base de datos, en modo escritura(wirtable) porque quiero escribir para borrar
        /*DELETE FROM usuario WHERE adads =?
        * */
        database.delete("users","name=?", arrayOf(name))
    }
    fun updateUser(name: String) {
        val database: SQLiteDatabase = DBHelper(context, "users_db", null, 1).writableDatabase

        val content: ContentValues = ContentValues()
        content.put("name","NombreNuevo")
        // UPDATE user SET nombre = NombreNuevo WHERE name = Dani
        database.update("users",content,"name=?", arrayOf(name))
    }
    fun getUsers(){
        // Este método me pide los usuarios por los tanto los lee(readable)
        val database: SQLiteDatabase = DBHelper(context,"users_db",null,1).readableDatabase
        val cursor: Cursor =
            database.query("users", arrayOf("name","age"),null,null,null,null,null)
        var contador = 0 // ¿Que quieres sacar también el número de resultados? Pues haces un contador
        // Aquí tengo varios resultados y como leo estos resultados uno por uno. Siguiente, siguiente
        //       v
        // r r r r r r r
        // ¿Como hago esto?
        // Mientras haya siguientes es decir,
        while (cursor.moveToNext()) { // muevete al siguiente
            contador++ // Y cada vez que pasas por el contador le incrementas 1
            val name =
                cursor.getString(cursor.getColumnIndexOrThrow("name")) // no es muy normal saberse la posición del resultado de la query
            // por eso se usa getColumnIndexThrow
            // Que quieres sacar los años también
            val age = cursor.getInt(cursor.getColumnIndexOrThrow("age"))
            // Vamos a sacarlo en un Log.v solo para verlo
            Log.v(
                "database_users",
                "Name:$name Age: $age"
            ) // Esto es solo para verlo a través del LogCat

        }
        return contador
    }
}