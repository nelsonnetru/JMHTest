package org.example;

import lombok.Getter;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@Getter
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1, warmups = 1)
@Threads(1)
public class App {

    final static String testString1 = "ggfdsgfsgfdsgf\ndsgfdsgfsgfhjhlkhkj;lhfgjhg\ngfgfdgfdgfdgfdgfd[]{}gfdgfdgfddgfdgfdgfdgfdgfdgfdgadjfohrfvnjknjxvnkdfs8778943y2rhrnjgfjksdfhnfgjkfdsy89743r843{}ur434r3{}vgfdgfdndjkgnfdjkgnfjdkngjfkdngjfkdgnjfdkn{}jkngjfkd\"njkgf][ndjgkfndjkgnfdjk\"gnjkfdnjk" +
            "ggfdsgfsgfdsgf\ndsgfdsgfsgfhjhlkhkjlhfgjhg\ngfgfdgfdgfdgfdgfd[]{}gfdgfdgfddgfdgfdgfdgfdgfdgfdgadjfohrfvnjknjxvnkdfs8778943y2rhrnjgfjksdfhnfgjkfdsy89743r843{}ur434r3{}vgfdgfdndjkgnfdjkgnfjdkngjfkdngjfkdgnjfdkn{}jkngjfkd\"njkgf][ndjgkfndjkgnfdjk\"gnjkfdnjk" +
            "ggfdsgfsgfdsgfdsgfdsgfsgfhjhlkhkjlhfgjhggfgfdgfdgfdgfdgfd[]{}gfdgfdgfddgfdgfdg\nfdgfdgfdgfdgadjfohrfvnjknjxvnkdfs8778943y2rhrnjgfjksdfhnfgjkfdsy89743r843{}ur434r3{}vgfdgfdndjkgnfdjkgnfjdkngjfkdngjfkdgnjfdkn{}jkngjfkdnjkgf][ndjgkfndjkgnfdjkgnjkfdnjk +ggfdsgfsgfdsgf" +
            "dsgfdsgfsgfhjhlkhkj;lhfgjhggfgfdgfdgfdgfdgfd[]{}gfdgfdgfddgfdgfdgfdgfdgfdgfdgadjfohrfvnjknjxvnkdfs8778943y2rhrnjgfjksdfhnfgjkfdsy89743r843{}ur434r3{}vgfdgfdndjkgnfdjkgnfjdkngjfkdngjfkdgnjfdkn{}jkngjfkdnjkgf][ndj\ngkfndjkgnfdjkgnjkfdnjk" +
            "ggfdsgfsgfdsgfdsgfdsgfsgfhjhlkhkj;lhfgjh\nggfgfdgfdgfdgfdgfd[]{}gfdgfdgfddgfdgfdgfdgfdgfd\ngfdgadjfohrfvnjknjxvnkdfs8778943y2rhrnjgfjksdfhnfgjkfd\nsy89743r843{}ur434r3{}vgfdgfdndjkgnfdjkgnfjdkngjfkdngjfkdgnjfdkn{}jkngjfkdnjkgf][ndjgkfndjkgnfdjkgnjkf" +
            "ggfdsgfsgfdsgfdsgfdsgfsgfhjh\"lkhkj;lhfg\"jhggfgfdgfdgfdgfdgfd[]{}gfdgfdgfddgfdgfdgfdgfdgfdgfdgadjfohrf\nvnjknjxvnkdfs8778943y2rhrnjgfjksdfhnfgjkfdsy{}89743r843{}ur434r3{}vgfdgfdndjkgnfdjkgnfjdkngjfkdngjfkdgnjfdkn{}jkngjfkdnjkgf][ndjgkfndjkgnfdjkgnjkf" +
            "ggfdsgfsgfdsgfdsgfdsgfsgfhjhlkhkj;lhfgjhggfgfdgfdgf\ndgfdgfd[]{}gfdgfdgfddgfdgfdgfdgf\ndgfdgfdgadjfohrfvnjknjxvnkdfs8778943y2rhrnjgfjksdfhnfgjkfdsy89743r843{}ur434r3{}vgfdgfdndjkgnfdjk{}gnfjdkngjfkdngjfkdgnjfdkn{}jk\nngjfkdnjkgf][ndjgkfndjkgnfdjkgnjkf" +
            "ggfdsgfsgfdsgfdsgfdsg\nfsgfhjhlkhkj;lhfgjhggfgfdgfdgfdgfdgfd[]{}gfdgfd\ngfddgfdgfdgfdgfdgfdgfdgadjfohrfvnjknjxvnkdfs8778943y2rhrnjgfjksdfhnfgjkfdsy89743r843{}ur434r3{}vgfdgfdndjkgnfdjkgnfjdkngjfkdngjfkdgnjfdkn{}jkngjfkdnjkgf][ndjgkfndjkgnfdjkgnjkf" +
            "ggfdsgfsgfdsgfdsgfdsgfs\ngfhjhl khkj;lhfgjhggfgfdgfdgfdgfdgfd[]{}gfdgfdgfddgfdgfdgfdgfdgfdgfdgadjfohrfvnjknjxvnkdfs8778943y2rhrnjgfjksdfhnfgjkf\ndsy89743r843{}u\nr434r3{}vgfdgfdndjkgnfdjkgnfjdkngjfkdngjfkdgnjfdkn{}jkngjfkdnjkgf][ndjgkfndjkgnfdjkgnjkf" +
            "ggfdsgfsgfdsgfdsgfdsgfsgfhjhlkhkj;lhfgj hggfgfdgfdgfdgfdgfd[]{}gfdgfdgfddgfdgfdgfdgf\ndgfdgfdgadjfohrfvnjknjxvnkdfs8778943y2rhrnjgfjksdfhnfgjkfdsy89743r843{}ur434r3{}vgfdgfdndjkgnfdjkgnfjdkngjfkdngjfkdgnjfdkn{}jkngjfkdnjkgf][ndjgkfndjkgnfdjkgnjkf" +
            "ggfdfff{}{}sgfsgfdsgfdsgfdsgfsgfhjhlkhkj;lhfgjhggfgfd\ngfdgfdgfdgfd[]{}gfdgfdgfddgfdgfdgfdgfdgfdgfdgadjfohrfvnjknjxvnkdfs8778943y2rhrnjgfjksdfhnfgjkfdsy89743r843{}ur434r3{}vgfdgfdndjkgnfd[]jkgnfjdkngjfkd{}ngjfkdgnjfdkn{}jkngjfkdnjkgf][ndjgkfndjkgnfdjkgnjkf" +
            "gg  fdsgfsgfdsgfdsgfdsgfs\ngfhjhlkhkj;lhfgjhggfgfdgfdgfdgfdgfd[]{}gfdgfdgfddgfdgfdgfdgfdgfdgfdgadjfo\nhrfvnjknjxvnkdfs8778943y2rhrnjgfjksdfhnfgjkfdsy89743r843{}ur434r3{}vgfdgfdndjkgnfdjkgnfjdkngjf[]kdngjfkdgnjfdkn{}jkngjfkdnjkgf][ndjgkfndjkgnfdjkgnjkf" +
            "gg  fdsgfsgfdsgfdsgfdsgfsgf\nhjhlkhkj;lhfgjhggfgfdgfdgfdgfdgfd[]{}gfdgfdgfddgfdgfdgfdgfdgfdgfdgadjfohrfvnjknjxvnkdfs8778943y2rhrnjgfjksdfhnfgjkfdsy89743r843{}ur434r3{}vgfdgfdndjkgnfdjkgn\nfjdkngjfkdngjfkdgnjfdkn{}jkngjfkdnjkgf][ndjgkfndjkgnfdjkgnjkf" +
            "gg  fdsgfsgfdsgfdsgfdsgfsgfhjhlkhkj;lhfgjhggfgfdgfdg\nfdgfdgfd[]{}gfdgfdgfddgfdgfdgfdgfdgfdgfdgadjfohrfvnjknjxvnkdfs8778943y2rhrnjgfjksdfhnfgjkfdsy89743r843{}ur434r3{}vgfdgfdndjkgnfdjkgnfjdkngjfkdngjfkdgnjfdkn{}jkngjfkdnjkgf][ndjgkfndjkgnfdjkgnjkf" +
            "gg  fdsg fsgfdsgfdsgfdsgfsgfhj\nhlkhkj;lhfgjhggfgfdgfdgfdgfdgfd[]{}g\nfdgfdgfddgfdgfdgfdgfdgfdgfdga\ndjfohrfvnjknjxvnkdfs8778943y2rhrnjgfjksdfhnfgjkfdsy89743r843{}ur434r3{}vgfdgfdndjkgnfdjk\ngnfjdkngjfkdngjfkdgnjfdkn{}jkngjfkdnjkgf][ndjgkfndjkgnfdjkgnjkf" +
            "gg  fdsgfsgfdsgfdsgfdsgfsgfh jhlkh\nkj;lhfgjhggfgfdgfdgfdgfdgfd[]{}gfdgfdgfddgfdgfdgf\"dgfdgfdgfdgadjfohrfvnjknjxvnkdfs8778943y2rhrnjgfjksdfhnfgjkfdsy89743r843{}ur434r3{}vgfdgfdndjkgnfdjkgnfjdkngjfkdngjfkdgnjfdkn{}jkngjfkdnjkgf][ndjgkfndjkgnfdjkgnjkf" +
            "gg  fdsgfsgfdsgfdsgfdsgfsgfhjhlkhkj;lhfgjhggfgfdgfdgfdgfdgfd[]{}gfdgfdgfddgfdgfdgfdgfdgfdgfdgadjfohrfvnjknjxvnkdfs8778943y2rhrnjgfjksdfhnfgjkfdsy89743r843{}ur434r3{}v\ngfdgfdndjkgnfdjkgnfjdkngjfkdngjfkdgnjfdkn{}jkngjfkdnjkgf][ndjgkfndjkgnfdjkgnjkf" +
            "gg  fdsgfs gfdsgfdsgfdsgfsgfhjhlkhkj;lhfgjhggfgfdgfdgfdgfdgfd[]{}gfdgfdgfddgfdgf\ndgfdgfdgfdgfdgadjfohrfvnjknjxvnkdfs8778943y2rhrnjgfjksdfhnfgjkfdsy89743r843{}ur434r3{}vgfdgfdndjkgnfdjkgnfjdkng\njfkdngjfkdgnjfdkn{}jkngjfkdnjkgf][ndjgkfndjkgnfdjkgnjkf" +
            "gg  fdsgfsgfdsgfdsgfdsgfsgfhjhlkhkj;lhf\ngjhggfgfdgfdgfdgfdgfd[]{}gfdgfdgfddgfdgfdgfdgfdgfdgfdgadj\nfohrfvnjknjxvnkdfs8778943y2rhrnjgfjksdfhn\nfgjkfdsy89743r843{}ur434r3{}vgfdgfdndjkgnfd{}jkgnfjdkngjfkdngjfkdgnjfdkn{}jkngjfkdnjkgf][ndjgkfndjkgnfdjkgnjkf" +
            "gg  fdsgfsgfdsgfdsgfdsgfsgfhjhlkhkj;lhfgjhggfgfdgfdgfdgfdgfd[]{}gfdgfdgfddgfdgfdgfdgfdgfdgfdgadjfohrfvnjknjxvnkdfs8778943y2rhrnjgfjksdfhnfgjkfdsy89743r843{}ur434r3{}vgfdgfdndjkgnfdjkgnfjdkngjfkdngjfkdgnjfdkn{}jkngjfkdnjkgf][ndjgkfndjkgnfdjkgnjkf";

    static String testString = testString1 + testString1 + testString1 + testString1 + testString1 +testString1 +testString1 +testString1 +testString1;

    @State(Scope.Benchmark)
    public static class TemplateModel {
    }

    @Benchmark
    public String getTemplateValue(TemplateModel arg0) {
        return testString.replaceAll("\"", "'").replaceAll("\n", "").replace("[]", "{}");
    }

    @Benchmark
    public String getTemplateValueFast(TemplateModel arg0) {
        return myReplaceAll(
                myReplaceAll(
                        myReplaceAll(testString,"\"","'"),
                        "\n","" ),
                "[]","{}");
    }

    public String myReplaceAll(String str, String target, String replacement) {
        int end = str.indexOf(target);
        if (end == -1) return str;

        int targetLength = target.length();
        StringBuilder result;
        int start = 0;

        for (result = new StringBuilder(str.length()); end != -1; end = str.indexOf(target, start)) {
            result.append(str, start, end).append(replacement);
            start = end + targetLength;
        }
        result.append(str, start, str.length());
        return result.toString();
    }


    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}