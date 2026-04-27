package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public abstract class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f12545a = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f12546b = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f12547c = Charset.forName("ISO-8859-1");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f12548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ByteBuffer f12549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AbstractC1241j f12550f;

    public interface a {
        int d();
    }

    public interface b {
    }

    public interface c {
        boolean a(int i7);
    }

    public interface d extends e {
    }

    public interface e extends List, RandomAccess {
        void d();

        e e(int i7);

        boolean f();
    }

    static {
        byte[] bArr = new byte[0];
        f12548d = bArr;
        f12549e = ByteBuffer.wrap(bArr);
        f12550f = AbstractC1241j.k(bArr);
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

    public static int e(byte[] bArr, int i7, int i8) {
        int iH = h(i8, bArr, i7, i8);
        if (iH == 0) {
            return 1;
        }
        return iH;
    }

    public static int f(long j7) {
        return (int) (j7 ^ (j7 >>> 32));
    }

    public static boolean g(byte[] bArr) {
        return A0.s(bArr);
    }

    public static int h(int i7, byte[] bArr, int i8, int i9) {
        for (int i10 = i8; i10 < i8 + i9; i10++) {
            i7 = (i7 * 31) + bArr[i10];
        }
        return i7;
    }

    public static String i(byte[] bArr) {
        return new String(bArr, f12546b);
    }
}
