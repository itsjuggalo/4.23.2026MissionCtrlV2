package H4;

import F4.K;
import F4.X;
import G4.S;
import G4.S0;
import java.util.ArrayList;
import java.util.List;
import u7.C2814g;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final J4.d f3758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final J4.d f3759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final J4.d f3760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final J4.d f3761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final J4.d f3762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final J4.d f3763f;

    static {
        C2814g c2814g = J4.d.f4575g;
        f3758a = new J4.d(c2814g, "https");
        f3759b = new J4.d(c2814g, "http");
        C2814g c2814g2 = J4.d.f4573e;
        f3760c = new J4.d(c2814g2, "POST");
        f3761d = new J4.d(c2814g2, "GET");
        f3762e = new J4.d(S.f2552j.d(), "application/grpc");
        f3763f = new J4.d("te", "trailers");
    }

    public static List a(List list, X x8) {
        byte[][] bArrD = S0.d(x8);
        for (int i8 = 0; i8 < bArrD.length; i8 += 2) {
            C2814g c2814gM = C2814g.M(bArrD[i8]);
            if (c2814gM.R() != 0 && c2814gM.k(0) != 58) {
                list.add(new J4.d(c2814gM, C2814g.M(bArrD[i8 + 1])));
            }
        }
        return list;
    }

    public static List b(X x8, String str, String str2, String str3, boolean z7, boolean z8) {
        AbstractC2848n.o(x8, "headers");
        AbstractC2848n.o(str, "defaultPath");
        AbstractC2848n.o(str2, "authority");
        c(x8);
        ArrayList arrayList = new ArrayList(K.a(x8) + 7);
        arrayList.add(z8 ? f3759b : f3758a);
        arrayList.add(z7 ? f3761d : f3760c);
        arrayList.add(new J4.d(J4.d.f4576h, str2));
        arrayList.add(new J4.d(J4.d.f4574f, str));
        arrayList.add(new J4.d(S.f2554l.d(), str3));
        arrayList.add(f3762e);
        arrayList.add(f3763f);
        return a(arrayList, x8);
    }

    public static void c(X x8) {
        x8.e(S.f2552j);
        x8.e(S.f2553k);
        x8.e(S.f2554l);
    }
}
