package r8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import r8.c;
import r8.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f19399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f19400b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends c.AbstractC0339c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f19401a;

        public a(b bVar) {
            this.f19401a = bVar;
        }

        @Override // r8.c.AbstractC0339c
        public void b(r8.b bVar, n nVar) {
            this.f19401a.q(bVar);
            d.f(nVar, this.f19401a);
            this.f19401a.l();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f19405d;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final InterfaceC0340d f19409h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public StringBuilder f19402a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Stack f19403b = new Stack();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19404c = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f19406e = true;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List f19407f = new ArrayList();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final List f19408g = new ArrayList();

        public b(InterfaceC0340d interfaceC0340d) {
            this.f19409h = interfaceC0340d;
        }

        public final void g(StringBuilder sb2, r8.b bVar) {
            sb2.append(m8.m.j(bVar.b()));
        }

        public boolean h() {
            return this.f19402a != null;
        }

        public int i() {
            return this.f19402a.length();
        }

        public j8.l j() {
            return k(this.f19405d);
        }

        public final j8.l k(int i10) {
            r8.b[] bVarArr = new r8.b[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                bVarArr[i11] = (r8.b) this.f19403b.get(i11);
            }
            return new j8.l(bVarArr);
        }

        public final void l() {
            this.f19405d--;
            if (h()) {
                this.f19402a.append(")");
            }
            this.f19406e = true;
        }

        public final void m() {
            m8.m.g(h(), "Can't end range without starting a range!");
            for (int i10 = 0; i10 < this.f19405d; i10++) {
                this.f19402a.append(")");
            }
            this.f19402a.append(")");
            j8.l lVarK = k(this.f19404c);
            this.f19408g.add(m8.m.i(this.f19402a.toString()));
            this.f19407f.add(lVarK);
            this.f19402a = null;
        }

        public final void n() {
            if (h()) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            this.f19402a = sb2;
            sb2.append("(");
            Iterator it = k(this.f19405d).iterator();
            while (it.hasNext()) {
                g(this.f19402a, (r8.b) it.next());
                this.f19402a.append(":(");
            }
            this.f19406e = false;
        }

        public final void o() {
            m8.m.g(this.f19405d == 0, "Can't finish hashing in the middle processing a child");
            if (h()) {
                m();
            }
            this.f19408g.add("");
        }

        public final void p(k kVar) {
            n();
            this.f19404c = this.f19405d;
            this.f19402a.append(kVar.C(n.b.V2));
            this.f19406e = true;
            if (this.f19409h.a(this)) {
                m();
            }
        }

        public final void q(r8.b bVar) {
            n();
            if (this.f19406e) {
                this.f19402a.append(com.amazon.a.a.o.b.f.f4598a);
            }
            g(this.f19402a, bVar);
            this.f19402a.append(":(");
            if (this.f19405d == this.f19403b.size()) {
                this.f19403b.add(bVar);
            } else {
                this.f19403b.set(this.f19405d, bVar);
            }
            this.f19405d++;
            this.f19406e = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c implements InterfaceC0340d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f19410a;

        public c(n nVar) {
            this.f19410a = Math.max(512L, (long) Math.sqrt(m8.e.b(nVar) * 100));
        }

        @Override // r8.d.InterfaceC0340d
        public boolean a(b bVar) {
            if (bVar.i() > this.f19410a) {
                return bVar.j().isEmpty() || !bVar.j().A().equals(r8.b.m());
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: r8.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface InterfaceC0340d {
        boolean a(b bVar);
    }

    public d(List list, List list2) {
        if (list.size() != list2.size() - 1) {
            throw new IllegalArgumentException("Number of posts need to be n-1 for n hashes in CompoundHash");
        }
        this.f19399a = list;
        this.f19400b = list2;
    }

    public static d b(n nVar) {
        return c(nVar, new c(nVar));
    }

    public static d c(n nVar, InterfaceC0340d interfaceC0340d) {
        if (nVar.isEmpty()) {
            return new d(Collections.EMPTY_LIST, Collections.singletonList(""));
        }
        b bVar = new b(interfaceC0340d);
        f(nVar, bVar);
        bVar.o();
        return new d(bVar.f19407f, bVar.f19408g);
    }

    public static void f(n nVar, b bVar) {
        if (nVar.J()) {
            bVar.p((k) nVar);
            return;
        }
        if (nVar.isEmpty()) {
            throw new IllegalArgumentException("Can't calculate hash on empty node!");
        }
        if (nVar instanceof r8.c) {
            ((r8.c) nVar).s(new a(bVar), true);
            return;
        }
        throw new IllegalStateException("Expected children node, but got: " + nVar);
    }

    public List d() {
        return Collections.unmodifiableList(this.f19400b);
    }

    public List e() {
        return Collections.unmodifiableList(this.f19399a);
    }
}
