# Amazon Product Detail Scrapper
This application generates a list of top 4 search results of any search term on amazon.in. This doesn't make use of the Product Search API from Amazon but it utilizes a Headless Chrome Browser process to simulate the tasks that you would perform on a browser window and parses the relavant information from the HTML response.

## Headless Browser
A headless browser is a browser process that runs in the background and is capable of simulating all the actions that can be performed on a browser UI, such as filling forms, navigating pages etc. This app uses a Selenium process with a Chrome Driver in Headless mode.

## Prerequisites
Java 1.8+

Windows Machine - The project contains only the Web Driver for Chrome on Windows

Google Chrome 85.0.4183.38+ - The Bundled Chrome Driver supports minimum this version of Chrome

## Running the Program
1. Download the jar and ChromeDriver.exe file from the target directory to your Windows machine. Make sure both these files exist at the same location.
2. Use the following command using command prompt from the directory (in which the downloaded files exist) to run the app

    ```java -jar amazonscrapper.jar <search term>```

    e.g.  ```java -jar amazonscrapper.jar books```

3. If the search term is multi-word, enclose it in double-quotes

    ```java -jar amazonscapper.jar "Mobile Phones"```
