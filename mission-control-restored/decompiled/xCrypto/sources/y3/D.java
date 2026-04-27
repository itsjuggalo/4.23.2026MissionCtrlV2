package y3;

/* JADX INFO: loaded from: classes3.dex */
public abstract class D {
    public static final C b(Object obj) {
        if (obj == AbstractC1950d.f15977a) {
            throw new IllegalStateException("Does not contain segment");
        }
        kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (C) obj;
    }

    public static final boolean c(Object obj) {
        return obj == AbstractC1950d.f15977a;
    }

    public static Object a(Object obj) {
        return obj;
    }
}
