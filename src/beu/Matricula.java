
package beu;

import Chuquitarco.Persona;
import Chuquitarco.Unidad;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class Matricula {
    private final String numero;
    private Calendar fecha;
    private Estado estado;
    private Persona estudiante;
    private Curso curso;
    private final List<Calificacion> calificaciones= new ArrayList<>(); //sin get and set
    //informacion 
    private float promedio;
    

    public Matricula() {
        fecha = Calendar.getInstance();
        estado = Estado.Registrada;
        UUID numeroAleatorio =UUID.randomUUID();
        numero = numeroAleatorio.toString();
        
    }

    public String getNumero() {
        return numero;
    }


    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Persona getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Persona estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public float getPromedio(){
        return promedio;
    }
    public void CalcularPromedio(){
        DecimalFormat f = new DecimalFormat("##.##");
        float suma=0;
        if (this.calificaciones.size()==0){
            return;
        }
        for (Calificacion c :  calificaciones){
            suma = suma+c.valor;// se puede acceder al atriburo por que es una clase interna
            
        }
        int divisor = calificaciones.size();
        promedio = (float)suma/(float)divisor;
        f.format(promedio);
        if(divisor == 3){
            if (promedio > 14){
                this.estado= Estado.Aprobada;
            }else{
                this.estado= Estado.Reprobada;
            }
        }
    }
    // este metodo agrega una calificacion y retorna uno nuevo
    //1 si es nota unidad I
    //2 si es nota unidad II
    //3 si es nota unidad III
    //0 si no tiene notas
    public int addCalificacion(float v){
        Calificacion cal = new Calificacion();
        int cuentaNotas = this.calificaciones.size();
        switch (cuentaNotas){
            case 0:
                cal.setUnidad(Unidad.I);
                break;
            case 1:
                cal.setUnidad(Unidad.II);
                break;
            case 2:
                cal.setUnidad(Unidad.III);
                break;
                
            default: return 0; //si tiene todas las notas retorna o
        }
        cal.setValor(v);
        cal.setFecha(Calendar.getInstance());
        this.calificaciones.add(cal);
        this.CalcularPromedio();
        //almacena el tamaño de la lista
        return this.calificaciones.size();
    }
    @Override
    public String toString() {
        return estudiante.toString()+ " #"+numero;
    }
    
    public String imprimirDetalle(){
        DecimalFormat f = new DecimalFormat("##.##");
        String str= "\n\t"+this.estudiante;
        for(Calificacion c : calificaciones){
            str +="\t\t"+c.getValor();
        }
        str +="\t\t" + f.format(promedio)+"\n";
        return str;
    }
    //creamos metodo para archivar el gson
    public String toSave(){
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        return gson.toJson(this);
    }
    
    
    //Clase interna
    class Calificacion{
        private Calendar fecha;
        private float valor;
        private Unidad unidad;

        public Calificacion() {
        }

        public Calendar getFecha() {
            return fecha;
        }

        public void setFecha(Calendar fecha) {
            this.fecha = fecha;
        }

        public float getValor() {
            return valor;
        }

        public void setValor(float valor) {
            this.valor = valor;
        }

        public Unidad getUnidad() {
            return unidad;
        }

        public void setUnidad(Unidad unidad) {
            this.unidad = unidad;
        }
        
        
    }

    
}
