package com.jknapka.testsvc.model;
/* hi joe*/


import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.XmlRootElement;




/**
 * A key could not be found.
 **/
@ApiModel(description = "A key could not be found.")
@XmlRootElement
public class KeyError  {
  
  private String oname = null;

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("oname")
  public String getOname() {
    return oname;
  }
  public void setOname(String oname) {
    this.oname = oname;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class KeyError {\n");
    
    sb.append("  oname: ").append(oname).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}


