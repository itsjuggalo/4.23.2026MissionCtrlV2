package o1;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.internal.auth.zzb;
import com.google.android.gms.internal.auth.zzc;

/* JADX INFO: renamed from: o1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC1663c extends zzb implements InterfaceC1664d {
    public AbstractBinderC1663c() {
        super("com.google.android.gms.auth.account.IWorkAccountCallback");
    }

    @Override // com.google.android.gms.internal.auth.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) {
        if (i4 != 1) {
            if (i4 != 2) {
                return false;
            }
            int i6 = zzc.zza;
            int i7 = parcel.readInt();
            zzc.zzb(parcel);
            zzc(i7 != 0);
        } else {
            Account account = (Account) zzc.zza(parcel, Account.CREATOR);
            zzc.zzb(parcel);
            zzb(account);
        }
        return true;
    }
}
