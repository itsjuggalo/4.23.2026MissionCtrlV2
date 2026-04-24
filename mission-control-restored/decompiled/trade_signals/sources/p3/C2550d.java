package p3;

import h3.C1875k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import k3.AbstractC2271e;
import k3.AbstractC2279m;
import p3.C2549c;
import p3.InterfaceC2560n;

/* JADX INFO: renamed from: p3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2550d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f22275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f22276b;

    /* JADX INFO: renamed from: p3.d$a */
    public class a extends C2549c.AbstractC0375c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f22277a;

        public a(b bVar) {
            this.f22277a = bVar;
        }

        @Override // p3.C2549c.AbstractC0375c
        public void b(C2548b c2548b, InterfaceC2560n interfaceC2560n) {
            this.f22277a.q(c2548b);
            C2550d.f(interfaceC2560n, this.f22277a);
            this.f22277a.l();
        }
    }

    /* JADX INFO: renamed from: p3.d$b */
    public static class b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f22281d;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final InterfaceC0376d f22285h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public StringBuilder f22278a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Stack f22279b = new Stack();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f22280c = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f22282e = true;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List f22283f = new ArrayList();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final List f22284g = new ArrayList();

        public b(InterfaceC0376d interfaceC0376d) {
            this.f22285h = interfaceC0376d;
        }

        public final void g(StringBuilder sb, C2548b c2548b) {
            sb.append(AbstractC2279m.j(c2548b.b()));
        }

        public boolean h() {
            return this.f22278a != null;
        }

        public int i() {
            return this.f22278a.length();
        }

        public C1875k j() {
            return k(this.f22281d);
        }

        public final C1875k k(int i8) {
            C2548b[] c2548bArr = new C2548b[i8];
            for (int i9 = 0; i9 < i8; i9++) {
                c2548bArr[i9] = (C2548b) this.f22279b.get(i9);
            }
            return new C1875k(c2548bArr);
        }

        public final void l() {
            this.f22281d--;
            if (h()) {
                this.f22278a.append(")");
            }
            this.f22282e = true;
        }

        public final void m() {
            AbstractC2279m.g(h(), "Can't end range without starting a range!");
            for (int i8 = 0; i8 < this.f22281d; i8++) {
                this.f22278a.append(")");
            }
            this.f22278a.append(")");
            C1875k c1875kK = k(this.f22280c);
            this.f22284g.add(AbstractC2279m.i(this.f22278a.toString()));
            this.f22283f.add(c1875kK);
            this.f22278a = null;
        }

        public final void n() {
            if (h()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            this.f22278a = sb;
            sb.append("(");
            Iterator it = k(this.f22281d).iterator();
            while (it.hasNext()) {
                g(this.f22278a, (C2548b) it.next());
                this.f22278a.append(":(");
            }
            this.f22282e = false;
        }

        public final void o() {
            AbstractC2279m.g(this.f22281d == 0, "Can't finish hashing in the middle processing a child");
            if (h()) {
                m();
            }
            this.f22284g.add("");
        }

        public final void p(AbstractC2557k abstractC2557k) {
            n();
            this.f22280c = this.f22281d;
            this.f22278a.append(abstractC2557k.v(InterfaceC2560n.b.V2));
            this.f22282e = true;
            if (this.f22285h.a(this)) {
                m();
            }
        }

        public final void q(C2548b c2548b) {
            n();
            if (this.f22282e) {
                this.f22278a.append(com.amazon.a.a.o.b.f.f14100a);
            }
            g(this.f22278a, c2548b);
            this.f22278a.append(":(");
            if (this.f22281d == this.f22279b.size()) {
                this.f22279b.add(c2548b);
            } else {
                this.f22279b.set(this.f22281d, c2548b);
            }
            this.f22281d++;
            this.f22282e = false;
        }
    }

    /* JADX INFO: renamed from: p3.d$c */
    public static class c implements InterfaceC0376d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f22286a;

        public c(InterfaceC2560n interfaceC2560n) {
            this.f22286a = Math.max(512L, (long) Math.sqrt(AbstractC2271e.b(interfaceC2560n) * 100));
        }

        @Override // p3.C2550d.InterfaceC0376d
        public boolean a(b bVar) {
            return ((long) bVar.i()) > this.f22286a && (bVar.j().isEmpty() || !bVar.j().N().equals(C2548b.n()));
        }
    }

    /* JADX INFO: renamed from: p3.d$d, reason: collision with other inner class name */
    public interface InterfaceC0376d {
        boolean a(b bVar);
    }

    public C2550d(List list, List list2) {
        if (list.size() != list2.size() - 1) {
            throw new IllegalArgumentException("Number of posts need to be n-1 for n hashes in CompoundHash");
        }
        this.f22275a = list;
        this.f22276b = list2;
    }

    public static C2550d b(InterfaceC2560n interfaceC2560n) {
        return c(interfaceC2560n, new c(interfaceC2560n));
    }

    public static C2550d c(InterfaceC2560n interfaceC2560n, InterfaceC0376d interfaceC0376d) {
        if (interfaceC2560n.isEmpty()) {
            return new C2550d(Collections.emptyList(), Collections.singletonList(""));
        }
        b bVar = new b(interfaceC0376d);
        f(interfaceC2560n, bVar);
        bVar.o();
        return new C2550d(bVar.f22283f, bVar.f22284g);
    }

    public static void f(InterfaceC2560n interfaceC2560n, b bVar) {
        if (interfaceC2560n.x()) {
            bVar.p((AbstractC2557k) interfaceC2560n);
            return;
        }
        if (interfaceC2560n.isEmpty()) {
            throw new IllegalArgumentException("Can't calculate hash on empty node!");
        }
        if (interfaceC2560n instanceof C2549c) {
            ((C2549c) interfaceC2560n).I(new a(bVar), true);
            return;
        }
        throw new IllegalStateException("Expected children node, but got: " + interfaceC2560n);
    }

    public List d() {
        return Collections.unmodifiableList(this.f22276b);
    }

    public List e() {
        return Collections.unmodifiableList(this.f22275a);
    }
}
