package com.cdc.apihub.mx.fip.client.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;


public class Score {
  @SerializedName("valor")
  private Double valor = null;
  @SerializedName("codigo")
  private String codigo = null;
  public Score valor(Double valor) {
    this.valor = valor;
    return this;
  }
   
  @ApiModelProperty(example = "15.0", value = "score")
  public Double getValor() {
    return valor;
  }
  public void setValor(Double valor) {
    this.valor = valor;
  }
  public Score codigo(String codigo) {
    this.codigo = codigo;
    return this;
  }
   
  @ApiModelProperty(example = "C2", value = "codigo")
  public String getCodigo() {
    return codigo;
  }
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Score score = (Score) o;
    return Objects.equals(this.valor, score.valor) &&
        Objects.equals(this.codigo, score.codigo);
  }
  @Override
  public int hashCode() {
    return Objects.hash(valor, codigo);
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Score {\n");
    
    sb.append("    valor: ").append(toIndentedString(valor)).append("\n");
    sb.append("    codigo: ").append(toIndentedString(codigo)).append("\n");
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
