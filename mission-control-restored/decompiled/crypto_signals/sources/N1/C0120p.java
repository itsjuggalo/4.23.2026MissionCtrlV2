package N1;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Objects;

/* JADX INFO: renamed from: N1.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0120p {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0120p f1740f = new C0120p((Boolean) null, 100, (Boolean) null, (String) null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f1743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1744d;
    public final EnumMap e;

    public C0120p(Boolean bool, int i, Boolean bool2, String str) {
        EnumMap enumMap = new EnumMap(I0.class);
        this.e = enumMap;
        enumMap.put(I0.AD_USER_DATA, bool == null ? G0.UNINITIALIZED : bool.booleanValue() ? G0.GRANTED : G0.DENIED);
        this.f1741a = i;
        this.f1742b = d();
        this.f1743c = bool2;
        this.f1744d = str;
    }

    public static C0120p b(String str) {
        if (str == null || str.length() <= 0) {
            return f1740f;
        }
        String[] strArrSplit = str.split(":");
        int i = Integer.parseInt(strArrSplit[0]);
        EnumMap enumMap = new EnumMap(I0.class);
        I0[] i0Arr = H0.DMA.f1257a;
        int length = i0Arr.length;
        int i6 = 1;
        int i7 = 0;
        while (i7 < length) {
            enumMap.put(i0Arr[i7], J0.e(strArrSplit[i6].charAt(0)));
            i7++;
            i6++;
        }
        return new C0120p(enumMap, i, (Boolean) null, (String) null);
    }

    public static C0120p c(int i, Bundle bundle) {
        if (bundle == null) {
            return new C0120p((Boolean) null, i, (Boolean) null, (String) null);
        }
        EnumMap enumMap = new EnumMap(I0.class);
        for (I0 i02 : H0.DMA.f1257a) {
            enumMap.put(i02, J0.d(bundle.getString(i02.f1263a)));
        }
        return new C0120p(enumMap, i, bundle.containsKey("is_dma_region") ? Boolean.valueOf(bundle.getString("is_dma_region")) : null, bundle.getString("cps_display_str"));
    }

    public final G0 a() {
        G0 g02 = (G0) this.e.get(I0.AD_USER_DATA);
        return g02 == null ? G0.UNINITIALIZED : g02;
    }

    public final String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1741a);
        for (I0 i02 : H0.DMA.f1257a) {
            sb.append(":");
            sb.append(J0.h((G0) this.e.get(i02)));
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0120p)) {
            return false;
        }
        C0120p c0120p = (C0120p) obj;
        if (this.f1742b.equalsIgnoreCase(c0120p.f1742b) && Objects.equals(this.f1743c, c0120p.f1743c)) {
            return Objects.equals(this.f1744d, c0120p.f1744d);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.f1743c;
        int i = bool == null ? 3 : true != bool.booleanValue() ? 13 : 7;
        String str = this.f1744d;
        return ((str == null ? 17 : str.hashCode()) * 137) + this.f1742b.hashCode() + (i * 29);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(J0.a(this.f1741a));
        for (I0 i02 : H0.DMA.f1257a) {
            sb.append(",");
            sb.append(i02.f1263a);
            sb.append("=");
            G0 g02 = (G0) this.e.get(i02);
            if (g02 == null) {
                sb.append("uninitialized");
            } else {
                int iOrdinal = g02.ordinal();
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
        Boolean bool = this.f1743c;
        if (bool != null) {
            sb.append(",isDmaRegion=");
            sb.append(bool);
        }
        String str = this.f1744d;
        if (str != null) {
            sb.append(",cpsDisplayStr=");
            sb.append(str);
        }
        return sb.toString();
    }

    public C0120p(EnumMap enumMap, int i, Boolean bool, String str) {
        EnumMap enumMap2 = new EnumMap(I0.class);
        this.e = enumMap2;
        enumMap2.putAll(enumMap);
        this.f1741a = i;
        this.f1742b = d();
        this.f1743c = bool;
        this.f1744d = str;
    }
}
