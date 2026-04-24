package b6;

import O5.o;
import h6.InterfaceC1892a;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.O;
import o5.w;
import p5.L;
import w6.x;

/* JADX INFO: renamed from: b6.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1232h extends C1227c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ I5.m[] f13203h = {O.g(new G(C1232h.class, "allValueArguments", "getAllValueArguments()Ljava/util/Map;", 0))};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final H6.i f13204g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1232h(InterfaceC1892a interfaceC1892a, d6.k c8) {
        super(c8, interfaceC1892a, o.a.f6210y);
        AbstractC2304t.f(c8, "c");
        this.f13204g = c8.e().e(C1231g.f13202a);
    }

    public static final Map i() {
        return L.e(w.a(C1228d.f13193a.b(), new x("Deprecated in Java")));
    }

    @Override // b6.C1227c, S5.c
    public Map a() {
        return (Map) H6.m.a(this.f13204g, this, f13203h[0]);
    }
}
