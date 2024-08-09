package org.example;

import lombok.Getter;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@Getter
@State(Scope.Thread)
public class App {

    private String testString;
    private String resultString;

    @Setup
    public void setup() {
        testString = "ggfdsgfsgfdsgf\ndsgfdsgfsgfhjhlkhkj;lhfgjhg\ngfgfdgfdgfdgfdgfd[]{}gfdgfdgfddgfdgfdgfdgfdgfdgfdgadjfohrfvnjknjxvnkdfs8778943y2rhrnjgfjksdfhnfgjkfdsy89743r843{}ur434r3{}vgfdgfdndjkgnfdjkgnfjdkngjfkdngjfkdgnjfdkn{}jkngjfkd\"njkgf][ndjgkfndjkgnfdjk\"gnjkfdnjk";
        resultString = "ggfdsgfsgfdsgfdsgfdsgfsgfhjhlkhkj;lhfgjhggfgfdgfdgfdgfdgfd{}{}gfdgfdgfddgfdgfdgfdgfdgfdgfdgadjfohrfvnjknjxvnkdfs8778943y2rhrnjgfjksdfhnfgjkfdsy89743r843{}ur434r3{}vgfdgfdndjkgnfdjkgnfjdkngjfkdngjfkdgnjfdkn{}jkngjfkd'njkgf][ndjgkfndjkgnfdjk'gnjkfdnjk";
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
    @Fork(value = 1, warmups = 1)
    @Threads(1)
    public String getTemplateValue () {
        return testString.replaceAll("\"", "'").replaceAll("\n", "").replace("[]", "{}");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
    @Fork(value = 1, warmups = 1)
    @Threads(1)
    public String getTemplateValueFast () {
        return myReplaceAll(
                myReplaceAll(
                        myReplaceAll(testString,"\"","'"),
                        "\n","" ),
                "[]","{}");
    }

    public String myReplaceAll(String str, String target, String replacement) {
        StringBuilder result = new StringBuilder(str);
        int targetLength = target.length();
        int strLength = str.length();
        for (int i = 0; i < strLength; i++) {
            int index = result.indexOf(target, i);
            if (index == -1) {
                if (i == 0) return str;
                return result.toString();
            }
            result.replace(index, index + targetLength, replacement);
        }
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}