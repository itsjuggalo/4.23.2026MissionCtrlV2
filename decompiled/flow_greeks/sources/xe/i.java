package xe;

import fe.m0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i {
    public static final h a(fe.h0 module, m0 notFoundClasses, wf.n storageManager, v kotlinClassFinder, df.e jvmMetadataVersion) {
        kotlin.jvm.internal.t.f(module, "module");
        kotlin.jvm.internal.t.f(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        kotlin.jvm.internal.t.f(kotlinClassFinder, "kotlinClassFinder");
        kotlin.jvm.internal.t.f(jvmMetadataVersion, "jvmMetadataVersion");
        h hVar = new h(module, notFoundClasses, storageManager, kotlinClassFinder);
        hVar.S(jvmMetadataVersion);
        return hVar;
    }
}
