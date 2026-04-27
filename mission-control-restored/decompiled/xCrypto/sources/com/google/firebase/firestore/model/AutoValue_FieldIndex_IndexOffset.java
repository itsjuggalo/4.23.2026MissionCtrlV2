package com.google.firebase.firestore.model;

import com.google.firebase.firestore.model.FieldIndex;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_FieldIndex_IndexOffset extends FieldIndex.IndexOffset {
    private final DocumentKey documentKey;
    private final int largestBatchId;
    private final SnapshotVersion readTime;

    public AutoValue_FieldIndex_IndexOffset(SnapshotVersion snapshotVersion, DocumentKey documentKey, int i4) {
        if (snapshotVersion == null) {
            throw new NullPointerException("Null readTime");
        }
        this.readTime = snapshotVersion;
        if (documentKey == null) {
            throw new NullPointerException("Null documentKey");
        }
        this.documentKey = documentKey;
        this.largestBatchId = i4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FieldIndex.IndexOffset) {
            FieldIndex.IndexOffset indexOffset = (FieldIndex.IndexOffset) obj;
            if (this.readTime.equals(indexOffset.getReadTime()) && this.documentKey.equals(indexOffset.getDocumentKey()) && this.largestBatchId == indexOffset.getLargestBatchId()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.firestore.model.FieldIndex.IndexOffset
    public DocumentKey getDocumentKey() {
        return this.documentKey;
    }

    @Override // com.google.firebase.firestore.model.FieldIndex.IndexOffset
    public int getLargestBatchId() {
        return this.largestBatchId;
    }

    @Override // com.google.firebase.firestore.model.FieldIndex.IndexOffset
    public SnapshotVersion getReadTime() {
        return this.readTime;
    }

    public int hashCode() {
        return ((((this.readTime.hashCode() ^ 1000003) * 1000003) ^ this.documentKey.hashCode()) * 1000003) ^ this.largestBatchId;
    }

    public String toString() {
        return "IndexOffset{readTime=" + this.readTime + ", documentKey=" + this.documentKey + ", largestBatchId=" + this.largestBatchId + "}";
    }
}
