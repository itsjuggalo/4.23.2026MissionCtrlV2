package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;

/* JADX INFO: loaded from: classes2.dex */
public final class RouteDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f20795a = new LinkedHashSet();

    public synchronized void a(Route route) {
        this.f20795a.remove(route);
    }

    public synchronized void b(Route route) {
        this.f20795a.add(route);
    }

    public synchronized boolean c(Route route) {
        return this.f20795a.contains(route);
    }
}
