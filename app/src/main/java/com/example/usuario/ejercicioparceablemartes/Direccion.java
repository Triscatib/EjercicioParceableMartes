package com.example.usuario.ejercicioparceablemartes;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by usuario on 19/09/2017.
 */

public class Direccion implements Parcelable{
    private String calle;
    private Integer numero;
    private Integer cp;
    private String localidad;

   protected Direccion(Parcel in) {
        calle = in.readString();
        numero= in.readInt();
        cp= in.readInt();
        localidad = in.readString();

    }

    public static final Creator<Direccion> CREATOR = new Creator<Direccion>() {
        @Override
        public Direccion createFromParcel(Parcel parcel) {
            return new Direccion(parcel);
        }

        @Override
        public Direccion[] newArray(int size) {
            return new Direccion[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(calle);
        dest.writeInt(numero);
        dest.writeInt(cp);
        dest.writeString(localidad);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direccion direccion = (Direccion) o;

        if (calle != null ? !calle.equals(direccion.calle) : direccion.calle != null) return false;
        if (numero != null ? !numero.equals(direccion.numero) : direccion.numero != null)
            return false;
        if (cp != null ? !cp.equals(direccion.cp) : direccion.cp != null) return false;
        return localidad != null ? localidad.equals(direccion.localidad) : direccion.localidad == null;

    }

    @Override
    public int hashCode() {
        int result = calle != null ? calle.hashCode() : 0;
        result = 31 * result + (numero != null ? numero.hashCode() : 0);
        result = 31 * result + (cp != null ? cp.hashCode() : 0);
        result = 31 * result + (localidad != null ? localidad.hashCode() : 0);
        return result;
    }

    public String getCalle() {

        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Direccion(String calle, Integer numero, Integer cp, String localidad) {

        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.localidad = localidad;
    }
}
