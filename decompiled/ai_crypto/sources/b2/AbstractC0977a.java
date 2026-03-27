package b2;

import android.app.Activity;
import c2.C1125a;
import com.google.android.gms.common.api.a;
import com.google.android.gms.internal.fido.zzaa;
import com.google.android.gms.internal.fido.zzab;

/* JADX INFO: renamed from: b2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0977a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a.g f8472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a f8473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zzaa f8474c;

    static {
        a.g gVar = new a.g();
        f8472a = gVar;
        f8473b = new com.google.android.gms.common.api.a("Fido.U2F_ZERO_PARTY_API", new zzab(), gVar);
        f8474c = new zzaa();
    }

    public static C1125a a(Activity activity) {
        return new C1125a(activity);
    }
}
