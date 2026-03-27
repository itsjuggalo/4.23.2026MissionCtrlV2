package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.remote.WatchChangeAggregator;
import com.google.firebase.firestore.util.Preconditions;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import p2.C1710g;

/* JADX INFO: loaded from: classes.dex */
final class TestingHooks {
    private static final TestingHooks instance = new TestingHooks();
    private final CopyOnWriteArrayList<AtomicReference<ExistenceFilterMismatchListener>> existenceFilterMismatchListeners = new CopyOnWriteArrayList<>();

    public static abstract class ExistenceFilterBloomFilterInfo {
        public static ExistenceFilterBloomFilterInfo create(BloomFilter bloomFilter, boolean z4, int i4, int i5, int i6) {
            return new AutoValue_TestingHooks_ExistenceFilterBloomFilterInfo(bloomFilter, z4, i4, i5, i6);
        }

        public static ExistenceFilterBloomFilterInfo from(BloomFilter bloomFilter, WatchChangeAggregator.BloomFilterApplicationStatus bloomFilterApplicationStatus, ExistenceFilter existenceFilter) {
            C1710g unchangedNames = existenceFilter.getUnchangedNames();
            if (unchangedNames == null) {
                return null;
            }
            return create(bloomFilter, bloomFilterApplicationStatus == WatchChangeAggregator.BloomFilterApplicationStatus.SUCCESS, unchangedNames.m(), unchangedNames.k().k().size(), unchangedNames.k().m());
        }

        public abstract boolean applied();

        public abstract int bitmapLength();

        public abstract BloomFilter bloomFilter();

        public abstract int hashCount();

        public abstract int padding();
    }

    public static abstract class ExistenceFilterMismatchInfo {
        public static ExistenceFilterMismatchInfo create(int i4, int i5, String str, String str2, ExistenceFilterBloomFilterInfo existenceFilterBloomFilterInfo) {
            return new AutoValue_TestingHooks_ExistenceFilterMismatchInfo(i4, i5, str, str2, existenceFilterBloomFilterInfo);
        }

        public static ExistenceFilterMismatchInfo from(int i4, ExistenceFilter existenceFilter, DatabaseId databaseId, BloomFilter bloomFilter, WatchChangeAggregator.BloomFilterApplicationStatus bloomFilterApplicationStatus) {
            return create(i4, existenceFilter.getCount(), databaseId.getProjectId(), databaseId.getDatabaseId(), ExistenceFilterBloomFilterInfo.from(bloomFilter, bloomFilterApplicationStatus, existenceFilter));
        }

        public abstract ExistenceFilterBloomFilterInfo bloomFilter();

        public abstract String databaseId();

        public abstract int existenceFilterCount();

        public abstract int localCacheCount();

        public abstract String projectId();
    }

    public interface ExistenceFilterMismatchListener {
        void onExistenceFilterMismatch(ExistenceFilterMismatchInfo existenceFilterMismatchInfo);
    }

    private TestingHooks() {
    }

    public static /* synthetic */ void a(TestingHooks testingHooks, AtomicReference atomicReference) {
        testingHooks.getClass();
        atomicReference.set(null);
        testingHooks.existenceFilterMismatchListeners.remove(atomicReference);
    }

    public static TestingHooks getInstance() {
        return instance;
    }

    public ListenerRegistration addExistenceFilterMismatchListener(ExistenceFilterMismatchListener existenceFilterMismatchListener) {
        Preconditions.checkNotNull(existenceFilterMismatchListener, "a null listener is not allowed");
        final AtomicReference<ExistenceFilterMismatchListener> atomicReference = new AtomicReference<>(existenceFilterMismatchListener);
        this.existenceFilterMismatchListeners.add(atomicReference);
        return new ListenerRegistration() { // from class: com.google.firebase.firestore.remote.A
            @Override // com.google.firebase.firestore.ListenerRegistration
            public final void remove() {
                TestingHooks.a(this.f10659a, atomicReference);
            }
        };
    }

    public void notifyOnExistenceFilterMismatch(ExistenceFilterMismatchInfo existenceFilterMismatchInfo) {
        Iterator<AtomicReference<ExistenceFilterMismatchListener>> it = this.existenceFilterMismatchListeners.iterator();
        while (it.hasNext()) {
            ExistenceFilterMismatchListener existenceFilterMismatchListener = it.next().get();
            if (existenceFilterMismatchListener != null) {
                existenceFilterMismatchListener.onExistenceFilterMismatch(existenceFilterMismatchInfo);
            }
        }
    }
}
