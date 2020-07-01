package ru.netology.domain;

public class Radio {
    private int channelMax = 9;
    private int channelMin;
    private int volumeMax = 10;
    private int volumeMin;
    private int currentChannel;
    private int currentVolume;

    public void increaseCurrentVolume(){
        if (currentVolume == volumeMax){
            return;
        }
        this.currentVolume ++;
    }

    public void decreaseCurrentVolume(){
        if (currentVolume == volumeMin){
            return;
        }
        this.currentVolume --;
    }

    public void nextChannel(){
        if (currentChannel == channelMax){
            this.currentChannel = 0;
            return;
        }
        this.currentChannel++;

    }

    public void previousChannel(){
        if (currentChannel == channelMin){
            this.currentChannel = 9;
            return;
        }
        this.currentChannel--;

    }



    public int getChannelMax() {
        return channelMax;
    }

    public void setChannelMax(int channelMax) {
        this.channelMax = channelMax;
    }

    public int getChannelMin() {
        return channelMin;
    }

    public void setChannelMin(int channelMin) {
        this.channelMin = channelMin;
    }

    public int getVolumeMax() {
        return volumeMax;
    }

    public void setVolumeMax(int volumeMax) {
        this.volumeMax = volumeMax;
    }

    public int getVolumeMin() {
        return volumeMin;
    }

    public void setVolumeMin(int volumeMin) {
        this.volumeMin = volumeMin;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public void setCurrentChannel(int currentChannel) {
        if (currentChannel > channelMax) {
            this.currentChannel = channelMax;
            return;
        }if (currentChannel < channelMin){
            this.currentChannel = channelMin;
            return;
        }
        this.currentChannel = currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume > volumeMax) {
            this.currentVolume = volumeMax;
            return;
        }if (currentVolume < volumeMin) {
            this.currentVolume = volumeMin;
            return;
        }
        this.currentVolume = currentVolume;
    }


}
