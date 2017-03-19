package com.sillyhat.learningenglish.business.message.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ${XUSHIKUAN} on 2017-03-18.
 */
public class YouDaoDTO implements Serializable {

    private static final long serialVersionUID = -3924124600454519495L;

    /**
     * errorCode：
     　0 - 正常
     　20 - 要翻译的文本过长
     　30 - 无法进行有效的翻译
     　40 - 不支持的语言类型
     　50 - 无效的key
     　60 - 无词典结果，仅在获取词典结果生效
     */
    private int errorCode;

    /**
     * 查询字段
     */
    private String query;

    /**
     * 基本词典
     */
    private List<YouDaoBasicDTO> basic;

    /**
     * 有道词典的翻译
     */
    private List<String> translation;

    /**
     * 网络释意
     */
    private List<YouDaoWebDTO> web;


    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<YouDaoBasicDTO> getBasic() {
        return basic;
    }

    public void setBasic(List<YouDaoBasicDTO> basic) {
        this.basic = basic;
    }

    public List<String> getTranslation() {
        return translation;
    }

    public void setTranslation(List<String> translation) {
        this.translation = translation;
    }

    public List<YouDaoWebDTO> getWeb() {
        return web;
    }

    public void setWeb(List<YouDaoWebDTO> web) {
        this.web = web;
    }

    @Override
    public String toString() {
        return "YouDaoDTO{" +
                "errorCode=" + errorCode +
                ", query='" + query + '\'' +
                ", basic=" + basic +
                ", translation=" + translation +
                ", web=" + web +
                '}';
    }
}
