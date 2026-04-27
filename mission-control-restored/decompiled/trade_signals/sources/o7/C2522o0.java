package o7;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: o7.o0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2522o0 extends N {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22195c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2522o0(m7.e primitive) {
        super(primitive, null);
        AbstractC2304t.f(primitive, "primitive");
        this.f22195c = primitive.a() + "Array";
    }

    @Override // m7.e
    public String a() {
        return this.f22195c;
    }
}
