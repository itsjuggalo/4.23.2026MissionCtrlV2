package e6;

import com.google.android.gms.common.api.a;
import com.google.android.gms.internal.location.zzaf;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zzbi;
import com.google.android.gms.internal.location.zzz;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a f8419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f8420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g f8421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final p f8422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a.g f8423e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a.AbstractC0094a f8424f;

    static {
        a.g gVar = new a.g();
        f8423e = gVar;
        g0 g0Var = new g0();
        f8424f = g0Var;
        f8419a = new com.google.android.gms.common.api.a("LocationServices.API", g0Var, gVar);
        f8420b = new zzz();
        f8421c = new zzaf();
        f8422d = new zzbi();
    }

    public static zzaz a(com.google.android.gms.common.api.g gVar) {
        com.google.android.gms.common.internal.s.b(gVar != null, "GoogleApiClient parameter is required.");
        zzaz zzazVar = (zzaz) gVar.d(f8423e);
        com.google.android.gms.common.internal.s.o(zzazVar != null, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return zzazVar;
    }
}
