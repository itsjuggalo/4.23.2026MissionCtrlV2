package U1;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import io.flutter.plugins.firebase.auth.Constants;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a.g f5259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a.g f5260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a.AbstractC0145a f5261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a.AbstractC0145a f5262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Scope f5263e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Scope f5264f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a f5265g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a f5266h;

    static {
        a.g gVar = new a.g();
        f5259a = gVar;
        a.g gVar2 = new a.g();
        f5260b = gVar2;
        b bVar = new b();
        f5261c = bVar;
        c cVar = new c();
        f5262d = cVar;
        f5263e = new Scope("profile");
        f5264f = new Scope(Constants.EMAIL);
        f5265g = new com.google.android.gms.common.api.a("SignIn.API", bVar, gVar);
        f5266h = new com.google.android.gms.common.api.a("SignIn.INTERNAL_API", cVar, gVar2);
    }
}
