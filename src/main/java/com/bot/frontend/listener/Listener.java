/*
    @author: Abraham Hernandez - TSOFT
*/
package com.bot.frontend.listener;

import com.bot.frontend.utility.ExtentReportUtil;
import com.bot.frontend.utility.FileHelper;

public class Listener {

    private static boolean SE_BORRARON_FILES = false;

    public static void onTestStart(String nombre) {
        try {
            ExtentReportUtil.INSTANCE.createTest(nombre);
        } catch (Exception e) {
            System.out.println("[ERROR CRL-4213] Error en onTestStart: " + e.getMessage());
        }
    }

    public static  void onStart() {
        if (!SE_BORRARON_FILES) {
            FileHelper.borrarElementosFolder("/img");
            SE_BORRARON_FILES = true;
        }
    }

    public static void onFinish() {
        ExtentReportUtil.INSTANCE.flushReport();
    }
}
