package io.txf4311.arch.eonar.ocr.entity;

import lombok.Data;
import lombok.ToString;

/**
 * 营业执照
 */
@Data
@ToString
public class BusinessLicense {
  private String name;
  private String type;
  private String address;
  private String legalPerson;
  private String amount;
  private String startDate;
}
