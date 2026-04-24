package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.j1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1353j1 extends C1368m1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f15443d;

    public C1353j1(byte[] bArr, int i8, int i9) {
        super(bArr);
        AbstractC1378o1.C(0, i9, bArr.length);
        this.f15443d = i9;
    }

    @Override // com.google.android.gms.internal.play_billing.C1368m1
    public final int I() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.C1368m1, com.google.android.gms.internal.play_billing.AbstractC1378o1
    public final byte a(int i8) {
        int i9 = this.f15443d;
        if (((i9 - (i8 + 1)) | i8) >= 0) {
            return this.f15456c[i8];
        }
        if (i8 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i8);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i8 + ", " + i9);
    }

    @Override // com.google.android.gms.internal.play_billing.C1368m1, com.google.android.gms.internal.play_billing.AbstractC1378o1
    public final byte d(int i8) {
        return this.f15456c[i8];
    }

    @Override // com.google.android.gms.internal.play_billing.C1368m1, com.google.android.gms.internal.play_billing.AbstractC1378o1
    public final int e() {
        return this.f15443d;
    }
}
