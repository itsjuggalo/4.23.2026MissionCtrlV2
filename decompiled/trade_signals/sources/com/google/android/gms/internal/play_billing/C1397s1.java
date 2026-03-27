package com.google.android.gms.internal.play_billing;

import java.util.Locale;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.s1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1397s1 extends AbstractC1412v1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f15498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f15499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f15500f;

    public C1397s1(byte[] bArr, int i8, int i9) {
        super(null);
        int length = bArr.length;
        if (((length - i9) | i9) < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i9)));
        }
        this.f15498d = bArr;
        this.f15500f = 0;
        this.f15499e = i9;
    }

    public final void A(byte[] bArr, int i8, int i9) {
        try {
            System.arraycopy(bArr, 0, this.f15498d, this.f15500f, i9);
            this.f15500f += i9;
        } catch (IndexOutOfBoundsException e8) {
            throw new C1402t1(this.f15500f, this.f15499e, i9, e8);
        }
    }

    public final void B(AbstractC1378o1 abstractC1378o1) throws C1402t1 {
        w(abstractC1378o1.e());
        abstractC1378o1.n(this);
    }

    public final void C(String str) throws C1402t1 {
        int i8 = this.f15500f;
        try {
            int iC = AbstractC1412v1.c(str.length() * 3);
            int iC2 = AbstractC1412v1.c(str.length());
            if (iC2 != iC) {
                w(F2.c(str));
                byte[] bArr = this.f15498d;
                int i9 = this.f15500f;
                this.f15500f = F2.b(str, bArr, i9, this.f15499e - i9);
                return;
            }
            int i10 = i8 + iC2;
            this.f15500f = i10;
            int iB = F2.b(str, this.f15498d, i10, this.f15499e - i10);
            this.f15500f = i8;
            w((iB - i8) - iC2);
            this.f15500f = iB;
        } catch (E2 e8) {
            this.f15500f = i8;
            f(str, e8);
        } catch (IndexOutOfBoundsException e9) {
            throw new C1402t1(e9);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1412v1
    public final int h() {
        return this.f15499e - this.f15500f;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1412v1
    public final void i(byte b8) throws C1402t1 {
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i8 = this.f15500f;
        try {
            int i9 = i8 + 1;
            try {
                this.f15498d[i8] = b8;
                this.f15500f = i9;
            } catch (IndexOutOfBoundsException e8) {
                indexOutOfBoundsException = e8;
                i8 = i9;
                throw new C1402t1(i8, this.f15499e, 1, indexOutOfBoundsException);
            }
        } catch (IndexOutOfBoundsException e9) {
            indexOutOfBoundsException = e9;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1412v1
    public final void j(int i8, boolean z7) throws C1402t1 {
        w(i8 << 3);
        i(z7 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1412v1
    public final void k(int i8, AbstractC1378o1 abstractC1378o1) throws C1402t1 {
        w((i8 << 3) | 2);
        B(abstractC1378o1);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1412v1
    public final void l(int i8, int i9) throws C1402t1 {
        w((i8 << 3) | 5);
        m(i9);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1412v1
    public final void m(int i8) throws C1402t1 {
        int i9 = this.f15500f;
        try {
            byte[] bArr = this.f15498d;
            bArr[i9] = (byte) i8;
            bArr[i9 + 1] = (byte) (i8 >> 8);
            bArr[i9 + 2] = (byte) (i8 >> 16);
            bArr[i9 + 3] = (byte) (i8 >> 24);
            this.f15500f = i9 + 4;
        } catch (IndexOutOfBoundsException e8) {
            throw new C1402t1(i9, this.f15499e, 4, e8);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1412v1
    public final void n(int i8, long j8) throws C1402t1 {
        w((i8 << 3) | 1);
        o(j8);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1412v1
    public final void o(long j8) throws C1402t1 {
        int i8 = this.f15500f;
        try {
            byte[] bArr = this.f15498d;
            bArr[i8] = (byte) j8;
            bArr[i8 + 1] = (byte) (j8 >> 8);
            bArr[i8 + 2] = (byte) (j8 >> 16);
            bArr[i8 + 3] = (byte) (j8 >> 24);
            bArr[i8 + 4] = (byte) (j8 >> 32);
            bArr[i8 + 5] = (byte) (j8 >> 40);
            bArr[i8 + 6] = (byte) (j8 >> 48);
            bArr[i8 + 7] = (byte) (j8 >> 56);
            this.f15500f = i8 + 8;
        } catch (IndexOutOfBoundsException e8) {
            throw new C1402t1(i8, this.f15499e, 8, e8);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1412v1
    public final void p(int i8, int i9) throws C1402t1 {
        w(i8 << 3);
        q(i9);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1412v1
    public final void q(int i8) throws C1402t1 {
        if (i8 >= 0) {
            w(i8);
        } else {
            y(i8);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1412v1
    public final void r(byte[] bArr, int i8, int i9) {
        A(bArr, 0, i9);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1412v1
    public final void s(int i8, InterfaceC1334f2 interfaceC1334f2, InterfaceC1384p2 interfaceC1384p2) throws C1402t1 {
        w((i8 << 3) | 2);
        w(((AbstractC1308a1) interfaceC1334f2).c(interfaceC1384p2));
        interfaceC1384p2.b(interfaceC1334f2, this.f15527a);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1412v1
    public final void t(int i8, String str) throws C1402t1 {
        w((i8 << 3) | 2);
        C(str);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1412v1
    public final void u(int i8, int i9) throws C1402t1 {
        w((i8 << 3) | i9);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1412v1
    public final void v(int i8, int i9) throws C1402t1 {
        w(i8 << 3);
        w(i9);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1412v1
    public final void w(int i8) throws C1402t1 {
        int i9;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i10 = this.f15500f;
        while ((i8 & (-128)) != 0) {
            try {
                i9 = i10 + 1;
                try {
                    this.f15498d[i10] = (byte) (i8 | 128);
                    i8 >>>= 7;
                    i10 = i9;
                } catch (IndexOutOfBoundsException e8) {
                    indexOutOfBoundsException = e8;
                    i10 = i9;
                    throw new C1402t1(i10, this.f15499e, 1, indexOutOfBoundsException);
                }
            } catch (IndexOutOfBoundsException e9) {
                indexOutOfBoundsException = e9;
                throw new C1402t1(i10, this.f15499e, 1, indexOutOfBoundsException);
            }
        }
        i9 = i10 + 1;
        this.f15498d[i10] = (byte) i8;
        this.f15500f = i9;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1412v1
    public final void x(int i8, long j8) throws C1402t1 {
        w(i8 << 3);
        y(j8);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1412v1
    public final void y(long j8) throws C1402t1 {
        int i8;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i9;
        int i10 = this.f15500f;
        if (!AbstractC1412v1.f15526c || this.f15499e - i10 < 10) {
            while ((j8 & (-128)) != 0) {
                try {
                    i9 = i10 + 1;
                } catch (IndexOutOfBoundsException e8) {
                    e = e8;
                }
                try {
                    this.f15498d[i10] = (byte) (((int) j8) | 128);
                    j8 >>>= 7;
                    i10 = i9;
                } catch (IndexOutOfBoundsException e9) {
                    e = e9;
                    i10 = i9;
                    indexOutOfBoundsException = e;
                    throw new C1402t1(i10, this.f15499e, 1, indexOutOfBoundsException);
                }
            }
            i8 = i10 + 1;
            try {
                this.f15498d[i10] = (byte) j8;
            } catch (IndexOutOfBoundsException e10) {
                indexOutOfBoundsException = e10;
                i10 = i8;
                throw new C1402t1(i10, this.f15499e, 1, indexOutOfBoundsException);
            }
        } else {
            while ((j8 & (-128)) != 0) {
                C2.s(this.f15498d, i10, (byte) (((int) j8) | 128));
                j8 >>>= 7;
                i10++;
            }
            i8 = i10 + 1;
            C2.s(this.f15498d, i10, (byte) j8);
        }
        this.f15500f = i8;
    }
}
