package com.leleproperty.leleproperty.model.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long propertyId;

    String propertyName;
    String propertyAddress;
    String propertyArea;
    String propertyPrice;
    String propertyDescription;
    String catagory;
    String propertyType;
    
//	public Catagory getCatagoryId() {
//		return catagoryId;
//	}
//
//	public void setCatagoryId(Catagory catagoryId) {
//		this.catagoryId = catagoryId;
//	}
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "catagory_id", nullable = false)
//	private Catagory catagoryId;

    @Lob
    @Column(name = "image_data1", columnDefinition = "LONGBLOB")
    byte[] imageData1;
    public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	String imageName1;
    String imageType1;

    @Lob
    @Column(name = "image_data2", columnDefinition = "LONGBLOB")
    byte[] imageData2;
    String imageName2;
    String imageType2;

    @Lob
    @Column(name = "image_data3", columnDefinition = "LONGBLOB")
    byte[] imageData3;
    String imageName3;
    String imageType3;

    @Lob
    @Column(name = "image_data4", columnDefinition = "LONGBLOB")
    byte[] imageData4;
    String imageName4;
    String imageType4;

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public String getPropertyArea() {
        return propertyArea;
    }

    public void setPropertyArea(String propertyArea) {
        this.propertyArea = propertyArea;
    }

    public String getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(String propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    public String getPropertyDescription() {
        return propertyDescription;
    }

    public void setPropertyDescription(String propertyDescription) {
        this.propertyDescription = propertyDescription;
    }

    public byte[] getImageData1() {
        return imageData1;
    }

    public void setImageData1(byte[] imageData1) {
        this.imageData1 = imageData1;
    }

    public String getImageName1() {
        return imageName1;
    }

    public void setImageName1(String imageName1) {
        this.imageName1 = imageName1;
    }

    public String getImageType1() {
        return imageType1;
    }

    public void setImageType1(String imageType1) {
        this.imageType1 = imageType1;
    }

    public byte[] getImageData2() {
        return imageData2;
    }

    public void setImageData2(byte[] imageData2) {
        this.imageData2 = imageData2;
    }

    public String getImageName2() {
        return imageName2;
    }

    public void setImageName2(String imageName2) {
        this.imageName2 = imageName2;
    }

    public String getImageType2() {
        return imageType2;
    }

    public void setImageType2(String imageType2) {
        this.imageType2 = imageType2;
    }

    public byte[] getImageData3() {
        return imageData3;
    }

    public void setImageData3(byte[] imageData3) {
        this.imageData3 = imageData3;
    }

    public String getImageName3() {
        return imageName3;
    }

    public void setImageName3(String imageName3) {
        this.imageName3 = imageName3;
    }

    public String getImageType3() {
        return imageType3;
    }

    public void setImageType3(String imageType3) {
        this.imageType3 = imageType3;
    }

    public byte[] getImageData4() {
        return imageData4;
    }

    public void setImageData4(byte[] imageData4) {
        this.imageData4 = imageData4;
    }

    public String getImageName4() {
        return imageName4;
    }

    public void setImageName4(String imageName4) {
        this.imageName4 = imageName4;
    }

    public String getImageType4() {
        return imageType4;
    }

    public void setImageType4(String imageType4) {
        this.imageType4 = imageType4;
    }
}