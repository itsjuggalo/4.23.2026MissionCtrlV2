package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class LocalDocumentsResult {
    private final int batchId;
    private final ImmutableSortedMap<DocumentKey, Document> documents;

    public LocalDocumentsResult(int i4, ImmutableSortedMap<DocumentKey, Document> immutableSortedMap) {
        this.batchId = i4;
        this.documents = immutableSortedMap;
    }

    public static LocalDocumentsResult fromOverlayedDocuments(int i4, Map<DocumentKey, OverlayedDocument> map) {
        ImmutableSortedMap<DocumentKey, Document> immutableSortedMapEmptyDocumentMap = DocumentCollections.emptyDocumentMap();
        for (Map.Entry<DocumentKey, OverlayedDocument> entry : map.entrySet()) {
            immutableSortedMapEmptyDocumentMap = immutableSortedMapEmptyDocumentMap.insert(entry.getKey(), entry.getValue().getDocument());
        }
        return new LocalDocumentsResult(i4, immutableSortedMapEmptyDocumentMap);
    }

    public int getBatchId() {
        return this.batchId;
    }

    public ImmutableSortedMap<DocumentKey, Document> getDocuments() {
        return this.documents;
    }
}
