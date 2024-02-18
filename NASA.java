import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class NASA {


    public NASA() throws FileNotFoundException {
    }

    public static void main(String[] args) throws Exception {

//        Задание 1


        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пожалуйста месяц в формате: ....MM...");
        System.out.print("Ввод: ");
        String month = scanner.nextLine();
        System.out.println("Введите пожалуйста год в формате: ....гггг");
        System.out.print("Ввод: ");
        String year = scanner.nextLine();

        for (int day = 1; day < 31; day++) {


            String dayStr = "";
            if (day < 10) {
                dayStr = "0" + day;
            } else {
                dayStr = String.valueOf(day);

            }


            String page = downloadWebPage("https://api.nasa.gov/planetary/apod?api_key=Cm7dFs696SM5PC7wmZkeu6Jl4fGDYjmuEyumBXpZ&date=" + year + "-" + month + "-" + dayStr);
            int urlBegin = page.lastIndexOf("url");
            int urlEnd = page.lastIndexOf("}");
            String url = page.substring(urlBegin + 6, urlEnd - 1);
            try (InputStream in = new URL(url).openStream()) {
                Files.copy(in, Paths.get(day + ".jpg"));
            }
            System.out.println("day " + dayStr + " saved");
            int explanationBegin = page.lastIndexOf("explanation");
            int explanationEnd = page.lastIndexOf("hdurl");
            if (explanationEnd != -1) {
                String explanation = page.substring(explanationBegin + 13, explanationEnd - 3);
                System.out.println(explanation);
            }
            System.out.println("Picture saved!");

//            Задание 2


        PrintWriter writer = new PrintWriter("all pictures.html");
        writer.println("<IMG SRC=\"1.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"2.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"3.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"4.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"5.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"6.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"7.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"8.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"9.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"10.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"11.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"12.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"13.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"14.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"15.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"16.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"17.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"18.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"19.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"20.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"21.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"22.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"23.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"24.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"25.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"26.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"27.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"28.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"29.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
        writer.println("<IMG SRC=\"30.jpg\" "
                + "WIDTH= \"600\" HEIGHT= \"400\" BORDER=\"7\" USEMAP=\"#chart \">");
//
        writer.close();


    }
//
    }


    private static String downloadWebPage(String url) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;

        URLConnection urlConnection = new URL(url).openConnection();
        urlConnection.addRequestProperty("User-Agent", "Mozilla");
        urlConnection.setReadTimeout(5000);
        urlConnection.setConnectTimeout(5000);

        try (InputStream is = urlConnection.getInputStream(); BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
        }
        return result.toString();

    }
}
//