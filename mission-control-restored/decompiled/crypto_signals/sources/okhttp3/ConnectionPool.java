package okhttp3;

import com.google.android.gms.common.api.f;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;

/* JADX INFO: loaded from: classes.dex */
public final class ConnectionPool {
    public static final ThreadPoolExecutor e = new ThreadPoolExecutor(0, f.API_PRIORITY_OTHER, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.g("OkHttp ConnectionPool", true));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f8767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f8768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayDeque f8769d;

    public ConnectionPool() {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        this.f8768c = new Runnable() { // from class: okhttp3.ConnectionPool.1
            @Override // java.lang.Runnable
            public final void run() {
                long j4;
                Object obj = null;
                while (true) {
                    ConnectionPool connectionPool = ConnectionPool.this;
                    System.nanoTime();
                    synchronized (connectionPool) {
                        Iterator it = connectionPool.f8769d.iterator();
                        if (it.hasNext()) {
                            RealConnection realConnection = (RealConnection) it.next();
                            connectionPool.getClass();
                            realConnection.getClass();
                            throw null;
                        }
                        if (Long.MIN_VALUE >= connectionPool.f8767b || connectionPool.f8766a < 0) {
                            connectionPool.f8769d.remove(null);
                            obj.getClass();
                            byte[] bArr = Util.f8827a;
                            j4 = 0;
                        } else {
                            j4 = -1;
                        }
                    }
                    if (j4 == -1) {
                        return;
                    }
                    if (j4 > 0) {
                        long j6 = j4 / 1000000;
                        long j7 = j4 - (1000000 * j6);
                        synchronized (ConnectionPool.this) {
                            try {
                                ConnectionPool.this.wait(j6, (int) j7);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
            }
        };
        this.f8769d = new ArrayDeque();
        new RouteDatabase();
        this.f8766a = 5;
        this.f8767b = timeUnit.toNanos(5L);
    }
}
