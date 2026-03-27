package E1;

import A1.b;
import E1.a;
import G1.l;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class c extends b {
    public static final Parcelable.Creator<c> CREATOR = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Parcel f393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f394c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f397f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f398g;

    public c(int i4, Parcel parcel, h hVar) {
        this.f392a = i4;
        this.f393b = (Parcel) AbstractC0940s.k(parcel);
        this.f395d = hVar;
        this.f396e = hVar == null ? null : hVar.i();
        this.f397f = 2;
    }

    public static final void g(StringBuilder sb, int i4, Object obj) {
        switch (i4) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                sb.append(G1.k.a(AbstractC0940s.k(obj).toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                sb.append(G1.c.c((byte[]) obj));
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                sb.append(G1.c.d((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                l.a(sb, (HashMap) AbstractC0940s.k(obj));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i4);
        }
    }

    public static final void h(StringBuilder sb, a.C0016a c0016a, Object obj) {
        if (!c0016a.f383c) {
            g(sb, c0016a.f382b, obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        sb.append("[");
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 != 0) {
                sb.append(com.amazon.a.a.o.b.f.f8804a);
            }
            g(sb, c0016a.f382b, arrayList.get(i4));
        }
        sb.append("]");
    }

    @Override // E1.a
    public final void addConcreteTypeArrayInternal(a.C0016a c0016a, String str, ArrayList arrayList) {
        e(c0016a);
        ArrayList arrayList2 = new ArrayList();
        ((ArrayList) AbstractC0940s.k(arrayList)).size();
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            arrayList2.add(((c) ((a) arrayList.get(i4))).d());
        }
        A1.c.B(this.f393b, c0016a.p(), arrayList2, true);
    }

    @Override // E1.a
    public final void addConcreteTypeInternal(a.C0016a c0016a, String str, a aVar) {
        e(c0016a);
        A1.c.A(this.f393b, c0016a.p(), ((c) aVar).d(), true);
    }

    public final Parcel d() {
        int i4 = this.f397f;
        if (i4 == 0) {
            int iA = A1.c.a(this.f393b);
            this.f398g = iA;
            A1.c.b(this.f393b, iA);
            this.f397f = 2;
        } else if (i4 == 1) {
            A1.c.b(this.f393b, this.f398g);
            this.f397f = 2;
        }
        return this.f393b;
    }

    public final void e(a.C0016a c0016a) {
        if (c0016a.f387g == -1) {
            throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
        }
        Parcel parcel = this.f393b;
        if (parcel == null) {
            throw new IllegalStateException("Internal Parcel object is null.");
        }
        int i4 = this.f397f;
        if (i4 != 0) {
            if (i4 != 1) {
                throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
            }
        } else {
            this.f398g = A1.c.a(parcel);
            this.f397f = 1;
        }
    }

    public final void f(StringBuilder sb, Map map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry entry : map.entrySet()) {
            sparseArray.put(((a.C0016a) entry.getValue()).p(), entry);
        }
        sb.append('{');
        int iM = A1.b.M(parcel);
        boolean z4 = false;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            Map.Entry entry2 = (Map.Entry) sparseArray.get(A1.b.w(iD));
            if (entry2 != null) {
                if (z4) {
                    sb.append(com.amazon.a.a.o.b.f.f8804a);
                }
                String str = (String) entry2.getKey();
                a.C0016a c0016a = (a.C0016a) entry2.getValue();
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (c0016a.x()) {
                    int i4 = c0016a.f384d;
                    switch (i4) {
                        case 0:
                            h(sb, c0016a, a.zaD(c0016a, Integer.valueOf(A1.b.F(parcel, iD))));
                            break;
                        case 1:
                            h(sb, c0016a, a.zaD(c0016a, A1.b.c(parcel, iD)));
                            break;
                        case 2:
                            h(sb, c0016a, a.zaD(c0016a, Long.valueOf(A1.b.H(parcel, iD))));
                            break;
                        case 3:
                            h(sb, c0016a, a.zaD(c0016a, Float.valueOf(A1.b.B(parcel, iD))));
                            break;
                        case 4:
                            h(sb, c0016a, a.zaD(c0016a, Double.valueOf(A1.b.z(parcel, iD))));
                            break;
                        case 5:
                            h(sb, c0016a, a.zaD(c0016a, A1.b.a(parcel, iD)));
                            break;
                        case 6:
                            h(sb, c0016a, a.zaD(c0016a, Boolean.valueOf(A1.b.x(parcel, iD))));
                            break;
                        case 7:
                            h(sb, c0016a, a.zaD(c0016a, A1.b.q(parcel, iD)));
                            break;
                        case 8:
                        case 9:
                            h(sb, c0016a, a.zaD(c0016a, A1.b.g(parcel, iD)));
                            break;
                        case 10:
                            Bundle bundleF = A1.b.f(parcel, iD);
                            HashMap map2 = new HashMap();
                            for (String str2 : bundleF.keySet()) {
                                map2.put(str2, (String) AbstractC0940s.k(bundleF.getString(str2)));
                            }
                            h(sb, c0016a, a.zaD(c0016a, map2));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            throw new IllegalArgumentException("Unknown field out type = " + i4);
                    }
                } else if (c0016a.f385e) {
                    sb.append("[");
                    switch (c0016a.f384d) {
                        case 0:
                            G1.b.e(sb, A1.b.k(parcel, iD));
                            break;
                        case 1:
                            G1.b.g(sb, A1.b.d(parcel, iD));
                            break;
                        case 2:
                            G1.b.f(sb, A1.b.m(parcel, iD));
                            break;
                        case 3:
                            G1.b.d(sb, A1.b.j(parcel, iD));
                            break;
                        case 4:
                            G1.b.c(sb, A1.b.i(parcel, iD));
                            break;
                        case 5:
                            G1.b.g(sb, A1.b.b(parcel, iD));
                            break;
                        case 6:
                            G1.b.h(sb, A1.b.e(parcel, iD));
                            break;
                        case 7:
                            G1.b.i(sb, A1.b.r(parcel, iD));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case 11:
                            Parcel[] parcelArrO = A1.b.o(parcel, iD);
                            int length = parcelArrO.length;
                            for (int i5 = 0; i5 < length; i5++) {
                                if (i5 > 0) {
                                    sb.append(com.amazon.a.a.o.b.f.f8804a);
                                }
                                parcelArrO[i5].setDataPosition(0);
                                f(sb, c0016a.v(), parcelArrO[i5]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    sb.append("]");
                } else {
                    switch (c0016a.f384d) {
                        case 0:
                            sb.append(A1.b.F(parcel, iD));
                            break;
                        case 1:
                            sb.append(A1.b.c(parcel, iD));
                            break;
                        case 2:
                            sb.append(A1.b.H(parcel, iD));
                            break;
                        case 3:
                            sb.append(A1.b.B(parcel, iD));
                            break;
                        case 4:
                            sb.append(A1.b.z(parcel, iD));
                            break;
                        case 5:
                            sb.append(A1.b.a(parcel, iD));
                            break;
                        case 6:
                            sb.append(A1.b.x(parcel, iD));
                            break;
                        case 7:
                            String strQ = A1.b.q(parcel, iD);
                            sb.append("\"");
                            sb.append(G1.k.a(strQ));
                            sb.append("\"");
                            break;
                        case 8:
                            byte[] bArrG = A1.b.g(parcel, iD);
                            sb.append("\"");
                            sb.append(G1.c.c(bArrG));
                            sb.append("\"");
                            break;
                        case 9:
                            byte[] bArrG2 = A1.b.g(parcel, iD);
                            sb.append("\"");
                            sb.append(G1.c.d(bArrG2));
                            sb.append("\"");
                            break;
                        case 10:
                            Bundle bundleF2 = A1.b.f(parcel, iD);
                            Set<String> setKeySet = bundleF2.keySet();
                            sb.append("{");
                            boolean z5 = true;
                            for (String str3 : setKeySet) {
                                if (!z5) {
                                    sb.append(com.amazon.a.a.o.b.f.f8804a);
                                }
                                sb.append("\"");
                                sb.append(str3);
                                sb.append("\":\"");
                                sb.append(G1.k.a(bundleF2.getString(str3)));
                                sb.append("\"");
                                z5 = false;
                            }
                            sb.append("}");
                            break;
                        case 11:
                            Parcel parcelN = A1.b.n(parcel, iD);
                            parcelN.setDataPosition(0);
                            f(sb, c0016a.v(), parcelN);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                z4 = true;
            }
        }
        if (parcel.dataPosition() == iM) {
            sb.append('}');
            return;
        }
        throw new b.a("Overread allowed size end=" + iM, parcel);
    }

    @Override // E1.a
    public final Map getFieldMappings() {
        h hVar = this.f395d;
        if (hVar == null) {
            return null;
        }
        return hVar.k((String) AbstractC0940s.k(this.f396e));
    }

    @Override // E1.b, E1.a
    public final Object getValueObject(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // E1.b, E1.a
    public final boolean isPrimitiveFieldSet(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // E1.a
    public final void setBooleanInternal(a.C0016a c0016a, String str, boolean z4) {
        e(c0016a);
        A1.c.g(this.f393b, c0016a.p(), z4);
    }

    @Override // E1.a
    public final void setDecodedBytesInternal(a.C0016a c0016a, String str, byte[] bArr) {
        e(c0016a);
        A1.c.k(this.f393b, c0016a.p(), bArr, true);
    }

    @Override // E1.a
    public final void setIntegerInternal(a.C0016a c0016a, String str, int i4) {
        e(c0016a);
        A1.c.t(this.f393b, c0016a.p(), i4);
    }

    @Override // E1.a
    public final void setLongInternal(a.C0016a c0016a, String str, long j4) {
        e(c0016a);
        A1.c.x(this.f393b, c0016a.p(), j4);
    }

    @Override // E1.a
    public final void setStringInternal(a.C0016a c0016a, String str, String str2) {
        e(c0016a);
        A1.c.E(this.f393b, c0016a.p(), str2, true);
    }

    @Override // E1.a
    public final void setStringMapInternal(a.C0016a c0016a, String str, Map map) {
        e(c0016a);
        Bundle bundle = new Bundle();
        for (String str2 : ((Map) AbstractC0940s.k(map)).keySet()) {
            bundle.putString(str2, (String) map.get(str2));
        }
        A1.c.j(this.f393b, c0016a.p(), bundle, true);
    }

    @Override // E1.a
    public final void setStringsInternal(a.C0016a c0016a, String str, ArrayList arrayList) {
        e(c0016a);
        int size = ((ArrayList) AbstractC0940s.k(arrayList)).size();
        String[] strArr = new String[size];
        for (int i4 = 0; i4 < size; i4++) {
            strArr[i4] = (String) arrayList.get(i4);
        }
        A1.c.F(this.f393b, c0016a.p(), strArr, true);
    }

    @Override // E1.a
    public final String toString() {
        AbstractC0940s.l(this.f395d, "Cannot convert to JSON on client side.");
        Parcel parcelD = d();
        parcelD.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        f(sb, (Map) AbstractC0940s.k(this.f395d.k((String) AbstractC0940s.k(this.f396e))), parcelD);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int i5 = this.f392a;
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, i5);
        A1.c.A(parcel, 2, d(), false);
        int i6 = this.f394c;
        A1.c.C(parcel, 3, i6 != 0 ? i6 != 1 ? this.f395d : this.f395d : null, i4, false);
        A1.c.b(parcel, iA);
    }

    @Override // E1.a
    public final void zab(a.C0016a c0016a, String str, BigDecimal bigDecimal) {
        e(c0016a);
        A1.c.c(this.f393b, c0016a.p(), bigDecimal, true);
    }

    @Override // E1.a
    public final void zad(a.C0016a c0016a, String str, ArrayList arrayList) {
        e(c0016a);
        int size = ((ArrayList) AbstractC0940s.k(arrayList)).size();
        BigDecimal[] bigDecimalArr = new BigDecimal[size];
        for (int i4 = 0; i4 < size; i4++) {
            bigDecimalArr[i4] = (BigDecimal) arrayList.get(i4);
        }
        A1.c.d(this.f393b, c0016a.p(), bigDecimalArr, true);
    }

    @Override // E1.a
    public final void zaf(a.C0016a c0016a, String str, BigInteger bigInteger) {
        e(c0016a);
        A1.c.e(this.f393b, c0016a.p(), bigInteger, true);
    }

    @Override // E1.a
    public final void zah(a.C0016a c0016a, String str, ArrayList arrayList) {
        e(c0016a);
        int size = ((ArrayList) AbstractC0940s.k(arrayList)).size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i4 = 0; i4 < size; i4++) {
            bigIntegerArr[i4] = (BigInteger) arrayList.get(i4);
        }
        A1.c.f(this.f393b, c0016a.p(), bigIntegerArr, true);
    }

    @Override // E1.a
    public final void zak(a.C0016a c0016a, String str, ArrayList arrayList) {
        e(c0016a);
        int size = ((ArrayList) AbstractC0940s.k(arrayList)).size();
        boolean[] zArr = new boolean[size];
        for (int i4 = 0; i4 < size; i4++) {
            zArr[i4] = ((Boolean) arrayList.get(i4)).booleanValue();
        }
        A1.c.h(this.f393b, c0016a.p(), zArr, true);
    }

    @Override // E1.a
    public final void zan(a.C0016a c0016a, String str, double d4) {
        e(c0016a);
        A1.c.m(this.f393b, c0016a.p(), d4);
    }

    @Override // E1.a
    public final void zap(a.C0016a c0016a, String str, ArrayList arrayList) {
        e(c0016a);
        int size = ((ArrayList) AbstractC0940s.k(arrayList)).size();
        double[] dArr = new double[size];
        for (int i4 = 0; i4 < size; i4++) {
            dArr[i4] = ((Double) arrayList.get(i4)).doubleValue();
        }
        A1.c.n(this.f393b, c0016a.p(), dArr, true);
    }

    @Override // E1.a
    public final void zar(a.C0016a c0016a, String str, float f4) {
        e(c0016a);
        A1.c.p(this.f393b, c0016a.p(), f4);
    }

    @Override // E1.a
    public final void zat(a.C0016a c0016a, String str, ArrayList arrayList) {
        e(c0016a);
        int size = ((ArrayList) AbstractC0940s.k(arrayList)).size();
        float[] fArr = new float[size];
        for (int i4 = 0; i4 < size; i4++) {
            fArr[i4] = ((Float) arrayList.get(i4)).floatValue();
        }
        A1.c.q(this.f393b, c0016a.p(), fArr, true);
    }

    @Override // E1.a
    public final void zaw(a.C0016a c0016a, String str, ArrayList arrayList) {
        e(c0016a);
        int size = ((ArrayList) AbstractC0940s.k(arrayList)).size();
        int[] iArr = new int[size];
        for (int i4 = 0; i4 < size; i4++) {
            iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
        }
        A1.c.u(this.f393b, c0016a.p(), iArr, true);
    }

    @Override // E1.a
    public final void zaz(a.C0016a c0016a, String str, ArrayList arrayList) {
        e(c0016a);
        int size = ((ArrayList) AbstractC0940s.k(arrayList)).size();
        long[] jArr = new long[size];
        for (int i4 = 0; i4 < size; i4++) {
            jArr[i4] = ((Long) arrayList.get(i4)).longValue();
        }
        A1.c.y(this.f393b, c0016a.p(), jArr, true);
    }
}
