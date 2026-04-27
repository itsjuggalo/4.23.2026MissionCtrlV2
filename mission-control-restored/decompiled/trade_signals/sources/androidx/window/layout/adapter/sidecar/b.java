package androidx.window.layout.adapter.sidecar;

import I0.k;
import L0.j;
import android.app.Activity;
import android.content.Context;
import androidx.window.layout.adapter.sidecar.a;
import androidx.window.layout.adapter.sidecar.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes.dex */
public final class b implements M0.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile b f12526d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public androidx.window.layout.adapter.sidecar.a f12528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f12529b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f12525c = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReentrantLock f12527e = new ReentrantLock();

    public static final class a {
        public a() {
        }

        public final b a(Context context) {
            AbstractC2304t.f(context, "context");
            if (b.f12526d == null) {
                ReentrantLock reentrantLock = b.f12527e;
                reentrantLock.lock();
                try {
                    if (b.f12526d == null) {
                        b.f12526d = new b(b.f12525c.b(context));
                    }
                    C2470H c2470h = C2470H.f21956a;
                    reentrantLock.unlock();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
            b bVar = b.f12526d;
            AbstractC2304t.c(bVar);
            return bVar;
        }

        public final androidx.window.layout.adapter.sidecar.a b(Context context) {
            AbstractC2304t.f(context, "context");
            try {
                if (!c(SidecarCompat.f12513f.c())) {
                    return null;
                }
                SidecarCompat sidecarCompat = new SidecarCompat(context);
                if (sidecarCompat.d()) {
                    return sidecarCompat;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        public final boolean c(k kVar) {
            return kVar != null && kVar.compareTo(k.f4052f.a()) >= 0;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    /* JADX INFO: renamed from: androidx.window.layout.adapter.sidecar.b$b, reason: collision with other inner class name */
    public final class C0203b implements a.InterfaceC0202a {
        public C0203b() {
        }

        @Override // androidx.window.layout.adapter.sidecar.a.InterfaceC0202a
        public void a(Activity activity, j newLayout) {
            AbstractC2304t.f(activity, "activity");
            AbstractC2304t.f(newLayout, "newLayout");
            for (c cVar : b.this.g()) {
                if (AbstractC2304t.b(cVar.d(), activity)) {
                    cVar.b(newLayout);
                }
            }
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f12531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f12532b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final S.a f12533c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public j f12534d;

        public c(Activity activity, Executor executor, S.a callback) {
            AbstractC2304t.f(activity, "activity");
            AbstractC2304t.f(executor, "executor");
            AbstractC2304t.f(callback, "callback");
            this.f12531a = activity;
            this.f12532b = executor;
            this.f12533c = callback;
        }

        public static final void c(c cVar, j jVar) {
            cVar.f12533c.accept(jVar);
        }

        public final void b(final j newLayoutInfo) {
            AbstractC2304t.f(newLayoutInfo, "newLayoutInfo");
            this.f12534d = newLayoutInfo;
            this.f12532b.execute(new Runnable() { // from class: O0.c
                @Override // java.lang.Runnable
                public final void run() {
                    b.c.c(this.f5895a, newLayoutInfo);
                }
            });
        }

        public final Activity d() {
            return this.f12531a;
        }

        public final S.a e() {
            return this.f12533c;
        }

        public final j f() {
            return this.f12534d;
        }
    }

    public b(androidx.window.layout.adapter.sidecar.a aVar) {
        this.f12528a = aVar;
        androidx.window.layout.adapter.sidecar.a aVar2 = this.f12528a;
        if (aVar2 != null) {
            aVar2.a(new C0203b());
        }
    }

    @Override // M0.a
    public void a(Context context, Executor executor, S.a callback) {
        Object next;
        AbstractC2304t.f(context, "context");
        AbstractC2304t.f(executor, "executor");
        AbstractC2304t.f(callback, "callback");
        C2470H c2470h = null;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            ReentrantLock reentrantLock = f12527e;
            reentrantLock.lock();
            try {
                androidx.window.layout.adapter.sidecar.a aVar = this.f12528a;
                if (aVar == null) {
                    callback.accept(new j(AbstractC2595q.i()));
                    return;
                }
                boolean zH = h(activity);
                c cVar = new c(activity, executor, callback);
                this.f12529b.add(cVar);
                if (zH) {
                    Iterator it = this.f12529b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        } else {
                            next = it.next();
                            if (AbstractC2304t.b(activity, ((c) next).d())) {
                                break;
                            }
                        }
                    }
                    c cVar2 = (c) next;
                    j jVarF = cVar2 != null ? cVar2.f() : null;
                    if (jVarF != null) {
                        cVar.b(jVarF);
                    }
                } else {
                    aVar.b(activity);
                }
                C2470H c2470h2 = C2470H.f21956a;
                reentrantLock.unlock();
                c2470h = C2470H.f21956a;
            } finally {
                reentrantLock.unlock();
            }
        }
        if (c2470h == null) {
            callback.accept(new j(AbstractC2595q.i()));
        }
    }

    @Override // M0.a
    public void b(S.a callback) {
        AbstractC2304t.f(callback, "callback");
        synchronized (f12527e) {
            try {
                if (this.f12528a == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (c cVar : this.f12529b) {
                    if (cVar.e() == callback) {
                        AbstractC2304t.c(cVar);
                        arrayList.add(cVar);
                    }
                }
                this.f12529b.removeAll(arrayList);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    f(((c) it.next()).d());
                }
                C2470H c2470h = C2470H.f21956a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f(Activity activity) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f12529b;
        if (!(copyOnWriteArrayList instanceof Collection) || !copyOnWriteArrayList.isEmpty()) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (AbstractC2304t.b(((c) it.next()).d(), activity)) {
                    return;
                }
            }
        }
        androidx.window.layout.adapter.sidecar.a aVar = this.f12528a;
        if (aVar != null) {
            aVar.c(activity);
        }
    }

    public final CopyOnWriteArrayList g() {
        return this.f12529b;
    }

    public final boolean h(Activity activity) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f12529b;
        if ((copyOnWriteArrayList instanceof Collection) && copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (AbstractC2304t.b(((c) it.next()).d(), activity)) {
                return true;
            }
        }
        return false;
    }
}
