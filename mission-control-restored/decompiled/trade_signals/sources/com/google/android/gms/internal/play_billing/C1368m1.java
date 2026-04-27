package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.m1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1368m1 extends AbstractC1363l1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f15456c;

    public C1368m1(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.f15456c = bArr;
    }

    public int I() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1378o1
    public byte a(int i8) {
        return this.f15456c[i8];
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1378o1
    public byte d(int i8) {
        return this.f15456c[i8];
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1378o1
    public int e() {
        return this.f15456c.length;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1378o1
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1378o1) || e() != ((AbstractC1378o1) obj).e()) {
            return false;
        }
        if (e() == 0) {
            return true;
        }
        if (!(obj instanceof C1368m1)) {
            return obj.equals(this);
        }
        C1368m1 c1368m1 = (C1368m1) obj;
        int iF = F();
        int iF2 = c1368m1.F();
        if (iF != 0 && iF2 != 0 && iF != iF2) {
            return false;
        }
        int iE = e();
        if (iE > c1368m1.e()) {
            throw new IllegalArgumentException("Length too large: " + iE + e());
        }
        if (iE > c1368m1.e()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + iE + ", " + c1368m1.e());
        }
        byte[] bArr = this.f15456c;
        byte[] bArr2 = c1368m1.f15456c;
        c1368m1.I();
        int i8 = 0;
        int i9 = 0;
        while (i8 < iE) {
            if (bArr[i8] != bArr2[i9]) {
                return false;
            }
            i8++;
            i9++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1378o1
    public final int f(int i8, int i9, int i10) {
        return P1.b(i8, this.f15456c, 0, i10);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1378o1
    public final AbstractC1378o1 h(int i8, int i9) {
        int iC = AbstractC1378o1.C(0, i9, e());
        return iC == 0 ? AbstractC1378o1.f15475b : new C1353j1(this.f15456c, 0, iC);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1378o1
    public final void n(AbstractC1333f1 abstractC1333f1) {
        ((C1397s1) abstractC1333f1).A(this.f15456c, 0, e());
    }
}
