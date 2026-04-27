package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class SQLiteOverlayMigrationManager implements OverlayMigrationManager {
    private final SQLitePersistence db;

    public SQLiteOverlayMigrationManager(SQLitePersistence sQLitePersistence) {
        this.db = sQLitePersistence;
    }

    public static /* synthetic */ void a(SQLiteOverlayMigrationManager sQLiteOverlayMigrationManager) {
        if (sQLiteOverlayMigrationManager.hasPendingOverlayMigration()) {
            Set<String> allUserIds = sQLiteOverlayMigrationManager.getAllUserIds();
            RemoteDocumentCache remoteDocumentCache = sQLiteOverlayMigrationManager.db.getRemoteDocumentCache();
            Iterator<String> it = allUserIds.iterator();
            while (it.hasNext()) {
                User user = new User(it.next());
                SQLitePersistence sQLitePersistence = sQLiteOverlayMigrationManager.db;
                MutationQueue mutationQueue = sQLitePersistence.getMutationQueue(user, sQLitePersistence.getIndexManager(user));
                HashSet hashSet = new HashSet();
                Iterator<MutationBatch> it2 = mutationQueue.getAllMutationBatches().iterator();
                while (it2.hasNext()) {
                    hashSet.addAll(it2.next().getKeys());
                }
                new LocalDocumentsView(remoteDocumentCache, mutationQueue, sQLiteOverlayMigrationManager.db.getDocumentOverlayCache(user), sQLiteOverlayMigrationManager.db.getIndexManager(user)).recalculateAndSaveOverlays(hashSet);
            }
            sQLiteOverlayMigrationManager.removePendingOverlayMigrations();
        }
    }

    private void buildOverlays() {
        this.db.runTransaction("build overlays", new Runnable() { // from class: com.google.firebase.firestore.local.n0
            @Override // java.lang.Runnable
            public final void run() {
                SQLiteOverlayMigrationManager.a(this.f10600a);
            }
        });
    }

    public static /* synthetic */ void c(Boolean[] boolArr, Cursor cursor) {
        try {
            if (Persistence.DATA_MIGRATION_BUILD_OVERLAYS.equals(cursor.getString(0))) {
                boolArr[0] = Boolean.TRUE;
            }
        } catch (IllegalArgumentException e4) {
            throw Assert.fail("SQLitePersistence.DataMigration failed to parse: %s", e4);
        }
    }

    private Set<String> getAllUserIds() {
        final HashSet hashSet = new HashSet();
        this.db.query("SELECT DISTINCT uid FROM mutation_queues").forEach(new Consumer() { // from class: com.google.firebase.firestore.local.p0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                hashSet.add(((Cursor) obj).getString(0));
            }
        });
        return hashSet;
    }

    private void removePendingOverlayMigrations() {
        this.db.execute("DELETE FROM data_migrations WHERE migration_name = ?", Persistence.DATA_MIGRATION_BUILD_OVERLAYS);
    }

    public boolean hasPendingOverlayMigration() {
        final Boolean[] boolArr = {Boolean.FALSE};
        this.db.query("SELECT migration_name FROM data_migrations").forEach(new Consumer() { // from class: com.google.firebase.firestore.local.o0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteOverlayMigrationManager.c(boolArr, (Cursor) obj);
            }
        });
        return boolArr[0].booleanValue();
    }

    @Override // com.google.firebase.firestore.local.OverlayMigrationManager
    public void run() {
        buildOverlays();
    }
}
