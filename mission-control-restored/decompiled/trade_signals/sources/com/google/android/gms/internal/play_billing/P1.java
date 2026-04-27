package com.google.android.gms.internal.play_billing;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public abstract class P1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f15203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f15204b;

    static {
        Charset.forName("US-ASCII");
        f15203a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f15204b = bArr;
        ByteBuffer.wrap(bArr);
        int i8 = AbstractC1392r1.f15495a;
        try {
            new C1383p1(bArr, 0, 0, false, null).c(0);
        } catch (R1 e8) {
            throw new IllegalArgumentException(e8);
        }
    }

    public static int a(boolean z7) {
        return z7 ? 1231 : 1237;
    }

    public static int b(int i8, byte[] bArr, int i9, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            i8 = (i8 * 31) + bArr[i11];
        }
        return i8;
    }

    public static Object c(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("messageType");
    }
}
