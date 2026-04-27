package io.flutter.plugins.firebase.firestore.streamhandler;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ListenerRegistration;
import io.flutter.plugin.common.EventChannel;

/* JADX INFO: loaded from: classes3.dex */
public class SnapshotsInSyncStreamHandler implements EventChannel.StreamHandler {
    FirebaseFirestore firestore;
    ListenerRegistration listenerRegistration;

    public SnapshotsInSyncStreamHandler(FirebaseFirestore firebaseFirestore) {
        this.firestore = firebaseFirestore;
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onCancel(Object obj) {
        ListenerRegistration listenerRegistration = this.listenerRegistration;
        if (listenerRegistration != null) {
            listenerRegistration.remove();
            this.listenerRegistration = null;
        }
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onListen(Object obj, final EventChannel.EventSink eventSink) {
        this.listenerRegistration = this.firestore.addSnapshotsInSyncListener(new Runnable() { // from class: io.flutter.plugins.firebase.firestore.streamhandler.e
            @Override // java.lang.Runnable
            public final void run() {
                eventSink.success(null);
            }
        });
    }
}
