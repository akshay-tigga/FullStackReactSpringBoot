package com.akki.ispdemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class IspEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private float lowestPrice;
    private float rating;
    private float maxSpeed;
    private String description;
    private String contact;
    private String email;
    private String image;
    private String ispUrl;

    public IspEntity() {
    }

    public IspEntity(Long id, String name, float lowestPrice, float rating, float maxSpeed, String description, String contact, String email, String image, String ispUrl) {
        this.id = id;
        this.name = name;
        this.lowestPrice = lowestPrice;
        this.rating = rating;
        this.maxSpeed = maxSpeed;
        this.description = description;
        this.contact = contact;
        this.email = email;
        this.image = image;
        this.ispUrl = ispUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(float lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIspUrl() {
        return ispUrl;
    }

    public void setIspUrl(String ispUrl) {
        this.ispUrl = ispUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IspEntity ispEntity = (IspEntity) o;
        return Float.compare(ispEntity.getRating(), getRating()) == 0 &&
                getId().equals(ispEntity.getId()) &&
                getName().equals(ispEntity.getName()) &&
                Objects.equals(getLowestPrice(), ispEntity.getLowestPrice()) &&
                Objects.equals(getMaxSpeed(), ispEntity.getMaxSpeed()) &&
                Objects.equals(getDescription(), ispEntity.getDescription()) &&
                Objects.equals(getContact(), ispEntity.getContact()) &&
                Objects.equals(getEmail(), ispEntity.getEmail()) &&
                Objects.equals(getImage(), ispEntity.getImage()) &&
                Objects.equals(getIspUrl(), ispEntity.getIspUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLowestPrice(), getRating(), getMaxSpeed(), getDescription(), getContact(), getEmail(), getImage(), getIspUrl());
    }

    @Override
    public String toString() {
        return "IspEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lowestPrice='" + lowestPrice + '\'' +
                ", rating=" + rating +
                ", maxSpeed='" + maxSpeed + '\'' +
                ", description='" + description + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", image='" + image + '\'' +
                ", ispUrl='" + ispUrl + '\'' +
                '}';
    }
}
