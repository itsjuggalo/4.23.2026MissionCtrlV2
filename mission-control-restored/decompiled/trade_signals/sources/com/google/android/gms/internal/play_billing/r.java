package com.google.android.gms.internal.play_billing;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class r extends F {
    @Override // com.google.android.gms.internal.play_billing.F
    public final long a() {
        return SystemClock.elapsedRealtime() * 1000000;
    }
}
