package d3;

import android.content.Context;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzhv;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzhz;
import com.google.android.gms.internal.play_billing.zzib;
import com.google.android.gms.internal.play_billing.zzij;
import com.google.android.gms.internal.play_billing.zziq;
import com.google.android.gms.internal.play_billing.zzis;
import com.google.android.gms.internal.play_billing.zzja;
import com.google.android.gms.internal.play_billing.zzjg;
import com.google.android.gms.internal.play_billing.zzji;
import com.google.android.gms.internal.play_billing.zzjo;
import com.google.android.gms.internal.play_billing.zzjs;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s1 implements p1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zzis f7788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u1 f7789c;

    public s1(Context context, zzis zzisVar) {
        this.f7789c = new u1(context);
        this.f7788b = zzisVar;
    }

    @Override // d3.p1
    public final void a(zzhx zzhxVar, int i10, long j10, boolean z10) {
        zzis zzisVar;
        try {
            zziq zziqVar = (zziq) this.f7788b.zzm();
            zziqVar.zzm(i10);
            this.f7788b = (zzis) zziqVar.zze();
            zzhv zzhvVar = (zzhv) zzhxVar.zzm();
            zzja zzjaVar = (zzja) zzhxVar.zzB().zzm();
            zzjaVar.zza(z10);
            zzhvVar.zzn(zzjaVar);
            zzhx zzhxVar2 = (zzhx) zzhvVar.zze();
            if (j10 == 0) {
                zzisVar = this.f7788b;
            } else {
                zziq zziqVar2 = (zziq) this.f7788b.zzm();
                zziqVar2.zzo(j10);
                zzisVar = (zzis) zziqVar2.zze();
            }
            l(zzhxVar2, zzisVar);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // d3.p1
    public final void b(zzhx zzhxVar) {
        try {
            l(zzhxVar, this.f7788b);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // d3.p1
    public final void c(zzij zzijVar) {
        try {
            zzjg zzjgVarZzc = zzji.zzc();
            zzjgVarZzc.zzn(this.f7788b);
            zzjgVarZzc.zzm(zzijVar);
            this.f7789c.a((zzji) zzjgVarZzc.zze());
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // d3.p1
    public final void d(zzib zzibVar, int i10) {
        try {
            zziq zziqVar = (zziq) this.f7788b.zzm();
            zziqVar.zzm(i10);
            this.f7788b = (zzis) zziqVar.zze();
            h(zzibVar);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // d3.p1
    public final void e(zzjo zzjoVar) {
        try {
            u1 u1Var = this.f7789c;
            zzjg zzjgVarZzc = zzji.zzc();
            zzjgVarZzc.zzn(this.f7788b);
            zzjgVarZzc.zzo(zzjoVar);
            u1Var.a((zzji) zzjgVarZzc.zze());
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // d3.p1
    public final void f(zzib zzibVar, long j10, boolean z10) {
        zzis zzisVar;
        try {
            zzhz zzhzVar = (zzhz) zzibVar.zzm();
            zzja zzjaVar = (zzja) zzibVar.zzA().zzm();
            zzjaVar.zza(z10);
            zzhzVar.zzm(zzjaVar);
            zzib zzibVar2 = (zzib) zzhzVar.zze();
            if (j10 == 0) {
                zzisVar = this.f7788b;
            } else {
                zziq zziqVar = (zziq) this.f7788b.zzm();
                zziqVar.zzo(j10);
                zzisVar = (zzis) zziqVar.zze();
            }
            m(zzibVar2, zzisVar);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // d3.p1
    public final void g(zzhx zzhxVar, long j10, boolean z10) {
        zzis zzisVar;
        try {
            zzhv zzhvVar = (zzhv) zzhxVar.zzm();
            zzja zzjaVar = (zzja) zzhxVar.zzB().zzm();
            zzjaVar.zza(z10);
            zzhvVar.zzn(zzjaVar);
            zzhx zzhxVar2 = (zzhx) zzhvVar.zze();
            if (j10 == 0) {
                zzisVar = this.f7788b;
            } else {
                zziq zziqVar = (zziq) this.f7788b.zzm();
                zziqVar.zzo(j10);
                zzisVar = (zzis) zziqVar.zze();
            }
            l(zzhxVar2, zzisVar);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // d3.p1
    public final void h(zzib zzibVar) {
        try {
            m(zzibVar, this.f7788b);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // d3.p1
    public final void i(zzjs zzjsVar) {
        if (zzjsVar == null) {
            return;
        }
        try {
            zzjg zzjgVarZzc = zzji.zzc();
            zzjgVarZzc.zzn(this.f7788b);
            zzjgVarZzc.zzp(zzjsVar);
            this.f7789c.a((zzji) zzjgVarZzc.zze());
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // d3.p1
    public final void j(zzhx zzhxVar, int i10, long j10) {
        try {
            zziq zziqVar = (zziq) this.f7788b.zzm();
            zziqVar.zzm(i10);
            zzis zzisVar = (zzis) zziqVar.zze();
            this.f7788b = zzisVar;
            if (j10 != 0) {
                zziq zziqVar2 = (zziq) zzisVar.zzm();
                zziqVar2.zzo(j10);
                zzisVar = (zzis) zziqVar2.zze();
            }
            l(zzhxVar, zzisVar);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // d3.p1
    public final void k(zzhx zzhxVar, int i10) {
        try {
            zziq zziqVar = (zziq) this.f7788b.zzm();
            zziqVar.zzm(i10);
            this.f7788b = (zzis) zziqVar.zze();
            b(zzhxVar);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    public final void l(zzhx zzhxVar, zzis zzisVar) {
        if (zzhxVar == null) {
            return;
        }
        try {
            zzjg zzjgVarZzc = zzji.zzc();
            zzjgVarZzc.zzn(zzisVar);
            zzjgVarZzc.zza(zzhxVar);
            this.f7789c.a((zzji) zzjgVarZzc.zze());
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    public final void m(zzib zzibVar, zzis zzisVar) {
        if (zzibVar == null) {
            return;
        }
        try {
            zzjg zzjgVarZzc = zzji.zzc();
            zzjgVarZzc.zzn(zzisVar);
            zzjgVarZzc.zzl(zzibVar);
            this.f7789c.a((zzji) zzjgVarZzc.zze());
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }
}
