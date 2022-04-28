package api.tests.service;

import com.google.common.io.CharStreams;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import static java.util.Arrays.asList;

public class RunCommandViaSsh {

    private static final String SSH_HOST = "192.168.1.69";
    private static final int SSH_PORT = 22;
    private static final String SSH_LOGIN = "remote";
    private static final String SSH_PASSWORD = "123456";

    public static List<String> runCommand(String command) throws JSchException {
        Session session = setupSshSession();
        session.connect();

        ChannelExec channel = (ChannelExec) session.openChannel("exec");
        try {
            channel.setCommand(command);
            channel.setInputStream(null);
            InputStream output = channel.getInputStream();
            channel.connect();

            String result = CharStreams.toString(new InputStreamReader(output));
            return asList(result.split("\n"));

        } catch (JSchException | IOException e) {
            closeConnection(channel, session);
            throw new RuntimeException(e);

        } finally {
            closeConnection(channel, session);
        }
    }
    public static void runCommand(String command, Boolean await) throws JSchException {
        Session session = setupSshSession();
        session.connect();

        ChannelExec channel = (ChannelExec) session.openChannel("exec");
        channel.setCommand(command);
        channel.connect();

    }
    private static Session setupSshSession() throws JSchException {
        Session session = new JSch().getSession(SSH_LOGIN, SSH_HOST, SSH_PORT);
        session.setPassword(SSH_PASSWORD);
        session.setConfig("PreferredAuthentications", "publickey,keyboard-interactive,password");
        session.setConfig("StrictHostKeyChecking", "no"); // disable check for RSA key
        return session;
    }

    private static void closeConnection(ChannelExec channel, Session session) {
        try {
            channel.disconnect();
        } catch (Exception ignored) {
        }
        session.disconnect();
    }
}
