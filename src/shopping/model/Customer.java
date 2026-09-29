package shopping.model;

public class Customer {
    private String name;
    private String email;
    private long mobileNumber;
    private boolean member;

    public Customer() {
        this("Guest", "guest@example.com", 0L, false);
    }

    public Customer(String name, String email, long mobileNumber) {
        this(name, email, mobileNumber, false);
    }

    public Customer(String name, String email, long mobileNumber, boolean member) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.member = member;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        if (mobileNumber >= 0) {
            this.mobileNumber = mobileNumber;
        }
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public String getShortName() {
        String cleaned = name.trim();
        if (cleaned.isEmpty()) {
            return "Guest";
        }
        return cleaned.substring(0, 1).toUpperCase()
                + cleaned.substring(1).toLowerCase();
    }

    @Override
    public String toString() {
        return String.format("Customer{name='%s', email='%s', member=%s}",
                name, email, member);
    }
}
