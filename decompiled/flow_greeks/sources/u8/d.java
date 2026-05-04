package u8;

import kotlin.jvm.internal.t;
import p1.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static final Object a(f fVar, f.a key, Object obj) {
        t.f(fVar, "<this>");
        t.f(key, "key");
        Object objB = fVar.b(key);
        return objB == null ? obj : objB;
    }
}
