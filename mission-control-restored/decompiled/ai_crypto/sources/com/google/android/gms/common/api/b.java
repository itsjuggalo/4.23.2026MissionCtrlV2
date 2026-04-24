package com.google.android.gms.common.api;

/* JADX INFO: loaded from: classes.dex */
public class b extends Exception {

    @Deprecated
    protected final Status mStatus;

    public b(Status status) {
        super(status.B() + ": " + (status.C() != null ? status.C() : ""));
        this.mStatus = status;
    }

    public Status getStatus() {
        return this.mStatus;
    }

    public int getStatusCode() {
        return this.mStatus.B();
    }

    @Deprecated
    public String getStatusMessage() {
        return this.mStatus.C();
    }
}
