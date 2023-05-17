package mailPageObjects;

public class Constants {
    public static final int EXPLICIT_WAIT = 5;
    public static final String MAIL_PAGE_URL = "https://yopmail.com/";
    public static final String GENERATE_NEW_EMAIL_LINK = "//h3[contains(text(),'Случайный адрес электронной почты')]";
    public static final String GENERATED_EMAIL = "//div[@id='egen']";
    public static final String CHECK_MAIL_BOX_BUTTON = "//button[@onclick = 'egengo();']";
    public static final String TOTAL_ESTIMATED_COST = "//td/h3[contains(text(), 'USD')]";
}
