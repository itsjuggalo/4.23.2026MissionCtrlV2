package o7;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class u implements c9.d, c9.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f17593a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Queue f17594b = new ArrayDeque();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f17595c;

    public u(Executor executor) {
        this.f17595c = executor;
    }

    @Override // c9.c
    public void a(final c9.a aVar) {
        d0.b(aVar);
        synchronized (this) {
            try {
                Queue queue = this.f17594b;
                if (queue != null) {
                    queue.add(aVar);
                    return;
                }
                for (final Map.Entry entry : g(aVar)) {
                    ((Executor) entry.getValue()).execute(new Runnable() { // from class: o7.t
                        @Override // java.lang.Runnable
                        public final void run() {
                            ((c9.b) entry.getKey()).handle(aVar);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // c9.d
    public void b(Class cls, c9.b bVar) {
        d(cls, this.f17595c, bVar);
    }

    @Override // c9.d
    public synchronized void c(Class cls, c9.b bVar) {
        d0.b(cls);
        d0.b(bVar);
        if (this.f17593a.containsKey(cls)) {
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f17593a.get(cls);
            concurrentHashMap.remove(bVar);
            if (concurrentHashMap.isEmpty()) {
                this.f17593a.remove(cls);
            }
        }
    }

    @Override // c9.d
    public synchronized void d(Class cls, Executor executor, c9.b bVar) {
        try {
            d0.b(cls);
            d0.b(bVar);
            d0.b(executor);
            if (!this.f17593a.containsKey(cls)) {
                this.f17593a.put(cls, new ConcurrentHashMap());
            }
            ((ConcurrentHashMap) this.f17593a.get(cls)).put(bVar, executor);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void f() {
        Queue queue;
        synchronized (this) {
            try {
                queue = this.f17594b;
                if (queue != null) {
                    this.f17594b = null;
                } else {
                    queue = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (queue != null) {
            Iterator it = queue.iterator();
            while (it.hasNext()) {
                a((c9.a) it.next());
            }
        }
    }

    public final synchronized Set g(c9.a aVar) {
        Map map;
        try {
            map = (Map) this.f17593a.get(aVar.b());
        } catch (Throwable th) {
            throw th;
        }
        return map == null ? Collections.EMPTY_SET : map.entrySet();
    }
}
