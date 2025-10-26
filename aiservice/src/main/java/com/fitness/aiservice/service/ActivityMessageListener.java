package com.fitness.aiservice.service;

import com.fitness.aiservice.model.Activity;
import com.fitness.aiservice.model.Recommendation;
import com.fitness.aiservice.repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivityMessageListener {
//    @Value("${rabbitmq.queue.name}")
//    private String queueName;

    private final ActivityAIService aiService;
    private final RecommendationRepository recommendationRepository;

    //Listening the queue. As soon as the queue is not empty, we process the one standing front in line
    @RabbitListener(queues="activity.queue")
    public void processActivity(Activity activity){
        log.info("Received activity for processing: {}", activity.getId());
//        log.info("Generated Recommendation: {}", aiService.generateRecommendation(activity));
        Recommendation recommendation= aiService.generateRecommendation(activity);
        recommendationRepository.save(recommendation);
    }
}
