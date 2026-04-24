package a3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzahn;
import java.util.ArrayList;
import k4.C2105D;

/* JADX INFO: renamed from: a3.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0853h implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        zzahn zzahnVar = null;
        C0847e c0847e = null;
        String strQ = null;
        String strQ2 = null;
        ArrayList arrayListU = null;
        ArrayList arrayListS = null;
        String strQ3 = null;
        Boolean boolY = null;
        C0859k c0859k = null;
        Z2.y0 y0Var = null;
        C0827N c0827n = null;
        ArrayList arrayListU2 = null;
        boolean zX = false;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 1:
                    zzahnVar = (zzahn) Q1.b.p(parcel, iD, zzahn.CREATOR);
                    break;
                case 2:
                    c0847e = (C0847e) Q1.b.p(parcel, iD, C0847e.CREATOR);
                    break;
                case 3:
                    strQ = Q1.b.q(parcel, iD);
                    break;
                case 4:
                    strQ2 = Q1.b.q(parcel, iD);
                    break;
                case 5:
                    arrayListU = Q1.b.u(parcel, iD, C0847e.CREATOR);
                    break;
                case 6:
                    arrayListS = Q1.b.s(parcel, iD);
                    break;
                case 7:
                    strQ3 = Q1.b.q(parcel, iD);
                    break;
                case 8:
                    boolY = Q1.b.y(parcel, iD);
                    break;
                case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    c0859k = (C0859k) Q1.b.p(parcel, iD, C0859k.CREATOR);
                    break;
                case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    zX = Q1.b.x(parcel, iD);
                    break;
                case 11:
                    y0Var = (Z2.y0) Q1.b.p(parcel, iD, Z2.y0.CREATOR);
                    break;
                case 12:
                    c0827n = (C0827N) Q1.b.p(parcel, iD, C0827N.CREATOR);
                    break;
                case 13:
                    arrayListU2 = Q1.b.u(parcel, iD, Z2.n0.CREATOR);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new C0855i(zzahnVar, c0847e, strQ, strQ2, arrayListU, arrayListS, strQ3, boolY, c0859k, zX, y0Var, c0827n, arrayListU2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C0855i[i7];
    }
}
