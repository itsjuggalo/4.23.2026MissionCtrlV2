package C0;

import W2.E;
import X2.AbstractC0769p;
import android.app.Activity;
import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.extensions.layout.WindowLayoutInfo;
import i3.k;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.r;
import x0.C1915d;

/* JADX INFO: loaded from: classes.dex */
public final class d implements B0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowLayoutComponent f131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1915d f132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReentrantLock f133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f136f;

    public /* synthetic */ class a extends o implements k {
        public a(Object obj) {
            super(1, obj, g.class, "accept", "accept(Landroidx/window/extensions/layout/WindowLayoutInfo;)V", 0);
        }

        public final void d(WindowLayoutInfo p02) {
            r.f(p02, "p0");
            ((g) this.receiver).accept(p02);
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            d((WindowLayoutInfo) obj);
            return E.f5463a;
        }
    }

    public d(WindowLayoutComponent component, C1915d consumerAdapter) {
        r.f(component, "component");
        r.f(consumerAdapter, "consumerAdapter");
        this.f131a = component;
        this.f132b = consumerAdapter;
        this.f133c = new ReentrantLock();
        this.f134d = new LinkedHashMap();
        this.f135e = new LinkedHashMap();
        this.f136f = new LinkedHashMap();
    }

    @Override // B0.a
    public void a(G.a callback) {
        r.f(callback, "callback");
        ReentrantLock reentrantLock = this.f133c;
        reentrantLock.lock();
        try {
            Context context = (Context) this.f135e.get(callback);
            if (context == null) {
                reentrantLock.unlock();
                return;
            }
            g gVar = (g) this.f134d.get(context);
            if (gVar == null) {
                reentrantLock.unlock();
                return;
            }
            gVar.d(callback);
            this.f135e.remove(callback);
            if (gVar.c()) {
                this.f134d.remove(context);
                C1915d.b bVar = (C1915d.b) this.f136f.remove(gVar);
                if (bVar != null) {
                    bVar.dispose();
                }
            }
            E e4 = E.f5463a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // B0.a
    public void b(Context context, Executor executor, G.a callback) {
        E e4;
        r.f(context, "context");
        r.f(executor, "executor");
        r.f(callback, "callback");
        ReentrantLock reentrantLock = this.f133c;
        reentrantLock.lock();
        try {
            g gVar = (g) this.f134d.get(context);
            if (gVar != null) {
                gVar.b(callback);
                this.f135e.put(callback, context);
                e4 = E.f5463a;
            } else {
                e4 = null;
            }
            if (e4 == null) {
                g gVar2 = new g(context);
                this.f134d.put(context, gVar2);
                this.f135e.put(callback, context);
                gVar2.b(callback);
                if (!(context instanceof Activity)) {
                    gVar2.accept(new WindowLayoutInfo(AbstractC0769p.g()));
                    reentrantLock.unlock();
                    return;
                } else {
                    this.f136f.put(gVar2, this.f132b.c(this.f131a, G.b(WindowLayoutInfo.class), "addWindowLayoutInfoListener", "removeWindowLayoutInfoListener", (Activity) context, new a(gVar2)));
                }
            }
            E e5 = E.f5463a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
