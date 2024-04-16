class Experience extends Employee {
    private int expInYear;
    private String proSkill;

    public Experience(int id, String fullName, String birthDay, String phone, String email, int expInYear, String proSkill) {
        super(id, fullName, birthDay, phone, email, "Experience");
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Years of Experience: " + expInYear);
        System.out.println("Professional Skill: " + proSkill);
    }

    public static void Employee_count() {
        employeeCount++;
    }
}