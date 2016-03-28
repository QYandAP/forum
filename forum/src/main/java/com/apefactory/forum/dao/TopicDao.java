package com.apefactory.forum.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.apefactory.forum.entity.Topic;
@Repository
public class TopicDao extends BaseDao<Topic> {
	public List<Topic> getTopicsById(int boardId){
		return getSession().createQuery("FROM Topic as t Where t.boardId="+boardId).list();
	}
}
