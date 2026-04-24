package o7;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class U extends A0 {
    public abstract String e0(String str, String str2);

    public String f0(m7.e descriptor, int i8) {
        AbstractC2304t.f(descriptor, "descriptor");
        return descriptor.f(i8);
    }

    @Override // o7.A0
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public final String Z(m7.e eVar, int i8) {
        AbstractC2304t.f(eVar, "<this>");
        return h0(f0(eVar, i8));
    }

    public final String h0(String nestedName) {
        AbstractC2304t.f(nestedName, "nestedName");
        String str = (String) Y();
        if (str == null) {
            str = "";
        }
        return e0(str, nestedName);
    }

    public final String i0() {
        return a0().isEmpty() ? "$" : p5.z.h0(a0(), ".", "$.", null, 0, null, null, 60, null);
    }
}
