package u5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/* JADX INFO: renamed from: u5.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1245b {
    public static final boolean a(byte[] a6, int i, byte[] b3, int i6, int i7) {
        kotlin.jvm.internal.j.e(a6, "a");
        kotlin.jvm.internal.j.e(b3, "b");
        for (int i8 = 0; i8 < i7; i8++) {
            if (a6[i8 + i] != b3[i8 + i6]) {
                return false;
            }
        }
        return true;
    }

    public static C1248e b() throws InterruptedException {
        C1248e c1248e = C1248e.f10521l;
        kotlin.jvm.internal.j.b(c1248e);
        C1248e c1248e2 = c1248e.f10522f;
        if (c1248e2 == null) {
            long jNanoTime = System.nanoTime();
            C1248e.i.await(C1248e.f10519j, TimeUnit.MILLISECONDS);
            C1248e c1248e3 = C1248e.f10521l;
            kotlin.jvm.internal.j.b(c1248e3);
            if (c1248e3.f10522f != null || System.nanoTime() - jNanoTime < C1248e.f10520k) {
                return null;
            }
            return C1248e.f10521l;
        }
        long jNanoTime2 = c1248e2.f10523g - System.nanoTime();
        if (jNanoTime2 > 0) {
            C1248e.i.await(jNanoTime2, TimeUnit.NANOSECONDS);
            return null;
        }
        C1248e c1248e4 = C1248e.f10521l;
        kotlin.jvm.internal.j.b(c1248e4);
        c1248e4.f10522f = c1248e2.f10522f;
        c1248e2.f10522f = null;
        return c1248e2;
    }

    public static final y c(E e) {
        kotlin.jvm.internal.j.e(e, "<this>");
        return new y(e);
    }

    public static final void d(long j4, long j6, long j7) {
        if ((j6 | j7) < 0 || j6 > j4 || j4 - j6 < j7) {
            throw new ArrayIndexOutOfBoundsException("size=" + j4 + " offset=" + j6 + " byteCount=" + j7);
        }
    }

    public static j e(String str) {
        kotlin.jvm.internal.j.e(str, "<this>");
        byte[] bytes = str.getBytes(Y4.a.f3689a);
        kotlin.jvm.internal.j.d(bytes, "this as java.lang.String).getBytes(charset)");
        j jVar = new j(bytes);
        jVar.f10530c = str;
        return jVar;
    }

    public static final boolean f(AssertionError assertionError) {
        Logger logger = u.f10548a;
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? Y4.d.U(message, "getsockname failed") : false) {
                return true;
            }
        }
        return false;
    }

    public static final C1246c g(Socket socket) throws IOException {
        Logger logger = u.f10548a;
        kotlin.jvm.internal.j.e(socket, "<this>");
        D d4 = new D(socket);
        OutputStream outputStream = socket.getOutputStream();
        kotlin.jvm.internal.j.d(outputStream, "getOutputStream()");
        return new C1246c(0, d4, new C1246c(1, outputStream, d4));
    }

    public static final C1247d h(Socket socket) throws IOException {
        Logger logger = u.f10548a;
        kotlin.jvm.internal.j.e(socket, "<this>");
        D d4 = new D(socket);
        InputStream inputStream = socket.getInputStream();
        kotlin.jvm.internal.j.d(inputStream, "getInputStream()");
        return new C1247d(0, d4, new C1247d(1, inputStream, d4));
    }
}
