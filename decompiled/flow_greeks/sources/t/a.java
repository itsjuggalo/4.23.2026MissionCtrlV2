package t;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f20436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f20437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f20438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f20439d;

    /* JADX INFO: renamed from: t.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0361a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f20440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f20441b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f20442c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f20443d;

        public a a() {
            return new a(this.f20440a, this.f20441b, this.f20442c, this.f20443d);
        }
    }

    public a(Integer num, Integer num2, Integer num3, Integer num4) {
        this.f20436a = num;
        this.f20437b = num2;
        this.f20438c = num3;
        this.f20439d = num4;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f20436a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.f20437b;
        if (num2 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num2.intValue());
        }
        Integer num3 = this.f20438c;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num3.intValue());
        }
        Integer num4 = this.f20439d;
        if (num4 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num4.intValue());
        }
        return bundle;
    }
}
