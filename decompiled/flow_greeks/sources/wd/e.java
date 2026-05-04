package wd;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e {
    public static final Object a(d dVar, Object obj) {
        kotlin.jvm.internal.t.f(dVar, "<this>");
        if (dVar.l(obj)) {
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast");
            return obj;
        }
        throw new ClassCastException("Value cannot be cast to " + dVar.b());
    }
}
