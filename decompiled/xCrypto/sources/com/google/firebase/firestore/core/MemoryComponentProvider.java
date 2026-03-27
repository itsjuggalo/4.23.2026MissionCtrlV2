package com.google.firebase.firestore.core;

import K2.l0;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.MemoryCacheSettings;
import com.google.firebase.firestore.MemoryLruGcSettings;
import com.google.firebase.firestore.core.ComponentProvider;
import com.google.firebase.firestore.local.IndexBackfiller;
import com.google.firebase.firestore.local.LocalSerializer;
import com.google.firebase.firestore.local.LocalStore;
import com.google.firebase.firestore.local.LruGarbageCollector;
import com.google.firebase.firestore.local.MemoryPersistence;
import com.google.firebase.firestore.local.Persistence;
import com.google.firebase.firestore.local.QueryEngine;
import com.google.firebase.firestore.local.Scheduler;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.mutation.MutationBatchResult;
import com.google.firebase.firestore.remote.RemoteEvent;
import com.google.firebase.firestore.remote.RemoteStore;

/* JADX INFO: loaded from: classes.dex */
public class MemoryComponentProvider extends ComponentProvider {

    public class RemoteStoreCallback implements RemoteStore.RemoteStoreCallback {
        private RemoteStoreCallback() {
        }

        @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
        public ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int i4) {
            return MemoryComponentProvider.this.getSyncEngine().getRemoteKeysForTarget(i4);
        }

        @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
        public void handleOnlineStateChange(OnlineState onlineState) {
            MemoryComponentProvider.this.getSyncEngine().handleOnlineStateChange(onlineState);
        }

        @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
        public void handleRejectedListen(int i4, l0 l0Var) {
            MemoryComponentProvider.this.getSyncEngine().handleRejectedListen(i4, l0Var);
        }

        @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
        public void handleRejectedWrite(int i4, l0 l0Var) {
            MemoryComponentProvider.this.getSyncEngine().handleRejectedWrite(i4, l0Var);
        }

        @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
        public void handleRemoteEvent(RemoteEvent remoteEvent) {
            MemoryComponentProvider.this.getSyncEngine().handleRemoteEvent(remoteEvent);
        }

        @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
        public void handleSuccessfulWrite(MutationBatchResult mutationBatchResult) {
            MemoryComponentProvider.this.getSyncEngine().handleSuccessfulWrite(mutationBatchResult);
        }
    }

    public MemoryComponentProvider(FirebaseFirestoreSettings firebaseFirestoreSettings) {
        super(firebaseFirestoreSettings);
    }

    private boolean isMemoryLruGcEnabled(FirebaseFirestoreSettings firebaseFirestoreSettings) {
        if (firebaseFirestoreSettings.getCacheSettings() == null || !(firebaseFirestoreSettings.getCacheSettings() instanceof MemoryCacheSettings)) {
            return false;
        }
        return ((MemoryCacheSettings) firebaseFirestoreSettings.getCacheSettings()).getGarbageCollectorSettings() instanceof MemoryLruGcSettings;
    }

    @Override // com.google.firebase.firestore.core.ComponentProvider
    public EventManager createEventManager(ComponentProvider.Configuration configuration) {
        return new EventManager(getSyncEngine());
    }

    @Override // com.google.firebase.firestore.core.ComponentProvider
    public Scheduler createGarbageCollectionScheduler(ComponentProvider.Configuration configuration) {
        return null;
    }

    @Override // com.google.firebase.firestore.core.ComponentProvider
    public IndexBackfiller createIndexBackfiller(ComponentProvider.Configuration configuration) {
        return null;
    }

    @Override // com.google.firebase.firestore.core.ComponentProvider
    public LocalStore createLocalStore(ComponentProvider.Configuration configuration) {
        return new LocalStore(getPersistence(), new QueryEngine(), configuration.initialUser);
    }

    @Override // com.google.firebase.firestore.core.ComponentProvider
    public Persistence createPersistence(ComponentProvider.Configuration configuration) {
        if (!isMemoryLruGcEnabled(this.settings)) {
            return MemoryPersistence.createEagerGcMemoryPersistence();
        }
        return MemoryPersistence.createLruGcMemoryPersistence(LruGarbageCollector.Params.WithCacheSizeBytes(this.settings.getCacheSizeBytes()), new LocalSerializer(getRemoteSerializer()));
    }

    @Override // com.google.firebase.firestore.core.ComponentProvider
    public RemoteStore createRemoteStore(ComponentProvider.Configuration configuration) {
        return new RemoteStore(configuration.databaseInfo.getDatabaseId(), new RemoteStoreCallback(), getLocalStore(), getDatastore(), configuration.asyncQueue, getConnectivityMonitor());
    }

    @Override // com.google.firebase.firestore.core.ComponentProvider
    public SyncEngine createSyncEngine(ComponentProvider.Configuration configuration) {
        return new SyncEngine(getLocalStore(), getRemoteStore(), configuration.initialUser, configuration.maxConcurrentLimboResolutions);
    }
}
