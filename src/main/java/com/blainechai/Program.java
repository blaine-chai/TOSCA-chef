package com.blainechai;

/**
 * Created by blainechai on 2016. 4. 12..
 */

@SuppressWarnings("unchecked")
public class Program {

    public static void main(String[] args) {
        ToscaParser parser = new ToscaParser(Constants.TOSCA_FILE_PATH + Constants.TOSCA_FILE_NAME);

        ChefUtil.createCookbooks(parser);
        ChefUtil.addInterface(parser);
        ChefUtil.uploadCookbooks();
        ChefUtil.bootstrap(Constants.NODE_NAME, Constants.NODE_URL, parser);
    }

}
