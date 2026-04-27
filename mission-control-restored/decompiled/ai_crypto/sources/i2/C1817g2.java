package i2;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbl;
import com.google.android.gms.internal.measurement.zzbn;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: i2.g2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1817g2 extends zzbl implements InterfaceC1841j2 {
    public C1817g2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // i2.InterfaceC1841j2
    public final void A(n7 n7Var) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, n7Var);
        zzc(4, parcelZza);
    }

    @Override // i2.InterfaceC1841j2
    public final void E(n7 n7Var) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, n7Var);
        zzc(27, parcelZza);
    }

    @Override // i2.InterfaceC1841j2
    public final void F(C1830i c1830i, n7 n7Var) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, c1830i);
        zzbn.zzc(parcelZza, n7Var);
        zzc(12, parcelZza);
    }

    @Override // i2.InterfaceC1841j2
    public final void G(n7 n7Var) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, n7Var);
        zzc(18, parcelZza);
    }

    @Override // i2.InterfaceC1841j2
    public final void I(h7 h7Var, n7 n7Var) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, h7Var);
        zzbn.zzc(parcelZza, n7Var);
        zzc(2, parcelZza);
    }

    @Override // i2.InterfaceC1841j2
    public final void J(n7 n7Var, C1814g c1814g) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, n7Var);
        zzbn.zzc(parcelZza, c1814g);
        zzc(30, parcelZza);
    }

    @Override // i2.InterfaceC1841j2
    public final void L(C1750J c1750j, n7 n7Var) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, c1750j);
        zzbn.zzc(parcelZza, n7Var);
        zzc(1, parcelZza);
    }

    @Override // i2.InterfaceC1841j2
    public final String N(n7 n7Var) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, n7Var);
        Parcel parcelZzP = zzP(11, parcelZza);
        String string = parcelZzP.readString();
        parcelZzP.recycle();
        return string;
    }

    @Override // i2.InterfaceC1841j2
    public final List P(String str, String str2, n7 n7Var) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbn.zzc(parcelZza, n7Var);
        Parcel parcelZzP = zzP(16, parcelZza);
        ArrayList arrayListCreateTypedArrayList = parcelZzP.createTypedArrayList(C1830i.CREATOR);
        parcelZzP.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // i2.InterfaceC1841j2
    public final void Q(n7 n7Var) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, n7Var);
        zzc(20, parcelZza);
    }

    @Override // i2.InterfaceC1841j2
    public final byte[] T(C1750J c1750j, String str) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, c1750j);
        parcelZza.writeString(str);
        Parcel parcelZzP = zzP(9, parcelZza);
        byte[] bArrCreateByteArray = parcelZzP.createByteArray();
        parcelZzP.recycle();
        return bArrCreateByteArray;
    }

    @Override // i2.InterfaceC1841j2
    public final void U(Bundle bundle, n7 n7Var) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, bundle);
        zzbn.zzc(parcelZza, n7Var);
        zzc(19, parcelZza);
    }

    @Override // i2.InterfaceC1841j2
    public final void d(n7 n7Var, Bundle bundle, InterfaceC1865m2 interfaceC1865m2) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, n7Var);
        zzbn.zzc(parcelZza, bundle);
        zzbn.zzd(parcelZza, interfaceC1865m2);
        zzc(31, parcelZza);
    }

    @Override // i2.InterfaceC1841j2
    public final List e(String str, String str2, String str3, boolean z7) {
        Parcel parcelZza = zza();
        parcelZza.writeString(null);
        parcelZza.writeString(str2);
        parcelZza.writeString(str3);
        int i7 = zzbn.zza;
        parcelZza.writeInt(z7 ? 1 : 0);
        Parcel parcelZzP = zzP(15, parcelZza);
        ArrayList arrayListCreateTypedArrayList = parcelZzP.createTypedArrayList(h7.CREATOR);
        parcelZzP.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // i2.InterfaceC1841j2
    public final List i(String str, String str2, boolean z7, n7 n7Var) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        int i7 = zzbn.zza;
        parcelZza.writeInt(z7 ? 1 : 0);
        zzbn.zzc(parcelZza, n7Var);
        Parcel parcelZzP = zzP(14, parcelZza);
        ArrayList arrayListCreateTypedArrayList = parcelZzP.createTypedArrayList(h7.CREATOR);
        parcelZzP.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // i2.InterfaceC1841j2
    public final void k(n7 n7Var) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, n7Var);
        zzc(25, parcelZza);
    }

    @Override // i2.InterfaceC1841j2
    public final void l(long j7, String str, String str2, String str3) {
        Parcel parcelZza = zza();
        parcelZza.writeLong(j7);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        parcelZza.writeString(str3);
        zzc(10, parcelZza);
    }

    @Override // i2.InterfaceC1841j2
    public final void p(n7 n7Var) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, n7Var);
        zzc(26, parcelZza);
    }

    @Override // i2.InterfaceC1841j2
    public final void s(n7 n7Var) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, n7Var);
        zzc(6, parcelZza);
    }

    @Override // i2.InterfaceC1841j2
    public final List u(String str, String str2, String str3) {
        Parcel parcelZza = zza();
        parcelZza.writeString(null);
        parcelZza.writeString(str2);
        parcelZza.writeString(str3);
        Parcel parcelZzP = zzP(17, parcelZza);
        ArrayList arrayListCreateTypedArrayList = parcelZzP.createTypedArrayList(C1830i.CREATOR);
        parcelZzP.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // i2.InterfaceC1841j2
    public final C1886p x(n7 n7Var) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, n7Var);
        Parcel parcelZzP = zzP(21, parcelZza);
        C1886p c1886p = (C1886p) zzbn.zzb(parcelZzP, C1886p.CREATOR);
        parcelZzP.recycle();
        return c1886p;
    }

    @Override // i2.InterfaceC1841j2
    public final void y(n7 n7Var, I6 i62, InterfaceC1889p2 interfaceC1889p2) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, n7Var);
        zzbn.zzc(parcelZza, i62);
        zzbn.zzd(parcelZza, interfaceC1889p2);
        zzc(29, parcelZza);
    }
}
