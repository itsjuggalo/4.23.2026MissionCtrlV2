package J5;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(IllegalAccessException cause) {
        super(cause);
        AbstractC2304t.f(cause, "cause");
    }
}
