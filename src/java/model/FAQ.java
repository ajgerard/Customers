package model;

/**
 *
 * @author tholm
 */
public class FAQ {

    private int FAQID;
    private String question;
    private String answer;

    public FAQ(int FAQID, String question, String answer) {
        this.FAQID = FAQID;
        this.question = question;
        this.answer = answer;
    }
    
    public FAQ() {
        this.FAQID = 0;
        this.question = "";
        this.answer = "";
    }

    public int getFAQID() {
        return FAQID;
    }

    public void setFAQID(int FAQID) {
        this.FAQID = FAQID;
    }

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

    @Override
    public String toString() {
        return "FAQ{" + "FAQID=" + FAQID + ", question=" + question + ", answer=" + answer + '}';
    }

        
    
    
    
    
}
