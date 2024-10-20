package com.example.sqlite.DAO;
import androidx.lifecycle.LiveData; //agregar
import androidx.room.Dao; //agregar
import androidx.room.Delete;//agregar
import androidx.room.Insert;//agregar
import androidx.room.Query;//agregar
import androidx.room.Update;//agregar

import com.example.sqlite.Entidades.Personas;

import java.util.List;

@Dao
public interface PersonaDAO {
    @Insert
    void Insert(Personas personaEntity);

    //actualizar y eliminar
// Método para actualizar la información


    @Query("SELECT * FROM PERSONAS")
    LiveData<List<Personas>> obtenerTodasLasPersonas();
}
