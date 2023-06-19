package com.kata.kataforfunjava.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class KataForFunServiceTest {

    @InjectMocks
    private KataForFunService kataForFunService;

    @Nested
    class ShouldReplaceWithKata {
        @Test
        void should_replace_with_Kata_if_number_is_divisible_by_3() {
            assertThat(kataForFunService.convertNumber(9)).isEqualTo("Kata");
            assertThat(kataForFunService.convertNumber(6)).isEqualTo("Kata");
            assertThat(kataForFunService.convertNumber(12)).isEqualTo("Kata");
        }

        @Test
        void should_replace_with_Kata_if_number_contains_3() {
            assertThat(kataForFunService.convertNumber(3)).isEqualTo("KataKata");
            assertThat(kataForFunService.convertNumber(333)).isEqualTo("KataKataKataKata");
        }
    }

    @Nested
    class ShouldReplaceWithFor {
        @Test
        void should_replace_with_For_if_number_is_divisible_by_5() {
            assertThat(kataForFunService.convertNumber(10)).isEqualTo("For");
            assertThat(kataForFunService.convertNumber(20)).isEqualTo("For");
        }

        @Test
        void should_replace_with_For_if_number_contains_5() {
            assertThat(kataForFunService.convertNumber(5)).isEqualTo("ForFor");
            assertThat(kataForFunService.convertNumber(55)).isEqualTo("ForForFor");
        }
    }



    @Test
    void convert_number_example_guides() {
        assertThat(kataForFunService.convertNumber(1)).isEqualTo("1");
        assertThat(kataForFunService.convertNumber(3)).isEqualTo("KataKata");
        assertThat(kataForFunService.convertNumber(5)).isEqualTo("ForFor");
        assertThat(kataForFunService.convertNumber(7)).isEqualTo("Fun");
        assertThat(kataForFunService.convertNumber(9)).isEqualTo("Kata");
        assertThat(kataForFunService.convertNumber(51)).isEqualTo("KataFor");
        assertThat(kataForFunService.convertNumber(53)).isEqualTo("ForKata");
        assertThat(kataForFunService.convertNumber(33)).isEqualTo("KataKataKata");
        assertThat(kataForFunService.convertNumber(27)).isEqualTo("KataFun");
        assertThat(kataForFunService.convertNumber(15)).isEqualTo("KataForFor");
    }

}
