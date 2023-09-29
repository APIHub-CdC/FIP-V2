package com.cdc.apihub.mx.fip.client.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;


public class RequestDatosGenerales {
  @SerializedName("primerNombre")
  private String primerNombre = null;
  @SerializedName("apellidoPaterno")
  private String apellidoPaterno = null;
  @SerializedName("apellidoMaterno")
  private String apellidoMaterno = null;
  @SerializedName("fechaNacimiento")
  private String fechaNacimiento = null;
  @SerializedName("direccion")
  private String direccion = null;
  @SerializedName("coloniaPoblacion")
  private String coloniaPoblacion = null;
  @SerializedName("ciudad")
  private String ciudad = null;
  @SerializedName("estado")
  private String estado = null;
  @SerializedName("pais")
  private String pais = null;
  @SerializedName("delegacionMunicipio")
  private String delegacionMunicipio = null;
  @SerializedName("cp")
  private String cp = null;
  @SerializedName("rfc")
  private String rfc = null;
  public RequestDatosGenerales primerNombre(String primerNombre) {
    this.primerNombre = primerNombre;
    return this;
  }
   
  @ApiModelProperty(example = "JUAN", required = true, value = "Primer nombre de la persona")
  public String getPrimerNombre() {
    return primerNombre;
  }
  public void setPrimerNombre(String primerNombre) {
    this.primerNombre = primerNombre;
  }
  public RequestDatosGenerales apellidoPaterno(String apellidoPaterno) {
    this.apellidoPaterno = apellidoPaterno;
    return this;
  }
   
  @ApiModelProperty(example = "PRUEBA", required = true, value = "Apellido paterno de la persona. Sin abreviaturas o iniciales")
  public String getApellidoPaterno() {
    return apellidoPaterno;
  }
  public void setApellidoPaterno(String apellidoPaterno) {
    this.apellidoPaterno = apellidoPaterno;
  }
  public RequestDatosGenerales apellidoMaterno(String apellidoMaterno) {
    this.apellidoMaterno = apellidoMaterno;
    return this;
  }
   
  @ApiModelProperty(example = "SIETE", required = true, value = "Apellido materno de la persona")
  public String getApellidoMaterno() {
    return apellidoMaterno;
  }
  public void setApellidoMaterno(String apellidoMaterno) {
    this.apellidoMaterno = apellidoMaterno;
  }
  public RequestDatosGenerales fechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
    return this;
  }
   
  @ApiModelProperty(example = "07-01-1980", required = true, value = "Fecha de nacimiento de la persona, en el formato especificado (por defecto yyyy-MM-dd)")
  public String getFechaNacimiento() {
    return fechaNacimiento;
  }
  public void setFechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }
  public RequestDatosGenerales direccion(String direccion) {
    this.direccion = direccion;
    return this;
  }
   
  @ApiModelProperty(example = "INSURGENTES SUR 1007", required = true, value = "calle y numero")
  public String getDireccion() {
    return direccion;
  }
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }
  public RequestDatosGenerales coloniaPoblacion(String coloniaPoblacion) {
    this.coloniaPoblacion = coloniaPoblacion;
    return this;
  }
   
  @ApiModelProperty(example = "INSURGENTES", required = true, value = "colonia")
  public String getColoniaPoblacion() {
    return coloniaPoblacion;
  }
  public void setColoniaPoblacion(String coloniaPoblacion) {
    this.coloniaPoblacion = coloniaPoblacion;
  }
  public RequestDatosGenerales ciudad(String ciudad) {
    this.ciudad = ciudad;
    return this;
  }
   
  @ApiModelProperty(example = "MEXICO", required = true, value = "ciudad")
  public String getCiudad() {
    return ciudad;
  }
  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }
  public RequestDatosGenerales estado(String estado) {
    this.estado = estado;
    return this;
  }
   
  @ApiModelProperty(example = "DF", required = true, value = "DISTRITO FEDERALF")
  public String getEstado() {
    return estado;
  }
  public void setEstado(String estado) {
    this.estado = estado;
  }
  public RequestDatosGenerales pais(String pais) {
    this.pais = pais;
    return this;
  }
   
  @ApiModelProperty(example = "MEX", required = true, value = "pais")
  public String getPais() {
    return pais;
  }
  public void setPais(String pais) {
    this.pais = pais;
  }
  public RequestDatosGenerales delegacionMunicipio(String delegacionMunicipio) {
    this.delegacionMunicipio = delegacionMunicipio;
    return this;
  }
   
  @ApiModelProperty(example = "BENITO JUAREZ", required = true, value = "delegacion o Municipio")
  public String getDelegacionMunicipio() {
    return delegacionMunicipio;
  }
  public void setDelegacionMunicipio(String delegacionMunicipio) {
    this.delegacionMunicipio = delegacionMunicipio;
  }
  public RequestDatosGenerales cp(String cp) {
    this.cp = cp;
    return this;
  }
   
  @ApiModelProperty(example = "11230", required = true, value = "codigo postal")
  public String getCp() {
    return cp;
  }
  public void setCp(String cp) {
    this.cp = cp;
  }
  public RequestDatosGenerales rfc(String rfc) {
    this.rfc = rfc;
    return this;
  }
   
  @ApiModelProperty(example = "XAXX010101000", required = true, value = "RFC")
  public String getRfc() {
    return rfc;
  }
  public void setRfc(String rfc) {
    this.rfc = rfc;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestDatosGenerales requestDatosGenerales = (RequestDatosGenerales) o;
    return Objects.equals(this.primerNombre, requestDatosGenerales.primerNombre) &&
        Objects.equals(this.apellidoPaterno, requestDatosGenerales.apellidoPaterno) &&
        Objects.equals(this.apellidoMaterno, requestDatosGenerales.apellidoMaterno) &&
        Objects.equals(this.fechaNacimiento, requestDatosGenerales.fechaNacimiento) &&
        Objects.equals(this.direccion, requestDatosGenerales.direccion) &&
        Objects.equals(this.coloniaPoblacion, requestDatosGenerales.coloniaPoblacion) &&
        Objects.equals(this.ciudad, requestDatosGenerales.ciudad) &&
        Objects.equals(this.estado, requestDatosGenerales.estado) &&
        Objects.equals(this.pais, requestDatosGenerales.pais) &&
        Objects.equals(this.delegacionMunicipio, requestDatosGenerales.delegacionMunicipio) &&
        Objects.equals(this.cp, requestDatosGenerales.cp) &&
        Objects.equals(this.rfc, requestDatosGenerales.rfc);
  }
  @Override
  public int hashCode() {
    return Objects.hash(primerNombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, direccion, coloniaPoblacion, ciudad, estado, pais, delegacionMunicipio, cp, rfc);
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestDatosGenerales {\n");
    
    sb.append("    primerNombre: ").append(toIndentedString(primerNombre)).append("\n");
    sb.append("    apellidoPaterno: ").append(toIndentedString(apellidoPaterno)).append("\n");
    sb.append("    apellidoMaterno: ").append(toIndentedString(apellidoMaterno)).append("\n");
    sb.append("    fechaNacimiento: ").append(toIndentedString(fechaNacimiento)).append("\n");
    sb.append("    direccion: ").append(toIndentedString(direccion)).append("\n");
    sb.append("    coloniaPoblacion: ").append(toIndentedString(coloniaPoblacion)).append("\n");
    sb.append("    ciudad: ").append(toIndentedString(ciudad)).append("\n");
    sb.append("    estado: ").append(toIndentedString(estado)).append("\n");
    sb.append("    pais: ").append(toIndentedString(pais)).append("\n");
    sb.append("    delegacionMunicipio: ").append(toIndentedString(delegacionMunicipio)).append("\n");
    sb.append("    cp: ").append(toIndentedString(cp)).append("\n");
    sb.append("    rfc: ").append(toIndentedString(rfc)).append("\n");
    sb.append("}");
    return sb.toString();
  }
  
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
