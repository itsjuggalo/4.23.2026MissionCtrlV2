package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public abstract class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f10881a = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f10882b = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f10883c = Charset.forName("ISO-8859-1");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f10884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ByteBuffer f10885e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AbstractC1063j f10886f;

    public interface a extends i {
        @Override // com.google.protobuf.C.i, com.google.protobuf.C.g
        a a(int i4);
    }

    public interface b extends i {
        @Override // com.google.protobuf.C.i, com.google.protobuf.C.g
        b a(int i4);
    }

    public interface c {
        int getNumber();
    }

    public interface d {
        c a(int i4);
    }

    public interface e {
        boolean a(int i4);
    }

    public interface f extends i {
        @Override // com.google.protobuf.C.i, com.google.protobuf.C.g
        f a(int i4);
    }

    public interface g extends i {
        g a(int i4);
    }

    public interface h extends i {
        @Override // com.google.protobuf.C.i, com.google.protobuf.C.g
        h a(int i4);
    }

    public interface i extends List, RandomAccess {
        i a(int i4);

        void d();

        boolean e();
    }

    static {
        byte[] bArr = new byte[0];
        f10884d = bArr;
        f10885e = ByteBuffer.wrap(bArr);
        f10886f = AbstractC1063j.l(bArr);
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

    public static int c(boolean z4) {
        return z4 ? 1231 : 1237;
    }

    public static int d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    public static int e(byte[] bArr, int i4, int i5) {
        int i6 = i(i5, bArr, i4, i5);
        if (i6 == 0) {
            return 1;
        }
        return i6;
    }

    public static int f(long j4) {
        return (int) (j4 ^ (j4 >>> 32));
    }

    public static boolean g(byte[] bArr) {
        return B0.s(bArr);
    }

    public static Object h(Object obj, Object obj2) {
        return ((W) obj).toBuilder().mergeFrom((W) obj2).buildPartial();
    }

    public static int i(int i4, byte[] bArr, int i5, int i6) {
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            i4 = (i4 * 31) + bArr[i7];
        }
        return i4;
    }

    public static String j(byte[] bArr) {
        return new String(bArr, f10882b);
    }
}
