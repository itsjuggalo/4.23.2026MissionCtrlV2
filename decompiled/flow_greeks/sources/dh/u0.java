package dh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class u0 extends a2 {
    public abstract String Z(String str, String str2);

    public abstract String a0(bh.e eVar, int i10);

    @Override // dh.a2
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public final String W(bh.e eVar, int i10) {
        kotlin.jvm.internal.t.f(eVar, "<this>");
        return c0(a0(eVar, i10));
    }

    public final String c0(String nestedName) {
        kotlin.jvm.internal.t.f(nestedName, "nestedName");
        String str = (String) V();
        if (str == null) {
            str = "";
        }
        return Z(str, nestedName);
    }
}
