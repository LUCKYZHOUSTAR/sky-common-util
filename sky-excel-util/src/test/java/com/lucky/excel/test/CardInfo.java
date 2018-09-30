package com.lucky.excel.test;

import com.lucky.excel.ExcelCell;
import java.time.LocalDateTime;


public class CardInfo {


  public CardInfo(String cardId, String cardName) {

    this.cardId = cardId;
    this.cardName = cardName;
    this.createTime = LocalDateTime.now();
  }

  @ExcelCell(index = 0, title = "卡号")
  private String cardId;

  @ExcelCell(index = 1, title = "卡名称")
  private String cardName;
  @ExcelCell(index = 2, title = "创建时间")
  private LocalDateTime createTime;


  public String getCardId() {
    return cardId;
  }

  public void setCardId(String cardId) {
    this.cardId = cardId;
  }

  public String getCardName() {
    return cardName;
  }

  public void setCardName(String cardName) {
    this.cardName = cardName;
  }


  public LocalDateTime getCreateTime() {
    return createTime;
  }

  public void setCreateTime(LocalDateTime createTime) {
    this.createTime = createTime;
  }
}
