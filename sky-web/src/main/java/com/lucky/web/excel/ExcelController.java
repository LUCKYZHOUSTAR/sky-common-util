package com.lucky.web.excel;

/**
 * @Author:chaoqiang.zhou
 * @Date:Create in 上午9:43 2018/7/25
 */

import com.lucky.excel.ExcelCell;
import com.lucky.excel.ExcelUtil;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/excel")
public class ExcelController {


  @RequestMapping("download")
  public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Collection<Object> dataset = new ArrayList<Object>();

    dataset.add(new CardInfo("1", "第一张卡片"));
    dataset.add(new CardInfo("2", "第二张卡片"));

    response.reset();
    response.setContentType("application/vnd.ms-excel;charset=utf-8");
    String filename = "卡服务列表.xls";
    String header = request.getHeader("User-Agent");
    if (header.toUpperCase().indexOf("MSIE") > 0 || header.contains("Trident")) {
      filename = URLEncoder.encode(filename, "UTF-8");
    } else {
      filename = new String(filename.getBytes(), "ISO8859-1");
    }
    response.setHeader("Content-Disposition", "attachment;filename=" + filename);
    ServletOutputStream out = response.getOutputStream();
    ExcelUtil.exportExcel(CardInfo.class, dataset, out);
    out.flush();
    out.close();

  }

  public static class CardInfo {


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

}
