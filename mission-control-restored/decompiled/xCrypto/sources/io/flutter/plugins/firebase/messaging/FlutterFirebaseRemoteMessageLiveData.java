package io.flutter.plugins.firebase.messaging;

import androidx.lifecycle.AbstractC0853p;
import com.google.firebase.messaging.RemoteMessage;

/* JADX INFO: loaded from: classes3.dex */
public class FlutterFirebaseRemoteMessageLiveData extends AbstractC0853p {
    private static FlutterFirebaseRemoteMessageLiveData instance;

    public static FlutterFirebaseRemoteMessageLiveData getInstance() {
        if (instance == null) {
            instance = new FlutterFirebaseRemoteMessageLiveData();
        }
        return instance;
    }

    public void postRemoteMessage(RemoteMessage remoteMessage) {
        postValue(remoteMessage);
    }
}
