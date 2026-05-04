package io.flutter.plugins.firebase.firestore.streamhandler;

import com.google.firebase.firestore.d;
import com.google.firebase.firestore.k;
import d9.b1;
import d9.r;
import d9.r1;
import d9.s0;
import d9.t0;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestorePlugin;
import io.flutter.plugins.firebase.firestore.utils.ExceptionConverter;
import io.flutter.plugins.firebase.firestore.utils.PigeonParser;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class QuerySnapshotsStreamHandler implements EventChannel.StreamHandler {
    t0 listenerRegistration;
    b1 metadataChanges;
    com.google.firebase.firestore.i query;
    d.a serverTimestampBehavior;
    s0 source;

    public QuerySnapshotsStreamHandler(com.google.firebase.firestore.i iVar, Boolean bool, d.a aVar, s0 s0Var) {
        this.query = iVar;
        this.metadataChanges = bool.booleanValue() ? b1.INCLUDE : b1.EXCLUDE;
        this.serverTimestampBehavior = aVar;
        this.source = s0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onListen$0(EventChannel.EventSink eventSink, k kVar, com.google.firebase.firestore.f fVar) {
        if (fVar != null) {
            eventSink.error(FlutterFirebaseFirestorePlugin.DEFAULT_ERROR_CODE, fVar.getMessage(), ExceptionConverter.createDetails(fVar));
            eventSink.endOfStream();
            onCancel(null);
            return;
        }
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(kVar.f().size());
        ArrayList arrayList3 = new ArrayList(kVar.d().size());
        Iterator it = kVar.f().iterator();
        while (it.hasNext()) {
            arrayList2.add(PigeonParser.toPigeonDocumentSnapshot((com.google.firebase.firestore.d) it.next(), this.serverTimestampBehavior).toList());
        }
        Iterator it2 = kVar.d().iterator();
        while (it2.hasNext()) {
            arrayList3.add(PigeonParser.toPigeonDocumentChange((d9.g) it2.next(), this.serverTimestampBehavior).toList());
        }
        arrayList.add(arrayList2);
        arrayList.add(arrayList3);
        arrayList.add(PigeonParser.toPigeonSnapshotMetadata(kVar.g()).toList());
        eventSink.success(arrayList);
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
        this.listenerRegistration = this.query.g(bVar.e(), new r() { // from class: io.flutter.plugins.firebase.firestore.streamhandler.d
            @Override // d9.r
            public final void a(Object obj2, com.google.firebase.firestore.f fVar) {
                this.f13054a.lambda$onListen$0(eventSink, (k) obj2, fVar);
            }
        });
    }
}
