package Automation.common;

public class LocatorsCRM {

    //Trang Login CRM
    public static String headerLoginPage = "//h1[normalize-space()='Login']";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String buttonLogin = "//button[normalize-space()='Login']";
    public static String linkForgotPassword = "//a[normalize-space()='Forgot Password?']";
    public static String checkboxRememberMe = "//input[@id='remember']";

    //Trang Dashboard
    public static String menuDashboard = "//ul[@id='side-menu']//span[normalize-space()='Dashboard']";
    public static String menuCustomers = "//ul[@id='side-menu']//span[normalize-space()='Customers']";
    public static String menuProjects = "//ul[@id='side-menu']//span[normalize-space()='Projects']";

    //Trang Customers List
    public static String buttonAddNewCustomers = "//a[normalize-space()='New Customer']";
    public static String buttonImportCustomers = "//a[normalize-space()='Import Customers']";
    public static String buttonContacts = "//a[contains(@href,'all_contacts')]";    //Cách 2: "//a[normalize-space()='Import Customers']/following-sibling::a[normalize-space()='Contacts']"
    public static String headerCustomerPage = "//span[normalize-space()='Customers Summary']";
    public static String buttonSearchCustomers = "//div[@id='clients_filter']//input[@aria-controls='clients']";
    public static String firstItemCustomerOnTable = "//tr[@class='has-row-options odd']//td[@class='sorting_1']/a";

    //Add new customers
    public static String inputCompany = "//input[@id='company']";
    public static String inputVAT = "//input[@id='vat']";
    public static String inputPhone = "//input[@id='phonenumber']";
    public static String inputWebsite = " //input[@id='website']";
    public static String dropdownGroups = "//button[@data-id='groups_in[]']";
    public static String inputSearchGroup = "//div[@app-field-wrapper='groups_in[]']//input[@type='search']";
    public static String dropdownCurrency = "//button[@data-id='default_currency']";
    public static String inputSearchCurrency = "//div[@app-field-wrapper='default_currency']//input[@type='search']";
    public static String dropdownLanguage = "//button[@data-id='default_language']";
    public static String inputAddress = "//textarea[@id='address']";
    public static String inputCity = "//input[@id='city']";
    public static String inputState = "//input[@id='state']";
    public static String inputZipCode = "//input[@id='zip']";
    public static String dropdownCountry = "//button[@data-id='country']";
    public static String inputSearchCountry = "//div[@app-field-wrapper='country']//input";
    public static String buttonSaveAndCreateContact = "//button[normalize-space()='Save and create contact']";
    public static String buttonSaveCustomer = "//div[@id='profile-save-section']//button[normalize-space()='Save']";

    //Trang Add new customer contact
    public static String menuContacts = "//a[normalize-space()='Contacts']";
    public static String headerContactPage = "//h4[normalize-space()='Contacts']";
    public static String buttonAddNewContact = "//a[normalize-space()='New Contact']";
    public static String inputSearchContacts = "//input[@class='form-control input-sm']";
    public static String headerAddNewContactDialog = "//h4[normalize-space()='Add new contact']";
    public static String inputProfileImage = "//input[@id='profile_image']";
    public static String inputFirstName = "//input[@id='firstname']";
    public static String inputLastName = "//input[@id='lastname']";
    public static String inputPosition = "//input[@id='title']";
    public static String inputEmailContact = "//input[@id='email']";
    public static String inputPhoneContact = "//input[@id='phonenumber']";
    public static String buttonGeneratePassword = "//a[@class='generate_password']";
    public static String buttonShowPassword = "//a[@class='show_password']";
    public static String inputPasswordContact = "//input[@name='password']";
    public static String checkboxDoNotSendEmail = "//input[@id='donotsendwelcomeemail']";
    public static String buttonSaveContact = "//form[@id='contact-form']//button[normalize-space()='Save']";
    public static String buttonCloseAddNewContact = "//form[@id='contact-form']//button[normalize-space()='Close']";
    public static String firstItemContactOnTable = "//td[@class='sorting_1']/a";



    //Trang Project List
    public static String buttonNewProject = "//div[@id='wrapper']/descendant::a[normalize-space()='New Project']";
    public static String inputSearch = "//div[@id='projects_filter']/descendant::input";


    //Add new project
    public static String inputProjectName = "//label[text()='Project Name']/following-sibling::input";
    public static String dropdownCustomer = "//label[text()='Customer']/following-sibling::div";
    public static String inputSearchCustomer = "//div[@id='bs-select-6']/preceding-sibling::div/input";
    public static String checkboxCalculateProgress = "//div[@id='tab_project']/descendant::input[@id='progress_from_tasks']";
    public static String sliderProject = "//span[@class='label_progress']/following::div[contains(@class,'project_progress')]";
    public static String dropdownBillingType = "//label[text()='Billing Type']/following-sibling::div";
    public static String dropdownStatus = "//label[normalize-space()='Status']/following-sibling::div";
    public static String inputRatePerHour = "//label[normalize-space()='Rate Per Hour']//following-sibling::input";
    public static String inputEstimatedHours = "//label[normalize-space()='Estimated Hours']/following-sibling::input";
    public static String dropdownMembers = "//label[normalize-space()='Members']/following-sibling::div";
    public static String inputSearchMembers = "//button[@title='Admin Example']/following-sibling::div//input";
    public static String buttonSelectAllMember = "//button[@title='Admin Example']/following-sibling::div//button[normalize-space()='Select All']";
    public static String buttonDeselectAllMember = "//button[@title='Admin Example']/following-sibling::div//button[normalize-space()='Deselect All']";
    public static String inputStartDate = "//label[@for='start_date']/following-sibling::div//input";
    public static String inputDeadline = "//label[normalize-space()='Deadline']/following-sibling::div//input";
    public static String dropdownTags = "//label[normalize-space()='Tags']/following-sibling::ul";
    public static String inputDescription = "//div[@id='mceu_15-body']/descendant::div[@id='mceu_34']";
    public static String checkboxSendProject = "//div[@id='tab_project']/descendant::div//input[@id='send_created_email']";
    public static String buttonSaveProject = "//button[normalize-space()='Save']";

}
