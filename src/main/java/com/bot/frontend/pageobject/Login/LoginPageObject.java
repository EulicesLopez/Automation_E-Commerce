package com.bot.frontend.pageobject.Login;

import com.bot.frontend.baseClass.web.BaseClass;
import com.bot.frontend.helpers.Hook;
import com.bot.frontend.utility.ExcelReader;
import com.bot.frontend.utility.ExtentReportUtil;
import com.bot.frontend.utility.GenerateWord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;

import static com.bot.frontend.baseClass.web.CommonComponents.cargarBrowser;

public class LoginPageObject extends BaseClass {

    public static WebDriver driver;
    static GenerateWord generateWord = new GenerateWord();

    private static final String EXCEL_WEB = "excel/DATA_PRUEBA.xlsx";
    private static final String EXCEL_SHEET = "Login";
    private static final String COLUMNA_URL = "URL";
    private static final String COLUMNA_USERNAME = "Username";
    private static final String COLUMNA_PASSWORD = "Password";
// selenium

    public static String BTN_LOGIN = "login2";
    public static String INPUT_USERNAME = "loginusername";
    public static String INPUT_PASSWORD = "loginpassword";
    //public static String BTN_ACEPTAR = "//*[@id=\"logInModal\"]/div/div/div[3]/button[2]";
    public static String BTN_ACEPTAR = "//button[contains(text(),'Log in')]";


    public LoginPageObject() {
        this.driver = Hook.getDriver();
    }

    private static List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, EXCEL_SHEET);
    }

    public static void ingresoALaUrlDemoblaze(String casoDePrueba) throws Throwable {
        try {
            int valores = Integer.parseInt(casoDePrueba) - 1;
            String url = getData().get(valores).get(COLUMNA_URL);
            driver.get(url);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se inició correctamente la página Demoblaze");
            generateWord.sendText("Se inició correctamente la página del Demoblaze");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            //ExcelReader.writeCellValue(EXCEL_WEB, EXCEL_SHEET, 1, 5, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }


    public static void ingresoDatosLogin(String casoDePrueba) throws Throwable {

        try {
            int valores = Integer.parseInt(casoDePrueba) - 1;
            String usernameData = getData().get(valores).get(COLUMNA_USERNAME);
            String passwordData = getData().get(valores).get(COLUMNA_PASSWORD);
            click(driver, "id", BTN_LOGIN);
            sendKeyValue(driver, "id", INPUT_USERNAME, usernameData);
            sendKeyValue(driver, "id", INPUT_PASSWORD, passwordData);
            click(driver, "xpath", BTN_ACEPTAR);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se Ingresa los datos de login: Usuario: " + usernameData + " Contraseña: " + passwordData);
            generateWord.sendText("Se Ingresa los datos de login: Usuario: " + usernameData + " Contraseña: " + passwordData);
            generateWord.addImageToWord(driver);
            sleep2(7);
        } catch (Exception e) {
            //ExcelReader.writeCellValue(EXCEL_WEB, EXCEL_SHEET, 1, 5, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }

    }


    public static void verificarAccesoLogin() throws Throwable {
        try {


            ExtentReportUtil.INSTANCE.stepPass(driver, "Se verifica acceso Correcto Login ");
            generateWord.sendText("Se verifica acceso Correcto Login");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }

    }


    /*------------------------------------------------------------------------------------------------------*/
    public static void cargarWeb() throws Throwable {
        try {
            cargarBrowser(driver, "https://www.demoblaze.com/");
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresó a la pagina web Demoblaze");
            generateWord.sendText("Se ingresó a la pagina web Demoblaze");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

    /*------------------------------------------------------------------------------------------------------*/
}
