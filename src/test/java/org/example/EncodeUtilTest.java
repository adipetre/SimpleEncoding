package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// This test class verifies only the public function.
class EncodeUtilTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldEncodeRepeatedCharacters() {
        assertEquals(
                "w4a3d1e1x6",
                EncodeUtil.encode("wwwwaaadexxxxxx")
        );
    }

    @Test
    void shouldEncodeSingleCharacter() {
        assertEquals(
                "a1",
                EncodeUtil.encode("a")
        );
    }

    @Test
    void shouldReturnEmptyStringForEmptyInput() {
        assertEquals(
                "",
                EncodeUtil.encode("")
        );
    }

    @Test
    void shouldReturnEmptyStringForNullInput() {
        assertEquals(
                "",
                EncodeUtil.encode(null)
        );
    }

    @Test
    void shouldEncodeNumbersAndSpecialCharacters() {
        assertEquals(
                "dg12dg22dg32!2",
                EncodeUtil.encode("112233!!")
        );
    }

    @Test
    void shouldTreatUppercaseAndLowercaseAsDifferentCharacters() {
        assertEquals(
                "a2A2",
                EncodeUtil.encode("aaAA")
        );
    }

    @Test
    void shouldEncodeSeparatelyBatchesOfSameCharacterInDifferentPlaces() {
        assertEquals(
                "w4a3d1e1x6w4a3d1e1x6",
                EncodeUtil.encode("wwwwaaadexxxxxxwwwwaaadexxxxxx")
        );
    }

    @Test
    void shouldEncodeCombinedStrings() {
        assertEquals(
                "w4a3d1e1x6w4a3d1e1x6dg12dg22dg32!2 1w4a3d1e1x6w4a3d1e1x6",
                EncodeUtil.encode("wwwwaaadexxxxxxwwwwaaadexxxxxx112233!! wwwwaaadexxxxxxwwwwaaadexxxxxx")
        );
    }

    @Test
    void shouldEncodeLongOccurencesStrings() {
        assertEquals(
                "w20dg124@20",
                EncodeUtil.encode("wwwwwwwwwwwwwwwwwwww111111111111111111111111@@@@@@@@@@@@@@@@@@@@")
        );
    }


}