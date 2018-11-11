package com.xuecheng.framework.domain.cms.request;

import lombok.Data;

/**
 * @author hmj
 * @create 2018-11-07 14:17
 */
@Data
public class QueryPageRequest {
    //接收页面查询条件
    //站点id
    private String siteId;
    //页面ID
    private String pageId;
    //页面名称
    private String pageName;
    //别名
    private String pageAliase;
    //模版id
    private String templateId;
}
