package hh;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;
import kg.c0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f11485a = Logger.getLogger("okio.Okio");

    public static final boolean b(AssertionError assertionError) {
        kotlin.jvm.internal.t.f(assertionError, "<this>");
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? c0.P(message, "getsockname failed", false, 2, null) : false) {
                return true;
            }
        }
        return false;
    }

    public static final r c(Socket socket) throws IOException {
        kotlin.jvm.internal.t.f(socket, "<this>");
        s sVar = new s(socket);
        OutputStream outputStream = socket.getOutputStream();
        kotlin.jvm.internal.t.e(outputStream, "getOutputStream()");
        return sVar.v(new l(outputStream, sVar));
    }

    public static final t d(Socket socket) throws IOException {
        kotlin.jvm.internal.t.f(socket, "<this>");
        s sVar = new s(socket);
        InputStream inputStream = socket.getInputStream();
        kotlin.jvm.internal.t.e(inputStream, "getInputStream()");
        return sVar.w(new h(inputStream, sVar));
    }
}
