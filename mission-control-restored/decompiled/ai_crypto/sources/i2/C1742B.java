package i2;

import android.os.Bundle;
import com.revenuecat.purchases.common.Constants;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: i2.B, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1742B {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C1742B f15014f = new C1742B((Boolean) null, 100, (Boolean) null, (String) null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f15017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f15018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EnumMap f15019e;

    public C1742B(Boolean bool, int i7, Boolean bool2, String str) {
        EnumMap enumMap = new EnumMap(Z3.class);
        this.f15019e = enumMap;
        enumMap.put(Z3.AD_USER_DATA, C1771a4.h(bool));
        this.f15015a = i7;
        this.f15016b = l();
        this.f15017c = bool2;
        this.f15018d = str;
    }

    public static C1742B a(X3 x32, int i7) {
        EnumMap enumMap = new EnumMap(Z3.class);
        enumMap.put(Z3.AD_USER_DATA, x32);
        return new C1742B(enumMap, -10, (Boolean) null, (String) null);
    }

    public static C1742B g(String str) {
        if (str == null || str.length() <= 0) {
            return f15014f;
        }
        String[] strArrSplit = str.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        int i7 = Integer.parseInt(strArrSplit[0]);
        EnumMap enumMap = new EnumMap(Z3.class);
        Z3[] z3ArrA = Y3.DMA.a();
        int length = z3ArrA.length;
        int i8 = 1;
        int i9 = 0;
        while (i9 < length) {
            enumMap.put(z3ArrA[i9], C1771a4.j(strArrSplit[i8].charAt(0)));
            i9++;
            i8++;
        }
        return new C1742B(enumMap, i7, (Boolean) null, (String) null);
    }

    public static C1742B h(Bundle bundle, int i7) {
        if (bundle == null) {
            return new C1742B((Boolean) null, i7, (Boolean) null, (String) null);
        }
        EnumMap enumMap = new EnumMap(Z3.class);
        for (Z3 z32 : Y3.DMA.a()) {
            enumMap.put(z32, C1771a4.g(bundle.getString(z32.f15480a)));
        }
        return new C1742B(enumMap, i7, bundle.containsKey("is_dma_region") ? Boolean.valueOf(bundle.getString("is_dma_region")) : null, bundle.getString("cps_display_str"));
    }

    public static Boolean i(Bundle bundle) {
        X3 x3G;
        if (bundle == null || (x3G = C1771a4.g(bundle.getString("ad_personalization"))) == null) {
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
        return this.f15015a;
    }

    public final X3 c() {
        X3 x32 = (X3) this.f15019e.get(Z3.AD_USER_DATA);
        return x32 == null ? X3.UNINITIALIZED : x32;
    }

    public final boolean d() {
        Iterator it = this.f15019e.values().iterator();
        while (it.hasNext()) {
            if (((X3) it.next()) != X3.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final String e() {
        return this.f15016b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1742B)) {
            return false;
        }
        C1742B c1742b = (C1742B) obj;
        if (this.f15016b.equalsIgnoreCase(c1742b.f15016b) && Objects.equals(this.f15017c, c1742b.f15017c)) {
            return Objects.equals(this.f15018d, c1742b.f15018d);
        }
        return false;
    }

    public final Bundle f() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.f15019e.entrySet()) {
            String strI = C1771a4.i((X3) entry.getValue());
            if (strI != null) {
                bundle.putString(((Z3) entry.getKey()).f15480a, strI);
            }
        }
        Boolean bool = this.f15017c;
        if (bool != null) {
            bundle.putString("is_dma_region", bool.toString());
        }
        String str = this.f15018d;
        if (str != null) {
            bundle.putString("cps_display_str", str);
        }
        return bundle;
    }

    public final int hashCode() {
        Boolean bool = this.f15017c;
        int i7 = bool == null ? 3 : true != bool.booleanValue() ? 13 : 7;
        String str = this.f15018d;
        return this.f15016b.hashCode() + (i7 * 29) + ((str == null ? 17 : str.hashCode()) * 137);
    }

    public final Boolean j() {
        return this.f15017c;
    }

    public final String k() {
        return this.f15018d;
    }

    public final String l() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f15015a);
        for (Z3 z32 : Y3.DMA.a()) {
            sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            sb.append(C1771a4.m((X3) this.f15019e.get(z32)));
        }
        return sb.toString();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(C1771a4.d(this.f15015a));
        for (Z3 z32 : Y3.DMA.a()) {
            sb.append(com.amazon.a.a.o.b.f.f9989a);
            sb.append(z32.f15480a);
            sb.append(com.amazon.a.a.o.b.f.f9990b);
            X3 x32 = (X3) this.f15019e.get(z32);
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
        Boolean bool = this.f15017c;
        if (bool != null) {
            sb.append(",isDmaRegion=");
            sb.append(bool);
        }
        String str = this.f15018d;
        if (str != null) {
            sb.append(",cpsDisplayStr=");
            sb.append(str);
        }
        return sb.toString();
    }

    public C1742B(EnumMap enumMap, int i7, Boolean bool, String str) {
        EnumMap enumMap2 = new EnumMap(Z3.class);
        this.f15019e = enumMap2;
        enumMap2.putAll(enumMap);
        this.f15015a = i7;
        this.f15016b = l();
        this.f15017c = bool;
        this.f15018d = str;
    }
}
