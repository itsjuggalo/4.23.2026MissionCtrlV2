package T0;

import E5.E;
import R0.j;
import android.content.Context;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class g implements P.a, Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f4713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f4714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f4715d;

    public g(Context context) {
        r.f(context, "context");
        this.f4712a = context;
        this.f4713b = new ReentrantLock();
        this.f4715d = new LinkedHashSet();
    }

    @Override // P.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(WindowLayoutInfo value) {
        r.f(value, "value");
        ReentrantLock reentrantLock = this.f4713b;
        reentrantLock.lock();
        try {
            this.f4714c = f.f4711a.c(this.f4712a, value);
            Iterator it = this.f4715d.iterator();
            while (it.hasNext()) {
                ((P.a) it.next()).accept(this.f4714c);
            }
            E e7 = E.f1657a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void b(P.a listener) {
        r.f(listener, "listener");
        ReentrantLock reentrantLock = this.f4713b;
        reentrantLock.lock();
        try {
            j jVar = this.f4714c;
            if (jVar != null) {
                listener.accept(jVar);
            }
            this.f4715d.add(listener);
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final boolean c() {
        return this.f4715d.isEmpty();
    }

    public final void d(P.a listener) {
        r.f(listener, "listener");
        ReentrantLock reentrantLock = this.f4713b;
        reentrantLock.lock();
        try {
            this.f4715d.remove(listener);
        } finally {
            reentrantLock.unlock();
        }
    }
}
