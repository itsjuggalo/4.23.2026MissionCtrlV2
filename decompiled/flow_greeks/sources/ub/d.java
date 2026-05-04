package ub;

import java.util.ArrayList;
import java.util.List;
import rb.m0;
import rb.y0;
import tb.r0;
import tb.r2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wb.d f22750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final wb.d f22751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final wb.d f22752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final wb.d f22753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final wb.d f22754e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final wb.d f22755f;

    static {
        hh.g gVar = wb.d.f23820g;
        f22750a = new wb.d(gVar, "https");
        f22751b = new wb.d(gVar, "http");
        hh.g gVar2 = wb.d.f23818e;
        f22752c = new wb.d(gVar2, "POST");
        f22753d = new wb.d(gVar2, "GET");
        f22754e = new wb.d(r0.f21633j.d(), "application/grpc");
        f22755f = new wb.d("te", "trailers");
    }

    public static List a(List list, y0 y0Var) {
        byte[][] bArrD = r2.d(y0Var);
        for (int i10 = 0; i10 < bArrD.length; i10 += 2) {
            hh.g gVarU = hh.g.u(bArrD[i10]);
            if (gVarU.B() != 0 && gVarU.h(0) != 58) {
                list.add(new wb.d(gVarU, hh.g.u(bArrD[i10 + 1])));
            }
        }
        return list;
    }

    public static List b(y0 y0Var, String str, String str2, String str3, boolean z10, boolean z11) {
        p6.n.o(y0Var, "headers");
        p6.n.o(str, "defaultPath");
        p6.n.o(str2, "authority");
        c(y0Var);
        ArrayList arrayList = new ArrayList(m0.a(y0Var) + 7);
        if (z11) {
            arrayList.add(f22751b);
        } else {
            arrayList.add(f22750a);
        }
        if (z10) {
            arrayList.add(f22753d);
        } else {
            arrayList.add(f22752c);
        }
        arrayList.add(new wb.d(wb.d.f23821h, str2));
        arrayList.add(new wb.d(wb.d.f23819f, str));
        arrayList.add(new wb.d(r0.f21635l.d(), str3));
        arrayList.add(f22754e);
        arrayList.add(f22755f);
        return a(arrayList, y0Var);
    }

    public static void c(y0 y0Var) {
        y0Var.e(r0.f21633j);
        y0Var.e(r0.f21634k);
        y0Var.e(r0.f21635l);
    }
}
