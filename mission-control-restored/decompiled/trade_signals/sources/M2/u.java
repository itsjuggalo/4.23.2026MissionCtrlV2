package M2;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class u implements A3.d, A3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f5337a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Queue f5338b = new ArrayDeque();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f5339c;

    public u(Executor executor) {
        this.f5339c = executor;
    }

    public static /* synthetic */ void h(Map.Entry entry, A3.a aVar) {
        ((A3.b) entry.getKey()).handle(aVar);
    }

    @Override // A3.d
    public void a(Class cls, A3.b bVar) {
        c(cls, this.f5339c, bVar);
    }

    @Override // A3.d
    public synchronized void b(Class cls, A3.b bVar) {
        D.b(cls);
        D.b(bVar);
        if (this.f5337a.containsKey(cls)) {
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f5337a.get(cls);
            concurrentHashMap.remove(bVar);
            if (concurrentHashMap.isEmpty()) {
                this.f5337a.remove(cls);
            }
        }
    }

    @Override // A3.d
    public synchronized void c(Class cls, Executor executor, A3.b bVar) {
        try {
            D.b(cls);
            D.b(bVar);
            D.b(executor);
            if (!this.f5337a.containsKey(cls)) {
                this.f5337a.put(cls, new ConcurrentHashMap());
            }
            ((ConcurrentHashMap) this.f5337a.get(cls)).put(bVar, executor);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // A3.c
    public void d(final A3.a aVar) {
        D.b(aVar);
        synchronized (this) {
            try {
                Queue queue = this.f5338b;
                if (queue != null) {
                    queue.add(aVar);
                    return;
                }
                for (final Map.Entry entry : g(aVar)) {
                    ((Executor) entry.getValue()).execute(new Runnable() { // from class: M2.t
                        @Override // java.lang.Runnable
                        public final void run() {
                            u.h(entry, aVar);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f() {
        Queue queue;
        synchronized (this) {
            try {
                queue = this.f5338b;
                if (queue != null) {
                    this.f5338b = null;
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
                d((A3.a) it.next());
            }
        }
    }

    public final synchronized Set g(A3.a aVar) {
        Map map;
        try {
            map = (Map) this.f5337a.get(aVar.b());
        } catch (Throwable th) {
            throw th;
        }
        return map == null ? Collections.emptySet() : map.entrySet();
    }
}
