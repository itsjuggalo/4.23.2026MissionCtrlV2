package w6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f25037a = Logger.getLogger("okio.Okio");

    public static final X b(File file) {
        kotlin.jvm.internal.r.f(file, "<this>");
        return L.h(new FileOutputStream(file, true));
    }

    public static final boolean c(AssertionError assertionError) {
        kotlin.jvm.internal.r.f(assertionError, "<this>");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? Z5.u.D(message, "getsockname failed", false, 2, null) : false;
    }

    public static final X d(File file) {
        kotlin.jvm.internal.r.f(file, "<this>");
        return h(file, false, 1, null);
    }

    public static final X e(File file, boolean z7) {
        kotlin.jvm.internal.r.f(file, "<this>");
        return L.h(new FileOutputStream(file, z7));
    }

    public static final X f(OutputStream outputStream) {
        kotlin.jvm.internal.r.f(outputStream, "<this>");
        return new O(outputStream, new a0());
    }

    public static final X g(Socket socket) throws IOException {
        kotlin.jvm.internal.r.f(socket, "<this>");
        Y y7 = new Y(socket);
        OutputStream outputStream = socket.getOutputStream();
        kotlin.jvm.internal.r.e(outputStream, "getOutputStream()");
        return y7.A(new O(outputStream, y7));
    }

    public static /* synthetic */ X h(File file, boolean z7, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            z7 = false;
        }
        return L.g(file, z7);
    }

    public static final Z i(File file) {
        kotlin.jvm.internal.r.f(file, "<this>");
        return new C2804q(new FileInputStream(file), a0.f25070e);
    }

    public static final Z j(InputStream inputStream) {
        kotlin.jvm.internal.r.f(inputStream, "<this>");
        return new C2804q(inputStream, new a0());
    }

    public static final Z k(Socket socket) throws IOException {
        kotlin.jvm.internal.r.f(socket, "<this>");
        Y y7 = new Y(socket);
        InputStream inputStream = socket.getInputStream();
        kotlin.jvm.internal.r.e(inputStream, "getInputStream()");
        return y7.B(new C2804q(inputStream, y7));
    }
}
