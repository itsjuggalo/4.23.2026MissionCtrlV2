package com.google.firebase.firestore.core;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenSource;
import com.google.firebase.firestore.core.EventManager;
import com.google.firebase.firestore.util.Assert;

/* JADX INFO: loaded from: classes.dex */
public class QueryListener {
    private final EventListener<ViewSnapshot> listener;
    private final EventManager.ListenOptions options;
    private final Query query;
    private ViewSnapshot snapshot;
    private boolean raisedInitialEvent = false;
    private OnlineState onlineState = OnlineState.UNKNOWN;

    public QueryListener(Query query, EventManager.ListenOptions listenOptions, EventListener<ViewSnapshot> eventListener) {
        this.query = query;
        this.listener = eventListener;
        this.options = listenOptions;
    }

    private void raiseInitialEvent(ViewSnapshot viewSnapshot) {
        Assert.hardAssert(!this.raisedInitialEvent, "Trying to raise initial event for second time", new Object[0]);
        ViewSnapshot viewSnapshotFromInitialDocuments = ViewSnapshot.fromInitialDocuments(viewSnapshot.getQuery(), viewSnapshot.getDocuments(), viewSnapshot.getMutatedKeys(), viewSnapshot.isFromCache(), viewSnapshot.excludesMetadataChanges(), viewSnapshot.hasCachedResults());
        this.raisedInitialEvent = true;
        this.listener.onEvent(viewSnapshotFromInitialDocuments, null);
    }

    private boolean shouldRaiseEvent(ViewSnapshot viewSnapshot) {
        if (!viewSnapshot.getChanges().isEmpty()) {
            return true;
        }
        ViewSnapshot viewSnapshot2 = this.snapshot;
        boolean z4 = (viewSnapshot2 == null || viewSnapshot2.hasPendingWrites() == viewSnapshot.hasPendingWrites()) ? false : true;
        if (viewSnapshot.didSyncStateChange() || z4) {
            return this.options.includeQueryMetadataChanges;
        }
        return false;
    }

    private boolean shouldRaiseInitialEvent(ViewSnapshot viewSnapshot, OnlineState onlineState) {
        Assert.hardAssert(!this.raisedInitialEvent, "Determining whether to raise first event but already had first event.", new Object[0]);
        if (!viewSnapshot.isFromCache() || !listensToRemoteStore()) {
            return true;
        }
        OnlineState onlineState2 = OnlineState.OFFLINE;
        boolean zEquals = onlineState.equals(onlineState2);
        if (!this.options.waitForSyncWhenOnline || zEquals) {
            return !viewSnapshot.getDocuments().isEmpty() || viewSnapshot.hasCachedResults() || onlineState.equals(onlineState2);
        }
        Assert.hardAssert(viewSnapshot.isFromCache(), "Waiting for sync, but snapshot is not from cache", new Object[0]);
        return false;
    }

    public Query getQuery() {
        return this.query;
    }

    public boolean listensToRemoteStore() {
        if (this.options != null) {
            return !r0.source.equals(ListenSource.CACHE);
        }
        return true;
    }

    public void onError(FirebaseFirestoreException firebaseFirestoreException) {
        this.listener.onEvent(null, firebaseFirestoreException);
    }

    public boolean onOnlineStateChanged(OnlineState onlineState) {
        this.onlineState = onlineState;
        ViewSnapshot viewSnapshot = this.snapshot;
        if (viewSnapshot == null || this.raisedInitialEvent || !shouldRaiseInitialEvent(viewSnapshot, onlineState)) {
            return false;
        }
        raiseInitialEvent(this.snapshot);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onViewSnapshot(com.google.firebase.firestore.core.ViewSnapshot r14) {
        /*
            r13 = this;
            java.util.List r0 = r14.getChanges()
            boolean r0 = r0.isEmpty()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L15
            boolean r0 = r14.didSyncStateChange()
            if (r0 == 0) goto L13
            goto L15
        L13:
            r0 = r2
            goto L16
        L15:
            r0 = r1
        L16:
            java.lang.String r3 = "We got a new snapshot with no changes?"
            java.lang.Object[] r4 = new java.lang.Object[r2]
            com.google.firebase.firestore.util.Assert.hardAssert(r0, r3, r4)
            com.google.firebase.firestore.core.EventManager$ListenOptions r0 = r13.options
            boolean r0 = r0.includeDocumentMetadataChanges
            if (r0 != 0) goto L6b
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r0 = r14.getChanges()
            java.util.Iterator r0 = r0.iterator()
        L30:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L48
            java.lang.Object r3 = r0.next()
            com.google.firebase.firestore.core.DocumentViewChange r3 = (com.google.firebase.firestore.core.DocumentViewChange) r3
            com.google.firebase.firestore.core.DocumentViewChange$Type r4 = r3.getType()
            com.google.firebase.firestore.core.DocumentViewChange$Type r5 = com.google.firebase.firestore.core.DocumentViewChange.Type.METADATA
            if (r4 == r5) goto L30
            r7.add(r3)
            goto L30
        L48:
            com.google.firebase.firestore.core.ViewSnapshot r3 = new com.google.firebase.firestore.core.ViewSnapshot
            com.google.firebase.firestore.core.Query r4 = r14.getQuery()
            com.google.firebase.firestore.model.DocumentSet r5 = r14.getDocuments()
            com.google.firebase.firestore.model.DocumentSet r6 = r14.getOldDocuments()
            boolean r8 = r14.isFromCache()
            com.google.firebase.database.collection.ImmutableSortedSet r9 = r14.getMutatedKeys()
            boolean r10 = r14.didSyncStateChange()
            r11 = 1
            boolean r12 = r14.hasCachedResults()
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r14 = r3
        L6b:
            boolean r0 = r13.raisedInitialEvent
            if (r0 != 0) goto L7b
            com.google.firebase.firestore.core.OnlineState r0 = r13.onlineState
            boolean r0 = r13.shouldRaiseInitialEvent(r14, r0)
            if (r0 == 0) goto L88
            r13.raiseInitialEvent(r14)
            goto L89
        L7b:
            boolean r0 = r13.shouldRaiseEvent(r14)
            if (r0 == 0) goto L88
            com.google.firebase.firestore.EventListener<com.google.firebase.firestore.core.ViewSnapshot> r0 = r13.listener
            r2 = 0
            r0.onEvent(r14, r2)
            goto L89
        L88:
            r1 = r2
        L89:
            r13.snapshot = r14
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.core.QueryListener.onViewSnapshot(com.google.firebase.firestore.core.ViewSnapshot):boolean");
    }
}
