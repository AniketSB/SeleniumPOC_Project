package UtilsLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;

import java.util.Optional;

public class CaptureRequest {

    DevTools devTools;

    public void captureHttpRequest(WebDriver driver){
        devTools= ((ChromeDriver)driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.<Integer>empty(),Optional.<Integer>empty(),Optional.<Integer>empty()));
        devTools.addListener(Network.requestWillBeSent(),
                entry->{
                    System.out.println("Request URL is "+entry.getRequest().getUrl());
                    System.out.println("Request type is "+entry.getRequest().getMethod());
        });
    }
}
