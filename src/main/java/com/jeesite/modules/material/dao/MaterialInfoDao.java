/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.material.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.material.entity.MaterialInfo;

/**
 * 材料清单DAO接口
 * @author 张雷
 * @version 2018-05-09
 */
@MyBatisDao
public interface MaterialInfoDao extends CrudDao<MaterialInfo> {
	
}