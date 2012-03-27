package org.wekit.web.db.dao;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.Feedback;

/**
 * 
 * @author huangweili
 *
 */
public interface FeedbackDao {

	public Feedback addFeedback(Feedback feedback);
	
	public Feedback getFeedback(long id);
	
	public boolean deleteFeedback(long id);
	
	public boolean deleteFeedback(Feedback feedback);
	
	public boolean updateFeedback(Feedback feedback);
	
	public List<Feedback> getAllFeedbacks();
	
	public List<Feedback> getFeedbacksWithPagination(IPaginable paginable);
}
