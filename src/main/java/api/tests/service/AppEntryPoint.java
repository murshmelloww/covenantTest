package api.tests.service;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class AppEntryPoint
{
    private static final String HOST = "192.168.1.69";
    private static final int PORT = 22;
    private static final String USERNAME = "remote";
    private static final String PASSWORD = "123456";

    public static void transferFile(String fileName) throws IOException
    {
        ScpUploader scpUploader = ScpUploader.newInstance();

        try
        {
            scpUploader.connect(HOST, PORT, USERNAME, PASSWORD);
        }
        catch(JSchException e)
        {
            System.err.println("Failed to connect the server!");
            e.printStackTrace();
            return;
        }

        System.out.println("Successfully connected to the server!");

        byte[] fileBytes = Files.readAllBytes(Paths.get("src/test/resources/" + fileName));

        try
        {
            scpUploader.uploadFile("/test/files", fileName, fileBytes, true); // if overwrite == false, it won't throw exception if the file exists
            System.out.println("Successfully uploaded the file!");
        }
        catch(SftpException e)
        {
            System.err.println("Failed to upload the file!");
            e.printStackTrace();
        }

        scpUploader.disconnect();
    }
}
