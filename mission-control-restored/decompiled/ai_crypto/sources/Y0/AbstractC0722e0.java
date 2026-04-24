package Y0;

import com.google.android.gms.internal.play_billing.zzbf;
import com.google.android.gms.internal.play_billing.zze;
import com.google.android.gms.internal.play_billing.zzjx;
import com.google.android.gms.internal.play_billing.zzjz;
import com.google.android.gms.internal.play_billing.zzkb;
import com.google.android.gms.internal.play_billing.zzkd;
import com.google.android.gms.internal.play_billing.zzke;
import com.google.android.gms.internal.play_billing.zzki;
import com.revenuecat.purchases.common.Constants;

/* JADX INFO: renamed from: Y0.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0722e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f5589a = 0;

    static {
        int i7 = InterfaceC0724f0.f5592a;
    }

    public static String a(Exception exc) {
        if (exc == null) {
            return null;
        }
        try {
            String str = exc.getClass().getSimpleName() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + zzbf.zzb(exc.getMessage());
            int i7 = zze.zza;
            return str.length() > 40 ? str.substring(0, 40) : str;
        } catch (Throwable th) {
            zze.zzm("BillingLogger", "Unable to get truncated exception info", th);
            return null;
        }
    }

    public static zzjz b(int i7, int i8, com.android.billingclient.api.d dVar) {
        try {
            zzjx zzjxVarZzc = zzjz.zzc();
            zzke zzkeVarZzc = zzki.zzc();
            zzkeVarZzc.zzn(dVar.b());
            zzkeVarZzc.zzm(dVar.a());
            zzkeVarZzc.zzo(i7);
            zzjxVarZzc.zza(zzkeVarZzc);
            zzjxVarZzc.zzn(i8);
            return (zzjz) zzjxVarZzc.zzf();
        } catch (Exception e7) {
            zze.zzm("BillingLogger", "Unable to create logging payload", e7);
            return null;
        }
    }

    public static zzjz c(int i7, int i8, com.android.billingclient.api.d dVar, String str) {
        try {
            zzke zzkeVarZzc = zzki.zzc();
            zzkeVarZzc.zzn(dVar.b());
            zzkeVarZzc.zzm(dVar.a());
            zzkeVarZzc.zzo(i7);
            if (str != null) {
                zzkeVarZzc.zza(str);
            }
            zzjx zzjxVarZzc = zzjz.zzc();
            zzjxVarZzc.zza(zzkeVarZzc);
            zzjxVarZzc.zzn(i8);
            return (zzjz) zzjxVarZzc.zzf();
        } catch (Throwable th) {
            zze.zzm("BillingLogger", "Unable to create logging payload", th);
            return null;
        }
    }

    public static zzkd d(int i7) {
        try {
            zzkb zzkbVarZzc = zzkd.zzc();
            zzkbVarZzc.zzn(i7);
            return (zzkd) zzkbVarZzc.zzf();
        } catch (Exception e7) {
            zze.zzm("BillingLogger", "Unable to create logging payload", e7);
            return null;
        }
    }
}
