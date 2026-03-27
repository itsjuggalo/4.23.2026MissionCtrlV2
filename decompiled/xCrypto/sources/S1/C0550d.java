package S1;

import com.google.android.gms.internal.measurement.zzfh;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zziu;
import com.google.android.gms.internal.measurement.zzpq;
import java.util.Objects;

/* JADX INFO: renamed from: S1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0550d extends AbstractC0542c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final zzfn f4435g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ C0558e f4436h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0550d(C0558e c0558e, String str, int i4, zzfn zzfnVar) {
        super(str, i4);
        Objects.requireNonNull(c0558e);
        this.f4436h = c0558e;
        this.f4435g = zzfnVar;
    }

    @Override // S1.AbstractC0542c
    public final int a() {
        return this.f4435g.zzb();
    }

    @Override // S1.AbstractC0542c
    public final boolean b() {
        return true;
    }

    @Override // S1.AbstractC0542c
    public final boolean c() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean k(Long l4, Long l5, zziu zziuVar, boolean z4) {
        zzpq.zza();
        C0658q3 c0658q3 = this.f4436h.f4245a;
        boolean zH = c0658q3.w().H(this.f4416a, AbstractC0569f2.f4511E0);
        zzfn zzfnVar = this.f4435g;
        boolean zZze = zzfnVar.zze();
        boolean zZzf = zzfnVar.zzf();
        boolean zZzh = zzfnVar.zzh();
        Object[] objArr = zZze || zZzf || zZzh;
        Boolean boolE = null;
        boolE = null;
        boolE = null;
        boolE = null;
        boolE = null;
        if (z4 && objArr != true) {
            c0658q3.a().w().c("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.f4417b), zzfnVar.zza() ? Integer.valueOf(zzfnVar.zzb()) : null);
            return true;
        }
        zzfh zzfhVarZzd = zzfnVar.zzd();
        boolean zZzf2 = zzfhVarZzd.zzf();
        if (zziuVar.zzf()) {
            if (zzfhVarZzd.zzc()) {
                boolE = AbstractC0542c.e(AbstractC0542c.g(zziuVar.zzg(), zzfhVarZzd.zzd()), zZzf2);
            } else {
                c0658q3.a().r().b("No number filter for long property. property", c0658q3.D().c(zziuVar.zzc()));
            }
        } else if (zziuVar.zzj()) {
            if (zzfhVarZzd.zzc()) {
                boolE = AbstractC0542c.e(AbstractC0542c.h(zziuVar.zzk(), zzfhVarZzd.zzd()), zZzf2);
            } else {
                c0658q3.a().r().b("No number filter for double property. property", c0658q3.D().c(zziuVar.zzc()));
            }
        } else if (!zziuVar.zzd()) {
            c0658q3.a().r().b("User property has no value, property", c0658q3.D().c(zziuVar.zzc()));
        } else if (zzfhVarZzd.zza()) {
            boolE = AbstractC0542c.e(AbstractC0542c.f(zziuVar.zze(), zzfhVarZzd.zzb(), c0658q3.a()), zZzf2);
        } else if (!zzfhVarZzd.zzc()) {
            c0658q3.a().r().b("No string or number filter defined. property", c0658q3.D().c(zziuVar.zzc()));
        } else if (g7.O(zziuVar.zze())) {
            boolE = AbstractC0542c.e(AbstractC0542c.i(zziuVar.zze(), zzfhVarZzd.zzd()), zZzf2);
        } else {
            c0658q3.a().r().c("Invalid user property value for Numeric number filter. property, value", c0658q3.D().c(zziuVar.zzc()), zziuVar.zze());
        }
        c0658q3.a().w().b("Property filter result", boolE == null ? "null" : boolE);
        if (boolE == null) {
            return false;
        }
        this.f4418c = Boolean.TRUE;
        if (zZzh && !boolE.booleanValue()) {
            return true;
        }
        if (!z4 || zzfnVar.zze()) {
            this.f4419d = boolE;
        }
        if (boolE.booleanValue() && objArr != false && zziuVar.zza()) {
            long jZzb = zziuVar.zzb();
            if (l4 != null) {
                jZzb = l4.longValue();
            }
            if (zH && zzfnVar.zze() && !zzfnVar.zzf() && l5 != null) {
                jZzb = l5.longValue();
            }
            if (zzfnVar.zzf()) {
                this.f4421f = Long.valueOf(jZzb);
            } else {
                this.f4420e = Long.valueOf(jZzb);
            }
        }
        return true;
    }
}
