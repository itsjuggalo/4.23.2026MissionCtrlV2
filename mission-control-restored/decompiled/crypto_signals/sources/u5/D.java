package u5;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes.dex */
public final class D extends C1248e {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Socket f10503m;

    public D(Socket socket) {
        kotlin.jvm.internal.j.e(socket, "socket");
        this.f10503m = socket;
    }

    @Override // u5.C1248e
    public final void h() {
        Socket socket = this.f10503m;
        try {
            socket.close();
        } catch (AssertionError e) {
            if (!AbstractC1245b.f(e)) {
                throw e;
            }
            u.f10548a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
        } catch (Exception e2) {
            u.f10548a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e2);
        }
    }

    public final IOException i(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }
}
