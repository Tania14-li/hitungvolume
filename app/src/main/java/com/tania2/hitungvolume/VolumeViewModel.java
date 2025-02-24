package com.tania2.hitungvolume;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VolumeViewModel extends ViewModel {

    // LiveData untuk menyimpan hasil volume
    private final MutableLiveData<Integer> volume = new MutableLiveData<>();

    // Constructor dengan nilai default
    public VolumeViewModel() {
        volume.setValue(0); // Default Volume = 0
    }

    // Method untuk mendapatkan LiveData volume
    public LiveData<Integer> getVolume() {
        return volume;
    }

    // Method untuk mengupdate nilai volume
    public void updateVolume(int newVolume) {
        volume.setValue(newVolume);
    }

}
