package com.google.firebase.firestore;

/* JADX INFO: loaded from: classes.dex */
public final class TransactionOptions {
    static final TransactionOptions DEFAULT = new Builder().build();
    static final int DEFAULT_MAX_ATTEMPTS_COUNT = 5;
    private final int maxAttempts;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && TransactionOptions.class == obj.getClass() && this.maxAttempts == ((TransactionOptions) obj).maxAttempts;
    }

    public int getMaxAttempts() {
        return this.maxAttempts;
    }

    public int hashCode() {
        return this.maxAttempts;
    }

    public String toString() {
        return "TransactionOptions{maxAttempts=" + this.maxAttempts + '}';
    }

    public static final class Builder {
        private int maxAttempts;

        public Builder() {
            this.maxAttempts = 5;
        }

        public TransactionOptions build() {
            return new TransactionOptions(this.maxAttempts);
        }

        public Builder setMaxAttempts(int i4) {
            if (i4 < 1) {
                throw new IllegalArgumentException("Max attempts must be at least 1");
            }
            this.maxAttempts = i4;
            return this;
        }

        public Builder(TransactionOptions transactionOptions) {
            this.maxAttempts = 5;
            this.maxAttempts = transactionOptions.maxAttempts;
        }
    }

    private TransactionOptions(int i4) {
        this.maxAttempts = i4;
    }
}
