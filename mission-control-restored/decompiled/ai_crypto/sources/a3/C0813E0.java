package a3;

import Z2.AbstractC0747b;
import Z2.InterfaceC0751d;
import com.google.android.gms.internal.p002firebaseauthapi.zzahx;

/* JADX INFO: renamed from: a3.E0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0813E0 implements InterfaceC0751d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbstractC0747b f6129d;

    public C0813E0(zzahx zzahxVar) {
        int i7 = 5;
        this.f6127b = zzahxVar.zzg() ? zzahxVar.zzc() : zzahxVar.zzb();
        this.f6128c = zzahxVar.zzb();
        AbstractC0747b c0809c0 = null;
        if (!zzahxVar.zzh()) {
            this.f6126a = 3;
            this.f6129d = null;
            return;
        }
        String strZzd = zzahxVar.zzd();
        strZzd.hashCode();
        switch (strZzd) {
            case "REVERT_SECOND_FACTOR_ADDITION":
                i7 = 6;
                break;
            case "PASSWORD_RESET":
                i7 = 0;
                break;
            case "VERIFY_EMAIL":
                i7 = 1;
                break;
            case "VERIFY_AND_CHANGE_EMAIL":
                break;
            case "EMAIL_SIGNIN":
                i7 = 4;
                break;
            case "RECOVER_EMAIL":
                i7 = 2;
                break;
            default:
                i7 = 3;
                break;
        }
        this.f6126a = i7;
        if (i7 == 4 || i7 == 3) {
            this.f6129d = null;
            return;
        }
        if (zzahxVar.zzf()) {
            c0809c0 = new C0815F0(zzahxVar.zzb(), AbstractC0828O.a(zzahxVar.zza()));
        } else if (zzahxVar.zzg()) {
            c0809c0 = new C0811D0(zzahxVar.zzc(), zzahxVar.zzb());
        } else if (zzahxVar.zze()) {
            c0809c0 = new C0809C0(zzahxVar.zzb());
        }
        this.f6129d = c0809c0;
    }

    @Override // Z2.InterfaceC0751d
    public final int a() {
        return this.f6126a;
    }

    @Override // Z2.InterfaceC0751d
    public final AbstractC0747b b() {
        return this.f6129d;
    }
}
