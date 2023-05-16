package pastebinPageObjects.constants;

public class Constants {
    public static class HomePageConstantVariables {
        public static final int EXPLICIT_WAIT = 5;
        public static final String PAGE_URL = "https://pastebin.com/";
        public static final String INPUT_TEXT = """
            git config --global user.name  "New Sheriff in Town"
            git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
            git push origin master --force""";
        public static final String TITLE_TEXT = "how to gain dominance among developers";
    }

    public static class HomePageSelectors {
        public static final String INPUT_FORM_SELECTOR = "//textarea[@id='postform-text']";
        public static final String SYNTAX_HIGHLIGHTING_OPTION_SELECTOR = "//span[@id='select2-postform-format-container']";
        public static final String SYNTAX_HIGHLIGHTING_CHOICE_SELECTOR = "//li[contains(text(),'Bash')]";
        public static final String PASTE_EXPIRATION_OPTION_SELECTOR = "//span[@id='select2-postform-expiration-container']";
        public static final String PASTE_EXPIRATION_CHOICE_SELECTOR = "//li[text()='10 Minutes']";
        public static final String PASTE_TITLE_NAME_SELECTOR = "//*[@id='postform-name']";
        public static final String SUBMIT_BUTTON_SELECTOR = "//button[text() = 'Create New Paste']";
    }

    public static class SubmittedPage {
        public static final String TITLE_TEXT_SELECTOR = "//h1[text()='how to gain dominance among developers']";
        public static final String SYNTAX_HIGHLIGHTING_SELECTOR = "//a[text()='Bash']";
        public static final String PASTE_TEXT_BLOCK_SELECTOR = "//ol[@class='bash']";
        public static final String EXPECTED_SYNTAX_HIGHLIGHTING = "Bash";
    }
}
