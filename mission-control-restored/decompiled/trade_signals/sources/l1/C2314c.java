package l1;

import W0.i;
import W0.t;
import i1.g;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import q1.C2627j;
import w.C2882a;

/* JADX INFO: renamed from: l1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2314c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t f20523c = new t(Object.class, Object.class, Object.class, Collections.singletonList(new i(Object.class, Object.class, Object.class, Collections.emptyList(), new g(), null)), null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2882a f20524a = new C2882a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f20525b = new AtomicReference();

    public t a(Class cls, Class cls2, Class cls3) {
        t tVar;
        C2627j c2627jB = b(cls, cls2, cls3);
        synchronized (this.f20524a) {
            tVar = (t) this.f20524a.get(c2627jB);
        }
        this.f20525b.set(c2627jB);
        return tVar;
    }

    public final C2627j b(Class cls, Class cls2, Class cls3) {
        C2627j c2627j = (C2627j) this.f20525b.getAndSet(null);
        if (c2627j == null) {
            c2627j = new C2627j();
        }
        c2627j.a(cls, cls2, cls3);
        return c2627j;
    }

    public boolean c(t tVar) {
        return f20523c.equals(tVar);
    }

    public void d(Class cls, Class cls2, Class cls3, t tVar) {
        synchronized (this.f20524a) {
            C2882a c2882a = this.f20524a;
            C2627j c2627j = new C2627j(cls, cls2, cls3);
            if (tVar == null) {
                tVar = f20523c;
            }
            c2882a.put(c2627j, tVar);
        }
    }
}
