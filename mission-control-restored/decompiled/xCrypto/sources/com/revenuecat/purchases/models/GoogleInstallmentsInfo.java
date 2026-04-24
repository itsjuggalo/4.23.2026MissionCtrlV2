package com.revenuecat.purchases.models;

/* JADX INFO: loaded from: classes3.dex */
public final class GoogleInstallmentsInfo implements InstallmentsInfo {
    private final int commitmentPaymentsCount;
    private final int renewalCommitmentPaymentsCount;

    public GoogleInstallmentsInfo(int i4, int i5) {
        this.commitmentPaymentsCount = i4;
        this.renewalCommitmentPaymentsCount = i5;
    }

    public static /* synthetic */ GoogleInstallmentsInfo copy$default(GoogleInstallmentsInfo googleInstallmentsInfo, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = googleInstallmentsInfo.commitmentPaymentsCount;
        }
        if ((i6 & 2) != 0) {
            i5 = googleInstallmentsInfo.renewalCommitmentPaymentsCount;
        }
        return googleInstallmentsInfo.copy(i4, i5);
    }

    public final int component1() {
        return this.commitmentPaymentsCount;
    }

    public final int component2() {
        return this.renewalCommitmentPaymentsCount;
    }

    public final GoogleInstallmentsInfo copy(int i4, int i5) {
        return new GoogleInstallmentsInfo(i4, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoogleInstallmentsInfo)) {
            return false;
        }
        GoogleInstallmentsInfo googleInstallmentsInfo = (GoogleInstallmentsInfo) obj;
        return this.commitmentPaymentsCount == googleInstallmentsInfo.commitmentPaymentsCount && this.renewalCommitmentPaymentsCount == googleInstallmentsInfo.renewalCommitmentPaymentsCount;
    }

    @Override // com.revenuecat.purchases.models.InstallmentsInfo
    public int getCommitmentPaymentsCount() {
        return this.commitmentPaymentsCount;
    }

    @Override // com.revenuecat.purchases.models.InstallmentsInfo
    public int getRenewalCommitmentPaymentsCount() {
        return this.renewalCommitmentPaymentsCount;
    }

    public int hashCode() {
        return (Integer.hashCode(this.commitmentPaymentsCount) * 31) + Integer.hashCode(this.renewalCommitmentPaymentsCount);
    }

    public String toString() {
        return "GoogleInstallmentsInfo(commitmentPaymentsCount=" + this.commitmentPaymentsCount + ", renewalCommitmentPaymentsCount=" + this.renewalCommitmentPaymentsCount + ')';
    }
}
