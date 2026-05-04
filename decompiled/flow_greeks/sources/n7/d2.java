package n7;

import com.google.android.gms.internal.p002firebaseauthapi.zzaif;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d2 implements m7.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m7.b f16731d;

    public d2(zzaif zzaifVar) {
        int i10;
        this.f16729b = zzaifVar.zzg() ? zzaifVar.zzc() : zzaifVar.zzb();
        this.f16730c = zzaifVar.zzb();
        m7.b b2Var = null;
        if (!zzaifVar.zzh()) {
            this.f16728a = 3;
            this.f16731d = null;
            return;
        }
        String strZzd = zzaifVar.zzd();
        strZzd.getClass();
        i10 = 5;
        switch (strZzd) {
            case "REVERT_SECOND_FACTOR_ADDITION":
                i10 = 6;
                break;
            case "PASSWORD_RESET":
                i10 = 0;
                break;
            case "VERIFY_EMAIL":
                i10 = 1;
                break;
            case "VERIFY_AND_CHANGE_EMAIL":
                break;
            case "EMAIL_SIGNIN":
                i10 = 4;
                break;
            case "RECOVER_EMAIL":
                i10 = 2;
                break;
            default:
                i10 = 3;
                break;
        }
        this.f16728a = i10;
        if (i10 == 4 || i10 == 3) {
            this.f16731d = null;
            return;
        }
        if (zzaifVar.zzf()) {
            b2Var = new e2(zzaifVar.zzb(), o0.b(zzaifVar.zza()));
        } else if (zzaifVar.zzg()) {
            b2Var = new c2(zzaifVar.zzc(), zzaifVar.zzb());
        } else if (zzaifVar.zze()) {
            b2Var = new b2(zzaifVar.zzb());
        }
        this.f16731d = b2Var;
    }

    @Override // m7.d
    public final int a() {
        return this.f16728a;
    }

    @Override // m7.d
    public final m7.b b() {
        return this.f16731d;
    }
}
