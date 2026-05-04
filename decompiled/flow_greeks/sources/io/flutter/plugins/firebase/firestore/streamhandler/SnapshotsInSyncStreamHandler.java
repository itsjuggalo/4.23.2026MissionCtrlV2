package io.flutter.plugins.firebase.firestore.streamhandler;

import com.google.firebase.firestore.FirebaseFirestore;
import d9.t0;
import io.flutter.plugin.common.EventChannel;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class SnapshotsInSyncStreamHandler implements EventChannel.StreamHandler {
    FirebaseFirestore firestore;
    t0 listenerRegistration;

    public SnapshotsInSyncStreamHandler(FirebaseFirestore firebaseFirestore) {
        this.firestore = firebaseFirestore;
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onCancel(Object obj) {
        t0 t0Var = this.listenerRegistration;
        if (t0Var != null) {
            t0Var.remove();
            this.listenerRegistration = null;
        }
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onListen(Object obj, final EventChannel.EventSink eventSink) {
        this.listenerRegistration = this.firestore.o(new Runnable() { // from class: io.flutter.plugins.firebase.firestore.streamhandler.e
            @Override // java.lang.Runnable
            public final void run() {
                eventSink.success(null);
            }
        });
    }
}
