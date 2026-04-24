package com.google.firebase.firestore.model;

import java.util.Comparator;
import p2.C1698D;

/* JADX INFO: loaded from: classes.dex */
public interface Document {
    public static final Comparator<Document> KEY_COMPARATOR = new Comparator() { // from class: com.google.firebase.firestore.model.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ((Document) obj).getKey().compareTo(((Document) obj2).getKey());
        }
    };

    ObjectValue getData();

    C1698D getField(FieldPath fieldPath);

    DocumentKey getKey();

    SnapshotVersion getReadTime();

    SnapshotVersion getVersion();

    boolean hasCommittedMutations();

    boolean hasLocalMutations();

    boolean hasPendingWrites();

    boolean isFoundDocument();

    boolean isNoDocument();

    boolean isUnknownDocument();

    boolean isValidDocument();

    MutableDocument mutableCopy();
}
