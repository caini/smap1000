package org.wekit.web.db.dao.impl;

import org.wekit.web.HibernateBaseDao;
import org.wekit.web.db.dao.FeedbackDao;
import org.wekit.web.db.model.Feedback;
/**
 * 评论相关操作类
 * @author HuangWeili
 *
 */
public class FeedbackDaoImpl extends HibernateBaseDao<Feedback, Long> implements FeedbackDao{

	@Override
	protected Class<Feedback> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
