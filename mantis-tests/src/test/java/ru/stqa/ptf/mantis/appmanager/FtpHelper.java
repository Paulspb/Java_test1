package ru.stqa.ptf.mantis.appmanager;

import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by khomep on 29-Jul-16.
 */
public class FtpHelper {
    private final ApplicationManager app;
    private FTPClient ftp;

    public FtpHelper(ApplicationManager app) {
        this.app = app;
        ftp = new FTPClient();
    }

    public void upload(File file,String target,String backup) throws IOException {
        ftp.connect(app.getProperty("ftp.host"));
        ftp.login(app.getProperty("ftp.logon"), app.getProperty("ftp.password"));
        Boolean nextDir = ftp.changeWorkingDirectory("/config");
        ftp.deleteFile(backup);
        //nextDir = ftp.changeWorkingDirectory("/config");
        ftp.rename(target,backup);
        ftp.enterLocalPassiveMode();
        ftp.storeFile(target, new FileInputStream(file));
        ftp.disconnect();
    }

    public void restore(String backup, String target) throws IOException {
        ftp.connect(app.getProperty("ftp.host"));
        ftp.login(app.getProperty("ftp.logon"), app.getProperty("ftp.password"));
        ftp.changeWorkingDirectory("/config");
        ftp.deleteFile(target);
        ftp.rename(backup, target);
        ftp.disconnect();
    }
}
