package com.google.firebase.firestore;

/* JADX INFO: loaded from: classes.dex */
public final class MemoryLruGcSettings implements MemoryGarbageCollectorSettings {
    private long sizeBytes;

    public static class Builder {
        private long sizeBytes;

        public MemoryLruGcSettings build() {
            return new MemoryLruGcSettings(this.sizeBytes);
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
        return obj != null && MemoryLruGcSettings.class == obj.getClass() && this.sizeBytes == ((MemoryLruGcSettings) obj).sizeBytes;
    }

    public long getSizeBytes() {
        return this.sizeBytes;
    }

    public int hashCode() {
        long j4 = this.sizeBytes;
        return (int) (j4 ^ (j4 >>> 32));
    }

    public String toString() {
        return "MemoryLruGcSettings{cacheSize=" + getSizeBytes() + "}";
    }

    private MemoryLruGcSettings(long j4) {
        this.sizeBytes = j4;
    }
}
