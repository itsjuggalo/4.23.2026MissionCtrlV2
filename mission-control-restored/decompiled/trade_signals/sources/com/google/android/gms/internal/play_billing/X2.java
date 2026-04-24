package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class X2 implements M1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final M1 f15374a = new X2();

    @Override // com.google.android.gms.internal.play_billing.M1
    public final boolean zza(int i8) {
        return (i8 != 0 ? i8 != 1 ? i8 != 2 ? i8 != 3 ? null : Y2.ALTERNATIVE_BILLING_ACTION : Y2.LOCAL_PURCHASES_UPDATED_ACTION : Y2.PURCHASES_UPDATED_ACTION : Y2.BROADCAST_ACTION_UNSPECIFIED) != null;
    }
}
