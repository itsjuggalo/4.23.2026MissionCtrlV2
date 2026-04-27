package U1;

import W1.l;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    public interface b {
        Object j(Object obj);

        Object m(Object obj);
    }

    public static final void c(StringBuilder sb, C0083a c0083a, Object obj) {
        int i7 = c0083a.f4761b;
        if (i7 == 11) {
            Class cls = c0083a.f4767h;
            AbstractC1207s.k(cls);
            sb.append(((a) cls.cast(obj)).toString());
        } else {
            if (i7 != 7) {
                sb.append(obj);
                return;
            }
            sb.append("\"");
            sb.append(W1.k.a((String) obj));
            sb.append("\"");
        }
    }

    public static final void d(String str) {
        if (Log.isLoggable("FastJsonResponse", 6)) {
            Log.e("FastJsonResponse", "Output field (" + str + ") has a null value, but expected a primitive");
        }
    }

    public static final Object zaD(C0083a c0083a, Object obj) {
        return c0083a.f4770k != null ? c0083a.K(obj) : obj;
    }

    public final void a(C0083a c0083a, Object obj) {
        int i7 = c0083a.f4763d;
        Object objJ = c0083a.J(obj);
        String str = c0083a.f4765f;
        switch (i7) {
            case 0:
                if (objJ != null) {
                    setIntegerInternal(c0083a, str, ((Integer) objJ).intValue());
                    return;
                } else {
                    d(str);
                    return;
                }
            case 1:
                zaf(c0083a, str, (BigInteger) objJ);
                return;
            case 2:
                if (objJ != null) {
                    setLongInternal(c0083a, str, ((Long) objJ).longValue());
                    return;
                } else {
                    d(str);
                    return;
                }
            case 3:
            default:
                throw new IllegalStateException("Unsupported type for conversion: " + i7);
            case 4:
                if (objJ != null) {
                    zan(c0083a, str, ((Double) objJ).doubleValue());
                    return;
                } else {
                    d(str);
                    return;
                }
            case 5:
                zab(c0083a, str, (BigDecimal) objJ);
                return;
            case 6:
                if (objJ != null) {
                    setBooleanInternal(c0083a, str, ((Boolean) objJ).booleanValue());
                    return;
                } else {
                    d(str);
                    return;
                }
            case 7:
                setStringInternal(c0083a, str, (String) objJ);
                return;
            case 8:
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                if (objJ != null) {
                    setDecodedBytesInternal(c0083a, str, (byte[]) objJ);
                    return;
                } else {
                    d(str);
                    return;
                }
        }
    }

    public <T extends a> void addConcreteTypeArrayInternal(C0083a c0083a, String str, ArrayList<T> arrayList) {
        throw new UnsupportedOperationException("Concrete type array not supported");
    }

    public <T extends a> void addConcreteTypeInternal(C0083a c0083a, String str, T t7) {
        throw new UnsupportedOperationException("Concrete type not supported");
    }

    public abstract Map<String, C0083a> getFieldMappings();

    public Object getFieldValue(C0083a c0083a) {
        String str = c0083a.f4765f;
        if (c0083a.f4767h == null) {
            return getValueObject(str);
        }
        AbstractC1207s.p(getValueObject(str) == null, "Concrete field shouldn't be value object: %s", c0083a.f4765f);
        try {
            return getClass().getMethod(com.amazon.a.a.o.b.au + Character.toUpperCase(str.charAt(0)) + str.substring(1), null).invoke(this, null);
        } catch (Exception e7) {
            throw new RuntimeException(e7);
        }
    }

    public abstract Object getValueObject(String str);

    public boolean isFieldSet(C0083a c0083a) {
        if (c0083a.f4763d != 11) {
            return isPrimitiveFieldSet(c0083a.f4765f);
        }
        if (c0083a.f4764e) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    public abstract boolean isPrimitiveFieldSet(String str);

    public void setBooleanInternal(C0083a c0083a, String str, boolean z7) {
        throw new UnsupportedOperationException("Boolean not supported");
    }

    public void setDecodedBytesInternal(C0083a c0083a, String str, byte[] bArr) {
        throw new UnsupportedOperationException("byte[] not supported");
    }

    public void setIntegerInternal(C0083a c0083a, String str, int i7) {
        throw new UnsupportedOperationException("Integer not supported");
    }

    public void setLongInternal(C0083a c0083a, String str, long j7) {
        throw new UnsupportedOperationException("Long not supported");
    }

    public void setStringInternal(C0083a c0083a, String str, String str2) {
        throw new UnsupportedOperationException("String not supported");
    }

    public void setStringMapInternal(C0083a c0083a, String str, Map<String, String> map) {
        throw new UnsupportedOperationException("String map not supported");
    }

    public void setStringsInternal(C0083a c0083a, String str, ArrayList<String> arrayList) {
        throw new UnsupportedOperationException("String list not supported");
    }

    public String toString() {
        Map<String, C0083a> fieldMappings = getFieldMappings();
        StringBuilder sb = new StringBuilder(100);
        for (String str : fieldMappings.keySet()) {
            C0083a c0083a = fieldMappings.get(str);
            if (isFieldSet(c0083a)) {
                Object objZaD = zaD(c0083a, getFieldValue(c0083a));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(com.amazon.a.a.o.b.f.f9989a);
                }
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (objZaD != null) {
                    switch (c0083a.f4763d) {
                        case 8:
                            sb.append("\"");
                            sb.append(W1.c.c((byte[]) objZaD));
                            sb.append("\"");
                            break;
                        case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            sb.append("\"");
                            sb.append(W1.c.d((byte[]) objZaD));
                            sb.append("\"");
                            break;
                        case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            l.a(sb, (HashMap) objZaD);
                            break;
                        default:
                            if (c0083a.f4762c) {
                                ArrayList arrayList = (ArrayList) objZaD;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i7 = 0; i7 < size; i7++) {
                                    if (i7 > 0) {
                                        sb.append(com.amazon.a.a.o.b.f.f9989a);
                                    }
                                    Object obj = arrayList.get(i7);
                                    if (obj != null) {
                                        c(sb, c0083a, obj);
                                    }
                                }
                                sb.append("]");
                            } else {
                                c(sb, c0083a, objZaD);
                            }
                            break;
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }

    public final void zaA(C0083a c0083a, String str) {
        if (c0083a.f4770k != null) {
            a(c0083a, str);
        } else {
            setStringInternal(c0083a, c0083a.f4765f, str);
        }
    }

    public final void zaB(C0083a c0083a, Map map) {
        if (c0083a.f4770k != null) {
            a(c0083a, map);
        } else {
            setStringMapInternal(c0083a, c0083a.f4765f, map);
        }
    }

    public final void zaC(C0083a c0083a, ArrayList arrayList) {
        if (c0083a.f4770k != null) {
            a(c0083a, arrayList);
        } else {
            setStringsInternal(c0083a, c0083a.f4765f, arrayList);
        }
    }

    public final void zaa(C0083a c0083a, BigDecimal bigDecimal) {
        if (c0083a.f4770k != null) {
            a(c0083a, bigDecimal);
        } else {
            zab(c0083a, c0083a.f4765f, bigDecimal);
        }
    }

    public void zab(C0083a c0083a, String str, BigDecimal bigDecimal) {
        throw new UnsupportedOperationException("BigDecimal not supported");
    }

    public final void zac(C0083a c0083a, ArrayList arrayList) {
        if (c0083a.f4770k != null) {
            a(c0083a, arrayList);
        } else {
            zad(c0083a, c0083a.f4765f, arrayList);
        }
    }

    public void zad(C0083a c0083a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("BigDecimal list not supported");
    }

    public final void zae(C0083a c0083a, BigInteger bigInteger) {
        if (c0083a.f4770k != null) {
            a(c0083a, bigInteger);
        } else {
            zaf(c0083a, c0083a.f4765f, bigInteger);
        }
    }

    public void zaf(C0083a c0083a, String str, BigInteger bigInteger) {
        throw new UnsupportedOperationException("BigInteger not supported");
    }

    public final void zag(C0083a c0083a, ArrayList arrayList) {
        if (c0083a.f4770k != null) {
            a(c0083a, arrayList);
        } else {
            zah(c0083a, c0083a.f4765f, arrayList);
        }
    }

    public void zah(C0083a c0083a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("BigInteger list not supported");
    }

    public final void zai(C0083a c0083a, boolean z7) {
        if (c0083a.f4770k != null) {
            a(c0083a, Boolean.valueOf(z7));
        } else {
            setBooleanInternal(c0083a, c0083a.f4765f, z7);
        }
    }

    public final void zaj(C0083a c0083a, ArrayList arrayList) {
        if (c0083a.f4770k != null) {
            a(c0083a, arrayList);
        } else {
            zak(c0083a, c0083a.f4765f, arrayList);
        }
    }

    public void zak(C0083a c0083a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Boolean list not supported");
    }

    public final void zal(C0083a c0083a, byte[] bArr) {
        if (c0083a.f4770k != null) {
            a(c0083a, bArr);
        } else {
            setDecodedBytesInternal(c0083a, c0083a.f4765f, bArr);
        }
    }

    public final void zam(C0083a c0083a, double d7) {
        if (c0083a.f4770k != null) {
            a(c0083a, Double.valueOf(d7));
        } else {
            zan(c0083a, c0083a.f4765f, d7);
        }
    }

    public void zan(C0083a c0083a, String str, double d7) {
        throw new UnsupportedOperationException("Double not supported");
    }

    public final void zao(C0083a c0083a, ArrayList arrayList) {
        if (c0083a.f4770k != null) {
            a(c0083a, arrayList);
        } else {
            zap(c0083a, c0083a.f4765f, arrayList);
        }
    }

    public void zap(C0083a c0083a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Double list not supported");
    }

    public final void zaq(C0083a c0083a, float f7) {
        if (c0083a.f4770k != null) {
            a(c0083a, Float.valueOf(f7));
        } else {
            zar(c0083a, c0083a.f4765f, f7);
        }
    }

    public void zar(C0083a c0083a, String str, float f7) {
        throw new UnsupportedOperationException("Float not supported");
    }

    public final void zas(C0083a c0083a, ArrayList arrayList) {
        if (c0083a.f4770k != null) {
            a(c0083a, arrayList);
        } else {
            zat(c0083a, c0083a.f4765f, arrayList);
        }
    }

    public void zat(C0083a c0083a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Float list not supported");
    }

    public final void zau(C0083a c0083a, int i7) {
        if (c0083a.f4770k != null) {
            a(c0083a, Integer.valueOf(i7));
        } else {
            setIntegerInternal(c0083a, c0083a.f4765f, i7);
        }
    }

    public final void zav(C0083a c0083a, ArrayList arrayList) {
        if (c0083a.f4770k != null) {
            a(c0083a, arrayList);
        } else {
            zaw(c0083a, c0083a.f4765f, arrayList);
        }
    }

    public void zaw(C0083a c0083a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Integer list not supported");
    }

    public final void zax(C0083a c0083a, long j7) {
        if (c0083a.f4770k != null) {
            a(c0083a, Long.valueOf(j7));
        } else {
            setLongInternal(c0083a, c0083a.f4765f, j7);
        }
    }

    public final void zay(C0083a c0083a, ArrayList arrayList) {
        if (c0083a.f4770k != null) {
            a(c0083a, arrayList);
        } else {
            zaz(c0083a, c0083a.f4765f, arrayList);
        }
    }

    public void zaz(C0083a c0083a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Long list not supported");
    }

    /* JADX INFO: renamed from: U1.a$a, reason: collision with other inner class name */
    public static class C0083a extends Q1.a {
        public static final d CREATOR = new d();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f4760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f4761b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f4762c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f4763d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f4764e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f4765f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f4766g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Class f4767h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f4768i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public h f4769j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final b f4770k;

        public C0083a(int i7, int i8, boolean z7, int i9, boolean z8, String str, int i10, String str2, T1.b bVar) {
            this.f4760a = i7;
            this.f4761b = i8;
            this.f4762c = z7;
            this.f4763d = i9;
            this.f4764e = z8;
            this.f4765f = str;
            this.f4766g = i10;
            if (str2 == null) {
                this.f4767h = null;
                this.f4768i = null;
            } else {
                this.f4767h = c.class;
                this.f4768i = str2;
            }
            if (bVar == null) {
                this.f4770k = null;
            } else {
                this.f4770k = bVar.B();
            }
        }

        public static C0083a A(String str, int i7) {
            return new C0083a(8, false, 8, false, str, i7, null, null);
        }

        public static C0083a B(String str, int i7, Class cls) {
            return new C0083a(11, false, 11, false, str, i7, cls, null);
        }

        public static C0083a C(String str, int i7, Class cls) {
            return new C0083a(11, true, 11, true, str, i7, cls, null);
        }

        public static C0083a D(String str, int i7) {
            return new C0083a(0, false, 0, false, str, i7, null, null);
        }

        public static C0083a E(String str, int i7) {
            return new C0083a(7, false, 7, false, str, i7, null, null);
        }

        public static C0083a F(String str, int i7) {
            return new C0083a(7, true, 7, true, str, i7, null, null);
        }

        public int G() {
            return this.f4766g;
        }

        public final T1.b H() {
            b bVar = this.f4770k;
            if (bVar == null) {
                return null;
            }
            return T1.b.A(bVar);
        }

        public final Object J(Object obj) {
            AbstractC1207s.k(this.f4770k);
            return AbstractC1207s.k(this.f4770k.m(obj));
        }

        public final Object K(Object obj) {
            AbstractC1207s.k(this.f4770k);
            return this.f4770k.j(obj);
        }

        public final String L() {
            String str = this.f4768i;
            if (str == null) {
                return null;
            }
            return str;
        }

        public final Map M() {
            AbstractC1207s.k(this.f4768i);
            AbstractC1207s.k(this.f4769j);
            return (Map) AbstractC1207s.k(this.f4769j.B(this.f4768i));
        }

        public final void N(h hVar) {
            this.f4769j = hVar;
        }

        public final boolean O() {
            return this.f4770k != null;
        }

        public final String toString() {
            AbstractC1206q.a aVarA = AbstractC1206q.d(this).a("versionCode", Integer.valueOf(this.f4760a)).a("typeIn", Integer.valueOf(this.f4761b)).a("typeInArray", Boolean.valueOf(this.f4762c)).a("typeOut", Integer.valueOf(this.f4763d)).a("typeOutArray", Boolean.valueOf(this.f4764e)).a("outputFieldName", this.f4765f).a("safeParcelFieldId", Integer.valueOf(this.f4766g)).a("concreteTypeName", L());
            Class cls = this.f4767h;
            if (cls != null) {
                aVarA.a("concreteType.class", cls.getCanonicalName());
            }
            b bVar = this.f4770k;
            if (bVar != null) {
                aVarA.a("converterName", bVar.getClass().getCanonicalName());
            }
            return aVarA.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i7) {
            int i8 = this.f4760a;
            int iA = Q1.c.a(parcel);
            Q1.c.t(parcel, 1, i8);
            Q1.c.t(parcel, 2, this.f4761b);
            Q1.c.g(parcel, 3, this.f4762c);
            Q1.c.t(parcel, 4, this.f4763d);
            Q1.c.g(parcel, 5, this.f4764e);
            Q1.c.E(parcel, 6, this.f4765f, false);
            Q1.c.t(parcel, 7, G());
            Q1.c.E(parcel, 8, L(), false);
            Q1.c.C(parcel, 9, H(), i7, false);
            Q1.c.b(parcel, iA);
        }

        public C0083a(int i7, boolean z7, int i8, boolean z8, String str, int i9, Class cls, b bVar) {
            this.f4760a = 1;
            this.f4761b = i7;
            this.f4762c = z7;
            this.f4763d = i8;
            this.f4764e = z8;
            this.f4765f = str;
            this.f4766g = i9;
            this.f4767h = cls;
            if (cls == null) {
                this.f4768i = null;
            } else {
                this.f4768i = cls.getCanonicalName();
            }
            this.f4770k = bVar;
        }
    }
}
