package S1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbl;
import com.google.android.gms.internal.measurement.zzbn;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: S1.g2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0577g2 extends zzbl implements InterfaceC0601j2 {
    public C0577g2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // S1.InterfaceC0601j2
    public final List C(String str, String str2, n7 n7Var) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbn.zzc(parcelZza, n7Var);
        Parcel parcelZzP = zzP(16, parcelZza);
        ArrayList arrayListCreateTypedArrayList = parcelZzP.createTypedArrayList(C0590i.CREATOR);
        parcelZzP.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // S1.InterfaceC0601j2
    public final void D(n7 n7Var) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, n7Var);
        zzc(20, parcelZza);
    }

    @Override // S1.InterfaceC0601j2
    public final void E(h7 h7Var, n7 n7Var) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, h7Var);
        zzbn.zzc(parcelZza, n7Var);
        zzc(2, parcelZza);
    }

    @Override // S1.InterfaceC0601j2
    public final void G(C0590i c0590i, n7 n7Var) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, c0590i);
        zzbn.zzc(parcelZza, n7Var);
        zzc(12, parcelZza);
    }

    @Override // S1.InterfaceC0601j2
    public final void I(n7 n7Var, C0574g c0574g) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, n7Var);
        zzbn.zzc(parcelZza, c0574g);
        zzc(30, parcelZza);
    }

    @Override // S1.InterfaceC0601j2
    public final void M(n7 n7Var) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, n7Var);
        zzc(25, parcelZza);
    }

    @Override // S1.InterfaceC0601j2
    public final List P(String str, String str2, boolean z4, n7 n7Var) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        int i4 = zzbn.zza;
        parcelZza.writeInt(z4 ? 1 : 0);
        zzbn.zzc(parcelZza, n7Var);
        Parcel parcelZzP = zzP(14, parcelZza);
        ArrayList arrayListCreateTypedArrayList = parcelZzP.createTypedArrayList(h7.CREATOR);
        parcelZzP.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // S1.InterfaceC0601j2
    public final void Q(n7 n7Var) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, n7Var);
        zzc(4, parcelZza);
    }

    @Override // S1.InterfaceC0601j2
    public final void W(n7 n7Var) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, n7Var);
        zzc(26, parcelZza);
    }

    @Override // S1.InterfaceC0601j2
    public final void X(n7 n7Var) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, n7Var);
        zzc(6, parcelZza);
    }

    @Override // S1.InterfaceC0601j2
    public final void Y(n7 n7Var, I6 i6, InterfaceC0649p2 interfaceC0649p2) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, n7Var);
        zzbn.zzc(parcelZza, i6);
        zzbn.zzd(parcelZza, interfaceC0649p2);
        zzc(29, parcelZza);
    }

    @Override // S1.InterfaceC0601j2
    public final List d(String str, String str2, String str3, boolean z4) {
        Parcel parcelZza = zza();
        parcelZza.writeString(null);
        parcelZza.writeString(str2);
        parcelZza.writeString(str3);
        int i4 = zzbn.zza;
        parcelZza.writeInt(z4 ? 1 : 0);
        Parcel parcelZzP = zzP(15, parcelZza);
        ArrayList arrayListCreateTypedArrayList = parcelZzP.createTypedArrayList(h7.CREATOR);
        parcelZzP.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // S1.InterfaceC0601j2
    public final String g(n7 n7Var) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, n7Var);
        Parcel parcelZzP = zzP(11, parcelZza);
        String string = parcelZzP.readString();
        parcelZzP.recycle();
        return string;
    }

    @Override // S1.InterfaceC0601j2
    public final void k(n7 n7Var) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, n7Var);
        zzc(27, parcelZza);
    }

    @Override // S1.InterfaceC0601j2
    public final void l(long j4, String str, String str2, String str3) {
        Parcel parcelZza = zza();
        parcelZza.writeLong(j4);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        parcelZza.writeString(str3);
        zzc(10, parcelZza);
    }

    @Override // S1.InterfaceC0601j2
    public final byte[] o(J j4, String str) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, j4);
        parcelZza.writeString(str);
        Parcel parcelZzP = zzP(9, parcelZza);
        byte[] bArrCreateByteArray = parcelZzP.createByteArray();
        parcelZzP.recycle();
        return bArrCreateByteArray;
    }

    @Override // S1.InterfaceC0601j2
    public final void p(n7 n7Var, Bundle bundle, InterfaceC0625m2 interfaceC0625m2) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, n7Var);
        zzbn.zzc(parcelZza, bundle);
        zzbn.zzd(parcelZza, interfaceC0625m2);
        zzc(31, parcelZza);
    }

    @Override // S1.InterfaceC0601j2
    public final void r(n7 n7Var) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, n7Var);
        zzc(18, parcelZza);
    }

    @Override // S1.InterfaceC0601j2
    public final void s(J j4, n7 n7Var) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, j4);
        zzbn.zzc(parcelZza, n7Var);
        zzc(1, parcelZza);
    }

    @Override // S1.InterfaceC0601j2
    public final void t(Bundle bundle, n7 n7Var) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, bundle);
        zzbn.zzc(parcelZza, n7Var);
        zzc(19, parcelZza);
    }

    @Override // S1.InterfaceC0601j2
    public final List u(String str, String str2, String str3) {
        Parcel parcelZza = zza();
        parcelZza.writeString(null);
        parcelZza.writeString(str2);
        parcelZza.writeString(str3);
        Parcel parcelZzP = zzP(17, parcelZza);
        ArrayList arrayListCreateTypedArrayList = parcelZzP.createTypedArrayList(C0590i.CREATOR);
        parcelZzP.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // S1.InterfaceC0601j2
    public final C0646p x(n7 n7Var) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, n7Var);
        Parcel parcelZzP = zzP(21, parcelZza);
        C0646p c0646p = (C0646p) zzbn.zzb(parcelZzP, C0646p.CREATOR);
        parcelZzP.recycle();
        return c0646p;
    }
}
