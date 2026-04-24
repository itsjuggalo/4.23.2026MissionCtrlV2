package b0;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: b0.B, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1168B extends I {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f12549b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1168B(Throwable readException, int i8) {
        super(i8, null);
        AbstractC2304t.f(readException, "readException");
        this.f12549b = readException;
    }

    public final Throwable b() {
        return this.f12549b;
    }
}
