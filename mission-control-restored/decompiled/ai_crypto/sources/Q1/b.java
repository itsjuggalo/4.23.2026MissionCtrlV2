package Q1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    public static class a extends RuntimeException {
        public a(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    public static Double A(Parcel parcel, int i7) {
        int iK = K(parcel, i7);
        if (iK == 0) {
            return null;
        }
        N(parcel, i7, iK, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static float B(Parcel parcel, int i7) {
        O(parcel, i7, 4);
        return parcel.readFloat();
    }

    public static Float C(Parcel parcel, int i7) {
        int iK = K(parcel, i7);
        if (iK == 0) {
            return null;
        }
        N(parcel, i7, iK, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int D(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder E(Parcel parcel, int i7) {
        int iK = K(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iK);
        return strongBinder;
    }

    public static int F(Parcel parcel, int i7) {
        O(parcel, i7, 4);
        return parcel.readInt();
    }

    public static Integer G(Parcel parcel, int i7) {
        int iK = K(parcel, i7);
        if (iK == 0) {
            return null;
        }
        N(parcel, i7, iK, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static long H(Parcel parcel, int i7) {
        O(parcel, i7, 8);
        return parcel.readLong();
    }

    public static Long I(Parcel parcel, int i7) {
        int iK = K(parcel, i7);
        if (iK == 0) {
            return null;
        }
        N(parcel, i7, iK, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static short J(Parcel parcel, int i7) {
        O(parcel, i7, 4);
        return (short) parcel.readInt();
    }

    public static int K(Parcel parcel, int i7) {
        return (i7 & (-65536)) != -65536 ? (char) (i7 >> 16) : parcel.readInt();
    }

    public static void L(Parcel parcel, int i7) {
        parcel.setDataPosition(parcel.dataPosition() + K(parcel, i7));
    }

    public static int M(Parcel parcel) {
        int iD = D(parcel);
        int iK = K(parcel, iD);
        int iW = w(iD);
        int iDataPosition = parcel.dataPosition();
        if (iW != 20293) {
            throw new a("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(iD))), parcel);
        }
        int i7 = iK + iDataPosition;
        if (i7 >= iDataPosition && i7 <= parcel.dataSize()) {
            return i7;
        }
        throw new a("Size read is invalid start=" + iDataPosition + " end=" + i7, parcel);
    }

    public static void N(Parcel parcel, int i7, int i8, int i9) {
        if (i8 == i9) {
            return;
        }
        throw new a("Expected size " + i9 + " got " + i8 + " (0x" + Integer.toHexString(i8) + ")", parcel);
    }

    public static void O(Parcel parcel, int i7, int i8) {
        int iK = K(parcel, i7);
        if (iK == i8) {
            return;
        }
        throw new a("Expected size " + i8 + " got " + iK + " (0x" + Integer.toHexString(iK) + ")", parcel);
    }

    public static BigDecimal a(Parcel parcel, int i7) {
        int iK = K(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        int i8 = parcel.readInt();
        parcel.setDataPosition(iDataPosition + iK);
        return new BigDecimal(new BigInteger(bArrCreateByteArray), i8);
    }

    public static BigDecimal[] b(Parcel parcel, int i7) {
        int iK = K(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        int i8 = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            byte[] bArrCreateByteArray = parcel.createByteArray();
            bigDecimalArr[i9] = new BigDecimal(new BigInteger(bArrCreateByteArray), parcel.readInt());
        }
        parcel.setDataPosition(iDataPosition + iK);
        return bigDecimalArr;
    }

    public static BigInteger c(Parcel parcel, int i7) {
        int iK = K(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iK);
        return new BigInteger(bArrCreateByteArray);
    }

    public static BigInteger[] d(Parcel parcel, int i7) {
        int iK = K(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        int i8 = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            bigIntegerArr[i9] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(iDataPosition + iK);
        return bigIntegerArr;
    }

    public static boolean[] e(Parcel parcel, int i7) {
        int iK = K(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        boolean[] zArrCreateBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(iDataPosition + iK);
        return zArrCreateBooleanArray;
    }

    public static Bundle f(Parcel parcel, int i7) {
        int iK = K(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iK);
        return bundle;
    }

    public static byte[] g(Parcel parcel, int i7) {
        int iK = K(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iK);
        return bArrCreateByteArray;
    }

    public static byte[][] h(Parcel parcel, int i7) {
        int iK = K(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        int i8 = parcel.readInt();
        byte[][] bArr = new byte[i8][];
        for (int i9 = 0; i9 < i8; i9++) {
            bArr[i9] = parcel.createByteArray();
        }
        parcel.setDataPosition(iDataPosition + iK);
        return bArr;
    }

    public static double[] i(Parcel parcel, int i7) {
        int iK = K(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        double[] dArrCreateDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(iDataPosition + iK);
        return dArrCreateDoubleArray;
    }

    public static float[] j(Parcel parcel, int i7) {
        int iK = K(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        float[] fArrCreateFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(iDataPosition + iK);
        return fArrCreateFloatArray;
    }

    public static int[] k(Parcel parcel, int i7) {
        int iK = K(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + iK);
        return iArrCreateIntArray;
    }

    public static ArrayList l(Parcel parcel, int i7) {
        int iK = K(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i8 = parcel.readInt();
        for (int i9 = 0; i9 < i8; i9++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(iDataPosition + iK);
        return arrayList;
    }

    public static long[] m(Parcel parcel, int i7) {
        int iK = K(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        long[] jArrCreateLongArray = parcel.createLongArray();
        parcel.setDataPosition(iDataPosition + iK);
        return jArrCreateLongArray;
    }

    public static Parcel n(Parcel parcel, int i7) {
        int iK = K(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.appendFrom(parcel, iDataPosition, iK);
        parcel.setDataPosition(iDataPosition + iK);
        return parcelObtain;
    }

    public static Parcel[] o(Parcel parcel, int i7) {
        int iK = K(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        int i8 = parcel.readInt();
        Parcel[] parcelArr = new Parcel[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            int i10 = parcel.readInt();
            if (i10 != 0) {
                int iDataPosition2 = parcel.dataPosition();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.appendFrom(parcel, iDataPosition2, i10);
                parcelArr[i9] = parcelObtain;
                parcel.setDataPosition(iDataPosition2 + i10);
            } else {
                parcelArr[i9] = null;
            }
        }
        parcel.setDataPosition(iDataPosition + iK);
        return parcelArr;
    }

    public static Parcelable p(Parcel parcel, int i7, Parcelable.Creator creator) {
        int iK = K(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iK);
        return parcelable;
    }

    public static String q(Parcel parcel, int i7) {
        int iK = K(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iK);
        return string;
    }

    public static String[] r(Parcel parcel, int i7) {
        int iK = K(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        String[] strArrCreateStringArray = parcel.createStringArray();
        parcel.setDataPosition(iDataPosition + iK);
        return strArrCreateStringArray;
    }

    public static ArrayList s(Parcel parcel, int i7) {
        int iK = K(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iK);
        return arrayListCreateStringArrayList;
    }

    public static Object[] t(Parcel parcel, int i7, Parcelable.Creator creator) {
        int iK = K(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iK);
        return objArrCreateTypedArray;
    }

    public static ArrayList u(Parcel parcel, int i7, Parcelable.Creator creator) {
        int iK = K(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iK);
        return arrayListCreateTypedArrayList;
    }

    public static void v(Parcel parcel, int i7) {
        if (parcel.dataPosition() == i7) {
            return;
        }
        throw new a("Overread allowed size end=" + i7, parcel);
    }

    public static int w(int i7) {
        return (char) i7;
    }

    public static boolean x(Parcel parcel, int i7) {
        O(parcel, i7, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean y(Parcel parcel, int i7) {
        int iK = K(parcel, i7);
        if (iK == 0) {
            return null;
        }
        N(parcel, i7, iK, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static double z(Parcel parcel, int i7) {
        O(parcel, i7, 8);
        return parcel.readDouble();
    }
}
