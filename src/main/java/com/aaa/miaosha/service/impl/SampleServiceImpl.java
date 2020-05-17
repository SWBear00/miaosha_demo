/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SampleServiceImpl
 * Author:   ${白帅}
 * Date:     2019/9/17 22:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.aaa.miaosha.service.impl;

import com.aaa.miaosha.dao.SampleDao;
import com.aaa.miaosha.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ${白帅}
 * @create 2019/9/17
 * @since 1.0.0
 */
@Service
public class SampleServiceImpl implements SampleService {

    @Autowired
    private SampleDao dao;



}
