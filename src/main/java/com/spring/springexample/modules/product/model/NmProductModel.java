package com.spring.springexample.modules.product.model;

import com.spring.springexample.common.NmBaseModel;
import com.spring.springexample.common.NmBaseResponse;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "chp_product")
public class NmProductModel extends NmBaseModel {

    Long companyId;
    Long categoryId;
    Date modelYear;
    Float price;
    Date inputDate;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Date getModelYear() {
        return modelYear;
    }

    public void setModelYear(Date modelYear) {
        this.modelYear = modelYear;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public NmProductResponse isTitleValid(String title){
        if(title== null || title.length()==0){
            return (NmProductResponse) NmBaseResponse.badRequest("Invalid Input Value,title field can not be empty! ");
        }
            return new NmProductResponse();
    }

    public NmProductResponse isPriceValid(Float price){
        if(price== null || price<0){
            return (NmProductResponse) NmBaseResponse.badRequest("Invalid Input Value, Price value is incorrect! ");
        }
        return new NmProductResponse();
    }

    public NmProductResponse isIdValid(Long id){
        if(id== null || id==0){
            return (NmProductResponse) NmBaseResponse.badRequest("Invalid Input Value,id field can not be empty! ");
        }
        return new NmProductResponse();
    }
}
