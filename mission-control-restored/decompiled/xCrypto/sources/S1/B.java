package S1;

import android.os.Bundle;
import com.revenuecat.purchases.common.Constants;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class B {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final B f3855f = new B((Boolean) null, 100, (Boolean) null, (String) null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f3858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3859d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EnumMap f3860e;

    public B(Boolean bool, int i4, Boolean bool2, String str) {
        EnumMap enumMap = new EnumMap(Z3.class);
        this.f3860e = enumMap;
        enumMap.put(Z3.AD_USER_DATA, C0531a4.h(bool));
        this.f3856a = i4;
        this.f3857b = l();
        this.f3858c = bool2;
        this.f3859d = str;
    }

    public static B a(X3 x32, int i4) {
        EnumMap enumMap = new EnumMap(Z3.class);
        enumMap.put(Z3.AD_USER_DATA, x32);
        return new B(enumMap, -10, (Boolean) null, (String) null);
    }

    public static B g(String str) {
        if (str == null || str.length() <= 0) {
            return f3855f;
        }
        String[] strArrSplit = str.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        int i4 = Integer.parseInt(strArrSplit[0]);
        EnumMap enumMap = new EnumMap(Z3.class);
        Z3[] z3ArrA = Y3.DMA.a();
        int length = z3ArrA.length;
        int i5 = 1;
        int i6 = 0;
        while (i6 < length) {
            enumMap.put(z3ArrA[i6], C0531a4.j(strArrSplit[i5].charAt(0)));
            i6++;
            i5++;
        }
        return new B(enumMap, i4, (Boolean) null, (String) null);
    }

    public static B h(Bundle bundle, int i4) {
        if (bundle == null) {
            return new B((Boolean) null, i4, (Boolean) null, (String) null);
        }
        EnumMap enumMap = new EnumMap(Z3.class);
        for (Z3 z32 : Y3.DMA.a()) {
            enumMap.put(z32, C0531a4.g(bundle.getString(z32.f4321a)));
        }
        return new B(enumMap, i4, bundle.containsKey("is_dma_region") ? Boolean.valueOf(bundle.getString("is_dma_region")) : null, bundle.getString("cps_display_str"));
    }

    public static Boolean i(Bundle bundle) {
        X3 x3G;
        if (bundle == null || (x3G = C0531a4.g(bundle.getString("ad_personalization"))) == null) {
            return null;
        }
        int iOrdinal = x3G.ordinal();
        if (iOrdinal == 2) {
            return Boolean.FALSE;
        }
        if (iOrdinal != 3) {
            return null;
        }
        return Boolean.TRUE;
    }

    public final int b() {
        return this.f3856a;
    }

    public final X3 c() {
        X3 x32 = (X3) this.f3860e.get(Z3.AD_USER_DATA);
        return x32 == null ? X3.UNINITIALIZED : x32;
    }

    public final boolean d() {
        Iterator it = this.f3860e.values().iterator();
        while (it.hasNext()) {
            if (((X3) it.next()) != X3.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final String e() {
        return this.f3857b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof B)) {
            return false;
        }
        B b4 = (B) obj;
        if (this.f3857b.equalsIgnoreCase(b4.f3857b) && Objects.equals(this.f3858c, b4.f3858c)) {
            return Objects.equals(this.f3859d, b4.f3859d);
        }
        return false;
    }

    public final Bundle f() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.f3860e.entrySet()) {
            String strI = C0531a4.i((X3) entry.getValue());
            if (strI != null) {
                bundle.putString(((Z3) entry.getKey()).f4321a, strI);
            }
        }
        Boolean bool = this.f3858c;
        if (bool != null) {
            bundle.putString("is_dma_region", bool.toString());
        }
        String str = this.f3859d;
        if (str != null) {
            bundle.putString("cps_display_str", str);
        }
        return bundle;
    }

    public final int hashCode() {
        Boolean bool = this.f3858c;
        int i4 = bool == null ? 3 : true != bool.booleanValue() ? 13 : 7;
        String str = this.f3859d;
        return this.f3857b.hashCode() + (i4 * 29) + ((str == null ? 17 : str.hashCode()) * 137);
    }

    public final Boolean j() {
        return this.f3858c;
    }

    public final String k() {
        return this.f3859d;
    }

    public final String l() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3856a);
        for (Z3 z32 : Y3.DMA.a()) {
            sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            sb.append(C0531a4.m((X3) this.f3860e.get(z32)));
        }
        return sb.toString();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(C0531a4.d(this.f3856a));
        for (Z3 z32 : Y3.DMA.a()) {
            sb.append(com.amazon.a.a.o.b.f.f8804a);
            sb.append(z32.f4321a);
            sb.append(com.amazon.a.a.o.b.f.f8805b);
            X3 x32 = (X3) this.f3860e.get(z32);
            if (x32 == null) {
                sb.append("uninitialized");
            } else {
                int iOrdinal = x32.ordinal();
                if (iOrdinal == 0) {
                    sb.append("uninitialized");
                } else if (iOrdinal == 1) {
                    sb.append("eu_consent_policy");
                } else if (iOrdinal == 2) {
                    sb.append("denied");
                } else if (iOrdinal == 3) {
                    sb.append("granted");
                }
            }
        }
        Boolean bool = this.f3858c;
        if (bool != null) {
            sb.append(",isDmaRegion=");
            sb.append(bool);
        }
        String str = this.f3859d;
        if (str != null) {
            sb.append(",cpsDisplayStr=");
            sb.append(str);
        }
        return sb.toString();
    }

    public B(EnumMap enumMap, int i4, Boolean bool, String str) {
        EnumMap enumMap2 = new EnumMap(Z3.class);
        this.f3860e = enumMap2;
        enumMap2.putAll(enumMap);
        this.f3856a = i4;
        this.f3857b = l();
        this.f3858c = bool;
        this.f3859d = str;
    }
}
