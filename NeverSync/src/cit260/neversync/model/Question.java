/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversync.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author benjaminlangston
 */
public class Question implements Serializable {
    
    private String questionText;    
    private String anwser1;
    private String answer2;
    private String answer3;
    private String answer4;
    private int correctAnswer;

    public Question() {
    }
    
    

    /**
     * Get the value of correctAnswer
     *
     * @return the value of correctAnswer
     */
    public int getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * Set the value of correctAnswer
     *
     * @param correctAnswer new value of correctAnswer
     */
    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }


    /**
     * Get the value of answer4
     *
     * @return the value of answer4
     */
    public String getAnswer4() {
        return answer4;
    }

    /**
     * Set the value of answer4
     *
     * @param answer4 new value of answer4
     */
    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }


    /**
     * Get the value of answer3
     *
     * @return the value of answer3
     */
    public String getAnswer3() {
        return answer3;
    }

    /**
     * Set the value of answer3
     *
     * @param answer3 new value of answer3
     */
    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }


    /**
     * Get the value of answer2
     *
     * @return the value of answer2
     */
    public String getAnswer2() {
        return answer2;
    }

    /**
     * Set the value of answer2
     *
     * @param answer2 new value of answer2
     */
    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }


    /**
     * Get the value of anwser1
     *
     * @return the value of anwser1
     */
    public String getAnwser1() {
        return anwser1;
    }

    /**
     * Set the value of anwser1
     *
     * @param anwser1 new value of anwser1
     */
    public void setAnwser1(String anwser1) {
        this.anwser1 = anwser1;
    }


    /**
     * Get the value of questionText
     *
     * @return the value of questionText
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * Set the value of questionText
     *
     * @param questionText new value of questionText
     */
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.questionText);
        hash = 79 * hash + Objects.hashCode(this.anwser1);
        hash = 79 * hash + Objects.hashCode(this.answer2);
        hash = 79 * hash + Objects.hashCode(this.answer3);
        hash = 79 * hash + Objects.hashCode(this.answer4);
        hash = 79 * hash + this.correctAnswer;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Question other = (Question) obj;
        if (this.correctAnswer != other.correctAnswer) {
            return false;
        }
        if (!Objects.equals(this.questionText, other.questionText)) {
            return false;
        }
        if (!Objects.equals(this.anwser1, other.anwser1)) {
            return false;
        }
        if (!Objects.equals(this.answer2, other.answer2)) {
            return false;
        }
        if (!Objects.equals(this.answer3, other.answer3)) {
            return false;
        }
        if (!Objects.equals(this.answer4, other.answer4)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Question{" + "questionText=" + questionText + ", anwser1=" + anwser1 + ", answer2=" + answer2 + ", answer3=" + answer3 + ", answer4=" + answer4 + ", correctAnswer=" + correctAnswer + '}';
    }
    
    

    
}
