package sg;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b0 {
    public static final a0 b(Object obj) {
        if (obj == a.f20376a) {
            throw new IllegalStateException("Does not contain segment");
        }
        kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (a0) obj;
    }

    public static final boolean c(Object obj) {
        return obj == a.f20376a;
    }

    public static Object a(Object obj) {
        return obj;
    }
}
