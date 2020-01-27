package com.ccb.dianping.model.bean;

import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@ToString
public class Shop {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.id
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.created_time
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    private Date createdTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.updated_time
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    private Date updatedTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.name
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.remark_score
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    private BigDecimal remarkScore;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.price_per_man
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    private Integer pricePerMan;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.latitude
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    private BigDecimal latitude;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.longitude
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    private BigDecimal longitude;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.category_id
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    private Integer categoryId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.tags
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    private String tags;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.start_time
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    private String startTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.end_time
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    private String endTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.address
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.seller_id
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    private Integer sellerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.icon_url
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    private String iconUrl;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.id
     *
     * @return the value of shop.id
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.id
     *
     * @param id the value for shop.id
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.created_time
     *
     * @return the value of shop.created_time
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.created_time
     *
     * @param createdTime the value for shop.created_time
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.updated_time
     *
     * @return the value of shop.updated_time
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.updated_time
     *
     * @param updatedTime the value for shop.updated_time
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.name
     *
     * @return the value of shop.name
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.name
     *
     * @param name the value for shop.name
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.remark_score
     *
     * @return the value of shop.remark_score
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public BigDecimal getRemarkScore() {
        return remarkScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.remark_score
     *
     * @param remarkScore the value for shop.remark_score
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public void setRemarkScore(BigDecimal remarkScore) {
        this.remarkScore = remarkScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.price_per_man
     *
     * @return the value of shop.price_per_man
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public Integer getPricePerMan() {
        return pricePerMan;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.price_per_man
     *
     * @param pricePerMan the value for shop.price_per_man
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public void setPricePerMan(Integer pricePerMan) {
        this.pricePerMan = pricePerMan;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.latitude
     *
     * @return the value of shop.latitude
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.latitude
     *
     * @param latitude the value for shop.latitude
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.longitude
     *
     * @return the value of shop.longitude
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.longitude
     *
     * @param longitude the value for shop.longitude
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.category_id
     *
     * @return the value of shop.category_id
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.category_id
     *
     * @param categoryId the value for shop.category_id
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.tags
     *
     * @return the value of shop.tags
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public String getTags() {
        return tags;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.tags
     *
     * @param tags the value for shop.tags
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.start_time
     *
     * @return the value of shop.start_time
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.start_time
     *
     * @param startTime the value for shop.start_time
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.end_time
     *
     * @return the value of shop.end_time
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.end_time
     *
     * @param endTime the value for shop.end_time
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.address
     *
     * @return the value of shop.address
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.address
     *
     * @param address the value for shop.address
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.seller_id
     *
     * @return the value of shop.seller_id
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public Integer getSellerId() {
        return sellerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.seller_id
     *
     * @param sellerId the value for shop.seller_id
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.icon_url
     *
     * @return the value of shop.icon_url
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.icon_url
     *
     * @param iconUrl the value for shop.icon_url
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }
}