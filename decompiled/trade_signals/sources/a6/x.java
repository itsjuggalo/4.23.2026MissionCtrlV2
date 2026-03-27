package a6;

import i6.C1981l;
import i6.EnumC1979k;
import java.util.List;
import java.util.Map;
import p5.AbstractC2594p;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f10163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f10164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f10165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f10166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map f10167e;

    static {
        EnumC1080c enumC1080c = EnumC1080c.f10130d;
        EnumC1080c enumC1080c2 = EnumC1080c.f10128b;
        EnumC1080c enumC1080c3 = EnumC1080c.f10129c;
        List listL = AbstractC2595q.l(enumC1080c, enumC1080c2, enumC1080c3, EnumC1080c.f10132f, EnumC1080c.f10131e);
        f10163a = listL;
        List listE = AbstractC2594p.e(enumC1080c3);
        f10164b = listE;
        q6.c cVarK = J.k();
        EnumC1979k enumC1979k = EnumC1979k.f18897c;
        Map mapK = p5.M.k(o5.w.a(cVarK, new w(new C1981l(enumC1979k, false, 2, null), listL, false)), o5.w.a(J.i(), new w(new C1981l(enumC1979k, false, 2, null), listL, false)), o5.w.a(J.j(), new w(new C1981l(EnumC1979k.f18895a, false, 2, null), listL, false, 4, null)));
        f10165c = mapK;
        Map mapK2 = p5.M.k(o5.w.a(J.d(), new w(new C1981l(enumC1979k, false, 2, null), listE, false, 4, null)), o5.w.a(J.e(), new w(new C1981l(EnumC1979k.f18896b, false, 2, null), listE, false, 4, null)));
        f10166d = mapK2;
        f10167e = p5.M.o(mapK, mapK2);
    }

    public static final Map a() {
        return f10167e;
    }

    public static final Map b() {
        return f10165c;
    }
}
