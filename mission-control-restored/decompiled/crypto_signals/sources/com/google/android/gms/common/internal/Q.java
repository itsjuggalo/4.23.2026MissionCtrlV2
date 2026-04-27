package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.TokenData;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.p002firebaseauthapi.zzaiz;
import com.google.android.gms.internal.p002firebaseauthapi.zzajb;
import f.C0583a;
import i2.C0647A;
import i2.C0649C;
import i2.C0650D;
import i2.C0652F;
import i2.C0654H;
import i2.C0656b;
import i2.C0659e;
import i2.C0660f;
import i2.C0671q;
import java.util.ArrayList;
import java.util.HashSet;
import k1.C0748a;
import k1.C0749b;
import k1.C0750c;
import n1.C0866a;
import n1.C0867b;
import n1.C0869d;
import n1.C0870e;
import n1.C0871f;
import o1.C0884a;
import s3.B0;
import s3.I0;
import t2.u0;
import u1.C1202d;
import v1.C1256b;

/* JADX INFO: loaded from: classes.dex */
public final class Q implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5213a;

    public /* synthetic */ Q(int i) {
        this.f5213a = i;
    }

    public static void a(C0432j c0432j, Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.b0(parcel, 1, 4);
        parcel.writeInt(c0432j.f5250a);
        u0.b0(parcel, 2, 4);
        parcel.writeInt(c0432j.f5251b);
        u0.b0(parcel, 3, 4);
        parcel.writeInt(c0432j.f5252c);
        u0.T(parcel, 4, c0432j.f5253d, false);
        u0.O(parcel, 5, c0432j.e);
        u0.V(parcel, 6, c0432j.f5254f, i);
        u0.L(parcel, 7, c0432j.f5255k, false);
        u0.S(parcel, 8, c0432j.f5256l, i, false);
        u0.V(parcel, 10, c0432j.f5257m, i);
        u0.V(parcel, 11, c0432j.f5258n, i);
        u0.b0(parcel, 12, 4);
        parcel.writeInt(c0432j.f5259o ? 1 : 0);
        u0.b0(parcel, 13, 4);
        parcel.writeInt(c0432j.f5260p);
        boolean z6 = c0432j.f5261q;
        u0.b0(parcel, 14, 4);
        parcel.writeInt(z6 ? 1 : 0);
        u0.T(parcel, 15, c0432j.f5262r, false);
        u0.a0(iX, parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f5213a) {
            case 0:
                int iK0 = s3.D.k0(parcel);
                Scope[] scopeArr = C0432j.f5248s;
                Bundle bundle = new Bundle();
                C1202d[] c1202dArr = C0432j.f5249t;
                C1202d[] c1202dArr2 = c1202dArr;
                String strA = null;
                IBinder iBinderZ = null;
                Account account = null;
                String strA2 = null;
                int iA0 = 0;
                int iA02 = 0;
                int iA03 = 0;
                boolean zW = false;
                int iA04 = 0;
                boolean zW2 = false;
                while (parcel.dataPosition() < iK0) {
                    int i = parcel.readInt();
                    switch ((char) i) {
                        case 1:
                            iA0 = s3.D.a0(i, parcel);
                            break;
                        case 2:
                            iA02 = s3.D.a0(i, parcel);
                            break;
                        case 3:
                            iA03 = s3.D.a0(i, parcel);
                            break;
                        case 4:
                            strA = s3.D.A(i, parcel);
                            break;
                        case 5:
                            iBinderZ = s3.D.Z(i, parcel);
                            break;
                        case 6:
                            scopeArr = (Scope[]) s3.D.C(parcel, i, Scope.CREATOR);
                            break;
                        case 7:
                            bundle = s3.D.w(i, parcel);
                            break;
                        case '\b':
                            account = (Account) s3.D.z(parcel, i, Account.CREATOR);
                            break;
                        case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                        default:
                            s3.D.j0(i, parcel);
                            break;
                        case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            c1202dArr = (C1202d[]) s3.D.C(parcel, i, C1202d.CREATOR);
                            break;
                        case 11:
                            c1202dArr2 = (C1202d[]) s3.D.C(parcel, i, C1202d.CREATOR);
                            break;
                        case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                            zW = s3.D.W(i, parcel);
                            break;
                        case '\r':
                            iA04 = s3.D.a0(i, parcel);
                            break;
                        case 14:
                            zW2 = s3.D.W(i, parcel);
                            break;
                        case 15:
                            strA2 = s3.D.A(i, parcel);
                            break;
                    }
                }
                s3.D.G(iK0, parcel);
                return new C0432j(iA0, iA02, iA03, strA, iBinderZ, scopeArr, bundle, account, c1202dArr, c1202dArr2, zW, iA04, zW2, strA2);
            case 1:
                int iK02 = s3.D.k0(parcel);
                Bundle bundleW = null;
                while (parcel.dataPosition() < iK02) {
                    int i6 = parcel.readInt();
                    if (((char) i6) != 2) {
                        s3.D.j0(i6, parcel);
                    } else {
                        bundleW = s3.D.w(i6, parcel);
                    }
                }
                s3.D.G(iK02, parcel);
                return new e3.u(bundleW);
            case 2:
                kotlin.jvm.internal.j.e(parcel, "parcel");
                return new C0583a(parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel), parcel.readInt());
            case 3:
                kotlin.jvm.internal.j.e(parcel, "inParcel");
                Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
                kotlin.jvm.internal.j.b(parcelable);
                return new f.e((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
            case 4:
                int iK03 = s3.D.k0(parcel);
                String strA3 = null;
                String strA4 = null;
                String strA5 = null;
                String strA6 = null;
                String strA7 = null;
                String strA8 = null;
                String strA9 = null;
                String strA10 = null;
                boolean zW3 = false;
                boolean zW4 = false;
                int iA05 = 0;
                while (parcel.dataPosition() < iK03) {
                    int i7 = parcel.readInt();
                    switch ((char) i7) {
                        case 1:
                            strA3 = s3.D.A(i7, parcel);
                            break;
                        case 2:
                            strA4 = s3.D.A(i7, parcel);
                            break;
                        case 3:
                            strA5 = s3.D.A(i7, parcel);
                            break;
                        case 4:
                            strA6 = s3.D.A(i7, parcel);
                            break;
                        case 5:
                            zW3 = s3.D.W(i7, parcel);
                            break;
                        case 6:
                            strA7 = s3.D.A(i7, parcel);
                            break;
                        case 7:
                            zW4 = s3.D.W(i7, parcel);
                            break;
                        case '\b':
                            strA8 = s3.D.A(i7, parcel);
                            break;
                        case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            iA05 = s3.D.a0(i7, parcel);
                            break;
                        case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            strA9 = s3.D.A(i7, parcel);
                            break;
                        case 11:
                            strA10 = s3.D.A(i7, parcel);
                            break;
                        default:
                            s3.D.j0(i7, parcel);
                            break;
                    }
                }
                s3.D.G(iK03, parcel);
                return new C0656b(strA3, strA4, strA5, strA6, zW3, strA7, zW4, strA8, iA05, strA9, strA10);
            case 5:
                int iK04 = s3.D.k0(parcel);
                String strA11 = null;
                while (parcel.dataPosition() < iK04) {
                    int i8 = parcel.readInt();
                    if (((char) i8) != 1) {
                        s3.D.j0(i8, parcel);
                    } else {
                        strA11 = s3.D.A(i8, parcel);
                    }
                }
                s3.D.G(iK04, parcel);
                return new C0671q(strA11);
            case 6:
                int iK05 = s3.D.k0(parcel);
                String strA12 = null;
                String strA13 = null;
                while (parcel.dataPosition() < iK05) {
                    int i9 = parcel.readInt();
                    char c6 = (char) i9;
                    if (c6 == 1) {
                        strA12 = s3.D.A(i9, parcel);
                    } else if (c6 != 2) {
                        s3.D.j0(i9, parcel);
                    } else {
                        strA13 = s3.D.A(i9, parcel);
                    }
                }
                s3.D.G(iK05, parcel);
                return new i2.r(strA12, strA13);
            case 7:
                int iK06 = s3.D.k0(parcel);
                String strA14 = null;
                String strA15 = null;
                String strA16 = null;
                while (parcel.dataPosition() < iK06) {
                    int i10 = parcel.readInt();
                    char c7 = (char) i10;
                    if (c7 == 1) {
                        strA14 = s3.D.A(i10, parcel);
                    } else if (c7 == 2) {
                        strA15 = s3.D.A(i10, parcel);
                    } else if (c7 != 3) {
                        s3.D.j0(i10, parcel);
                    } else {
                        strA16 = s3.D.A(i10, parcel);
                    }
                }
                s3.D.G(iK06, parcel);
                return new C0654H(strA14, strA15, strA16);
            case 8:
                int iK07 = s3.D.k0(parcel);
                String strA17 = null;
                String strA18 = null;
                String strA19 = null;
                String strA20 = null;
                boolean zW5 = false;
                while (parcel.dataPosition() < iK07) {
                    int i11 = parcel.readInt();
                    char c8 = (char) i11;
                    if (c8 == 1) {
                        strA17 = s3.D.A(i11, parcel);
                    } else if (c8 == 2) {
                        strA18 = s3.D.A(i11, parcel);
                    } else if (c8 == 4) {
                        strA19 = s3.D.A(i11, parcel);
                    } else if (c8 == 5) {
                        zW5 = s3.D.W(i11, parcel);
                    } else if (c8 != 6) {
                        s3.D.j0(i11, parcel);
                    } else {
                        strA20 = s3.D.A(i11, parcel);
                    }
                }
                s3.D.G(iK07, parcel);
                return new i2.u(strA17, strA18, strA19, strA20, zW5);
            case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                int iK08 = s3.D.k0(parcel);
                String strA21 = null;
                String strA22 = null;
                String strA23 = null;
                long jC0 = 0;
                while (parcel.dataPosition() < iK08) {
                    int i12 = parcel.readInt();
                    char c9 = (char) i12;
                    if (c9 == 1) {
                        strA21 = s3.D.A(i12, parcel);
                    } else if (c9 == 2) {
                        strA22 = s3.D.A(i12, parcel);
                    } else if (c9 == 3) {
                        jC0 = s3.D.c0(i12, parcel);
                    } else if (c9 != 4) {
                        s3.D.j0(i12, parcel);
                    } else {
                        strA23 = s3.D.A(i12, parcel);
                    }
                }
                s3.D.G(iK08, parcel);
                return new i2.z(jC0, strA21, strA22, strA23);
            case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                int iK09 = s3.D.k0(parcel);
                String strA24 = null;
                while (parcel.dataPosition() < iK09) {
                    int i13 = parcel.readInt();
                    if (((char) i13) != 1) {
                        s3.D.j0(i13, parcel);
                    } else {
                        strA24 = s3.D.A(i13, parcel);
                    }
                }
                s3.D.G(iK09, parcel);
                return new C0647A(strA24);
            case 11:
                int iK010 = s3.D.k0(parcel);
                String strA25 = null;
                String strA26 = null;
                zzaiz zzaizVar = null;
                long jC02 = 0;
                while (parcel.dataPosition() < iK010) {
                    int i14 = parcel.readInt();
                    char c10 = (char) i14;
                    if (c10 == 1) {
                        strA25 = s3.D.A(i14, parcel);
                    } else if (c10 == 2) {
                        strA26 = s3.D.A(i14, parcel);
                    } else if (c10 == 3) {
                        jC02 = s3.D.c0(i14, parcel);
                    } else if (c10 != 4) {
                        s3.D.j0(i14, parcel);
                    } else {
                        zzaizVar = (zzaiz) s3.D.z(parcel, i14, zzaiz.CREATOR);
                    }
                }
                s3.D.G(iK010, parcel);
                return new C0649C(strA25, strA26, jC02, zzaizVar);
            case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                int iK011 = s3.D.k0(parcel);
                String strA27 = null;
                String strA28 = null;
                while (parcel.dataPosition() < iK011) {
                    int i15 = parcel.readInt();
                    char c11 = (char) i15;
                    if (c11 == 1) {
                        strA27 = s3.D.A(i15, parcel);
                    } else if (c11 != 2) {
                        s3.D.j0(i15, parcel);
                    } else {
                        strA28 = s3.D.A(i15, parcel);
                    }
                }
                s3.D.G(iK011, parcel);
                return new C0650D(strA27, strA28);
            case 13:
                int iK012 = s3.D.k0(parcel);
                String strA29 = null;
                boolean zW6 = false;
                boolean zW7 = false;
                String strA30 = null;
                while (parcel.dataPosition() < iK012) {
                    int i16 = parcel.readInt();
                    char c12 = (char) i16;
                    if (c12 == 2) {
                        strA29 = s3.D.A(i16, parcel);
                    } else if (c12 == 3) {
                        strA30 = s3.D.A(i16, parcel);
                    } else if (c12 == 4) {
                        zW6 = s3.D.W(i16, parcel);
                    } else if (c12 != 5) {
                        s3.D.j0(i16, parcel);
                    } else {
                        zW7 = s3.D.W(i16, parcel);
                    }
                }
                s3.D.G(iK012, parcel);
                return new C0652F(strA29, strA30, zW6, zW7);
            case 14:
                int iK013 = s3.D.k0(parcel);
                while (parcel.dataPosition() < iK013) {
                    s3.D.j0(parcel.readInt(), parcel);
                }
                s3.D.G(iK013, parcel);
                return new i2.w();
            case 15:
                int iK014 = s3.D.k0(parcel);
                String strA31 = null;
                String strA32 = null;
                String strA33 = null;
                zzajb zzajbVar = null;
                String strA34 = null;
                String strA35 = null;
                String strA36 = null;
                while (parcel.dataPosition() < iK014) {
                    int i17 = parcel.readInt();
                    switch ((char) i17) {
                        case 1:
                            strA31 = s3.D.A(i17, parcel);
                            break;
                        case 2:
                            strA32 = s3.D.A(i17, parcel);
                            break;
                        case 3:
                            strA33 = s3.D.A(i17, parcel);
                            break;
                        case 4:
                            zzajbVar = (zzajb) s3.D.z(parcel, i17, zzajb.CREATOR);
                            break;
                        case 5:
                            strA34 = s3.D.A(i17, parcel);
                            break;
                        case 6:
                            strA35 = s3.D.A(i17, parcel);
                            break;
                        case 7:
                            strA36 = s3.D.A(i17, parcel);
                            break;
                        default:
                            s3.D.j0(i17, parcel);
                            break;
                    }
                }
                s3.D.G(iK014, parcel);
                return new i2.I(strA31, strA32, strA33, zzajbVar, strA34, strA35, strA36);
            case 16:
                int iK015 = s3.D.k0(parcel);
                String strA37 = null;
                String strA38 = null;
                String strA39 = null;
                String strA40 = null;
                boolean zW8 = false;
                while (parcel.dataPosition() < iK015) {
                    int i18 = parcel.readInt();
                    char c13 = (char) i18;
                    if (c13 == 1) {
                        strA37 = s3.D.A(i18, parcel);
                    } else if (c13 == 2) {
                        strA38 = s3.D.A(i18, parcel);
                    } else if (c13 == 3) {
                        strA39 = s3.D.A(i18, parcel);
                    } else if (c13 == 4) {
                        strA40 = s3.D.A(i18, parcel);
                    } else if (c13 != 5) {
                        s3.D.j0(i18, parcel);
                    } else {
                        zW8 = s3.D.W(i18, parcel);
                    }
                }
                s3.D.G(iK015, parcel);
                return new C0659e(strA37, strA38, strA39, strA40, zW8);
            case I0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                int iK016 = s3.D.k0(parcel);
                String strA41 = null;
                while (parcel.dataPosition() < iK016) {
                    int i19 = parcel.readInt();
                    if (((char) i19) != 1) {
                        s3.D.j0(i19, parcel);
                    } else {
                        strA41 = s3.D.A(i19, parcel);
                    }
                }
                s3.D.G(iK016, parcel);
                return new C0660f(strA41);
            case I0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                int iK017 = s3.D.k0(parcel);
                String strA42 = null;
                String strA43 = null;
                int iA06 = 0;
                int iA07 = 0;
                int iA08 = 0;
                long jC03 = 0;
                while (parcel.dataPosition() < iK017) {
                    int i20 = parcel.readInt();
                    switch ((char) i20) {
                        case 1:
                            iA06 = s3.D.a0(i20, parcel);
                            break;
                        case 2:
                            jC03 = s3.D.c0(i20, parcel);
                            break;
                        case 3:
                            strA42 = s3.D.A(i20, parcel);
                            break;
                        case 4:
                            iA07 = s3.D.a0(i20, parcel);
                            break;
                        case 5:
                            iA08 = s3.D.a0(i20, parcel);
                            break;
                        case 6:
                            strA43 = s3.D.A(i20, parcel);
                            break;
                        default:
                            s3.D.j0(i20, parcel);
                            break;
                    }
                }
                s3.D.G(iK017, parcel);
                return new C0748a(iA06, jC03, strA42, iA07, iA08, strA43);
            case 19:
                int iK018 = s3.D.k0(parcel);
                String strA44 = null;
                int iA09 = 0;
                int iA010 = 0;
                Account account2 = null;
                while (parcel.dataPosition() < iK018) {
                    int i21 = parcel.readInt();
                    char c14 = (char) i21;
                    if (c14 == 1) {
                        iA09 = s3.D.a0(i21, parcel);
                    } else if (c14 == 2) {
                        iA010 = s3.D.a0(i21, parcel);
                    } else if (c14 == 3) {
                        strA44 = s3.D.A(i21, parcel);
                    } else if (c14 != 4) {
                        s3.D.j0(i21, parcel);
                    } else {
                        account2 = (Account) s3.D.z(parcel, i21, Account.CREATOR);
                    }
                }
                s3.D.G(iK018, parcel);
                return new C0749b(iA09, iA010, strA44, account2);
            case 20:
                int iK019 = s3.D.k0(parcel);
                ArrayList arrayListD = null;
                int iA011 = 0;
                while (parcel.dataPosition() < iK019) {
                    int i22 = parcel.readInt();
                    char c15 = (char) i22;
                    if (c15 == 1) {
                        iA011 = s3.D.a0(i22, parcel);
                    } else if (c15 != 2) {
                        s3.D.j0(i22, parcel);
                    } else {
                        arrayListD = s3.D.D(parcel, i22, C0748a.CREATOR);
                    }
                }
                s3.D.G(iK019, parcel);
                return new C0750c(iA011, arrayListD);
            case 21:
                int iK020 = s3.D.k0(parcel);
                String strA45 = null;
                Long lD0 = null;
                ArrayList arrayListB = null;
                String strA46 = null;
                int iA012 = 0;
                boolean zW9 = false;
                boolean zW10 = false;
                while (parcel.dataPosition() < iK020) {
                    int i23 = parcel.readInt();
                    switch ((char) i23) {
                        case 1:
                            iA012 = s3.D.a0(i23, parcel);
                            break;
                        case 2:
                            strA45 = s3.D.A(i23, parcel);
                            break;
                        case 3:
                            lD0 = s3.D.d0(i23, parcel);
                            break;
                        case 4:
                            zW9 = s3.D.W(i23, parcel);
                            break;
                        case 5:
                            zW10 = s3.D.W(i23, parcel);
                            break;
                        case 6:
                            arrayListB = s3.D.B(i23, parcel);
                            break;
                        case 7:
                            strA46 = s3.D.A(i23, parcel);
                            break;
                        default:
                            s3.D.j0(i23, parcel);
                            break;
                    }
                }
                s3.D.G(iK020, parcel);
                return new TokenData(iA012, strA45, lD0, zW9, zW10, arrayListB, strA46);
            case 22:
                int iK021 = s3.D.k0(parcel);
                HashSet hashSet = new HashSet();
                int iA013 = 0;
                ArrayList arrayListD2 = null;
                C0869d c0869d = null;
                int iA014 = 0;
                while (parcel.dataPosition() < iK021) {
                    int i24 = parcel.readInt();
                    char c16 = (char) i24;
                    if (c16 == 1) {
                        iA013 = s3.D.a0(i24, parcel);
                        hashSet.add(1);
                    } else if (c16 == 2) {
                        arrayListD2 = s3.D.D(parcel, i24, C0870e.CREATOR);
                        hashSet.add(2);
                    } else if (c16 == 3) {
                        iA014 = s3.D.a0(i24, parcel);
                        hashSet.add(3);
                    } else if (c16 != 4) {
                        s3.D.j0(i24, parcel);
                    } else {
                        c0869d = (C0869d) s3.D.z(parcel, i24, C0869d.CREATOR);
                        hashSet.add(4);
                    }
                }
                if (parcel.dataPosition() == iK021) {
                    return new C0867b(hashSet, iA013, arrayListD2, iA014, c0869d);
                }
                throw new C1256b(a3.d.f(iK021, "Overread allowed size end="), parcel);
            case 23:
                int iK022 = s3.D.k0(parcel);
                ArrayList arrayListB2 = null;
                ArrayList arrayListB3 = null;
                ArrayList arrayListB4 = null;
                ArrayList arrayListB5 = null;
                ArrayList arrayListB6 = null;
                int iA015 = 0;
                while (parcel.dataPosition() < iK022) {
                    int i25 = parcel.readInt();
                    switch ((char) i25) {
                        case 1:
                            iA015 = s3.D.a0(i25, parcel);
                            break;
                        case 2:
                            arrayListB2 = s3.D.B(i25, parcel);
                            break;
                        case 3:
                            arrayListB3 = s3.D.B(i25, parcel);
                            break;
                        case 4:
                            arrayListB4 = s3.D.B(i25, parcel);
                            break;
                        case 5:
                            arrayListB5 = s3.D.B(i25, parcel);
                            break;
                        case 6:
                            arrayListB6 = s3.D.B(i25, parcel);
                            break;
                        default:
                            s3.D.j0(i25, parcel);
                            break;
                    }
                }
                s3.D.G(iK022, parcel);
                return new C0869d(iA015, arrayListB2, arrayListB3, arrayListB4, arrayListB5, arrayListB6);
            case 24:
                int iK023 = s3.D.k0(parcel);
                HashSet hashSet2 = new HashSet();
                int iA016 = 0;
                C0871f c0871f = null;
                String strA47 = null;
                String strA48 = null;
                String strA49 = null;
                while (parcel.dataPosition() < iK023) {
                    int i26 = parcel.readInt();
                    char c17 = (char) i26;
                    if (c17 == 1) {
                        iA016 = s3.D.a0(i26, parcel);
                        hashSet2.add(1);
                    } else if (c17 == 2) {
                        c0871f = (C0871f) s3.D.z(parcel, i26, C0871f.CREATOR);
                        hashSet2.add(2);
                    } else if (c17 == 3) {
                        strA47 = s3.D.A(i26, parcel);
                        hashSet2.add(3);
                    } else if (c17 == 4) {
                        strA48 = s3.D.A(i26, parcel);
                        hashSet2.add(4);
                    } else if (c17 != 5) {
                        s3.D.j0(i26, parcel);
                    } else {
                        strA49 = s3.D.A(i26, parcel);
                        hashSet2.add(5);
                    }
                }
                if (parcel.dataPosition() == iK023) {
                    return new C0870e(hashSet2, iA016, c0871f, strA47, strA48, strA49);
                }
                throw new C1256b(a3.d.f(iK023, "Overread allowed size end="), parcel);
            case 25:
                int iK024 = s3.D.k0(parcel);
                HashSet hashSet3 = new HashSet();
                int iA017 = 0;
                String strA50 = null;
                byte[] bArrX = null;
                PendingIntent pendingIntent = null;
                C0866a c0866a = null;
                int iA018 = 0;
                while (parcel.dataPosition() < iK024) {
                    int i27 = parcel.readInt();
                    switch ((char) i27) {
                        case 1:
                            iA017 = s3.D.a0(i27, parcel);
                            hashSet3.add(1);
                            break;
                        case 2:
                            strA50 = s3.D.A(i27, parcel);
                            hashSet3.add(2);
                            break;
                        case 3:
                            iA018 = s3.D.a0(i27, parcel);
                            hashSet3.add(3);
                            break;
                        case 4:
                            bArrX = s3.D.x(i27, parcel);
                            hashSet3.add(4);
                            break;
                        case 5:
                            pendingIntent = (PendingIntent) s3.D.z(parcel, i27, PendingIntent.CREATOR);
                            hashSet3.add(5);
                            break;
                        case 6:
                            c0866a = (C0866a) s3.D.z(parcel, i27, C0866a.CREATOR);
                            hashSet3.add(6);
                            break;
                        default:
                            s3.D.j0(i27, parcel);
                            break;
                    }
                }
                if (parcel.dataPosition() == iK024) {
                    return new C0871f(hashSet3, iA017, strA50, iA018, bArrX, pendingIntent, c0866a);
                }
                throw new C1256b(a3.d.f(iK024, "Overread allowed size end="), parcel);
            case 26:
                int iK025 = s3.D.k0(parcel);
                int iA019 = 0;
                boolean zW11 = false;
                boolean zW12 = false;
                long jC04 = 0;
                while (parcel.dataPosition() < iK025) {
                    int i28 = parcel.readInt();
                    char c18 = (char) i28;
                    if (c18 == 1) {
                        iA019 = s3.D.a0(i28, parcel);
                    } else if (c18 == 2) {
                        zW11 = s3.D.W(i28, parcel);
                    } else if (c18 == 3) {
                        jC04 = s3.D.c0(i28, parcel);
                    } else if (c18 != 4) {
                        s3.D.j0(i28, parcel);
                    } else {
                        zW12 = s3.D.W(i28, parcel);
                    }
                }
                s3.D.G(iK025, parcel);
                return new C0866a(iA019, zW11, jC04, zW12);
            case 27:
                int iK026 = s3.D.k0(parcel);
                boolean zW13 = false;
                boolean zW14 = false;
                boolean zW15 = false;
                ArrayList arrayListD3 = null;
                String strA51 = null;
                Account account3 = null;
                String strA52 = null;
                String strA53 = null;
                while (parcel.dataPosition() < iK026) {
                    int i29 = parcel.readInt();
                    switch ((char) i29) {
                        case 1:
                            arrayListD3 = s3.D.D(parcel, i29, Scope.CREATOR);
                            break;
                        case 2:
                            strA51 = s3.D.A(i29, parcel);
                            break;
                        case 3:
                            zW13 = s3.D.W(i29, parcel);
                            break;
                        case 4:
                            zW14 = s3.D.W(i29, parcel);
                            break;
                        case 5:
                            account3 = (Account) s3.D.z(parcel, i29, Account.CREATOR);
                            break;
                        case 6:
                            strA52 = s3.D.A(i29, parcel);
                            break;
                        case 7:
                            strA53 = s3.D.A(i29, parcel);
                            break;
                        case '\b':
                            zW15 = s3.D.W(i29, parcel);
                            break;
                        default:
                            s3.D.j0(i29, parcel);
                            break;
                    }
                }
                s3.D.G(iK026, parcel);
                return new AuthorizationRequest(arrayListD3, strA51, zW13, zW14, account3, strA52, strA53, zW15);
            case 28:
                int iK027 = s3.D.k0(parcel);
                String strA54 = null;
                String strA55 = null;
                String strA56 = null;
                ArrayList arrayListB7 = null;
                GoogleSignInAccount googleSignInAccount = null;
                PendingIntent pendingIntent2 = null;
                while (parcel.dataPosition() < iK027) {
                    int i30 = parcel.readInt();
                    switch ((char) i30) {
                        case 1:
                            strA54 = s3.D.A(i30, parcel);
                            break;
                        case 2:
                            strA55 = s3.D.A(i30, parcel);
                            break;
                        case 3:
                            strA56 = s3.D.A(i30, parcel);
                            break;
                        case 4:
                            arrayListB7 = s3.D.B(i30, parcel);
                            break;
                        case 5:
                            googleSignInAccount = (GoogleSignInAccount) s3.D.z(parcel, i30, GoogleSignInAccount.CREATOR);
                            break;
                        case 6:
                            pendingIntent2 = (PendingIntent) s3.D.z(parcel, i30, PendingIntent.CREATOR);
                            break;
                        default:
                            s3.D.j0(i30, parcel);
                            break;
                    }
                }
                s3.D.G(iK027, parcel);
                return new C0884a(strA54, strA55, strA56, arrayListB7, googleSignInAccount, pendingIntent2);
            default:
                int iK028 = s3.D.k0(parcel);
                o1.e eVar = null;
                o1.b bVar = null;
                String strA57 = null;
                o1.d dVar = null;
                o1.c cVar = null;
                boolean zW16 = false;
                int iA020 = 0;
                while (parcel.dataPosition() < iK028) {
                    int i31 = parcel.readInt();
                    switch ((char) i31) {
                        case 1:
                            eVar = (o1.e) s3.D.z(parcel, i31, o1.e.CREATOR);
                            break;
                        case 2:
                            bVar = (o1.b) s3.D.z(parcel, i31, o1.b.CREATOR);
                            break;
                        case 3:
                            strA57 = s3.D.A(i31, parcel);
                            break;
                        case 4:
                            zW16 = s3.D.W(i31, parcel);
                            break;
                        case 5:
                            iA020 = s3.D.a0(i31, parcel);
                            break;
                        case 6:
                            dVar = (o1.d) s3.D.z(parcel, i31, o1.d.CREATOR);
                            break;
                        case 7:
                            cVar = (o1.c) s3.D.z(parcel, i31, o1.c.CREATOR);
                            break;
                        default:
                            s3.D.j0(i31, parcel);
                            break;
                    }
                }
                s3.D.G(iK028, parcel);
                return new o1.f(eVar, bVar, strA57, zW16, iA020, dVar, cVar);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f5213a) {
            case 0:
                return new C0432j[i];
            case 1:
                return new e3.u[i];
            case 2:
                return new C0583a[i];
            case 3:
                return new f.e[i];
            case 4:
                return new C0656b[i];
            case 5:
                return new C0671q[i];
            case 6:
                return new i2.r[i];
            case 7:
                return new C0654H[i];
            case 8:
                return new i2.u[i];
            case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return new i2.z[i];
            case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return new C0647A[i];
            case 11:
                return new C0649C[i];
            case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                return new C0650D[i];
            case 13:
                return new C0652F[i];
            case 14:
                return new i2.w[i];
            case 15:
                return new i2.I[i];
            case 16:
                return new C0659e[i];
            case I0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return new C0660f[i];
            case I0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                return new C0748a[i];
            case 19:
                return new C0749b[i];
            case 20:
                return new C0750c[i];
            case 21:
                return new TokenData[i];
            case 22:
                return new C0867b[i];
            case 23:
                return new C0869d[i];
            case 24:
                return new C0870e[i];
            case 25:
                return new C0871f[i];
            case 26:
                return new C0866a[i];
            case 27:
                return new AuthorizationRequest[i];
            case 28:
                return new C0884a[i];
            default:
                return new o1.f[i];
        }
    }
}
