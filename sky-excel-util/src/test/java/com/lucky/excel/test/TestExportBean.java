package com.lucky.excel.test;

import com.lucky.excel.ExcelCell;
import com.lucky.excel.ExcelUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class TestExportBean {

  @Test
  public void exportXls() throws IOException {
    //用排序的Map且Map的键应与ExcelCell注解的index对应
    Map<String, String> map = new LinkedHashMap<>();
    map.put("a", "姓名");
    map.put("b", "年龄");
    map.put("c", "性别");
    map.put("d", "出生日期");
    map.put("e", "创建日期");

    Collection<Object> dataset = new ArrayList<Object>();
    dataset.add(new Model("", "", "", null));
    dataset.add(new Model(null, null, null, null));
    dataset.add(new Model("王五", "34", "男", new Date()));
    File f = new File("test.xls");
    OutputStream out = new FileOutputStream(f);
    ExcelUtil.exportExcel(map, dataset, out);
    out.close();
  }


  @Test
  public void exportExcel() throws IOException {
    Collection<Object> dataset = new ArrayList<Object>();

    dataset.add(new CardInfo("1", "第一张卡片"));
    dataset.add(new CardInfo("2", "第二张卡片"));
    File f = new File("test.xls");
    OutputStream out = new FileOutputStream(f);
    ExcelUtil.exportExcel(CardInfo.class, dataset, out);
    out.close();
  }
}
