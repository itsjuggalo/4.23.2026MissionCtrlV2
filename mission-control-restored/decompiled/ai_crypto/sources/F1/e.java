package F1;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.auth.zza;
import com.google.android.gms.internal.auth.zzc;

/* JADX INFO: loaded from: classes.dex */
public final class e extends zza implements g {
    public e(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.account.IWorkAccountService");
    }

    @Override // F1.g
    public final void R(boolean z7) {
        Parcel parcelZza = zza();
        int i7 = zzc.zza;
        parcelZza.writeInt(z7 ? 1 : 0);
        zzc(1, parcelZza);
    }

    @Override // F1.g
    public final void Z(d dVar, String str) {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, dVar);
        parcelZza.writeString(str);
        zzc(2, parcelZza);
    }

    @Override // F1.g
    public final void g(d dVar, Account account) {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, dVar);
        zzc.zzc(parcelZza, account);
        zzc(3, parcelZza);
    }
}
