package C0;

import A0.j;
import W2.E;
import android.content.Context;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class g implements G.a, Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f145d;

    public g(Context context) {
        r.f(context, "context");
        this.f142a = context;
        this.f143b = new ReentrantLock();
        this.f145d = new LinkedHashSet();
    }

    @Override // G.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(WindowLayoutInfo value) {
        r.f(value, "value");
        ReentrantLock reentrantLock = this.f143b;
        reentrantLock.lock();
        try {
            this.f144c = f.f141a.c(this.f142a, value);
            Iterator it = this.f145d.iterator();
            while (it.hasNext()) {
                ((G.a) it.next()).accept(this.f144c);
            }
            E e4 = E.f5463a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void b(G.a listener) {
        r.f(listener, "listener");
        ReentrantLock reentrantLock = this.f143b;
        reentrantLock.lock();
        try {
            j jVar = this.f144c;
            if (jVar != null) {
                listener.accept(jVar);
            }
            this.f145d.add(listener);
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final boolean c() {
        return this.f145d.isEmpty();
    }

    public final void d(G.a listener) {
        r.f(listener, "listener");
        ReentrantLock reentrantLock = this.f143b;
        reentrantLock.lock();
        try {
            this.f145d.remove(listener);
        } finally {
            reentrantLock.unlock();
        }
    }
}
