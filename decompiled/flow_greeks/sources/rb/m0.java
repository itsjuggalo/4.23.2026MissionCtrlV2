package rb;

import java.nio.charset.Charset;
import rb.y0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f19649a = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r6.a f19650b = y0.f19748f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a extends y0.j {
    }

    public static int a(y0 y0Var) {
        return y0Var.h();
    }

    public static y0.g b(String str, a aVar) {
        boolean z10 = false;
        if (str != null && !str.isEmpty() && str.charAt(0) == ':') {
            z10 = true;
        }
        return y0.g.g(str, z10, aVar);
    }

    public static y0 c(byte[]... bArr) {
        return new y0(bArr);
    }

    public static byte[][] d(y0 y0Var) {
        return y0Var.q();
    }
}
