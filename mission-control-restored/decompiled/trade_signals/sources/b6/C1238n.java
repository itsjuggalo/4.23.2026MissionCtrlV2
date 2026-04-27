package b6;

import O5.o;
import h6.InterfaceC1892a;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.O;

/* JADX INFO: renamed from: b6.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1238n extends C1227c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ I5.m[] f13211h = {O.g(new G(C1238n.class, "allValueArguments", "getAllValueArguments()Ljava/util/Map;", 0))};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final H6.i f13212g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1238n(InterfaceC1892a annotation, d6.k c8) {
        super(c8, annotation, o.a.f6135H);
        AbstractC2304t.f(annotation, "annotation");
        AbstractC2304t.f(c8, "c");
        this.f13212g = c8.e().e(new C1237m(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.Map i(b6.C1238n r3) {
        /*
            h6.b r0 = r3.c()
            boolean r1 = r0 instanceof h6.InterfaceC1896e
            r2 = 0
            if (r1 == 0) goto L1a
            b6.f r0 = b6.C1230f.f13199a
            h6.b r3 = r3.c()
            h6.e r3 = (h6.InterfaceC1896e) r3
            java.util.List r3 = r3.e()
        L15:
            w6.g r3 = r0.d(r3)
            goto L2a
        L1a:
            boolean r0 = r0 instanceof h6.InterfaceC1904m
            if (r0 == 0) goto L29
            b6.f r0 = b6.C1230f.f13199a
            h6.b r3 = r3.c()
            java.util.List r3 = p5.AbstractC2594p.e(r3)
            goto L15
        L29:
            r3 = r2
        L2a:
            if (r3 == 0) goto L3a
            b6.d r0 = b6.C1228d.f13193a
            q6.f r0 = r0.d()
            o5.q r3 = o5.w.a(r0, r3)
            java.util.Map r2 = p5.L.e(r3)
        L3a:
            if (r2 != 0) goto L40
            java.util.Map r2 = p5.M.h()
        L40:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.C1238n.i(b6.n):java.util.Map");
    }

    @Override // b6.C1227c, S5.c
    public Map a() {
        return (Map) H6.m.a(this.f13212g, this, f13211h[0]);
    }
}
