package xe;

import xe.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w {
    public static final x a(v vVar, ef.b classId, df.e jvmMetadataVersion) {
        kotlin.jvm.internal.t.f(vVar, "<this>");
        kotlin.jvm.internal.t.f(classId, "classId");
        kotlin.jvm.internal.t.f(jvmMetadataVersion, "jvmMetadataVersion");
        v.a aVarA = vVar.a(classId, jvmMetadataVersion);
        if (aVarA != null) {
            return aVarA.a();
        }
        return null;
    }

    public static final x b(v vVar, ve.g javaClass, df.e jvmMetadataVersion) {
        kotlin.jvm.internal.t.f(vVar, "<this>");
        kotlin.jvm.internal.t.f(javaClass, "javaClass");
        kotlin.jvm.internal.t.f(jvmMetadataVersion, "jvmMetadataVersion");
        v.a aVarB = vVar.b(javaClass, jvmMetadataVersion);
        if (aVarB != null) {
            return aVarB.a();
        }
        return null;
    }
}
