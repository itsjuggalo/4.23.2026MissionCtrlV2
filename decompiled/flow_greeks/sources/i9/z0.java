package i9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class z0 implements e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f12233a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g8.e f12234b = new g8.e(Collections.EMPTY_LIST, e.f11901c);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12235c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.google.protobuf.i f12236d = m9.b1.f16123v;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b1 f12237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w0 f12238f;

    public z0(b1 b1Var, e9.j jVar) {
        this.f12237e = b1Var;
        this.f12238f = b1Var.d(jVar);
    }

    @Override // i9.e1
    public k9.g a(a7.s sVar, List list, List list2) {
        n9.b.d(!list2.isEmpty(), "Mutation batches should not be empty", new Object[0]);
        int i10 = this.f12235c;
        this.f12235c = i10 + 1;
        int size = this.f12233a.size();
        if (size > 0) {
            n9.b.d(((k9.g) this.f12233a.get(size - 1)).e() < i10, "Mutation batchIds must be monotonically increasing order", new Object[0]);
        }
        k9.g gVar = new k9.g(i10, sVar, list, list2);
        this.f12233a.add(gVar);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            k9.f fVar = (k9.f) it.next();
            this.f12234b = this.f12234b.e(new e(fVar.g(), i10));
            this.f12238f.l(fVar.g().o());
        }
        return gVar;
    }

    @Override // i9.e1
    public void b() {
        if (this.f12233a.isEmpty()) {
            n9.b.d(this.f12234b.isEmpty(), "Document leak -- detected dangling mutation references when queue is empty.", new Object[0]);
        }
    }

    @Override // i9.e1
    public void c(k9.g gVar) {
        n9.b.d(o(gVar.e(), "removed") == 0, "Can only remove the first entry of the mutation queue", new Object[0]);
        this.f12233a.remove(0);
        g8.e eVarG = this.f12234b;
        Iterator it = gVar.h().iterator();
        while (it.hasNext()) {
            j9.k kVarG = ((k9.f) it.next()).g();
            this.f12237e.g().n(kVarG);
            eVarG = eVarG.g(new e(kVarG, gVar.e()));
        }
        this.f12234b = eVarG;
    }

    @Override // i9.e1
    public List d(Iterable iterable) {
        g8.e eVar = new g8.e(Collections.EMPTY_LIST, n9.g0.g());
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            j9.k kVar = (j9.k) it.next();
            Iterator itF = this.f12234b.f(new e(kVar, 0));
            while (itF.hasNext()) {
                e eVar2 = (e) itF.next();
                if (!kVar.equals(eVar2.d())) {
                    break;
                }
                eVar = eVar.e(Integer.valueOf(eVar2.c()));
            }
        }
        return q(eVar);
    }

    @Override // i9.e1
    public void e(com.google.protobuf.i iVar) {
        this.f12236d = (com.google.protobuf.i) n9.x.b(iVar);
    }

    @Override // i9.e1
    public void f(k9.g gVar, com.google.protobuf.i iVar) {
        int iE = gVar.e();
        int iO = o(iE, "acknowledged");
        n9.b.d(iO == 0, "Can only acknowledge the first batch in the mutation queue", new Object[0]);
        k9.g gVar2 = (k9.g) this.f12233a.get(iO);
        n9.b.d(iE == gVar2.e(), "Queue ordering failure: expected batch %d, got batch %d", Integer.valueOf(iE), Integer.valueOf(gVar2.e()));
        this.f12236d = (com.google.protobuf.i) n9.x.b(iVar);
    }

    @Override // i9.e1
    public k9.g g(int i10) {
        int iN = n(i10 + 1);
        if (iN < 0) {
            iN = 0;
        }
        if (this.f12233a.size() > iN) {
            return (k9.g) this.f12233a.get(iN);
        }
        return null;
    }

    @Override // i9.e1
    public int h() {
        if (this.f12233a.isEmpty()) {
            return -1;
        }
        return this.f12235c - 1;
    }

    @Override // i9.e1
    public k9.g i(int i10) {
        int iN = n(i10);
        if (iN < 0 || iN >= this.f12233a.size()) {
            return null;
        }
        k9.g gVar = (k9.g) this.f12233a.get(iN);
        n9.b.d(gVar.e() == i10, "If found batch must match", new Object[0]);
        return gVar;
    }

    @Override // i9.e1
    public com.google.protobuf.i j() {
        return this.f12236d;
    }

    @Override // i9.e1
    public List k() {
        return Collections.unmodifiableList(this.f12233a);
    }

    public boolean l(j9.k kVar) {
        Iterator itF = this.f12234b.f(new e(kVar, 0));
        if (itF.hasNext()) {
            return ((e) itF.next()).d().equals(kVar);
        }
        return false;
    }

    public long m(p pVar) {
        Iterator it = this.f12233a.iterator();
        long jB = 0;
        while (it.hasNext()) {
            jB += (long) pVar.o((k9.g) it.next()).b();
        }
        return jB;
    }

    public final int n(int i10) {
        if (this.f12233a.isEmpty()) {
            return 0;
        }
        return i10 - ((k9.g) this.f12233a.get(0)).e();
    }

    public final int o(int i10, String str) {
        int iN = n(i10);
        n9.b.d(iN >= 0 && iN < this.f12233a.size(), "Batches must exist to be %s", str);
        return iN;
    }

    public boolean p() {
        return this.f12233a.isEmpty();
    }

    public final List q(g8.e eVar) {
        ArrayList arrayList = new ArrayList();
        Iterator it = eVar.iterator();
        while (it.hasNext()) {
            k9.g gVarI = i(((Integer) it.next()).intValue());
            if (gVarI != null) {
                arrayList.add(gVarI);
            }
        }
        return arrayList;
    }

    @Override // i9.e1
    public void start() {
        if (p()) {
            this.f12235c = 1;
        }
    }
}
