package A1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static void A(Parcel parcel, int i4, Parcel parcel2, boolean z4) {
        if (parcel2 == null) {
            if (z4) {
                L(parcel, i4, 0);
            }
        } else {
            int iJ = J(parcel, i4);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            K(parcel, iJ);
        }
    }

    public static void B(Parcel parcel, int i4, List list, boolean z4) {
        if (list == null) {
            if (z4) {
                L(parcel, i4, 0);
                return;
            }
            return;
        }
        int iJ = J(parcel, i4);
        int size = list.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            Parcel parcel2 = (Parcel) list.get(i5);
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        K(parcel, iJ);
    }

    public static void C(Parcel parcel, int i4, Parcelable parcelable, int i5, boolean z4) {
        if (parcelable == null) {
            if (z4) {
                L(parcel, i4, 0);
            }
        } else {
            int iJ = J(parcel, i4);
            parcelable.writeToParcel(parcel, i5);
            K(parcel, iJ);
        }
    }

    public static void D(Parcel parcel, int i4, short s4) {
        L(parcel, i4, 4);
        parcel.writeInt(s4);
    }

    public static void E(Parcel parcel, int i4, String str, boolean z4) {
        if (str == null) {
            if (z4) {
                L(parcel, i4, 0);
            }
        } else {
            int iJ = J(parcel, i4);
            parcel.writeString(str);
            K(parcel, iJ);
        }
    }

    public static void F(Parcel parcel, int i4, String[] strArr, boolean z4) {
        if (strArr == null) {
            if (z4) {
                L(parcel, i4, 0);
            }
        } else {
            int iJ = J(parcel, i4);
            parcel.writeStringArray(strArr);
            K(parcel, iJ);
        }
    }

    public static void G(Parcel parcel, int i4, List list, boolean z4) {
        if (list == null) {
            if (z4) {
                L(parcel, i4, 0);
            }
        } else {
            int iJ = J(parcel, i4);
            parcel.writeStringList(list);
            K(parcel, iJ);
        }
    }

    public static void H(Parcel parcel, int i4, Parcelable[] parcelableArr, int i5, boolean z4) {
        if (parcelableArr == null) {
            if (z4) {
                L(parcel, i4, 0);
                return;
            }
            return;
        }
        int iJ = J(parcel, i4);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                M(parcel, parcelable, i5);
            }
        }
        K(parcel, iJ);
    }

    public static void I(Parcel parcel, int i4, List list, boolean z4) {
        if (list == null) {
            if (z4) {
                L(parcel, i4, 0);
                return;
            }
            return;
        }
        int iJ = J(parcel, i4);
        int size = list.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            Parcelable parcelable = (Parcelable) list.get(i5);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                M(parcel, parcelable, 0);
            }
        }
        K(parcel, iJ);
    }

    public static int J(Parcel parcel, int i4) {
        parcel.writeInt(i4 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void K(Parcel parcel, int i4) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i4 - 4);
        parcel.writeInt(iDataPosition - i4);
        parcel.setDataPosition(iDataPosition);
    }

    public static void L(Parcel parcel, int i4, int i5) {
        parcel.writeInt(i4 | (i5 << 16));
    }

    public static void M(Parcel parcel, Parcelable parcelable, int i4) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i4);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }

    public static int a(Parcel parcel) {
        return J(parcel, 20293);
    }

    public static void b(Parcel parcel, int i4) {
        K(parcel, i4);
    }

    public static void c(Parcel parcel, int i4, BigDecimal bigDecimal, boolean z4) {
        if (bigDecimal == null) {
            if (z4) {
                L(parcel, i4, 0);
            }
        } else {
            int iJ = J(parcel, i4);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            K(parcel, iJ);
        }
    }

    public static void d(Parcel parcel, int i4, BigDecimal[] bigDecimalArr, boolean z4) {
        if (bigDecimalArr == null) {
            if (z4) {
                L(parcel, i4, 0);
                return;
            }
            return;
        }
        int iJ = J(parcel, i4);
        int length = bigDecimalArr.length;
        parcel.writeInt(length);
        for (int i5 = 0; i5 < length; i5++) {
            parcel.writeByteArray(bigDecimalArr[i5].unscaledValue().toByteArray());
            parcel.writeInt(bigDecimalArr[i5].scale());
        }
        K(parcel, iJ);
    }

    public static void e(Parcel parcel, int i4, BigInteger bigInteger, boolean z4) {
        if (bigInteger == null) {
            if (z4) {
                L(parcel, i4, 0);
            }
        } else {
            int iJ = J(parcel, i4);
            parcel.writeByteArray(bigInteger.toByteArray());
            K(parcel, iJ);
        }
    }

    public static void f(Parcel parcel, int i4, BigInteger[] bigIntegerArr, boolean z4) {
        if (bigIntegerArr == null) {
            if (z4) {
                L(parcel, i4, 0);
                return;
            }
            return;
        }
        int iJ = J(parcel, i4);
        parcel.writeInt(bigIntegerArr.length);
        for (BigInteger bigInteger : bigIntegerArr) {
            parcel.writeByteArray(bigInteger.toByteArray());
        }
        K(parcel, iJ);
    }

    public static void g(Parcel parcel, int i4, boolean z4) {
        L(parcel, i4, 4);
        parcel.writeInt(z4 ? 1 : 0);
    }

    public static void h(Parcel parcel, int i4, boolean[] zArr, boolean z4) {
        if (zArr == null) {
            if (z4) {
                L(parcel, i4, 0);
            }
        } else {
            int iJ = J(parcel, i4);
            parcel.writeBooleanArray(zArr);
            K(parcel, iJ);
        }
    }

    public static void i(Parcel parcel, int i4, Boolean bool, boolean z4) {
        if (bool != null) {
            L(parcel, i4, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z4) {
            L(parcel, i4, 0);
        }
    }

    public static void j(Parcel parcel, int i4, Bundle bundle, boolean z4) {
        if (bundle == null) {
            if (z4) {
                L(parcel, i4, 0);
            }
        } else {
            int iJ = J(parcel, i4);
            parcel.writeBundle(bundle);
            K(parcel, iJ);
        }
    }

    public static void k(Parcel parcel, int i4, byte[] bArr, boolean z4) {
        if (bArr == null) {
            if (z4) {
                L(parcel, i4, 0);
            }
        } else {
            int iJ = J(parcel, i4);
            parcel.writeByteArray(bArr);
            K(parcel, iJ);
        }
    }

    public static void l(Parcel parcel, int i4, byte[][] bArr, boolean z4) {
        if (bArr == null) {
            if (z4) {
                L(parcel, i4, 0);
                return;
            }
            return;
        }
        int iJ = J(parcel, i4);
        parcel.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            parcel.writeByteArray(bArr2);
        }
        K(parcel, iJ);
    }

    public static void m(Parcel parcel, int i4, double d4) {
        L(parcel, i4, 8);
        parcel.writeDouble(d4);
    }

    public static void n(Parcel parcel, int i4, double[] dArr, boolean z4) {
        if (dArr == null) {
            if (z4) {
                L(parcel, i4, 0);
            }
        } else {
            int iJ = J(parcel, i4);
            parcel.writeDoubleArray(dArr);
            K(parcel, iJ);
        }
    }

    public static void o(Parcel parcel, int i4, Double d4, boolean z4) {
        if (d4 != null) {
            L(parcel, i4, 8);
            parcel.writeDouble(d4.doubleValue());
        } else if (z4) {
            L(parcel, i4, 0);
        }
    }

    public static void p(Parcel parcel, int i4, float f4) {
        L(parcel, i4, 4);
        parcel.writeFloat(f4);
    }

    public static void q(Parcel parcel, int i4, float[] fArr, boolean z4) {
        if (fArr == null) {
            if (z4) {
                L(parcel, i4, 0);
            }
        } else {
            int iJ = J(parcel, i4);
            parcel.writeFloatArray(fArr);
            K(parcel, iJ);
        }
    }

    public static void r(Parcel parcel, int i4, Float f4, boolean z4) {
        if (f4 != null) {
            L(parcel, i4, 4);
            parcel.writeFloat(f4.floatValue());
        } else if (z4) {
            L(parcel, i4, 0);
        }
    }

    public static void s(Parcel parcel, int i4, IBinder iBinder, boolean z4) {
        if (iBinder == null) {
            if (z4) {
                L(parcel, i4, 0);
            }
        } else {
            int iJ = J(parcel, i4);
            parcel.writeStrongBinder(iBinder);
            K(parcel, iJ);
        }
    }

    public static void t(Parcel parcel, int i4, int i5) {
        L(parcel, i4, 4);
        parcel.writeInt(i5);
    }

    public static void u(Parcel parcel, int i4, int[] iArr, boolean z4) {
        if (iArr == null) {
            if (z4) {
                L(parcel, i4, 0);
            }
        } else {
            int iJ = J(parcel, i4);
            parcel.writeIntArray(iArr);
            K(parcel, iJ);
        }
    }

    public static void v(Parcel parcel, int i4, List list, boolean z4) {
        if (list == null) {
            if (z4) {
                L(parcel, i4, 0);
                return;
            }
            return;
        }
        int iJ = J(parcel, i4);
        int size = list.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            parcel.writeInt(((Integer) list.get(i5)).intValue());
        }
        K(parcel, iJ);
    }

    public static void w(Parcel parcel, int i4, Integer num, boolean z4) {
        if (num != null) {
            L(parcel, i4, 4);
            parcel.writeInt(num.intValue());
        } else if (z4) {
            L(parcel, i4, 0);
        }
    }

    public static void x(Parcel parcel, int i4, long j4) {
        L(parcel, i4, 8);
        parcel.writeLong(j4);
    }

    public static void y(Parcel parcel, int i4, long[] jArr, boolean z4) {
        if (jArr == null) {
            if (z4) {
                L(parcel, i4, 0);
            }
        } else {
            int iJ = J(parcel, i4);
            parcel.writeLongArray(jArr);
            K(parcel, iJ);
        }
    }

    public static void z(Parcel parcel, int i4, Long l4, boolean z4) {
        if (l4 != null) {
            L(parcel, i4, 8);
            parcel.writeLong(l4.longValue());
        } else if (z4) {
            L(parcel, i4, 0);
        }
    }
}
