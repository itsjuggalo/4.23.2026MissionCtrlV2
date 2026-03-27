package z1;

import android.util.Base64;
import com.google.android.gms.common.internal.I;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import s3.I0;
import y1.C1421a;

/* JADX INFO: renamed from: z1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1457b {
    public static final void b(StringBuilder sb, C1456a c1456a, Object obj) {
        int i = c1456a.f11733b;
        if (i == 11) {
            Class cls = c1456a.f11738l;
            I.g(cls);
            sb.append(((AbstractC1457b) cls.cast(obj)).toString());
        } else {
            if (i != 7) {
                sb.append(obj);
                return;
            }
            sb.append("\"");
            sb.append(B1.d.a((String) obj));
            sb.append("\"");
        }
    }

    public static final Object zaD(C1456a c1456a, Object obj) {
        C1421a c1421a = c1456a.f11741o;
        if (c1421a != null) {
            obj = (String) c1421a.f11637c.get(((Integer) obj).intValue());
            if (obj == null && c1421a.f11636b.containsKey("gms_unknown")) {
                return "gms_unknown";
            }
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(C1456a c1456a, Object obj) {
        C1421a c1421a = c1456a.f11741o;
        I.g(c1421a);
        HashMap map = c1421a.f11636b;
        Integer num = (Integer) map.get((String) obj);
        Integer num2 = num;
        if (num == null) {
            num2 = (Integer) map.get("gms_unknown");
        }
        I.g(num2);
        int i = c1456a.f11735d;
        String str = c1456a.f11736f;
        switch (i) {
            case 0:
                setIntegerInternal(c1456a, str, num2.intValue());
                return;
            case 1:
                zaf(c1456a, str, (BigInteger) num2);
                return;
            case 2:
                setLongInternal(c1456a, str, ((Long) num2).longValue());
                return;
            case 3:
            default:
                throw new IllegalStateException(a3.d.f(i, "Unsupported type for conversion: "));
            case 4:
                zan(c1456a, str, ((Double) num2).doubleValue());
                return;
            case 5:
                zab(c1456a, str, (BigDecimal) num2);
                return;
            case 6:
                setBooleanInternal(c1456a, str, ((Boolean) num2).booleanValue());
                return;
            case 7:
                setStringInternal(c1456a, str, (String) num2);
                return;
            case 8:
            case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                setDecodedBytesInternal(c1456a, str, (byte[]) num2);
                return;
        }
    }

    public <T extends AbstractC1457b> void addConcreteTypeArrayInternal(C1456a c1456a, String str, ArrayList<T> arrayList) {
        throw new UnsupportedOperationException("Concrete type array not supported");
    }

    public <T extends AbstractC1457b> void addConcreteTypeInternal(C1456a c1456a, String str, T t6) {
        throw new UnsupportedOperationException("Concrete type not supported");
    }

    public abstract Map<String, C1456a> getFieldMappings();

    public Object getFieldValue(C1456a c1456a) {
        String str = c1456a.f11736f;
        if (c1456a.f11738l == null) {
            return getValueObject(str);
        }
        if (!(getValueObject(str) == null)) {
            throw new IllegalStateException("Concrete field shouldn't be value object: " + c1456a.f11736f);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(str.charAt(0)) + str.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public abstract Object getValueObject(String str);

    public boolean isFieldSet(C1456a c1456a) {
        if (c1456a.f11735d != 11) {
            return isPrimitiveFieldSet(c1456a.f11736f);
        }
        if (c1456a.e) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    public abstract boolean isPrimitiveFieldSet(String str);

    public void setBooleanInternal(C1456a c1456a, String str, boolean z6) {
        throw new UnsupportedOperationException("Boolean not supported");
    }

    public void setDecodedBytesInternal(C1456a c1456a, String str, byte[] bArr) {
        throw new UnsupportedOperationException("byte[] not supported");
    }

    public void setIntegerInternal(C1456a c1456a, String str, int i) {
        throw new UnsupportedOperationException("Integer not supported");
    }

    public void setLongInternal(C1456a c1456a, String str, long j4) {
        throw new UnsupportedOperationException("Long not supported");
    }

    public void setStringInternal(C1456a c1456a, String str, String str2) {
        throw new UnsupportedOperationException("String not supported");
    }

    public void setStringMapInternal(C1456a c1456a, String str, Map<String, String> map) {
        throw new UnsupportedOperationException("String map not supported");
    }

    public void setStringsInternal(C1456a c1456a, String str, ArrayList<String> arrayList) {
        throw new UnsupportedOperationException("String list not supported");
    }

    public String toString() {
        Map<String, C1456a> fieldMappings = getFieldMappings();
        StringBuilder sb = new StringBuilder(100);
        for (String str : fieldMappings.keySet()) {
            C1456a c1456a = fieldMappings.get(str);
            if (isFieldSet(c1456a)) {
                Object objZaD = zaD(c1456a, getFieldValue(c1456a));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (objZaD != null) {
                    switch (c1456a.f11735d) {
                        case 8:
                            sb.append("\"");
                            sb.append(Base64.encodeToString((byte[]) objZaD, 0));
                            sb.append("\"");
                            break;
                        case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            sb.append("\"");
                            sb.append(Base64.encodeToString((byte[]) objZaD, 10));
                            sb.append("\"");
                            break;
                        case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            B1.c.h(sb, (HashMap) objZaD);
                            break;
                        default:
                            if (c1456a.f11734c) {
                                ArrayList arrayList = (ArrayList) objZaD;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i = 0; i < size; i++) {
                                    if (i > 0) {
                                        sb.append(",");
                                    }
                                    Object obj = arrayList.get(i);
                                    if (obj != null) {
                                        b(sb, c1456a, obj);
                                    }
                                }
                                sb.append("]");
                            } else {
                                b(sb, c1456a, objZaD);
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

    public final void zaA(C1456a c1456a, String str) {
        if (c1456a.f11741o != null) {
            a(c1456a, str);
        } else {
            setStringInternal(c1456a, c1456a.f11736f, str);
        }
    }

    public final void zaB(C1456a c1456a, Map map) {
        if (c1456a.f11741o != null) {
            a(c1456a, map);
        } else {
            setStringMapInternal(c1456a, c1456a.f11736f, map);
        }
    }

    public final void zaC(C1456a c1456a, ArrayList arrayList) {
        if (c1456a.f11741o != null) {
            a(c1456a, arrayList);
        } else {
            setStringsInternal(c1456a, c1456a.f11736f, arrayList);
        }
    }

    public final void zaa(C1456a c1456a, BigDecimal bigDecimal) {
        if (c1456a.f11741o != null) {
            a(c1456a, bigDecimal);
        } else {
            zab(c1456a, c1456a.f11736f, bigDecimal);
        }
    }

    public void zab(C1456a c1456a, String str, BigDecimal bigDecimal) {
        throw new UnsupportedOperationException("BigDecimal not supported");
    }

    public final void zac(C1456a c1456a, ArrayList arrayList) {
        if (c1456a.f11741o != null) {
            a(c1456a, arrayList);
        } else {
            zad(c1456a, c1456a.f11736f, arrayList);
        }
    }

    public void zad(C1456a c1456a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("BigDecimal list not supported");
    }

    public final void zae(C1456a c1456a, BigInteger bigInteger) {
        if (c1456a.f11741o != null) {
            a(c1456a, bigInteger);
        } else {
            zaf(c1456a, c1456a.f11736f, bigInteger);
        }
    }

    public void zaf(C1456a c1456a, String str, BigInteger bigInteger) {
        throw new UnsupportedOperationException("BigInteger not supported");
    }

    public final void zag(C1456a c1456a, ArrayList arrayList) {
        if (c1456a.f11741o != null) {
            a(c1456a, arrayList);
        } else {
            zah(c1456a, c1456a.f11736f, arrayList);
        }
    }

    public void zah(C1456a c1456a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("BigInteger list not supported");
    }

    public final void zai(C1456a c1456a, boolean z6) {
        if (c1456a.f11741o != null) {
            a(c1456a, Boolean.valueOf(z6));
        } else {
            setBooleanInternal(c1456a, c1456a.f11736f, z6);
        }
    }

    public final void zaj(C1456a c1456a, ArrayList arrayList) {
        if (c1456a.f11741o != null) {
            a(c1456a, arrayList);
        } else {
            zak(c1456a, c1456a.f11736f, arrayList);
        }
    }

    public void zak(C1456a c1456a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Boolean list not supported");
    }

    public final void zal(C1456a c1456a, byte[] bArr) {
        if (c1456a.f11741o != null) {
            a(c1456a, bArr);
        } else {
            setDecodedBytesInternal(c1456a, c1456a.f11736f, bArr);
        }
    }

    public final void zam(C1456a c1456a, double d4) {
        if (c1456a.f11741o != null) {
            a(c1456a, Double.valueOf(d4));
        } else {
            zan(c1456a, c1456a.f11736f, d4);
        }
    }

    public void zan(C1456a c1456a, String str, double d4) {
        throw new UnsupportedOperationException("Double not supported");
    }

    public final void zao(C1456a c1456a, ArrayList arrayList) {
        if (c1456a.f11741o != null) {
            a(c1456a, arrayList);
        } else {
            zap(c1456a, c1456a.f11736f, arrayList);
        }
    }

    public void zap(C1456a c1456a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Double list not supported");
    }

    public final void zaq(C1456a c1456a, float f6) {
        if (c1456a.f11741o != null) {
            a(c1456a, Float.valueOf(f6));
        } else {
            zar(c1456a, c1456a.f11736f, f6);
        }
    }

    public void zar(C1456a c1456a, String str, float f6) {
        throw new UnsupportedOperationException("Float not supported");
    }

    public final void zas(C1456a c1456a, ArrayList arrayList) {
        if (c1456a.f11741o != null) {
            a(c1456a, arrayList);
        } else {
            zat(c1456a, c1456a.f11736f, arrayList);
        }
    }

    public void zat(C1456a c1456a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Float list not supported");
    }

    public final void zau(C1456a c1456a, int i) {
        if (c1456a.f11741o != null) {
            a(c1456a, Integer.valueOf(i));
        } else {
            setIntegerInternal(c1456a, c1456a.f11736f, i);
        }
    }

    public final void zav(C1456a c1456a, ArrayList arrayList) {
        if (c1456a.f11741o != null) {
            a(c1456a, arrayList);
        } else {
            zaw(c1456a, c1456a.f11736f, arrayList);
        }
    }

    public void zaw(C1456a c1456a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Integer list not supported");
    }

    public final void zax(C1456a c1456a, long j4) {
        if (c1456a.f11741o != null) {
            a(c1456a, Long.valueOf(j4));
        } else {
            setLongInternal(c1456a, c1456a.f11736f, j4);
        }
    }

    public final void zay(C1456a c1456a, ArrayList arrayList) {
        if (c1456a.f11741o != null) {
            a(c1456a, arrayList);
        } else {
            zaz(c1456a, c1456a.f11736f, arrayList);
        }
    }

    public void zaz(C1456a c1456a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Long list not supported");
    }
}
