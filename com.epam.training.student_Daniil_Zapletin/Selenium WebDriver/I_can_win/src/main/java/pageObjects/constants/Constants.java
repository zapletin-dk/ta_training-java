package pageObjects.constants;

public class Constants {
    public static class TimeOutVariable {
        public static final int EXPLICIT_WAIT = 5;
        public static final String PAGE_URL = "https://pastebin.com/";
        public static final String INPUT_TEXT = "Hello from WebDriver";
        public static final String TITLE_TEXT = "helloweb";
    }

    public static class Selectors {
        public static final String inputFormSelector = "//textarea[@id='postform-text']";
        public static final String pasteExpirationSelectSelector = "//span[@id='select2-postform-expiration-container']";
        public static final String pasteExpirationChoiceSelector = "//li[text()='10 Minutes']";
        public static final String pasteNameInputFieldSelector = "//*[@id='postform-name']";
        public static final String submitButtonSelector = "//button[text() = 'Create New Paste']";
    }
}
