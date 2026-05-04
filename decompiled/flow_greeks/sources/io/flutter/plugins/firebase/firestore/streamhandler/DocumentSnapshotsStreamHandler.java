package io.flutter.plugins.firebase.firestore.streamhandler;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.d;
import d9.b1;
import d9.r;
import d9.r1;
import d9.s0;
import d9.t0;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestorePlugin;
import io.flutter.plugins.firebase.firestore.utils.ExceptionConverter;
import io.flutter.plugins.firebase.firestore.utils.PigeonParser;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class DocumentSnapshotsStreamHandler implements EventChannel.StreamHandler {
    com.google.firebase.firestore.c documentReference;
    FirebaseFirestore firestore;
    t0 listenerRegistration;
    b1 metadataChanges;
    d.a serverTimestampBehavior;
    s0 source;

    public DocumentSnapshotsStreamHandler(FirebaseFirestore firebaseFirestore, com.google.firebase.firestore.c cVar, Boolean bool, d.a aVar, s0 s0Var) {
        this.firestore = firebaseFirestore;
        this.documentReference = cVar;
        this.metadataChanges = bool.booleanValue() ? b1.INCLUDE : b1.EXCLUDE;
        this.serverTimestampBehavior = aVar;
        this.source = s0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onListen$0(EventChannel.EventSink eventSink, com.google.firebase.firestore.d dVar, com.google.firebase.firestore.f fVar) {
        if (fVar == null) {
            eventSink.success(PigeonParser.toPigeonDocumentSnapshot(dVar, this.serverTimestampBehavior).toList());
            return;
        }
        eventSink.error(FlutterFirebaseFirestorePlugin.DEFAULT_ERROR_CODE, fVar.getMessage(), ExceptionConverter.createDetails(fVar));
        eventSink.endOfStream();
        onCancel(null);
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
        r1.b bVar = new r1.b();
        bVar.f(this.metadataChanges);
        bVar.g(this.source);
        this.listenerRegistration = this.documentReference.j(bVar.e(), new r() { // from class: io.flutter.plugins.firebase.firestore.streamhandler.a
            @Override // d9.r
            public final void a(Object obj2, com.google.firebase.firestore.f fVar) {
                this.f13049a.lambda$onListen$0(eventSink, (com.google.firebase.firestore.d) obj2, fVar);
            }
        });
    }
}
