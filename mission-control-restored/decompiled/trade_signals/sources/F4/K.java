package F4;

import F4.X;
import java.nio.charset.Charset;
import x2.AbstractC2954a;

/* JADX INFO: loaded from: classes.dex */
public abstract class K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f1643a = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC2954a f1644b = X.f1687f;

    public interface a extends X.j {
    }

    public static int a(X x8) {
        return x8.h();
    }

    public static X.g b(String str, a aVar) {
        boolean z7 = false;
        if (str != null && !str.isEmpty() && str.charAt(0) == ':') {
            z7 = true;
        }
        return X.g.g(str, z7, aVar);
    }

    public static X c(byte[]... bArr) {
        return new X(bArr);
    }

    public static byte[][] d(X x8) {
        return x8.p();
    }
}
