package com.apefactory.forum.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.apefactory.forum.dao.BoardDao;
import com.apefactory.forum.dao.TopicDao;
import com.apefactory.forum.entity.Board;
import com.apefactory.forum.entity.Topic;

@Service
public class ForumService {
	@Resource
	private BoardDao boardDao;
	@Resource
	private TopicDao topicDao;
	
	public List<Board> getAllBoard(){
		return boardDao.getALL();
	}
	
	public List<Topic> getAllBoardTopics(int boardId){
		return topicDao.getTopicsById(boardId);
	}
}
