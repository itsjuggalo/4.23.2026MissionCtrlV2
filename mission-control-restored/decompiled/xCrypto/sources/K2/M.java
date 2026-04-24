package K2;

import K2.Z;
import b2.AbstractC0862a;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public abstract class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f1054a = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC0862a f1055b = Z.f1098f;

    public interface a extends Z.j {
    }

    public static int a(Z z4) {
        return z4.h();
    }

    public static Z.g b(String str, a aVar) {
        boolean z4 = false;
        if (str != null && !str.isEmpty() && str.charAt(0) == ':') {
            z4 = true;
        }
        return Z.g.g(str, z4, aVar);
    }

    public static Z c(byte[]... bArr) {
        return new Z(bArr);
    }

    public static byte[][] d(Z z4) {
        return z4.q();
    }
}
