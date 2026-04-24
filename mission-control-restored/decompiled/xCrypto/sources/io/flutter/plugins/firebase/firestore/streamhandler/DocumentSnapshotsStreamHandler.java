package io.flutter.plugins.firebase.firestore.streamhandler;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenSource;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.MetadataChanges;
import com.google.firebase.firestore.SnapshotListenOptions;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugins.firebase.firestore.FlutterFirebaseFirestorePlugin;
import io.flutter.plugins.firebase.firestore.utils.ExceptionConverter;
import io.flutter.plugins.firebase.firestore.utils.PigeonParser;

/* JADX INFO: loaded from: classes3.dex */
public class DocumentSnapshotsStreamHandler implements EventChannel.StreamHandler {
    DocumentReference documentReference;
    FirebaseFirestore firestore;
    ListenerRegistration listenerRegistration;
    MetadataChanges metadataChanges;
    DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior;
    ListenSource source;

    public DocumentSnapshotsStreamHandler(FirebaseFirestore firebaseFirestore, DocumentReference documentReference, Boolean bool, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior, ListenSource listenSource) {
        this.firestore = firebaseFirestore;
        this.documentReference = documentReference;
        this.metadataChanges = bool.booleanValue() ? MetadataChanges.INCLUDE : MetadataChanges.EXCLUDE;
        this.serverTimestampBehavior = serverTimestampBehavior;
        this.source = listenSource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onListen$0(EventChannel.EventSink eventSink, DocumentSnapshot documentSnapshot, FirebaseFirestoreException firebaseFirestoreException) {
        if (firebaseFirestoreException == null) {
            eventSink.success(PigeonParser.toPigeonDocumentSnapshot(documentSnapshot, this.serverTimestampBehavior).toList());
            return;
        }
        eventSink.error(FlutterFirebaseFirestorePlugin.DEFAULT_ERROR_CODE, firebaseFirestoreException.getMessage(), ExceptionConverter.createDetails(firebaseFirestoreException));
        eventSink.endOfStream();
        onCancel(null);
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
        SnapshotListenOptions.Builder builder = new SnapshotListenOptions.Builder();
        builder.setMetadataChanges(this.metadataChanges);
        builder.setSource(this.source);
        this.listenerRegistration = this.documentReference.addSnapshotListener(builder.build(), new EventListener() { // from class: io.flutter.plugins.firebase.firestore.streamhandler.a
            @Override // com.google.firebase.firestore.EventListener
            public final void onEvent(Object obj2, FirebaseFirestoreException firebaseFirestoreException) {
                this.f12645a.lambda$onListen$0(eventSink, (DocumentSnapshot) obj2, firebaseFirestoreException);
            }
        });
    }
}
