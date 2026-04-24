package com.google.firebase.firestore;

/* JADX INFO: loaded from: classes.dex */
public final class MemoryEagerGcSettings implements MemoryGarbageCollectorSettings {

    public static class Builder {
        public MemoryEagerGcSettings build() {
            return new MemoryEagerGcSettings();
        }

        private Builder() {
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && MemoryEagerGcSettings.class == obj.getClass();
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return "MemoryEagerGcSettings{}";
    }

    private MemoryEagerGcSettings() {
    }
}
