/*
 * Copyright 2005-2015 shopxx.net. All rights reserved. Support: http://www.shopxx.net License:
 * http://www.shopxx.net/license
 */
package org.quickxx.core.support;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang3.StringUtils;

/**
 * Editor - 字符串
 * 
 * @author xiaoshu.lv
 * @since 2017年8月7日15:32:54
 */
public class StringEditor extends PropertyEditorSupport {

  /** 是否将空转换为null */
  private boolean emptyAsNull;

  /**
   * 构造方法
   * 
   * @param emptyAsNull 是否将空转换为null
   */
  public StringEditor(boolean emptyAsNull) {
    this.emptyAsNull = emptyAsNull;
  }

  /**
   * 获取内容
   * 
   * @return 内容
   */
  @Override
  public String getAsText() {
    Object value = getValue();
    return value != null ? value.toString() : StringUtils.EMPTY;
  }

  /**
   * 设置内容
   * 
   * @param text 内容
   */
  @Override
  public void setAsText(String text) {
    if (emptyAsNull && StringUtils.isEmpty(text)) {
      setValue(null);
    } else {
      setValue(text);
    }
  }

}
