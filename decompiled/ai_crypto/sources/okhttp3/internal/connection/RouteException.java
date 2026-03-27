package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes2.dex */
public final class RouteException extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IOException f20796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IOException f20797b;

    public RouteException(IOException iOException) {
        super(iOException);
        this.f20796a = iOException;
        this.f20797b = iOException;
    }

    public void a(IOException iOException) {
        Util.a(this.f20796a, iOException);
        this.f20797b = iOException;
    }

    public IOException b() {
        return this.f20796a;
    }

    public IOException c() {
        return this.f20797b;
    }
}
