package com.google.android.gms.internal.play_billing;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.o1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1378o1 implements Iterable, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC1378o1 f15475b = new C1368m1(P1.f15204b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15476a = 0;

    static {
        int i8 = AbstractC1318c1.f15401a;
    }

    public static int C(int i8, int i9, int i10) {
        int i11 = i9 - i8;
        if ((i8 | i9 | i11 | (i10 - i9)) >= 0) {
            return i11;
        }
        if (i8 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i8 + " < 0");
        }
        if (i9 < i8) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i8 + ", " + i9);
        }
        throw new IndexOutOfBoundsException("End index: " + i9 + " >= " + i10);
    }

    public static AbstractC1378o1 H(byte[] bArr, int i8, int i9) {
        C(i8, i8 + i9, bArr.length);
        byte[] bArr2 = new byte[i9];
        System.arraycopy(bArr, i8, bArr2, 0, i9);
        return new C1368m1(bArr2);
    }

    public final int F() {
        return this.f15476a;
    }

    public abstract byte a(int i8);

    public abstract byte d(int i8);

    public abstract int e();

    public abstract boolean equals(Object obj);

    public abstract int f(int i8, int i9, int i10);

    public abstract AbstractC1378o1 h(int i8, int i9);

    public final int hashCode() {
        int iF = this.f15476a;
        if (iF == 0) {
            int iE = e();
            iF = f(iE, 0, iE);
            if (iF == 0) {
                iF = 1;
            }
            this.f15476a = iF;
        }
        return iF;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new C1343h1(this);
    }

    public abstract void n(AbstractC1333f1 abstractC1333f1);

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(e()), e() <= 50 ? AbstractC1403t2.a(this) : AbstractC1403t2.a(h(0, 47)).concat("..."));
    }
}
