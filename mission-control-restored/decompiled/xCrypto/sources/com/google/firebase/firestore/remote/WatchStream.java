package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.local.TargetData;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.remote.Stream;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.protobuf.AbstractC1062i;
import java.util.Map;
import p2.s;

/* JADX INFO: loaded from: classes.dex */
public class WatchStream extends AbstractStream<p2.s, p2.t, Callback> {
    public static final AbstractC1062i EMPTY_RESUME_TOKEN = AbstractC1062i.f11025b;
    private final RemoteSerializer serializer;

    public interface Callback extends Stream.StreamCallback {
        void onWatchChange(SnapshotVersion snapshotVersion, WatchChange watchChange);
    }

    public WatchStream(FirestoreChannel firestoreChannel, AsyncQueue asyncQueue, RemoteSerializer remoteSerializer, Callback callback) {
        super(firestoreChannel, p2.r.c(), asyncQueue, AsyncQueue.TimerId.LISTEN_STREAM_CONNECTION_BACKOFF, AsyncQueue.TimerId.LISTEN_STREAM_IDLE, AsyncQueue.TimerId.HEALTH_CHECK_TIMEOUT, callback);
        this.serializer = remoteSerializer;
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream, com.google.firebase.firestore.remote.Stream
    public /* bridge */ /* synthetic */ void inhibitBackoff() {
        super.inhibitBackoff();
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream, com.google.firebase.firestore.remote.Stream
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream, com.google.firebase.firestore.remote.Stream
    public /* bridge */ /* synthetic */ boolean isStarted() {
        return super.isStarted();
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream, com.google.firebase.firestore.remote.Stream
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream, com.google.firebase.firestore.remote.Stream
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    public void unwatchTarget(int i4) {
        Assert.hardAssert(isOpen(), "Unwatching targets requires an open stream", new Object[0]);
        writeRequest((p2.s) p2.s.r().h(this.serializer.databaseName()).i(i4).build());
    }

    public void watchQuery(TargetData targetData) {
        Assert.hardAssert(isOpen(), "Watching queries requires an open stream", new Object[0]);
        s.b bVarG = p2.s.r().h(this.serializer.databaseName()).g(this.serializer.encodeTarget(targetData));
        Map<String, String> mapEncodeListenRequestLabels = this.serializer.encodeListenRequestLabels(targetData);
        if (mapEncodeListenRequestLabels != null) {
            bVarG.f(mapEncodeListenRequestLabels);
        }
        writeRequest((p2.s) bVarG.build());
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    public void onFirst(p2.t tVar) {
        onNext(tVar);
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    public void onNext(p2.t tVar) {
        this.backoff.reset();
        WatchChange watchChangeDecodeWatchChange = this.serializer.decodeWatchChange(tVar);
        ((Callback) this.listener).onWatchChange(this.serializer.decodeVersionFromListenResponse(tVar), watchChangeDecodeWatchChange);
    }
}
