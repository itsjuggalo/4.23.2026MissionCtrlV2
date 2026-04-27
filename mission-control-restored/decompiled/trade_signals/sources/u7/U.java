package u7;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class U extends C2810c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Socket f23609o;

    public U(Socket socket) {
        AbstractC2304t.f(socket, "socket");
        this.f23609o = socket;
    }

    @Override // u7.C2810c
    public IOException t(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // u7.C2810c
    public void x() {
        Level level;
        StringBuilder sb;
        Logger logger;
        Throwable th;
        try {
            this.f23609o.close();
        } catch (AssertionError e8) {
            if (!H.c(e8)) {
                throw e8;
            }
            Logger logger2 = I.f23580a;
            level = Level.WARNING;
            sb = new StringBuilder();
            th = e8;
            logger = logger2;
            sb.append("Failed to close timed out socket ");
            sb.append(this.f23609o);
            logger.log(level, sb.toString(), th);
        } catch (Exception e9) {
            Logger logger3 = I.f23580a;
            level = Level.WARNING;
            sb = new StringBuilder();
            th = e9;
            logger = logger3;
            sb.append("Failed to close timed out socket ");
            sb.append(this.f23609o);
            logger.log(level, sb.toString(), th);
        }
    }
}
