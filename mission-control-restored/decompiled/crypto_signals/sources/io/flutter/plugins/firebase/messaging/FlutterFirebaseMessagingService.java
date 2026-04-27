package io.flutter.plugins.firebase.messaging;

import com.google.firebase.messaging.FirebaseMessagingService;
import k4.C0781g;

/* JADX INFO: loaded from: classes.dex */
public class FlutterFirebaseMessagingService extends FirebaseMessagingService {
    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void c(String str) {
        if (C0781g.f7900m == null) {
            C0781g.f7900m = new C0781g();
        }
        C0781g.f7900m.h(str);
    }
}
