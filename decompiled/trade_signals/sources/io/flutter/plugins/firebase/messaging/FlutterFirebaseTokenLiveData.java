package io.flutter.plugins.firebase.messaging;

import androidx.lifecycle.AbstractC1164p;

/* JADX INFO: loaded from: classes.dex */
public class FlutterFirebaseTokenLiveData extends AbstractC1164p {
    private static FlutterFirebaseTokenLiveData instance;

    public static FlutterFirebaseTokenLiveData getInstance() {
        if (instance == null) {
            instance = new FlutterFirebaseTokenLiveData();
        }
        return instance;
    }

    public void postToken(String str) {
        postValue(str);
    }
}
