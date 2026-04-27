package j6;

import h6.InterfaceC1898g;
import j6.InterfaceC2258v;
import kotlin.jvm.internal.AbstractC2304t;
import p6.C2602e;

/* JADX INFO: renamed from: j6.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2259w {
    public static final InterfaceC2260x a(InterfaceC2258v interfaceC2258v, InterfaceC1898g javaClass, C2602e jvmMetadataVersion) {
        AbstractC2304t.f(interfaceC2258v, "<this>");
        AbstractC2304t.f(javaClass, "javaClass");
        AbstractC2304t.f(jvmMetadataVersion, "jvmMetadataVersion");
        InterfaceC2258v.a aVarB = interfaceC2258v.b(javaClass, jvmMetadataVersion);
        if (aVarB != null) {
            return aVarB.a();
        }
        return null;
    }

    public static final InterfaceC2260x b(InterfaceC2258v interfaceC2258v, q6.b classId, C2602e jvmMetadataVersion) {
        AbstractC2304t.f(interfaceC2258v, "<this>");
        AbstractC2304t.f(classId, "classId");
        AbstractC2304t.f(jvmMetadataVersion, "jvmMetadataVersion");
        InterfaceC2258v.a aVarC = interfaceC2258v.c(classId, jvmMetadataVersion);
        if (aVarC != null) {
            return aVarC.a();
        }
        return null;
    }
}
