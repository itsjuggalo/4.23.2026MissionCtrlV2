package X5;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends AbstractC0992h implements h6.o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f9450c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(q6.f fVar, Object value) {
        super(fVar, null);
        AbstractC2304t.f(value, "value");
        this.f9450c = value;
    }

    @Override // h6.o
    public Object getValue() {
        return this.f9450c;
    }
}
