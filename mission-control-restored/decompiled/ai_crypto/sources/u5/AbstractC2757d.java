package u5;

import java.util.ArrayList;
import java.util.List;
import r5.M;
import r5.Z;
import t5.S;
import t5.S0;
import w5.C2781d;
import w6.C2795h;

/* JADX INFO: renamed from: u5.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2757d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2781d f24493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C2781d f24494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C2781d f24495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C2781d f24496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C2781d f24497e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C2781d f24498f;

    static {
        C2795h c2795h = C2781d.f24972g;
        f24493a = new C2781d(c2795h, "https");
        f24494b = new C2781d(c2795h, "http");
        C2795h c2795h2 = C2781d.f24970e;
        f24495c = new C2781d(c2795h2, "POST");
        f24496d = new C2781d(c2795h2, "GET");
        f24497e = new C2781d(S.f23515j.d(), "application/grpc");
        f24498f = new C2781d("te", "trailers");
    }

    public static List a(List list, Z z7) {
        byte[][] bArrD = S0.d(z7);
        for (int i7 = 0; i7 < bArrD.length; i7 += 2) {
            C2795h c2795hA = C2795h.A(bArrD[i7]);
            if (c2795hA.H() != 0 && c2795hA.l(0) != 58) {
                list.add(new C2781d(c2795hA, C2795h.A(bArrD[i7 + 1])));
            }
        }
        return list;
    }

    public static List b(Z z7, String str, String str2, String str3, boolean z8, boolean z9) {
        H2.m.o(z7, "headers");
        H2.m.o(str, "defaultPath");
        H2.m.o(str2, "authority");
        c(z7);
        ArrayList arrayList = new ArrayList(M.a(z7) + 7);
        if (z9) {
            arrayList.add(f24494b);
        } else {
            arrayList.add(f24493a);
        }
        if (z8) {
            arrayList.add(f24496d);
        } else {
            arrayList.add(f24495c);
        }
        arrayList.add(new C2781d(C2781d.f24973h, str2));
        arrayList.add(new C2781d(C2781d.f24971f, str));
        arrayList.add(new C2781d(S.f23517l.d(), str3));
        arrayList.add(f24497e);
        arrayList.add(f24498f);
        return a(arrayList, z7);
    }

    public static void c(Z z7) {
        z7.e(S.f23515j);
        z7.e(S.f23516k);
        z7.e(S.f23517l);
    }
}
