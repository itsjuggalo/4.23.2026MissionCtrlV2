package r5;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.s;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import n5.b;
import r5.a;
import t5.l;
import t5.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c extends b {
    public static final Parcelable.Creator<c> CREATOR = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Parcel f19330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f19331c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f19332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f19333e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f19334f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f19335g;

    public c(int i10, Parcel parcel, h hVar) {
        this.f19329a = i10;
        this.f19330b = (Parcel) s.k(parcel);
        this.f19332d = hVar;
        this.f19333e = hVar == null ? null : hVar.T();
        this.f19334f = 2;
    }

    public static final void h(StringBuilder sb2, int i10, Object obj) {
        switch (i10) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb2.append(obj);
                return;
            case 7:
                sb2.append("\"");
                sb2.append(l.a(s.k(obj).toString()));
                sb2.append("\"");
                return;
            case 8:
                sb2.append("\"");
                sb2.append(t5.c.c((byte[]) obj));
                sb2.append("\"");
                return;
            case 9:
                sb2.append("\"");
                sb2.append(t5.c.d((byte[]) obj));
                sb2.append("\"");
                return;
            case 10:
                m.a(sb2, (HashMap) s.k(obj));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                StringBuilder sb3 = new StringBuilder(String.valueOf(i10).length() + 15);
                sb3.append("Unknown type = ");
                sb3.append(i10);
                throw new IllegalArgumentException(sb3.toString());
        }
    }

    public static final void i(StringBuilder sb2, a.C0336a c0336a, Object obj) {
        if (!c0336a.f19320c) {
            h(sb2, c0336a.f19319b, obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        sb2.append("[");
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 != 0) {
                sb2.append(com.amazon.a.a.o.b.f.f4598a);
            }
            h(sb2, c0336a.f19319b, arrayList.get(i10));
        }
        sb2.append("]");
    }

    @Override // r5.a
    public final void addConcreteTypeArrayInternal(a.C0336a c0336a, String str, ArrayList arrayList) {
        f(c0336a);
        ArrayList arrayList2 = new ArrayList();
        ((ArrayList) s.k(arrayList)).size();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList2.add(((c) ((a) arrayList.get(i10))).e());
        }
        n5.c.B(this.f19330b, c0336a.X(), arrayList2, true);
    }

    @Override // r5.a
    public final void addConcreteTypeInternal(a.C0336a c0336a, String str, a aVar) {
        f(c0336a);
        n5.c.A(this.f19330b, c0336a.X(), ((c) aVar).e(), true);
    }

    public final Parcel e() {
        int i10 = this.f19334f;
        if (i10 == 0) {
            Parcel parcel = this.f19330b;
            int iA = n5.c.a(parcel);
            this.f19335g = iA;
            n5.c.b(parcel, iA);
            this.f19334f = 2;
        } else if (i10 == 1) {
            n5.c.b(this.f19330b, this.f19335g);
            this.f19334f = 2;
        }
        return this.f19330b;
    }

    public final void f(a.C0336a c0336a) {
        if (c0336a.f19324g == -1) {
            throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
        }
        Parcel parcel = this.f19330b;
        if (parcel == null) {
            throw new IllegalStateException("Internal Parcel object is null.");
        }
        int i10 = this.f19334f;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
            }
        } else {
            this.f19335g = n5.c.a(parcel);
            this.f19334f = 1;
        }
    }

    public final void g(StringBuilder sb2, Map map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry entry : map.entrySet()) {
            sparseArray.put(((a.C0336a) entry.getValue()).X(), entry);
        }
        sb2.append('{');
        int iM = n5.b.M(parcel);
        boolean z10 = false;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            Map.Entry entry2 = (Map.Entry) sparseArray.get(n5.b.w(iD));
            if (entry2 != null) {
                if (z10) {
                    sb2.append(com.amazon.a.a.o.b.f.f4598a);
                }
                String str = (String) entry2.getKey();
                a.C0336a c0336a = (a.C0336a) entry2.getValue();
                sb2.append("\"");
                sb2.append(str);
                sb2.append("\":");
                if (c0336a.Z()) {
                    int i10 = c0336a.f19321d;
                    switch (i10) {
                        case 0:
                            i(sb2, c0336a, a.zaD(c0336a, Integer.valueOf(n5.b.F(parcel, iD))));
                            break;
                        case 1:
                            i(sb2, c0336a, a.zaD(c0336a, n5.b.c(parcel, iD)));
                            break;
                        case 2:
                            i(sb2, c0336a, a.zaD(c0336a, Long.valueOf(n5.b.H(parcel, iD))));
                            break;
                        case 3:
                            i(sb2, c0336a, a.zaD(c0336a, Float.valueOf(n5.b.B(parcel, iD))));
                            break;
                        case 4:
                            i(sb2, c0336a, a.zaD(c0336a, Double.valueOf(n5.b.z(parcel, iD))));
                            break;
                        case 5:
                            i(sb2, c0336a, a.zaD(c0336a, n5.b.a(parcel, iD)));
                            break;
                        case 6:
                            i(sb2, c0336a, a.zaD(c0336a, Boolean.valueOf(n5.b.x(parcel, iD))));
                            break;
                        case 7:
                            i(sb2, c0336a, a.zaD(c0336a, n5.b.q(parcel, iD)));
                            break;
                        case 8:
                        case 9:
                            i(sb2, c0336a, a.zaD(c0336a, n5.b.g(parcel, iD)));
                            break;
                        case 10:
                            Bundle bundleF = n5.b.f(parcel, iD);
                            HashMap map2 = new HashMap();
                            for (String str2 : bundleF.keySet()) {
                                map2.put(str2, (String) s.k(bundleF.getString(str2)));
                            }
                            i(sb2, c0336a, a.zaD(c0336a, map2));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            StringBuilder sb3 = new StringBuilder(String.valueOf(i10).length() + 25);
                            sb3.append("Unknown field out type = ");
                            sb3.append(i10);
                            throw new IllegalArgumentException(sb3.toString());
                    }
                } else if (c0336a.f19322e) {
                    sb2.append("[");
                    switch (c0336a.f19321d) {
                        case 0:
                            t5.b.e(sb2, n5.b.k(parcel, iD));
                            break;
                        case 1:
                            t5.b.g(sb2, n5.b.d(parcel, iD));
                            break;
                        case 2:
                            t5.b.f(sb2, n5.b.m(parcel, iD));
                            break;
                        case 3:
                            t5.b.d(sb2, n5.b.j(parcel, iD));
                            break;
                        case 4:
                            t5.b.c(sb2, n5.b.i(parcel, iD));
                            break;
                        case 5:
                            t5.b.g(sb2, n5.b.b(parcel, iD));
                            break;
                        case 6:
                            t5.b.h(sb2, n5.b.e(parcel, iD));
                            break;
                        case 7:
                            t5.b.i(sb2, n5.b.r(parcel, iD));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case 11:
                            Parcel[] parcelArrO = n5.b.o(parcel, iD);
                            int length = parcelArrO.length;
                            for (int i11 = 0; i11 < length; i11++) {
                                if (i11 > 0) {
                                    sb2.append(com.amazon.a.a.o.b.f.f4598a);
                                }
                                parcelArrO[i11].setDataPosition(0);
                                g(sb2, c0336a.c0(), parcelArrO[i11]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    sb2.append("]");
                } else {
                    switch (c0336a.f19321d) {
                        case 0:
                            sb2.append(n5.b.F(parcel, iD));
                            break;
                        case 1:
                            sb2.append(n5.b.c(parcel, iD));
                            break;
                        case 2:
                            sb2.append(n5.b.H(parcel, iD));
                            break;
                        case 3:
                            sb2.append(n5.b.B(parcel, iD));
                            break;
                        case 4:
                            sb2.append(n5.b.z(parcel, iD));
                            break;
                        case 5:
                            sb2.append(n5.b.a(parcel, iD));
                            break;
                        case 6:
                            sb2.append(n5.b.x(parcel, iD));
                            break;
                        case 7:
                            String strQ = n5.b.q(parcel, iD);
                            sb2.append("\"");
                            sb2.append(l.a(strQ));
                            sb2.append("\"");
                            break;
                        case 8:
                            byte[] bArrG = n5.b.g(parcel, iD);
                            sb2.append("\"");
                            sb2.append(t5.c.c(bArrG));
                            sb2.append("\"");
                            break;
                        case 9:
                            byte[] bArrG2 = n5.b.g(parcel, iD);
                            sb2.append("\"");
                            sb2.append(t5.c.d(bArrG2));
                            sb2.append("\"");
                            break;
                        case 10:
                            Bundle bundleF2 = n5.b.f(parcel, iD);
                            Set<String> setKeySet = bundleF2.keySet();
                            sb2.append("{");
                            boolean z11 = true;
                            for (String str3 : setKeySet) {
                                if (!z11) {
                                    sb2.append(com.amazon.a.a.o.b.f.f4598a);
                                }
                                sb2.append("\"");
                                sb2.append(str3);
                                sb2.append("\":\"");
                                sb2.append(l.a(bundleF2.getString(str3)));
                                sb2.append("\"");
                                z11 = false;
                            }
                            sb2.append("}");
                            break;
                        case 11:
                            Parcel parcelN = n5.b.n(parcel, iD);
                            parcelN.setDataPosition(0);
                            g(sb2, c0336a.c0(), parcelN);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                z10 = true;
            }
        }
        if (parcel.dataPosition() == iM) {
            sb2.append('}');
            return;
        }
        StringBuilder sb4 = new StringBuilder(String.valueOf(iM).length() + 26);
        sb4.append("Overread allowed size end=");
        sb4.append(iM);
        throw new b.a(sb4.toString(), parcel);
    }

    @Override // r5.a
    public final Map getFieldMappings() {
        h hVar = this.f19332d;
        if (hVar == null) {
            return null;
        }
        return hVar.S((String) s.k(this.f19333e));
    }

    @Override // r5.b, r5.a
    public final Object getValueObject(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // r5.b, r5.a
    public final boolean isPrimitiveFieldSet(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // r5.a
    public final void setBooleanInternal(a.C0336a c0336a, String str, boolean z10) {
        f(c0336a);
        n5.c.g(this.f19330b, c0336a.X(), z10);
    }

    @Override // r5.a
    public final void setDecodedBytesInternal(a.C0336a c0336a, String str, byte[] bArr) {
        f(c0336a);
        n5.c.k(this.f19330b, c0336a.X(), bArr, true);
    }

    @Override // r5.a
    public final void setIntegerInternal(a.C0336a c0336a, String str, int i10) {
        f(c0336a);
        n5.c.t(this.f19330b, c0336a.X(), i10);
    }

    @Override // r5.a
    public final void setLongInternal(a.C0336a c0336a, String str, long j10) {
        f(c0336a);
        n5.c.x(this.f19330b, c0336a.X(), j10);
    }

    @Override // r5.a
    public final void setStringInternal(a.C0336a c0336a, String str, String str2) {
        f(c0336a);
        n5.c.E(this.f19330b, c0336a.X(), str2, true);
    }

    @Override // r5.a
    public final void setStringMapInternal(a.C0336a c0336a, String str, Map map) {
        f(c0336a);
        Bundle bundle = new Bundle();
        for (String str2 : ((Map) s.k(map)).keySet()) {
            bundle.putString(str2, (String) map.get(str2));
        }
        n5.c.j(this.f19330b, c0336a.X(), bundle, true);
    }

    @Override // r5.a
    public final void setStringsInternal(a.C0336a c0336a, String str, ArrayList arrayList) {
        f(c0336a);
        int size = ((ArrayList) s.k(arrayList)).size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 < size; i10++) {
            strArr[i10] = (String) arrayList.get(i10);
        }
        n5.c.F(this.f19330b, c0336a.X(), strArr, true);
    }

    @Override // r5.a
    public final String toString() {
        h hVar = this.f19332d;
        s.l(hVar, "Cannot convert to JSON on client side.");
        Parcel parcelE = e();
        parcelE.setDataPosition(0);
        StringBuilder sb2 = new StringBuilder(100);
        g(sb2, (Map) s.k(hVar.S((String) s.k(this.f19333e))), parcelE);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f19329a;
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, i11);
        n5.c.A(parcel, 2, e(), false);
        int i12 = this.f19331c;
        n5.c.C(parcel, 3, i12 != 0 ? i12 != 1 ? this.f19332d : this.f19332d : null, i10, false);
        n5.c.b(parcel, iA);
    }

    @Override // r5.a
    public final void zaA(a.C0336a c0336a, String str, BigDecimal bigDecimal) {
        f(c0336a);
        n5.c.c(this.f19330b, c0336a.X(), bigDecimal, true);
    }

    @Override // r5.a
    public final void zaB(a.C0336a c0336a, String str, ArrayList arrayList) {
        f(c0336a);
        int size = ((ArrayList) s.k(arrayList)).size();
        BigDecimal[] bigDecimalArr = new BigDecimal[size];
        for (int i10 = 0; i10 < size; i10++) {
            bigDecimalArr[i10] = (BigDecimal) arrayList.get(i10);
        }
        n5.c.d(this.f19330b, c0336a.X(), bigDecimalArr, true);
    }

    @Override // r5.a
    public final void zaC(a.C0336a c0336a, String str, ArrayList arrayList) {
        f(c0336a);
        int size = ((ArrayList) s.k(arrayList)).size();
        boolean[] zArr = new boolean[size];
        for (int i10 = 0; i10 < size; i10++) {
            zArr[i10] = ((Boolean) arrayList.get(i10)).booleanValue();
        }
        n5.c.h(this.f19330b, c0336a.X(), zArr, true);
    }

    @Override // r5.a
    public final void zas(a.C0336a c0336a, String str, ArrayList arrayList) {
        f(c0336a);
        int size = ((ArrayList) s.k(arrayList)).size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = ((Integer) arrayList.get(i10)).intValue();
        }
        n5.c.u(this.f19330b, c0336a.X(), iArr, true);
    }

    @Override // r5.a
    public final void zat(a.C0336a c0336a, String str, BigInteger bigInteger) {
        f(c0336a);
        n5.c.e(this.f19330b, c0336a.X(), bigInteger, true);
    }

    @Override // r5.a
    public final void zau(a.C0336a c0336a, String str, ArrayList arrayList) {
        f(c0336a);
        int size = ((ArrayList) s.k(arrayList)).size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i10 = 0; i10 < size; i10++) {
            bigIntegerArr[i10] = (BigInteger) arrayList.get(i10);
        }
        n5.c.f(this.f19330b, c0336a.X(), bigIntegerArr, true);
    }

    @Override // r5.a
    public final void zav(a.C0336a c0336a, String str, ArrayList arrayList) {
        f(c0336a);
        int size = ((ArrayList) s.k(arrayList)).size();
        long[] jArr = new long[size];
        for (int i10 = 0; i10 < size; i10++) {
            jArr[i10] = ((Long) arrayList.get(i10)).longValue();
        }
        n5.c.y(this.f19330b, c0336a.X(), jArr, true);
    }

    @Override // r5.a
    public final void zaw(a.C0336a c0336a, String str, float f10) {
        f(c0336a);
        n5.c.p(this.f19330b, c0336a.X(), f10);
    }

    @Override // r5.a
    public final void zax(a.C0336a c0336a, String str, ArrayList arrayList) {
        f(c0336a);
        int size = ((ArrayList) s.k(arrayList)).size();
        float[] fArr = new float[size];
        for (int i10 = 0; i10 < size; i10++) {
            fArr[i10] = ((Float) arrayList.get(i10)).floatValue();
        }
        n5.c.q(this.f19330b, c0336a.X(), fArr, true);
    }

    @Override // r5.a
    public final void zay(a.C0336a c0336a, String str, double d10) {
        f(c0336a);
        n5.c.m(this.f19330b, c0336a.X(), d10);
    }

    @Override // r5.a
    public final void zaz(a.C0336a c0336a, String str, ArrayList arrayList) {
        f(c0336a);
        int size = ((ArrayList) s.k(arrayList)).size();
        double[] dArr = new double[size];
        for (int i10 = 0; i10 < size; i10++) {
            dArr[i10] = ((Double) arrayList.get(i10)).doubleValue();
        }
        n5.c.n(this.f19330b, c0336a.X(), dArr, true);
    }
}
