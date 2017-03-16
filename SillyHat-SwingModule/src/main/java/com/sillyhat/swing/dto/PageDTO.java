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
        pageSize = 25;
        setCurrentPage(1);
    }

    //传递的参数或是配置的参数
    private int currentPage; // 当前页
    private int pageSize; // 每页显示多少条记录
    private Map<String,Object> params;

    //查询数据库
    private List resultList; // 本页的数据列表
    private int totalCount; // 总记录数

    //计算
    private int totalPage; // 总页数
    private int startIndex; // 页码列表的开始索引（包含）
    private int endIndex; // 页码列表的结束索引（包含）

    public void compute(){
        startIndex = (currentPage - 1) * pageSize;
        endIndex =  currentPage * pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        compute();
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

    public List getResultList() {
        return resultList;
    }

    public void setResultList(List resultList) {
        this.resultList = resultList;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        setTotalPage((totalCount + (pageSize - 1)) / pageSize);
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }


    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
}
