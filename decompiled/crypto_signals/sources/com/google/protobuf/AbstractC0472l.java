package com.google.protobuf;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import s3.AbstractC1024h;

/* JADX INFO: renamed from: com.google.protobuf.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0472l implements Iterable, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0470k f5744b = new C0470k(M.f5652b);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0466i f5745c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5746a = 0;

    static {
        f5745c = AbstractC0454c.a() ? new C0466i(1) : new C0466i(0);
    }

    public static AbstractC0472l b(Iterator it, int i) {
        if (i < 1) {
            throw new IllegalArgumentException(a3.d.i("length (", i, ") must be >= 1"));
        }
        if (i == 1) {
            return (AbstractC0472l) it.next();
        }
        int i6 = i >>> 1;
        AbstractC0472l abstractC0472lB = b(it, i6);
        AbstractC0472l abstractC0472lB2 = b(it, i - i6);
        if (com.google.android.gms.common.api.f.API_PRIORITY_OTHER - abstractC0472lB.size() < abstractC0472lB2.size()) {
            throw new IllegalArgumentException("ByteString would be too long: " + abstractC0472lB.size() + "+" + abstractC0472lB2.size());
        }
        if (abstractC0472lB2.size() == 0) {
            return abstractC0472lB;
        }
        if (abstractC0472lB.size() == 0) {
            return abstractC0472lB2;
        }
        int size = abstractC0472lB2.size() + abstractC0472lB.size();
        if (size < 128) {
            int size2 = abstractC0472lB.size();
            int size3 = abstractC0472lB2.size();
            int i7 = size2 + size3;
            byte[] bArr = new byte[i7];
            h(0, size2, abstractC0472lB.size());
            h(0, size2, i7);
            if (size2 > 0) {
                abstractC0472lB.l(0, bArr, 0, size2);
            }
            h(0, size3, abstractC0472lB2.size());
            h(size2, i7, i7);
            if (size3 > 0) {
                abstractC0472lB2.l(0, bArr, size2, size3);
            }
            return new C0470k(bArr);
        }
        if (abstractC0472lB instanceof C0486s0) {
            C0486s0 c0486s0 = (C0486s0) abstractC0472lB;
            AbstractC0472l abstractC0472l = c0486s0.f5798f;
            int size4 = abstractC0472lB2.size() + abstractC0472l.size();
            AbstractC0472l abstractC0472l2 = c0486s0.e;
            if (size4 < 128) {
                int size5 = abstractC0472l.size();
                int size6 = abstractC0472lB2.size();
                int i8 = size5 + size6;
                byte[] bArr2 = new byte[i8];
                h(0, size5, abstractC0472l.size());
                h(0, size5, i8);
                if (size5 > 0) {
                    abstractC0472l.l(0, bArr2, 0, size5);
                }
                h(0, size6, abstractC0472lB2.size());
                h(size5, i8, i8);
                if (size6 > 0) {
                    abstractC0472lB2.l(0, bArr2, size5, size6);
                }
                return new C0486s0(abstractC0472l2, new C0470k(bArr2));
            }
            if (abstractC0472l2.m() > abstractC0472l.m()) {
                if (c0486s0.f5800l > abstractC0472lB2.m()) {
                    return new C0486s0(abstractC0472l2, new C0486s0(abstractC0472l, abstractC0472lB2));
                }
            }
        }
        if (size >= C0486s0.x(Math.max(abstractC0472lB.m(), abstractC0472lB2.m()) + 1)) {
            return new C0486s0(abstractC0472lB, abstractC0472lB2);
        }
        Z z6 = new Z(2);
        z6.a(abstractC0472lB);
        z6.a(abstractC0472lB2);
        ArrayDeque arrayDeque = (ArrayDeque) z6.f5702a;
        AbstractC0472l c0486s02 = (AbstractC0472l) arrayDeque.pop();
        while (!arrayDeque.isEmpty()) {
            c0486s02 = new C0486s0((AbstractC0472l) arrayDeque.pop(), c0486s02);
        }
        return c0486s02;
    }

    public static void f(int i, int i6) {
        if (((i6 - (i + 1)) | i) < 0) {
            if (i >= 0) {
                throw new ArrayIndexOutOfBoundsException(a3.d.h("Index > length: ", i, i6, ", "));
            }
            throw new ArrayIndexOutOfBoundsException(a3.d.f(i, "Index < 0: "));
        }
    }

    public static int h(int i, int i6, int i7) {
        int i8 = i6 - i;
        if ((i | i6 | i8 | (i7 - i6)) >= 0) {
            return i8;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(a3.d.i("Beginning index: ", i, " < 0"));
        }
        if (i6 < i) {
            throw new IndexOutOfBoundsException(a3.d.h("Beginning index larger than ending index: ", i, i6, ", "));
        }
        throw new IndexOutOfBoundsException(a3.d.h("End index: ", i6, i7, " >= "));
    }

    public static C0470k k(byte[] bArr, int i, int i6) {
        byte[] bArrCopyOfRange;
        h(i, i + i6, bArr.length);
        switch (f5745c.f5736a) {
            case 0:
                bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i6 + i);
                break;
            default:
                bArrCopyOfRange = new byte[i6];
                System.arraycopy(bArr, i, bArrCopyOfRange, 0, i6);
                break;
        }
        return new C0470k(bArrCopyOfRange);
    }

    public abstract ByteBuffer a();

    public abstract byte c(int i);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iR = this.f5746a;
        if (iR == 0) {
            int size = size();
            iR = r(size, 0, size);
            if (iR == 0) {
                iR = 1;
            }
            this.f5746a = iR;
        }
        return iR;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public abstract void l(int i, byte[] bArr, int i6, int i7);

    public abstract int m();

    public abstract byte n(int i);

    public abstract boolean o();

    public abstract boolean p();

    public abstract AbstractC0480p q();

    public abstract int r(int i, int i6, int i7);

    public abstract int s(int i, int i6, int i7);

    public abstract int size();

    public abstract AbstractC0472l t(int i, int i6);

    public final String toString() {
        String strQ;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        if (size() <= 50) {
            strQ = y0.q(this);
        } else {
            strQ = y0.q(t(0, 47)) + "...";
        }
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(size);
        sb.append(" contents=\"");
        return AbstractC1024h.d(sb, strQ, "\">");
    }

    public final byte[] u() {
        int size = size();
        if (size == 0) {
            return M.f5652b;
        }
        byte[] bArr = new byte[size];
        l(0, bArr, 0, size);
        return bArr;
    }

    public abstract String v(Charset charset);

    public abstract void w(AbstractC0485s abstractC0485s);
}
