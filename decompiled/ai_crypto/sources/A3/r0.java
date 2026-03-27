package A3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class r0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r0 f218c = new r0(false, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r0 f219d = new r0(true, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H3.d f221b;

    public r0(boolean z7, H3.d dVar) {
        K3.z.a(dVar == null || z7, "Cannot specify a fieldMask for non-merge sets()", new Object[0]);
        this.f220a = z7;
        this.f221b = dVar;
    }

    public static r0 c() {
        return f219d;
    }

    public static r0 d(List list) {
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(((C0419t) it.next()).c());
        }
        return new r0(true, H3.d.b(hashSet));
    }

    public H3.d a() {
        return this.f221b;
    }

    public boolean b() {
        return this.f220a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r0.class != obj.getClass()) {
            return false;
        }
        r0 r0Var = (r0) obj;
        if (this.f220a != r0Var.f220a) {
            return false;
        }
        H3.d dVar = this.f221b;
        H3.d dVar2 = r0Var.f221b;
        return dVar != null ? dVar.equals(dVar2) : dVar2 == null;
    }

    public int hashCode() {
        int i7 = (this.f220a ? 1 : 0) * 31;
        H3.d dVar = this.f221b;
        return i7 + (dVar != null ? dVar.hashCode() : 0);
    }
}
