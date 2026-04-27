package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.mutation.FieldMask;

/* JADX INFO: loaded from: classes.dex */
public class OverlayedDocument {
    private FieldMask mutatedFields;
    private Document overlayedDocument;

    public OverlayedDocument(Document document, FieldMask fieldMask) {
        this.overlayedDocument = document;
        this.mutatedFields = fieldMask;
    }

    public Document getDocument() {
        return this.overlayedDocument;
    }

    public FieldMask getMutatedFields() {
        return this.mutatedFields;
    }
}
