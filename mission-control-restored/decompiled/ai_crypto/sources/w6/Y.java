package w6;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes2.dex */
public final class Y extends C2790c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Socket f25066o;

    public Y(Socket socket) {
        kotlin.jvm.internal.r.f(socket, "socket");
        this.f25066o = socket;
    }

    @Override // w6.C2790c
    public void C() {
        try {
            this.f25066o.close();
        } catch (AssertionError e7) {
            if (!L.e(e7)) {
                throw e7;
            }
            M.f25037a.log(Level.WARNING, "Failed to close timed out socket " + this.f25066o, (Throwable) e7);
        } catch (Exception e8) {
            M.f25037a.log(Level.WARNING, "Failed to close timed out socket " + this.f25066o, (Throwable) e8);
        }
    }

    @Override // w6.C2790c
    public IOException y(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }
}
