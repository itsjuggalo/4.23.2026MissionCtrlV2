package c3;

import c3.r;
import h3.C1859C;
import h3.C1866b;
import h3.C1875k;
import h3.C1877m;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import k3.AbstractC2279m;
import k3.AbstractC2280n;
import k3.C2273g;
import l2.AbstractC2328l;
import l3.AbstractC2334a;
import p3.AbstractC2561o;
import p3.AbstractC2564r;
import p3.C2548b;
import p3.InterfaceC2560n;

/* JADX INFO: loaded from: classes.dex */
public class e extends p {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC2560n f13356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ C2273g f13357b;

        public a(InterfaceC2560n interfaceC2560n, C2273g c2273g) {
            this.f13356a = interfaceC2560n;
            this.f13357b = c2273g;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            eVar.f13398a.m0(eVar.s(), this.f13356a, (InterfaceC0230e) this.f13357b.b());
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC2560n f13359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ C2273g f13360b;

        public b(InterfaceC2560n interfaceC2560n, C2273g c2273g) {
            this.f13359a = interfaceC2560n;
            this.f13360b = c2273g;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            eVar.f13398a.m0(eVar.s().K(C2548b.n()), this.f13359a, (InterfaceC0230e) this.f13360b.b());
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C1866b f13362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ C2273g f13363b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f13364c;

        public c(C1866b c1866b, C2273g c2273g, Map map) {
            this.f13362a = c1866b;
            this.f13363b = c2273g;
            this.f13364c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            eVar.f13398a.o0(eVar.s(), this.f13362a, (InterfaceC0230e) this.f13363b.b(), this.f13364c);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r.b f13366a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f13367b;

        public d(r.b bVar, boolean z7) {
            this.f13366a = bVar;
            this.f13367b = z7;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            eVar.f13398a.n0(eVar.s(), this.f13366a, this.f13367b);
        }
    }

    /* JADX INFO: renamed from: c3.e$e, reason: collision with other inner class name */
    public interface InterfaceC0230e {
        void a(c3.c cVar, e eVar);
    }

    public e(C1877m c1877m, C1875k c1875k) {
        super(c1877m, c1875k);
    }

    public e W(String str) {
        if (str == null) {
            throw new NullPointerException("Can't pass null for argument 'pathString' in child()");
        }
        if (s().isEmpty()) {
            AbstractC2280n.i(str);
        } else {
            AbstractC2280n.h(str);
        }
        return new e(this.f13398a, s().J(new C1875k(str)));
    }

    public String X() {
        if (s().isEmpty()) {
            return null;
        }
        return s().N().b();
    }

    public e Y() {
        C1875k c1875kQ = s().Q();
        if (c1875kQ != null) {
            return new e(this.f13398a, c1875kQ);
        }
        return null;
    }

    public n Z() {
        AbstractC2280n.l(s());
        return new n(this.f13398a, s());
    }

    public void a0(r.b bVar, boolean z7) {
        if (bVar == null) {
            throw new NullPointerException("Can't pass null for argument 'handler' in runTransaction()");
        }
        AbstractC2280n.l(s());
        this.f13398a.i0(new d(bVar, z7));
    }

    public AbstractC2328l b0(Object obj) {
        return c0(AbstractC2564r.c(this.f13399b, obj), null);
    }

    public final AbstractC2328l c0(InterfaceC2560n interfaceC2560n, InterfaceC0230e interfaceC0230e) {
        AbstractC2280n.l(s());
        C2273g c2273gL = AbstractC2279m.l(interfaceC0230e);
        this.f13398a.i0(new b(interfaceC2560n, c2273gL));
        return (AbstractC2328l) c2273gL.a();
    }

    public AbstractC2328l d0(Object obj) {
        return f0(obj, AbstractC2564r.c(this.f13399b, null), null);
    }

    public AbstractC2328l e0(Object obj, Object obj2) {
        return f0(obj, AbstractC2564r.c(this.f13399b, obj2), null);
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && toString().equals(obj.toString());
    }

    public final AbstractC2328l f0(Object obj, InterfaceC2560n interfaceC2560n, InterfaceC0230e interfaceC0230e) {
        AbstractC2280n.l(s());
        C1859C.g(s(), obj);
        Object objB = AbstractC2334a.b(obj);
        AbstractC2280n.k(objB);
        InterfaceC2560n interfaceC2560nB = AbstractC2561o.b(objB, interfaceC2560n);
        C2273g c2273gL = AbstractC2279m.l(interfaceC0230e);
        this.f13398a.i0(new a(interfaceC2560nB, c2273gL));
        return (AbstractC2328l) c2273gL.a();
    }

    public AbstractC2328l g0(Map map) {
        return h0(map, null);
    }

    public final AbstractC2328l h0(Map map, InterfaceC0230e interfaceC0230e) {
        if (map == null) {
            throw new NullPointerException("Can't pass null for argument 'update' in updateChildren()");
        }
        Map mapC = AbstractC2334a.c(map);
        C1866b c1866bH = C1866b.H(AbstractC2280n.e(s(), mapC));
        C2273g c2273gL = AbstractC2279m.l(interfaceC0230e);
        this.f13398a.i0(new c(c1866bH, c2273gL, mapC));
        return (AbstractC2328l) c2273gL.a();
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        e eVarY = Y();
        if (eVarY == null) {
            return this.f13398a.toString();
        }
        try {
            return eVarY.toString() + "/" + URLEncoder.encode(X(), "UTF-8").replace("+", "%20");
        } catch (UnsupportedEncodingException e8) {
            throw new c3.d("Failed to URLEncode key: " + X(), e8);
        }
    }
}
