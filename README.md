# Amazon Product Detail Scrapper
This application generates a list of top 4 search results of any search term on amazon.in. This doesn't make use of the Product Search API from Amazon but it utilizes a Headless Chrome Browser process to simulate the tasks that you would perform on a browser window and parses the relavant information from the HTML response.

## Headless Browser
A headless browser is a browser process that runs in the background and is capable of simulating all the actions that can be performed on a browser UI, such as filling forms, navigating pages etc. This app uses a Selenium process with a Chrome Driver in Headless mode.

## Prerequisites
Java 1.8+

Windows Machine - The project contains Web Driver only for Chrome on Windows

Google Chrome 85.0.4183.38+ - The Bundled Chrome Driver supports minimum this version of Chrome

## Running the Program
1. Download the amazonscrapper.jar and ChromeDriver.exe file from the target directory to your Windows machine. Make sure both these files exist at the same location on your machine.
2. Use the following command using command prompt from the directory (in which the downloaded files exist) to run the app

    ```java -jar amazonscrapper.jar <search term>```

    e.g.  ```java -jar amazonscrapper.jar books```

3. If the search term is multi-word, enclose it in double-quotes

    ```java -jar amazonscapper.jar "fiction books"```

## Sample Output

```
[ {
  "productName" : "Moby Dick or, the Whale",
  "productImageUrl" : "https://m.media-amazon.com/images/I/81cVhKhMVCL._AC_UY218_.jpg",
  "productPrice" : "199",
  "bestProductReview" : {
    "reviewerName" : "biswadeep g.",
    "reviewTitle" : "Good service by amazon",
    "reviewText" : "The book is simply great. When it comes to the classic literature i always i like the fingerprint publishing. The paper quality is good and also price is cheap."
  }
}, {
  "productName" : "U n Me . . . itÆs Complicated",
  "productImageUrl" : "https://m.media-amazon.com/images/I/41UYp7tr7UL._AC_UY218_.jpg",
  "productPrice" : "169",
  "bestProductReview" : {
    "reviewerName" : "Amreen Shaikh",
    "reviewTitle" : "must read",
    "reviewText" : "Its always very excited to read Aditya sir's books as it has everything you are looking for.\nFirst of all it feels great to receive signed copy that too of your favorite author.\nAs the first book this one also has won my heart completely.\nFrom start till end everything is just excellent.\nIts a complete package of Love, care, friendship,trust and misunderstanding.\nBest part is his stories are true, real, pure and genuine.\nLove you sir.\nAll the very best."
  }
}, {
  "productName" : "All the Light we Cannot See",
  "productImageUrl" : "https://m.media-amazon.com/images/I/71ZX-2C+9lL._AC_UY218_.jpg",
  "productPrice" : "228",
  "bestProductReview" : {
    "reviewerName" : "Ashwini A.",
    "reviewTitle" : "An absolute must-read",
    "reviewText" : "The language in the book is perhaps one of the most important bits, it is written with such rich and lively details that at times, I could almost see myself in places where Marie-Laure was or where Werner was. That was one of the most brilliant things about the book. There are many more. I think the fact that the author could transport me to that time period, make me as tense as Marie-Laure or Werner just makes me so happy?\n\nIs happy a word to be used when talking about this book, this time period? Maybe not but the author did make me very happy. ItÆs very important to me that I feel connected to the characters and transported to places in the books and it did that and more.\n\nThe book jumps from time periods of Marie-LaureÆs and WernerÆs life, from their teen years to their younger years and back and forth. Sometimes it was a bit confusing to keep track of it, sometimes because it was an e-book, it was even frustrating to not be able to flip back to the pages I lost my thread. (An actual paperback really helps with this, it just gives me satisfaction if nothing else.)\n\nEverything about the book made me fall in love with it. There are the usual World War II horrors and you canÆt escape them, most times, I was so acutely uncomfortable with the scene but I moved ahead anyway. This book is an absolute must-read if you like reading about the World War II. Not because itÆs super informative or because thereÆs tons of other things that could make you relate to the people of the times more. ItÆs more to understand how it felt for the children, for those who grew up in Germany and had to join HitlerÆs army. For the children who had nobody left, those who couldnÆt do much for themselves. Marie-Laure and Werner might be fictional but there were real people who were in their places at some point. They must have faced countless problems and horrors.\n\nIt is that feeling that makes me think that people should really read it.\n\nI have a lot of wonderful things to say about it and I could say it but thereÆs also the one bit that I felt almost unnecessary in the book. Yes, the hunt for the Sea of Flames. The diamond. That part always felt unnecessary and almost tacked on as if it was an afterthought. I am not saying I didnÆt enjoy the fantasy of it and there was a realistic part to it but at the same time, it just didnÆt click with the rest of the book.\n\nHowever that does not negate all the awesome things about this book and so, this remains a five-star book.\n\nI would recommend it to anyone who loves to read World War II fiction or who wants to see how language can be elevated to this level. If you wanna read in leisure, you totally can!! This book, despite it being based during the World War II, has an almost unhurried pace to it. ItÆs just me who wouldnÆt stop reading.\n\nAnd if you still have any doubts about this book, itÆs worth mentioning that it won the Pulitzer Prize for Fiction in 2015. So, thereÆs that?"
  }
}, {
  "productName" : "A Thousand Splendid Suns",
  "productImageUrl" : "https://m.media-amazon.com/images/I/81DFcrQgjrL._AC_UY218_.jpg",
  "productPrice" : "310",
  "bestProductReview" : {
    "reviewerName" : "Zeeshan Ahmed",
    "reviewTitle" : "Beauty is..",
    "reviewText" : "I had this book for two years, for two years I had been shying away to muster up the courage to read it. Why was I reluctant? Because I knew it had a deep, profound, soul awakening message, a message which I wasn't willing to look in the eye and whole heartedly accept. There are such books, believe me that can speak to you without you even reading them. This book has that mystical power.\n\nWhen I did, a week ago I was engulfed by the beauty of Khaled's writing.\nBeauty is when you are not willing to believe the characters are fictional.\nBeauty is when you decide with firm conviction that maybe, in some distant future your child will bear the name 'Aziza'\nBeauty is when your weeping becomes second nature, when you begin to understand the great human suffering .\nWhen you realise that you have been gifted. The mere things that we've been taking for granted, the things that we have at our disposal every single day, there are people out there for whom this may seem as a dream, maybe a dream never fulfilled.\nYou will realize one thing for sure -\nTo respect and honor Human Beings. For a great deal has been endured by humanity.\nFor every person we encounter has a story, wants to be understood, every person wants to be embraced, has dreams, wants to be seen.\n\nWhen you realise this you will start serving, uplifting, giving instead of wanting and getting.\n\nThis book will break you.\nBreak your ego.\nBreak your desire for needs shoved through the wrath of consumerism.\nIt will break your heart into a million shards.\n\nI urge you to read this unforgettable book. Let it take you down heartbreak zone. And liberate a sense of empathy, compassion and meaning that is in you, already. And that which the world so desperately needs."
  }
} ]

```

## Assumption
Amazon is sometimes notorious for publishing full page promotions for a searched product. For e.g. following is sometimes returned for search term - Mobile Phones. https://imgur.com/1JTtUH4
The scrapper app is written to support standard search results like https://imgur.com/IpuMOeG
