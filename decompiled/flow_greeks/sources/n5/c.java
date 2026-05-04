package n5;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static void A(Parcel parcel, int i10, Parcel parcel2, boolean z10) {
        if (parcel2 == null) {
            if (z10) {
                J(parcel, i10, 0);
            }
        } else {
            int iK = K(parcel, i10);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            L(parcel, iK);
        }
    }

    public static void B(Parcel parcel, int i10, List list, boolean z10) {
        if (list == null) {
            if (z10) {
                J(parcel, i10, 0);
                return;
            }
            return;
        }
        int iK = K(parcel, i10);
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            Parcel parcel2 = (Parcel) list.get(i11);
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        L(parcel, iK);
    }

    public static void C(Parcel parcel, int i10, Parcelable parcelable, int i11, boolean z10) {
        if (parcelable == null) {
            if (z10) {
                J(parcel, i10, 0);
            }
        } else {
            int iK = K(parcel, i10);
            parcelable.writeToParcel(parcel, i11);
            L(parcel, iK);
        }
    }

    public static void D(Parcel parcel, int i10, short s10) {
        J(parcel, i10, 4);
        parcel.writeInt(s10);
    }

    public static void E(Parcel parcel, int i10, String str, boolean z10) {
        if (str == null) {
            if (z10) {
                J(parcel, i10, 0);
            }
        } else {
            int iK = K(parcel, i10);
            parcel.writeString(str);
            L(parcel, iK);
        }
    }

    public static void F(Parcel parcel, int i10, String[] strArr, boolean z10) {
        if (strArr == null) {
            if (z10) {
                J(parcel, i10, 0);
            }
        } else {
            int iK = K(parcel, i10);
            parcel.writeStringArray(strArr);
            L(parcel, iK);
        }
    }

    public static void G(Parcel parcel, int i10, List list, boolean z10) {
        if (list == null) {
            if (z10) {
                J(parcel, i10, 0);
            }
        } else {
            int iK = K(parcel, i10);
            parcel.writeStringList(list);
            L(parcel, iK);
        }
    }

    public static void H(Parcel parcel, int i10, Parcelable[] parcelableArr, int i11, boolean z10) {
        if (parcelableArr == null) {
            if (z10) {
                J(parcel, i10, 0);
                return;
            }
            return;
        }
        int iK = K(parcel, i10);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                M(parcel, parcelable, i11);
            }
        }
        L(parcel, iK);
    }

    public static void I(Parcel parcel, int i10, List list, boolean z10) {
        if (list == null) {
            if (z10) {
                J(parcel, i10, 0);
                return;
            }
            return;
        }
        int iK = K(parcel, i10);
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            Parcelable parcelable = (Parcelable) list.get(i11);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                M(parcel, parcelable, 0);
            }
        }
        L(parcel, iK);
    }

    public static void J(Parcel parcel, int i10, int i11) {
        parcel.writeInt(i10 | (i11 << 16));
    }

    public static int K(Parcel parcel, int i10) {
        parcel.writeInt(i10 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void L(Parcel parcel, int i10) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i10 - 4);
        parcel.writeInt(iDataPosition - i10);
        parcel.setDataPosition(iDataPosition);
    }

    public static void M(Parcel parcel, Parcelable parcelable, int i10) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i10);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }

    public static int a(Parcel parcel) {
        return K(parcel, 20293);
    }

    public static void b(Parcel parcel, int i10) {
        L(parcel, i10);
    }

    public static void c(Parcel parcel, int i10, BigDecimal bigDecimal, boolean z10) {
        if (bigDecimal == null) {
            if (z10) {
                J(parcel, i10, 0);
            }
        } else {
            int iK = K(parcel, i10);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            L(parcel, iK);
        }
    }

    public static void d(Parcel parcel, int i10, BigDecimal[] bigDecimalArr, boolean z10) {
        if (bigDecimalArr == null) {
            if (z10) {
                J(parcel, i10, 0);
                return;
            }
            return;
        }
        int iK = K(parcel, i10);
        int length = bigDecimalArr.length;
        parcel.writeInt(length);
        for (int i11 = 0; i11 < length; i11++) {
            parcel.writeByteArray(bigDecimalArr[i11].unscaledValue().toByteArray());
            parcel.writeInt(bigDecimalArr[i11].scale());
        }
        L(parcel, iK);
    }

    public static void e(Parcel parcel, int i10, BigInteger bigInteger, boolean z10) {
        if (bigInteger == null) {
            if (z10) {
                J(parcel, i10, 0);
            }
        } else {
            int iK = K(parcel, i10);
            parcel.writeByteArray(bigInteger.toByteArray());
            L(parcel, iK);
        }
    }

    public static void f(Parcel parcel, int i10, BigInteger[] bigIntegerArr, boolean z10) {
        if (bigIntegerArr == null) {
            if (z10) {
                J(parcel, i10, 0);
                return;
            }
            return;
        }
        int iK = K(parcel, i10);
        parcel.writeInt(bigIntegerArr.length);
        for (BigInteger bigInteger : bigIntegerArr) {
            parcel.writeByteArray(bigInteger.toByteArray());
        }
        L(parcel, iK);
    }

    public static void g(Parcel parcel, int i10, boolean z10) {
        J(parcel, i10, 4);
        parcel.writeInt(z10 ? 1 : 0);
    }

    public static void h(Parcel parcel, int i10, boolean[] zArr, boolean z10) {
        if (zArr == null) {
            if (z10) {
                J(parcel, i10, 0);
            }
        } else {
            int iK = K(parcel, i10);
            parcel.writeBooleanArray(zArr);
            L(parcel, iK);
        }
    }

    public static void i(Parcel parcel, int i10, Boolean bool, boolean z10) {
        if (bool != null) {
            J(parcel, i10, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static void j(Parcel parcel, int i10, Bundle bundle, boolean z10) {
        if (bundle == null) {
            if (z10) {
                J(parcel, i10, 0);
            }
        } else {
            int iK = K(parcel, i10);
            parcel.writeBundle(bundle);
            L(parcel, iK);
        }
    }

    public static void k(Parcel parcel, int i10, byte[] bArr, boolean z10) {
        if (bArr == null) {
            if (z10) {
                J(parcel, i10, 0);
            }
        } else {
            int iK = K(parcel, i10);
            parcel.writeByteArray(bArr);
            L(parcel, iK);
        }
    }

    public static void l(Parcel parcel, int i10, byte[][] bArr, boolean z10) {
        if (bArr == null) {
            if (z10) {
                J(parcel, i10, 0);
                return;
            }
            return;
        }
        int iK = K(parcel, i10);
        parcel.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            parcel.writeByteArray(bArr2);
        }
        L(parcel, iK);
    }

    public static void m(Parcel parcel, int i10, double d10) {
        J(parcel, i10, 8);
        parcel.writeDouble(d10);
    }

    public static void n(Parcel parcel, int i10, double[] dArr, boolean z10) {
        if (dArr == null) {
            if (z10) {
                J(parcel, i10, 0);
            }
        } else {
            int iK = K(parcel, i10);
            parcel.writeDoubleArray(dArr);
            L(parcel, iK);
        }
    }

    public static void o(Parcel parcel, int i10, Double d10, boolean z10) {
        if (d10 != null) {
            J(parcel, i10, 8);
            parcel.writeDouble(d10.doubleValue());
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static void p(Parcel parcel, int i10, float f10) {
        J(parcel, i10, 4);
        parcel.writeFloat(f10);
    }

    public static void q(Parcel parcel, int i10, float[] fArr, boolean z10) {
        if (fArr == null) {
            if (z10) {
                J(parcel, i10, 0);
            }
        } else {
            int iK = K(parcel, i10);
            parcel.writeFloatArray(fArr);
            L(parcel, iK);
        }
    }

    public static void r(Parcel parcel, int i10, Float f10, boolean z10) {
        if (f10 != null) {
            J(parcel, i10, 4);
            parcel.writeFloat(f10.floatValue());
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static void s(Parcel parcel, int i10, IBinder iBinder, boolean z10) {
        if (iBinder == null) {
            if (z10) {
                J(parcel, i10, 0);
            }
        } else {
            int iK = K(parcel, i10);
            parcel.writeStrongBinder(iBinder);
            L(parcel, iK);
        }
    }

    public static void t(Parcel parcel, int i10, int i11) {
        J(parcel, i10, 4);
        parcel.writeInt(i11);
    }

    public static void u(Parcel parcel, int i10, int[] iArr, boolean z10) {
        if (iArr == null) {
            if (z10) {
                J(parcel, i10, 0);
            }
        } else {
            int iK = K(parcel, i10);
            parcel.writeIntArray(iArr);
            L(parcel, iK);
        }
    }

    public static void v(Parcel parcel, int i10, List list, boolean z10) {
        if (list == null) {
            if (z10) {
                J(parcel, i10, 0);
                return;
            }
            return;
        }
        int iK = K(parcel, i10);
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeInt(((Integer) list.get(i11)).intValue());
        }
        L(parcel, iK);
    }

    public static void w(Parcel parcel, int i10, Integer num, boolean z10) {
        if (num != null) {
            J(parcel, i10, 4);
            parcel.writeInt(num.intValue());
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static void x(Parcel parcel, int i10, long j10) {
        J(parcel, i10, 8);
        parcel.writeLong(j10);
    }

    public static void y(Parcel parcel, int i10, long[] jArr, boolean z10) {
        if (jArr == null) {
            if (z10) {
                J(parcel, i10, 0);
            }
        } else {
            int iK = K(parcel, i10);
            parcel.writeLongArray(jArr);
            L(parcel, iK);
        }
    }

    public static void z(Parcel parcel, int i10, Long l10, boolean z10) {
        if (l10 != null) {
            J(parcel, i10, 8);
            parcel.writeLong(l10.longValue());
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }
}
