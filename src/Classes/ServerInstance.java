package Classes;

public class ServerInstance {

    String hostname = "";
    String portNum = "";

    public ServerInstance(String hostname, String portNum) {
        this.hostname = hostname;
        this.portNum = portNum;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getPortNum() {
        return portNum;
    }

    public void setPortNum(String portNum) {
        this.portNum = portNum;
    }

    @Override
    public String toString() {
        return "hostname=" + hostname + "\n" + "portNum= " + portNum ;
    }
}

