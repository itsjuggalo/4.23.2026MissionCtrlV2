package com.google.firebase.firestore.local;

import com.google.firebase.firestore.local.IndexBackfiller;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Supplier;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class IndexBackfiller {
    private static final String LOG_TAG = "IndexBackfiller";
    private static final int MAX_DOCUMENTS_TO_PROCESS = 50;
    private final Z1.r indexManagerOfCurrentUser;
    private final Z1.r localDocumentsViewOfCurrentUser;
    private int maxDocumentsToProcess;
    private final Persistence persistence;
    private final Scheduler scheduler;
    private static final long INITIAL_BACKFILL_DELAY_MS = TimeUnit.SECONDS.toMillis(15);
    private static final long REGULAR_BACKFILL_DELAY_MS = TimeUnit.MINUTES.toMillis(1);

    public class Scheduler implements com.google.firebase.firestore.local.Scheduler {
        private final AsyncQueue asyncQueue;
        private AsyncQueue.DelayedTask backfillTask;

        public Scheduler(AsyncQueue asyncQueue) {
            this.asyncQueue = asyncQueue;
        }

        public static /* synthetic */ void a(Scheduler scheduler) {
            Logger.debug(IndexBackfiller.LOG_TAG, "Documents written: %s", Integer.valueOf(IndexBackfiller.this.backfill()));
            scheduler.scheduleBackfill(IndexBackfiller.REGULAR_BACKFILL_DELAY_MS);
        }

        private void scheduleBackfill(long j4) {
            this.backfillTask = this.asyncQueue.enqueueAfterDelay(AsyncQueue.TimerId.INDEX_BACKFILL, j4, new Runnable() { // from class: com.google.firebase.firestore.local.f
                @Override // java.lang.Runnable
                public final void run() {
                    IndexBackfiller.Scheduler.a(this.f10572a);
                }
            });
        }

        @Override // com.google.firebase.firestore.local.Scheduler
        public void start() {
            scheduleBackfill(IndexBackfiller.INITIAL_BACKFILL_DELAY_MS);
        }

        @Override // com.google.firebase.firestore.local.Scheduler
        public void stop() {
            AsyncQueue.DelayedTask delayedTask = this.backfillTask;
            if (delayedTask != null) {
                delayedTask.cancel();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IndexBackfiller(Persistence persistence, AsyncQueue asyncQueue, final LocalStore localStore) {
        this(persistence, asyncQueue, new Z1.r() { // from class: com.google.firebase.firestore.local.c
            @Override // Z1.r
            public final Object get() {
                return localStore.getIndexManagerForCurrentUser();
            }
        }, new Z1.r() { // from class: com.google.firebase.firestore.local.d
            @Override // Z1.r
            public final Object get() {
                return localStore.getLocalDocumentsForCurrentUser();
            }
        });
        Objects.requireNonNull(localStore);
    }

    private FieldIndex.IndexOffset getNewOffset(FieldIndex.IndexOffset indexOffset, LocalDocumentsResult localDocumentsResult) {
        Iterator<Map.Entry<DocumentKey, Document>> it = localDocumentsResult.getDocuments().iterator();
        FieldIndex.IndexOffset indexOffset2 = indexOffset;
        while (it.hasNext()) {
            FieldIndex.IndexOffset indexOffsetFromDocument = FieldIndex.IndexOffset.fromDocument(it.next().getValue());
            if (indexOffsetFromDocument.compareTo(indexOffset2) > 0) {
                indexOffset2 = indexOffsetFromDocument;
            }
        }
        return FieldIndex.IndexOffset.create(indexOffset2.getReadTime(), indexOffset2.getDocumentKey(), Math.max(localDocumentsResult.getBatchId(), indexOffset.getLargestBatchId()));
    }

    private int writeEntriesForCollectionGroup(String str, int i4) {
        IndexManager indexManager = (IndexManager) this.indexManagerOfCurrentUser.get();
        LocalDocumentsView localDocumentsView = (LocalDocumentsView) this.localDocumentsViewOfCurrentUser.get();
        FieldIndex.IndexOffset minOffset = indexManager.getMinOffset(str);
        LocalDocumentsResult nextDocuments = localDocumentsView.getNextDocuments(str, minOffset, i4);
        indexManager.updateIndexEntries(nextDocuments.getDocuments());
        FieldIndex.IndexOffset newOffset = getNewOffset(minOffset, nextDocuments);
        Logger.debug(LOG_TAG, "Updating offset: %s", newOffset);
        indexManager.updateCollectionGroup(str, newOffset);
        return nextDocuments.getDocuments().size();
    }

    private int writeIndexEntries() {
        IndexManager indexManager = (IndexManager) this.indexManagerOfCurrentUser.get();
        HashSet hashSet = new HashSet();
        int iWriteEntriesForCollectionGroup = this.maxDocumentsToProcess;
        while (iWriteEntriesForCollectionGroup > 0) {
            String nextCollectionGroupToUpdate = indexManager.getNextCollectionGroupToUpdate();
            if (nextCollectionGroupToUpdate == null || hashSet.contains(nextCollectionGroupToUpdate)) {
                break;
            }
            Logger.debug(LOG_TAG, "Processing collection: %s", nextCollectionGroupToUpdate);
            iWriteEntriesForCollectionGroup -= writeEntriesForCollectionGroup(nextCollectionGroupToUpdate, iWriteEntriesForCollectionGroup);
            hashSet.add(nextCollectionGroupToUpdate);
        }
        return this.maxDocumentsToProcess - iWriteEntriesForCollectionGroup;
    }

    public int backfill() {
        return ((Integer) this.persistence.runTransaction("Backfill Indexes", new Supplier() { // from class: com.google.firebase.firestore.local.e
            @Override // com.google.firebase.firestore.util.Supplier
            public final Object get() {
                return Integer.valueOf(this.f10568a.writeIndexEntries());
            }
        })).intValue();
    }

    public Scheduler getScheduler() {
        return this.scheduler;
    }

    public void setMaxDocumentsToProcess(int i4) {
        this.maxDocumentsToProcess = i4;
    }

    public IndexBackfiller(Persistence persistence, AsyncQueue asyncQueue, Z1.r rVar, Z1.r rVar2) {
        this.maxDocumentsToProcess = 50;
        this.persistence = persistence;
        this.scheduler = new Scheduler(asyncQueue);
        this.indexManagerOfCurrentUser = rVar;
        this.localDocumentsViewOfCurrentUser = rVar2;
    }
}
