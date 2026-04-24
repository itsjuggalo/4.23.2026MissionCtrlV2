package C0;

import W2.E;
import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class e implements B0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowLayoutComponent f137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f140d;

    public e(WindowLayoutComponent component) {
        r.f(component, "component");
        this.f137a = component;
        this.f138b = new ReentrantLock();
        this.f139c = new LinkedHashMap();
        this.f140d = new LinkedHashMap();
    }

    @Override // B0.a
    public void a(G.a callback) {
        r.f(callback, "callback");
        ReentrantLock reentrantLock = this.f138b;
        reentrantLock.lock();
        try {
            Context context = (Context) this.f140d.get(callback);
            if (context == null) {
                reentrantLock.unlock();
                return;
            }
            g gVar = (g) this.f139c.get(context);
            if (gVar == null) {
                reentrantLock.unlock();
                return;
            }
            gVar.d(callback);
            this.f140d.remove(callback);
            if (gVar.c()) {
                this.f139c.remove(context);
                this.f137a.removeWindowLayoutInfoListener(gVar);
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
        ReentrantLock reentrantLock = this.f138b;
        reentrantLock.lock();
        try {
            g gVar = (g) this.f139c.get(context);
            if (gVar != null) {
                gVar.b(callback);
                this.f140d.put(callback, context);
                e4 = E.f5463a;
            } else {
                e4 = null;
            }
            if (e4 == null) {
                g gVar2 = new g(context);
                this.f139c.put(context, gVar2);
                this.f140d.put(callback, context);
                gVar2.b(callback);
                this.f137a.addWindowLayoutInfoListener(context, gVar2);
            }
            E e5 = E.f5463a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
