package com.sillyhat.swing.dto;

import java.util.List;
import java.util.Map;

/**
 * 分页实体类
 *
 * @author 徐士宽
 * @date 2017/3/14 18:09
 */
public class PageDTO {

    public PageDTO(){
        currentPage = 1;
        pageSize = 20;
    }

    //传递的参数或是配置的参数
    private int currentPage; // 当前页
    private int pageSize; // 每页显示多少条记录
    private Map<String,Object> params;

    //查询数据库
    private List recordList; // 本页的数据列表
    private int recordCount; // 总记录数

    //计算
    private int pageCount; // 总页数
//    private int beginPageIndex; // 页码列表的开始索引（包含）
//    private int endPageIndex; // 页码列表的结束索引（包含）

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public List getRecordList() {
        return recordList;
    }

    public void setRecordList(List recordList) {
        this.recordList = recordList;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
