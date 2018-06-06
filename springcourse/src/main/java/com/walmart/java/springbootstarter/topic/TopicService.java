package com.walmart.java.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> courseTopics = new ArrayList<>(Arrays.asList(new Topic("java", "Core Java", "description"),
			new Topic("Spring", "Spring Framework", "Spring Framework Description"),
			new Topic("Sql", "Sql", "Sql Description")));

	public List<Topic> getAllTopics() {
		//return courseTopics;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
		
		
	}

	public Topic getTopic(String id) {
		return courseTopics.stream().filter(t -> t.getId().equals(id)).findFirst().get();

	}

	public void addTopic(Topic topic) {
		courseTopics.add(topic);

	}

	public void deleteTopics(String id) {
		courseTopics.removeIf(t->t.getId().equals(id));
		
		}

	public void updateTopic(String id, Topic topic) {
		for(int i = 0; i<courseTopics.size(); i++) {
			Topic t = courseTopics.get(i);
			if(t.getId().equals(id)) {
				courseTopics.set(i, topic);
				return;
			}
			
				
				
			}
		
	}

}
