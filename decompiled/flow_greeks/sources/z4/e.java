package z4;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.auth.zza;
import com.google.android.gms.internal.auth.zzc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends zza implements g {
    public e(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.account.IWorkAccountService");
    }

    @Override // z4.g
    public final void d(d dVar, Account account) {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, dVar);
        zzc.zzc(parcelZza, account);
        zzc(3, parcelZza);
    }

    @Override // z4.g
    public final void y(d dVar, String str) {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, dVar);
        parcelZza.writeString(str);
        zzc(2, parcelZza);
    }

    @Override // z4.g
    public final void z(boolean z10) {
        Parcel parcelZza = zza();
        int i10 = zzc.zza;
        parcelZza.writeInt(z10 ? 1 : 0);
        zzc(1, parcelZza);
    }
}
