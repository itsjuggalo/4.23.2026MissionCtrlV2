package l1;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.internal.auth.zzb;
import com.google.android.gms.internal.auth.zzc;

/* JADX INFO: renamed from: l1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC0791b extends zzb implements InterfaceC0792c {
    @Override // com.google.android.gms.internal.auth.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i6) {
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            int i7 = zzc.zza;
            int i8 = parcel.readInt();
            zzc.zzb(parcel);
            zzc(i8 != 0);
        } else {
            Account account = (Account) zzc.zza(parcel, Account.CREATOR);
            zzc.zzb(parcel);
            zzb(account);
        }
        return true;
    }
}
