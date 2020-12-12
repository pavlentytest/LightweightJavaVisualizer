package com.company;

import org.atpfivt.ljv.LJV;

import java.awt.*;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        // https://dzone.com/articles/what-can-we-learn-from-java-data-structures-visual
        browse(new LJV(), new TreeSet<Integer> (Arrays.asList(5,3,4,3,4)));
    }

    public static void browse(LJV ljv, Object obj) {
        try {
            var dot = URLEncoder.encode(ljv.drawGraph(obj), "UTF8")
                    .replaceAll("\\+", "%20");
            Desktop.getDesktop().browse(
                    new URI("https://dreampuf.github.io/GraphvizOnline/#"
                            + dot));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
