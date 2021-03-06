package com.netcracker.Entities;

import com.netcracker.Entities.PrimaryKey.TestQuestKey;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "test_quest")
@EnableTransactionManagement
public class TestQuest implements Serializable {

    @EmbeddedId
    private TestQuestKey id;

    public TestQuest() {
    }

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
