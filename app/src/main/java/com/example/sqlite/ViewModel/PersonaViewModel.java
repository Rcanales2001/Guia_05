package com.example.sqlite.ViewModel;
import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.sqlite.DAO.PersonaDAO;
import com.example.sqlite.Database.PersonasDatabase;
import com.example. sqlite.Entidades.Personas;

import java.util.List;

public class PersonaViewModel extends AndroidViewModel {

    private PersonaDAO personaDAO;
    private LiveData<List<Personas>> listaDePersonas;
    public PersonaViewModel(Application application) {
        super(application);

        PersonasDatabase database = PersonasDatabase.getInstance(application);


        personaDAO = database.personaDAO();

        listaDePersonas = personaDAO.obtenerTodasLasPersonas();
    }
    // Método para obtener la lista observable de todas las personas
    public LiveData<List<Personas>> getListaDePersonas() {
        return listaDePersonas;
    }
    //eliminar y editar

    // Método para insertar una persona en la base de datos, ejecutado en un hilo secundario
    public void insertPersona(Personas persona) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                personaDAO.Insert(persona);
            }
        }).start();
    }
}

