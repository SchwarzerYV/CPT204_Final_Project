package ataxx;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScoreTest {

    private static void createMoves(Board b, String[] moves) {
        for (String s : moves) {
            b.createMove(s.charAt(0), s.charAt(1),
                    s.charAt(3), s.charAt(4));
        }
    }


    @Test
    public void testEmptyScore() {
        Board b = new Board();
        assertEquals("2 red vs 2 blue", b.getScore());
    }

    @Test
    public void testSimpleMoveScore() {
        Board b1 = new Board();
        b1.createMove("a7-a6");
        assertEquals("3 red vs 2 blue", b1.getScore());
    }

    @Test
    public void testMoreMoveScore() {
        Board b2 = new Board();
        String[] moves2 = {
                "a7-a6", "a1-c2",
                "g1-f1", "g7-e6"
        };
        createMoves(b2, moves2);
        assertEquals("4 red vs 2 blue", b2.getScore());
    }

    @Test
    public void testComplexScore() {
        Board b3 = new Board();
        String[] moves3 = {
            "a7-a6", "g7-e5",
            "a6-b5", "e5-d7",
            "a6-c7", "a1-a2",
            "a7-a6", "a2-b2",
            "a7-b6", "a2-c1",
            "a7-b7", "c1-e1",
            "g1-f1", "b2-a2",
            "b7-c6", "a2-a3",
            "b5-b3", "a1-b1",
            "c7-d6", "b2-d4",
            "b3-d3", "b1-d1",
            "d3-e2", "a2-b2",
            "d4-b3", "a1-c2",
            "e2-c3", "d1-c1",
            "d3-b1", "d1-f2",
            "c3-e2", "g1-g2",
            "c6-d5", "f2-d4",
            "e2-c4", "g2-e3",
            "c1-d3", "f1-f2",
            "c4-e2", "g1-f3",
            "d4-d2", "f3-f4",
            "c2-e4", "f2-g3",
            "e4-g2", "f4-e5",
            "d7-e6", "f4-f5",
            "d7-f6", "f4-g5",
            "e6-f7", "f5-g6",
            "c7-e7", "f5-g7",
            "e3-f5", "f7-d7",
            "d5-f7", "d7-b5",
            "b7-c5", "a6-b7",
            "d6-c7", "a7-a5",
            "b7-a7", "a5-c3",
            "e2-c2", "b5-b4",
            "a6-c4", "a3-a1",
            "b4-a3", "b1-d1",
            "d3-b1", "e1-g1",
            "f4-e2", "g1-e1",
            "f3-g1", "d1-d3",
            "b1-d1", "c4-e4",
            "d6-c4", "e5-f4",
            "g2-g4", "e5-d5",
            "c3-d4", "c6-a6",
            "c7-a5", "a7-c6",
            "e7-d6", "b5-a7",
            "c6-b5" };
        createMoves(b3, moves3);
        assertEquals("39 red vs 2 blue", b3.getScore());
    }


}
