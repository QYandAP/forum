package com.apefactory.forum.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_post")
public class Post extends BaseEntity {
	@Id
	@Column(name = "post_id")
	private int postId;
	@Column(name = "post_text")
	private String postText;
	@Column(name = "create_time")
	private Date createTime;
	@Column(name = "user_id")
	private int userId;
	@Column(name = "board_id")
	private int boardId;
	@Column(name = "topic_id")
	private int topicId;
}
