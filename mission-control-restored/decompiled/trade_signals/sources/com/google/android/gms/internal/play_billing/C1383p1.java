package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.p1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1383p1 extends AbstractC1392r1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15486d;

    public /* synthetic */ C1383p1(byte[] bArr, int i8, int i9, boolean z7, AbstractC1388q1 abstractC1388q1) {
        super(null);
        this.f15486d = Integer.MAX_VALUE;
        this.f15484b = 0;
    }

    public final int c(int i8) {
        int i9 = this.f15486d;
        this.f15486d = 0;
        int i10 = this.f15484b + this.f15485c;
        this.f15484b = i10;
        if (i10 > 0) {
            this.f15485c = i10;
            this.f15484b = 0;
        } else {
            this.f15485c = 0;
        }
        return i9;
    }
}
