package t;

import android.os.Bundle;

/* JADX INFO: renamed from: t.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1780a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f14696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f14697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f14698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f14699d;

    /* JADX INFO: renamed from: t.a$a, reason: collision with other inner class name */
    public static final class C0238a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f14700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f14701b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f14702c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f14703d;

        public C1780a a() {
            return new C1780a(this.f14700a, this.f14701b, this.f14702c, this.f14703d);
        }
    }

    public C1780a(Integer num, Integer num2, Integer num3, Integer num4) {
        this.f14696a = num;
        this.f14697b = num2;
        this.f14698c = num3;
        this.f14699d = num4;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f14696a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.f14697b;
        if (num2 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num2.intValue());
        }
        Integer num3 = this.f14698c;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num3.intValue());
        }
        Integer num4 = this.f14699d;
        if (num4 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num4.intValue());
        }
        return bundle;
    }
}
