package o1;

import J1.C0047x;
import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.versionedparcelable.ParcelImpl;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import java.util.ArrayList;
import p0.C0900l;
import p0.I;
import p0.J;
import q1.C0920a;
import q1.C0921b;
import s1.C0984a;
import s3.B0;
import s3.D;
import s3.I0;
import u1.C1200b;
import u1.C1202d;
import u1.u;
import y1.C1421a;
import y1.C1422b;
import y1.C1423c;
import z1.C1456a;
import z1.C1462g;

/* JADX INFO: loaded from: classes.dex */
public final class r implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8673a;

    public /* synthetic */ r(int i) {
        this.f8673a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f8673a) {
            case 0:
                int iK0 = D.k0(parcel);
                PendingIntent pendingIntent = null;
                while (parcel.dataPosition() < iK0) {
                    int i = parcel.readInt();
                    if (((char) i) != 1) {
                        D.j0(i, parcel);
                    } else {
                        pendingIntent = (PendingIntent) D.z(parcel, i, PendingIntent.CREATOR);
                    }
                }
                D.G(iK0, parcel);
                return new g(pendingIntent);
            case 1:
                int iK02 = D.k0(parcel);
                int iA0 = 0;
                while (parcel.dataPosition() < iK02) {
                    int i6 = parcel.readInt();
                    if (((char) i6) != 1) {
                        D.j0(i6, parcel);
                    } else {
                        iA0 = D.a0(i6, parcel);
                    }
                }
                D.G(iK02, parcel);
                return new i(iA0);
            case 2:
                int iK03 = D.k0(parcel);
                boolean zW = false;
                int iA02 = 0;
                String strA = null;
                String strA2 = null;
                String strA3 = null;
                String strA4 = null;
                while (parcel.dataPosition() < iK03) {
                    int i7 = parcel.readInt();
                    switch ((char) i7) {
                        case 1:
                            strA = D.A(i7, parcel);
                            break;
                        case 2:
                            strA2 = D.A(i7, parcel);
                            break;
                        case 3:
                            strA3 = D.A(i7, parcel);
                            break;
                        case 4:
                            strA4 = D.A(i7, parcel);
                            break;
                        case 5:
                            zW = D.W(i7, parcel);
                            break;
                        case 6:
                            iA02 = D.a0(i7, parcel);
                            break;
                        default:
                            D.j0(i7, parcel);
                            break;
                    }
                }
                D.G(iK03, parcel);
                return new j(strA, strA2, strA3, strA4, zW, iA02);
            case 3:
                int iK04 = D.k0(parcel);
                boolean zW2 = false;
                boolean zW3 = false;
                boolean zW4 = false;
                String strA5 = null;
                String strA6 = null;
                String strA7 = null;
                ArrayList arrayListB = null;
                while (parcel.dataPosition() < iK04) {
                    int i8 = parcel.readInt();
                    switch ((char) i8) {
                        case 1:
                            zW2 = D.W(i8, parcel);
                            break;
                        case 2:
                            strA5 = D.A(i8, parcel);
                            break;
                        case 3:
                            strA6 = D.A(i8, parcel);
                            break;
                        case 4:
                            zW3 = D.W(i8, parcel);
                            break;
                        case 5:
                            strA7 = D.A(i8, parcel);
                            break;
                        case 6:
                            arrayListB = D.B(i8, parcel);
                            break;
                        case 7:
                            zW4 = D.W(i8, parcel);
                            break;
                        default:
                            D.j0(i8, parcel);
                            break;
                    }
                }
                D.G(iK04, parcel);
                return new b(zW2, strA5, strA6, zW3, strA7, arrayListB, zW4);
            case 4:
                int iK05 = D.k0(parcel);
                String strA8 = null;
                boolean zW5 = false;
                while (parcel.dataPosition() < iK05) {
                    int i9 = parcel.readInt();
                    char c6 = (char) i9;
                    if (c6 == 1) {
                        zW5 = D.W(i9, parcel);
                    } else if (c6 != 2) {
                        D.j0(i9, parcel);
                    } else {
                        strA8 = D.A(i9, parcel);
                    }
                }
                D.G(iK05, parcel);
                return new c(strA8, zW5);
            case 5:
                int iK06 = D.k0(parcel);
                byte[] bArrX = null;
                boolean zW6 = false;
                String strA9 = null;
                while (parcel.dataPosition() < iK06) {
                    int i10 = parcel.readInt();
                    char c7 = (char) i10;
                    if (c7 == 1) {
                        zW6 = D.W(i10, parcel);
                    } else if (c7 == 2) {
                        bArrX = D.x(i10, parcel);
                    } else if (c7 != 3) {
                        D.j0(i10, parcel);
                    } else {
                        strA9 = D.A(i10, parcel);
                    }
                }
                D.G(iK06, parcel);
                return new d(zW6, bArrX, strA9);
            case 6:
                int iK07 = D.k0(parcel);
                boolean zW7 = false;
                while (parcel.dataPosition() < iK07) {
                    int i11 = parcel.readInt();
                    if (((char) i11) != 1) {
                        D.j0(i11, parcel);
                    } else {
                        zW7 = D.W(i11, parcel);
                    }
                }
                D.G(iK07, parcel);
                return new e(zW7);
            case 7:
                int iK08 = D.k0(parcel);
                int iA03 = 0;
                PendingIntent pendingIntent2 = null;
                String strA10 = null;
                String strA11 = null;
                ArrayList arrayListB2 = null;
                String strA12 = null;
                while (parcel.dataPosition() < iK08) {
                    int i12 = parcel.readInt();
                    switch ((char) i12) {
                        case 1:
                            pendingIntent2 = (PendingIntent) D.z(parcel, i12, PendingIntent.CREATOR);
                            break;
                        case 2:
                            strA10 = D.A(i12, parcel);
                            break;
                        case 3:
                            strA11 = D.A(i12, parcel);
                            break;
                        case 4:
                            arrayListB2 = D.B(i12, parcel);
                            break;
                        case 5:
                            strA12 = D.A(i12, parcel);
                            break;
                        case 6:
                            iA03 = D.a0(i12, parcel);
                            break;
                        default:
                            D.j0(i12, parcel);
                            break;
                    }
                }
                D.G(iK08, parcel);
                return new SaveAccountLinkingTokenRequest(pendingIntent2, strA10, strA11, arrayListB2, strA12, iA03);
            case 8:
                int iK09 = D.k0(parcel);
                PendingIntent pendingIntent3 = null;
                while (parcel.dataPosition() < iK09) {
                    int i13 = parcel.readInt();
                    if (((char) i13) != 1) {
                        D.j0(i13, parcel);
                    } else {
                        pendingIntent3 = (PendingIntent) D.z(parcel, i13, PendingIntent.CREATOR);
                    }
                }
                D.G(iK09, parcel);
                return new k(pendingIntent3);
            case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                int iK010 = D.k0(parcel);
                int iA04 = 0;
                p pVar = null;
                String strA13 = null;
                while (parcel.dataPosition() < iK010) {
                    int i14 = parcel.readInt();
                    char c8 = (char) i14;
                    if (c8 == 1) {
                        pVar = (p) D.z(parcel, i14, p.CREATOR);
                    } else if (c8 == 2) {
                        strA13 = D.A(i14, parcel);
                    } else if (c8 != 3) {
                        D.j0(i14, parcel);
                    } else {
                        iA04 = D.a0(i14, parcel);
                    }
                }
                D.G(iK010, parcel);
                return new l(pVar, strA13, iA04);
            case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                int iK011 = D.k0(parcel);
                PendingIntent pendingIntent4 = null;
                while (parcel.dataPosition() < iK011) {
                    int i15 = parcel.readInt();
                    if (((char) i15) != 1) {
                        D.j0(i15, parcel);
                    } else {
                        pendingIntent4 = (PendingIntent) D.z(parcel, i15, PendingIntent.CREATOR);
                    }
                }
                D.G(iK011, parcel);
                return new m(pendingIntent4);
            case 11:
                int iK012 = D.k0(parcel);
                String strA14 = null;
                String strA15 = null;
                String strA16 = null;
                String strA17 = null;
                Uri uri = null;
                String strA18 = null;
                String strA19 = null;
                String strA20 = null;
                C0047x c0047x = null;
                while (parcel.dataPosition() < iK012) {
                    int i16 = parcel.readInt();
                    switch ((char) i16) {
                        case 1:
                            strA14 = D.A(i16, parcel);
                            break;
                        case 2:
                            strA15 = D.A(i16, parcel);
                            break;
                        case 3:
                            strA16 = D.A(i16, parcel);
                            break;
                        case 4:
                            strA17 = D.A(i16, parcel);
                            break;
                        case 5:
                            uri = (Uri) D.z(parcel, i16, Uri.CREATOR);
                            break;
                        case 6:
                            strA18 = D.A(i16, parcel);
                            break;
                        case 7:
                            strA19 = D.A(i16, parcel);
                            break;
                        case '\b':
                            strA20 = D.A(i16, parcel);
                            break;
                        case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            c0047x = (C0047x) D.z(parcel, i16, C0047x.CREATOR);
                            break;
                        default:
                            D.j0(i16, parcel);
                            break;
                    }
                }
                D.G(iK012, parcel);
                return new o(strA14, strA15, strA16, strA17, uri, strA18, strA19, strA20, c0047x);
            case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                int iK013 = D.k0(parcel);
                String strA21 = null;
                String strA22 = null;
                while (parcel.dataPosition() < iK013) {
                    int i17 = parcel.readInt();
                    char c9 = (char) i17;
                    if (c9 == 1) {
                        strA21 = D.A(i17, parcel);
                    } else if (c9 != 2) {
                        D.j0(i17, parcel);
                    } else {
                        strA22 = D.A(i17, parcel);
                    }
                }
                D.G(iK013, parcel);
                return new p(strA21, strA22);
            case 13:
                C0900l c0900l = new C0900l();
                c0900l.f9041a = parcel.readInt();
                c0900l.f9042b = parcel.readInt();
                c0900l.f9043c = parcel.readInt() == 1;
                return c0900l;
            case 14:
                I i18 = new I();
                i18.f8972a = parcel.readInt();
                i18.f8973b = parcel.readInt();
                i18.f8975d = parcel.readInt() == 1;
                int i19 = parcel.readInt();
                if (i19 > 0) {
                    int[] iArr = new int[i19];
                    i18.f8974c = iArr;
                    parcel.readIntArray(iArr);
                }
                return i18;
            case 15:
                J j4 = new J();
                j4.f8976a = parcel.readInt();
                j4.f8977b = parcel.readInt();
                int i20 = parcel.readInt();
                j4.f8978c = i20;
                if (i20 > 0) {
                    int[] iArr2 = new int[i20];
                    j4.f8979d = iArr2;
                    parcel.readIntArray(iArr2);
                }
                int i21 = parcel.readInt();
                j4.e = i21;
                if (i21 > 0) {
                    int[] iArr3 = new int[i21];
                    j4.f8980f = iArr3;
                    parcel.readIntArray(iArr3);
                }
                j4.f8982l = parcel.readInt() == 1;
                j4.f8983m = parcel.readInt() == 1;
                j4.f8984n = parcel.readInt() == 1;
                j4.f8981k = parcel.readArrayList(I.class.getClassLoader());
                return j4;
            case 16:
                int iK014 = D.k0(parcel);
                String strA23 = null;
                byte[] bArrX2 = null;
                Bundle bundleW = null;
                long jC0 = 0;
                int iA05 = 0;
                int iA06 = 0;
                while (parcel.dataPosition() < iK014) {
                    int i22 = parcel.readInt();
                    char c10 = (char) i22;
                    if (c10 == 1) {
                        strA23 = D.A(i22, parcel);
                    } else if (c10 == 2) {
                        iA06 = D.a0(i22, parcel);
                    } else if (c10 == 3) {
                        jC0 = D.c0(i22, parcel);
                    } else if (c10 == 4) {
                        bArrX2 = D.x(i22, parcel);
                    } else if (c10 == 5) {
                        bundleW = D.w(i22, parcel);
                    } else if (c10 != 1000) {
                        D.j0(i22, parcel);
                    } else {
                        iA05 = D.a0(i22, parcel);
                    }
                }
                D.G(iK014, parcel);
                return new C0920a(iA05, strA23, iA06, jC0, bArrX2, bundleW);
            case I0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                int iK015 = D.k0(parcel);
                PendingIntent pendingIntent5 = null;
                Bundle bundleW2 = null;
                byte[] bArrX3 = null;
                int iA07 = 0;
                int iA08 = 0;
                int iA09 = 0;
                while (parcel.dataPosition() < iK015) {
                    int i23 = parcel.readInt();
                    char c11 = (char) i23;
                    if (c11 == 1) {
                        iA08 = D.a0(i23, parcel);
                    } else if (c11 == 2) {
                        pendingIntent5 = (PendingIntent) D.z(parcel, i23, PendingIntent.CREATOR);
                    } else if (c11 == 3) {
                        iA09 = D.a0(i23, parcel);
                    } else if (c11 == 4) {
                        bundleW2 = D.w(i23, parcel);
                    } else if (c11 == 5) {
                        bArrX3 = D.x(i23, parcel);
                    } else if (c11 != 1000) {
                        D.j0(i23, parcel);
                    } else {
                        iA07 = D.a0(i23, parcel);
                    }
                }
                D.G(iK015, parcel);
                return new C0921b(iA07, iA08, pendingIntent5, iA09, bundleW2, bArrX3);
            case I0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                int iK016 = D.k0(parcel);
                Bundle bundleW3 = null;
                int iA010 = 0;
                int iA011 = 0;
                while (parcel.dataPosition() < iK016) {
                    int i24 = parcel.readInt();
                    char c12 = (char) i24;
                    if (c12 == 1) {
                        iA010 = D.a0(i24, parcel);
                    } else if (c12 == 2) {
                        iA011 = D.a0(i24, parcel);
                    } else if (c12 != 3) {
                        D.j0(i24, parcel);
                    } else {
                        bundleW3 = D.w(i24, parcel);
                    }
                }
                D.G(iK016, parcel);
                return new C0984a(iA010, iA011, bundleW3);
            case 19:
                int iK017 = D.k0(parcel);
                String strA24 = null;
                GoogleSignInOptions googleSignInOptions = null;
                while (parcel.dataPosition() < iK017) {
                    int i25 = parcel.readInt();
                    char c13 = (char) i25;
                    if (c13 == 2) {
                        strA24 = D.A(i25, parcel);
                    } else if (c13 != 5) {
                        D.j0(i25, parcel);
                    } else {
                        googleSignInOptions = (GoogleSignInOptions) D.z(parcel, i25, GoogleSignInOptions.CREATOR);
                    }
                }
                D.G(iK017, parcel);
                return new SignInConfiguration(strA24, googleSignInOptions);
            case 20:
                return new ParcelImpl(parcel);
            case 21:
                int iK018 = D.k0(parcel);
                PendingIntent pendingIntent6 = null;
                int iA012 = 0;
                int iA013 = 0;
                String strA25 = null;
                while (parcel.dataPosition() < iK018) {
                    int i26 = parcel.readInt();
                    char c14 = (char) i26;
                    if (c14 == 1) {
                        iA012 = D.a0(i26, parcel);
                    } else if (c14 == 2) {
                        iA013 = D.a0(i26, parcel);
                    } else if (c14 == 3) {
                        pendingIntent6 = (PendingIntent) D.z(parcel, i26, PendingIntent.CREATOR);
                    } else if (c14 != 4) {
                        D.j0(i26, parcel);
                    } else {
                        strA25 = D.A(i26, parcel);
                    }
                }
                D.G(iK018, parcel);
                return new C1200b(iA012, iA013, pendingIntent6, strA25);
            case 22:
                int iK019 = D.k0(parcel);
                long jC02 = -1;
                int iA014 = 0;
                String strA26 = null;
                while (parcel.dataPosition() < iK019) {
                    int i27 = parcel.readInt();
                    char c15 = (char) i27;
                    if (c15 == 1) {
                        strA26 = D.A(i27, parcel);
                    } else if (c15 == 2) {
                        iA014 = D.a0(i27, parcel);
                    } else if (c15 != 3) {
                        D.j0(i27, parcel);
                    } else {
                        jC02 = D.c0(i27, parcel);
                    }
                }
                D.G(iK019, parcel);
                return new C1202d(jC02, strA26, iA014);
            case 23:
                int iK020 = D.k0(parcel);
                boolean zW8 = false;
                boolean zW9 = false;
                boolean zW10 = false;
                boolean zW11 = false;
                String strA27 = null;
                IBinder iBinderZ = null;
                while (parcel.dataPosition() < iK020) {
                    int i28 = parcel.readInt();
                    switch ((char) i28) {
                        case 1:
                            strA27 = D.A(i28, parcel);
                            break;
                        case 2:
                            zW8 = D.W(i28, parcel);
                            break;
                        case 3:
                            zW9 = D.W(i28, parcel);
                            break;
                        case 4:
                            iBinderZ = D.Z(i28, parcel);
                            break;
                        case 5:
                            zW10 = D.W(i28, parcel);
                            break;
                        case 6:
                            zW11 = D.W(i28, parcel);
                            break;
                        default:
                            D.j0(i28, parcel);
                            break;
                    }
                }
                D.G(iK020, parcel);
                return new u1.s(strA27, zW8, zW9, iBinderZ, zW10, zW11);
            case 24:
                int iK021 = D.k0(parcel);
                boolean zW12 = false;
                int iA015 = 0;
                String strA28 = null;
                int iA016 = 0;
                while (parcel.dataPosition() < iK021) {
                    int i29 = parcel.readInt();
                    char c16 = (char) i29;
                    if (c16 == 1) {
                        zW12 = D.W(i29, parcel);
                    } else if (c16 == 2) {
                        strA28 = D.A(i29, parcel);
                    } else if (c16 == 3) {
                        iA016 = D.a0(i29, parcel);
                    } else if (c16 != 4) {
                        D.j0(i29, parcel);
                    } else {
                        iA015 = D.a0(i29, parcel);
                    }
                }
                D.G(iK021, parcel);
                return new u1.t(iA016, iA015, strA28, zW12);
            case 25:
                int iK022 = D.k0(parcel);
                boolean zW13 = false;
                String strA29 = null;
                IBinder iBinderZ2 = null;
                boolean zW14 = false;
                while (parcel.dataPosition() < iK022) {
                    int i30 = parcel.readInt();
                    char c17 = (char) i30;
                    if (c17 == 1) {
                        strA29 = D.A(i30, parcel);
                    } else if (c17 == 2) {
                        iBinderZ2 = D.Z(i30, parcel);
                    } else if (c17 == 3) {
                        zW13 = D.W(i30, parcel);
                    } else if (c17 != 4) {
                        D.j0(i30, parcel);
                    } else {
                        zW14 = D.W(i30, parcel);
                    }
                }
                D.G(iK022, parcel);
                return new u(strA29, iBinderZ2, zW13, zW14);
            case 26:
                int iK023 = D.k0(parcel);
                C1421a c1421a = null;
                int iA017 = 0;
                while (parcel.dataPosition() < iK023) {
                    int i31 = parcel.readInt();
                    char c18 = (char) i31;
                    if (c18 == 1) {
                        iA017 = D.a0(i31, parcel);
                    } else if (c18 != 2) {
                        D.j0(i31, parcel);
                    } else {
                        c1421a = (C1421a) D.z(parcel, i31, C1421a.CREATOR);
                    }
                }
                D.G(iK023, parcel);
                return new C1422b(iA017, c1421a);
            case 27:
                int iK024 = D.k0(parcel);
                ArrayList arrayListD = null;
                int iA018 = 0;
                while (parcel.dataPosition() < iK024) {
                    int i32 = parcel.readInt();
                    char c19 = (char) i32;
                    if (c19 == 1) {
                        iA018 = D.a0(i32, parcel);
                    } else if (c19 != 2) {
                        D.j0(i32, parcel);
                    } else {
                        arrayListD = D.D(parcel, i32, C1423c.CREATOR);
                    }
                }
                D.G(iK024, parcel);
                return new C1421a(iA018, arrayListD);
            case 28:
                int iK025 = D.k0(parcel);
                int iA019 = 0;
                String strA30 = null;
                int iA020 = 0;
                while (parcel.dataPosition() < iK025) {
                    int i33 = parcel.readInt();
                    char c20 = (char) i33;
                    if (c20 == 1) {
                        iA019 = D.a0(i33, parcel);
                    } else if (c20 == 2) {
                        strA30 = D.A(i33, parcel);
                    } else if (c20 != 3) {
                        D.j0(i33, parcel);
                    } else {
                        iA020 = D.a0(i33, parcel);
                    }
                }
                D.G(iK025, parcel);
                return new C1423c(iA019, strA30, iA020);
            default:
                int iK026 = D.k0(parcel);
                String strA31 = null;
                int iA021 = 0;
                C1456a c1456a = null;
                while (parcel.dataPosition() < iK026) {
                    int i34 = parcel.readInt();
                    char c21 = (char) i34;
                    if (c21 == 1) {
                        iA021 = D.a0(i34, parcel);
                    } else if (c21 == 2) {
                        strA31 = D.A(i34, parcel);
                    } else if (c21 != 3) {
                        D.j0(i34, parcel);
                    } else {
                        c1456a = (C1456a) D.z(parcel, i34, C1456a.CREATOR);
                    }
                }
                D.G(iK026, parcel);
                return new C1462g(c1456a, strA31, iA021);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f8673a) {
            case 0:
                return new g[i];
            case 1:
                return new i[i];
            case 2:
                return new j[i];
            case 3:
                return new b[i];
            case 4:
                return new c[i];
            case 5:
                return new d[i];
            case 6:
                return new e[i];
            case 7:
                return new SaveAccountLinkingTokenRequest[i];
            case 8:
                return new k[i];
            case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return new l[i];
            case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return new m[i];
            case 11:
                return new o[i];
            case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                return new p[i];
            case 13:
                return new C0900l[i];
            case 14:
                return new I[i];
            case 15:
                return new J[i];
            case 16:
                return new C0920a[i];
            case I0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return new C0921b[i];
            case I0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                return new C0984a[i];
            case 19:
                return new SignInConfiguration[i];
            case 20:
                return new ParcelImpl[i];
            case 21:
                return new C1200b[i];
            case 22:
                return new C1202d[i];
            case 23:
                return new u1.s[i];
            case 24:
                return new u1.t[i];
            case 25:
                return new u[i];
            case 26:
                return new C1422b[i];
            case 27:
                return new C1421a[i];
            case 28:
                return new C1423c[i];
            default:
                return new C1462g[i];
        }
    }
}
