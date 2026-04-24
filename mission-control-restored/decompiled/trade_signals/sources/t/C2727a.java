package t;

import android.os.Bundle;

/* JADX INFO: renamed from: t.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2727a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f23267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f23268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f23269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f23270d;

    /* JADX INFO: renamed from: t.a$a, reason: collision with other inner class name */
    public static final class C0400a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f23271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f23272b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f23273c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f23274d;

        public C2727a a() {
            return new C2727a(this.f23271a, this.f23272b, this.f23273c, this.f23274d);
        }
    }

    public C2727a(Integer num, Integer num2, Integer num3, Integer num4) {
        this.f23267a = num;
        this.f23268b = num2;
        this.f23269c = num3;
        this.f23270d = num4;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f23267a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.f23268b;
        if (num2 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num2.intValue());
        }
        Integer num3 = this.f23269c;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num3.intValue());
        }
        Integer num4 = this.f23270d;
        if (num4 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num4.intValue());
        }
        return bundle;
    }
}
