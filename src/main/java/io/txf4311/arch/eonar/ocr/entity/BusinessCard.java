package io.txf4311.arch.eonar.ocr.entity;

import lombok.Data;
import lombok.ToString;

/**
 * 名片
 */
@Data
@ToString
public class BusinessCard{

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 名字（中文）
     */
    private String nameZh;

    /**
     * 名字（英文）
     */
    private String nameEn;

    /**
     * 职位
     */
    private String position;

    /**
     * 电话
     */
    private String tel;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 地址
     */
    private String address;

    /**
     * 手机
     */
    private String phone;
}
