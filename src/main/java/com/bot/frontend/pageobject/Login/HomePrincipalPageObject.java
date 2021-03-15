package com.bot.frontend.pageobject.Login;

import com.bot.frontend.baseClass.web.BaseClass;
import com.bot.frontend.helpers.Hook;
import com.bot.frontend.utility.ExcelReader;
import com.bot.frontend.utility.ExtentReportUtil;
import com.bot.frontend.utility.GenerateWord;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;


public class HomePrincipalPageObject extends BaseClass {

    public WebDriver driver;
    static GenerateWord generateWord = new GenerateWord();

    private static final String EXCEL_WEB = "excel/DATA_PRUEBA.xlsx";
    private static final String EXCEL_SHEET = "Shop";
    private static final String COLUMNA_CATEGORIA = "Categoria";
    private static final String COLUMNA_PRODUCTO1 = "Producto1";
    private static final String COLUMNA_PRODUCTO2 = "Producto2";
    private static final String COLUMNA_PRODUCTO3 = "Producto3";
    private static final String COLUMNA_PRODUCTO4 = "Producto4";
// selenium

    public static String BTN_HOME = "//*[@id=\"navbarExample\"]/ul/li[1]/a";
    //public static String BTN_HOME = "//body/nav[@id='narvbarx']/div[@id='navbarExample']/ul[1]/li[1]/a[1]";
    public static String BTN_CATEGORIA_PHONES = "//a[contains(text(),'Phones')]";
    public static String BTN_CATEGORIA_LAPTOPS = "//a[contains(text(),'Laptops')]";
    public static String BTN_CATEGORIA_MONITORS = "//a[contains(text(),'Monitors')]";


    public static String comprobarItem;
    public static int precioProducto1;
    public static int precioProducto2;
    public static int precioProducto3;
    public static int sumaPrecioProductos;
    public static int totalOrden;


    public HomePrincipalPageObject() {
        this.driver = Hook.getDriver();
    }

    private static List<HashMap<String, String>> getData1() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, EXCEL_SHEET);
    }

    public void seleccionarCategoria(String categoria) throws Throwable {
        try {
            int valores = Integer.parseInt(categoria) - 1;
            String categoriaData = getData1().get(valores).get(COLUMNA_CATEGORIA);
            String producto1Data = getData1().get(valores).get(COLUMNA_PRODUCTO1);

            switch (categoriaData) {
                case "Phones":
                    driver.findElement(By.linkText(categoria)).click();
                    click(driver, "linktext", BTN_CATEGORIA_PHONES);
                    break;
                case "Laptops":
                    break;
                case "Monitors":
                    break;
                default:
                    break;

            }


            ExtentReportUtil.INSTANCE.stepPass(driver, "Se inició correctamente la página del Agente");
            generateWord.sendText("Se inició correctamente la página del Agente");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            //ExcelReader.writeCellValue(EXCEL_WEB, EXCEL_SHEET, 1, 5, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }


    public void agregarProductosCarrito() throws Throwable {
        seleccionarProductos("Phones", "Samsung galaxy s6");
        seleccionaHome();
        sleep2(2);
        seleccionarProductos("Laptops", "Sony vaio i5");
        seleccionaHome();
        sleep2(2);
        seleccionarProductos("Monitors", "ASUS Full HD");

    }


    public void seleccionarProductos(String categoria, String producto) throws Throwable {
        try {
            //driver.findElement(By.linkText(categoria)).click();
            click(driver, "linkText", categoria);
            sleep2(2);
            //driver.findElement(By.linkText(producto)).click();
            click(driver, "linkText", producto);
            sleep2(2);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se seleccionó la Categoria: " + categoria + "  Producto: " + producto);
            generateWord.sendText("Se seleccionó la Categoria: " + categoria + "  Producto: " + producto);
            generateWord.addImageToWord(driver);

            driver.findElement(By.linkText("Add to cart")).click();

            sleep2(2);
            driver.switchTo().alert().accept();
            sleep2(2);
            driver.findElement(By.linkText("Cart")).click();
            sleep2(2);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Lista de Productos Agregados");
            generateWord.sendText("Lista de Productos Agregados");
            generateWord.addImageToWord(driver);
            comprobarItem = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]")).getText();
            sleep2(2);


        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

    public void verificaPrcios() throws Exception {

        try {
            driver.findElement(By.linkText("Cart")).click();
            sleep2(3);


            totalOrden = Integer.parseInt(driver.findElement(By.id("totalp")).getText());
            precioProducto1 = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[3]")).getText());
            precioProducto2 = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[2]/td[3]")).getText());
            precioProducto3 = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[3]/td[3]")).getText());
            sumaPrecioProductos = precioProducto1 + precioProducto2 + precioProducto3;
            assertThat(precioProducto1, greaterThanOrEqualTo(120));
            assertThat(precioProducto2, greaterThanOrEqualTo(120));
            assertThat(precioProducto3, greaterThanOrEqualTo(120));
            assertThat(sumaPrecioProductos, equalTo(totalOrden));
            if (totalOrden==sumaPrecioProductos){
                System.out.println("La Suma de precios y la orden es igual");
            }

            ExtentReportUtil.INSTANCE.stepPass(driver, "Precio Producto 1: " + precioProducto1+" Soles");
            generateWord.sendTextOnly("Precio Producto 1: " + precioProducto1+" Soles");
            ExtentReportUtil.INSTANCE.stepPass(driver, "Precio Producto 2: " + precioProducto2+" Soles");
            generateWord.sendTextOnly("Precio Producto 2: " + precioProducto2+" Soles");
            ExtentReportUtil.INSTANCE.stepPass(driver, "Precio Producto 3: " + precioProducto3+" Soles");
            generateWord.sendTextOnly("Precio Producto 2: " + precioProducto3+" Soles");
            ExtentReportUtil.INSTANCE.stepPass(driver, "Suma Precio Productos: " + sumaPrecioProductos + "= TotalOrden: " + totalOrden);
            generateWord.sendTextOnly("Suma Precio Productos: " + sumaPrecioProductos + " = TotalOrden: " + totalOrden);

        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }


    public void seleccionaHome() throws Throwable {
        try {
            click(driver, "xpath", BTN_HOME);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }

    }


}
