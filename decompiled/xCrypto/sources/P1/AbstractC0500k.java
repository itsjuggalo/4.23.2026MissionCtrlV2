package P1;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.location.zzaf;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zzbi;
import com.google.android.gms.internal.location.zzz;

/* JADX INFO: renamed from: P1.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0500k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a f3426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final InterfaceC0494e f3427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final InterfaceC0496g f3428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final InterfaceC0505p f3429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a.g f3430e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a.AbstractC0145a f3431f;

    static {
        a.g gVar = new a.g();
        f3430e = gVar;
        G g4 = new G();
        f3431f = g4;
        f3426a = new com.google.android.gms.common.api.a("LocationServices.API", g4, gVar);
        f3427b = new zzz();
        f3428c = new zzaf();
        f3429d = new zzbi();
    }

    public static zzaz a(com.google.android.gms.common.api.f fVar) {
        AbstractC0940s.b(fVar != null, "GoogleApiClient parameter is required.");
        zzaz zzazVar = (zzaz) fVar.d(f3430e);
        AbstractC0940s.o(zzazVar != null, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return zzazVar;
    }
}
