package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public enum Y2 implements L1 {
    BROADCAST_ACTION_UNSPECIFIED(0),
    PURCHASES_UPDATED_ACTION(1),
    LOCAL_PURCHASES_UPDATED_ACTION(2),
    ALTERNATIVE_BILLING_ACTION(3);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15385a;

    Y2(int i8) {
        this.f15385a = i8;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.f15385a);
    }

    public final int zza() {
        return this.f15385a;
    }
}
