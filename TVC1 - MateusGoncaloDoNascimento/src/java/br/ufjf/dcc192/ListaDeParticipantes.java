package br.ufjf.dcc192;

import java.util.ArrayList;
import java.util.List;

public class ListaDeParticipantes {
    private static ArrayList<Pessoa> estudante;
    private static ArrayList<Pessoa> TAE;
    private static ArrayList<Pessoa> intercambista;
    private static ArrayList<Pessoa> docente;
    
    public static List<Pessoa> getEstudante()
    {
        if (estudante == null)
        {
            estudante = new ArrayList<>();
        }
        return estudante;
    }
    public static List<Pessoa> getTAE()
    {
        if (TAE == null)
        {
            TAE = new ArrayList<>();
        }
        return TAE;
    }
    public static List<Pessoa> getIntercambista()
    {
        if (intercambista == null)
        {
            intercambista = new ArrayList<>();
        }
        return intercambista;
    }
    public static List<Pessoa> getDocente()
    {
        if (docente == null)
        {
            docente = new ArrayList<>();
        }
        return docente;
    }
}
