package com.google.android.gms.internal.play_billing;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class R3 extends N3 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ S3 f15349h;

    public R3(S3 s32) {
        Objects.requireNonNull(s32);
        this.f15349h = s32;
    }

    @Override // com.google.android.gms.internal.play_billing.N3
    public final String c() {
        O3 o32 = (O3) this.f15349h.f15363a.get();
        if (o32 == null) {
            return "Completer object has been garbage collected, future will fail soon";
        }
        return "tag=[" + String.valueOf(o32.f15196a) + "]";
    }
}
