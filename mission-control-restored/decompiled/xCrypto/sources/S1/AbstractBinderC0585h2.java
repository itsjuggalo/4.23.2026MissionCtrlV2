package S1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbm;
import com.google.android.gms.internal.measurement.zzbn;
import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import io.flutter.Build;
import java.util.List;
import p2.C1698D;

/* JADX INFO: renamed from: S1.h2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC0585h2 extends zzbm implements InterfaceC0601j2 {
    public AbstractBinderC0585h2() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) {
        InterfaceC0649p2 c0633n2 = null;
        InterfaceC0625m2 c0609k2 = null;
        switch (i4) {
            case 1:
                J j4 = (J) zzbn.zzb(parcel, J.CREATOR);
                n7 n7Var = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                s(j4, n7Var);
                parcel2.writeNoException();
                return true;
            case 2:
                h7 h7Var = (h7) zzbn.zzb(parcel, h7.CREATOR);
                n7 n7Var2 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                E(h7Var, n7Var2);
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            case Build.API_LEVELS.API_22 /* 22 */:
            case Build.API_LEVELS.API_23 /* 23 */:
            case Build.API_LEVELS.API_28 /* 28 */:
            default:
                return false;
            case 4:
                n7 n7Var3 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                Q(n7Var3);
                parcel2.writeNoException();
                return true;
            case 5:
                J j5 = (J) zzbn.zzb(parcel, J.CREATOR);
                String string = parcel.readString();
                String string2 = parcel.readString();
                zzbn.zzf(parcel);
                S(j5, string, string2);
                parcel2.writeNoException();
                return true;
            case 6:
                n7 n7Var4 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                X(n7Var4);
                parcel2.writeNoException();
                return true;
            case 7:
                n7 n7Var5 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                boolean zZza = zzbn.zza(parcel);
                zzbn.zzf(parcel);
                List listI = i(n7Var5, zZza);
                parcel2.writeNoException();
                parcel2.writeTypedList(listI);
                return true;
            case 9:
                J j6 = (J) zzbn.zzb(parcel, J.CREATOR);
                String string3 = parcel.readString();
                zzbn.zzf(parcel);
                byte[] bArrO = o(j6, string3);
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrO);
                return true;
            case 10:
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
                String strG = g(n7Var6);
                parcel2.writeNoException();
                parcel2.writeString(strG);
                return true;
            case 12:
                C0590i c0590i = (C0590i) zzbn.zzb(parcel, C0590i.CREATOR);
                n7 n7Var7 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                G(c0590i, n7Var7);
                parcel2.writeNoException();
                return true;
            case 13:
                C0590i c0590i2 = (C0590i) zzbn.zzb(parcel, C0590i.CREATOR);
                zzbn.zzf(parcel);
                L(c0590i2);
                parcel2.writeNoException();
                return true;
            case 14:
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                boolean zZza2 = zzbn.zza(parcel);
                n7 n7Var8 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                List listP = P(string7, string8, zZza2, n7Var8);
                parcel2.writeNoException();
                parcel2.writeTypedList(listP);
                return true;
            case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                String string9 = parcel.readString();
                String string10 = parcel.readString();
                String string11 = parcel.readString();
                boolean zZza3 = zzbn.zza(parcel);
                zzbn.zzf(parcel);
                List listD = d(string9, string10, string11, zZza3);
                parcel2.writeNoException();
                parcel2.writeTypedList(listD);
                return true;
            case 16:
                String string12 = parcel.readString();
                String string13 = parcel.readString();
                n7 n7Var9 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                List listC = C(string12, string13, n7Var9);
                parcel2.writeNoException();
                parcel2.writeTypedList(listC);
                return true;
            case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                String string14 = parcel.readString();
                String string15 = parcel.readString();
                String string16 = parcel.readString();
                zzbn.zzf(parcel);
                List listU = u(string14, string15, string16);
                parcel2.writeNoException();
                parcel2.writeTypedList(listU);
                return true;
            case C1698D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                n7 n7Var10 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                r(n7Var10);
                parcel2.writeNoException();
                return true;
            case 19:
                Bundle bundle = (Bundle) zzbn.zzb(parcel, Bundle.CREATOR);
                n7 n7Var11 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                t(bundle, n7Var11);
                parcel2.writeNoException();
                return true;
            case FirestoreIndexValueWriter.INDEX_TYPE_TIMESTAMP /* 20 */:
                n7 n7Var12 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                D(n7Var12);
                parcel2.writeNoException();
                return true;
            case Build.API_LEVELS.API_21 /* 21 */:
                n7 n7Var13 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                C0646p c0646pX = x(n7Var13);
                parcel2.writeNoException();
                if (c0646pX == null) {
                    parcel2.writeInt(0);
                } else {
                    parcel2.writeInt(1);
                    c0646pX.writeToParcel(parcel2, 1);
                }
                return true;
            case 24:
                n7 n7Var14 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                Bundle bundle2 = (Bundle) zzbn.zzb(parcel, Bundle.CREATOR);
                zzbn.zzf(parcel);
                List listT = T(n7Var14, bundle2);
                parcel2.writeNoException();
                parcel2.writeTypedList(listT);
                return true;
            case 25:
                n7 n7Var15 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                M(n7Var15);
                parcel2.writeNoException();
                return true;
            case Build.API_LEVELS.API_26 /* 26 */:
                n7 n7Var16 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                W(n7Var16);
                parcel2.writeNoException();
                return true;
            case Build.API_LEVELS.API_27 /* 27 */:
                n7 n7Var17 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                zzbn.zzf(parcel);
                k(n7Var17);
                parcel2.writeNoException();
                return true;
            case Build.API_LEVELS.API_29 /* 29 */:
                n7 n7Var18 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                I6 i6 = (I6) zzbn.zzb(parcel, I6.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
                    c0633n2 = iInterfaceQueryLocalInterface instanceof InterfaceC0649p2 ? (InterfaceC0649p2) iInterfaceQueryLocalInterface : new C0633n2(strongBinder);
                }
                zzbn.zzf(parcel);
                Y(n7Var18, i6, c0633n2);
                parcel2.writeNoException();
                return true;
            case 30:
                n7 n7Var19 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                C0574g c0574g = (C0574g) zzbn.zzb(parcel, C0574g.CREATOR);
                zzbn.zzf(parcel);
                I(n7Var19, c0574g);
                parcel2.writeNoException();
                return true;
            case Build.API_LEVELS.API_31 /* 31 */:
                n7 n7Var20 = (n7) zzbn.zzb(parcel, n7.CREATOR);
                Bundle bundle3 = (Bundle) zzbn.zzb(parcel, Bundle.CREATOR);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
                    c0609k2 = iInterfaceQueryLocalInterface2 instanceof InterfaceC0625m2 ? (InterfaceC0625m2) iInterfaceQueryLocalInterface2 : new C0609k2(strongBinder2);
                }
                zzbn.zzf(parcel);
                p(n7Var20, bundle3, c0609k2);
                parcel2.writeNoException();
                return true;
        }
    }
}
