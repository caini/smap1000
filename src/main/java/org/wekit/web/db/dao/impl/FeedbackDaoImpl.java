package org.wekit.web.db.dao.impl;

import java.util.List;

import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
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

	@Override
	public Feedback addFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Feedback getFeedback(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteFeedback(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Feedback> getFeedbacksWithPagination(IPaginable paginable) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
