package org.wekit.web.db.dao;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.FeedbackType;

/**
 * 反馈信息类型访问层
 * @author huangweili
 *
 */
public interface FeedbackTypeDao {

	public FeedbackType addFeedbackType(FeedbackType feedbackType);
	
	public FeedbackType getFeedbackType(long id);
	
	public boolean deleteFeedbackType(long id);
	
	public boolean deleteFeedbackType(FeedbackType feedbackType);
	
	public boolean updateFeedbackType(FeedbackType feedbackType);
	
	public List<FeedbackType> getAllFeedbackTypes();
	
	public List<FeedbackType> getFeedbackTypesWithPagination(IPaginable paginable);
	
}
