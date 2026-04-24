package i2;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.measurement.zzdd;

/* JADX INFO: renamed from: i2.h4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1827h4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f15811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f15812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public zzdd f15813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f15814e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f15815f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f15816g;

    public C1827h4(Context context, zzdd zzddVar, Long l7) {
        this.f15814e = true;
        AbstractC1207s.k(context);
        Context applicationContext = context.getApplicationContext();
        AbstractC1207s.k(applicationContext);
        this.f15810a = applicationContext;
        this.f15815f = l7;
        if (zzddVar != null) {
            this.f15813d = zzddVar;
            this.f15814e = zzddVar.zzc;
            this.f15812c = zzddVar.zzb;
            this.f15816g = zzddVar.zze;
            Bundle bundle = zzddVar.zzd;
            if (bundle != null) {
                this.f15811b = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
