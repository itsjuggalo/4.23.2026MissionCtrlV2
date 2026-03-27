package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0949u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f7615a = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f7616b = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f7617c = Charset.forName("ISO-8859-1");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f7618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ByteBuffer f7619e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AbstractC0936g f7620f;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.u$a */
    public interface a {
        boolean a(int i7);
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.u$b */
    public interface b extends List, RandomAccess {
        void d();

        b e(int i7);

        boolean f();
    }

    static {
        byte[] bArr = new byte[0];
        f7618d = bArr;
        f7619e = ByteBuffer.wrap(bArr);
        f7620f = AbstractC0936g.i(bArr);
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
        int iG = g(i8, bArr, i7, i8);
        if (iG == 0) {
            return 1;
        }
        return iG;
    }

    public static int f(long j7) {
        return (int) (j7 ^ (j7 >>> 32));
    }

    public static int g(int i7, byte[] bArr, int i8, int i9) {
        for (int i10 = i8; i10 < i8 + i9; i10++) {
            i7 = (i7 * 31) + bArr[i10];
        }
        return i7;
    }
}
