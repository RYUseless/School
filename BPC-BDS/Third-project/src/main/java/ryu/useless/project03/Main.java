package ryu.useless.project03;

import ryu.useless.project03.config.DataSetupConfig;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n---------- BDS 03 PROJECT START   -----------------");
        System.out.println("---------- FROM HERE STARTS MAIN SECTION ----------\n");

        if (args != null && args.length > 0) {
            DataSetupConfig.initializeDataSource(args[0]); //connect to bds docker
        } else {
            DataSetupConfig.initializeDataSource(null);
        }
        FakeMain.main(args); //starting FakeMain :)
    }
}
