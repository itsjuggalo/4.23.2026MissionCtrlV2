package h3;

import java.util.HashMap;
import java.util.Map;
import p3.C2548b;
import p3.C2549c;
import p3.InterfaceC2560n;

/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterfaceC2560n f18590a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f18591b = null;

    public class a extends C2549c.AbstractC0375c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C1875k f18592a;

        public a(C1875k c1875k) {
            this.f18592a = c1875k;
        }

        @Override // p3.C2549c.AbstractC0375c
        public void b(C2548b c2548b, InterfaceC2560n interfaceC2560n) {
            u.this.d(this.f18592a.K(c2548b), interfaceC2560n);
        }
    }

    public class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C1875k f18594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f18595b;

        public b(C1875k c1875k, d dVar) {
            this.f18594a = c1875k;
            this.f18595b = dVar;
        }

        @Override // h3.u.c
        public void a(C2548b c2548b, u uVar) {
            uVar.b(this.f18594a.K(c2548b), this.f18595b);
        }
    }

    public interface c {
        void a(C2548b c2548b, u uVar);
    }

    public interface d {
        void a(C1875k c1875k, InterfaceC2560n interfaceC2560n);
    }

    public void a(c cVar) {
        Map map = this.f18591b;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                cVar.a((C2548b) entry.getKey(), (u) entry.getValue());
            }
        }
    }

    public void b(C1875k c1875k, d dVar) {
        InterfaceC2560n interfaceC2560n = this.f18590a;
        if (interfaceC2560n != null) {
            dVar.a(c1875k, interfaceC2560n);
        } else {
            a(new b(c1875k, dVar));
        }
    }

    public boolean c(C1875k c1875k) {
        if (c1875k.isEmpty()) {
            this.f18590a = null;
            this.f18591b = null;
            return true;
        }
        InterfaceC2560n interfaceC2560n = this.f18590a;
        if (interfaceC2560n != null) {
            if (interfaceC2560n.x()) {
                return false;
            }
            C2549c c2549c = (C2549c) this.f18590a;
            this.f18590a = null;
            c2549c.H(new a(c1875k));
            return c(c1875k);
        }
        if (this.f18591b == null) {
            return true;
        }
        C2548b c2548bP = c1875k.P();
        C1875k c1875kS = c1875k.S();
        if (this.f18591b.containsKey(c2548bP) && ((u) this.f18591b.get(c2548bP)).c(c1875kS)) {
            this.f18591b.remove(c2548bP);
        }
        if (!this.f18591b.isEmpty()) {
            return false;
        }
        this.f18591b = null;
        return true;
    }

    public void d(C1875k c1875k, InterfaceC2560n interfaceC2560n) {
        if (c1875k.isEmpty()) {
            this.f18590a = interfaceC2560n;
            this.f18591b = null;
            return;
        }
        InterfaceC2560n interfaceC2560n2 = this.f18590a;
        if (interfaceC2560n2 != null) {
            this.f18590a = interfaceC2560n2.y(c1875k, interfaceC2560n);
            return;
        }
        if (this.f18591b == null) {
            this.f18591b = new HashMap();
        }
        C2548b c2548bP = c1875k.P();
        if (!this.f18591b.containsKey(c2548bP)) {
            this.f18591b.put(c2548bP, new u());
        }
        ((u) this.f18591b.get(c2548bP)).d(c1875k.S(), interfaceC2560n);
    }
}
