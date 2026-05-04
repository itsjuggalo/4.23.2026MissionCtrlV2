package x3;

import c4.j;
import i3.i;
import i3.t;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import u3.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t f24181c = new t(Object.class, Object.class, Object.class, Collections.singletonList(new i(Object.class, Object.class, Object.class, Collections.EMPTY_LIST, new g(), null)), null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w.a f24182a = new w.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f24183b = new AtomicReference();

    public t a(Class cls, Class cls2, Class cls3) {
        t tVar;
        j jVarB = b(cls, cls2, cls3);
        synchronized (this.f24182a) {
            tVar = (t) this.f24182a.get(jVarB);
        }
        this.f24183b.set(jVarB);
        return tVar;
    }

    public final j b(Class cls, Class cls2, Class cls3) {
        j jVar = (j) this.f24183b.getAndSet(null);
        if (jVar == null) {
            jVar = new j();
        }
        jVar.a(cls, cls2, cls3);
        return jVar;
    }

    public boolean c(t tVar) {
        return f24181c.equals(tVar);
    }

    public void d(Class cls, Class cls2, Class cls3, t tVar) {
        synchronized (this.f24182a) {
            w.a aVar = this.f24182a;
            j jVar = new j(cls, cls2, cls3);
            if (tVar == null) {
                tVar = f24181c;
            }
            aVar.put(jVar, tVar);
        }
    }
}
