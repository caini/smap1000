package org.wekit.web.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.FeedbackTypeDao;
import org.wekit.web.db.model.FeedbackType;

/**
 * 
 * @author HuangWeili
 *
 */
@Repository("feedbackTypeDao")
public class FeedbackTypeDaoImpl extends HibernateBaseDao<FeedbackType, Long> implements FeedbackTypeDao {

	@Override
	protected Class<FeedbackType> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FeedbackType addFeedbackType(FeedbackType feedbackType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FeedbackType getFeedbackType(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteFeedbackType(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFeedbackType(FeedbackType feedbackType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateFeedbackType(FeedbackType feedbackType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<FeedbackType> getAllFeedbackTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FeedbackType> getFeedbackTypesWithPagination(IPaginable paginable) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
