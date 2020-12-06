package lesson5;

public class Main {
    static  String[] dataFullName = {"Nedda Cromar", "Kaitlyn Greedier", "Teriann Benfell", "Florentia Capelin",
            "Donal Danieli", "Darrel Hemphall", "Elena Kelinge", "Nickolai Stanlake",
            "Donall Yitzhakov", "Harwilll Uppett", "Cole Mantrup", "Hale Martynov",
            "Riobard Stanmore", "Byran Ivanyushin", "Tansy Glavis", "Ania Sivess",
            "Yehudit Hallewell", "Golda Natwick", "Jill Velden", "Adelaida Molloy"};

    static String[] dataPosition = {"Pharmacist", "Social Worker", "Technical Writer",
            "VP Sales", "Nurse", "Senior Editor", "Teacher", "Help Desk Operator",
            "Payment Adjustment Coordinator", "Analyst Programmer", "Environmental Specialist",
            "Professor", "Database Administrator I", "Quality Engineer", "Staff Scientist", "Biostatistician IV",
            "Design Engineer", "VP Accounting", "Safety Technician II", "Operator"};

    static String[] dataEmail = {"ncromar0@unesco.org", "kgreedier1@engadget.com", "tbenfell2@4shared.com",
            "fcapelin3@artisteer.com", "ddanieli4@amazon.co.jp", "dhemphall5@odnoklassniki.ru",
            "ekelinge6@deviantart.com", "nstanlake7@cam.ac.uk", "dyitzhakov8@paypal.com",
            "huppett9@amazon.de", "cmantrupa@is.gd", "hmartynovb@sciencedirect.com", "rstanmorec@nydailynews.com",
            "bivanyushind@unesco.org", "tglavise@loc.gov", "asivessf@theguardian.com", "yhallewellg@com.com",
            "gnatwickh@reference.com", "jveldeni@mayoclinic.com", "amolloyj@tmall.com"};

    static String[] dataPhoneNumber = {"708-440-1857", "645-376-3143", "477-909-3026", "234-607-8142", "287-498-6246",
            "214-274-4266", "624-699-8180", "864-845-2490", "827-930-1635", "335-755-6342", "336-653-4659", "702-895-1751",
            "236-492-8291", "107-547-5256", "981-439-5282", "787-192-1778", "910-531-8383", "138-431-2893",
            "972-987-2779", "497-200-8210"};



    public static void main(String[] args) {
        int definitionAge = 40;

        Employee[] employeesArray = new Employee[5];

        for (int i = 0; i < employeesArray.length; i++) {
            String fullName = dataFullName[(int)(Math.random()*dataFullName.length)];
            String position = dataPosition[(int)(Math.random()*dataPosition.length)];
            String email = dataEmail[(int)(Math.random()*dataEmail.length)];
            String phoneNumber = dataPhoneNumber[(int)(Math.random()*dataPhoneNumber.length)];
            double salary = (Math.random()*3000) + 1;
            int age = (int)(Math.random()*70) + 5;
            employeesArray[i] = new Employee(fullName, position, email, phoneNumber, salary, age);
            employeesArray[i].printInfo();
        }

        System.out.println("\n \n");

        for (int i = 0; i < employeesArray.length; i++) {
            if(employeesArray[i].getAge() > definitionAge){
                employeesArray[i].printInfo();
            }
        }

    }
}
