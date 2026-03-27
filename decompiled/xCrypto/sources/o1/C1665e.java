package o1;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.auth.zza;
import com.google.android.gms.internal.auth.zzc;

/* JADX INFO: renamed from: o1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1665e extends zza implements InterfaceC1667g {
    public C1665e(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.account.IWorkAccountService");
    }

    @Override // o1.InterfaceC1667g
    public final void O(InterfaceC1664d interfaceC1664d, String str) {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, interfaceC1664d);
        parcelZza.writeString(str);
        zzc(2, parcelZza);
    }

    @Override // o1.InterfaceC1667g
    public final void R(boolean z4) {
        Parcel parcelZza = zza();
        int i4 = zzc.zza;
        parcelZza.writeInt(z4 ? 1 : 0);
        zzc(1, parcelZza);
    }

    @Override // o1.InterfaceC1667g
    public final void q(InterfaceC1664d interfaceC1664d, Account account) {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, interfaceC1664d);
        zzc.zzc(parcelZza, account);
        zzc(3, parcelZza);
    }
}
