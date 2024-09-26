package AutotestCMS.Locators;

public class LocatorsCMS {

    //Trang Login
    public static String headerLoginPage = "//h1[normalize-space()='Welcome to Active eCommerce CMS']";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String buttonLogin = "//button[normalize-space()='Login']";

    //Menu
    public static String menuDashboard = "//span[normalize-space()='Dashboard']";
    public static String menuProducts = "//span[normalize-space()='Products']";
    public static String menuCategory = "//span[normalize-space()='Category']";

    //Trang Category
    public static String headerCategoryPage = "//h1[normalize-space()='All categories']";
    public static String inputSearchCategory = "//input[@id='search']";

    //Trang Add New Category
    public static String buttonAddNewCategory = "//span[normalize-space()='Add New category']";
    public static String headerAddNewCategoryPage = "//span[normalize-space()='Add New category']";
    public static String inputNameCategory = "//input[@id='name']";
    public static String dropdownParentCategory = "//button[@title='No Parent']";
    public static String inputSearchParentCategory = "//div[@class='dropdown-menu show']//input[@aria-label='Search']";
    public static String inputOrderingNumber = "//input[@id='order_level']";
    public static String dropdownType = "//button[@title='Physical']";
    public static String inputBanner = "//label[contains(text(),'Banner')]/following-sibling::div//div[contains(text(),'Browse')]";
    public static String inputIcon = "//label[contains(text(),'Icon')]/following-sibling::div//div[contains(text(),'Browse')]";
    public static String inputMetaTitle = "//label[normalize-space()='Meta Title']/following-sibling::div//input";
    public static String inputMetaDescription = "//textarea[@name='meta_description']";
    public static String dropdownFilteringAttributes = "//button[@title='Nothing selected']";
    public static String inputSearchFilteringAttributes = "//div[@class='dropdown-menu show']//input[@aria-label='Search']";
    public static String buttonSaveCategory = "//button[normalize-space()='Save']";
    public static String inputSearchImage = "//input[@placeholder='Search your files']";
    public static String firstItemSelectFile = "//div[@id='aiz-select-file']/descendant::div[@class = 'card card-file aiz-uploader-select'][1]";
    public static String buttonAddFiles = "//button[normalize-space()='Add Files']";
    public static String xc = "";
    }
