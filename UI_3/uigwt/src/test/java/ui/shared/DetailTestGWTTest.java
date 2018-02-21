package ui.shared;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DetailTestGWTTest {
    @Test
    void getPassed() {
        DetailTestGWT detailTestGWT = new DetailTestGWT(0, 70, 30, 0.0, 1, "");
        assertEquals(true, detailTestGWT.getPassed());

        DetailTestGWT detailTestGWT2 = new DetailTestGWT(0, 69, 31, 0.0, 1, "");
        assertEquals(false, detailTestGWT2.getPassed());
    }
}