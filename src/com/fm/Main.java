package com.fm;

import com.fm.controller.ControllersController;
import com.fm.ui.ComprehensiveForm;
import com.fm.ui.DoctorScreen;
import com.fm.ui.HospitalManagementScreen;
import com.fm.ui.MainMenu;

public class Main {
    public static void main(final String[] args) throws Exception {
        hibernateCheck();
//        new Thread(()-> {
//            MainMenu mm = new MainMenu();
//            mm.setVisible(true);
//        }).run();
//        new Thread(()->{
//            new DoctorScreen().setVisible(true);
//        }).run();
//        new Thread(() -> {
//            new ComprehensiveForm().setVisible(true);
//        }).run();
        new Thread(()->{
            new HospitalManagementScreen().setVisible(true);
        }).run();
    }

    private static void hibernateCheck() {
        //Hibernate checkers
        //Sample.putSampleData();
        ControllersController.main();
    }
}
