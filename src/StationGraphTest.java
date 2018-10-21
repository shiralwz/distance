import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.util.Scanner;

public class StationGraphTest {
    public static void main(String[] args) {

        String path = System.getProperty("user.dir");
        String fileStationGraph = path + File.separator + "station_graph";
        BufferedReader buf;
        try {
            String tmpfileName;
            buf = new BufferedReader (new InputStreamReader(System.in));

            System.out.println("Please specify the file path of the station graph (default path \"" + fileStationGraph + "\").");
            tmpfileName = buf.readLine();
            if (!tmpfileName.equals("")) {
                fileStationGraph = tmpfileName;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        StationGraph graph= new StationGraph();
        boolean isCreated = true;
        try {
            isCreated = graph.createGraph(fileStationGraph);
        } catch (IOException e) {
            System.err.println("IO Exception. Graph creation failed.");
            // e.printStackTrace();
            return;
        }

        if (isCreated) {
            graph.printGraph();
            graph.getShortestDists();
            graph.printPath();
            // graph.printStations();

            graph.printAllShortestDists();

            System.out.println("\nPlease input the name of the start and end station: (such as: \"J->G\")");
            Scanner in = new Scanner(System.in);
            String[] stations = in.nextLine().split("->");
            if (stations.length != 2) {
                System.out.println("Invalid station names. Please re-input, such as: \"J->G\"");
                return;
            }
            graph.printShortestDists(stations[0], stations[1]);
        }
    }
}
