package O6;

import I6.S;
import J6.e;
import R5.m0;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0 f6243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final S f6244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final S f6245c;

    public d(m0 typeParameter, S inProjection, S outProjection) {
        AbstractC2304t.f(typeParameter, "typeParameter");
        AbstractC2304t.f(inProjection, "inProjection");
        AbstractC2304t.f(outProjection, "outProjection");
        this.f6243a = typeParameter;
        this.f6244b = inProjection;
        this.f6245c = outProjection;
    }

    public final S a() {
        return this.f6244b;
    }

    public final S b() {
        return this.f6245c;
    }

    public final m0 c() {
        return this.f6243a;
    }

    public final boolean d() {
        return e.f4643a.b(this.f6244b, this.f6245c);
    }
}
