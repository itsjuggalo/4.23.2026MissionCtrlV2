package H0;

import android.content.Context;
import com.google.android.gms.internal.play_billing.zze;
import com.google.android.gms.internal.play_billing.zzjz;
import com.google.android.gms.internal.play_billing.zzkd;
import com.google.android.gms.internal.play_billing.zzkl;
import com.google.android.gms.internal.play_billing.zzks;
import com.google.android.gms.internal.play_billing.zzku;
import com.google.android.gms.internal.play_billing.zzli;
import com.google.android.gms.internal.play_billing.zzlk;
import com.google.android.gms.internal.play_billing.zzlq;
import com.google.android.gms.internal.play_billing.zzlu;

/* JADX INFO: loaded from: classes.dex */
public final class i0 implements InterfaceC0303f0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zzku f668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k0 f669c;

    public i0(Context context, zzku zzkuVar) {
        this.f669c = new k0(context);
        this.f668b = zzkuVar;
    }

    @Override // H0.InterfaceC0303f0
    public final void a(zzkl zzklVar) {
        try {
            zzli zzliVarZzc = zzlk.zzc();
            zzliVarZzc.zzo(this.f668b);
            zzliVarZzc.zzn(zzklVar);
            this.f669c.a((zzlk) zzliVarZzc.zzf());
        } catch (Throwable th) {
            zze.zzm("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // H0.InterfaceC0303f0
    public final void b(zzlu zzluVar) {
        if (zzluVar == null) {
            return;
        }
        try {
            zzli zzliVarZzc = zzlk.zzc();
            zzliVarZzc.zzo(this.f668b);
            zzliVarZzc.zzq(zzluVar);
            this.f669c.a((zzlk) zzliVarZzc.zzf());
        } catch (Throwable th) {
            zze.zzm("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // H0.InterfaceC0303f0
    public final void c(zzlq zzlqVar) {
        try {
            k0 k0Var = this.f669c;
            zzli zzliVarZzc = zzlk.zzc();
            zzliVarZzc.zzo(this.f668b);
            zzliVarZzc.zzp(zzlqVar);
            k0Var.a((zzlk) zzliVarZzc.zzf());
        } catch (Throwable th) {
            zze.zzm("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // H0.InterfaceC0303f0
    public final void d(zzjz zzjzVar) {
        if (zzjzVar == null) {
            return;
        }
        try {
            zzli zzliVarZzc = zzlk.zzc();
            zzliVarZzc.zzo(this.f668b);
            zzliVarZzc.zza(zzjzVar);
            this.f669c.a((zzlk) zzliVarZzc.zzf());
        } catch (Throwable th) {
            zze.zzm("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // H0.InterfaceC0303f0
    public final void e(zzjz zzjzVar, int i4) {
        try {
            zzks zzksVar = (zzks) this.f668b.zzn();
            zzksVar.zza(i4);
            this.f668b = (zzku) zzksVar.zzf();
            d(zzjzVar);
        } catch (Throwable th) {
            zze.zzm("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // H0.InterfaceC0303f0
    public final void f(zzkd zzkdVar, int i4) {
        try {
            zzks zzksVar = (zzks) this.f668b.zzn();
            zzksVar.zza(i4);
            this.f668b = (zzku) zzksVar.zzf();
            g(zzkdVar);
        } catch (Throwable th) {
            zze.zzm("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // H0.InterfaceC0303f0
    public final void g(zzkd zzkdVar) {
        if (zzkdVar == null) {
            return;
        }
        try {
            zzli zzliVarZzc = zzlk.zzc();
            zzliVarZzc.zzo(this.f668b);
            zzliVarZzc.zzm(zzkdVar);
            this.f669c.a((zzlk) zzliVarZzc.zzf());
        } catch (Throwable th) {
            zze.zzm("BillingLogger", "Unable to log.", th);
        }
    }
}
