package com.google.firebase.firestore.model;

import com.google.firebase.firestore.model.FieldIndex;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_FieldIndex extends FieldIndex {
    private final String collectionGroup;
    private final int indexId;
    private final FieldIndex.IndexState indexState;
    private final List<FieldIndex.Segment> segments;

    public AutoValue_FieldIndex(int i4, String str, List<FieldIndex.Segment> list, FieldIndex.IndexState indexState) {
        this.indexId = i4;
        if (str == null) {
            throw new NullPointerException("Null collectionGroup");
        }
        this.collectionGroup = str;
        if (list == null) {
            throw new NullPointerException("Null segments");
        }
        this.segments = list;
        if (indexState == null) {
            throw new NullPointerException("Null indexState");
        }
        this.indexState = indexState;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FieldIndex) {
            FieldIndex fieldIndex = (FieldIndex) obj;
            if (this.indexId == fieldIndex.getIndexId() && this.collectionGroup.equals(fieldIndex.getCollectionGroup()) && this.segments.equals(fieldIndex.getSegments()) && this.indexState.equals(fieldIndex.getIndexState())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.firestore.model.FieldIndex
    public String getCollectionGroup() {
        return this.collectionGroup;
    }

    @Override // com.google.firebase.firestore.model.FieldIndex
    public int getIndexId() {
        return this.indexId;
    }

    @Override // com.google.firebase.firestore.model.FieldIndex
    public FieldIndex.IndexState getIndexState() {
        return this.indexState;
    }

    @Override // com.google.firebase.firestore.model.FieldIndex
    public List<FieldIndex.Segment> getSegments() {
        return this.segments;
    }

    public int hashCode() {
        return ((((((this.indexId ^ 1000003) * 1000003) ^ this.collectionGroup.hashCode()) * 1000003) ^ this.segments.hashCode()) * 1000003) ^ this.indexState.hashCode();
    }

    public String toString() {
        return "FieldIndex{indexId=" + this.indexId + ", collectionGroup=" + this.collectionGroup + ", segments=" + this.segments + ", indexState=" + this.indexState + "}";
    }
}
