import java.io.Serializable;

class Guest implements Serializable {
    private String name, contact, email;
    private int stayDuration;

    public Guest(String name, String contact, String email, int stayDuration) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.stayDuration = stayDuration;
    }

    public int getStayDuration() { return stayDuration; }

    @Override
    public String toString() {
        return name + " (Contact: " + contact + ", Email: " + email + ")";
    }
}