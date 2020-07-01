package ru.netology.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    Radio radio = new Radio();

    @Test
    public void shouldSetNextCurrentChannel(){

        radio.setCurrentChannel(4);
        radio.nextChannel();
        assertEquals(5,radio.getCurrentChannel());

    }

    @Test
    public void shouldSetPreviousCurrentChannel(){

        radio.setCurrentChannel(8);
        radio.previousChannel();
        assertEquals(7,radio.getCurrentChannel());

    }

    @Test
    public void shouldSetPreviousAfterMinChannel(){

        radio.setCurrentChannel(0);
        radio.previousChannel();
        assertEquals(9,radio.getCurrentChannel());

    }

    @Test
    public void shouldSetNextAfterMaxChannel(){

        radio.setCurrentChannel(9);
        radio.nextChannel();
        assertEquals(0,radio.getCurrentChannel());

    }

    @Test
    public void shouldIncreaseCurrentVolume(){

        radio.setCurrentVolume(5);
        radio.increaseCurrentVolume();
        assertEquals(6,radio.getCurrentVolume());

    }

    @Test
    public void shouldDecreaseCurrentVolume(){

        radio.setCurrentVolume(7);
        radio.decreaseCurrentVolume();
        assertEquals(6,radio.getCurrentVolume());

    }

    @Test
    public void shouldDecreaseMinVolume(){

        radio.setCurrentVolume(0);
        radio.decreaseCurrentVolume();
        assertEquals(0,radio.getCurrentVolume());

    }

    @Test
    public void shouldIncreaseMaxVolume(){

        radio.setCurrentVolume(10);
        radio.increaseCurrentVolume();
        assertEquals(10,radio.getCurrentVolume());

    }

    @Test
    public void shouldIncreaseOverMaxVolume() {

        radio.setCurrentVolume(15);
        radio.increaseCurrentVolume();
        assertEquals(10, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseOverMaxVolume(){

        radio.setCurrentVolume(15);
        radio.decreaseCurrentVolume();
        assertEquals(9,radio.getCurrentVolume());

    }

    @Test
    public void shouldDecreaseUnderMinVolume(){

        radio.setCurrentVolume(-5);
        radio.decreaseCurrentVolume();
        assertEquals(0,radio.getCurrentVolume());

    }

    @Test
    public void shouldIncreaseUnderMinVolume(){

        radio.setCurrentVolume(-13);
        radio.increaseCurrentVolume();
        assertEquals(1,radio.getCurrentVolume());

    }

    @Test
    public void TurnPreviousChannelUnderMinChannel(){

        radio.setCurrentChannel(-5);
        radio.previousChannel();
        assertEquals(9,radio.getCurrentChannel());

    }

    @Test
    public void TurnNextChannelOverMaxChannel(){

        radio.setCurrentChannel(11);
        radio.nextChannel();
        assertEquals(0,radio.getCurrentChannel());

    }
// Ввод с пульта

    @Test
    public void shouldSetChannelFromRemoteNormal (){

        radio.setCurrentChannel(5);
        assertEquals(5,radio.getCurrentChannel());

    }

    @Test
    public void shouldSetChannelFromRemoteMax (){

        radio.setCurrentChannel(9);
        assertEquals(9,radio.getCurrentChannel());

    }

    @Test
    public void shouldSetChannelFromRemoteMin (){

        radio.setCurrentChannel(0);
        assertEquals(0,radio.getCurrentChannel());

    }

    @Test
    public void shouldSetChannelFromRemoteOverMax (){

        radio.setCurrentChannel(14);
        assertEquals(9,radio.getCurrentChannel());

    }

    @Test
    public void shouldSetChannelFromRemoteUnderMin (){

        radio.setCurrentChannel(-3);
        assertEquals(0,radio.getCurrentChannel());

    }

}
