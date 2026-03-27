package com.google.firebase.firestore;

import com.google.firebase.firestore.core.FirestoreClient;

/* JADX INFO: loaded from: classes.dex */
public final class PersistentCacheIndexManager {
    private FirestoreClientProvider client;

    public PersistentCacheIndexManager(FirestoreClientProvider firestoreClientProvider) {
        this.client = firestoreClientProvider;
    }

    public void deleteAllIndexes() {
        this.client.procedure(new G.a() { // from class: com.google.firebase.firestore.M
            @Override // G.a
            public final void accept(Object obj) {
                ((FirestoreClient) obj).deleteAllFieldIndexes();
            }
        });
    }

    public void disableIndexAutoCreation() {
        this.client.procedure(new G.a() { // from class: com.google.firebase.firestore.L
            @Override // G.a
            public final void accept(Object obj) {
                ((FirestoreClient) obj).setIndexAutoCreationEnabled(false);
            }
        });
    }

    public void enableIndexAutoCreation() {
        this.client.procedure(new G.a() { // from class: com.google.firebase.firestore.K
            @Override // G.a
            public final void accept(Object obj) {
                ((FirestoreClient) obj).setIndexAutoCreationEnabled(true);
            }
        });
    }
}
