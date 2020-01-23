
package bll;

import Chuquitarco.BaseBllCrud;
import Chuquitarco.BasePersistencia;
import Chuquitarco.Util;
import beu.Curso;
import beu.Estudiante;
import beu.Matricula;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class GestionMatricula extends BasePersistencia implements BaseBllCrud<Matricula>{
    private Matricula matricula;
    private final String directorio = "matriculas";

    public GestionMatricula() {
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
    
    public String imprimir(){
        DecimalFormat f = new DecimalFormat();
        StringBuilder sb = new StringBuilder();
        sb.append("Estudiante: ").append(matricula.getEstudiante()).append("\n");
        sb.append("Curso: ").append(matricula.getCurso().getTitulo()).append("\n");
        sb.append("Promedio: ");
        sb.append(f.format(matricula.getPromedio()));
        sb.append(matricula.imprimirDetalle());
        
        return sb.toString();
    }
    
    public String Calificar(float valor){
        String mensaje = "";
        int num = this.matricula.addCalificacion(valor);
        switch(num){
            case 0:
                mensaje = "Todas las notas estan registradas\n";
                break;
            case 1:
                mensaje = "Calificacion de la unidad I agregada\n";
                break;
            case 2:
                mensaje ="Calificacion de la unidad II agregada\n";
                break;
            case 3:
                mensaje = "Calificacion de la unidad III agregada";
                break;    
        }
        return mensaje;
    }
    
    public void Promediar(){
        this.matricula.CalcularPromedio();
    }
    
    public void Archivar() throws IOException{
        /*String resultado="";
        String nombreArchivo = "matricula_"+matricula.getNumero()+".json";
        //Agregamos importación
        try {
            try(FileWriter archivo = new FileWriter(nombreArchivo)){
                archivo.write(matricula.toSave());
            }
            resultado="Matricula " +matricula.getNumero()+" archivada correctamente\n";
        } catch (IOException e) {
            resultado = "Error: "+ e.toString();
        }
        return resultado;*/
        this.escribir(directorio, this.matricula.getNumero(),matricula);
    }
    
    public void configurar(Curso curso , Estudiante est ){
        this.matricula.setCurso(curso);
        matricula.setEstudiante(est);
    }
    
    public List<Matricula> reportar(String titulo) throws IOException{
        List<Matricula> resultado = new ArrayList<>();
        List<String> contenidos = this.LeerDirectorio(directorio,titulo);
        for(String texto : contenidos){
            GsonBuilder gb = new GsonBuilder();
            gb.setPrettyPrinting();
            Gson gson = gb.create();
            try {
                Matricula m = gson.fromJson(texto, Matricula.class);
                resultado.add(m);
            } catch (JsonSyntaxException e) {
                Util.imprimir("El texto no se pudo convertir en matricula"+"\n"+e.toString()+"\n");
            }
            
        }
        return resultado;
    }

    @Override
    public void crear() {
        matricula = new Matricula();
            
    }

    @Override
    public void consultar(String id) throws IOException {
        String archivo = id + ".json";
        String contenido = this.leer(directorio, archivo);
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        matricula = gson.fromJson(contenido,Matricula.class);     
    }

    @Override
    public void actualizar() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     
    
}
