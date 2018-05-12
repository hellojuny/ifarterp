package com.jeesite.modules.common.utils;

import com.jeesite.common.utils.SpringUtils;
import com.jeesite.modules.common.entity.CommonSeq;
import com.jeesite.modules.common.service.CommonSeqService;

/**
 * 序列工具类
 * 
 * @author 张雷
 * @version 1.0, 2018-05-12
 */
public class SeqUtils {
	
	private static CommonSeqService commonSeqService = (CommonSeqService)SpringUtils.getBean(CommonSeqService.class);
	
	/**
	 * 获取序列
	 * @param tableName
	 * @return
	 */
	public static int getNumber(String tableName) {
		CommonSeq seq = commonSeqService.get(tableName, false);
		if (seq == null) {
			return 0;
		} else {
			int curNumber = seq.getNumber();
			seq.setNumber(curNumber + 1);
			commonSeqService.save(seq);
			return curNumber;
		}
	}
	
}
