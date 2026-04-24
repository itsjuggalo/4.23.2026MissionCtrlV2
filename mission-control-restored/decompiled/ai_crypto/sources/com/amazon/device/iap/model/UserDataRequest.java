package com.amazon.device.iap.model;

/* JADX INFO: loaded from: classes.dex */
public class UserDataRequest {
    private boolean fetchLWAConsentStatus;

    public static class Builder {
        private boolean fetchLWAConsentStatus;

        public UserDataRequest build() {
            return new UserDataRequest(this);
        }

        public Builder setFetchLWAConsentStatus(boolean z7) {
            this.fetchLWAConsentStatus = z7;
            return this;
        }

        private Builder() {
        }
    }

    public UserDataRequest(Builder builder) {
        this.fetchLWAConsentStatus = builder.fetchLWAConsentStatus;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean getFetchLWAConsentStatus() {
        return this.fetchLWAConsentStatus;
    }
}
