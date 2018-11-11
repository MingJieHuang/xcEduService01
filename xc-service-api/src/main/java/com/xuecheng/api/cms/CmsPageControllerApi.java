package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;

/**
 * @author hmj
 * @create 2018-11-07 14:23
 */
public interface CmsPageControllerApi {
    //页面查询接口
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);
}
