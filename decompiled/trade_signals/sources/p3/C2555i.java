package p3;

import com.google.android.gms.common.internal.AbstractC1293m;
import e3.C1668e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: renamed from: p3.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2555i implements Iterable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1668e f22290d = new C1668e(Collections.emptyList(), null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2560n f22291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C1668e f22292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractC2554h f22293c;

    public C2555i(InterfaceC2560n interfaceC2560n, AbstractC2554h abstractC2554h) {
        this.f22293c = abstractC2554h;
        this.f22291a = interfaceC2560n;
        this.f22292b = null;
    }

    public static C2555i d(InterfaceC2560n interfaceC2560n) {
        return new C2555i(interfaceC2560n, C2563q.j());
    }

    public static C2555i e(InterfaceC2560n interfaceC2560n, AbstractC2554h abstractC2554h) {
        return new C2555i(interfaceC2560n, abstractC2554h);
    }

    public C2548b C(C2548b c2548b, InterfaceC2560n interfaceC2560n, AbstractC2554h abstractC2554h) {
        if (!this.f22293c.equals(C2556j.j()) && !this.f22293c.equals(abstractC2554h)) {
            throw new IllegalArgumentException("Index not available in IndexedNode!");
        }
        a();
        if (AbstractC1293m.a(this.f22292b, f22290d)) {
            return this.f22291a.p(c2548b);
        }
        C2559m c2559m = (C2559m) this.f22292b.e(new C2559m(c2548b, interfaceC2560n));
        if (c2559m != null) {
            return c2559m.c();
        }
        return null;
    }

    public Iterator E() {
        a();
        return AbstractC1293m.a(this.f22292b, f22290d) ? this.f22291a.E() : this.f22292b.E();
    }

    public boolean F(AbstractC2554h abstractC2554h) {
        return this.f22293c == abstractC2554h;
    }

    public C2555i H(C2548b c2548b, InterfaceC2560n interfaceC2560n) {
        InterfaceC2560n interfaceC2560nA = this.f22291a.A(c2548b, interfaceC2560n);
        C1668e c1668e = this.f22292b;
        C1668e c1668e2 = f22290d;
        if (AbstractC1293m.a(c1668e, c1668e2) && !this.f22293c.e(interfaceC2560n)) {
            return new C2555i(interfaceC2560nA, this.f22293c, c1668e2);
        }
        C1668e c1668e3 = this.f22292b;
        if (c1668e3 == null || AbstractC1293m.a(c1668e3, c1668e2)) {
            return new C2555i(interfaceC2560nA, this.f22293c, null);
        }
        C1668e c1668eH = this.f22292b.h(new C2559m(c2548b, this.f22291a.z(c2548b)));
        if (!interfaceC2560n.isEmpty()) {
            c1668eH = c1668eH.f(new C2559m(c2548b, interfaceC2560n));
        }
        return new C2555i(interfaceC2560nA, this.f22293c, c1668eH);
    }

    public C2555i I(InterfaceC2560n interfaceC2560n) {
        return new C2555i(this.f22291a.c(interfaceC2560n), this.f22293c, this.f22292b);
    }

    public final void a() {
        if (this.f22292b == null) {
            if (!this.f22293c.equals(C2556j.j())) {
                ArrayList arrayList = new ArrayList();
                boolean z7 = false;
                for (C2559m c2559m : this.f22291a) {
                    z7 = z7 || this.f22293c.e(c2559m.d());
                    arrayList.add(new C2559m(c2559m.c(), c2559m.d()));
                }
                if (z7) {
                    this.f22292b = new C1668e(arrayList, this.f22293c);
                    return;
                }
            }
            this.f22292b = f22290d;
        }
    }

    public C2559m f() {
        if (!(this.f22291a instanceof C2549c)) {
            return null;
        }
        a();
        if (!AbstractC1293m.a(this.f22292b, f22290d)) {
            return (C2559m) this.f22292b.d();
        }
        C2548b c2548bJ = ((C2549c) this.f22291a).J();
        return new C2559m(c2548bJ, this.f22291a.z(c2548bJ));
    }

    public C2559m h() {
        if (!(this.f22291a instanceof C2549c)) {
            return null;
        }
        a();
        if (!AbstractC1293m.a(this.f22292b, f22290d)) {
            return (C2559m) this.f22292b.a();
        }
        C2548b c2548bK = ((C2549c) this.f22291a).K();
        return new C2559m(c2548bK, this.f22291a.z(c2548bK));
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        a();
        return AbstractC1293m.a(this.f22292b, f22290d) ? this.f22291a.iterator() : this.f22292b.iterator();
    }

    public InterfaceC2560n n() {
        return this.f22291a;
    }

    public C2555i(InterfaceC2560n interfaceC2560n, AbstractC2554h abstractC2554h, C1668e c1668e) {
        this.f22293c = abstractC2554h;
        this.f22291a = interfaceC2560n;
        this.f22292b = c1668e;
    }
}
