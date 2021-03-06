/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.common.entity.CommonSeq;

/**
 * 序列DAO接口
 * @author 张雷
 * @version 2018-05-12
 */
@MyBatisDao
public interface CommonSeqDao extends CrudDao<CommonSeq> {
	
}