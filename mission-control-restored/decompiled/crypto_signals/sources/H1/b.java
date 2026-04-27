package H1;

import I.i;
import J1.A;
import J1.B;
import J1.C;
import J1.C0026b;
import J1.C0028d;
import J1.C0030f;
import J1.C0031g;
import J1.C0032h;
import J1.C0033i;
import J1.C0034j;
import J1.C0035k;
import J1.C0037m;
import J1.C0045v;
import J1.C0046w;
import J1.C0047x;
import J1.C0048y;
import J1.C0049z;
import J1.E;
import J1.EnumC0027c;
import J1.EnumC0029e;
import J1.F;
import J1.H;
import J1.I;
import J1.J;
import J1.K;
import J1.L;
import J1.M;
import J1.N;
import J1.O;
import J1.P;
import J1.Q;
import J1.S;
import J1.T;
import J1.U;
import J1.V;
import J1.W;
import J1.X;
import J1.a0;
import J1.b0;
import J1.c0;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.common.Transport;
import java.util.ArrayList;
import s3.AbstractC1024h;
import s3.B0;
import s3.D;
import s3.I0;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f547a;

    public /* synthetic */ b(int i) {
        this.f547a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f547a) {
            case 0:
                String string = parcel.readString();
                try {
                    for (Transport transport : Transport.values()) {
                        if (string.equals(transport.f5300a)) {
                            return transport;
                        }
                    }
                    if (string.equals("hybrid")) {
                        return Transport.HYBRID;
                    }
                    throw new a(AbstractC1024h.c("Transport ", string, " not supported"));
                } catch (a e) {
                    throw new RuntimeException(e);
                }
            case 1:
                i iVar = new i(parcel);
                iVar.f617a = parcel.readInt();
                return iVar;
            case 2:
                return new I3.a(parcel);
            case 3:
                try {
                    return EnumC0027c.a(parcel.readString());
                } catch (C0026b e2) {
                    throw new RuntimeException(e2);
                }
            case 4:
                int iK0 = D.k0(parcel);
                boolean zW = false;
                while (parcel.dataPosition() < iK0) {
                    int i = parcel.readInt();
                    if (((char) i) != 1) {
                        D.j0(i, parcel);
                    } else {
                        zW = D.W(i, parcel);
                    }
                }
                D.G(iK0, parcel);
                return new c0(zW);
            case 5:
                int iK02 = D.k0(parcel);
                long jC0 = 0;
                while (parcel.dataPosition() < iK02) {
                    int i6 = parcel.readInt();
                    if (((char) i6) != 1) {
                        D.j0(i6, parcel);
                    } else {
                        jC0 = D.c0(i6, parcel);
                    }
                }
                D.G(iK02, parcel);
                return new P(jC0);
            case 6:
                int iK03 = D.k0(parcel);
                boolean zW2 = false;
                while (parcel.dataPosition() < iK03) {
                    int i7 = parcel.readInt();
                    if (((char) i7) != 1) {
                        D.j0(i7, parcel);
                    } else {
                        zW2 = D.W(i7, parcel);
                    }
                }
                D.G(iK03, parcel);
                return new Q(zW2);
            case 7:
                int iK04 = D.k0(parcel);
                boolean zW3 = false;
                while (parcel.dataPosition() < iK04) {
                    int i8 = parcel.readInt();
                    if (((char) i8) != 1) {
                        D.j0(i8, parcel);
                    } else {
                        zW3 = D.W(i8, parcel);
                    }
                }
                D.G(iK04, parcel);
                return new C0046w(zW3);
            case 8:
                int iK05 = D.k0(parcel);
                String strA = null;
                while (parcel.dataPosition() < iK05) {
                    int i9 = parcel.readInt();
                    if (((char) i9) != 1) {
                        D.j0(i9, parcel);
                    } else {
                        strA = D.A(i9, parcel);
                    }
                }
                D.G(iK05, parcel);
                return new S(strA);
            case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                int iK06 = D.k0(parcel);
                while (true) {
                    byte[][] bArr = null;
                    while (parcel.dataPosition() < iK06) {
                        int i10 = parcel.readInt();
                        if (((char) i10) != 1) {
                            D.j0(i10, parcel);
                        } else {
                            int iE0 = D.e0(i10, parcel);
                            int iDataPosition = parcel.dataPosition();
                            if (iE0 == 0) {
                            }
                            int i11 = parcel.readInt();
                            byte[][] bArr2 = new byte[i11][];
                            for (int i12 = 0; i12 < i11; i12++) {
                                bArr2[i12] = parcel.createByteArray();
                            }
                            parcel.setDataPosition(iDataPosition + iE0);
                            bArr = bArr2;
                        }
                        break;
                    }
                    D.G(iK06, parcel);
                    return new T(bArr);
                }
                break;
            case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                int iK07 = D.k0(parcel);
                C c6 = null;
                F f6 = null;
                byte[] bArrX = null;
                ArrayList arrayListD = null;
                Double dY = null;
                ArrayList arrayListD2 = null;
                C0037m c0037m = null;
                Integer numB0 = null;
                L l6 = null;
                String strA2 = null;
                C0030f c0030f = null;
                while (parcel.dataPosition() < iK07) {
                    int i13 = parcel.readInt();
                    switch ((char) i13) {
                        case 2:
                            c6 = (C) D.z(parcel, i13, C.CREATOR);
                            break;
                        case 3:
                            f6 = (F) D.z(parcel, i13, F.CREATOR);
                            break;
                        case 4:
                            bArrX = D.x(i13, parcel);
                            break;
                        case 5:
                            arrayListD = D.D(parcel, i13, A.CREATOR);
                            break;
                        case 6:
                            dY = D.Y(i13, parcel);
                            break;
                        case 7:
                            arrayListD2 = D.D(parcel, i13, C0049z.CREATOR);
                            break;
                        case '\b':
                            c0037m = (C0037m) D.z(parcel, i13, C0037m.CREATOR);
                            break;
                        case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            numB0 = D.b0(i13, parcel);
                            break;
                        case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            l6 = (L) D.z(parcel, i13, L.CREATOR);
                            break;
                        case 11:
                            strA2 = D.A(i13, parcel);
                            break;
                        case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                            c0030f = (C0030f) D.z(parcel, i13, C0030f.CREATOR);
                            break;
                        default:
                            D.j0(i13, parcel);
                            break;
                    }
                }
                D.G(iK07, parcel);
                return new C0048y(c6, f6, bArrX, arrayListD, dY, arrayListD2, c0037m, numB0, l6, strA2, c0030f);
            case 11:
                int iK08 = D.k0(parcel);
                String strA3 = null;
                String strA4 = null;
                byte[] bArrX2 = null;
                C0034j c0034j = null;
                C0033i c0033i = null;
                C0035k c0035k = null;
                C0031g c0031g = null;
                String strA5 = null;
                while (parcel.dataPosition() < iK08) {
                    int i14 = parcel.readInt();
                    switch ((char) i14) {
                        case 1:
                            strA3 = D.A(i14, parcel);
                            break;
                        case 2:
                            strA4 = D.A(i14, parcel);
                            break;
                        case 3:
                            bArrX2 = D.x(i14, parcel);
                            break;
                        case 4:
                            c0034j = (C0034j) D.z(parcel, i14, C0034j.CREATOR);
                            break;
                        case 5:
                            c0033i = (C0033i) D.z(parcel, i14, C0033i.CREATOR);
                            break;
                        case 6:
                            c0035k = (C0035k) D.z(parcel, i14, C0035k.CREATOR);
                            break;
                        case 7:
                            c0031g = (C0031g) D.z(parcel, i14, C0031g.CREATOR);
                            break;
                        case '\b':
                            strA5 = D.A(i14, parcel);
                            break;
                        default:
                            D.j0(i14, parcel);
                            break;
                    }
                }
                D.G(iK08, parcel);
                return new C0047x(strA3, strA4, bArrX2, c0034j, c0033i, c0035k, c0031g, strA5);
            case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                int iK09 = D.k0(parcel);
                String strA6 = null;
                byte[] bArrX3 = null;
                ArrayList arrayListD3 = null;
                while (parcel.dataPosition() < iK09) {
                    int i15 = parcel.readInt();
                    char c7 = (char) i15;
                    if (c7 == 2) {
                        strA6 = D.A(i15, parcel);
                    } else if (c7 == 3) {
                        bArrX3 = D.x(i15, parcel);
                    } else if (c7 != 4) {
                        D.j0(i15, parcel);
                    } else {
                        arrayListD3 = D.D(parcel, i15, Transport.CREATOR);
                    }
                }
                D.G(iK09, parcel);
                return new C0049z(strA6, bArrX3, arrayListD3);
            case 13:
                int iK010 = D.k0(parcel);
                String strA7 = null;
                Integer numB02 = null;
                while (parcel.dataPosition() < iK010) {
                    int i16 = parcel.readInt();
                    char c8 = (char) i16;
                    if (c8 == 2) {
                        strA7 = D.A(i16, parcel);
                    } else if (c8 != 3) {
                        D.j0(i16, parcel);
                    } else {
                        numB02 = D.b0(i16, parcel);
                    }
                }
                D.G(iK010, parcel);
                return new A(strA7, numB02.intValue());
            case 14:
                int iK011 = D.k0(parcel);
                byte[] bArrX4 = null;
                Double dY2 = null;
                String strA8 = null;
                ArrayList arrayListD4 = null;
                Integer numB03 = null;
                L l7 = null;
                String strA9 = null;
                C0030f c0030f2 = null;
                Long lD0 = null;
                while (parcel.dataPosition() < iK011) {
                    int i17 = parcel.readInt();
                    switch ((char) i17) {
                        case 2:
                            bArrX4 = D.x(i17, parcel);
                            break;
                        case 3:
                            dY2 = D.Y(i17, parcel);
                            break;
                        case 4:
                            strA8 = D.A(i17, parcel);
                            break;
                        case 5:
                            arrayListD4 = D.D(parcel, i17, C0049z.CREATOR);
                            break;
                        case 6:
                            numB03 = D.b0(i17, parcel);
                            break;
                        case 7:
                            l7 = (L) D.z(parcel, i17, L.CREATOR);
                            break;
                        case '\b':
                            strA9 = D.A(i17, parcel);
                            break;
                        case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            c0030f2 = (C0030f) D.z(parcel, i17, C0030f.CREATOR);
                            break;
                        case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            lD0 = D.d0(i17, parcel);
                            break;
                        default:
                            D.j0(i17, parcel);
                            break;
                    }
                }
                D.G(iK011, parcel);
                return new B(bArrX4, dY2, strA8, arrayListD4, numB03, l7, strA9, c0030f2, lD0);
            case 15:
                int iK012 = D.k0(parcel);
                String strA10 = null;
                String strA11 = null;
                String strA12 = null;
                while (parcel.dataPosition() < iK012) {
                    int i18 = parcel.readInt();
                    char c9 = (char) i18;
                    if (c9 == 2) {
                        strA10 = D.A(i18, parcel);
                    } else if (c9 == 3) {
                        strA11 = D.A(i18, parcel);
                    } else if (c9 != 4) {
                        D.j0(i18, parcel);
                    } else {
                        strA12 = D.A(i18, parcel);
                    }
                }
                D.G(iK012, parcel);
                return new C(strA10, strA11, strA12);
            case 16:
                try {
                    return E.a(parcel.readString());
                } catch (J1.D e6) {
                    throw new RuntimeException(e6);
                }
            case I0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                int iK013 = D.k0(parcel);
                byte[] bArrX5 = null;
                String strA13 = null;
                String strA14 = null;
                String strA15 = null;
                while (parcel.dataPosition() < iK013) {
                    int i19 = parcel.readInt();
                    char c10 = (char) i19;
                    if (c10 == 2) {
                        bArrX5 = D.x(i19, parcel);
                    } else if (c10 == 3) {
                        strA13 = D.A(i19, parcel);
                    } else if (c10 == 4) {
                        strA14 = D.A(i19, parcel);
                    } else if (c10 != 5) {
                        D.j0(i19, parcel);
                    } else {
                        strA15 = D.A(i19, parcel);
                    }
                }
                D.G(iK013, parcel);
                return new F(strA13, strA14, strA15, bArrX5);
            case I0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                String string2 = parcel.readString();
                if (string2 == null) {
                    string2 = "";
                }
                try {
                    return I.a(string2);
                } catch (H e7) {
                    throw new RuntimeException(e7);
                }
            case 19:
                try {
                    return J.a(parcel.readString());
                } catch (K e8) {
                    throw new RuntimeException(e8);
                }
            case 20:
                int iK014 = D.k0(parcel);
                String strA16 = null;
                String strA17 = null;
                while (parcel.dataPosition() < iK014) {
                    int i20 = parcel.readInt();
                    char c11 = (char) i20;
                    if (c11 == 2) {
                        strA16 = D.A(i20, parcel);
                    } else if (c11 != 3) {
                        D.j0(i20, parcel);
                    } else {
                        strA17 = D.A(i20, parcel);
                    }
                }
                D.G(iK014, parcel);
                return new L(strA16, strA17);
            case 21:
                int iK015 = D.k0(parcel);
                boolean zW4 = false;
                while (parcel.dataPosition() < iK015) {
                    int i21 = parcel.readInt();
                    if (((char) i21) != 1) {
                        D.j0(i21, parcel);
                    } else {
                        zW4 = D.W(i21, parcel);
                    }
                }
                D.G(iK015, parcel);
                return new M(zW4);
            case 22:
                try {
                    return V.a(parcel.readString());
                } catch (U e9) {
                    throw new RuntimeException(e9);
                }
            case 23:
                int iK016 = D.k0(parcel);
                ArrayList arrayListD5 = null;
                while (parcel.dataPosition() < iK016) {
                    int i22 = parcel.readInt();
                    if (((char) i22) != 1) {
                        D.j0(i22, parcel);
                    } else {
                        arrayListD5 = D.D(parcel, i22, O.CREATOR);
                    }
                }
                D.G(iK016, parcel);
                return new N(arrayListD5);
            case 24:
                try {
                    return EnumC0029e.a(parcel.readString());
                } catch (C0028d e10) {
                    throw new RuntimeException(e10);
                }
            case 25:
                int iK017 = D.k0(parcel);
                int iA0 = 0;
                short s6 = 0;
                short s7 = 0;
                while (parcel.dataPosition() < iK017) {
                    int i23 = parcel.readInt();
                    char c12 = (char) i23;
                    if (c12 == 1) {
                        iA0 = D.a0(i23, parcel);
                    } else if (c12 == 2) {
                        D.o0(parcel, i23, 4);
                        s6 = (short) parcel.readInt();
                    } else if (c12 != 3) {
                        D.j0(i23, parcel);
                    } else {
                        D.o0(parcel, i23, 4);
                        s7 = (short) parcel.readInt();
                    }
                }
                D.G(iK017, parcel);
                return new O(iA0, s6, s7);
            case 26:
                int iK018 = D.k0(parcel);
                N n6 = null;
                W w6 = null;
                C0032h c0032h = null;
                X x6 = null;
                while (parcel.dataPosition() < iK018) {
                    int i24 = parcel.readInt();
                    char c13 = (char) i24;
                    if (c13 == 1) {
                        n6 = (N) D.z(parcel, i24, N.CREATOR);
                    } else if (c13 == 2) {
                        w6 = (W) D.z(parcel, i24, W.CREATOR);
                    } else if (c13 == 3) {
                        c0032h = (C0032h) D.z(parcel, i24, C0032h.CREATOR);
                    } else if (c13 != 4) {
                        D.j0(i24, parcel);
                    } else {
                        x6 = (X) D.z(parcel, i24, X.CREATOR);
                    }
                }
                D.G(iK018, parcel);
                return new C0031g(n6, w6, c0032h, x6);
            case 27:
                int iK019 = D.k0(parcel);
                C0045v c0045v = null;
                a0 a0Var = null;
                M m5 = null;
                c0 c0Var = null;
                P p3 = null;
                Q q6 = null;
                b0 b0Var = null;
                S s8 = null;
                C0046w c0046w = null;
                T t6 = null;
                while (parcel.dataPosition() < iK019) {
                    int i25 = parcel.readInt();
                    switch ((char) i25) {
                        case 2:
                            c0045v = (C0045v) D.z(parcel, i25, C0045v.CREATOR);
                            break;
                        case 3:
                            a0Var = (a0) D.z(parcel, i25, a0.CREATOR);
                            break;
                        case 4:
                            m5 = (M) D.z(parcel, i25, M.CREATOR);
                            break;
                        case 5:
                            c0Var = (c0) D.z(parcel, i25, c0.CREATOR);
                            break;
                        case 6:
                            p3 = (P) D.z(parcel, i25, P.CREATOR);
                            break;
                        case 7:
                            q6 = (Q) D.z(parcel, i25, Q.CREATOR);
                            break;
                        case '\b':
                            b0Var = (b0) D.z(parcel, i25, b0.CREATOR);
                            break;
                        case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            s8 = (S) D.z(parcel, i25, S.CREATOR);
                            break;
                        case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            c0046w = (C0046w) D.z(parcel, i25, C0046w.CREATOR);
                            break;
                        case 11:
                            t6 = (T) D.z(parcel, i25, T.CREATOR);
                            break;
                        default:
                            D.j0(i25, parcel);
                            break;
                    }
                }
                D.G(iK019, parcel);
                return new C0030f(c0045v, a0Var, m5, c0Var, p3, q6, b0Var, s8, c0046w, t6);
            case 28:
                int iK020 = D.k0(parcel);
                boolean zW5 = false;
                while (parcel.dataPosition() < iK020) {
                    int i26 = parcel.readInt();
                    if (((char) i26) != 1) {
                        D.j0(i26, parcel);
                    } else {
                        zW5 = D.W(i26, parcel);
                    }
                }
                D.G(iK020, parcel);
                return new C0032h(zW5);
            default:
                int iK021 = D.k0(parcel);
                byte[] bArrX6 = null;
                byte[] bArrX7 = null;
                while (parcel.dataPosition() < iK021) {
                    int i27 = parcel.readInt();
                    char c14 = (char) i27;
                    if (c14 == 1) {
                        bArrX6 = D.x(i27, parcel);
                    } else if (c14 != 2) {
                        D.j0(i27, parcel);
                    } else {
                        bArrX7 = D.x(i27, parcel);
                    }
                }
                D.G(iK021, parcel);
                return new W(bArrX6, bArrX7);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f547a) {
            case 0:
                return new Transport[i];
            case 1:
                return new i[i];
            case 2:
                return new I3.a[i];
            case 3:
                return new EnumC0027c[i];
            case 4:
                return new c0[i];
            case 5:
                return new P[i];
            case 6:
                return new Q[i];
            case 7:
                return new C0046w[i];
            case 8:
                return new S[i];
            case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return new T[i];
            case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return new C0048y[i];
            case 11:
                return new C0047x[i];
            case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                return new C0049z[i];
            case 13:
                return new A[i];
            case 14:
                return new B[i];
            case 15:
                return new C[i];
            case 16:
                return new E[i];
            case I0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return new F[i];
            case I0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                return new I[i];
            case 19:
                return new J[i];
            case 20:
                return new L[i];
            case 21:
                return new M[i];
            case 22:
                return new V[i];
            case 23:
                return new N[i];
            case 24:
                return new EnumC0029e[i];
            case 25:
                return new O[i];
            case 26:
                return new C0031g[i];
            case 27:
                return new C0030f[i];
            case 28:
                return new C0032h[i];
            default:
                return new W[i];
        }
    }
}
