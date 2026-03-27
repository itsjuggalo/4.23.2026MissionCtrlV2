package com.revenuecat.purchases.models;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: GoogleInstallmentsInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/revenuecat/purchases/models/GoogleInstallmentsInfo;", "Lcom/revenuecat/purchases/models/InstallmentsInfo;", "commitmentPaymentsCount", "", "renewalCommitmentPaymentsCount", "(II)V", "getCommitmentPaymentsCount", "()I", "getRenewalCommitmentPaymentsCount", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class GoogleInstallmentsInfo implements InstallmentsInfo {
    private final int commitmentPaymentsCount;
    private final int renewalCommitmentPaymentsCount;

    public static /* synthetic */ GoogleInstallmentsInfo copy$default(GoogleInstallmentsInfo googleInstallmentsInfo, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = googleInstallmentsInfo.commitmentPaymentsCount;
        }
        if ((i3 & 2) != 0) {
            i2 = googleInstallmentsInfo.renewalCommitmentPaymentsCount;
        }
        return googleInstallmentsInfo.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCommitmentPaymentsCount() {
        return this.commitmentPaymentsCount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getRenewalCommitmentPaymentsCount() {
        return this.renewalCommitmentPaymentsCount;
    }

    public final GoogleInstallmentsInfo copy(int commitmentPaymentsCount, int renewalCommitmentPaymentsCount) {
        return new GoogleInstallmentsInfo(commitmentPaymentsCount, renewalCommitmentPaymentsCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoogleInstallmentsInfo)) {
            return false;
        }
        GoogleInstallmentsInfo googleInstallmentsInfo = (GoogleInstallmentsInfo) other;
        return this.commitmentPaymentsCount == googleInstallmentsInfo.commitmentPaymentsCount && this.renewalCommitmentPaymentsCount == googleInstallmentsInfo.renewalCommitmentPaymentsCount;
    }

    public int hashCode() {
        return (Integer.hashCode(this.commitmentPaymentsCount) * 31) + Integer.hashCode(this.renewalCommitmentPaymentsCount);
    }

    public String toString() {
        return "GoogleInstallmentsInfo(commitmentPaymentsCount=" + this.commitmentPaymentsCount + ", renewalCommitmentPaymentsCount=" + this.renewalCommitmentPaymentsCount + ')';
    }

    public GoogleInstallmentsInfo(int i, int i2) {
        this.commitmentPaymentsCount = i;
        this.renewalCommitmentPaymentsCount = i2;
    }

    @Override // com.revenuecat.purchases.models.InstallmentsInfo
    public int getCommitmentPaymentsCount() {
        return this.commitmentPaymentsCount;
    }

    @Override // com.revenuecat.purchases.models.InstallmentsInfo
    public int getRenewalCommitmentPaymentsCount() {
        return this.renewalCommitmentPaymentsCount;
    }
}
