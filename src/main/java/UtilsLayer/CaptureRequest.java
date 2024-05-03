package UtilsLayer;

import BaseLayer.BaseClass;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v121.network.Network;
import org.openqa.selenium.devtools.v121.network.model.RequestId;
import org.openqa.selenium.devtools.v121.network.model.Response;
import org.openqa.selenium.devtools.v121.network.model.ResponseReceived;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class CaptureRequest extends BaseClass {

    DevTools devTools;

    public void captureHttpRequest(WebDriver driver) {
        try {
            devTools = ((ChromeDriver) driver).getDevTools();
            devTools.createSession();
            devTools.send(Network.enable(Optional.<Integer>empty(), Optional.<Integer>empty(), Optional.<Integer>empty()));
            Set<String> statusCodes = new HashSet<>();
            devTools.addListener(Network.requestWillBeSent(),
                    entry -> {
//                    System.out.println("Request URL is "+entry.getRequest().getUrl());
//                    System.out.println("Request type is "+entry.getRequest().getMethod());
                    });
            final RequestId[] requestId = new RequestId[1];
            devTools.addListener(Network.responseReceived(),
                    responseReceived -> {
                        Response response = responseReceived.getResponse();
                        requestId[0] = responseReceived.getRequestId();

                            System.out.println("Status and response url's are: ");
                            System.out.println(responseReceived.getResponse().getStatus() + " " + responseReceived.getResponse().getUrl());

                            List<List<Object>> data = getLists(responseReceived);

                        ExcelWrite.writeDataToExcel(p.getProperty("writeExcelPath"), data);

                    });

        } finally {
            System.out.println("In finally");
        }

    }

    private static List<List<Object>> getLists(ResponseReceived responseReceived) {
        if (responseReceived!=null) {
            String url = responseReceived.getResponse().getUrl();
            int statusCode = responseReceived.getResponse().getStatus();
            List<List<Object>> data = new ArrayList<>();
            List<Object> row = new ArrayList<>();
            row.add("Status");
            row.add("Url");
            data.add(row);

            List<Object> row1 = new ArrayList<>();
            row1.add(url);
            row1.add(statusCode);
            data.add(row1);
            return data;
        }
        return null;
    }
}