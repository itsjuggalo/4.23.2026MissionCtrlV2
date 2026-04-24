package N2;

import T2.C0247k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class L {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ThreadPoolExecutor f1950g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0247k f1951a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1954d;
    public K2.K e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f1952b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f1953c = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashSet f1955f = new HashSet();

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f1950g = threadPoolExecutor;
    }

    public L(C0247k c0247k) {
        this.f1951a = c0247k;
    }

    public final R2.m a(Q2.h hVar) {
        Q2.n nVar = (Q2.n) this.f1952b.get(hVar);
        return (this.f1955f.contains(hVar) || nVar == null) ? R2.m.f2791c : nVar.equals(Q2.n.f2687b) ? R2.m.a(false) : new R2.m(nVar, null);
    }

    public final R2.m b(Q2.h hVar) throws K2.K {
        Q2.n nVar = (Q2.n) this.f1952b.get(hVar);
        if (this.f1955f.contains(hVar) || nVar == null) {
            return R2.m.a(true);
        }
        if (nVar.equals(Q2.n.f2687b)) {
            throw new K2.K("Can't update a document that doesn't exist.", K2.J.INVALID_ARGUMENT);
        }
        return new R2.m(nVar, null);
    }
}
