package org.wekit.web.db.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.FeedbackDao;
import org.wekit.web.db.model.Feedback;

/**
 * 评论相关操作类
 * 
 * @author HuangWeili
 * 
 */
public class FeedbackDaoImpl extends HibernateBaseDao<Feedback, Long> implements FeedbackDao {

	private static Logger	logger	= Logger.getLogger(FeedbackDaoImpl.class);

	@Override
	protected Class<Feedback> getEntityClass() {
		return Feedback.class;
	}

	@Override
	public Feedback addFeedback(Feedback feedback) {
		return this.save(feedback);
	}

	@Override
	public Feedback getFeedback(long id) {
		return this.get(id);
	}

	@Override
	public boolean deleteFeedback(long id) {
		try {
			this.deleteByPK(id);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteFeedback(Feedback feedback) {
		try {
			this.delete(feedback);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean updateFeedback(Feedback feedback) {
		try {
			this.update(feedback);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		return this.getAll();
	}

	@Override
	public List<Feedback> getFeedbacksWithPagination(IPaginable paginable) {
		return this.getObjectsWithPagination(paginable);
	}

}
