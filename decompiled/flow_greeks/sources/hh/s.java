package hh;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class s extends c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Socket f11509o;

    public s(Socket socket) {
        kotlin.jvm.internal.t.f(socket, "socket");
        this.f11509o = socket;
    }

    @Override // hh.c
    public IOException t(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // hh.c
    public void x() {
        try {
            this.f11509o.close();
        } catch (AssertionError e10) {
            if (!i.c(e10)) {
                throw e10;
            }
            j.f11485a.log(Level.WARNING, "Failed to close timed out socket " + this.f11509o, (Throwable) e10);
        } catch (Exception e11) {
            j.f11485a.log(Level.WARNING, "Failed to close timed out socket " + this.f11509o, (Throwable) e11);
        }
    }
}
