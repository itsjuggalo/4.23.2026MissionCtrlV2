package com.google.firebase.firestore.local;

import android.util.SparseArray;
import com.google.firebase.firestore.local.LruGarbageCollector;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Consumer;
import com.google.firebase.firestore.util.Logger;
import java.util.Comparator;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class LruGarbageCollector {
    private static final long INITIAL_GC_DELAY_MS;
    private static final long REGULAR_GC_DELAY_MS;
    private final LruDelegate delegate;
    private final Params params;

    public class GCScheduler implements Scheduler {
        private final AsyncQueue asyncQueue;
        private AsyncQueue.DelayedTask gcTask;
        private boolean hasRun = false;
        private final LocalStore localStore;

        public GCScheduler(AsyncQueue asyncQueue, LocalStore localStore) {
            this.asyncQueue = asyncQueue;
            this.localStore = localStore;
        }

        public static /* synthetic */ void a(GCScheduler gCScheduler) {
            gCScheduler.localStore.collectGarbage(LruGarbageCollector.this);
            gCScheduler.hasRun = true;
            gCScheduler.scheduleGC();
        }

        private void scheduleGC() {
            this.gcTask = this.asyncQueue.enqueueAfterDelay(AsyncQueue.TimerId.GARBAGE_COLLECTION, this.hasRun ? LruGarbageCollector.REGULAR_GC_DELAY_MS : LruGarbageCollector.INITIAL_GC_DELAY_MS, new Runnable() { // from class: com.google.firebase.firestore.local.D
                @Override // java.lang.Runnable
                public final void run() {
                    LruGarbageCollector.GCScheduler.a(this.f10494a);
                }
            });
        }

        @Override // com.google.firebase.firestore.local.Scheduler
        public void start() {
            if (LruGarbageCollector.this.params.minBytesThreshold != -1) {
                scheduleGC();
            }
        }

        @Override // com.google.firebase.firestore.local.Scheduler
        public void stop() {
            AsyncQueue.DelayedTask delayedTask = this.gcTask;
            if (delayedTask != null) {
                delayedTask.cancel();
            }
        }
    }

    public static class Params {
        private static final long COLLECTION_DISABLED = -1;
        private static final long DEFAULT_CACHE_SIZE_BYTES = 104857600;
        private static final int DEFAULT_COLLECTION_PERCENTILE = 10;
        private static final int DEFAULT_MAX_SEQUENCE_NUMBERS_TO_COLLECT = 1000;
        final int maximumSequenceNumbersToCollect;
        long minBytesThreshold;
        int percentileToCollect;

        public Params(long j4, int i4, int i5) {
            this.minBytesThreshold = j4;
            this.percentileToCollect = i4;
            this.maximumSequenceNumbersToCollect = i5;
        }

        public static Params Default() {
            return new Params(DEFAULT_CACHE_SIZE_BYTES, 10, DEFAULT_MAX_SEQUENCE_NUMBERS_TO_COLLECT);
        }

        public static Params Disabled() {
            return new Params(-1L, 0, 0);
        }

        public static Params WithCacheSizeBytes(long j4) {
            return new Params(j4, 10, DEFAULT_MAX_SEQUENCE_NUMBERS_TO_COLLECT);
        }
    }

    public static class Results {
        private final int documentsRemoved;
        private final boolean hasRun;
        private final int sequenceNumbersCollected;
        private final int targetsRemoved;

        public Results(boolean z4, int i4, int i5, int i6) {
            this.hasRun = z4;
            this.sequenceNumbersCollected = i4;
            this.targetsRemoved = i5;
            this.documentsRemoved = i6;
        }

        public static Results DidNotRun() {
            return new Results(false, 0, 0, 0);
        }

        public int getDocumentsRemoved() {
            return this.documentsRemoved;
        }

        public int getSequenceNumbersCollected() {
            return this.sequenceNumbersCollected;
        }

        public int getTargetsRemoved() {
            return this.targetsRemoved;
        }

        public boolean hasRun() {
            return this.hasRun;
        }
    }

    public static class RollingSequenceNumberBuffer {
        private static final Comparator<Long> COMPARATOR = new Comparator() { // from class: com.google.firebase.firestore.local.E
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((Long) obj2).compareTo((Long) obj);
            }
        };
        private final int maxElements;
        private final PriorityQueue<Long> queue;

        public RollingSequenceNumberBuffer(int i4) {
            this.maxElements = i4;
            this.queue = new PriorityQueue<>(i4, COMPARATOR);
        }

        public void addElement(Long l4) {
            if (this.queue.size() < this.maxElements) {
                this.queue.add(l4);
                return;
            }
            if (l4.longValue() < this.queue.peek().longValue()) {
                this.queue.poll();
                this.queue.add(l4);
            }
        }

        public long getMaxValue() {
            return this.queue.peek().longValue();
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        INITIAL_GC_DELAY_MS = timeUnit.toMillis(1L);
        REGULAR_GC_DELAY_MS = timeUnit.toMillis(5L);
    }

    public LruGarbageCollector(LruDelegate lruDelegate, Params params) {
        this.delegate = lruDelegate;
        this.params = params;
    }

    private Results runGarbageCollection(SparseArray<?> sparseArray) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iCalculateQueryCount = calculateQueryCount(this.params.percentileToCollect);
        if (iCalculateQueryCount > this.params.maximumSequenceNumbersToCollect) {
            Logger.debug("LruGarbageCollector", "Capping sequence numbers to collect down to the maximum of " + this.params.maximumSequenceNumbersToCollect + " from " + iCalculateQueryCount, new Object[0]);
            iCalculateQueryCount = this.params.maximumSequenceNumbersToCollect;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        long nthSequenceNumber = getNthSequenceNumber(iCalculateQueryCount);
        long jCurrentTimeMillis3 = System.currentTimeMillis();
        int iRemoveTargets = removeTargets(nthSequenceNumber, sparseArray);
        long jCurrentTimeMillis4 = System.currentTimeMillis();
        int iRemoveOrphanedDocuments = removeOrphanedDocuments(nthSequenceNumber);
        long jCurrentTimeMillis5 = System.currentTimeMillis();
        if (Logger.isDebugEnabled()) {
            String str = "LRU Garbage Collection:\n\tCounted targets in " + (jCurrentTimeMillis2 - jCurrentTimeMillis) + "ms\n";
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            Locale locale = Locale.ROOT;
            sb.append(String.format(locale, "\tDetermined least recently used %d sequence numbers in %dms\n", Integer.valueOf(iCalculateQueryCount), Long.valueOf(jCurrentTimeMillis3 - jCurrentTimeMillis2)));
            Logger.debug("LruGarbageCollector", ((sb.toString() + String.format(locale, "\tRemoved %d targets in %dms\n", Integer.valueOf(iRemoveTargets), Long.valueOf(jCurrentTimeMillis4 - jCurrentTimeMillis3))) + String.format(locale, "\tRemoved %d documents in %dms\n", Integer.valueOf(iRemoveOrphanedDocuments), Long.valueOf(jCurrentTimeMillis5 - jCurrentTimeMillis4))) + String.format(locale, "Total Duration: %dms", Long.valueOf(jCurrentTimeMillis5 - jCurrentTimeMillis)), new Object[0]);
        }
        return new Results(true, iCalculateQueryCount, iRemoveTargets, iRemoveOrphanedDocuments);
    }

    public int calculateQueryCount(int i4) {
        return (int) ((i4 / 100.0f) * this.delegate.getSequenceNumberCount());
    }

    public Results collect(SparseArray<?> sparseArray) {
        if (this.params.minBytesThreshold == -1) {
            Logger.debug("LruGarbageCollector", "Garbage collection skipped; disabled", new Object[0]);
            return Results.DidNotRun();
        }
        long byteSize = getByteSize();
        if (byteSize >= this.params.minBytesThreshold) {
            return runGarbageCollection(sparseArray);
        }
        Logger.debug("LruGarbageCollector", "Garbage collection skipped; Cache size " + byteSize + " is lower than threshold " + this.params.minBytesThreshold, new Object[0]);
        return Results.DidNotRun();
    }

    public long getByteSize() {
        return this.delegate.getByteSize();
    }

    public long getNthSequenceNumber(int i4) {
        if (i4 == 0) {
            return -1L;
        }
        final RollingSequenceNumberBuffer rollingSequenceNumberBuffer = new RollingSequenceNumberBuffer(i4);
        this.delegate.forEachTarget(new Consumer() { // from class: com.google.firebase.firestore.local.B
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                rollingSequenceNumberBuffer.addElement(Long.valueOf(((TargetData) obj).getSequenceNumber()));
            }
        });
        this.delegate.forEachOrphanedDocumentSequenceNumber(new Consumer() { // from class: com.google.firebase.firestore.local.C
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                rollingSequenceNumberBuffer.addElement((Long) obj);
            }
        });
        return rollingSequenceNumberBuffer.getMaxValue();
    }

    public GCScheduler newScheduler(AsyncQueue asyncQueue, LocalStore localStore) {
        return new GCScheduler(asyncQueue, localStore);
    }

    public int removeOrphanedDocuments(long j4) {
        return this.delegate.removeOrphanedDocuments(j4);
    }

    public int removeTargets(long j4, SparseArray<?> sparseArray) {
        return this.delegate.removeTargets(j4, sparseArray);
    }

    public LruGarbageCollector withNewThreshold(long j4) {
        Params params = this.params;
        params.minBytesThreshold = j4;
        params.percentileToCollect = 100;
        return this;
    }
}
