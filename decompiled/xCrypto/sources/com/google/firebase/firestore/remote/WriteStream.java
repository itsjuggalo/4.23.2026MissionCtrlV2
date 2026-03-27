package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationResult;
import com.google.firebase.firestore.remote.Stream;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Preconditions;
import com.google.protobuf.AbstractC1062i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p2.C1701G;
import p2.C1702H;

/* JADX INFO: loaded from: classes.dex */
public class WriteStream extends AbstractStream<C1701G, C1702H, Callback> {
    public static final AbstractC1062i EMPTY_STREAM_TOKEN = AbstractC1062i.f11025b;
    protected boolean handshakeComplete;
    private AbstractC1062i lastStreamToken;
    private final RemoteSerializer serializer;

    public interface Callback extends Stream.StreamCallback {
        void onHandshakeComplete();

        void onWriteResponse(SnapshotVersion snapshotVersion, List<MutationResult> list);
    }

    public WriteStream(FirestoreChannel firestoreChannel, AsyncQueue asyncQueue, RemoteSerializer remoteSerializer, Callback callback) {
        super(firestoreChannel, p2.r.e(), asyncQueue, AsyncQueue.TimerId.WRITE_STREAM_CONNECTION_BACKOFF, AsyncQueue.TimerId.WRITE_STREAM_IDLE, AsyncQueue.TimerId.HEALTH_CHECK_TIMEOUT, callback);
        this.handshakeComplete = false;
        this.lastStreamToken = EMPTY_STREAM_TOKEN;
        this.serializer = remoteSerializer;
    }

    public AbstractC1062i getLastStreamToken() {
        return this.lastStreamToken;
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream, com.google.firebase.firestore.remote.Stream
    public /* bridge */ /* synthetic */ void inhibitBackoff() {
        super.inhibitBackoff();
    }

    public boolean isHandshakeComplete() {
        return this.handshakeComplete;
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream, com.google.firebase.firestore.remote.Stream
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream, com.google.firebase.firestore.remote.Stream
    public /* bridge */ /* synthetic */ boolean isStarted() {
        return super.isStarted();
    }

    public void setLastStreamToken(AbstractC1062i abstractC1062i) {
        this.lastStreamToken = (AbstractC1062i) Preconditions.checkNotNull(abstractC1062i);
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream, com.google.firebase.firestore.remote.Stream
    public void start() {
        this.handshakeComplete = false;
        super.start();
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream, com.google.firebase.firestore.remote.Stream
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    public void tearDown() {
        if (this.handshakeComplete) {
            writeMutations(Collections.EMPTY_LIST);
        }
    }

    public void writeHandshake() {
        Assert.hardAssert(isOpen(), "Writing handshake requires an opened stream", new Object[0]);
        Assert.hardAssert(!this.handshakeComplete, "Handshake already completed", new Object[0]);
        writeRequest((C1701G) C1701G.o().g(this.serializer.databaseName()).build());
    }

    public void writeMutations(List<Mutation> list) {
        Assert.hardAssert(isOpen(), "Writing mutations requires an opened stream", new Object[0]);
        Assert.hardAssert(this.handshakeComplete, "Handshake must be complete before writing mutations", new Object[0]);
        C1701G.b bVarO = C1701G.o();
        Iterator<Mutation> it = list.iterator();
        while (it.hasNext()) {
            bVarO.f(this.serializer.encodeMutation(it.next()));
        }
        bVarO.h(this.lastStreamToken);
        writeRequest((C1701G) bVarO.build());
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    public void onFirst(C1702H c1702h) {
        this.lastStreamToken = c1702h.m();
        this.handshakeComplete = true;
        ((Callback) this.listener).onHandshakeComplete();
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    public void onNext(C1702H c1702h) {
        this.lastStreamToken = c1702h.m();
        this.backoff.reset();
        SnapshotVersion snapshotVersionDecodeVersion = this.serializer.decodeVersion(c1702h.k());
        int iO = c1702h.o();
        ArrayList arrayList = new ArrayList(iO);
        for (int i4 = 0; i4 < iO; i4++) {
            arrayList.add(this.serializer.decodeMutationResult(c1702h.n(i4), snapshotVersionDecodeVersion));
        }
        ((Callback) this.listener).onWriteResponse(snapshotVersionDecodeVersion, arrayList);
    }
}
