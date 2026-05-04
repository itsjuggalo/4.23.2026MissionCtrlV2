package g6;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import io.flutter.plugins.firebase.auth.Constants;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a.g f10083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a.g f10084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a.AbstractC0094a f10085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a.AbstractC0094a f10086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Scope f10087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Scope f10088f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a f10089g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a f10090h;

    static {
        a.g gVar = new a.g();
        f10083a = gVar;
        a.g gVar2 = new a.g();
        f10084b = gVar2;
        b bVar = new b();
        f10085c = bVar;
        c cVar = new c();
        f10086d = cVar;
        f10087e = new Scope("profile");
        f10088f = new Scope(Constants.EMAIL);
        f10089g = new com.google.android.gms.common.api.a("SignIn.API", bVar, gVar);
        f10090h = new com.google.android.gms.common.api.a("SignIn.INTERNAL_API", cVar, gVar2);
    }
}
