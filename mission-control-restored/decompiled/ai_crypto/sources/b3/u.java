package b3;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import z3.C2889a;
import z3.InterfaceC2890b;
import z3.InterfaceC2891c;
import z3.InterfaceC2892d;

/* JADX INFO: loaded from: classes.dex */
public class u implements InterfaceC2892d, InterfaceC2891c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f8570a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Queue f8571b = new ArrayDeque();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f8572c;

    public u(Executor executor) {
        this.f8572c = executor;
    }

    public static /* synthetic */ void h(Map.Entry entry, C2889a c2889a) {
        ((InterfaceC2890b) entry.getKey()).a(c2889a);
    }

    @Override // z3.InterfaceC2892d
    public synchronized void a(Class cls, Executor executor, InterfaceC2890b interfaceC2890b) {
        try {
            AbstractC0981D.b(cls);
            AbstractC0981D.b(interfaceC2890b);
            AbstractC0981D.b(executor);
            if (!this.f8570a.containsKey(cls)) {
                this.f8570a.put(cls, new ConcurrentHashMap());
            }
            ((ConcurrentHashMap) this.f8570a.get(cls)).put(interfaceC2890b, executor);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // z3.InterfaceC2892d
    public void b(Class cls, InterfaceC2890b interfaceC2890b) {
        a(cls, this.f8572c, interfaceC2890b);
    }

    @Override // z3.InterfaceC2891c
    public void c(final C2889a c2889a) {
        AbstractC0981D.b(c2889a);
        synchronized (this) {
            try {
                Queue queue = this.f8571b;
                if (queue != null) {
                    queue.add(c2889a);
                    return;
                }
                for (final Map.Entry entry : g(c2889a)) {
                    ((Executor) entry.getValue()).execute(new Runnable() { // from class: b3.t
                        @Override // java.lang.Runnable
                        public final void run() {
                            u.h(entry, c2889a);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // z3.InterfaceC2892d
    public synchronized void d(Class cls, InterfaceC2890b interfaceC2890b) {
        AbstractC0981D.b(cls);
        AbstractC0981D.b(interfaceC2890b);
        if (this.f8570a.containsKey(cls)) {
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f8570a.get(cls);
            concurrentHashMap.remove(interfaceC2890b);
            if (concurrentHashMap.isEmpty()) {
                this.f8570a.remove(cls);
            }
        }
    }

    public void f() {
        Queue queue;
        synchronized (this) {
            try {
                queue = this.f8571b;
                if (queue != null) {
                    this.f8571b = null;
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
                c((C2889a) it.next());
            }
        }
    }

    public final synchronized Set g(C2889a c2889a) {
        Map map;
        try {
            map = (Map) this.f8570a.get(c2889a.b());
        } catch (Throwable th) {
            throw th;
        }
        return map == null ? Collections.emptySet() : map.entrySet();
    }
}
