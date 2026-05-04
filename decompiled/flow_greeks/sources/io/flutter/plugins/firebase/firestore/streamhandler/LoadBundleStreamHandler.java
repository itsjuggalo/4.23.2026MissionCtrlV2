package io.flutter.plugins.firebase.firestore.streamhandler;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.firestore.FirebaseFirestore;
import d9.c1;
import d9.v0;
import d9.w0;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestorePlugin;
import io.flutter.plugins.firebase.firestore.utils.ExceptionConverter;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class LoadBundleStreamHandler implements EventChannel.StreamHandler {
    private final byte[] bundle;
    private EventChannel.EventSink eventSink;
    private final FirebaseFirestore firestore;

    public LoadBundleStreamHandler(FirebaseFirestore firebaseFirestore, byte[] bArr) {
        this.firestore = firebaseFirestore;
        this.bundle = bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onListen$0(EventChannel.EventSink eventSink, Exception exc) {
        eventSink.error(FlutterFirebaseFirestorePlugin.DEFAULT_ERROR_CODE, exc.getMessage(), ExceptionConverter.createDetails(exc));
        onCancel(null);
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onCancel(Object obj) {
        this.eventSink.endOfStream();
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onListen(Object obj, final EventChannel.EventSink eventSink) {
        this.eventSink = eventSink;
        v0 v0VarH = this.firestore.H(this.bundle);
        Objects.requireNonNull(eventSink);
        v0VarH.a(new c1() { // from class: io.flutter.plugins.firebase.firestore.streamhandler.b
            @Override // d9.c1
            public final void a(Object obj2) {
                eventSink.success((w0) obj2);
            }
        });
        v0VarH.addOnFailureListener(new OnFailureListener() { // from class: io.flutter.plugins.firebase.firestore.streamhandler.c
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.f13052a.lambda$onListen$0(eventSink, exc);
            }
        });
    }
}
