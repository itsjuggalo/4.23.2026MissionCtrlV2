package x3;

import c4.j;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f24184a = new AtomicReference();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w.a f24185b = new w.a();

    public List a(Class cls, Class cls2, Class cls3) {
        List list;
        j jVar = (j) this.f24184a.getAndSet(null);
        if (jVar == null) {
            jVar = new j(cls, cls2, cls3);
        } else {
            jVar.a(cls, cls2, cls3);
        }
        synchronized (this.f24185b) {
            list = (List) this.f24185b.get(jVar);
        }
        this.f24184a.set(jVar);
        return list;
    }

    public void b(Class cls, Class cls2, Class cls3, List list) {
        synchronized (this.f24185b) {
            this.f24185b.put(new j(cls, cls2, cls3), list);
        }
    }
}
