package t;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.LocaleList;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import java.util.ArrayList;
import t.C1780a;
import x.AbstractC1909a;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f14704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f14705b;

    public static class a {
        public static ActivityOptions a() {
            return ActivityOptions.makeBasic();
        }
    }

    public static class b {
        public static String a() {
            LocaleList adjustedDefault = LocaleList.getAdjustedDefault();
            if (adjustedDefault.size() > 0) {
                return adjustedDefault.get(0).toLanguageTag();
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: t.c$c, reason: collision with other inner class name */
    public static class C0239c {
        public static void a(ActivityOptions activityOptions, boolean z4) {
            activityOptions.setShareIdentityEnabled(z4);
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList f14708c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ActivityOptions f14709d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ArrayList f14710e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public SparseArray f14711f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Bundle f14712g;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f14715j;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f14706a = new Intent("android.intent.action.VIEW");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C1780a.C0238a f14707b = new C1780a.C0238a();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f14713h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f14714i = true;

        public c a() {
            if (!this.f14706a.hasExtra("android.support.customtabs.extra.SESSION")) {
                c(null, null);
            }
            ArrayList<? extends Parcelable> arrayList = this.f14708c;
            if (arrayList != null) {
                this.f14706a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<? extends Parcelable> arrayList2 = this.f14710e;
            if (arrayList2 != null) {
                this.f14706a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f14706a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f14714i);
            this.f14706a.putExtras(this.f14707b.a().a());
            Bundle bundle = this.f14712g;
            if (bundle != null) {
                this.f14706a.putExtras(bundle);
            }
            if (this.f14711f != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.f14711f);
                this.f14706a.putExtras(bundle2);
            }
            this.f14706a.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.f14713h);
            int i4 = Build.VERSION.SDK_INT;
            b();
            if (i4 >= 34) {
                d();
            }
            ActivityOptions activityOptions = this.f14709d;
            return new c(this.f14706a, activityOptions != null ? activityOptions.toBundle() : null);
        }

        public final void b() {
            String strA = b.a();
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            Bundle bundleExtra = this.f14706a.hasExtra("com.android.browser.headers") ? this.f14706a.getBundleExtra("com.android.browser.headers") : new Bundle();
            if (bundleExtra.containsKey("Accept-Language")) {
                return;
            }
            bundleExtra.putString("Accept-Language", strA);
            this.f14706a.putExtra("com.android.browser.headers", bundleExtra);
        }

        public final void c(IBinder iBinder, PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            bundle.putBinder("android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.f14706a.putExtras(bundle);
        }

        public final void d() {
            if (this.f14709d == null) {
                this.f14709d = a.a();
            }
            C0239c.a(this.f14709d, this.f14715j);
        }

        public d e(boolean z4) {
            this.f14706a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", z4 ? 1 : 0);
            return this;
        }
    }

    public c(Intent intent, Bundle bundle) {
        this.f14704a = intent;
        this.f14705b = bundle;
    }

    public void a(Context context, Uri uri) {
        this.f14704a.setData(uri);
        AbstractC1909a.startActivity(context, this.f14704a, this.f14705b);
    }
}
