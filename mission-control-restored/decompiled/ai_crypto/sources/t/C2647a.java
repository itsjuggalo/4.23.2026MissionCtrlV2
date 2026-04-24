package t;

import android.os.Bundle;

/* JADX INFO: renamed from: t.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2647a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f23077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f23078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f23079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f23080d;

    /* JADX INFO: renamed from: t.a$a, reason: collision with other inner class name */
    public static final class C0361a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f23081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f23082b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f23083c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f23084d;

        public C2647a a() {
            return new C2647a(this.f23081a, this.f23082b, this.f23083c, this.f23084d);
        }
    }

    public C2647a(Integer num, Integer num2, Integer num3, Integer num4) {
        this.f23077a = num;
        this.f23078b = num2;
        this.f23079c = num3;
        this.f23080d = num4;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f23077a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.f23078b;
        if (num2 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num2.intValue());
        }
        Integer num3 = this.f23079c;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num3.intValue());
        }
        Integer num4 = this.f23080d;
        if (num4 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num4.intValue());
        }
        return bundle;
    }
}
