package k9;

import a7.s;
import bb.b;
import bb.d0;
import j9.y;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f14769a;

    /* JADX INFO: renamed from: k9.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0254a extends a {
        public C0254a(List list) {
            super(list);
        }

        @Override // k9.a
        public d0 d(d0 d0Var) {
            b.C0055b c0055bE = a.e(d0Var);
            for (d0 d0Var2 : f()) {
                int i10 = 0;
                while (i10 < c0055bE.A()) {
                    if (y.r(c0055bE.z(i10), d0Var2)) {
                        c0055bE.B(i10);
                    } else {
                        i10++;
                    }
                }
            }
            return (d0) d0.y0().y(c0055bE).n();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends a {
        public b(List list) {
            super(list);
        }

        @Override // k9.a
        public d0 d(d0 d0Var) {
            b.C0055b c0055bE = a.e(d0Var);
            for (d0 d0Var2 : f()) {
                if (!y.q(c0055bE, d0Var2)) {
                    c0055bE.y(d0Var2);
                }
            }
            return (d0) d0.y0().y(c0055bE).n();
        }
    }

    public a(List list) {
        this.f14769a = Collections.unmodifiableList(list);
    }

    public static b.C0055b e(d0 d0Var) {
        return y.u(d0Var) ? (b.C0055b) d0Var.l0().Y() : bb.b.j0();
    }

    @Override // k9.p
    public d0 a(d0 d0Var) {
        return null;
    }

    @Override // k9.p
    public d0 b(d0 d0Var, d0 d0Var2) {
        return d(d0Var);
    }

    @Override // k9.p
    public d0 c(d0 d0Var, s sVar) {
        return d(d0Var);
    }

    public abstract d0 d(d0 d0Var);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f14769a.equals(((a) obj).f14769a);
    }

    public List f() {
        return this.f14769a;
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.f14769a.hashCode();
    }
}
