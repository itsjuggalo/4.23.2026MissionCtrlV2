package i2;

import R1.a;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a.g f18772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a.g f18773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a.AbstractC0099a f18774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a.AbstractC0099a f18775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Scope f18776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Scope f18777f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final R1.a f18778g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final R1.a f18779h;

    static {
        a.g gVar = new a.g();
        f18772a = gVar;
        a.g gVar2 = new a.g();
        f18773b = gVar2;
        C1915b c1915b = new C1915b();
        f18774c = c1915b;
        c cVar = new c();
        f18775d = cVar;
        f18776e = new Scope("profile");
        f18777f = new Scope("email");
        f18778g = new R1.a("SignIn.API", c1915b, gVar);
        f18779h = new R1.a("SignIn.INTERNAL_API", cVar, gVar2);
    }
}
