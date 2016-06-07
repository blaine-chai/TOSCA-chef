package com.blainechai;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by blainechai on 2016. 6. 7..
 */
public class ChefUtil {

    public static void createCookbooks(ToscaParser parser) {
        for (Object key : parser.nodeTemplate.keySet()) {
            ArrayList tmpList = ToscaParser.getNodeByKey((Map) parser.nodeTemplate.get(key), "type");
//            Thread tx = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for(int i=0;i<100;i++){
//                        System.out.println(i);
//                    }
//                }
//            });
//            tx.start();
            if (!tmpList.isEmpty()) {
                if (ToscaParser.isLeafNode(tmpList.get(0)) && !tmpList.get(0).equals("Compute")) {
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            createCookbook((String) key);
                        }
                    });
                    t.start();
                } else
                    System.out.println(tmpList.get(0));
            } else {
                System.err.println("TOSCA document is incomplete.");
            }
        }
    }

    private static void createCookbook(String cookbookName) {
        String[] command = new String[1];
        command[0] = "knife cookbook create " + cookbookName;
        try {
            byCommonsExec(command, Constants.CHEF_KNIFE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void execKnifeStatus(String cookbookName) {
        String[] command = new String[1];
        command[0] = "knife node status";
        try {
            byCommonsExec(command, Constants.CHEF_KNIFE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void execKnife(String cookbookName) {
        String[] command = new String[1];
        command[0] = "knife cookbook create " + cookbookName;
        try {
            byCommonsExec(command, Constants.CHEF_KNIFE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void byCommonsExec(String[] command)
            throws IOException, InterruptedException {
        DefaultExecutor executor = new DefaultExecutor();
        CommandLine cmdLine = CommandLine.parse(command[0]);
        for (int i = 1, n = command.length; i < n; i++) {
            cmdLine.addArgument(command[i]);
        }
        executor.execute(cmdLine);
    }

    private static void byCommonsExec(String[] command, String uri)
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
