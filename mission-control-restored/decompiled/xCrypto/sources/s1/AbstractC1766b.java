package s1;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.tasks.Task;

/* JADX INFO: renamed from: s1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1766b extends e {
    private static final a.g zza;
    private static final a.AbstractC0145a zzb;
    private static final com.google.android.gms.common.api.a zzc;

    static {
        a.g gVar = new a.g();
        zza = gVar;
        C1767c c1767c = new C1767c();
        zzb = c1767c;
        zzc = new com.google.android.gms.common.api.a("SmsRetriever.API", c1767c, gVar);
    }

    public AbstractC1766b(Activity activity) {
        super(activity, zzc, (a.d) a.d.f9667K, e.a.f9668c);
    }

    public abstract Task startSmsRetriever();

    public AbstractC1766b(Context context) {
        super(context, zzc, a.d.f9667K, e.a.f9668c);
    }
}
