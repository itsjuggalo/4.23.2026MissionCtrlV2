package T1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static int a(Parcel parcel) {
        return t(parcel, 20293);
    }

    public static void b(Parcel parcel, int i8) {
        u(parcel, i8);
    }

    public static void c(Parcel parcel, int i8, boolean z7) {
        v(parcel, i8, 4);
        parcel.writeInt(z7 ? 1 : 0);
    }

    public static void d(Parcel parcel, int i8, Boolean bool, boolean z7) {
        if (bool != null) {
            v(parcel, i8, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z7) {
            v(parcel, i8, 0);
        }
    }

    public static void e(Parcel parcel, int i8, Bundle bundle, boolean z7) {
        if (bundle == null) {
            if (z7) {
                v(parcel, i8, 0);
            }
        } else {
            int iT = t(parcel, i8);
            parcel.writeBundle(bundle);
            u(parcel, iT);
        }
    }

    public static void f(Parcel parcel, int i8, byte[] bArr, boolean z7) {
        if (bArr == null) {
            if (z7) {
                v(parcel, i8, 0);
            }
        } else {
            int iT = t(parcel, i8);
            parcel.writeByteArray(bArr);
            u(parcel, iT);
        }
    }

    public static void g(Parcel parcel, int i8, Double d8, boolean z7) {
        if (d8 != null) {
            v(parcel, i8, 8);
            parcel.writeDouble(d8.doubleValue());
        } else if (z7) {
            v(parcel, i8, 0);
        }
    }

    public static void h(Parcel parcel, int i8, Float f8, boolean z7) {
        if (f8 != null) {
            v(parcel, i8, 4);
            parcel.writeFloat(f8.floatValue());
        } else if (z7) {
            v(parcel, i8, 0);
        }
    }

    public static void i(Parcel parcel, int i8, IBinder iBinder, boolean z7) {
        if (iBinder == null) {
            if (z7) {
                v(parcel, i8, 0);
            }
        } else {
            int iT = t(parcel, i8);
            parcel.writeStrongBinder(iBinder);
            u(parcel, iT);
        }
    }

    public static void j(Parcel parcel, int i8, int i9) {
        v(parcel, i8, 4);
        parcel.writeInt(i9);
    }

    public static void k(Parcel parcel, int i8, int[] iArr, boolean z7) {
        if (iArr == null) {
            if (z7) {
                v(parcel, i8, 0);
            }
        } else {
            int iT = t(parcel, i8);
            parcel.writeIntArray(iArr);
            u(parcel, iT);
        }
    }

    public static void l(Parcel parcel, int i8, List list, boolean z7) {
        if (list == null) {
            if (z7) {
                v(parcel, i8, 0);
                return;
            }
            return;
        }
        int iT = t(parcel, i8);
        int size = list.size();
        parcel.writeInt(size);
        for (int i9 = 0; i9 < size; i9++) {
            parcel.writeInt(((Integer) list.get(i9)).intValue());
        }
        u(parcel, iT);
    }

    public static void m(Parcel parcel, int i8, long j8) {
        v(parcel, i8, 8);
        parcel.writeLong(j8);
    }

    public static void n(Parcel parcel, int i8, Long l8, boolean z7) {
        if (l8 != null) {
            v(parcel, i8, 8);
            parcel.writeLong(l8.longValue());
        } else if (z7) {
            v(parcel, i8, 0);
        }
    }

    public static void o(Parcel parcel, int i8, Parcelable parcelable, int i9, boolean z7) {
        if (parcelable == null) {
            if (z7) {
                v(parcel, i8, 0);
            }
        } else {
            int iT = t(parcel, i8);
            parcelable.writeToParcel(parcel, i9);
            u(parcel, iT);
        }
    }

    public static void p(Parcel parcel, int i8, String str, boolean z7) {
        if (str == null) {
            if (z7) {
                v(parcel, i8, 0);
            }
        } else {
            int iT = t(parcel, i8);
            parcel.writeString(str);
            u(parcel, iT);
        }
    }

    public static void q(Parcel parcel, int i8, List list, boolean z7) {
        if (list == null) {
            if (z7) {
                v(parcel, i8, 0);
            }
        } else {
            int iT = t(parcel, i8);
            parcel.writeStringList(list);
            u(parcel, iT);
        }
    }

    public static void r(Parcel parcel, int i8, Parcelable[] parcelableArr, int i9, boolean z7) {
        if (parcelableArr == null) {
            if (z7) {
                v(parcel, i8, 0);
                return;
            }
            return;
        }
        int iT = t(parcel, i8);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                w(parcel, parcelable, i9);
            }
        }
        u(parcel, iT);
    }

    public static void s(Parcel parcel, int i8, List list, boolean z7) {
        if (list == null) {
            if (z7) {
                v(parcel, i8, 0);
                return;
            }
            return;
        }
        int iT = t(parcel, i8);
        int size = list.size();
        parcel.writeInt(size);
        for (int i9 = 0; i9 < size; i9++) {
            Parcelable parcelable = (Parcelable) list.get(i9);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                w(parcel, parcelable, 0);
            }
        }
        u(parcel, iT);
    }

    public static int t(Parcel parcel, int i8) {
        parcel.writeInt(i8 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void u(Parcel parcel, int i8) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i8 - 4);
        parcel.writeInt(iDataPosition - i8);
        parcel.setDataPosition(iDataPosition);
    }

    public static void v(Parcel parcel, int i8, int i9) {
        parcel.writeInt(i8 | (i9 << 16));
    }

    public static void w(Parcel parcel, Parcelable parcelable, int i8) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i8);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }
}
