package io.flutter.plugins.firebase.appcheck;

import com.google.firebase.appcheck.AppCheckToken;
import com.google.firebase.appcheck.FirebaseAppCheck;
import io.flutter.plugin.common.EventChannel;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class TokenChannelStreamHandler implements EventChannel.StreamHandler {
    private final FirebaseAppCheck firebaseAppCheck;
    private FirebaseAppCheck.AppCheckListener listener;

    public TokenChannelStreamHandler(FirebaseAppCheck firebaseAppCheck) {
        this.firebaseAppCheck = firebaseAppCheck;
    }

    public static /* synthetic */ void a(EventChannel.EventSink eventSink, AppCheckToken appCheckToken) {
        HashMap map = new HashMap();
        map.put("token", appCheckToken.getToken());
        eventSink.success(map);
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onCancel(Object obj) {
        FirebaseAppCheck.AppCheckListener appCheckListener = this.listener;
        if (appCheckListener != null) {
            this.firebaseAppCheck.removeAppCheckListener(appCheckListener);
            this.listener = null;
        }
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onListen(Object obj, final EventChannel.EventSink eventSink) {
        FirebaseAppCheck.AppCheckListener appCheckListener = new FirebaseAppCheck.AppCheckListener() { // from class: io.flutter.plugins.firebase.appcheck.i
            @Override // com.google.firebase.appcheck.FirebaseAppCheck.AppCheckListener
            public final void onAppCheckTokenChanged(AppCheckToken appCheckToken) {
                TokenChannelStreamHandler.a(eventSink, appCheckToken);
            }
        };
        this.listener = appCheckListener;
        this.firebaseAppCheck.addAppCheckListener(appCheckListener);
    }
}
