import kr.ac.hanyang.Constants;
import kr.ac.hanyang.ToscaParser;

/**
 * Created by blainechai on 2016. 6. 15..
 */
public class DependencyTest {

    public static void main(String[] args) {
        ToscaParser parser = new ToscaParser(Constants.TOSCA_FILE_PATH + Constants.TOSCA_FILE_NAME);
//        ToscaParser.sortByDependency();
    }
}
