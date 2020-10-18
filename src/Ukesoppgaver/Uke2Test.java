package Ukesoppgaver;

import static org.junit.jupiter.api.Assertions.*;

class Uke2Test {

    @org.junit.jupiter.api.Test
    void min1() {
        int a[] = {22, 3,43, 9, 6};

        String minimun = Uke2.min1(a, 0, 2);

        assertEquals(1, minimun);
    }
}