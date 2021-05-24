package tcpplugin.fragum.tech;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import java.net.*;
import java.io.*;

@CapacitorPlugin(name = "TcpPlugin")
public class TcpPluginPlugin extends Plugin {

    private TcpPlugin implementation = new TcpPlugin();
    private Socket socket;

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void connect(String host, int port)
    {
        try (this.socket = new Socket(host, port)) {

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }

    @PluginMethod
    public String ConnectAndRunCommand(String hostname, int port, String command)
    {
      String response = "";

      try (Socket socket = new Socket(hostname, port)) {
        OutputStream output = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(output, true);
        writer.println(command);

        InputStream input = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line;

        while ((line = reader.readLine()) != null) {
          response += line + "\n";
        }
      } catch (UnknownHostException ex) {
          System.out.println("Server not found: " + ex.getMessage());
      } catch (IOException ex) {
          System.out.println("I/O error: " + ex.getMessage());
      }

      return response;
    }
}
