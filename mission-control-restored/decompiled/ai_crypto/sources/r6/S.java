package r6;

/* JADX INFO: loaded from: classes2.dex */
public abstract class S extends p0 {
    public abstract String Z(String str, String str2);

    public String a0(p6.e descriptor, int i7) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return descriptor.g(i7);
    }

    @Override // r6.p0
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public final String V(p6.e eVar, int i7) {
        kotlin.jvm.internal.r.f(eVar, "<this>");
        return c0(a0(eVar, i7));
    }

    public final String c0(String nestedName) {
        kotlin.jvm.internal.r.f(nestedName, "nestedName");
        String str = (String) U();
        if (str == null) {
            str = "";
        }
        return Z(str, nestedName);
    }
}
