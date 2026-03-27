package J1;

import N1.C0084d;
import N1.C0087e;
import N1.C0099i;
import N1.C0131t;
import N1.C0134u;
import N1.J1;
import N1.M1;
import N1.N1;
import N1.O1;
import N1.W1;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.common.Transport;
import com.google.android.gms.fido.u2f.api.common.RegisterRequestParams;
import com.google.android.gms.fido.u2f.api.common.SignRequestParams;
import java.util.ArrayList;
import s3.B0;
import s3.I0;
import t2.u0;

/* JADX INFO: loaded from: classes.dex */
public final class Y implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f705a;

    public /* synthetic */ Y(int i) {
        this.f705a = i;
    }

    public static void a(C0134u c0134u, Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.T(parcel, 2, c0134u.f1795a, false);
        u0.S(parcel, 3, c0134u.f1796b, i, false);
        u0.T(parcel, 4, c0134u.f1797c, false);
        u0.b0(parcel, 5, 8);
        parcel.writeLong(c0134u.f1798d);
        u0.a0(iX, parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f705a) {
            case 0:
                int iK0 = s3.D.k0(parcel);
                byte[] bArrX = null;
                boolean zW = false;
                while (parcel.dataPosition() < iK0) {
                    int i = parcel.readInt();
                    char c6 = (char) i;
                    if (c6 == 1) {
                        zW = s3.D.W(i, parcel);
                    } else if (c6 != 2) {
                        s3.D.j0(i, parcel);
                    } else {
                        bArrX = s3.D.x(i, parcel);
                    }
                }
                s3.D.G(iK0, parcel);
                return new X(zW, bArrX);
            case 1:
                int iK02 = s3.D.k0(parcel);
                byte[] bArrX2 = null;
                byte[] bArrX3 = null;
                byte[] bArrX4 = null;
                byte[] bArrX5 = null;
                byte[] bArrX6 = null;
                while (parcel.dataPosition() < iK02) {
                    int i6 = parcel.readInt();
                    char c7 = (char) i6;
                    if (c7 == 2) {
                        bArrX2 = s3.D.x(i6, parcel);
                    } else if (c7 == 3) {
                        bArrX3 = s3.D.x(i6, parcel);
                    } else if (c7 == 4) {
                        bArrX4 = s3.D.x(i6, parcel);
                    } else if (c7 == 5) {
                        bArrX5 = s3.D.x(i6, parcel);
                    } else if (c7 != 6) {
                        s3.D.j0(i6, parcel);
                    } else {
                        bArrX6 = s3.D.x(i6, parcel);
                    }
                }
                s3.D.G(iK02, parcel);
                return new C0033i(bArrX2, bArrX3, bArrX4, bArrX5, bArrX6);
            case 2:
                int iK03 = s3.D.k0(parcel);
                byte[] bArrX7 = null;
                byte[] bArrX8 = null;
                byte[] bArrX9 = null;
                String[] strArr = null;
                while (parcel.dataPosition() < iK03) {
                    int i7 = parcel.readInt();
                    char c8 = (char) i7;
                    if (c8 == 2) {
                        bArrX7 = s3.D.x(i7, parcel);
                    } else if (c8 == 3) {
                        bArrX8 = s3.D.x(i7, parcel);
                    } else if (c8 == 4) {
                        bArrX9 = s3.D.x(i7, parcel);
                    } else if (c8 != 5) {
                        s3.D.j0(i7, parcel);
                    } else {
                        int iE0 = s3.D.e0(i7, parcel);
                        int iDataPosition = parcel.dataPosition();
                        if (iE0 == 0) {
                            strArr = null;
                        } else {
                            String[] strArrCreateStringArray = parcel.createStringArray();
                            parcel.setDataPosition(iDataPosition + iE0);
                            strArr = strArrCreateStringArray;
                        }
                    }
                }
                s3.D.G(iK03, parcel);
                return new C0034j(bArrX7, bArrX8, bArrX9, strArr);
            case 3:
                int iK04 = s3.D.k0(parcel);
                int iA0 = 0;
                String strA = null;
                int iA02 = 0;
                while (parcel.dataPosition() < iK04) {
                    int i8 = parcel.readInt();
                    char c9 = (char) i8;
                    if (c9 == 2) {
                        iA0 = s3.D.a0(i8, parcel);
                    } else if (c9 == 3) {
                        strA = s3.D.A(i8, parcel);
                    } else if (c9 != 4) {
                        s3.D.j0(i8, parcel);
                    } else {
                        iA02 = s3.D.a0(i8, parcel);
                    }
                }
                s3.D.G(iK04, parcel);
                return new C0035k(iA0, strA, iA02);
            case 4:
                int iK05 = s3.D.k0(parcel);
                String strA2 = null;
                Boolean boolX = null;
                String strA3 = null;
                String strA4 = null;
                while (parcel.dataPosition() < iK05) {
                    int i9 = parcel.readInt();
                    char c10 = (char) i9;
                    if (c10 == 2) {
                        strA2 = s3.D.A(i9, parcel);
                    } else if (c10 == 3) {
                        boolX = s3.D.X(i9, parcel);
                    } else if (c10 == 4) {
                        strA3 = s3.D.A(i9, parcel);
                    } else if (c10 != 5) {
                        s3.D.j0(i9, parcel);
                    } else {
                        strA4 = s3.D.A(i9, parcel);
                    }
                }
                s3.D.G(iK05, parcel);
                return new C0037m(strA2, boolX, strA3, strA4);
            case 5:
                int iK06 = s3.D.k0(parcel);
                C0048y c0048y = null;
                Uri uri = null;
                byte[] bArrX10 = null;
                while (parcel.dataPosition() < iK06) {
                    int i10 = parcel.readInt();
                    char c11 = (char) i10;
                    if (c11 == 2) {
                        c0048y = (C0048y) s3.D.z(parcel, i10, C0048y.CREATOR);
                    } else if (c11 == 3) {
                        uri = (Uri) s3.D.z(parcel, i10, Uri.CREATOR);
                    } else if (c11 != 4) {
                        s3.D.j0(i10, parcel);
                    } else {
                        bArrX10 = s3.D.x(i10, parcel);
                    }
                }
                s3.D.G(iK06, parcel);
                return new C0038n(c0048y, uri, bArrX10);
            case 6:
                int iK07 = s3.D.k0(parcel);
                B b3 = null;
                Uri uri2 = null;
                byte[] bArrX11 = null;
                while (parcel.dataPosition() < iK07) {
                    int i11 = parcel.readInt();
                    char c12 = (char) i11;
                    if (c12 == 2) {
                        b3 = (B) s3.D.z(parcel, i11, B.CREATOR);
                    } else if (c12 == 3) {
                        uri2 = (Uri) s3.D.z(parcel, i11, Uri.CREATOR);
                    } else if (c12 != 4) {
                        s3.D.j0(i11, parcel);
                    } else {
                        bArrX11 = s3.D.x(i11, parcel);
                    }
                }
                s3.D.G(iK07, parcel);
                return new C0039o(b3, uri2, bArrX11);
            case 7:
                try {
                    return r.a(parcel.readInt());
                } catch (C0041q e) {
                    throw new RuntimeException(e);
                }
            case 8:
                int iK08 = s3.D.k0(parcel);
                byte[] bArrX12 = null;
                byte[] bArrX13 = null;
                byte[] bArrX14 = null;
                long jC0 = 0;
                while (parcel.dataPosition() < iK08) {
                    int i12 = parcel.readInt();
                    char c13 = (char) i12;
                    if (c13 == 1) {
                        jC0 = s3.D.c0(i12, parcel);
                    } else if (c13 == 2) {
                        bArrX12 = s3.D.x(i12, parcel);
                    } else if (c13 == 3) {
                        bArrX13 = s3.D.x(i12, parcel);
                    } else if (c13 != 4) {
                        s3.D.j0(i12, parcel);
                    } else {
                        bArrX14 = s3.D.x(i12, parcel);
                    }
                }
                s3.D.G(iK08, parcel);
                return new Z(jC0, bArrX12, bArrX13, bArrX14);
            case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                int iK09 = s3.D.k0(parcel);
                ArrayList arrayListD = null;
                while (parcel.dataPosition() < iK09) {
                    int i13 = parcel.readInt();
                    if (((char) i13) != 1) {
                        s3.D.j0(i13, parcel);
                    } else {
                        arrayListD = s3.D.D(parcel, i13, Z.CREATOR);
                    }
                }
                s3.D.G(iK09, parcel);
                return new a0(arrayListD);
            case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                int iK010 = s3.D.k0(parcel);
                boolean zW2 = false;
                while (parcel.dataPosition() < iK010) {
                    int i14 = parcel.readInt();
                    if (((char) i14) != 1) {
                        s3.D.j0(i14, parcel);
                    } else {
                        zW2 = s3.D.W(i14, parcel);
                    }
                }
                s3.D.G(iK010, parcel);
                return new b0(zW2);
            case 11:
                try {
                    return EnumC0044u.a(parcel.readInt());
                } catch (C0043t e2) {
                    throw new IllegalArgumentException(e2);
                }
            case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                int iK011 = s3.D.k0(parcel);
                String strA5 = null;
                while (parcel.dataPosition() < iK011) {
                    int i15 = parcel.readInt();
                    if (((char) i15) != 2) {
                        s3.D.j0(i15, parcel);
                    } else {
                        strA5 = s3.D.A(i15, parcel);
                    }
                }
                s3.D.G(iK011, parcel);
                return new C0045v(strA5);
            case 13:
                try {
                    return K1.c.m(parcel.readInt());
                } catch (K1.b e6) {
                    throw new RuntimeException(e6);
                }
            case 14:
                int iK012 = s3.D.k0(parcel);
                String strA6 = null;
                int iA03 = 0;
                String strA7 = null;
                while (parcel.dataPosition() < iK012) {
                    int i16 = parcel.readInt();
                    char c14 = (char) i16;
                    if (c14 == 2) {
                        iA03 = s3.D.a0(i16, parcel);
                    } else if (c14 == 3) {
                        strA6 = s3.D.A(i16, parcel);
                    } else if (c14 != 4) {
                        s3.D.j0(i16, parcel);
                    } else {
                        strA7 = s3.D.A(i16, parcel);
                    }
                }
                s3.D.G(iK012, parcel);
                return new K1.c(strA6, iA03, strA7);
            case 15:
                int iK013 = s3.D.k0(parcel);
                byte[] bArrX15 = null;
                ArrayList arrayListD2 = null;
                int iA04 = 0;
                String strA8 = null;
                while (parcel.dataPosition() < iK013) {
                    int i17 = parcel.readInt();
                    char c15 = (char) i17;
                    if (c15 == 1) {
                        iA04 = s3.D.a0(i17, parcel);
                    } else if (c15 == 2) {
                        bArrX15 = s3.D.x(i17, parcel);
                    } else if (c15 == 3) {
                        strA8 = s3.D.A(i17, parcel);
                    } else if (c15 != 4) {
                        s3.D.j0(i17, parcel);
                    } else {
                        arrayListD2 = s3.D.D(parcel, i17, Transport.CREATOR);
                    }
                }
                s3.D.G(iK013, parcel);
                return new K1.d(iA04, bArrX15, strA8, arrayListD2);
            case 16:
                try {
                    return K1.f.a(parcel.readString());
                } catch (K1.e e7) {
                    throw new RuntimeException(e7);
                }
            case I0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                int iK014 = s3.D.k0(parcel);
                String strA9 = null;
                String strA10 = null;
                int iA05 = 0;
                byte[] bArrX16 = null;
                while (parcel.dataPosition() < iK014) {
                    int i18 = parcel.readInt();
                    char c16 = (char) i18;
                    if (c16 == 1) {
                        iA05 = s3.D.a0(i18, parcel);
                    } else if (c16 == 2) {
                        strA9 = s3.D.A(i18, parcel);
                    } else if (c16 == 3) {
                        bArrX16 = s3.D.x(i18, parcel);
                    } else if (c16 != 4) {
                        s3.D.j0(i18, parcel);
                    } else {
                        strA10 = s3.D.A(i18, parcel);
                    }
                }
                s3.D.G(iK014, parcel);
                return new K1.g(iA05, strA9, bArrX16, strA10);
            case I0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                int iK015 = s3.D.k0(parcel);
                Integer numB0 = null;
                Double dY = null;
                Uri uri3 = null;
                ArrayList arrayListD3 = null;
                ArrayList arrayListD4 = null;
                K1.c cVar = null;
                String strA11 = null;
                while (parcel.dataPosition() < iK015) {
                    int i19 = parcel.readInt();
                    switch ((char) i19) {
                        case 2:
                            numB0 = s3.D.b0(i19, parcel);
                            break;
                        case 3:
                            dY = s3.D.Y(i19, parcel);
                            break;
                        case 4:
                            uri3 = (Uri) s3.D.z(parcel, i19, Uri.CREATOR);
                            break;
                        case 5:
                            arrayListD3 = s3.D.D(parcel, i19, K1.g.CREATOR);
                            break;
                        case 6:
                            arrayListD4 = s3.D.D(parcel, i19, K1.h.CREATOR);
                            break;
                        case 7:
                            cVar = (K1.c) s3.D.z(parcel, i19, K1.c.CREATOR);
                            break;
                        case '\b':
                            strA11 = s3.D.A(i19, parcel);
                            break;
                        default:
                            s3.D.j0(i19, parcel);
                            break;
                    }
                }
                s3.D.G(iK015, parcel);
                return new RegisterRequestParams(numB0, dY, uri3, arrayListD3, arrayListD4, cVar, strA11);
            case 19:
                int iK016 = s3.D.k0(parcel);
                K1.d dVar = null;
                String strA12 = null;
                String strA13 = null;
                while (parcel.dataPosition() < iK016) {
                    int i20 = parcel.readInt();
                    char c17 = (char) i20;
                    if (c17 == 2) {
                        dVar = (K1.d) s3.D.z(parcel, i20, K1.d.CREATOR);
                    } else if (c17 == 3) {
                        strA12 = s3.D.A(i20, parcel);
                    } else if (c17 != 4) {
                        s3.D.j0(i20, parcel);
                    } else {
                        strA13 = s3.D.A(i20, parcel);
                    }
                }
                s3.D.G(iK016, parcel);
                return new K1.h(dVar, strA12, strA13);
            case 20:
                int iK017 = s3.D.k0(parcel);
                Integer numB02 = null;
                Double dY2 = null;
                Uri uri4 = null;
                byte[] bArrX17 = null;
                ArrayList arrayListD5 = null;
                K1.c cVar2 = null;
                String strA14 = null;
                while (parcel.dataPosition() < iK017) {
                    int i21 = parcel.readInt();
                    switch ((char) i21) {
                        case 2:
                            numB02 = s3.D.b0(i21, parcel);
                            break;
                        case 3:
                            dY2 = s3.D.Y(i21, parcel);
                            break;
                        case 4:
                            uri4 = (Uri) s3.D.z(parcel, i21, Uri.CREATOR);
                            break;
                        case 5:
                            bArrX17 = s3.D.x(i21, parcel);
                            break;
                        case 6:
                            arrayListD5 = s3.D.D(parcel, i21, K1.h.CREATOR);
                            break;
                        case 7:
                            cVar2 = (K1.c) s3.D.z(parcel, i21, K1.c.CREATOR);
                            break;
                        case '\b':
                            strA14 = s3.D.A(i21, parcel);
                            break;
                        default:
                            s3.D.j0(i21, parcel);
                            break;
                    }
                }
                s3.D.G(iK017, parcel);
                return new SignRequestParams(numB02, dY2, uri4, bArrX17, arrayListD5, cVar2, strA14);
            case 21:
                int iK018 = s3.D.k0(parcel);
                long jC02 = 0;
                long jC03 = 0;
                int iA06 = 0;
                while (parcel.dataPosition() < iK018) {
                    int i22 = parcel.readInt();
                    char c18 = (char) i22;
                    if (c18 == 1) {
                        jC02 = s3.D.c0(i22, parcel);
                    } else if (c18 == 2) {
                        iA06 = s3.D.a0(i22, parcel);
                    } else if (c18 != 3) {
                        s3.D.j0(i22, parcel);
                    } else {
                        jC03 = s3.D.c0(i22, parcel);
                    }
                }
                s3.D.G(iK018, parcel);
                return new C0084d(iA06, jC02, jC03);
            case 22:
                int iK019 = s3.D.k0(parcel);
                String strA15 = null;
                String strA16 = null;
                W1 w12 = null;
                String strA17 = null;
                C0134u c0134u = null;
                C0134u c0134u2 = null;
                C0134u c0134u3 = null;
                long jC04 = 0;
                long jC05 = 0;
                long jC06 = 0;
                boolean zW3 = false;
                while (parcel.dataPosition() < iK019) {
                    int i23 = parcel.readInt();
                    switch ((char) i23) {
                        case 2:
                            strA15 = s3.D.A(i23, parcel);
                            break;
                        case 3:
                            strA16 = s3.D.A(i23, parcel);
                            break;
                        case 4:
                            w12 = (W1) s3.D.z(parcel, i23, W1.CREATOR);
                            break;
                        case 5:
                            jC04 = s3.D.c0(i23, parcel);
                            break;
                        case 6:
                            zW3 = s3.D.W(i23, parcel);
                            break;
                        case 7:
                            strA17 = s3.D.A(i23, parcel);
                            break;
                        case '\b':
                            c0134u = (C0134u) s3.D.z(parcel, i23, C0134u.CREATOR);
                            break;
                        case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            jC05 = s3.D.c0(i23, parcel);
                            break;
                        case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            c0134u2 = (C0134u) s3.D.z(parcel, i23, C0134u.CREATOR);
                            break;
                        case 11:
                            jC06 = s3.D.c0(i23, parcel);
                            break;
                        case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                            c0134u3 = (C0134u) s3.D.z(parcel, i23, C0134u.CREATOR);
                            break;
                        default:
                            s3.D.j0(i23, parcel);
                            break;
                    }
                }
                s3.D.G(iK019, parcel);
                return new C0087e(strA15, strA16, w12, jC04, zW3, strA17, c0134u, jC05, c0134u2, jC06, c0134u3);
            case 23:
                int iK020 = s3.D.k0(parcel);
                Bundle bundleW = null;
                while (parcel.dataPosition() < iK020) {
                    int i24 = parcel.readInt();
                    if (((char) i24) != 1) {
                        s3.D.j0(i24, parcel);
                    } else {
                        bundleW = s3.D.w(i24, parcel);
                    }
                }
                s3.D.G(iK020, parcel);
                return new C0099i(bundleW);
            case 24:
                int iK021 = s3.D.k0(parcel);
                Bundle bundleW2 = null;
                while (parcel.dataPosition() < iK021) {
                    int i25 = parcel.readInt();
                    if (((char) i25) != 2) {
                        s3.D.j0(i25, parcel);
                    } else {
                        bundleW2 = s3.D.w(i25, parcel);
                    }
                }
                s3.D.G(iK021, parcel);
                return new C0131t(bundleW2);
            case 25:
                int iK022 = s3.D.k0(parcel);
                long jC07 = 0;
                String strA18 = null;
                C0131t c0131t = null;
                String strA19 = null;
                while (parcel.dataPosition() < iK022) {
                    int i26 = parcel.readInt();
                    char c19 = (char) i26;
                    if (c19 == 2) {
                        strA18 = s3.D.A(i26, parcel);
                    } else if (c19 == 3) {
                        c0131t = (C0131t) s3.D.z(parcel, i26, C0131t.CREATOR);
                    } else if (c19 == 4) {
                        strA19 = s3.D.A(i26, parcel);
                    } else if (c19 != 5) {
                        s3.D.j0(i26, parcel);
                    } else {
                        jC07 = s3.D.c0(i26, parcel);
                    }
                }
                s3.D.G(iK022, parcel);
                return new C0134u(strA18, c0131t, strA19, jC07);
            case 26:
                int iK023 = s3.D.k0(parcel);
                int iA07 = 0;
                long jC08 = 0;
                String strA20 = null;
                while (parcel.dataPosition() < iK023) {
                    int i27 = parcel.readInt();
                    char c20 = (char) i27;
                    if (c20 == 1) {
                        strA20 = s3.D.A(i27, parcel);
                    } else if (c20 == 2) {
                        jC08 = s3.D.c0(i27, parcel);
                    } else if (c20 != 3) {
                        s3.D.j0(i27, parcel);
                    } else {
                        iA07 = s3.D.a0(i27, parcel);
                    }
                }
                s3.D.G(iK023, parcel);
                return new J1(strA20, jC08, iA07);
            case 27:
                int iK024 = s3.D.k0(parcel);
                byte[] bArrX18 = null;
                String strA21 = null;
                Bundle bundleW3 = null;
                String strA22 = null;
                long jC09 = 0;
                long jC010 = 0;
                int iA08 = 0;
                while (parcel.dataPosition() < iK024) {
                    int i28 = parcel.readInt();
                    switch ((char) i28) {
                        case 1:
                            jC09 = s3.D.c0(i28, parcel);
                            break;
                        case 2:
                            bArrX18 = s3.D.x(i28, parcel);
                            break;
                        case 3:
                            strA21 = s3.D.A(i28, parcel);
                            break;
                        case 4:
                            bundleW3 = s3.D.w(i28, parcel);
                            break;
                        case 5:
                            iA08 = s3.D.a0(i28, parcel);
                            break;
                        case 6:
                            jC010 = s3.D.c0(i28, parcel);
                            break;
                        case 7:
                            strA22 = s3.D.A(i28, parcel);
                            break;
                        default:
                            s3.D.j0(i28, parcel);
                            break;
                    }
                }
                s3.D.G(iK024, parcel);
                return new M1(jC09, bArrX18, strA21, bundleW3, iA08, jC010, strA22);
            case 28:
                int iK025 = s3.D.k0(parcel);
                while (true) {
                    ArrayList arrayList = null;
                    while (parcel.dataPosition() < iK025) {
                        int i29 = parcel.readInt();
                        if (((char) i29) != 1) {
                            s3.D.j0(i29, parcel);
                        } else {
                            int iE02 = s3.D.e0(i29, parcel);
                            int iDataPosition2 = parcel.dataPosition();
                            if (iE02 == 0) {
                            }
                            ArrayList arrayList2 = new ArrayList();
                            int i30 = parcel.readInt();
                            for (int i31 = 0; i31 < i30; i31++) {
                                arrayList2.add(Integer.valueOf(parcel.readInt()));
                            }
                            parcel.setDataPosition(iDataPosition2 + iE02);
                            arrayList = arrayList2;
                        }
                        break;
                    }
                    s3.D.G(iK025, parcel);
                    return new N1(arrayList);
                }
                break;
            default:
                int iK026 = s3.D.k0(parcel);
                ArrayList arrayListD6 = null;
                while (parcel.dataPosition() < iK026) {
                    int i32 = parcel.readInt();
                    if (((char) i32) != 1) {
                        s3.D.j0(i32, parcel);
                    } else {
                        arrayListD6 = s3.D.D(parcel, i32, M1.CREATOR);
                    }
                }
                s3.D.G(iK026, parcel);
                return new O1(arrayListD6);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        switch (this.f705a) {
            case 0:
                return new X[i];
            case 1:
                return new C0033i[i];
            case 2:
                return new C0034j[i];
            case 3:
                return new C0035k[i];
            case 4:
                return new C0037m[i];
            case 5:
                return new C0038n[i];
            case 6:
                return new C0039o[i];
            case 7:
                return new r[i];
            case 8:
                return new Z[i];
            case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return new a0[i];
            case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return new b0[i];
            case 11:
                return new EnumC0044u[i];
            case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                return new C0045v[i];
            case 13:
                return new K1.a[i];
            case 14:
                return new K1.c[i];
            case 15:
                return new K1.d[i];
            case 16:
                return new K1.f[i];
            case I0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return new K1.g[i];
            case I0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                return new RegisterRequestParams[i];
            case 19:
                return new K1.h[i];
            case 20:
                return new SignRequestParams[i];
            case 21:
                return new C0084d[i];
            case 22:
                return new C0087e[i];
            case 23:
                return new C0099i[i];
            case 24:
                return new C0131t[i];
            case 25:
                return new C0134u[i];
            case 26:
                return new J1[i];
            case 27:
                return new M1[i];
            case 28:
                return new N1[i];
            default:
                return new O1[i];
        }
    }
}
