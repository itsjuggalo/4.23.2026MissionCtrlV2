package dh;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f8208a = c1.a();

    public static final bh.e a(String serialName, bh.d kind) {
        kotlin.jvm.internal.t.f(serialName, "serialName");
        kotlin.jvm.internal.t.f(kind, "kind");
        b(serialName);
        return new p1(serialName, kind);
    }

    public static final void b(String str) {
        for (zg.b bVar : f8208a.values()) {
            if (kotlin.jvm.internal.t.b(str, bVar.getDescriptor().i())) {
                throw new IllegalArgumentException(kg.s.i("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name " + str + " there already exists " + kotlin.jvm.internal.n0.b(bVar.getClass()).c() + ".\n                Please refer to SerialDescriptor documentation for additional information.\n            "));
            }
        }
    }
}
