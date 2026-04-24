package d7;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class B {
    public static final A b(Object obj) {
        if (obj == AbstractC1640a.f17040a) {
            throw new IllegalStateException("Does not contain segment".toString());
        }
        AbstractC2304t.d(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (A) obj;
    }

    public static final boolean c(Object obj) {
        return obj == AbstractC1640a.f17040a;
    }

    public static Object a(Object obj) {
        return obj;
    }
}
