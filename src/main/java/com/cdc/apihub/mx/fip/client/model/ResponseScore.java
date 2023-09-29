package com.cdc.apihub.mx.fip.client.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;


public class ResponseScore {
  @SerializedName("Score")
  private Score score = null;
  public ResponseScore score(Score score) {
    this.score = score;
    return this;
  }
   
  @ApiModelProperty(value = "")
  public Score getScore() {
    return score;
  }
  public void setScore(Score score) {
    this.score = score;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseScore responseScore = (ResponseScore) o;
    return Objects.equals(this.score, responseScore.score);
  }
  @Override
  public int hashCode() {
    return Objects.hash(score);
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseScore {\n");
    
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
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
