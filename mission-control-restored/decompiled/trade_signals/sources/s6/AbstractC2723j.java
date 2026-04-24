package s6;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: s6.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2723j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f23183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ByteBuffer f23184b;

    /* JADX INFO: renamed from: s6.j$a */
    public interface a {
        int d();
    }

    /* JADX INFO: renamed from: s6.j$b */
    public interface b {
        a a(int i8);
    }

    static {
        byte[] bArr = new byte[0];
        f23183a = bArr;
        f23184b = ByteBuffer.wrap(bArr);
    }

    public static boolean a(byte[] bArr) {
        return x.e(bArr);
    }

    public static String b(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e8) {
            throw new RuntimeException("UTF-8 not supported?", e8);
        }
    }
}
