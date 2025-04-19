package com.uax.almacenamiento.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// Esta clase me va ayudar a llegar a la base de datos
// Pero esto no es la base de datos

// Y cuando lo llamemos tenemos que crear el constructor como tal
class DBHelper(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    // Hay que llamar a sus constructores de forma obligatorio el que se usa en este caso es el segundo
// Si no existe vamos a decirle que la cree
// Está clase es abstracta y nos traerá dos métodos
    override fun onCreate(db: SQLiteDatabase?) {
        // Ejecutado cuando la base de datos no existe
        // la primera vez que se llama a un objeto DBHelper
        val query = "CREATE TABLE user(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "age INTEGER NOT NULL)"
        // Ahora ejecutaremos la query que hemos declarado antes
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Ejecutaré lo que diga mis ubida de versión
    }
}

