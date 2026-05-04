package dh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class t0 extends z1 {
    public abstract String e0(String str, String str2);

    public String f0(bh.e descriptor, int i10) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        return descriptor.m(i10);
    }

    @Override // dh.z1
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public final String Z(bh.e eVar, int i10) {
        kotlin.jvm.internal.t.f(eVar, "<this>");
        return h0(f0(eVar, i10));
    }

    public final String h0(String nestedName) {
        kotlin.jvm.internal.t.f(nestedName, "nestedName");
        String str = (String) Y();
        if (str == null) {
            str = "";
        }
        return e0(str, nestedName);
    }

    public final String i0() {
        return a0().isEmpty() ? "$" : dd.a0.i0(a0(), ".", "$.", null, 0, null, null, 60, null);
    }
}
