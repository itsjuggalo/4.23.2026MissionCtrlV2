package com.google.firebase.firestore.model;

import com.google.firebase.firestore.model.FieldIndex;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_FieldIndex_IndexState extends FieldIndex.IndexState {
    private final FieldIndex.IndexOffset offset;
    private final long sequenceNumber;

    public AutoValue_FieldIndex_IndexState(long j4, FieldIndex.IndexOffset indexOffset) {
        this.sequenceNumber = j4;
        if (indexOffset == null) {
            throw new NullPointerException("Null offset");
        }
        this.offset = indexOffset;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FieldIndex.IndexState) {
            FieldIndex.IndexState indexState = (FieldIndex.IndexState) obj;
            if (this.sequenceNumber == indexState.getSequenceNumber() && this.offset.equals(indexState.getOffset())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.firestore.model.FieldIndex.IndexState
    public FieldIndex.IndexOffset getOffset() {
        return this.offset;
    }

    @Override // com.google.firebase.firestore.model.FieldIndex.IndexState
    public long getSequenceNumber() {
        return this.sequenceNumber;
    }

    public int hashCode() {
        long j4 = this.sequenceNumber;
        return ((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ this.offset.hashCode();
    }

    public String toString() {
        return "IndexState{sequenceNumber=" + this.sequenceNumber + ", offset=" + this.offset + "}";
    }
}
