package com.google.firebase.firestore.model.mutation;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_Overlay extends Overlay {
    private final int largestBatchId;
    private final Mutation mutation;

    public AutoValue_Overlay(int i4, Mutation mutation) {
        this.largestBatchId = i4;
        if (mutation == null) {
            throw new NullPointerException("Null mutation");
        }
        this.mutation = mutation;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Overlay) {
            Overlay overlay = (Overlay) obj;
            if (this.largestBatchId == overlay.getLargestBatchId() && this.mutation.equals(overlay.getMutation())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.firestore.model.mutation.Overlay
    public int getLargestBatchId() {
        return this.largestBatchId;
    }

    @Override // com.google.firebase.firestore.model.mutation.Overlay
    public Mutation getMutation() {
        return this.mutation;
    }

    public int hashCode() {
        return ((this.largestBatchId ^ 1000003) * 1000003) ^ this.mutation.hashCode();
    }

    public String toString() {
        return "Overlay{largestBatchId=" + this.largestBatchId + ", mutation=" + this.mutation + "}";
    }
}
