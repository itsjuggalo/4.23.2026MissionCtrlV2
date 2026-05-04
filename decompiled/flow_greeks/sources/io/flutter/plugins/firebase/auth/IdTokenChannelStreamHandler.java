package io.flutter.plugins.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;
import io.flutter.plugin.common.EventChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class IdTokenChannelStreamHandler implements EventChannel.StreamHandler {
    private final FirebaseAuth firebaseAuth;
    private FirebaseAuth.b idTokenListener;

    public IdTokenChannelStreamHandler(FirebaseAuth firebaseAuth) {
        this.firebaseAuth = firebaseAuth;
    }

    public static /* synthetic */ void a(AtomicBoolean atomicBoolean, Map map, EventChannel.EventSink eventSink, FirebaseAuth firebaseAuth) {
        if (atomicBoolean.get()) {
            atomicBoolean.set(false);
            return;
        }
        m7.a0 a0VarM = firebaseAuth.m();
        if (a0VarM == null) {
            map.put(Constants.USER, null);
        } else {
            map.put(Constants.USER, PigeonParser.manuallyToList(PigeonParser.parseFirebaseUser(a0VarM)));
        }
        eventSink.success(map);
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onCancel(Object obj) {
        FirebaseAuth.b bVar = this.idTokenListener;
        if (bVar != null) {
            this.firebaseAuth.t(bVar);
            this.idTokenListener = null;
        }
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onListen(Object obj, final EventChannel.EventSink eventSink) {
        final HashMap map = new HashMap();
        map.put("appName", this.firebaseAuth.l().q());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        FirebaseAuth.b bVar = new FirebaseAuth.b() { // from class: io.flutter.plugins.firebase.auth.s2
            @Override // com.google.firebase.auth.FirebaseAuth.b
            public final void a(FirebaseAuth firebaseAuth) {
                IdTokenChannelStreamHandler.a(atomicBoolean, map, eventSink, firebaseAuth);
            }
        };
        this.idTokenListener = bVar;
        this.firebaseAuth.f(bVar);
    }
}
