package z4;

import java.io.IOException;
import java.util.Locale;
import java.util.logging.Logger;
import u5.AbstractC1245b;
import u5.y;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f11814a = Logger.getLogger(f.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u5.j f11815b;

    static {
        u5.j jVar = u5.j.f10527d;
        f11815b = AbstractC1245b.e("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    }

    public static int a(y yVar) {
        return (yVar.d() & 255) | ((yVar.d() & 255) << 16) | ((yVar.d() & 255) << 8);
    }

    public static int b(int i, byte b3, short s6) throws IOException {
        if ((b3 & 8) != 0) {
            i--;
        }
        if (s6 <= i) {
            return (short) (i - s6);
        }
        c("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s6), Integer.valueOf(i));
        throw null;
    }

    public static void c(String str, Object... objArr) throws IOException {
        throw new IOException(String.format(Locale.US, str, objArr));
    }
}
