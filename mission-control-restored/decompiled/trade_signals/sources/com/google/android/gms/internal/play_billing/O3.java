package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class O3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f15196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public S3 f15197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public U3 f15198c = U3.j();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f15199d;

    public final void a() {
        this.f15196a = null;
        this.f15197b = null;
        this.f15198c.e(null);
    }

    public final boolean b(Object obj) {
        this.f15199d = true;
        S3 s32 = this.f15197b;
        boolean z7 = s32 != null && s32.c(obj);
        if (z7) {
            this.f15196a = null;
            this.f15197b = null;
            this.f15198c = null;
        }
        return z7;
    }

    public final void finalize() {
        U3 u32;
        S3 s32 = this.f15197b;
        if (s32 != null && !s32.isDone()) {
            s32.d(new P3("The completer object was garbage collected - this future would otherwise never complete. The tag was: ".concat(String.valueOf(this.f15196a))));
        }
        if (this.f15199d || (u32 = this.f15198c) == null) {
            return;
        }
        u32.e(null);
    }
}
