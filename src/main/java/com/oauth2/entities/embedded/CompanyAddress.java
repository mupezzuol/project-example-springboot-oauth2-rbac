package com.oauth2.entities.embedded;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Embeddable
public class CompanyAddress implements Serializable {
	
	private static final long serialVersionUID = 4145928058196660600L;
	private String address;
	private String numberAddress;
	private String complement;
	private String neighbourhood;
	private String zipCode;
	private String city;
	private String state;

}
