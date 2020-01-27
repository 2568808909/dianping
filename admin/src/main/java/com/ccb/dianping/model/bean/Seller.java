package com.ccb.dianping.model.bean;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
public class Seller {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column seller.id
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column seller.name
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column seller.created_time
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    private Date createdTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column seller.updated_time
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    private Date updatedTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column seller.remark_score
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    private BigDecimal remarkScore;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column seller.disabled_flag
     *
     * @mbg.generated Mon Jan 27 11:47:50 CST 2020
     */
    private Integer disabledFlag;

}