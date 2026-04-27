package N2;

import K2.M;
import K2.Z;
import M2.S;
import M2.S0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final P2.d f2901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final P2.d f2902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final P2.d f2903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final P2.d f2904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final P2.d f2905e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final P2.d f2906f;

    static {
        O3.g gVar = P2.d.f3471g;
        f2901a = new P2.d(gVar, "https");
        f2902b = new P2.d(gVar, "http");
        O3.g gVar2 = P2.d.f3469e;
        f2903c = new P2.d(gVar2, "POST");
        f2904d = new P2.d(gVar2, "GET");
        f2905e = new P2.d(S.f1964j.d(), "application/grpc");
        f2906f = new P2.d("te", "trailers");
    }

    public static List a(List list, Z z4) {
        byte[][] bArrD = S0.d(z4);
        for (int i4 = 0; i4 < bArrD.length; i4 += 2) {
            O3.g gVarQ = O3.g.q(bArrD[i4]);
            if (gVarQ.v() != 0 && gVarQ.h(0) != 58) {
                list.add(new P2.d(gVarQ, O3.g.q(bArrD[i4 + 1])));
            }
        }
        return list;
    }

    public static List b(Z z4, String str, String str2, String str3, boolean z5, boolean z6) {
        Z1.m.o(z4, "headers");
        Z1.m.o(str, "defaultPath");
        Z1.m.o(str2, "authority");
        c(z4);
        ArrayList arrayList = new ArrayList(M.a(z4) + 7);
        if (z6) {
            arrayList.add(f2902b);
        } else {
            arrayList.add(f2901a);
        }
        if (z5) {
            arrayList.add(f2904d);
        } else {
            arrayList.add(f2903c);
        }
        arrayList.add(new P2.d(P2.d.f3472h, str2));
        arrayList.add(new P2.d(P2.d.f3470f, str));
        arrayList.add(new P2.d(S.f1966l.d(), str3));
        arrayList.add(f2905e);
        arrayList.add(f2906f);
        return a(arrayList, z4);
    }

    public static void c(Z z4) {
        z4.e(S.f1964j);
        z4.e(S.f1965k);
        z4.e(S.f1966l);
    }
}
