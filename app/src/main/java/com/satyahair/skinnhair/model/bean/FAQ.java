package com.satyahair.skinnhair.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sandeep on 20/12/2016.
 */

public class FAQ extends BaseBean {

    @SerializedName("title")
    String question = "FAQ";

    @SerializedName("content")
    String answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
