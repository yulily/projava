package projava.part5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ALL")
class CalcTest {

    @Test
    void add() {
        assertEquals(4, new Calc().add(2,2), "2 + 2 = 4");
        assertEquals(6, new Calc().add(2,4), "2 + 4 = 6");

        assertThrows(
                NumberFormatException.class,
                () -> Integer.parseInt("¥10,000"), "¥や, が入ってるためパースできない"
        );

        assertDoesNotThrow(
                () -> new Calc().add(-100, 10),
                "負の値は指定しても例外出ない"
        );

        // 途中で失敗しても assertAll 内のものは全て実行される
        assertAll(
                () -> assertEquals(4, new Calc().add(2,2), "2 + 2 = 4"),
                () -> assertEquals(6, new Calc().add(2,4), "2 + 4 = 6")
        );
    }

    void 正の数同士の加算() {
        assertEquals(4, new Calc().add(2,2), "2 + 2 = 4");
        assertEquals(6, new Calc().add(2,4), "2 + 4 = 6");
    }
}