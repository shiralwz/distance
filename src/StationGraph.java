import java.io.*;
import java.util.*;

// In the graph, every vertex represents a station.
public class StationGraph {
    private final int INFINITE = Integer.MAX_VALUE;              // the max distance between two stations
    private final int ELEMENT_NOT_EXISTED = -1;
    private int num_stations = 0;                                 // the amount of the stations
    private int[][] distance;                                     // keep all the distances between any 2 arbitrary stations
    private int[][] path;                                          //
    private Set<String> station_names = new HashSet<>();          // keep all the stations names

    public boolean createGraph(String fileStationGraph) throws IOException {
        File file = new File(fileStationGraph);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;

        while ((line = reader.readLine()) != null) {
            if (!line.trim().equals("")) {
                break;
            }
        }

        String[] stations = line.split(",");
        for (String station : stations) {
            if (station.trim().equals("")) {
                continue;
            }

            if (!station_names.add(station.trim().toUpperCase())) { // Convert them to upper case, for easy comparison
                System.err.println("Staion \"" + station + "\" had already exited, omitted it.");
            }
        }

        num_stations = station_names.size();
        if (num_stations == 0) {
            return false;
        }

        distance = new int[num_stations][num_stations];
        path = new int[num_stations][num_stations];

        for (int row = 0; row < num_stations; ++row) {
            for (int col = 0; col < num_stations; ++col) {
                distance[row][col] = (row == col) ? 0 : INFINITE;
                //path[row][col] = col;
                path[row][col] = (row == col) ? col : -1;
            }
        }

        int lineCount = 0;
        while ((line = reader.readLine()) != null) {
            ++lineCount;
            if (line.trim().equals("")) {
                continue;
            }

            String edge[] = line.trim().split(",");
            if (edge.length != 3) {
                System.err.println("Line " + lineCount + ": \"" + line + "\" Invalid edge description, " +
                        "only 3 parts needed: Source, Destination and Their Distance, omitted this line.");
                continue;
            }

            try {
                String src = edge[0].trim();
                String dst = edge[1].trim();
                int dist = Integer.parseInt(edge[2]);
                int srcIndex = getStationIndex(src);
                int dstIndex = getStationIndex(dst);

                if (validEdge(src, dst, dist)) {
                    distance[srcIndex][dstIndex] = dist;
                    path[srcIndex][dstIndex] = dstIndex;
                }
                else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("Line " + lineCount + ": \"" + line + "\" Invalid edge, omitted this line.");
                continue;
            }
        }
        reader.close();

        return true;
    }

    public void printGraph() {
        System.out.println("\nThe Adjacent Matrix: ");
        printMatrix(distance);
    }

    public void printPath() {
        System.out.println("\nThe Final Path Matrix: ");
        printMatrix(path);
    }

    public void getShortestDists() {
        // "n" represents a intermediate station
        for (int n = 0; n < num_stations; ++n) {
            for (int src = 0; src < num_stations; ++src) {
                for (int dst = 0; dst < num_stations; ++dst) {
                    if ((distance[src][n] != INFINITE) && (distance[n][dst] != INFINITE)) {
                        if (distance[src][dst] > distance[src][n] + distance[n][dst]) {
                            distance[src][dst] = distance[src][n] + distance[n][dst];
                            path[src][dst] = path[src][n];
                        }
                    }
                }
            }
        }
    }

    public void printShortestDists(String source, String destination) {
        String src = source.trim().toUpperCase();
        String dst = destination.trim().toUpperCase();
        if (!validStation(src) || !validStation(dst)) {
            System.err.println("Invalid station name(s)");
            return;
        }

        System.out.print(src + " -> " + dst);
        int indexSrc = getStationIndex(src);
        int indexDst = getStationIndex(dst);

        if (distance[indexSrc][indexDst] == INFINITE) {
            System.out.println(": UNREACHABLE");
        }
        else {
            System.out.print("   Distance: " + distance[indexSrc][indexDst] + "   Path: " + src);

            int temp = path[indexSrc][indexDst];
            while (temp != indexDst) {
                System.out.print(" -> " + station_names.toArray()[temp]);
                temp = path[temp][indexDst];
            }
            System.out.println(" -> " + dst);
        }
    }

    public void printAllShortestDists() {
        System.out.println("\nPrint all the shortest paths and distances between two arbitrary stations: ");
        for (String src : station_names) {
            for (String dst: station_names) {
                printShortestDists(src, dst);
            }
            System.out.println();
        }
    }

    public void printStations() {
        System.out.println("\nPrint all the stations: ");
        for (String station_name: station_names) {
            System.out.println(station_name);
        }
    }

    private void printMatrix(int[][] matrix) {
        Formatter formatter = new Formatter(System.out);

        Object[] stations = station_names.toArray();
        formatter.format("%6s", "");
        for (int i = 0; i < num_stations; ++i){
            formatter.format("%6s", (String)stations[i]);
        }
        System.out.println();

        for (int row = 0; row < num_stations; ++row) {
            formatter.format("%6s", stations[row]);
            for (int col = 0; col< num_stations; ++col) {
                if (matrix[row][col] == INFINITE) {
                    formatter.format("%6s", "INF");
                }
                else {
                    formatter.format("%6d", matrix[row][col]);
                }
            }
            System.out.println();
        }
    }

    // Apart from the sequence numbers of the source and destination are valid,
    // the distance between them should be at least 0.
    private boolean validEdge(String src, String dst, int distance) {
        return (validStation(src) && validStation(dst) && (distance >= 0));
    }

    private boolean validStation(String station) {
        return (getStationIndex(station) != ELEMENT_NOT_EXISTED);
    }

    private int getStationIndex(String station_name) {
        int index = 0;
        for (String station: station_names) {
            if (station.toUpperCase().equals(station_name)) {
                return index;
            }
            ++index;
        }

        return ELEMENT_NOT_EXISTED;
    }
}
