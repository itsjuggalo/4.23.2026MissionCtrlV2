package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public abstract class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f5651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f5652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ByteBuffer f5653c;

    static {
        Charset.forName("US-ASCII");
        f5651a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f5652b = bArr;
        f5653c = ByteBuffer.wrap(bArr);
        AbstractC0480p.h(bArr, 0, 0, false);
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static int b(long j4) {
        return (int) (j4 ^ (j4 >>> 32));
    }
}
