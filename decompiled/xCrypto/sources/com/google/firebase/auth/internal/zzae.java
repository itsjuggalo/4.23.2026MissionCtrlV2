package com.google.firebase.auth.internal;

import A1.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzahn;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzae implements Parcelable.Creator<zzaf> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaf createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        zzahn zzahnVar = null;
        zzab zzabVar = null;
        String strQ = null;
        String strQ2 = null;
        ArrayList arrayListU = null;
        ArrayList arrayListS = null;
        String strQ3 = null;
        Boolean boolY = null;
        zzah zzahVar = null;
        com.google.firebase.auth.zzc zzcVar = null;
        zzbj zzbjVar = null;
        ArrayList arrayListU2 = null;
        boolean zX = false;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            switch (b.w(iD)) {
                case 1:
                    zzahnVar = (zzahn) b.p(parcel, iD, zzahn.CREATOR);
                    break;
                case 2:
                    zzabVar = (zzab) b.p(parcel, iD, zzab.CREATOR);
                    break;
                case 3:
                    strQ = b.q(parcel, iD);
                    break;
                case 4:
                    strQ2 = b.q(parcel, iD);
                    break;
                case 5:
                    arrayListU = b.u(parcel, iD, zzab.CREATOR);
                    break;
                case 6:
                    arrayListS = b.s(parcel, iD);
                    break;
                case 7:
                    strQ3 = b.q(parcel, iD);
                    break;
                case 8:
                    boolY = b.y(parcel, iD);
                    break;
                case 9:
                    zzahVar = (zzah) b.p(parcel, iD, zzah.CREATOR);
                    break;
                case 10:
                    zX = b.x(parcel, iD);
                    break;
                case 11:
                    zzcVar = (com.google.firebase.auth.zzc) b.p(parcel, iD, com.google.firebase.auth.zzc.CREATOR);
                    break;
                case 12:
                    zzbjVar = (zzbj) b.p(parcel, iD, zzbj.CREATOR);
                    break;
                case 13:
                    arrayListU2 = b.u(parcel, iD, com.google.firebase.auth.zzal.CREATOR);
                    break;
                default:
                    b.L(parcel, iD);
                    break;
            }
        }
        b.v(parcel, iM);
        return new zzaf(zzahnVar, zzabVar, strQ, strQ2, arrayListU, arrayListS, strQ3, boolY, zzahVar, zX, zzcVar, zzbjVar, arrayListU2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaf[] newArray(int i4) {
        return new zzaf[i4];
    }
}
