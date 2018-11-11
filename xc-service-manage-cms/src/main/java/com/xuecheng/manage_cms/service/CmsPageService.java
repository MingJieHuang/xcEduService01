package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author hmj
 * @create 2018-11-08 14:57
 */
@Service
public class CmsPageService {
    @Autowired
    private CmsPageRepository cmsPageRepository;

    /**
     * 查询分页集合
     * @param page 起始页码为1 ,dao的其实页码为0,这里做处理
     * @param size
     * @param queryPageRequest
     * @return
     */
    public QueryResponseResult findList(int page,int size, QueryPageRequest queryPageRequest) {
        if (page<=0){
            page =1;
        }
        if (size<=0){
            size =10;
        }
        page = page-1;//特殊处理,dao是从0页开始计数的
        Pageable pageable = PageRequest.of(page,size);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(all.getContent());
        queryResult.setTotal(all.getTotalElements());
        QueryResponseResult result = new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return result;
    }
}
