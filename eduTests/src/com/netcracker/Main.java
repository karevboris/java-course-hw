package com.netcracker;

import com.netcracker.Entities.Answer;
import com.netcracker.Entities.PrimaryKey.QuestAnswerKey;
import com.netcracker.Entities.QuestAnswer;
import com.netcracker.Service.AnswerService.AnswerService;
import com.netcracker.Service.QuestAnswerService.QuestAnswerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        QuestAnswerService service = (QuestAnswerService)context.getBean("questAnswerService");
        QuestAnswer questAnswer = new QuestAnswer();

        QuestAnswerKey questAnswerKey = new QuestAnswerKey();
        questAnswerKey.setQuestId(101);
        questAnswerKey.setAnswerId(1);
        System.out.println(service.readById(questAnswerKey));
    }
}
