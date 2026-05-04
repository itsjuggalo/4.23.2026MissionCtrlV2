package r8;

import java.util.Collections;
import java.util.Iterator;
import r8.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g extends c implements n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g f19413e = new g();

    public static g y() {
        return f19413e;
    }

    @Override // r8.c, r8.n
    public String C(n.b bVar) {
        return "";
    }

    @Override // r8.c, r8.n
    public boolean F(b bVar) {
        return false;
    }

    @Override // r8.c, r8.n
    public n I(j8.l lVar, n nVar) {
        if (lVar.isEmpty()) {
            return nVar;
        }
        b bVarK = lVar.K();
        return t(bVarK, z(bVarK).I(lVar.S(), nVar));
    }

    @Override // r8.c, r8.n
    public boolean J() {
        return false;
    }

    @Override // r8.c, r8.n
    public Object N(boolean z10) {
        return null;
    }

    @Override // r8.c, r8.n
    public Iterator P() {
        return Collections.EMPTY_LIST.iterator();
    }

    @Override // r8.c, r8.n
    public String Q() {
        return "";
    }

    @Override // r8.c, java.lang.Comparable
    /* JADX INFO: renamed from: c */
    public int compareTo(n nVar) {
        return nVar.isEmpty() ? 0 : -1;
    }

    @Override // r8.c
    public boolean equals(Object obj) {
        if (obj instanceof g) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return nVar.isEmpty() && n().equals(nVar.n());
    }

    @Override // r8.c, r8.n
    public Object getValue() {
        return null;
    }

    @Override // r8.c
    public int hashCode() {
        return 0;
    }

    @Override // r8.c, r8.n
    public boolean isEmpty() {
        return true;
    }

    @Override // r8.c, java.lang.Iterable
    public Iterator iterator() {
        return Collections.EMPTY_LIST.iterator();
    }

    @Override // r8.c, r8.n
    public int j() {
        return 0;
    }

    @Override // r8.c, r8.n
    public n t(b bVar, n nVar) {
        return (nVar.isEmpty() || bVar.s()) ? this : new c().t(bVar, nVar);
    }

    @Override // r8.c
    public String toString() {
        return "<Empty Node>";
    }

    @Override // r8.c, r8.n
    public b x(b bVar) {
        return null;
    }

    @Override // r8.c, r8.n
    public n n() {
        return this;
    }

    @Override // r8.c, r8.n
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public g D(n nVar) {
        return this;
    }

    @Override // r8.c, r8.n
    public n O(j8.l lVar) {
        return this;
    }

    @Override // r8.c, r8.n
    public n z(b bVar) {
        return this;
    }
}
