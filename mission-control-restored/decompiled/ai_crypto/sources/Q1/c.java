package Q1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static void A(Parcel parcel, int i7, Parcel parcel2, boolean z7) {
        if (parcel2 == null) {
            if (z7) {
                L(parcel, i7, 0);
            }
        } else {
            int iJ = J(parcel, i7);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            K(parcel, iJ);
        }
    }

    public static void B(Parcel parcel, int i7, List list, boolean z7) {
        if (list == null) {
            if (z7) {
                L(parcel, i7, 0);
                return;
            }
            return;
        }
        int iJ = J(parcel, i7);
        int size = list.size();
        parcel.writeInt(size);
        for (int i8 = 0; i8 < size; i8++) {
            Parcel parcel2 = (Parcel) list.get(i8);
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        K(parcel, iJ);
    }

    public static void C(Parcel parcel, int i7, Parcelable parcelable, int i8, boolean z7) {
        if (parcelable == null) {
            if (z7) {
                L(parcel, i7, 0);
            }
        } else {
            int iJ = J(parcel, i7);
            parcelable.writeToParcel(parcel, i8);
            K(parcel, iJ);
        }
    }

    public static void D(Parcel parcel, int i7, short s7) {
        L(parcel, i7, 4);
        parcel.writeInt(s7);
    }

    public static void E(Parcel parcel, int i7, String str, boolean z7) {
        if (str == null) {
            if (z7) {
                L(parcel, i7, 0);
            }
        } else {
            int iJ = J(parcel, i7);
            parcel.writeString(str);
            K(parcel, iJ);
        }
    }

    public static void F(Parcel parcel, int i7, String[] strArr, boolean z7) {
        if (strArr == null) {
            if (z7) {
                L(parcel, i7, 0);
            }
        } else {
            int iJ = J(parcel, i7);
            parcel.writeStringArray(strArr);
            K(parcel, iJ);
        }
    }

    public static void G(Parcel parcel, int i7, List list, boolean z7) {
        if (list == null) {
            if (z7) {
                L(parcel, i7, 0);
            }
        } else {
            int iJ = J(parcel, i7);
            parcel.writeStringList(list);
            K(parcel, iJ);
        }
    }

    public static void H(Parcel parcel, int i7, Parcelable[] parcelableArr, int i8, boolean z7) {
        if (parcelableArr == null) {
            if (z7) {
                L(parcel, i7, 0);
                return;
            }
            return;
        }
        int iJ = J(parcel, i7);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                M(parcel, parcelable, i8);
            }
        }
        K(parcel, iJ);
    }

    public static void I(Parcel parcel, int i7, List list, boolean z7) {
        if (list == null) {
            if (z7) {
                L(parcel, i7, 0);
                return;
            }
            return;
        }
        int iJ = J(parcel, i7);
        int size = list.size();
        parcel.writeInt(size);
        for (int i8 = 0; i8 < size; i8++) {
            Parcelable parcelable = (Parcelable) list.get(i8);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                M(parcel, parcelable, 0);
            }
        }
        K(parcel, iJ);
    }

    public static int J(Parcel parcel, int i7) {
        parcel.writeInt(i7 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void K(Parcel parcel, int i7) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i7 - 4);
        parcel.writeInt(iDataPosition - i7);
        parcel.setDataPosition(iDataPosition);
    }

    public static void L(Parcel parcel, int i7, int i8) {
        parcel.writeInt(i7 | (i8 << 16));
    }

    public static void M(Parcel parcel, Parcelable parcelable, int i7) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i7);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }

    public static int a(Parcel parcel) {
        return J(parcel, 20293);
    }

    public static void b(Parcel parcel, int i7) {
        K(parcel, i7);
    }

    public static void c(Parcel parcel, int i7, BigDecimal bigDecimal, boolean z7) {
        if (bigDecimal == null) {
            if (z7) {
                L(parcel, i7, 0);
            }
        } else {
            int iJ = J(parcel, i7);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            K(parcel, iJ);
        }
    }

    public static void d(Parcel parcel, int i7, BigDecimal[] bigDecimalArr, boolean z7) {
        if (bigDecimalArr == null) {
            if (z7) {
                L(parcel, i7, 0);
                return;
            }
            return;
        }
        int iJ = J(parcel, i7);
        int length = bigDecimalArr.length;
        parcel.writeInt(length);
        for (int i8 = 0; i8 < length; i8++) {
            parcel.writeByteArray(bigDecimalArr[i8].unscaledValue().toByteArray());
            parcel.writeInt(bigDecimalArr[i8].scale());
        }
        K(parcel, iJ);
    }

    public static void e(Parcel parcel, int i7, BigInteger bigInteger, boolean z7) {
        if (bigInteger == null) {
            if (z7) {
                L(parcel, i7, 0);
            }
        } else {
            int iJ = J(parcel, i7);
            parcel.writeByteArray(bigInteger.toByteArray());
            K(parcel, iJ);
        }
    }

    public static void f(Parcel parcel, int i7, BigInteger[] bigIntegerArr, boolean z7) {
        if (bigIntegerArr == null) {
            if (z7) {
                L(parcel, i7, 0);
                return;
            }
            return;
        }
        int iJ = J(parcel, i7);
        parcel.writeInt(bigIntegerArr.length);
        for (BigInteger bigInteger : bigIntegerArr) {
            parcel.writeByteArray(bigInteger.toByteArray());
        }
        K(parcel, iJ);
    }

    public static void g(Parcel parcel, int i7, boolean z7) {
        L(parcel, i7, 4);
        parcel.writeInt(z7 ? 1 : 0);
    }

    public static void h(Parcel parcel, int i7, boolean[] zArr, boolean z7) {
        if (zArr == null) {
            if (z7) {
                L(parcel, i7, 0);
            }
        } else {
            int iJ = J(parcel, i7);
            parcel.writeBooleanArray(zArr);
            K(parcel, iJ);
        }
    }

    public static void i(Parcel parcel, int i7, Boolean bool, boolean z7) {
        if (bool != null) {
            L(parcel, i7, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z7) {
            L(parcel, i7, 0);
        }
    }

    public static void j(Parcel parcel, int i7, Bundle bundle, boolean z7) {
        if (bundle == null) {
            if (z7) {
                L(parcel, i7, 0);
            }
        } else {
            int iJ = J(parcel, i7);
            parcel.writeBundle(bundle);
            K(parcel, iJ);
        }
    }

    public static void k(Parcel parcel, int i7, byte[] bArr, boolean z7) {
        if (bArr == null) {
            if (z7) {
                L(parcel, i7, 0);
            }
        } else {
            int iJ = J(parcel, i7);
            parcel.writeByteArray(bArr);
            K(parcel, iJ);
        }
    }

    public static void l(Parcel parcel, int i7, byte[][] bArr, boolean z7) {
        if (bArr == null) {
            if (z7) {
                L(parcel, i7, 0);
                return;
            }
            return;
        }
        int iJ = J(parcel, i7);
        parcel.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            parcel.writeByteArray(bArr2);
        }
        K(parcel, iJ);
    }

    public static void m(Parcel parcel, int i7, double d7) {
        L(parcel, i7, 8);
        parcel.writeDouble(d7);
    }

    public static void n(Parcel parcel, int i7, double[] dArr, boolean z7) {
        if (dArr == null) {
            if (z7) {
                L(parcel, i7, 0);
            }
        } else {
            int iJ = J(parcel, i7);
            parcel.writeDoubleArray(dArr);
            K(parcel, iJ);
        }
    }

    public static void o(Parcel parcel, int i7, Double d7, boolean z7) {
        if (d7 != null) {
            L(parcel, i7, 8);
            parcel.writeDouble(d7.doubleValue());
        } else if (z7) {
            L(parcel, i7, 0);
        }
    }

    public static void p(Parcel parcel, int i7, float f7) {
        L(parcel, i7, 4);
        parcel.writeFloat(f7);
    }

    public static void q(Parcel parcel, int i7, float[] fArr, boolean z7) {
        if (fArr == null) {
            if (z7) {
                L(parcel, i7, 0);
            }
        } else {
            int iJ = J(parcel, i7);
            parcel.writeFloatArray(fArr);
            K(parcel, iJ);
        }
    }

    public static void r(Parcel parcel, int i7, Float f7, boolean z7) {
        if (f7 != null) {
            L(parcel, i7, 4);
            parcel.writeFloat(f7.floatValue());
        } else if (z7) {
            L(parcel, i7, 0);
        }
    }

    public static void s(Parcel parcel, int i7, IBinder iBinder, boolean z7) {
        if (iBinder == null) {
            if (z7) {
                L(parcel, i7, 0);
            }
        } else {
            int iJ = J(parcel, i7);
            parcel.writeStrongBinder(iBinder);
            K(parcel, iJ);
        }
    }

    public static void t(Parcel parcel, int i7, int i8) {
        L(parcel, i7, 4);
        parcel.writeInt(i8);
    }

    public static void u(Parcel parcel, int i7, int[] iArr, boolean z7) {
        if (iArr == null) {
            if (z7) {
                L(parcel, i7, 0);
            }
        } else {
            int iJ = J(parcel, i7);
            parcel.writeIntArray(iArr);
            K(parcel, iJ);
        }
    }

    public static void v(Parcel parcel, int i7, List list, boolean z7) {
        if (list == null) {
            if (z7) {
                L(parcel, i7, 0);
                return;
            }
            return;
        }
        int iJ = J(parcel, i7);
        int size = list.size();
        parcel.writeInt(size);
        for (int i8 = 0; i8 < size; i8++) {
            parcel.writeInt(((Integer) list.get(i8)).intValue());
        }
        K(parcel, iJ);
    }

    public static void w(Parcel parcel, int i7, Integer num, boolean z7) {
        if (num != null) {
            L(parcel, i7, 4);
            parcel.writeInt(num.intValue());
        } else if (z7) {
            L(parcel, i7, 0);
        }
    }

    public static void x(Parcel parcel, int i7, long j7) {
        L(parcel, i7, 8);
        parcel.writeLong(j7);
    }

    public static void y(Parcel parcel, int i7, long[] jArr, boolean z7) {
        if (jArr == null) {
            if (z7) {
                L(parcel, i7, 0);
            }
        } else {
            int iJ = J(parcel, i7);
            parcel.writeLongArray(jArr);
            K(parcel, iJ);
        }
    }

    public static void z(Parcel parcel, int i7, Long l7, boolean z7) {
        if (l7 != null) {
            L(parcel, i7, 8);
            parcel.writeLong(l7.longValue());
        } else if (z7) {
            L(parcel, i7, 0);
        }
    }
}
