package com.google.android.gms.internal.play_billing;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzay extends zzbl {
    @Override // com.google.android.gms.internal.play_billing.zzbl
    public final long zza() {
        return SystemClock.elapsedRealtime() * 1000000;
    }
}
