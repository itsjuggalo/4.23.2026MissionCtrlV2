package O3;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Socket f3361o;

    public s(Socket socket) {
        kotlin.jvm.internal.r.f(socket, "socket");
        this.f3361o = socket;
    }

    @Override // O3.c
    public IOException t(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // O3.c
    public void x() {
        try {
            this.f3361o.close();
        } catch (AssertionError e4) {
            if (!i.c(e4)) {
                throw e4;
            }
            j.f3337a.log(Level.WARNING, "Failed to close timed out socket " + this.f3361o, (Throwable) e4);
        } catch (Exception e5) {
            j.f3337a.log(Level.WARNING, "Failed to close timed out socket " + this.f3361o, (Throwable) e5);
        }
    }
}
