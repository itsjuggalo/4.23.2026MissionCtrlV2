package io.flutter.plugins.firebase.messaging;

import androidx.lifecycle.AbstractC0853p;

/* JADX INFO: loaded from: classes3.dex */
public class FlutterFirebaseTokenLiveData extends AbstractC0853p {
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
