package O3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;
import r3.AbstractC1753A;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f3337a = Logger.getLogger("okio.Okio");

    public static final boolean b(AssertionError assertionError) {
        kotlin.jvm.internal.r.f(assertionError, "<this>");
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? AbstractC1753A.I(message, "getsockname failed", false, 2, null) : false) {
                return true;
            }
        }
        return false;
    }

    public static final r c(Socket socket) throws IOException {
        kotlin.jvm.internal.r.f(socket, "<this>");
        s sVar = new s(socket);
        OutputStream outputStream = socket.getOutputStream();
        kotlin.jvm.internal.r.e(outputStream, "getOutputStream()");
        return sVar.v(new l(outputStream, sVar));
    }

    public static final t d(Socket socket) throws IOException {
        kotlin.jvm.internal.r.f(socket, "<this>");
        s sVar = new s(socket);
        InputStream inputStream = socket.getInputStream();
        kotlin.jvm.internal.r.e(inputStream, "getInputStream()");
        return sVar.w(new h(inputStream, sVar));
    }
}
