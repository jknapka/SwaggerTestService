package com.jknapka.testsvc.model;
/* hi joe*/


import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.XmlRootElement;




/**
 * The thing we output.
 **/
@ApiModel(description = "The thing we output.")
@XmlRootElement
public class OutputThing  {
  
  private String oname = null;
  private String ovalue = null;

  
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

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("ovalue")
  public String getOvalue() {
    return ovalue;
  }
  public void setOvalue(String ovalue) {
    this.ovalue = ovalue;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class OutputThing {\n");
    
    sb.append("  oname: ").append(oname).append("\n");
    sb.append("  ovalue: ").append(ovalue).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}


