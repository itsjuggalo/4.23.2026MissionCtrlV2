package dg;

import fe.l1;
import kotlin.jvm.internal.t;
import xf.r0;
import yf.e;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l1 f8117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r0 f8118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r0 f8119c;

    public d(l1 typeParameter, r0 inProjection, r0 outProjection) {
        t.f(typeParameter, "typeParameter");
        t.f(inProjection, "inProjection");
        t.f(outProjection, "outProjection");
        this.f8117a = typeParameter;
        this.f8118b = inProjection;
        this.f8119c = outProjection;
    }

    public final r0 a() {
        return this.f8118b;
    }

    public final r0 b() {
        return this.f8119c;
    }

    public final l1 c() {
        return this.f8117a;
    }

    public final boolean d() {
        return e.f25402a.c(this.f8118b, this.f8119c);
    }
}
