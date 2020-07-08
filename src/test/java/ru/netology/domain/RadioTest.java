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
        Radio radio = new Radio(5);
        radio.setCurrentChannel(0);
        radio.previousChannel();
        assertEquals(5,radio.getCurrentChannel());

    }

    @Test
    public void shouldSetNextAfterMaxChannel(){
        Radio radio = new Radio(8, 8);
        radio.nextChannel();
        assertEquals(0,radio.getCurrentChannel());

    }

    @Test
    public void shouldIncreaseCurrentVolume(){

        radio.setCurrentVolume(50);
        radio.increaseCurrentVolume();
        assertEquals(51,radio.getCurrentVolume());

    }

    @Test
    public void shouldDecreaseCurrentVolume(){

        radio.setCurrentVolume(50);
        radio.decreaseCurrentVolume();
        assertEquals(49,radio.getCurrentVolume());

    }

    @Test
    public void shouldDecreaseMinVolume(){

        radio.setCurrentVolume(0);
        radio.decreaseCurrentVolume();
        assertEquals(0,radio.getCurrentVolume());

    }

    @Test
    public void shouldIncreaseMaxVolume(){

        radio.setCurrentVolume(100);
        radio.increaseCurrentVolume();
        assertEquals(100,radio.getCurrentVolume());

    }

    @Test
    public void shouldIncreaseOverMaxVolume() {

        radio.setCurrentVolume(120);
        radio.increaseCurrentVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseOverMaxVolume(){

        radio.setCurrentVolume(112);
        radio.decreaseCurrentVolume();
        assertEquals(99,radio.getCurrentVolume());

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
    public void shouldTurnPreviousChannelUnderMinChannel(){
        Radio radio = new Radio(6);
        radio.setCurrentChannel(-5);
        radio.previousChannel();
        assertEquals(6,radio.getCurrentChannel());

    }

    @Test
    public void shouldTurnNextChannelOverMaxChannel(){
        Radio radio = new Radio(6);
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
        Radio radio = new Radio(7, 7);

        assertEquals(7,radio.getCurrentChannel());

    }

    @Test
    public void shouldSetChannelFromRemoteMin (){
        Radio radio = new Radio(0, 0);
        assertEquals(0,radio.getCurrentChannel());

    }

    @Test
    public void shouldSetChannelFromRemoteOverMax (){
        Radio radio = new Radio(10);
        radio.setCurrentChannel(11);
        assertEquals(10,radio.getCurrentChannel());

    }

    @Test
    public void shouldSetChannelFromRemoteUnderMin (){

        radio.setCurrentChannel(-3);
        assertEquals(0,radio.getCurrentChannel());

    }

}
