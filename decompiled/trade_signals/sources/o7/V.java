package o7;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class V extends B0 {
    public abstract String Z(String str, String str2);

    public abstract String a0(m7.e eVar, int i8);

    @Override // o7.B0
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public final String W(m7.e eVar, int i8) {
        AbstractC2304t.f(eVar, "<this>");
        return c0(a0(eVar, i8));
    }

    public final String c0(String nestedName) {
        AbstractC2304t.f(nestedName, "nestedName");
        String str = (String) V();
        if (str == null) {
            str = "";
        }
        return Z(str, nestedName);
    }
}
