package q7;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: q7.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2657o extends C2656n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f22900c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2657o(A writer, boolean z7) {
        super(writer);
        AbstractC2304t.f(writer, "writer");
        this.f22900c = z7;
    }

    @Override // q7.C2656n
    public void n(String value) {
        AbstractC2304t.f(value, "value");
        if (this.f22900c) {
            super.n(value);
        } else {
            super.k(value);
        }
    }
}
