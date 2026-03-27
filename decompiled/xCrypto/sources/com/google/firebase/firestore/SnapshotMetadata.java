package com.google.firebase.firestore;

/* JADX INFO: loaded from: classes.dex */
public class SnapshotMetadata {
    private final boolean hasPendingWrites;
    private final boolean isFromCache;

    public SnapshotMetadata(boolean z4, boolean z5) {
        this.hasPendingWrites = z4;
        this.isFromCache = z5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SnapshotMetadata)) {
            return false;
        }
        SnapshotMetadata snapshotMetadata = (SnapshotMetadata) obj;
        return this.hasPendingWrites == snapshotMetadata.hasPendingWrites && this.isFromCache == snapshotMetadata.isFromCache;
    }

    public boolean hasPendingWrites() {
        return this.hasPendingWrites;
    }

    public int hashCode() {
        return ((this.hasPendingWrites ? 1 : 0) * 31) + (this.isFromCache ? 1 : 0);
    }

    public boolean isFromCache() {
        return this.isFromCache;
    }

    public String toString() {
        return "SnapshotMetadata{hasPendingWrites=" + this.hasPendingWrites + ", isFromCache=" + this.isFromCache + '}';
    }
}
