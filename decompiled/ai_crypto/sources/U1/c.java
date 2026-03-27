package U1;

import Q1.b;
import U1.a;
import W1.l;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public class c extends b {
    public static final Parcelable.Creator<c> CREATOR = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Parcel f4772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4773c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f4774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f4775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4777g;

    public c(int i7, Parcel parcel, h hVar) {
        this.f4771a = i7;
        this.f4772b = (Parcel) AbstractC1207s.k(parcel);
        this.f4774d = hVar;
        this.f4775e = hVar == null ? null : hVar.A();
        this.f4776f = 2;
    }

    public static final void h(StringBuilder sb, int i7, Object obj) {
        switch (i7) {
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
                sb.append(W1.k.a(AbstractC1207s.k(obj).toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                sb.append(W1.c.c((byte[]) obj));
                sb.append("\"");
                return;
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                sb.append("\"");
                sb.append(W1.c.d((byte[]) obj));
                sb.append("\"");
                return;
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                l.a(sb, (HashMap) AbstractC1207s.k(obj));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i7);
        }
    }

    public static final void i(StringBuilder sb, a.C0083a c0083a, Object obj) {
        if (!c0083a.f4762c) {
            h(sb, c0083a.f4761b, obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        sb.append("[");
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            if (i7 != 0) {
                sb.append(com.amazon.a.a.o.b.f.f9989a);
            }
            h(sb, c0083a.f4761b, arrayList.get(i7));
        }
        sb.append("]");
    }

    @Override // U1.a
    public final void addConcreteTypeArrayInternal(a.C0083a c0083a, String str, ArrayList arrayList) {
        f(c0083a);
        ArrayList arrayList2 = new ArrayList();
        ((ArrayList) AbstractC1207s.k(arrayList)).size();
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            arrayList2.add(((c) ((a) arrayList.get(i7))).e());
        }
        Q1.c.B(this.f4772b, c0083a.G(), arrayList2, true);
    }

    @Override // U1.a
    public final void addConcreteTypeInternal(a.C0083a c0083a, String str, a aVar) {
        f(c0083a);
        Q1.c.A(this.f4772b, c0083a.G(), ((c) aVar).e(), true);
    }

    public final Parcel e() {
        int i7 = this.f4776f;
        if (i7 == 0) {
            int iA = Q1.c.a(this.f4772b);
            this.f4777g = iA;
            Q1.c.b(this.f4772b, iA);
            this.f4776f = 2;
        } else if (i7 == 1) {
            Q1.c.b(this.f4772b, this.f4777g);
            this.f4776f = 2;
        }
        return this.f4772b;
    }

    public final void f(a.C0083a c0083a) {
        if (c0083a.f4766g == -1) {
            throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
        }
        Parcel parcel = this.f4772b;
        if (parcel == null) {
            throw new IllegalStateException("Internal Parcel object is null.");
        }
        int i7 = this.f4776f;
        if (i7 != 0) {
            if (i7 != 1) {
                throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
            }
        } else {
            this.f4777g = Q1.c.a(parcel);
            this.f4776f = 1;
        }
    }

    public final void g(StringBuilder sb, Map map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry entry : map.entrySet()) {
            sparseArray.put(((a.C0083a) entry.getValue()).G(), entry);
        }
        sb.append('{');
        int iM = Q1.b.M(parcel);
        boolean z7 = false;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            Map.Entry entry2 = (Map.Entry) sparseArray.get(Q1.b.w(iD));
            if (entry2 != null) {
                if (z7) {
                    sb.append(com.amazon.a.a.o.b.f.f9989a);
                }
                String str = (String) entry2.getKey();
                a.C0083a c0083a = (a.C0083a) entry2.getValue();
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (c0083a.O()) {
                    int i7 = c0083a.f4763d;
                    switch (i7) {
                        case 0:
                            i(sb, c0083a, a.zaD(c0083a, Integer.valueOf(Q1.b.F(parcel, iD))));
                            break;
                        case 1:
                            i(sb, c0083a, a.zaD(c0083a, Q1.b.c(parcel, iD)));
                            break;
                        case 2:
                            i(sb, c0083a, a.zaD(c0083a, Long.valueOf(Q1.b.H(parcel, iD))));
                            break;
                        case 3:
                            i(sb, c0083a, a.zaD(c0083a, Float.valueOf(Q1.b.B(parcel, iD))));
                            break;
                        case 4:
                            i(sb, c0083a, a.zaD(c0083a, Double.valueOf(Q1.b.z(parcel, iD))));
                            break;
                        case 5:
                            i(sb, c0083a, a.zaD(c0083a, Q1.b.a(parcel, iD)));
                            break;
                        case 6:
                            i(sb, c0083a, a.zaD(c0083a, Boolean.valueOf(Q1.b.x(parcel, iD))));
                            break;
                        case 7:
                            i(sb, c0083a, a.zaD(c0083a, Q1.b.q(parcel, iD)));
                            break;
                        case 8:
                        case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            i(sb, c0083a, a.zaD(c0083a, Q1.b.g(parcel, iD)));
                            break;
                        case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            Bundle bundleF = Q1.b.f(parcel, iD);
                            HashMap map2 = new HashMap();
                            for (String str2 : bundleF.keySet()) {
                                map2.put(str2, (String) AbstractC1207s.k(bundleF.getString(str2)));
                            }
                            i(sb, c0083a, a.zaD(c0083a, map2));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            throw new IllegalArgumentException("Unknown field out type = " + i7);
                    }
                } else if (c0083a.f4764e) {
                    sb.append("[");
                    switch (c0083a.f4763d) {
                        case 0:
                            W1.b.e(sb, Q1.b.k(parcel, iD));
                            break;
                        case 1:
                            W1.b.g(sb, Q1.b.d(parcel, iD));
                            break;
                        case 2:
                            W1.b.f(sb, Q1.b.m(parcel, iD));
                            break;
                        case 3:
                            W1.b.d(sb, Q1.b.j(parcel, iD));
                            break;
                        case 4:
                            W1.b.c(sb, Q1.b.i(parcel, iD));
                            break;
                        case 5:
                            W1.b.g(sb, Q1.b.b(parcel, iD));
                            break;
                        case 6:
                            W1.b.h(sb, Q1.b.e(parcel, iD));
                            break;
                        case 7:
                            W1.b.i(sb, Q1.b.r(parcel, iD));
                            break;
                        case 8:
                        case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                        case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case 11:
                            Parcel[] parcelArrO = Q1.b.o(parcel, iD);
                            int length = parcelArrO.length;
                            for (int i8 = 0; i8 < length; i8++) {
                                if (i8 > 0) {
                                    sb.append(com.amazon.a.a.o.b.f.f9989a);
                                }
                                parcelArrO[i8].setDataPosition(0);
                                g(sb, c0083a.M(), parcelArrO[i8]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    sb.append("]");
                } else {
                    switch (c0083a.f4763d) {
                        case 0:
                            sb.append(Q1.b.F(parcel, iD));
                            break;
                        case 1:
                            sb.append(Q1.b.c(parcel, iD));
                            break;
                        case 2:
                            sb.append(Q1.b.H(parcel, iD));
                            break;
                        case 3:
                            sb.append(Q1.b.B(parcel, iD));
                            break;
                        case 4:
                            sb.append(Q1.b.z(parcel, iD));
                            break;
                        case 5:
                            sb.append(Q1.b.a(parcel, iD));
                            break;
                        case 6:
                            sb.append(Q1.b.x(parcel, iD));
                            break;
                        case 7:
                            String strQ = Q1.b.q(parcel, iD);
                            sb.append("\"");
                            sb.append(W1.k.a(strQ));
                            sb.append("\"");
                            break;
                        case 8:
                            byte[] bArrG = Q1.b.g(parcel, iD);
                            sb.append("\"");
                            sb.append(W1.c.c(bArrG));
                            sb.append("\"");
                            break;
                        case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            byte[] bArrG2 = Q1.b.g(parcel, iD);
                            sb.append("\"");
                            sb.append(W1.c.d(bArrG2));
                            sb.append("\"");
                            break;
                        case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            Bundle bundleF2 = Q1.b.f(parcel, iD);
                            Set<String> setKeySet = bundleF2.keySet();
                            sb.append("{");
                            boolean z8 = true;
                            for (String str3 : setKeySet) {
                                if (!z8) {
                                    sb.append(com.amazon.a.a.o.b.f.f9989a);
                                }
                                sb.append("\"");
                                sb.append(str3);
                                sb.append("\":\"");
                                sb.append(W1.k.a(bundleF2.getString(str3)));
                                sb.append("\"");
                                z8 = false;
                            }
                            sb.append("}");
                            break;
                        case 11:
                            Parcel parcelN = Q1.b.n(parcel, iD);
                            parcelN.setDataPosition(0);
                            g(sb, c0083a.M(), parcelN);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                z7 = true;
            }
        }
        if (parcel.dataPosition() == iM) {
            sb.append('}');
            return;
        }
        throw new b.a("Overread allowed size end=" + iM, parcel);
    }

    @Override // U1.a
    public final Map getFieldMappings() {
        h hVar = this.f4774d;
        if (hVar == null) {
            return null;
        }
        return hVar.B((String) AbstractC1207s.k(this.f4775e));
    }

    @Override // U1.b, U1.a
    public final Object getValueObject(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // U1.b, U1.a
    public final boolean isPrimitiveFieldSet(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // U1.a
    public final void setBooleanInternal(a.C0083a c0083a, String str, boolean z7) {
        f(c0083a);
        Q1.c.g(this.f4772b, c0083a.G(), z7);
    }

    @Override // U1.a
    public final void setDecodedBytesInternal(a.C0083a c0083a, String str, byte[] bArr) {
        f(c0083a);
        Q1.c.k(this.f4772b, c0083a.G(), bArr, true);
    }

    @Override // U1.a
    public final void setIntegerInternal(a.C0083a c0083a, String str, int i7) {
        f(c0083a);
        Q1.c.t(this.f4772b, c0083a.G(), i7);
    }

    @Override // U1.a
    public final void setLongInternal(a.C0083a c0083a, String str, long j7) {
        f(c0083a);
        Q1.c.x(this.f4772b, c0083a.G(), j7);
    }

    @Override // U1.a
    public final void setStringInternal(a.C0083a c0083a, String str, String str2) {
        f(c0083a);
        Q1.c.E(this.f4772b, c0083a.G(), str2, true);
    }

    @Override // U1.a
    public final void setStringMapInternal(a.C0083a c0083a, String str, Map map) {
        f(c0083a);
        Bundle bundle = new Bundle();
        for (String str2 : ((Map) AbstractC1207s.k(map)).keySet()) {
            bundle.putString(str2, (String) map.get(str2));
        }
        Q1.c.j(this.f4772b, c0083a.G(), bundle, true);
    }

    @Override // U1.a
    public final void setStringsInternal(a.C0083a c0083a, String str, ArrayList arrayList) {
        f(c0083a);
        int size = ((ArrayList) AbstractC1207s.k(arrayList)).size();
        String[] strArr = new String[size];
        for (int i7 = 0; i7 < size; i7++) {
            strArr[i7] = (String) arrayList.get(i7);
        }
        Q1.c.F(this.f4772b, c0083a.G(), strArr, true);
    }

    @Override // U1.a
    public final String toString() {
        AbstractC1207s.l(this.f4774d, "Cannot convert to JSON on client side.");
        Parcel parcelE = e();
        parcelE.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        g(sb, (Map) AbstractC1207s.k(this.f4774d.B((String) AbstractC1207s.k(this.f4775e))), parcelE);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int i8 = this.f4771a;
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, i8);
        Q1.c.A(parcel, 2, e(), false);
        int i9 = this.f4773c;
        Q1.c.C(parcel, 3, i9 != 0 ? i9 != 1 ? this.f4774d : this.f4774d : null, i7, false);
        Q1.c.b(parcel, iA);
    }

    @Override // U1.a
    public final void zab(a.C0083a c0083a, String str, BigDecimal bigDecimal) {
        f(c0083a);
        Q1.c.c(this.f4772b, c0083a.G(), bigDecimal, true);
    }

    @Override // U1.a
    public final void zad(a.C0083a c0083a, String str, ArrayList arrayList) {
        f(c0083a);
        int size = ((ArrayList) AbstractC1207s.k(arrayList)).size();
        BigDecimal[] bigDecimalArr = new BigDecimal[size];
        for (int i7 = 0; i7 < size; i7++) {
            bigDecimalArr[i7] = (BigDecimal) arrayList.get(i7);
        }
        Q1.c.d(this.f4772b, c0083a.G(), bigDecimalArr, true);
    }

    @Override // U1.a
    public final void zaf(a.C0083a c0083a, String str, BigInteger bigInteger) {
        f(c0083a);
        Q1.c.e(this.f4772b, c0083a.G(), bigInteger, true);
    }

    @Override // U1.a
    public final void zah(a.C0083a c0083a, String str, ArrayList arrayList) {
        f(c0083a);
        int size = ((ArrayList) AbstractC1207s.k(arrayList)).size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i7 = 0; i7 < size; i7++) {
            bigIntegerArr[i7] = (BigInteger) arrayList.get(i7);
        }
        Q1.c.f(this.f4772b, c0083a.G(), bigIntegerArr, true);
    }

    @Override // U1.a
    public final void zak(a.C0083a c0083a, String str, ArrayList arrayList) {
        f(c0083a);
        int size = ((ArrayList) AbstractC1207s.k(arrayList)).size();
        boolean[] zArr = new boolean[size];
        for (int i7 = 0; i7 < size; i7++) {
            zArr[i7] = ((Boolean) arrayList.get(i7)).booleanValue();
        }
        Q1.c.h(this.f4772b, c0083a.G(), zArr, true);
    }

    @Override // U1.a
    public final void zan(a.C0083a c0083a, String str, double d7) {
        f(c0083a);
        Q1.c.m(this.f4772b, c0083a.G(), d7);
    }

    @Override // U1.a
    public final void zap(a.C0083a c0083a, String str, ArrayList arrayList) {
        f(c0083a);
        int size = ((ArrayList) AbstractC1207s.k(arrayList)).size();
        double[] dArr = new double[size];
        for (int i7 = 0; i7 < size; i7++) {
            dArr[i7] = ((Double) arrayList.get(i7)).doubleValue();
        }
        Q1.c.n(this.f4772b, c0083a.G(), dArr, true);
    }

    @Override // U1.a
    public final void zar(a.C0083a c0083a, String str, float f7) {
        f(c0083a);
        Q1.c.p(this.f4772b, c0083a.G(), f7);
    }

    @Override // U1.a
    public final void zat(a.C0083a c0083a, String str, ArrayList arrayList) {
        f(c0083a);
        int size = ((ArrayList) AbstractC1207s.k(arrayList)).size();
        float[] fArr = new float[size];
        for (int i7 = 0; i7 < size; i7++) {
            fArr[i7] = ((Float) arrayList.get(i7)).floatValue();
        }
        Q1.c.q(this.f4772b, c0083a.G(), fArr, true);
    }

    @Override // U1.a
    public final void zaw(a.C0083a c0083a, String str, ArrayList arrayList) {
        f(c0083a);
        int size = ((ArrayList) AbstractC1207s.k(arrayList)).size();
        int[] iArr = new int[size];
        for (int i7 = 0; i7 < size; i7++) {
            iArr[i7] = ((Integer) arrayList.get(i7)).intValue();
        }
        Q1.c.u(this.f4772b, c0083a.G(), iArr, true);
    }

    @Override // U1.a
    public final void zaz(a.C0083a c0083a, String str, ArrayList arrayList) {
        f(c0083a);
        int size = ((ArrayList) AbstractC1207s.k(arrayList)).size();
        long[] jArr = new long[size];
        for (int i7 = 0; i7 < size; i7++) {
            jArr[i7] = ((Long) arrayList.get(i7)).longValue();
        }
        Q1.c.y(this.f4772b, c0083a.G(), jArr, true);
    }
}
