package T0;

import E5.E;
import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class e implements S0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowLayoutComponent f4707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f4708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f4709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f4710d;

    public e(WindowLayoutComponent component) {
        r.f(component, "component");
        this.f4707a = component;
        this.f4708b = new ReentrantLock();
        this.f4709c = new LinkedHashMap();
        this.f4710d = new LinkedHashMap();
    }

    @Override // S0.a
    public void a(Context context, Executor executor, P.a callback) {
        E e7;
        r.f(context, "context");
        r.f(executor, "executor");
        r.f(callback, "callback");
        ReentrantLock reentrantLock = this.f4708b;
        reentrantLock.lock();
        try {
            g gVar = (g) this.f4709c.get(context);
            if (gVar != null) {
                gVar.b(callback);
                this.f4710d.put(callback, context);
                e7 = E.f1657a;
            } else {
                e7 = null;
            }
            if (e7 == null) {
                g gVar2 = new g(context);
                this.f4709c.put(context, gVar2);
                this.f4710d.put(callback, context);
                gVar2.b(callback);
                this.f4707a.addWindowLayoutInfoListener(context, gVar2);
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
        ReentrantLock reentrantLock = this.f4708b;
        reentrantLock.lock();
        try {
            Context context = (Context) this.f4710d.get(callback);
            if (context == null) {
                reentrantLock.unlock();
                return;
            }
            g gVar = (g) this.f4709c.get(context);
            if (gVar == null) {
                reentrantLock.unlock();
                return;
            }
            gVar.d(callback);
            this.f4710d.remove(callback);
            if (gVar.c()) {
                this.f4709c.remove(context);
                this.f4707a.removeWindowLayoutInfoListener(gVar);
            }
            E e7 = E.f1657a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
