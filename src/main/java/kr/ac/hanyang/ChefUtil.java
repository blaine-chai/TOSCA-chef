package kr.ac.hanyang;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by blainechai on 2016. 6. 7..
 */
public class ChefUtil {
    private String CHEF_PROJECT_PATH = "";
    private String TOSCA_FILE_PATH = "";

    public ChefUtil() {
    }

    public ChefUtil(String CHEF_PROJECT_PATH, String TOSCA_FILE_PATH) {
        this.CHEF_PROJECT_PATH = CHEF_PROJECT_PATH;
        this.TOSCA_FILE_PATH = TOSCA_FILE_PATH;
    }

    public void uploadCookbooks() {
        String[] command = new String[1];
        command[0] = "knife cookbook upload --all";
        try {
            byCommonsExec(command, CHEF_PROJECT_PATH + Constants.CHEF_KNIFE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void bootstrap(String nodeName, String nodeUrl, ToscaParser parser) {

        ArrayList<String> arrayList = new ArrayList(parser.nodeTemplate.keySet());
        String runList = "";
        runList += "recipe[" + arrayList.get(arrayList.size() - 2) + "]";
        for (int i = arrayList.size() - 2; i > 0; i--) {
            runList += ",recipe[" + arrayList.get(i - 1) + "]";
        }
        System.out.println(runList);

        String[] command = new String[1];
        command[0] = "knife bootstrap " +
                nodeUrl +
                " --ssh-user " +
                "root" +
                " --ssh-password " +
                "'" +
                "password" +
                "'" +
                " --sudo --use-sudo-password --node-name " +
                nodeName +
                " --run-list '" +
                runList +
                "' --node-ssl-verify-mode none -yy";
        try {
            byCommonsExec(command, CHEF_PROJECT_PATH + Constants.CHEF_KNIFE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void createCookbooks(ToscaParser parser) {
        for (Object key : parser.nodeTemplate.keySet()) {
            ArrayList tmpList = ToscaParser.getNodeByKey((Map) parser.nodeTemplate.get(key), "type");
            if (!tmpList.isEmpty()) {
                if (ToscaParser.isLeafNode(tmpList.get(0)) && !((String) tmpList.get(0)).contains("Compute")) {
                    createCookbook((String) key);
                }
            } else {
                System.err.println("TOSCA document is incomplete.");
            }
        }
    }

    public void addInterface(ToscaParser parser) {
        for (Object key : parser.nodeTemplate.keySet()) {
            ArrayList interfaces = ToscaParser.getNodeByKey((Map) parser.nodeTemplate.get(key), "interfaces");
            if (!interfaces.isEmpty()) {
                try {
                    FileWriter fileWriter = new FileWriter(CHEF_PROJECT_PATH + Constants.CHEF_COOKBOOKS_PATH + key + "/" + "recipes/default.rb");
                    fileWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                addInterface((Map) interfaces.get(0), (String) key);
            }
        }
    }

    private void copyFile(String source, String dest)
            throws IOException {
        Files.copy(new File(source).toPath(), new File(dest).toPath(), StandardCopyOption.REPLACE_EXISTING);
    }


    private void addInterface(Map node, String key) {
        for (Object subValueKey : node.keySet()) {
            if (node.get(subValueKey) != null
                    && LinkedHashMap.class.getName().equals(node.get(subValueKey).getClass().getName())) {
                addInterface((Map) node.get(subValueKey), (String) key);
            } else if (node.get(subValueKey).getClass().getName().equals(String.class.getName()) && ((String) node.get(subValueKey)).indexOf(".") > 0) {
                try {
                    copyFile(TOSCA_FILE_PATH + (String) node.get(subValueKey), CHEF_PROJECT_PATH + Constants.CHEF_COOKBOOKS_PATH + key + "/" + Constants.CHEF_COOKBOOKS_DEFAULT_FILE_PATH + (String) node.get(subValueKey));
                    FileWriter fileWriter = new FileWriter(CHEF_PROJECT_PATH + Constants.CHEF_COOKBOOKS_PATH + key + "/" + "recipes/default.rb", true);
                    fileWriter.write("\ncookbook_file '" +
                            Constants.NODE_CHEF_REPO_PATH +
                            node.get(subValueKey) + "' do\n" +
                            "\tsource '" + node.get(subValueKey) + "'\n" +
                            "\taction :create\n" +
                            "\tmode '0777'\n" +
                            "end\n");
                    fileWriter.write("\nexecute '" +
                            key + "_" + subValueKey +
                            "' do\n" +
                            "\tcommand '/bin/bash " +
                            Constants.NODE_CHEF_REPO_PATH +
                            node.get(subValueKey) +
                            "'\n" +
                            "end\n");

                    fileWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void createCookbook(String cookbookName) {
        String[] command = new String[1];
        command[0] = "knife cookbook create " + cookbookName;
        try {
            byCommonsExec(command, CHEF_PROJECT_PATH + Constants.CHEF_KNIFE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void createNode(String nodeName) {
        String[] command = new String[1];
        command[0] = "knife node create " + nodeName + " -d";
        try {
            byCommonsExec(command, CHEF_PROJECT_PATH + Constants.CHEF_KNIFE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void execKnifeStatus(String cookbookName) {
        String[] command = new String[1];
        command[0] = "knife node status";
        try {
            byCommonsExec(command, CHEF_PROJECT_PATH + Constants.CHEF_KNIFE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void execKnife(String cookbookName) {
        String[] command = new String[1];
        command[0] = "knife cookbook create " + cookbookName;
        try {
            byCommonsExec(command, CHEF_PROJECT_PATH + Constants.CHEF_KNIFE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void byCommonsExec(String[] command)
            throws IOException, InterruptedException {
        DefaultExecutor executor = new DefaultExecutor();
        CommandLine cmdLine = CommandLine.parse(command[0]);
        for (int i = 1, n = command.length; i < n; i++) {
            cmdLine.addArgument(command[i]);
        }
        executor.execute(cmdLine);
    }

    private void byCommonsExec(String[] command, String uri)
            throws IOException, InterruptedException {
        DefaultExecutor executor = new DefaultExecutor();
        CommandLine cmdLine = CommandLine.parse(command[0]);
        for (int i = 1, n = command.length; i < n; i++) {
            cmdLine.addArgument(command[i]);
        }
        executor.setWorkingDirectory(new File(uri));
        executor.execute(cmdLine);
    }
}
