package X0;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray f3426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ H[] f3427b;

    /* JADX INFO: Fake field, exist only in values array */
    H EF1;

    static {
        H h6 = new H("UNKNOWN_MOBILE_SUBTYPE", 0);
        H h7 = new H("GPRS", 1);
        H h8 = new H("EDGE", 2);
        H h9 = new H("UMTS", 3);
        H h10 = new H("CDMA", 4);
        H h11 = new H("EVDO_0", 5);
        H h12 = new H("EVDO_A", 6);
        H h13 = new H("RTT", 7);
        H h14 = new H("HSDPA", 8);
        H h15 = new H("HSUPA", 9);
        H h16 = new H("HSPA", 10);
        H h17 = new H("IDEN", 11);
        H h18 = new H("EVDO_B", 12);
        H h19 = new H("LTE", 13);
        H h20 = new H("EHRPD", 14);
        H h21 = new H("HSPAP", 15);
        H h22 = new H("GSM", 16);
        H h23 = new H("TD_SCDMA", 17);
        H h24 = new H("IWLAN", 18);
        H h25 = new H("LTE_CA", 19);
        f3427b = new H[]{h6, h7, h8, h9, h10, h11, h12, h13, h14, h15, h16, h17, h18, h19, h20, h21, h22, h23, h24, h25, new H("COMBINED", 20)};
        SparseArray sparseArray = new SparseArray();
        f3426a = sparseArray;
        sparseArray.put(0, h6);
        sparseArray.put(1, h7);
        sparseArray.put(2, h8);
        sparseArray.put(3, h9);
        sparseArray.put(4, h10);
        sparseArray.put(5, h11);
        sparseArray.put(6, h12);
        sparseArray.put(7, h13);
        sparseArray.put(8, h14);
        sparseArray.put(9, h15);
        sparseArray.put(10, h16);
        sparseArray.put(11, h17);
        sparseArray.put(12, h18);
        sparseArray.put(13, h19);
        sparseArray.put(14, h20);
        sparseArray.put(15, h21);
        sparseArray.put(16, h22);
        sparseArray.put(17, h23);
        sparseArray.put(18, h24);
        sparseArray.put(19, h25);
    }

    public static H valueOf(String str) {
        return (H) Enum.valueOf(H.class, str);
    }

    public static H[] values() {
        return (H[]) f3427b.clone();
    }
}
