package r5;

import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import t5.l;
import t5.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        Object g(Object obj);

        Object r(Object obj);
    }

    public static final void b(StringBuilder sb2, C0336a c0336a, Object obj) {
        int i10 = c0336a.f19319b;
        if (i10 == 11) {
            Class cls = c0336a.f19325h;
            s.k(cls);
            sb2.append(((a) cls.cast(obj)).toString());
        } else {
            if (i10 != 7) {
                sb2.append(obj);
                return;
            }
            sb2.append("\"");
            sb2.append(l.a((String) obj));
            sb2.append("\"");
        }
    }

    public static final void d(String str) {
        if (Log.isLoggable("FastJsonResponse", 6)) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 58);
            sb2.append("Output field (");
            sb2.append(str);
            sb2.append(") has a null value, but expected a primitive");
            Log.e("FastJsonResponse", sb2.toString());
        }
    }

    public static final Object zaD(C0336a c0336a, Object obj) {
        return c0336a.f0() != null ? c0336a.e0(obj) : obj;
    }

    public final void a(C0336a c0336a, Object obj) {
        int i10 = c0336a.f19321d;
        Object objD0 = c0336a.d0(obj);
        String str = c0336a.f19323f;
        switch (i10) {
            case 0:
                if (objD0 != null) {
                    setIntegerInternal(c0336a, str, ((Integer) objD0).intValue());
                    return;
                } else {
                    d(str);
                    return;
                }
            case 1:
                zat(c0336a, str, (BigInteger) objD0);
                return;
            case 2:
                if (objD0 != null) {
                    setLongInternal(c0336a, str, ((Long) objD0).longValue());
                    return;
                } else {
                    d(str);
                    return;
                }
            case 3:
            default:
                StringBuilder sb2 = new StringBuilder(String.valueOf(i10).length() + 33);
                sb2.append("Unsupported type for conversion: ");
                sb2.append(i10);
                throw new IllegalStateException(sb2.toString());
            case 4:
                if (objD0 != null) {
                    zay(c0336a, str, ((Double) objD0).doubleValue());
                    return;
                } else {
                    d(str);
                    return;
                }
            case 5:
                zaA(c0336a, str, (BigDecimal) objD0);
                return;
            case 6:
                if (objD0 != null) {
                    setBooleanInternal(c0336a, str, ((Boolean) objD0).booleanValue());
                    return;
                } else {
                    d(str);
                    return;
                }
            case 7:
                setStringInternal(c0336a, str, (String) objD0);
                return;
            case 8:
            case 9:
                if (objD0 != null) {
                    setDecodedBytesInternal(c0336a, str, (byte[]) objD0);
                    return;
                } else {
                    d(str);
                    return;
                }
        }
    }

    public <T extends a> void addConcreteTypeArrayInternal(C0336a c0336a, String str, ArrayList<T> arrayList) {
        throw new UnsupportedOperationException("Concrete type array not supported");
    }

    public <T extends a> void addConcreteTypeInternal(C0336a c0336a, String str, T t10) {
        throw new UnsupportedOperationException("Concrete type not supported");
    }

    public abstract Map<String, C0336a> getFieldMappings();

    public Object getFieldValue(C0336a c0336a) {
        String str = c0336a.f19323f;
        if (c0336a.f19325h == null) {
            return getValueObject(str);
        }
        s.p(getValueObject(str) == null, "Concrete field shouldn't be value object: %s", str);
        try {
            char upperCase = Character.toUpperCase(str.charAt(0));
            String strSubstring = str.substring(1);
            StringBuilder sb2 = new StringBuilder(String.valueOf(upperCase).length() + 3 + String.valueOf(strSubstring).length());
            sb2.append(com.amazon.a.a.o.b.au);
            sb2.append(upperCase);
            sb2.append(strSubstring);
            return getClass().getMethod(sb2.toString(), null).invoke(this, null);
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }

    public abstract Object getValueObject(String str);

    public boolean isFieldSet(C0336a c0336a) {
        if (c0336a.f19321d != 11) {
            return isPrimitiveFieldSet(c0336a.f19323f);
        }
        if (c0336a.f19322e) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    public abstract boolean isPrimitiveFieldSet(String str);

    public void setBooleanInternal(C0336a c0336a, String str, boolean z10) {
        throw new UnsupportedOperationException("Boolean not supported");
    }

    public void setDecodedBytesInternal(C0336a c0336a, String str, byte[] bArr) {
        throw new UnsupportedOperationException("byte[] not supported");
    }

    public void setIntegerInternal(C0336a c0336a, String str, int i10) {
        throw new UnsupportedOperationException("Integer not supported");
    }

    public void setLongInternal(C0336a c0336a, String str, long j10) {
        throw new UnsupportedOperationException("Long not supported");
    }

    public void setStringInternal(C0336a c0336a, String str, String str2) {
        throw new UnsupportedOperationException("String not supported");
    }

    public void setStringMapInternal(C0336a c0336a, String str, Map<String, String> map) {
        throw new UnsupportedOperationException("String map not supported");
    }

    public void setStringsInternal(C0336a c0336a, String str, ArrayList<String> arrayList) {
        throw new UnsupportedOperationException("String list not supported");
    }

    public String toString() {
        Map<String, C0336a> fieldMappings = getFieldMappings();
        StringBuilder sb2 = new StringBuilder(100);
        for (String str : fieldMappings.keySet()) {
            C0336a c0336a = fieldMappings.get(str);
            if (isFieldSet(c0336a)) {
                Object objZaD = zaD(c0336a, getFieldValue(c0336a));
                if (sb2.length() == 0) {
                    sb2.append("{");
                } else {
                    sb2.append(com.amazon.a.a.o.b.f.f4598a);
                }
                sb2.append("\"");
                sb2.append(str);
                sb2.append("\":");
                if (objZaD != null) {
                    switch (c0336a.f19321d) {
                        case 8:
                            sb2.append("\"");
                            sb2.append(t5.c.c((byte[]) objZaD));
                            sb2.append("\"");
                            break;
                        case 9:
                            sb2.append("\"");
                            sb2.append(t5.c.d((byte[]) objZaD));
                            sb2.append("\"");
                            break;
                        case 10:
                            m.a(sb2, (HashMap) objZaD);
                            break;
                        default:
                            if (c0336a.f19320c) {
                                ArrayList arrayList = (ArrayList) objZaD;
                                sb2.append("[");
                                int size = arrayList.size();
                                for (int i10 = 0; i10 < size; i10++) {
                                    if (i10 > 0) {
                                        sb2.append(com.amazon.a.a.o.b.f.f4598a);
                                    }
                                    Object obj = arrayList.get(i10);
                                    if (obj != null) {
                                        b(sb2, c0336a, obj);
                                    }
                                }
                                sb2.append("]");
                            } else {
                                b(sb2, c0336a, objZaD);
                            }
                            break;
                    }
                } else {
                    sb2.append("null");
                }
            }
        }
        if (sb2.length() > 0) {
            sb2.append("}");
        } else {
            sb2.append("{}");
        }
        return sb2.toString();
    }

    public void zaA(C0336a c0336a, String str, BigDecimal bigDecimal) {
        throw new UnsupportedOperationException("BigDecimal not supported");
    }

    public void zaB(C0336a c0336a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("BigDecimal list not supported");
    }

    public void zaC(C0336a c0336a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Boolean list not supported");
    }

    public final void zaa(C0336a c0336a, int i10) {
        if (c0336a.f0() != null) {
            a(c0336a, Integer.valueOf(i10));
        } else {
            setIntegerInternal(c0336a, c0336a.f19323f, i10);
        }
    }

    public final void zab(C0336a c0336a, ArrayList arrayList) {
        if (c0336a.f0() != null) {
            a(c0336a, arrayList);
        } else {
            zas(c0336a, c0336a.f19323f, arrayList);
        }
    }

    public final void zac(C0336a c0336a, BigInteger bigInteger) {
        if (c0336a.f0() != null) {
            a(c0336a, bigInteger);
        } else {
            zat(c0336a, c0336a.f19323f, bigInteger);
        }
    }

    public final void zad(C0336a c0336a, ArrayList arrayList) {
        if (c0336a.f0() != null) {
            a(c0336a, arrayList);
        } else {
            zau(c0336a, c0336a.f19323f, arrayList);
        }
    }

    public final void zae(C0336a c0336a, long j10) {
        if (c0336a.f0() != null) {
            a(c0336a, Long.valueOf(j10));
        } else {
            setLongInternal(c0336a, c0336a.f19323f, j10);
        }
    }

    public final void zaf(C0336a c0336a, ArrayList arrayList) {
        if (c0336a.f0() != null) {
            a(c0336a, arrayList);
        } else {
            zav(c0336a, c0336a.f19323f, arrayList);
        }
    }

    public final void zag(C0336a c0336a, float f10) {
        if (c0336a.f0() != null) {
            a(c0336a, Float.valueOf(f10));
        } else {
            zaw(c0336a, c0336a.f19323f, f10);
        }
    }

    public final void zah(C0336a c0336a, ArrayList arrayList) {
        if (c0336a.f0() != null) {
            a(c0336a, arrayList);
        } else {
            zax(c0336a, c0336a.f19323f, arrayList);
        }
    }

    public final void zai(C0336a c0336a, double d10) {
        if (c0336a.f0() != null) {
            a(c0336a, Double.valueOf(d10));
        } else {
            zay(c0336a, c0336a.f19323f, d10);
        }
    }

    public final void zaj(C0336a c0336a, ArrayList arrayList) {
        if (c0336a.f0() != null) {
            a(c0336a, arrayList);
        } else {
            zaz(c0336a, c0336a.f19323f, arrayList);
        }
    }

    public final void zak(C0336a c0336a, BigDecimal bigDecimal) {
        if (c0336a.f0() != null) {
            a(c0336a, bigDecimal);
        } else {
            zaA(c0336a, c0336a.f19323f, bigDecimal);
        }
    }

    public final void zal(C0336a c0336a, ArrayList arrayList) {
        if (c0336a.f0() != null) {
            a(c0336a, arrayList);
        } else {
            zaB(c0336a, c0336a.f19323f, arrayList);
        }
    }

    public final void zam(C0336a c0336a, boolean z10) {
        if (c0336a.f0() != null) {
            a(c0336a, Boolean.valueOf(z10));
        } else {
            setBooleanInternal(c0336a, c0336a.f19323f, z10);
        }
    }

    public final void zan(C0336a c0336a, ArrayList arrayList) {
        if (c0336a.f0() != null) {
            a(c0336a, arrayList);
        } else {
            zaC(c0336a, c0336a.f19323f, arrayList);
        }
    }

    public final void zao(C0336a c0336a, String str) {
        if (c0336a.f0() != null) {
            a(c0336a, str);
        } else {
            setStringInternal(c0336a, c0336a.f19323f, str);
        }
    }

    public final void zap(C0336a c0336a, ArrayList arrayList) {
        if (c0336a.f0() != null) {
            a(c0336a, arrayList);
        } else {
            setStringsInternal(c0336a, c0336a.f19323f, arrayList);
        }
    }

    public final void zaq(C0336a c0336a, byte[] bArr) {
        if (c0336a.f0() != null) {
            a(c0336a, bArr);
        } else {
            setDecodedBytesInternal(c0336a, c0336a.f19323f, bArr);
        }
    }

    public final void zar(C0336a c0336a, Map map) {
        if (c0336a.f0() != null) {
            a(c0336a, map);
        } else {
            setStringMapInternal(c0336a, c0336a.f19323f, map);
        }
    }

    public void zas(C0336a c0336a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Integer list not supported");
    }

    public void zat(C0336a c0336a, String str, BigInteger bigInteger) {
        throw new UnsupportedOperationException("BigInteger not supported");
    }

    public void zau(C0336a c0336a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("BigInteger list not supported");
    }

    public void zav(C0336a c0336a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Long list not supported");
    }

    public void zaw(C0336a c0336a, String str, float f10) {
        throw new UnsupportedOperationException("Float not supported");
    }

    public void zax(C0336a c0336a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Float list not supported");
    }

    public void zay(C0336a c0336a, String str, double d10) {
        throw new UnsupportedOperationException("Double not supported");
    }

    public void zaz(C0336a c0336a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Double list not supported");
    }

    /* JADX INFO: renamed from: r5.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0336a extends n5.a {
        public static final d CREATOR = new d();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f19318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f19319b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f19320c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f19321d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f19322e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f19323f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f19324g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Class f19325h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f19326i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public h f19327j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final b f19328k;

        public C0336a(int i10, int i11, boolean z10, int i12, boolean z11, String str, int i13, String str2, q5.b bVar) {
            this.f19318a = i10;
            this.f19319b = i11;
            this.f19320c = z10;
            this.f19321d = i12;
            this.f19322e = z11;
            this.f19323f = str;
            this.f19324g = i13;
            if (str2 == null) {
                this.f19325h = null;
                this.f19326i = null;
            } else {
                this.f19325h = c.class;
                this.f19326i = str2;
            }
            if (bVar == null) {
                this.f19328k = null;
            } else {
                this.f19328k = bVar.S();
            }
        }

        public static C0336a R(String str, int i10) {
            return new C0336a(8, false, 8, false, str, i10, null, null);
        }

        public static C0336a S(String str, int i10, Class cls) {
            return new C0336a(11, false, 11, false, str, i10, cls, null);
        }

        public static C0336a T(String str, int i10, Class cls) {
            return new C0336a(11, true, 11, true, str, i10, cls, null);
        }

        public static C0336a U(String str, int i10) {
            return new C0336a(0, false, 0, false, str, i10, null, null);
        }

        public static C0336a V(String str, int i10) {
            return new C0336a(7, false, 7, false, str, i10, null, null);
        }

        public static C0336a W(String str, int i10) {
            return new C0336a(7, true, 7, true, str, i10, null, null);
        }

        public int X() {
            return this.f19324g;
        }

        public final String Y() {
            String str = this.f19326i;
            if (str == null) {
                return null;
            }
            return str;
        }

        public final boolean Z() {
            return this.f19328k != null;
        }

        public final void a0(h hVar) {
            this.f19327j = hVar;
        }

        public final q5.b b0() {
            b bVar = this.f19328k;
            if (bVar == null) {
                return null;
            }
            return q5.b.R(bVar);
        }

        public final Map c0() {
            String str = this.f19326i;
            s.k(str);
            s.k(this.f19327j);
            return (Map) s.k(this.f19327j.S(str));
        }

        public final Object d0(Object obj) {
            b bVar = this.f19328k;
            s.k(bVar);
            return s.k(bVar.g(obj));
        }

        public final Object e0(Object obj) {
            b bVar = this.f19328k;
            s.k(bVar);
            return bVar.r(obj);
        }

        public final /* synthetic */ b f0() {
            return this.f19328k;
        }

        public final String toString() {
            q.a aVarA = q.d(this).a("versionCode", Integer.valueOf(this.f19318a)).a("typeIn", Integer.valueOf(this.f19319b)).a("typeInArray", Boolean.valueOf(this.f19320c)).a("typeOut", Integer.valueOf(this.f19321d)).a("typeOutArray", Boolean.valueOf(this.f19322e)).a("outputFieldName", this.f19323f).a("safeParcelFieldId", Integer.valueOf(this.f19324g)).a("concreteTypeName", Y());
            Class cls = this.f19325h;
            if (cls != null) {
                aVarA.a("concreteType.class", cls.getCanonicalName());
            }
            b bVar = this.f19328k;
            if (bVar != null) {
                aVarA.a("converterName", bVar.getClass().getCanonicalName());
            }
            return aVarA.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i10) {
            int i11 = this.f19318a;
            int iA = n5.c.a(parcel);
            n5.c.t(parcel, 1, i11);
            n5.c.t(parcel, 2, this.f19319b);
            n5.c.g(parcel, 3, this.f19320c);
            n5.c.t(parcel, 4, this.f19321d);
            n5.c.g(parcel, 5, this.f19322e);
            n5.c.E(parcel, 6, this.f19323f, false);
            n5.c.t(parcel, 7, X());
            n5.c.E(parcel, 8, Y(), false);
            n5.c.C(parcel, 9, b0(), i10, false);
            n5.c.b(parcel, iA);
        }

        public C0336a(int i10, boolean z10, int i11, boolean z11, String str, int i12, Class cls, b bVar) {
            this.f19318a = 1;
            this.f19319b = i10;
            this.f19320c = z10;
            this.f19321d = i11;
            this.f19322e = z11;
            this.f19323f = str;
            this.f19324g = i12;
            this.f19325h = cls;
            if (cls == null) {
                this.f19326i = null;
            } else {
                this.f19326i = cls.getCanonicalName();
            }
            this.f19328k = bVar;
        }
    }
}
