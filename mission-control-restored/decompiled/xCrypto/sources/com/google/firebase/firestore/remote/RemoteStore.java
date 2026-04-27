package com.google.firebase.firestore.remote;

import K2.l0;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.AggregateField;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.core.OnlineState;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.core.Transaction;
import com.google.firebase.firestore.local.LocalStore;
import com.google.firebase.firestore.local.QueryPurpose;
import com.google.firebase.firestore.local.TargetData;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.model.mutation.MutationBatchResult;
import com.google.firebase.firestore.model.mutation.MutationResult;
import com.google.firebase.firestore.remote.ConnectivityMonitor;
import com.google.firebase.firestore.remote.OnlineStateTracker;
import com.google.firebase.firestore.remote.WatchChange;
import com.google.firebase.firestore.remote.WatchChangeAggregator;
import com.google.firebase.firestore.remote.WatchStream;
import com.google.firebase.firestore.remote.WriteStream;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Consumer;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Util;
import com.google.protobuf.AbstractC1062i;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p2.C1698D;

/* JADX INFO: loaded from: classes.dex */
public final class RemoteStore implements WatchChangeAggregator.TargetMetadataProvider {
    private static final String LOG_TAG = "RemoteStore";
    private static final int MAX_PENDING_WRITES = 10;
    private final ConnectivityMonitor connectivityMonitor;
    private final DatabaseId databaseId;
    private final Datastore datastore;
    private final LocalStore localStore;
    private final OnlineStateTracker onlineStateTracker;
    private final RemoteStoreCallback remoteStoreCallback;
    private WatchChangeAggregator watchChangeAggregator;
    private final WatchStream watchStream;
    private final WriteStream writeStream;
    private boolean networkEnabled = false;
    private final Map<Integer, TargetData> listenTargets = new HashMap();
    private final Deque<MutationBatch> writePipeline = new ArrayDeque();

    public interface RemoteStoreCallback {
        ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int i4);

        void handleOnlineStateChange(OnlineState onlineState);

        void handleRejectedListen(int i4, l0 l0Var);

        void handleRejectedWrite(int i4, l0 l0Var);

        void handleRemoteEvent(RemoteEvent remoteEvent);

        void handleSuccessfulWrite(MutationBatchResult mutationBatchResult);
    }

    public RemoteStore(DatabaseId databaseId, final RemoteStoreCallback remoteStoreCallback, LocalStore localStore, Datastore datastore, final AsyncQueue asyncQueue, ConnectivityMonitor connectivityMonitor) {
        this.databaseId = databaseId;
        this.remoteStoreCallback = remoteStoreCallback;
        this.localStore = localStore;
        this.datastore = datastore;
        this.connectivityMonitor = connectivityMonitor;
        Objects.requireNonNull(remoteStoreCallback);
        this.onlineStateTracker = new OnlineStateTracker(asyncQueue, new OnlineStateTracker.OnlineStateCallback() { // from class: com.google.firebase.firestore.remote.y
            @Override // com.google.firebase.firestore.remote.OnlineStateTracker.OnlineStateCallback
            public final void handleOnlineStateChange(OnlineState onlineState) {
                remoteStoreCallback.handleOnlineStateChange(onlineState);
            }
        });
        this.watchStream = datastore.createWatchStream(new WatchStream.Callback() { // from class: com.google.firebase.firestore.remote.RemoteStore.1
            @Override // com.google.firebase.firestore.remote.Stream.StreamCallback
            public void onClose(l0 l0Var) {
                RemoteStore.this.handleWatchStreamClose(l0Var);
            }

            @Override // com.google.firebase.firestore.remote.Stream.StreamCallback
            public void onOpen() {
                RemoteStore.this.handleWatchStreamOpen();
            }

            @Override // com.google.firebase.firestore.remote.WatchStream.Callback
            public void onWatchChange(SnapshotVersion snapshotVersion, WatchChange watchChange) {
                RemoteStore.this.handleWatchChange(snapshotVersion, watchChange);
            }
        });
        this.writeStream = datastore.createWriteStream(new WriteStream.Callback() { // from class: com.google.firebase.firestore.remote.RemoteStore.2
            @Override // com.google.firebase.firestore.remote.Stream.StreamCallback
            public void onClose(l0 l0Var) {
                RemoteStore.this.handleWriteStreamClose(l0Var);
            }

            @Override // com.google.firebase.firestore.remote.WriteStream.Callback
            public void onHandshakeComplete() {
                RemoteStore.this.handleWriteStreamHandshakeComplete();
            }

            @Override // com.google.firebase.firestore.remote.Stream.StreamCallback
            public void onOpen() {
                RemoteStore.this.writeStream.writeHandshake();
            }

            @Override // com.google.firebase.firestore.remote.WriteStream.Callback
            public void onWriteResponse(SnapshotVersion snapshotVersion, List<MutationResult> list) {
                RemoteStore.this.handleWriteStreamMutationResults(snapshotVersion, list);
            }
        });
        connectivityMonitor.addCallback(new Consumer() { // from class: com.google.firebase.firestore.remote.z
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                RemoteStore.b(this.f10707a, asyncQueue, (ConnectivityMonitor.NetworkStatus) obj);
            }
        });
    }

    public static /* synthetic */ void a(RemoteStore remoteStore, ConnectivityMonitor.NetworkStatus networkStatus) {
        remoteStore.getClass();
        if (networkStatus.equals(ConnectivityMonitor.NetworkStatus.REACHABLE) && remoteStore.onlineStateTracker.getState().equals(OnlineState.ONLINE)) {
            return;
        }
        if (!(networkStatus.equals(ConnectivityMonitor.NetworkStatus.UNREACHABLE) && remoteStore.onlineStateTracker.getState().equals(OnlineState.OFFLINE)) && remoteStore.canUseNetwork()) {
            Logger.debug(LOG_TAG, "Restarting streams for network reachability change.", new Object[0]);
            remoteStore.restartNetwork();
        }
    }

    private void addToWritePipeline(MutationBatch mutationBatch) {
        Assert.hardAssert(canAddToWritePipeline(), "addToWritePipeline called when pipeline is full", new Object[0]);
        this.writePipeline.add(mutationBatch);
        if (this.writeStream.isOpen() && this.writeStream.isHandshakeComplete()) {
            this.writeStream.writeMutations(mutationBatch.getMutations());
        }
    }

    public static /* synthetic */ void b(final RemoteStore remoteStore, AsyncQueue asyncQueue, final ConnectivityMonitor.NetworkStatus networkStatus) {
        remoteStore.getClass();
        asyncQueue.enqueueAndForget(new Runnable() { // from class: com.google.firebase.firestore.remote.x
            @Override // java.lang.Runnable
            public final void run() {
                RemoteStore.a(this.f10704a, networkStatus);
            }
        });
    }

    private boolean canAddToWritePipeline() {
        return canUseNetwork() && this.writePipeline.size() < 10;
    }

    private void cleanUpWatchStreamState() {
        this.watchChangeAggregator = null;
    }

    private void disableNetworkInternal() {
        this.watchStream.stop();
        this.writeStream.stop();
        if (!this.writePipeline.isEmpty()) {
            Logger.debug(LOG_TAG, "Stopping write stream with %d pending writes", Integer.valueOf(this.writePipeline.size()));
            this.writePipeline.clear();
        }
        cleanUpWatchStreamState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleWatchChange(SnapshotVersion snapshotVersion, WatchChange watchChange) {
        this.onlineStateTracker.updateState(OnlineState.ONLINE);
        Assert.hardAssert((this.watchStream == null || this.watchChangeAggregator == null) ? false : true, "WatchStream and WatchStreamAggregator should both be non-null", new Object[0]);
        boolean z4 = watchChange instanceof WatchChange.WatchTargetChange;
        WatchChange.WatchTargetChange watchTargetChange = z4 ? (WatchChange.WatchTargetChange) watchChange : null;
        if (watchTargetChange != null && watchTargetChange.getChangeType().equals(WatchChange.WatchTargetChangeType.Removed) && watchTargetChange.getCause() != null) {
            processTargetError(watchTargetChange);
            return;
        }
        if (watchChange instanceof WatchChange.DocumentChange) {
            this.watchChangeAggregator.handleDocumentChange((WatchChange.DocumentChange) watchChange);
        } else if (watchChange instanceof WatchChange.ExistenceFilterWatchChange) {
            this.watchChangeAggregator.handleExistenceFilter((WatchChange.ExistenceFilterWatchChange) watchChange);
        } else {
            Assert.hardAssert(z4, "Expected watchChange to be an instance of WatchTargetChange", new Object[0]);
            this.watchChangeAggregator.handleTargetChange((WatchChange.WatchTargetChange) watchChange);
        }
        if (snapshotVersion.equals(SnapshotVersion.NONE) || snapshotVersion.compareTo(this.localStore.getLastRemoteSnapshotVersion()) < 0) {
            return;
        }
        raiseWatchSnapshot(snapshotVersion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleWatchStreamClose(l0 l0Var) {
        if (l0Var.o()) {
            Assert.hardAssert(!shouldStartWatchStream(), "Watch stream was stopped gracefully while still needed.", new Object[0]);
        }
        cleanUpWatchStreamState();
        if (!shouldStartWatchStream()) {
            this.onlineStateTracker.updateState(OnlineState.UNKNOWN);
        } else {
            this.onlineStateTracker.handleWatchStreamFailure(l0Var);
            startWatchStream();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleWatchStreamOpen() {
        Iterator<TargetData> it = this.listenTargets.values().iterator();
        while (it.hasNext()) {
            sendWatchRequest(it.next());
        }
    }

    private void handleWriteError(l0 l0Var) {
        Assert.hardAssert(!l0Var.o(), "Handling write error with status OK.", new Object[0]);
        if (Datastore.isPermanentWriteError(l0Var)) {
            MutationBatch mutationBatchPoll = this.writePipeline.poll();
            this.writeStream.inhibitBackoff();
            this.remoteStoreCallback.handleRejectedWrite(mutationBatchPoll.getBatchId(), l0Var);
            fillWritePipeline();
        }
    }

    private void handleWriteHandshakeError(l0 l0Var) {
        Assert.hardAssert(!l0Var.o(), "Handling write error with status OK.", new Object[0]);
        if (Datastore.isPermanentError(l0Var)) {
            Logger.debug(LOG_TAG, "RemoteStore error before completed handshake; resetting stream token %s: %s", Util.toDebugString(this.writeStream.getLastStreamToken()), l0Var);
            WriteStream writeStream = this.writeStream;
            AbstractC1062i abstractC1062i = WriteStream.EMPTY_STREAM_TOKEN;
            writeStream.setLastStreamToken(abstractC1062i);
            this.localStore.setLastStreamToken(abstractC1062i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleWriteStreamClose(l0 l0Var) {
        if (l0Var.o()) {
            Assert.hardAssert(!shouldStartWriteStream(), "Write stream was stopped gracefully while still needed.", new Object[0]);
        }
        if (!l0Var.o() && !this.writePipeline.isEmpty()) {
            if (this.writeStream.isHandshakeComplete()) {
                handleWriteError(l0Var);
            } else {
                handleWriteHandshakeError(l0Var);
            }
        }
        if (shouldStartWriteStream()) {
            startWriteStream();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleWriteStreamHandshakeComplete() {
        this.localStore.setLastStreamToken(this.writeStream.getLastStreamToken());
        Iterator<MutationBatch> it = this.writePipeline.iterator();
        while (it.hasNext()) {
            this.writeStream.writeMutations(it.next().getMutations());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleWriteStreamMutationResults(SnapshotVersion snapshotVersion, List<MutationResult> list) {
        this.remoteStoreCallback.handleSuccessfulWrite(MutationBatchResult.create(this.writePipeline.poll(), snapshotVersion, list, this.writeStream.getLastStreamToken()));
        fillWritePipeline();
    }

    private void processTargetError(WatchChange.WatchTargetChange watchTargetChange) {
        Assert.hardAssert(watchTargetChange.getCause() != null, "Processing target error without a cause", new Object[0]);
        for (Integer num : watchTargetChange.getTargetIds()) {
            if (this.listenTargets.containsKey(num)) {
                this.listenTargets.remove(num);
                this.watchChangeAggregator.removeTarget(num.intValue());
                this.remoteStoreCallback.handleRejectedListen(num.intValue(), watchTargetChange.getCause());
            }
        }
    }

    private void raiseWatchSnapshot(SnapshotVersion snapshotVersion) {
        Assert.hardAssert(!snapshotVersion.equals(SnapshotVersion.NONE), "Can't raise event for unknown SnapshotVersion", new Object[0]);
        RemoteEvent remoteEventCreateRemoteEvent = this.watchChangeAggregator.createRemoteEvent(snapshotVersion);
        for (Map.Entry<Integer, TargetChange> entry : remoteEventCreateRemoteEvent.getTargetChanges().entrySet()) {
            TargetChange value = entry.getValue();
            if (!value.getResumeToken().isEmpty()) {
                Integer key = entry.getKey();
                key.intValue();
                TargetData targetData = this.listenTargets.get(key);
                if (targetData != null) {
                    this.listenTargets.put(key, targetData.withResumeToken(value.getResumeToken(), snapshotVersion));
                }
            }
        }
        for (Map.Entry<Integer, QueryPurpose> entry2 : remoteEventCreateRemoteEvent.getTargetMismatches().entrySet()) {
            Integer key2 = entry2.getKey();
            int iIntValue = key2.intValue();
            TargetData targetData2 = this.listenTargets.get(key2);
            if (targetData2 != null) {
                this.listenTargets.put(key2, targetData2.withResumeToken(AbstractC1062i.f11025b, targetData2.getSnapshotVersion()));
                sendUnwatchRequest(iIntValue);
                sendWatchRequest(new TargetData(targetData2.getTarget(), iIntValue, targetData2.getSequenceNumber(), entry2.getValue()));
            }
        }
        this.remoteStoreCallback.handleRemoteEvent(remoteEventCreateRemoteEvent);
    }

    private void restartNetwork() {
        this.networkEnabled = false;
        disableNetworkInternal();
        this.onlineStateTracker.updateState(OnlineState.UNKNOWN);
        this.writeStream.inhibitBackoff();
        this.watchStream.inhibitBackoff();
        enableNetwork();
    }

    private void sendUnwatchRequest(int i4) {
        this.watchChangeAggregator.recordPendingTargetRequest(i4);
        this.watchStream.unwatchTarget(i4);
    }

    private void sendWatchRequest(TargetData targetData) {
        this.watchChangeAggregator.recordPendingTargetRequest(targetData.getTargetId());
        if (!targetData.getResumeToken().isEmpty() || targetData.getSnapshotVersion().compareTo(SnapshotVersion.NONE) > 0) {
            targetData = targetData.withExpectedCount(Integer.valueOf(getRemoteKeysForTarget(targetData.getTargetId()).size()));
        }
        this.watchStream.watchQuery(targetData);
    }

    private boolean shouldStartWatchStream() {
        return (!canUseNetwork() || this.watchStream.isStarted() || this.listenTargets.isEmpty()) ? false : true;
    }

    private boolean shouldStartWriteStream() {
        return (!canUseNetwork() || this.writeStream.isStarted() || this.writePipeline.isEmpty()) ? false : true;
    }

    private void startWatchStream() {
        Assert.hardAssert(shouldStartWatchStream(), "startWatchStream() called when shouldStartWatchStream() is false.", new Object[0]);
        this.watchChangeAggregator = new WatchChangeAggregator(this.databaseId, this);
        this.watchStream.start();
        this.onlineStateTracker.handleWatchStreamStart();
    }

    private void startWriteStream() {
        Assert.hardAssert(shouldStartWriteStream(), "startWriteStream() called when shouldStartWriteStream() is false.", new Object[0]);
        this.writeStream.start();
    }

    public boolean canUseNetwork() {
        return this.networkEnabled;
    }

    public Transaction createTransaction() {
        return new Transaction(this.datastore);
    }

    public void disableNetwork() {
        this.networkEnabled = false;
        disableNetworkInternal();
        this.onlineStateTracker.updateState(OnlineState.OFFLINE);
    }

    public void enableNetwork() {
        this.networkEnabled = true;
        if (canUseNetwork()) {
            this.writeStream.setLastStreamToken(this.localStore.getLastStreamToken());
            if (shouldStartWatchStream()) {
                startWatchStream();
            } else {
                this.onlineStateTracker.updateState(OnlineState.UNKNOWN);
            }
            fillWritePipeline();
        }
    }

    public void fillWritePipeline() {
        int batchId = this.writePipeline.isEmpty() ? -1 : this.writePipeline.getLast().getBatchId();
        while (true) {
            if (!canAddToWritePipeline()) {
                break;
            }
            MutationBatch nextMutationBatch = this.localStore.getNextMutationBatch(batchId);
            if (nextMutationBatch != null) {
                addToWritePipeline(nextMutationBatch);
                batchId = nextMutationBatch.getBatchId();
            } else if (this.writePipeline.size() == 0) {
                this.writeStream.markIdle();
            }
        }
        if (shouldStartWriteStream()) {
            startWriteStream();
        }
    }

    public void forceEnableNetwork() {
        enableNetwork();
        this.onlineStateTracker.updateState(OnlineState.ONLINE);
    }

    @Override // com.google.firebase.firestore.remote.WatchChangeAggregator.TargetMetadataProvider
    public ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int i4) {
        return this.remoteStoreCallback.getRemoteKeysForTarget(i4);
    }

    @Override // com.google.firebase.firestore.remote.WatchChangeAggregator.TargetMetadataProvider
    public TargetData getTargetDataForTarget(int i4) {
        return this.listenTargets.get(Integer.valueOf(i4));
    }

    public void handleCredentialChange() {
        if (canUseNetwork()) {
            Logger.debug(LOG_TAG, "Restarting streams for new credential.", new Object[0]);
            restartNetwork();
        }
    }

    public void listen(TargetData targetData) {
        Integer numValueOf = Integer.valueOf(targetData.getTargetId());
        if (this.listenTargets.containsKey(numValueOf)) {
            return;
        }
        this.listenTargets.put(numValueOf, targetData);
        if (shouldStartWatchStream()) {
            startWatchStream();
        } else if (this.watchStream.isOpen()) {
            sendWatchRequest(targetData);
        }
    }

    public Task<Map<String, C1698D>> runAggregateQuery(Query query, List<AggregateField> list) {
        return canUseNetwork() ? this.datastore.runAggregateQuery(query, list) : Tasks.forException(new FirebaseFirestoreException("Failed to get result from server.", FirebaseFirestoreException.Code.UNAVAILABLE));
    }

    public void shutdown() {
        Logger.debug(LOG_TAG, "Shutting down", new Object[0]);
        this.connectivityMonitor.shutdown();
        this.networkEnabled = false;
        disableNetworkInternal();
        this.datastore.shutdown();
        this.onlineStateTracker.updateState(OnlineState.UNKNOWN);
    }

    public void start() {
        enableNetwork();
    }

    public void stopListening(int i4) {
        Assert.hardAssert(this.listenTargets.remove(Integer.valueOf(i4)) != null, "stopListening called on target no currently watched: %d", Integer.valueOf(i4));
        if (this.watchStream.isOpen()) {
            sendUnwatchRequest(i4);
        }
        if (this.listenTargets.isEmpty()) {
            if (this.watchStream.isOpen()) {
                this.watchStream.markIdle();
            } else if (canUseNetwork()) {
                this.onlineStateTracker.updateState(OnlineState.UNKNOWN);
            }
        }
    }
}
