package com.example.usuario.ejercicioparceablemartes;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by usuario on 19/09/2017.
 */

public class Persona implements Parcelable{

    private String nombre;
    private String apellido;
    private Integer edad;
    private Direccion direccion;

   public Persona(Parcel parcel) {
        nombre=parcel.readString();
        apellido=parcel.readString();
        edad=parcel.readInt();
        direccion=parcel.readParcelable(Direccion.class.getClassLoader());

    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Persona(String nombre, String apellido, Integer edad, Direccion direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion=direccion;

    }
    public Persona(String nombre, String apellido, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;


    }
    public Persona(Persona persona, Direccion direccion) {
        this.nombre = persona.nombre;
        this.apellido = persona.apellido;
        this.edad = persona.edad;
        this.direccion=direccion;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persona persona = (Persona) o;

        if (nombre != null ? !nombre.equals(persona.nombre) : persona.nombre != null) return false;
        if (apellido != null ? !apellido.equals(persona.apellido) : persona.apellido != null)
            return false;
        return edad != null ? edad.equals(persona.edad) : persona.edad == null;

    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (edad != null ? edad.hashCode() : 0);
        return result;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(apellido);
        dest.writeInt(edad);
        dest.writeParcelable(direccion,0);


    }

    public static final Parcelable.Creator<Persona> CREATOR=new Parcelable.Creator<Persona>(){

        @Override
        public Persona createFromParcel(Parcel parcel) {
            return new Persona(parcel);
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };

}
