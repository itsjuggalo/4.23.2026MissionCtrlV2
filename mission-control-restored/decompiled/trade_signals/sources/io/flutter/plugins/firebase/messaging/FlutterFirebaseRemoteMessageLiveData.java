package io.flutter.plugins.firebase.messaging;

import androidx.lifecycle.AbstractC1164p;
import com.google.firebase.messaging.V;

/* JADX INFO: loaded from: classes.dex */
public class FlutterFirebaseRemoteMessageLiveData extends AbstractC1164p {
    private static FlutterFirebaseRemoteMessageLiveData instance;

    public static FlutterFirebaseRemoteMessageLiveData getInstance() {
        if (instance == null) {
            instance = new FlutterFirebaseRemoteMessageLiveData();
        }
        return instance;
    }

    public void postRemoteMessage(V v8) {
        postValue(v8);
    }
}
