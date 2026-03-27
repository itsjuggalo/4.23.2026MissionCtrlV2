package E1;

import G1.l;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    public interface b {
        Object c(Object obj);

        Object f(Object obj);
    }

    public static final void b(StringBuilder sb, C0016a c0016a, Object obj) {
        int i4 = c0016a.f382b;
        if (i4 == 11) {
            Class cls = c0016a.f388h;
            AbstractC0940s.k(cls);
            sb.append(((a) cls.cast(obj)).toString());
        } else {
            if (i4 != 7) {
                sb.append(obj);
                return;
            }
            sb.append("\"");
            sb.append(G1.k.a((String) obj));
            sb.append("\"");
        }
    }

    public static final void c(String str) {
        if (Log.isLoggable("FastJsonResponse", 6)) {
            Log.e("FastJsonResponse", "Output field (" + str + ") has a null value, but expected a primitive");
        }
    }

    public static final Object zaD(C0016a c0016a, Object obj) {
        return c0016a.f391k != null ? c0016a.t(obj) : obj;
    }

    public final void a(C0016a c0016a, Object obj) {
        int i4 = c0016a.f384d;
        Object objS = c0016a.s(obj);
        String str = c0016a.f386f;
        switch (i4) {
            case 0:
                if (objS != null) {
                    setIntegerInternal(c0016a, str, ((Integer) objS).intValue());
                    return;
                } else {
                    c(str);
                    return;
                }
            case 1:
                zaf(c0016a, str, (BigInteger) objS);
                return;
            case 2:
                if (objS != null) {
                    setLongInternal(c0016a, str, ((Long) objS).longValue());
                    return;
                } else {
                    c(str);
                    return;
                }
            case 3:
            default:
                throw new IllegalStateException("Unsupported type for conversion: " + i4);
            case 4:
                if (objS != null) {
                    zan(c0016a, str, ((Double) objS).doubleValue());
                    return;
                } else {
                    c(str);
                    return;
                }
            case 5:
                zab(c0016a, str, (BigDecimal) objS);
                return;
            case 6:
                if (objS != null) {
                    setBooleanInternal(c0016a, str, ((Boolean) objS).booleanValue());
                    return;
                } else {
                    c(str);
                    return;
                }
            case 7:
                setStringInternal(c0016a, str, (String) objS);
                return;
            case 8:
            case 9:
                if (objS != null) {
                    setDecodedBytesInternal(c0016a, str, (byte[]) objS);
                    return;
                } else {
                    c(str);
                    return;
                }
        }
    }

    public <T extends a> void addConcreteTypeArrayInternal(C0016a c0016a, String str, ArrayList<T> arrayList) {
        throw new UnsupportedOperationException("Concrete type array not supported");
    }

    public <T extends a> void addConcreteTypeInternal(C0016a c0016a, String str, T t4) {
        throw new UnsupportedOperationException("Concrete type not supported");
    }

    public abstract Map<String, C0016a> getFieldMappings();

    public Object getFieldValue(C0016a c0016a) {
        String str = c0016a.f386f;
        if (c0016a.f388h == null) {
            return getValueObject(str);
        }
        AbstractC0940s.p(getValueObject(str) == null, "Concrete field shouldn't be value object: %s", c0016a.f386f);
        try {
            return getClass().getMethod(com.amazon.a.a.o.b.au + Character.toUpperCase(str.charAt(0)) + str.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public abstract Object getValueObject(String str);

    public boolean isFieldSet(C0016a c0016a) {
        if (c0016a.f384d != 11) {
            return isPrimitiveFieldSet(c0016a.f386f);
        }
        if (c0016a.f385e) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    public abstract boolean isPrimitiveFieldSet(String str);

    public void setBooleanInternal(C0016a c0016a, String str, boolean z4) {
        throw new UnsupportedOperationException("Boolean not supported");
    }

    public void setDecodedBytesInternal(C0016a c0016a, String str, byte[] bArr) {
        throw new UnsupportedOperationException("byte[] not supported");
    }

    public void setIntegerInternal(C0016a c0016a, String str, int i4) {
        throw new UnsupportedOperationException("Integer not supported");
    }

    public void setLongInternal(C0016a c0016a, String str, long j4) {
        throw new UnsupportedOperationException("Long not supported");
    }

    public void setStringInternal(C0016a c0016a, String str, String str2) {
        throw new UnsupportedOperationException("String not supported");
    }

    public void setStringMapInternal(C0016a c0016a, String str, Map<String, String> map) {
        throw new UnsupportedOperationException("String map not supported");
    }

    public void setStringsInternal(C0016a c0016a, String str, ArrayList<String> arrayList) {
        throw new UnsupportedOperationException("String list not supported");
    }

    public String toString() {
        Map<String, C0016a> fieldMappings = getFieldMappings();
        StringBuilder sb = new StringBuilder(100);
        for (String str : fieldMappings.keySet()) {
            C0016a c0016a = fieldMappings.get(str);
            if (isFieldSet(c0016a)) {
                Object objZaD = zaD(c0016a, getFieldValue(c0016a));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(com.amazon.a.a.o.b.f.f8804a);
                }
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (objZaD != null) {
                    switch (c0016a.f384d) {
                        case 8:
                            sb.append("\"");
                            sb.append(G1.c.c((byte[]) objZaD));
                            sb.append("\"");
                            break;
                        case 9:
                            sb.append("\"");
                            sb.append(G1.c.d((byte[]) objZaD));
                            sb.append("\"");
                            break;
                        case 10:
                            l.a(sb, (HashMap) objZaD);
                            break;
                        default:
                            if (c0016a.f383c) {
                                ArrayList arrayList = (ArrayList) objZaD;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i4 = 0; i4 < size; i4++) {
                                    if (i4 > 0) {
                                        sb.append(com.amazon.a.a.o.b.f.f8804a);
                                    }
                                    Object obj = arrayList.get(i4);
                                    if (obj != null) {
                                        b(sb, c0016a, obj);
                                    }
                                }
                                sb.append("]");
                            } else {
                                b(sb, c0016a, objZaD);
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

    public final void zaA(C0016a c0016a, String str) {
        if (c0016a.f391k != null) {
            a(c0016a, str);
        } else {
            setStringInternal(c0016a, c0016a.f386f, str);
        }
    }

    public final void zaB(C0016a c0016a, Map map) {
        if (c0016a.f391k != null) {
            a(c0016a, map);
        } else {
            setStringMapInternal(c0016a, c0016a.f386f, map);
        }
    }

    public final void zaC(C0016a c0016a, ArrayList arrayList) {
        if (c0016a.f391k != null) {
            a(c0016a, arrayList);
        } else {
            setStringsInternal(c0016a, c0016a.f386f, arrayList);
        }
    }

    public final void zaa(C0016a c0016a, BigDecimal bigDecimal) {
        if (c0016a.f391k != null) {
            a(c0016a, bigDecimal);
        } else {
            zab(c0016a, c0016a.f386f, bigDecimal);
        }
    }

    public void zab(C0016a c0016a, String str, BigDecimal bigDecimal) {
        throw new UnsupportedOperationException("BigDecimal not supported");
    }

    public final void zac(C0016a c0016a, ArrayList arrayList) {
        if (c0016a.f391k != null) {
            a(c0016a, arrayList);
        } else {
            zad(c0016a, c0016a.f386f, arrayList);
        }
    }

    public void zad(C0016a c0016a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("BigDecimal list not supported");
    }

    public final void zae(C0016a c0016a, BigInteger bigInteger) {
        if (c0016a.f391k != null) {
            a(c0016a, bigInteger);
        } else {
            zaf(c0016a, c0016a.f386f, bigInteger);
        }
    }

    public void zaf(C0016a c0016a, String str, BigInteger bigInteger) {
        throw new UnsupportedOperationException("BigInteger not supported");
    }

    public final void zag(C0016a c0016a, ArrayList arrayList) {
        if (c0016a.f391k != null) {
            a(c0016a, arrayList);
        } else {
            zah(c0016a, c0016a.f386f, arrayList);
        }
    }

    public void zah(C0016a c0016a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("BigInteger list not supported");
    }

    public final void zai(C0016a c0016a, boolean z4) {
        if (c0016a.f391k != null) {
            a(c0016a, Boolean.valueOf(z4));
        } else {
            setBooleanInternal(c0016a, c0016a.f386f, z4);
        }
    }

    public final void zaj(C0016a c0016a, ArrayList arrayList) {
        if (c0016a.f391k != null) {
            a(c0016a, arrayList);
        } else {
            zak(c0016a, c0016a.f386f, arrayList);
        }
    }

    public void zak(C0016a c0016a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Boolean list not supported");
    }

    public final void zal(C0016a c0016a, byte[] bArr) {
        if (c0016a.f391k != null) {
            a(c0016a, bArr);
        } else {
            setDecodedBytesInternal(c0016a, c0016a.f386f, bArr);
        }
    }

    public final void zam(C0016a c0016a, double d4) {
        if (c0016a.f391k != null) {
            a(c0016a, Double.valueOf(d4));
        } else {
            zan(c0016a, c0016a.f386f, d4);
        }
    }

    public void zan(C0016a c0016a, String str, double d4) {
        throw new UnsupportedOperationException("Double not supported");
    }

    public final void zao(C0016a c0016a, ArrayList arrayList) {
        if (c0016a.f391k != null) {
            a(c0016a, arrayList);
        } else {
            zap(c0016a, c0016a.f386f, arrayList);
        }
    }

    public void zap(C0016a c0016a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Double list not supported");
    }

    public final void zaq(C0016a c0016a, float f4) {
        if (c0016a.f391k != null) {
            a(c0016a, Float.valueOf(f4));
        } else {
            zar(c0016a, c0016a.f386f, f4);
        }
    }

    public void zar(C0016a c0016a, String str, float f4) {
        throw new UnsupportedOperationException("Float not supported");
    }

    public final void zas(C0016a c0016a, ArrayList arrayList) {
        if (c0016a.f391k != null) {
            a(c0016a, arrayList);
        } else {
            zat(c0016a, c0016a.f386f, arrayList);
        }
    }

    public void zat(C0016a c0016a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Float list not supported");
    }

    public final void zau(C0016a c0016a, int i4) {
        if (c0016a.f391k != null) {
            a(c0016a, Integer.valueOf(i4));
        } else {
            setIntegerInternal(c0016a, c0016a.f386f, i4);
        }
    }

    public final void zav(C0016a c0016a, ArrayList arrayList) {
        if (c0016a.f391k != null) {
            a(c0016a, arrayList);
        } else {
            zaw(c0016a, c0016a.f386f, arrayList);
        }
    }

    public void zaw(C0016a c0016a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Integer list not supported");
    }

    public final void zax(C0016a c0016a, long j4) {
        if (c0016a.f391k != null) {
            a(c0016a, Long.valueOf(j4));
        } else {
            setLongInternal(c0016a, c0016a.f386f, j4);
        }
    }

    public final void zay(C0016a c0016a, ArrayList arrayList) {
        if (c0016a.f391k != null) {
            a(c0016a, arrayList);
        } else {
            zaz(c0016a, c0016a.f386f, arrayList);
        }
    }

    public void zaz(C0016a c0016a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Long list not supported");
    }

    /* JADX INFO: renamed from: E1.a$a, reason: collision with other inner class name */
    public static class C0016a extends A1.a {
        public static final d CREATOR = new d();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f382b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f383c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f384d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f385e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f386f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f387g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Class f388h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f389i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public h f390j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final b f391k;

        public C0016a(int i4, int i5, boolean z4, int i6, boolean z5, String str, int i7, String str2, D1.b bVar) {
            this.f381a = i4;
            this.f382b = i5;
            this.f383c = z4;
            this.f384d = i6;
            this.f385e = z5;
            this.f386f = str;
            this.f387g = i7;
            if (str2 == null) {
                this.f388h = null;
                this.f389i = null;
            } else {
                this.f388h = c.class;
                this.f389i = str2;
            }
            if (bVar == null) {
                this.f391k = null;
            } else {
                this.f391k = bVar.k();
            }
        }

        public static C0016a i(String str, int i4) {
            return new C0016a(8, false, 8, false, str, i4, null, null);
        }

        public static C0016a k(String str, int i4, Class cls) {
            return new C0016a(11, false, 11, false, str, i4, cls, null);
        }

        public static C0016a l(String str, int i4, Class cls) {
            return new C0016a(11, true, 11, true, str, i4, cls, null);
        }

        public static C0016a m(String str, int i4) {
            return new C0016a(0, false, 0, false, str, i4, null, null);
        }

        public static C0016a n(String str, int i4) {
            return new C0016a(7, false, 7, false, str, i4, null, null);
        }

        public static C0016a o(String str, int i4) {
            return new C0016a(7, true, 7, true, str, i4, null, null);
        }

        public int p() {
            return this.f387g;
        }

        public final D1.b q() {
            b bVar = this.f391k;
            if (bVar == null) {
                return null;
            }
            return D1.b.i(bVar);
        }

        public final Object s(Object obj) {
            AbstractC0940s.k(this.f391k);
            return AbstractC0940s.k(this.f391k.f(obj));
        }

        public final Object t(Object obj) {
            AbstractC0940s.k(this.f391k);
            return this.f391k.c(obj);
        }

        public final String toString() {
            AbstractC0939q.a aVarA = AbstractC0939q.d(this).a("versionCode", Integer.valueOf(this.f381a)).a("typeIn", Integer.valueOf(this.f382b)).a("typeInArray", Boolean.valueOf(this.f383c)).a("typeOut", Integer.valueOf(this.f384d)).a("typeOutArray", Boolean.valueOf(this.f385e)).a("outputFieldName", this.f386f).a("safeParcelFieldId", Integer.valueOf(this.f387g)).a("concreteTypeName", u());
            Class cls = this.f388h;
            if (cls != null) {
                aVarA.a("concreteType.class", cls.getCanonicalName());
            }
            b bVar = this.f391k;
            if (bVar != null) {
                aVarA.a("converterName", bVar.getClass().getCanonicalName());
            }
            return aVarA.toString();
        }

        public final String u() {
            String str = this.f389i;
            if (str == null) {
                return null;
            }
            return str;
        }

        public final Map v() {
            AbstractC0940s.k(this.f389i);
            AbstractC0940s.k(this.f390j);
            return (Map) AbstractC0940s.k(this.f390j.k(this.f389i));
        }

        public final void w(h hVar) {
            this.f390j = hVar;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            int i5 = this.f381a;
            int iA = A1.c.a(parcel);
            A1.c.t(parcel, 1, i5);
            A1.c.t(parcel, 2, this.f382b);
            A1.c.g(parcel, 3, this.f383c);
            A1.c.t(parcel, 4, this.f384d);
            A1.c.g(parcel, 5, this.f385e);
            A1.c.E(parcel, 6, this.f386f, false);
            A1.c.t(parcel, 7, p());
            A1.c.E(parcel, 8, u(), false);
            A1.c.C(parcel, 9, q(), i4, false);
            A1.c.b(parcel, iA);
        }

        public final boolean x() {
            return this.f391k != null;
        }

        public C0016a(int i4, boolean z4, int i5, boolean z5, String str, int i6, Class cls, b bVar) {
            this.f381a = 1;
            this.f382b = i4;
            this.f383c = z4;
            this.f384d = i5;
            this.f385e = z5;
            this.f386f = str;
            this.f387g = i6;
            this.f388h = cls;
            if (cls == null) {
                this.f389i = null;
            } else {
                this.f389i = cls.getCanonicalName();
            }
            this.f391k = bVar;
        }
    }
}
