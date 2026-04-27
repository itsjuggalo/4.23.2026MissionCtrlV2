package i2;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbm;
import com.google.android.gms.internal.measurement.zzbn;
import java.util.List;
import k4.C2105D;

/* JADX INFO: renamed from: i2.h2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC1825h2 extends zzbm implements InterfaceC1841j2 {
    public AbstractBinderC1825h2() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    public final boolean zza(int i7, Parcel parcel, Parcel parcel2, int i8) {
        InterfaceC1889p2 c1873n2 = null;
        InterfaceC1865m2 c1849k2 = null;
        switch (i7) {
            case 1:
                C1750J c1750j = (C1750J) zzbn.zzb(parcel, C1750J.CREATOR);
                n7 n7Var = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                L(c1750j, n7Var);
                parcel2.writeNoException();
                return true;
            case 2:
                h7 h7Var = (h7) zzbn.zzb(parcel, h7.CREATOR);
                n7 n7Var2 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                I(h7Var, n7Var2);
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            case 22:
            case 23:
            case 28:
            default:
                return false;
            case 4:
                n7 n7Var3 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                A(n7Var3);
                parcel2.writeNoException();
                return true;
            case 5:
                C1750J c1750j2 = (C1750J) zzbn.zzb(parcel, C1750J.CREATOR);
                String string = parcel.readString();
                String string2 = parcel.readString();
                zzbn.zzf(parcel);
                t(c1750j2, string, string2);
                parcel2.writeNoException();
                return true;
            case 6:
                n7 n7Var4 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                s(n7Var4);
                parcel2.writeNoException();
                return true;
            case 7:
                n7 n7Var5 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                boolean zZza = zzbn.zza(parcel);
                zzbn.zzf(parcel);
                List listO = O(n7Var5, zZza);
                parcel2.writeNoException();
                parcel2.writeTypedList(listO);
                return true;
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                C1750J c1750j3 = (C1750J) zzbn.zzb(parcel, C1750J.CREATOR);
                String string3 = parcel.readString();
                zzbn.zzf(parcel);
                byte[] bArrT = T(c1750j3, string3);
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrT);
                return true;
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                long j7 = parcel.readLong();
                String string4 = parcel.readString();
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                zzbn.zzf(parcel);
                l(j7, string4, string5, string6);
                parcel2.writeNoException();
                return true;
            case 11:
                n7 n7Var6 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                String strN = N(n7Var6);
                parcel2.writeNoException();
                parcel2.writeString(strN);
                return true;
            case 12:
                C1830i c1830i = (C1830i) zzbn.zzb(parcel, C1830i.CREATOR);
                n7 n7Var7 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                F(c1830i, n7Var7);
                parcel2.writeNoException();
                return true;
            case 13:
                C1830i c1830i2 = (C1830i) zzbn.zzb(parcel, C1830i.CREATOR);
                zzbn.zzf(parcel);
                r(c1830i2);
                parcel2.writeNoException();
                return true;
            case 14:
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                boolean zZza2 = zzbn.zza(parcel);
                n7 n7Var8 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                List listI = i(string7, string8, zZza2, n7Var8);
                parcel2.writeNoException();
                parcel2.writeTypedList(listI);
                return true;
            case 15:
                String string9 = parcel.readString();
                String string10 = parcel.readString();
                String string11 = parcel.readString();
                boolean zZza3 = zzbn.zza(parcel);
                zzbn.zzf(parcel);
                List listE = e(string9, string10, string11, zZza3);
                parcel2.writeNoException();
                parcel2.writeTypedList(listE);
                return true;
            case com.amazon.c.a.a.c.f10119g /* 16 */:
                String string12 = parcel.readString();
                String string13 = parcel.readString();
                n7 n7Var9 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                List listP = P(string12, string13, n7Var9);
                parcel2.writeNoException();
                parcel2.writeTypedList(listP);
                return true;
            case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                String string14 = parcel.readString();
                String string15 = parcel.readString();
                String string16 = parcel.readString();
                zzbn.zzf(parcel);
                List listU = u(string14, string15, string16);
                parcel2.writeNoException();
                parcel2.writeTypedList(listU);
                return true;
            case C2105D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                n7 n7Var10 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                G(n7Var10);
                parcel2.writeNoException();
                return true;
            case 19:
                Bundle bundle = (Bundle) zzbn.zzb(parcel, Bundle.CREATOR);
                n7 n7Var11 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                U(bundle, n7Var11);
                parcel2.writeNoException();
                return true;
            case 20:
                n7 n7Var12 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                Q(n7Var12);
                parcel2.writeNoException();
                return true;
            case 21:
                n7 n7Var13 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                C1886p c1886pX = x(n7Var13);
                parcel2.writeNoException();
                if (c1886pX == null) {
                    parcel2.writeInt(0);
                } else {
                    parcel2.writeInt(1);
                    c1886pX.writeToParcel(parcel2, 1);
                }
                return true;
            case 24:
                n7 n7Var14 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                Bundle bundle2 = (Bundle) zzbn.zzb(parcel, Bundle.CREATOR);
                zzbn.zzf(parcel);
                List listO2 = o(n7Var14, bundle2);
                parcel2.writeNoException();
                parcel2.writeTypedList(listO2);
                return true;
            case 25:
                n7 n7Var15 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                k(n7Var15);
                parcel2.writeNoException();
                return true;
            case 26:
                n7 n7Var16 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                p(n7Var16);
                parcel2.writeNoException();
                return true;
            case 27:
                n7 n7Var17 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                E(n7Var17);
                parcel2.writeNoException();
                return true;
            case 29:
                n7 n7Var18 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                I6 i62 = (I6) zzbn.zzb(parcel, I6.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
                    c1873n2 = iInterfaceQueryLocalInterface instanceof InterfaceC1889p2 ? (InterfaceC1889p2) iInterfaceQueryLocalInterface : new C1873n2(strongBinder);
                }
                zzbn.zzf(parcel);
                y(n7Var18, i62, c1873n2);
                parcel2.writeNoException();
                return true;
            case 30:
                n7 n7Var19 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                C1814g c1814g = (C1814g) zzbn.zzb(parcel, C1814g.CREATOR);
                zzbn.zzf(parcel);
                J(n7Var19, c1814g);
                parcel2.writeNoException();
                return true;
            case 31:
                n7 n7Var20 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                Bundle bundle3 = (Bundle) zzbn.zzb(parcel, Bundle.CREATOR);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
                    c1849k2 = iInterfaceQueryLocalInterface2 instanceof InterfaceC1865m2 ? (InterfaceC1865m2) iInterfaceQueryLocalInterface2 : new C1849k2(strongBinder2);
                }
                zzbn.zzf(parcel);
                d(n7Var20, bundle3, c1849k2);
                parcel2.writeNoException();
                return true;
        }
    }
}
