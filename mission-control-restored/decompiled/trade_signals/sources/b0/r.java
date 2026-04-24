package b0;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class r extends I {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f12809b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(Throwable finalException) {
        super(Integer.MAX_VALUE, null);
        AbstractC2304t.f(finalException, "finalException");
        this.f12809b = finalException;
    }

    public final Throwable b() {
        return this.f12809b;
    }
}
