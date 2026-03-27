package N0;

import L0.j;
import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutInfo;
import androidx.window.reflection.Consumer2;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;

/* JADX INFO: loaded from: classes.dex */
public final class h implements S.a, Consumer2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f5457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f5458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f5459d;

    public h(Context context) {
        AbstractC2304t.f(context, "context");
        this.f5456a = context;
        this.f5457b = new ReentrantLock();
        this.f5459d = new LinkedHashSet();
    }

    @Override // S.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(WindowLayoutInfo value) {
        AbstractC2304t.f(value, "value");
        ReentrantLock reentrantLock = this.f5457b;
        reentrantLock.lock();
        try {
            j jVarC = g.f5455a.c(this.f5456a, value);
            this.f5458c = jVarC;
            Iterator it = this.f5459d.iterator();
            while (it.hasNext()) {
                ((S.a) it.next()).accept(jVarC);
            }
            C2470H c2470h = C2470H.f21956a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void b(S.a listener) {
        AbstractC2304t.f(listener, "listener");
        ReentrantLock reentrantLock = this.f5457b;
        reentrantLock.lock();
        try {
            j jVar = this.f5458c;
            if (jVar != null) {
                listener.accept(jVar);
            }
            this.f5459d.add(listener);
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final boolean c() {
        return this.f5459d.isEmpty();
    }

    public final void d(S.a listener) {
        AbstractC2304t.f(listener, "listener");
        ReentrantLock reentrantLock = this.f5457b;
        reentrantLock.lock();
        try {
            this.f5459d.remove(listener);
        } finally {
            reentrantLock.unlock();
        }
    }
}
