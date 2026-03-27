package x4;

import java.io.Closeable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.net.ssl.SSLSocketFactory;
import s3.D;
import w4.C1325d;
import w4.C1343j;
import w4.Y1;
import w4.Z1;
import w4.c2;
import y4.C1432b;

/* JADX INFO: renamed from: x4.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1410f implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1343j f11496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f11497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C1343j f11498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f11499d;
    public final c2 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SSLSocketFactory f11500f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C1432b f11501k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f11502l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f11503m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final C1325d f11504n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f11505o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f11506p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f11507q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f11508r;

    public C1410f(C1343j c1343j, C1343j c1343j2, SSLSocketFactory sSLSocketFactory, C1432b c1432b, int i, boolean z6, long j4, long j6, int i6, int i7, c2 c2Var) {
        this.f11496a = c1343j;
        this.f11497b = (Executor) Z1.a((Y1) c1343j.f11289b);
        this.f11498c = c1343j2;
        this.f11499d = (ScheduledExecutorService) Z1.a((Y1) c1343j2.f11289b);
        this.f11500f = sSLSocketFactory;
        this.f11501k = c1432b;
        this.f11502l = i;
        this.f11503m = z6;
        this.f11504n = new C1325d(j4);
        this.f11505o = j6;
        this.f11506p = i6;
        this.f11507q = i7;
        D.j(c2Var, "transportTracerFactory");
        this.e = c2Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f11508r) {
            return;
        }
        this.f11508r = true;
        Z1.b((Y1) this.f11496a.f11289b, this.f11497b);
        Z1.b((Y1) this.f11498c.f11289b, this.f11499d);
    }
}
