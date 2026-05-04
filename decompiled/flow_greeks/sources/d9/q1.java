package d9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class q1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q1 f7920c = new q1(false, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q1 f7921d = new q1(true, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k9.d f7923b;

    public q1(boolean z10, k9.d dVar) {
        n9.x.a(dVar == null || z10, "Cannot specify a fieldMask for non-merge sets()", new Object[0]);
        this.f7922a = z10;
        this.f7923b = dVar;
    }

    public static q1 c() {
        return f7921d;
    }

    public static q1 d(List list) {
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(((t) it.next()).c());
        }
        return new q1(true, k9.d.b(hashSet));
    }

    public k9.d a() {
        return this.f7923b;
    }

    public boolean b() {
        return this.f7922a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && q1.class == obj.getClass()) {
            q1 q1Var = (q1) obj;
            if (this.f7922a != q1Var.f7922a) {
                return false;
            }
            k9.d dVar = this.f7923b;
            k9.d dVar2 = q1Var.f7923b;
            if (dVar != null) {
                return dVar.equals(dVar2);
            }
            if (dVar2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i10 = (this.f7922a ? 1 : 0) * 31;
        k9.d dVar = this.f7923b;
        return i10 + (dVar != null ? dVar.hashCode() : 0);
    }
}
