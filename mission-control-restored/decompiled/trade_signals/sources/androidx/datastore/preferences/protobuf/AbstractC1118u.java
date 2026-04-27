package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1118u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f11427a = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f11428b = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f11429c = Charset.forName("ISO-8859-1");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f11430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ByteBuffer f11431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AbstractC1105g f11432f;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.u$a */
    public interface a {
        boolean a(int i8);
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.u$b */
    public interface b extends List, RandomAccess {
        void g();

        b i(int i8);

        boolean m();
    }

    static {
        byte[] bArr = new byte[0];
        f11430d = bArr;
        f11431e = ByteBuffer.wrap(bArr);
        f11432f = AbstractC1105g.i(bArr);
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
        int iG = g(i9, bArr, i8, i9);
        if (iG == 0) {
            return 1;
        }
        return iG;
    }

    public static int f(long j8) {
        return (int) (j8 ^ (j8 >>> 32));
    }

    public static int g(int i8, byte[] bArr, int i9, int i10) {
        for (int i11 = i9; i11 < i9 + i10; i11++) {
            i8 = (i8 * 31) + bArr[i11];
        }
        return i8;
    }
}
