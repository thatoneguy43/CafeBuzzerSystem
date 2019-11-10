import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

//holds the phone number and/or email of a user
//holds flags to tell if users want email, text, or both.
public class MessageBox implements Serializable {

    private class Message {
        private String email;
        private String phoneNum;
        private boolean pNumFlag = false;
        private boolean emailFlag = false;

        public Message(String em, String pNum) {
            email = em;
            if (em.length() != 0) {
                emailFlag = true;
            }
            phoneNum = pNum;
            if (pNum.length() != 0) {
                pNumFlag = true;
            }
        }

        public boolean hasEmail() {
            return emailFlag;
        }

        public boolean hasPhone() {
            return pNumFlag;
        }

        public String getEmail() {
            return email;
        }

        public String getPhoneNum() {
            return phoneNum;
        }
    }

    private HashMap<Integer, Message> orders;

    public MessageBox() {
        orders = new HashMap<>();
    }

    //inserts a new message into the box
    public Message putMessage(int orderNum, String email, String pNum) {
        Message newOrder = new Message(email, pNum);
        return orders.put(orderNum, newOrder);
    }

    //removes and returns a message from the box
    public Message removeMessage(int orderNum) {
        return orders.remove(orderNum);
    }

    public Set<Integer> getKeys(){
        return orders.keySet();
    }

    public String[] getEmailPhone(int orderNumber) throws NullPointerException{
        String[] emailphone = new String[2];
        Message m = orders.get(orderNumber);
        if(m == null)
            throw new NullPointerException();
        if (m.emailFlag)
            emailphone[0] = m.getEmail();
        if (m.pNumFlag)
            emailphone[1] = m.getPhoneNum();
        return emailphone;
    }

}
