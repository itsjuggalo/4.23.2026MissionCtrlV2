package k2;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a.g f17566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a.g f17567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a.AbstractC0178a f17568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a.AbstractC0178a f17569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Scope f17570e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Scope f17571f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a f17572g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a f17573h;

    static {
        a.g gVar = new a.g();
        f17566a = gVar;
        a.g gVar2 = new a.g();
        f17567b = gVar2;
        C2067b c2067b = new C2067b();
        f17568c = c2067b;
        C2068c c2068c = new C2068c();
        f17569d = c2068c;
        f17570e = new Scope("profile");
        f17571f = new Scope("email");
        f17572g = new com.google.android.gms.common.api.a("SignIn.API", c2067b, gVar);
        f17573h = new com.google.android.gms.common.api.a("SignIn.INTERNAL_API", c2068c, gVar2);
    }
}
