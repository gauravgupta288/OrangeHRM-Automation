package com.orangehrm.framework.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecFactory {
        public static RequestSpecification getDefaultSpec() {
            return new RequestSpecBuilder()
                    .setBaseUri("https://opensource-demo.orangehrmlive.com")
                    .addHeader("Accept", "application/json")
                    .addHeader("Accept-Language", "en-US,en;q=0.9")
                    .addHeader("Cache-Control", "no-store, no-cache, must-revalidate, post-check=0, pre-check=0")
                    .addHeader("Connection", "keep-alive")
                    .addHeader("DNT", "1")
                    .addHeader("Referer", "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers")
                    .addHeader("Sec-Fetch-Dest", "empty")
                    .addHeader("Sec-Fetch-Mode", "cors")
                    .addHeader("Sec-Fetch-Site", "same-origin")
                    .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Safari/537.36")
                    .addHeader("sec-ch-ua", "\"Google Chrome\";v=\"137\", \"Chromium\";v=\"137\", \"Not/A)Brand\";v=\"24\"")
                    .addHeader("sec-ch-ua-mobile", "?0")
                    .addHeader("sec-ch-ua-platform", "\"Windows\"")
                    .addCookie("orangehrm", "38oebkjsh9tna13b5h5uf4dgc0")
                    .build();
        }
    }

