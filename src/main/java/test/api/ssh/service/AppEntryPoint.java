package test.api.ssh.service;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import test.api.ssh.config.ConfigurationManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class AppEntryPoint implements ConfigurationManager
{
    private static final String HOST = configuration.host();
    private static final int PORT = configuration.port();
    private static final String USERNAME = configuration.username();
    private static final String PASSWORD = configuration.password();

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
