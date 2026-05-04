package h6;

import android.os.Parcel;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zac;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e extends zab implements f {
    public e() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // com.google.android.gms.internal.base.zab
    public final boolean zaa(int i10, Parcel parcel, Parcel parcel2, int i11) {
        switch (i10) {
            case 3:
                zac.zad(parcel);
                break;
            case 4:
                zac.zad(parcel);
                break;
            case 5:
            default:
                return false;
            case 6:
                zac.zad(parcel);
                break;
            case 7:
                zac.zad(parcel);
                break;
            case 8:
                l lVar = (l) zac.zaa(parcel, l.CREATOR);
                zac.zad(parcel);
                v(lVar);
                break;
            case 9:
                zac.zad(parcel);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
