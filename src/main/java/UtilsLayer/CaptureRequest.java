package UtilsLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v121.network.Network;
import org.openqa.selenium.devtools.v121.network.model.RequestId;
import org.openqa.selenium.devtools.v121.network.model.Response;
import org.testng.Assert;

import java.util.Optional;
import java.util.Properties;

public class CaptureRequest {

    DevTools devTools;

    Properties p;

    public void captureHttpRequest(WebDriver driver){
        devTools= ((ChromeDriver)driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.<Integer>empty(),Optional.<Integer>empty(),Optional.<Integer>empty()));
        devTools.addListener(Network.requestWillBeSent(),
                entry->{
                    System.out.println("Request URL is "+entry.getRequest().getUrl());
                    System.out.println("Request type is "+entry.getRequest().getMethod());
        });
        final RequestId[]  requestId = new RequestId[1];
        devTools.addListener(Network.responseReceived(),
                entry->{
                    Response response = entry.getResponse();
                    requestId[0] = entry.getRequestId();

                    if (response.getUrl().contains("automationexercise.com")) {
                        System.out.println(entry.getResponse().getStatus() + " " + entry.getResponse().getUrl());
                        if (response.getStatus()==200) {
                            String responseBody = devTools.send(Network.getResponseBody(requestId[0])).getBody();
                            System.out.println("Response Body is *** " + responseBody);
                        }
                    }
                });
    }
}
