package com.netcracker.Entities;

import com.netcracker.Entities.PrimaryKey.TestQuestKey;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;

@Entity
@Table(name = "test_quest")
@EnableTransactionManagement
public class TestQuest {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private TestQuestKey id;

    public TestQuestKey getId() {
        return id;
    }

    public void setId(TestQuestKey id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TestQuest{" +
                "id=" + id +
                '}';
    }
}
