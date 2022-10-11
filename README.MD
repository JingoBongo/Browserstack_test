This is semi-short on how to use basic Browserstack features
For testing I started by creating free account here: https://www.browserstack.com/

Then, together with account you are provided with BS username and key (navigate to products -> browserstack automate -> Access Key)

For entire thing to work you need to get a tunnel application.
It is can be .exe / other types of executables for other OSes or a Java dependency

.exe example: 

    https://www.browserstack.com/browserstack-local/BrowserStackLocal-win32.zip

Java dependency:

    <dependency>
    <groupId>com.browserstack</groupId>
    <artifactId>browserstack-local-java</artifactId>
    <version>1.0.6</version>
    </dependency>

I think binary (they call .exe a binary; there is also a way to use common local application) 
might be preferred because it can be launched from cmd/terminal

Links for local binaries:

    https://www.browserstack.com/docs/local-testing/releases-and-downloads

Actually, there is a guide that I personally consider not that useful, but nonetheless:

    https://automate.browserstack.com/dashboard/v2/quick-start/integrate-test-suite-step

Actual demo recreation:
We start a tunnel to their machines using our key:

    win: .\BrowserStackLocal.exe --key Azo4heERqqeUXpTFuKRy

    mac/linux: ./BrowserStackLocal --key Azo4heERqqeUXpTFuKRy

There should be a message displayed after some time:

    [SUCCESS] You can now access your local server(s) in our remote browser

It would mean you can start using RemoteWebDriver

Then, for actual code that will run the test is the BSDemo.java file. It is very small,
silly and probably doesn't comply with any framework standards, but it gets the job done

Open it, for 'try how it works' you can use my username and key but won't be able to validate the result,
so you better change it to yours.

Same goes for path to chromedriver. It is needed only if you decide to comment RemoteWebDriver and uncomment the
usual one, but still.

Then. We have a tunnel opened in the terminal (keep the terminal opened) and we have a file to execute. Run the file.
Console output will be the same as you expect, but there will be no new tabs opened.

Navigate to dashboard (link):

    https://automate.browserstack.com/dashboard/v2/

There in bottom left corner you will see the build that you just executed. The logs, screenshots and even a video 
(video used to be kept on their servers for 30 days if I remember it right) are provided for each test.

You can try that with debug breakpoints in your code, open interactive sessions and just see how it goes yourself.

What we used to use BS for is to use it together with Jenkins and Allure reports to execute all tests in parallel and see the 
results in every possible way after the fact. We used to use configs for most BS settings (screen resolution, browser type and version,
OS type and version, etc),
pom.xml to specify Cucumber options (this way you can provide specific tags for example).
In order to use it with Jenkins that means Jenkins needs that tunnel opened as well. I believe username and key were stored in config.

What I haven't tried back then but I saw an opportunity now: deep in the examples Browserstack said we can test on LOCAL websites as well somehow,
but that needs some investigation, at the moment I am not competent enough. I haven't touched BS for a year and haven't tried running it with local
webpage at all.

I hope you find this information useful! 

Note: free account is limited to 100 minutes of time on their machines spent

