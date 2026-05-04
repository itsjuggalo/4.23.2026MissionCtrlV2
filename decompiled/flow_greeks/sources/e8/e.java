package e8;

import com.google.android.gms.tasks.Task;
import e8.r;
import j8.d0;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e extends p {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r8.n f8475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m8.g f8476b;

        public a(r8.n nVar, m8.g gVar) {
            this.f8475a = nVar;
            this.f8476b = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            eVar.f8517a.o0(eVar.s(), this.f8475a, (InterfaceC0157e) this.f8476b.b());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r8.n f8478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m8.g f8479b;

        public b(r8.n nVar, m8.g gVar) {
            this.f8478a = nVar;
            this.f8479b = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            eVar.f8517a.o0(eVar.s().v(r8.b.m()), this.f8478a, (InterfaceC0157e) this.f8479b.b());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j8.b f8481a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m8.g f8482b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f8483c;

        public c(j8.b bVar, m8.g gVar, Map map) {
            this.f8481a = bVar;
            this.f8482b = gVar;
            this.f8483c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            eVar.f8517a.q0(eVar.s(), this.f8481a, (InterfaceC0157e) this.f8482b.b(), this.f8483c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r.b f8485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f8486b;

        public d(r.b bVar, boolean z10) {
            this.f8485a = bVar;
            this.f8486b = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            eVar.f8517a.p0(eVar.s(), this.f8485a, this.f8486b);
        }
    }

    /* JADX INFO: renamed from: e8.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface InterfaceC0157e {
        void a(e8.c cVar, e eVar);
    }

    public e(j8.n nVar, j8.l lVar) {
        super(nVar, lVar);
    }

    public e W(String str) {
        if (str == null) {
            throw new NullPointerException("Can't pass null for argument 'pathString' in child()");
        }
        if (s().isEmpty()) {
            m8.n.i(str);
        } else {
            m8.n.h(str);
        }
        return new e(this.f8517a, s().u(new j8.l(str)));
    }

    public String X() {
        if (s().isEmpty()) {
            return null;
        }
        return s().A().b();
    }

    public e Y() {
        j8.l lVarL = s().L();
        if (lVarL != null) {
            return new e(this.f8517a, lVarL);
        }
        return null;
    }

    public n Z() {
        m8.n.l(s());
        return new n(this.f8517a, s());
    }

    public void a0(r.b bVar) {
        b0(bVar, true);
    }

    public void b0(r.b bVar, boolean z10) {
        if (bVar == null) {
            throw new NullPointerException("Can't pass null for argument 'handler' in runTransaction()");
        }
        m8.n.l(s());
        this.f8517a.k0(new d(bVar, z10));
    }

    public Task c0(Object obj) {
        return d0(r8.r.c(this.f8518b, obj), null);
    }

    public final Task d0(r8.n nVar, InterfaceC0157e interfaceC0157e) {
        m8.n.l(s());
        m8.g gVarL = m8.m.l(interfaceC0157e);
        this.f8517a.k0(new b(nVar, gVarL));
        return (Task) gVarL.a();
    }

    public Task e0(Object obj) {
        return g0(obj, r8.r.c(this.f8518b, null), null);
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && toString().equals(obj.toString());
    }

    public Task f0(Object obj, Object obj2) {
        return g0(obj, r8.r.c(this.f8518b, obj2), null);
    }

    public final Task g0(Object obj, r8.n nVar, InterfaceC0157e interfaceC0157e) {
        m8.n.l(s());
        d0.g(s(), obj);
        Object objB = n8.a.b(obj);
        m8.n.k(objB);
        r8.n nVarB = r8.o.b(objB, nVar);
        m8.g gVarL = m8.m.l(interfaceC0157e);
        this.f8517a.k0(new a(nVarB, gVarL));
        return (Task) gVarL.a();
    }

    public Task h0(Map map) {
        return i0(map, null);
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public final Task i0(Map map, InterfaceC0157e interfaceC0157e) {
        if (map == null) {
            throw new NullPointerException("Can't pass null for argument 'update' in updateChildren()");
        }
        Map mapC = n8.a.c(map);
        j8.b bVarR = j8.b.r(m8.n.e(s(), mapC));
        m8.g gVarL = m8.m.l(interfaceC0157e);
        this.f8517a.k0(new c(bVarR, gVarL, mapC));
        return (Task) gVarL.a();
    }

    public String toString() {
        e eVarY = Y();
        if (eVarY == null) {
            return this.f8517a.toString();
        }
        try {
            return eVarY.toString() + "/" + URLEncoder.encode(X(), "UTF-8").replace("+", "%20");
        } catch (UnsupportedEncodingException e10) {
            throw new e8.d("Failed to URLEncode key: " + X(), e10);
        }
    }
}
