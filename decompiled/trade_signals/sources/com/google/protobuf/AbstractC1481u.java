package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.google.protobuf.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1481u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f16587a = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f16588b = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f16589c = Charset.forName("ISO-8859-1");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f16590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ByteBuffer f16591e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AbstractC1468g f16592f;

    /* JADX INFO: renamed from: com.google.protobuf.u$a */
    public interface a {
        int d();
    }

    /* JADX INFO: renamed from: com.google.protobuf.u$b */
    public interface b {
    }

    /* JADX INFO: renamed from: com.google.protobuf.u$c */
    public interface c {
        boolean a(int i8);
    }

    /* JADX INFO: renamed from: com.google.protobuf.u$d */
    public interface d extends List, RandomAccess {
        void g();

        d i(int i8);

        boolean m();
    }

    static {
        byte[] bArr = new byte[0];
        f16590d = bArr;
        f16591e = ByteBuffer.wrap(bArr);
        f16592f = AbstractC1468g.i(bArr);
    }

    public static Object a(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object b(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static int c(boolean z7) {
        return z7 ? 1231 : 1237;
    }

    public static int d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    public static int e(byte[] bArr, int i8, int i9) {
        int iH = h(i9, bArr, i8, i9);
        if (iH == 0) {
            return 1;
        }
        return iH;
    }

    public static int f(long j8) {
        return (int) (j8 ^ (j8 >>> 32));
    }

    public static boolean g(byte[] bArr) {
        return k0.m(bArr);
    }

    public static int h(int i8, byte[] bArr, int i9, int i10) {
        for (int i11 = i9; i11 < i9 + i10; i11++) {
            i8 = (i8 * 31) + bArr[i11];
        }
        return i8;
    }

    public static String i(byte[] bArr) {
        return new String(bArr, f16588b);
    }
}
