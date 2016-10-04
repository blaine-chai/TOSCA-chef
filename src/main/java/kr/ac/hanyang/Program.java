package kr.ac.hanyang;

/**
 * Created by blainechai on 2016. 4. 12..
 */

@SuppressWarnings("unchecked")
public class Program {

    public static void main(String[] args) {
        ToscaParser parser = new ToscaParser(Constants.TOSCA_FILE_PATH + Constants.TOSCA_FILE_NAME);
//        ToscaParser parser = new ToscaParser(Constants.TOSCA_FILE_PATH + "master-service-template-application.yml");

        ChefUtil chefUtil = new ChefUtil(Constants.CHEF_PROJECT_PATH, Constants.TOSCA_FILE_PATH);
        chefUtil.createCookbooks(parser);
        chefUtil.addInterface(parser);
        chefUtil.uploadCookbooks();
        chefUtil.bootstrap(Constants.NODE_NAME, Constants.NODE_URL, parser);
    }

}
