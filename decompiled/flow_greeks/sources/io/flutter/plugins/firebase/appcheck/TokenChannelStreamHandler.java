package io.flutter.plugins.firebase.appcheck;

import e7.e;
import io.flutter.plugin.common.EventChannel;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class TokenChannelStreamHandler implements EventChannel.StreamHandler {
    private final e7.e firebaseAppCheck;
    private e.a listener;

    public TokenChannelStreamHandler(e7.e eVar) {
        this.firebaseAppCheck = eVar;
    }

    public static /* synthetic */ void a(EventChannel.EventSink eventSink, e7.c cVar) {
        HashMap map = new HashMap();
        map.put("token", cVar.b());
        eventSink.success(map);
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onCancel(Object obj) {
        e.a aVar = this.listener;
        if (aVar != null) {
            this.firebaseAppCheck.i(aVar);
            this.listener = null;
        }
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onListen(Object obj, final EventChannel.EventSink eventSink) {
        e.a aVar = new e.a() { // from class: io.flutter.plugins.firebase.appcheck.j
            @Override // e7.e.a
            public final void a(e7.c cVar) {
                TokenChannelStreamHandler.a(eventSink, cVar);
            }
        };
        this.listener = aVar;
        this.firebaseAppCheck.d(aVar);
    }
}
