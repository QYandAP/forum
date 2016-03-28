package com.apefactory.forum.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_topic")
public class Topic extends BaseEntity {
	@Id
	@Column(name="topic_id")
	private int topicId;
	
	@Column(name="topic_tittle")
	private String topicTittle;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="board_id")
	private int boardId;
	
	@Column(name="create_time")
	private Date createTime;
	
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public String getTopicTittle() {
		return topicTittle;
	}
	public void setTopicTittle(String topicTittle) {
		this.topicTittle = topicTittle;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
