package r8;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public interface n extends Comparable, Iterable {
    public static final c P = new a();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum b {
        V1,
        V2
    }

    String C(b bVar);

    n D(n nVar);

    boolean F(r8.b bVar);

    n I(j8.l lVar, n nVar);

    boolean J();

    Object N(boolean z10);

    n O(j8.l lVar);

    Iterator P();

    String Q();

    Object getValue();

    boolean isEmpty();

    int j();

    n n();

    n t(r8.b bVar, n nVar);

    r8.b x(r8.b bVar);

    n z(r8.b bVar);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends c {
        @Override // r8.c, r8.n
        public boolean F(r8.b bVar) {
            return false;
        }

        @Override // r8.c, java.lang.Comparable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(n nVar) {
            return nVar == this ? 0 : 1;
        }

        @Override // r8.c
        public boolean equals(Object obj) {
            return obj == this;
        }

        @Override // r8.c, r8.n
        public boolean isEmpty() {
            return false;
        }

        @Override // r8.c
        public String toString() {
            return "<Max Node>";
        }

        @Override // r8.c, r8.n
        public n z(r8.b bVar) {
            return bVar.s() ? n() : g.y();
        }

        @Override // r8.c, r8.n
        public n n() {
            return this;
        }
    }
}
