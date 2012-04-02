package org.wekit.web.db.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
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

	private static Logger	logger	= Logger.getLogger(FeedbackTypeDaoImpl.class);

	@Override
	protected Class<FeedbackType> getEntityClass() {
		return FeedbackType.class;
	}

	@Override
	public FeedbackType addFeedbackType(FeedbackType feedbackType) {
		return this.save(feedbackType);
	}

	@Override
	public FeedbackType getFeedbackType(long id) {
		return this.get(id);
	}

	@Override
	public boolean deleteFeedbackType(long id) {
		try {
			this.deleteByPK(id);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;

	}

	@Override
	public boolean deleteFeedbackType(FeedbackType feedbackType) {
		try {
			this.delete(feedbackType);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean updateFeedbackType(FeedbackType feedbackType) {
		try {
			this.update(feedbackType);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<FeedbackType> getAllFeedbackTypes() {
		return this.getAll();
	}

	@Override
	public List<FeedbackType> getFeedbackTypesWithPagination(IPaginable paginable) {
		return this.getObjectsWithPagination(paginable);
	}

}
