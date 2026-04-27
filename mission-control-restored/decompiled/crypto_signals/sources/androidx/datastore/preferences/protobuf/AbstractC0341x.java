package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0341x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f4616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f4617b;

    static {
        Charset.forName("US-ASCII");
        f4616a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f4617b = bArr;
        ByteBuffer.wrap(bArr);
        try {
            new C0326h(bArr, 0, 0, false).e(0);
        } catch (C0343z e) {
            throw new IllegalArgumentException(e);
        }
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
