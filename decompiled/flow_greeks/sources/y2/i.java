package y2;

import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutInfo;
import androidx.window.reflection.Consumer2;
import cd.h0;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.t;
import w2.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements s0.a, Consumer2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f25179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f25180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s f25181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f25182d;

    public i(Context context) {
        t.f(context, "context");
        this.f25179a = context;
        this.f25180b = new ReentrantLock();
        this.f25182d = new LinkedHashSet();
    }

    @Override // s0.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(WindowLayoutInfo value) {
        t.f(value, "value");
        ReentrantLock reentrantLock = this.f25180b;
        reentrantLock.lock();
        try {
            s sVarB = h.f25178a.b(this.f25179a, value);
            this.f25181c = sVarB;
            Iterator it = this.f25182d.iterator();
            while (it.hasNext()) {
                ((s0.a) it.next()).accept(sVarB);
            }
            h0 h0Var = h0.f3852a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void b(s0.a listener) {
        t.f(listener, "listener");
        ReentrantLock reentrantLock = this.f25180b;
        reentrantLock.lock();
        try {
            s sVar = this.f25181c;
            if (sVar != null) {
                listener.accept(sVar);
            }
            this.f25182d.add(listener);
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final boolean c() {
        return this.f25182d.isEmpty();
    }

    public final void d(s0.a listener) {
        t.f(listener, "listener");
        ReentrantLock reentrantLock = this.f25180b;
        reentrantLock.lock();
        try {
            this.f25182d.remove(listener);
        } finally {
            reentrantLock.unlock();
        }
    }
}
