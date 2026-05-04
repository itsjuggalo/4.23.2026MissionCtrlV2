package y5;

import android.app.Activity;
import com.google.android.gms.common.api.a;
import com.google.android.gms.internal.fido.zzaa;
import com.google.android.gms.internal.fido.zzab;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a.g f25291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a f25292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zzaa f25293c;

    static {
        a.g gVar = new a.g();
        f25291a = gVar;
        f25292b = new com.google.android.gms.common.api.a("Fido.U2F_ZERO_PARTY_API", new zzab(), gVar);
        f25293c = new zzaa();
    }

    public static z5.a a(Activity activity) {
        return new z5.a(activity);
    }
}
