package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author hmj
 * @create 2018-11-08 9:51
 */
public interface CmsPageRepository extends MongoRepository<CmsPage,String> {
}
