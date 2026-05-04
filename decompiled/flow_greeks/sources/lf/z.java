package lf;

import fe.h0;
import java.util.List;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class z extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r0 f15678c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(List value, r0 type) {
        super(value, new y(type));
        kotlin.jvm.internal.t.f(value, "value");
        kotlin.jvm.internal.t.f(type, "type");
        this.f15678c = type;
    }

    public static final r0 c(r0 r0Var, h0 it) {
        kotlin.jvm.internal.t.f(it, "it");
        return r0Var;
    }

    public final r0 e() {
        return this.f15678c;
    }
}
