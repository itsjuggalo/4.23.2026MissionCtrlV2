package com.google.android.gms.internal.location;

import A1.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0926d;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbb implements Parcelable.Creator<zzba> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzba createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        List<C0926d> listU = zzba.zza;
        LocationRequest locationRequest = null;
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        boolean zX4 = false;
        boolean zX5 = false;
        long jH = Long.MAX_VALUE;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            int iW = b.w(iD);
            if (iW != 1) {
                switch (iW) {
                    case 5:
                        listU = b.u(parcel, iD, C0926d.CREATOR);
                        break;
                    case 6:
                        strQ = b.q(parcel, iD);
                        break;
                    case 7:
                        zX = b.x(parcel, iD);
                        break;
                    case 8:
                        zX2 = b.x(parcel, iD);
                        break;
                    case 9:
                        zX3 = b.x(parcel, iD);
                        break;
                    case 10:
                        strQ2 = b.q(parcel, iD);
                        break;
                    case 11:
                        zX4 = b.x(parcel, iD);
                        break;
                    case 12:
                        zX5 = b.x(parcel, iD);
                        break;
                    case 13:
                        strQ3 = b.q(parcel, iD);
                        break;
                    case 14:
                        jH = b.H(parcel, iD);
                        break;
                    default:
                        b.L(parcel, iD);
                        break;
                }
            } else {
                locationRequest = (LocationRequest) b.p(parcel, iD, LocationRequest.CREATOR);
            }
        }
        b.v(parcel, iM);
        return new zzba(locationRequest, listU, strQ, zX, zX2, zX3, strQ2, zX4, zX5, strQ3, jH);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzba[] newArray(int i4) {
        return new zzba[i4];
    }
}
