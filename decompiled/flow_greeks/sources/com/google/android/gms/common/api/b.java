package com.google.android.gms.common.api;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b extends Exception {

    @Deprecated
    protected final Status mStatus;

    public b(Status status) {
        int iS = status.S();
        String strT = status.T() != null ? status.T() : "";
        StringBuilder sb2 = new StringBuilder(String.valueOf(iS).length() + 2 + String.valueOf(strT).length());
        sb2.append(iS);
        sb2.append(": ");
        sb2.append(strT);
        super(sb2.toString());
        this.mStatus = status;
    }

    public Status getStatus() {
        return this.mStatus;
    }

    public int getStatusCode() {
        return this.mStatus.S();
    }

    @Deprecated
    public String getStatusMessage() {
        return this.mStatus.T();
    }
}
