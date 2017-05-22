package com.souza;

/**
 * Created by csouza on 03/05/17.
 */
public class ReadTest {
    public static void main(String[] args) {
        RSSFeedParser parser = new RSSFeedParser("http://rss.home.uol.com.br/index.xml");
        Feed feed = parser.readFeed(); System.out.println(feed);
        for (FeedMessage message : feed.getMessages()) {
//            System.out.println(message);
            PageParser pageParser = new PageParser(message.getLink());
            pageParser.readPage();
        }

    }
}