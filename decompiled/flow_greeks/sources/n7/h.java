package n7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzahv;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        zzahv zzahvVar = null;
        e eVar = null;
        String strQ = null;
        String strQ2 = null;
        ArrayList arrayListU = null;
        ArrayList arrayListS = null;
        String strQ3 = null;
        Boolean boolY = null;
        k kVar = null;
        m7.z1 z1Var = null;
        n0 n0Var = null;
        ArrayList arrayListU2 = null;
        boolean zX = false;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            switch (n5.b.w(iD)) {
                case 1:
                    zzahvVar = (zzahv) n5.b.p(parcel, iD, zzahv.CREATOR);
                    break;
                case 2:
                    eVar = (e) n5.b.p(parcel, iD, e.CREATOR);
                    break;
                case 3:
                    strQ = n5.b.q(parcel, iD);
                    break;
                case 4:
                    strQ2 = n5.b.q(parcel, iD);
                    break;
                case 5:
                    arrayListU = n5.b.u(parcel, iD, e.CREATOR);
                    break;
                case 6:
                    arrayListS = n5.b.s(parcel, iD);
                    break;
                case 7:
                    strQ3 = n5.b.q(parcel, iD);
                    break;
                case 8:
                    boolY = n5.b.y(parcel, iD);
                    break;
                case 9:
                    kVar = (k) n5.b.p(parcel, iD, k.CREATOR);
                    break;
                case 10:
                    zX = n5.b.x(parcel, iD);
                    break;
                case 11:
                    z1Var = (m7.z1) n5.b.p(parcel, iD, m7.z1.CREATOR);
                    break;
                case 12:
                    n0Var = (n0) n5.b.p(parcel, iD, n0.CREATOR);
                    break;
                case 13:
                    arrayListU2 = n5.b.u(parcel, iD, m7.p1.CREATOR);
                    break;
                default:
                    n5.b.L(parcel, iD);
                    break;
            }
        }
        n5.b.v(parcel, iM);
        return new i(zzahvVar, eVar, strQ, strQ2, arrayListU, arrayListS, strQ3, boolY, kVar, zX, z1Var, n0Var, arrayListU2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new i[i10];
    }
}
