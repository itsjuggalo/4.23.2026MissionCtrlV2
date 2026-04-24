package com.revenuecat.purchases.google.usecase;

/* JADX INFO: loaded from: classes2.dex */
public final class GetBillingConfigUseCaseParams implements UseCaseParams {
    private final boolean appInBackground;

    public GetBillingConfigUseCaseParams(boolean z7) {
        this.appInBackground = z7;
    }

    public static /* synthetic */ GetBillingConfigUseCaseParams copy$default(GetBillingConfigUseCaseParams getBillingConfigUseCaseParams, boolean z7, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            z7 = getBillingConfigUseCaseParams.appInBackground;
        }
        return getBillingConfigUseCaseParams.copy(z7);
    }

    public final boolean component1() {
        return this.appInBackground;
    }

    public final GetBillingConfigUseCaseParams copy(boolean z7) {
        return new GetBillingConfigUseCaseParams(z7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetBillingConfigUseCaseParams) && this.appInBackground == ((GetBillingConfigUseCaseParams) obj).appInBackground;
    }

    @Override // com.revenuecat.purchases.google.usecase.UseCaseParams
    public boolean getAppInBackground() {
        return this.appInBackground;
    }

    public int hashCode() {
        boolean z7 = this.appInBackground;
        if (z7) {
            return 1;
        }
        return z7 ? 1 : 0;
    }

    public String toString() {
        return "GetBillingConfigUseCaseParams(appInBackground=" + this.appInBackground + ')';
    }
}
