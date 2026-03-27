package u7;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f23580a = Logger.getLogger("okio.Okio");

    public static final boolean b(AssertionError assertionError) {
        AbstractC2304t.f(assertionError, "<this>");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? V6.C.L(message, "getsockname failed", false, 2, null) : false;
    }

    public static final T c(Socket socket) throws IOException {
        AbstractC2304t.f(socket, "<this>");
        U u8 = new U(socket);
        OutputStream outputStream = socket.getOutputStream();
        AbstractC2304t.e(outputStream, "getOutputStream()");
        return u8.v(new K(outputStream, u8));
    }

    public static final V d(File file) {
        AbstractC2304t.f(file, "<this>");
        return new C2820m(new FileInputStream(file), W.f23611e);
    }

    public static final V e(Socket socket) throws IOException {
        AbstractC2304t.f(socket, "<this>");
        U u8 = new U(socket);
        InputStream inputStream = socket.getInputStream();
        AbstractC2304t.e(inputStream, "getInputStream()");
        return u8.w(new C2820m(inputStream, u8));
    }
}
