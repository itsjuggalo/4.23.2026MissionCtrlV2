package r5;

import java.nio.charset.Charset;
import r5.Z;

/* JADX INFO: loaded from: classes2.dex */
public abstract class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f22544a = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final J2.a f22545b = Z.f22588f;

    public interface a extends Z.j {
    }

    public static int a(Z z7) {
        return z7.h();
    }

    public static Z.g b(String str, a aVar) {
        boolean z7 = false;
        if (str != null && !str.isEmpty() && str.charAt(0) == ':') {
            z7 = true;
        }
        return Z.g.g(str, z7, aVar);
    }

    public static Z c(byte[]... bArr) {
        return new Z(bArr);
    }

    public static byte[][] d(Z z7) {
        return z7.q();
    }
}
