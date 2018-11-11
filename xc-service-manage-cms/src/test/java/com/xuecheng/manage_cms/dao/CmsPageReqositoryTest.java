package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsPageParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author hmj
 * @create 2018-11-08 10:15
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageReqositoryTest {
    @Autowired
    private CmsPageRepository cmsPageRepository;
    //测试查询全部集合
    @Test
    public void findAll(){
        List<CmsPage> all = cmsPageRepository.findAll();
        System.out.println(all);
    }
    //测试查询分页集合
    @Test
    public  void findPage(){
        int page = 2;//页码从0开始
        int size= 10;
        Pageable pageable = PageRequest.of(page,size);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        System.out.println(all.getContent());
    }
    //添加
    @Test
    public void testInsert(){
//定义实体类
        CmsPage cmsPage = new CmsPage();
        cmsPage.setSiteId("s01");
        cmsPage.setTemplateId("t01");
        cmsPage.setPageName("测试页面");
        cmsPage.setPageCreateTime(new Date());
        List<CmsPageParam> cmsPageParams = new ArrayList<>();
        CmsPageParam cmsPageParam = new CmsPageParam();
        cmsPageParam.setPageParamName("param1");
        cmsPageParam.setPageParamValue("value1");
        cmsPageParams.add(cmsPageParam);
        cmsPage.setPageParams(cmsPageParams);
        cmsPageRepository.save(cmsPage);
        System.out.println(cmsPage);
    }
    //测试根据id删除信息
    @Test
    public void deletePageById(){
        cmsPageRepository.deleteById("5be3a6f1901ab5a20825c771");
    }

    //测试修改,并使用了jdl 1.8引入的Optiona 对象容器,完成为空判断的标准化
    @Test
    public  void  updatePageInfo(){
        //先根据id查询信息,返回一个Optional对象
        Optional<CmsPage> optional = cmsPageRepository.findById("5b17a34211fe5e2ee8c116c9");
            if (optional.isPresent()){//判断容器是否为空,如果为空返回false
                CmsPage cmsPage = optional.get();//从容器里面取出对象

            }
    }
}
