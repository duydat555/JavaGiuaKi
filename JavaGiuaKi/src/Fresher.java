class Fresher extends Employee {
    private String graduationDate;
    private String graduationRank;
    private String education;

    public Fresher(int id, String fullName, String birthDay, String phone, String email, String graduationDate, String graduationRank, String education) {
        super(id, fullName, birthDay, phone, email, "Fresher");
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Graduation Date: " + graduationDate);
        System.out.println("Graduation Rank: " + graduationRank);
        System.out.println("Education: " + education);
    }

    public static void Employee_count() {
        employeeCount++;
    }
    @Override
    public String toFileString() {
        return super.toFileString() + "," + graduationDate + "," + graduationRank + "," + education;
    }
}