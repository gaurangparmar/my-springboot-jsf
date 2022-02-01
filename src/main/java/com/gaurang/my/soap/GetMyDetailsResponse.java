
package com.gaurang.my.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="mydetails" type="{http://www.gaurang.com/my/soap}MyDetails"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "mydetails"
})
@XmlRootElement(name = "getMyDetailsResponse")
public class GetMyDetailsResponse {

    @XmlElement(required = true)
    protected MyDetails mydetails;

    /**
     * Gets the value of the mydetails property.
     * 
     * @return
     *     possible object is
     *     {@link MyDetails }
     *     
     */
    public MyDetails getMydetails() {
        return mydetails;
    }

    /**
     * Sets the value of the mydetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link MyDetails }
     *     
     */
    public void setMydetails(MyDetails value) {
        this.mydetails = value;
    }

}
