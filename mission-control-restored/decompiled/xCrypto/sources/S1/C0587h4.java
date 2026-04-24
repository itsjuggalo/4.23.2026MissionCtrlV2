package S1;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.measurement.zzdd;

/* JADX INFO: renamed from: S1.h4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0587h4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f4652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public zzdd f4654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f4655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f4656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f4657g;

    public C0587h4(Context context, zzdd zzddVar, Long l4) {
        this.f4655e = true;
        AbstractC0940s.k(context);
        Context applicationContext = context.getApplicationContext();
        AbstractC0940s.k(applicationContext);
        this.f4651a = applicationContext;
        this.f4656f = l4;
        if (zzddVar != null) {
            this.f4654d = zzddVar;
            this.f4655e = zzddVar.zzc;
            this.f4653c = zzddVar.zzb;
            this.f4657g = zzddVar.zze;
            Bundle bundle = zzddVar.zzd;
            if (bundle != null) {
                this.f4652b = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
