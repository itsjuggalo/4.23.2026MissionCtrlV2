package l2;

import android.os.Parcel;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zac;
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public abstract class e extends zab implements f {
    public e() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // com.google.android.gms.internal.base.zab
    public final boolean zaa(int i7, Parcel parcel, Parcel parcel2, int i8) {
        switch (i7) {
            case 3:
                zac.zab(parcel);
                break;
            case 4:
                zac.zab(parcel);
                break;
            case 5:
            default:
                return false;
            case 6:
                zac.zab(parcel);
                break;
            case 7:
                zac.zab(parcel);
                break;
            case 8:
                l lVar = (l) zac.zaa(parcel, l.CREATOR);
                zac.zab(parcel);
                q(lVar);
                break;
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                zac.zab(parcel);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
