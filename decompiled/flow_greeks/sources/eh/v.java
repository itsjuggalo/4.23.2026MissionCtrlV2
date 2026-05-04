package eh;

import fh.z0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bh.e f9028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9029c;

    public /* synthetic */ v(Object obj, boolean z10, bh.e eVar, int i10, kotlin.jvm.internal.k kVar) {
        this(obj, z10, (i10 & 4) != 0 ? null : eVar);
    }

    @Override // eh.e0
    public String a() {
        return this.f9029c;
    }

    @Override // eh.e0
    public boolean c() {
        return this.f9027a;
    }

    public final bh.e e() {
        return this.f9028b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || v.class != obj.getClass()) {
            return false;
        }
        v vVar = (v) obj;
        return c() == vVar.c() && kotlin.jvm.internal.t.b(a(), vVar.a());
    }

    public int hashCode() {
        return (Boolean.hashCode(c()) * 31) + a().hashCode();
    }

    @Override // eh.e0
    public String toString() {
        if (!c()) {
            return a();
        }
        StringBuilder sb2 = new StringBuilder();
        z0.c(sb2, a());
        String string = sb2.toString();
        kotlin.jvm.internal.t.e(string, "toString(...)");
        return string;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(Object body, boolean z10, bh.e eVar) {
        super(null);
        kotlin.jvm.internal.t.f(body, "body");
        this.f9027a = z10;
        this.f9028b = eVar;
        this.f9029c = body.toString();
        if (eVar != null && !eVar.isInline()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }
}
