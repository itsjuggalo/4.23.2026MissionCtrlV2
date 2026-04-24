package T0;

import E5.E;
import F5.AbstractC0556n;
import O0.d;
import Q5.k;
import android.app.Activity;
import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class d implements S0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowLayoutComponent f4701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final O0.d f4702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReentrantLock f4703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f4704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f4705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f4706f;

    public /* synthetic */ class a extends o implements k {
        public a(Object obj) {
            super(1, obj, g.class, "accept", "accept(Landroidx/window/extensions/layout/WindowLayoutInfo;)V", 0);
        }

        public final void e(WindowLayoutInfo p02) {
            r.f(p02, "p0");
            ((g) this.receiver).accept(p02);
        }

        @Override // Q5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            e((WindowLayoutInfo) obj);
            return E.f1657a;
        }
    }

    public d(WindowLayoutComponent component, O0.d consumerAdapter) {
        r.f(component, "component");
        r.f(consumerAdapter, "consumerAdapter");
        this.f4701a = component;
        this.f4702b = consumerAdapter;
        this.f4703c = new ReentrantLock();
        this.f4704d = new LinkedHashMap();
        this.f4705e = new LinkedHashMap();
        this.f4706f = new LinkedHashMap();
    }

    @Override // S0.a
    public void a(Context context, Executor executor, P.a callback) {
        E e7;
        r.f(context, "context");
        r.f(executor, "executor");
        r.f(callback, "callback");
        ReentrantLock reentrantLock = this.f4703c;
        reentrantLock.lock();
        try {
            g gVar = (g) this.f4704d.get(context);
            if (gVar != null) {
                gVar.b(callback);
                this.f4705e.put(callback, context);
                e7 = E.f1657a;
            } else {
                e7 = null;
            }
            if (e7 == null) {
                g gVar2 = new g(context);
                this.f4704d.put(context, gVar2);
                this.f4705e.put(callback, context);
                gVar2.b(callback);
                if (!(context instanceof Activity)) {
                    gVar2.accept(new WindowLayoutInfo(AbstractC0556n.g()));
                    reentrantLock.unlock();
                    return;
                } else {
                    this.f4706f.put(gVar2, this.f4702b.c(this.f4701a, H.b(WindowLayoutInfo.class), "addWindowLayoutInfoListener", "removeWindowLayoutInfoListener", (Activity) context, new a(gVar2)));
                }
            }
            E e8 = E.f1657a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // S0.a
    public void b(P.a callback) {
        r.f(callback, "callback");
        ReentrantLock reentrantLock = this.f4703c;
        reentrantLock.lock();
        try {
            Context context = (Context) this.f4705e.get(callback);
            if (context == null) {
                reentrantLock.unlock();
                return;
            }
            g gVar = (g) this.f4704d.get(context);
            if (gVar == null) {
                reentrantLock.unlock();
                return;
            }
            gVar.d(callback);
            this.f4705e.remove(callback);
            if (gVar.c()) {
                this.f4704d.remove(context);
                d.b bVar = (d.b) this.f4706f.remove(gVar);
                if (bVar != null) {
                    bVar.a();
                }
            }
            E e7 = E.f1657a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
