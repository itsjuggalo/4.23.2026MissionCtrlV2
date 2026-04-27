package com.google.firebase.firestore;

/* JADX INFO: loaded from: classes.dex */
public final class PersistentCacheSettings implements LocalCacheSettings {
    private final long sizeBytes;

    public static class Builder {
        private long sizeBytes;

        public PersistentCacheSettings build() {
            return new PersistentCacheSettings(this.sizeBytes);
        }

        public Builder setSizeBytes(long j4) {
            this.sizeBytes = j4;
            return this;
        }

        private Builder() {
            this.sizeBytes = 104857600L;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && PersistentCacheSettings.class == obj.getClass() && this.sizeBytes == ((PersistentCacheSettings) obj).sizeBytes;
    }

    public long getSizeBytes() {
        return this.sizeBytes;
    }

    public int hashCode() {
        long j4 = this.sizeBytes;
        return (int) (j4 ^ (j4 >>> 32));
    }

    public String toString() {
        return "PersistentCacheSettings{sizeBytes=" + this.sizeBytes + '}';
    }

    private PersistentCacheSettings(long j4) {
        this.sizeBytes = j4;
    }
}
