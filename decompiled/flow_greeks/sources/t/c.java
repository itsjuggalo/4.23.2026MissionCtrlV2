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
import t.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f20444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f20445b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {
        public static ActivityOptions a() {
            return ActivityOptions.makeBasic();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0362c {
        public static void a(ActivityOptions activityOptions, boolean z10) {
            activityOptions.setShareIdentityEnabled(z10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList f20448c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ActivityOptions f20449d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ArrayList f20450e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public SparseArray f20451f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Bundle f20452g;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f20455j;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f20446a = new Intent("android.intent.action.VIEW");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a.C0361a f20447b = new a.C0361a();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f20453h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f20454i = true;

        public c a() {
            if (!this.f20446a.hasExtra("android.support.customtabs.extra.SESSION")) {
                c(null, null);
            }
            ArrayList<? extends Parcelable> arrayList = this.f20448c;
            if (arrayList != null) {
                this.f20446a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<? extends Parcelable> arrayList2 = this.f20450e;
            if (arrayList2 != null) {
                this.f20446a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f20446a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f20454i);
            this.f20446a.putExtras(this.f20447b.a().a());
            Bundle bundle = this.f20452g;
            if (bundle != null) {
                this.f20446a.putExtras(bundle);
            }
            if (this.f20451f != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.f20451f);
                this.f20446a.putExtras(bundle2);
            }
            this.f20446a.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.f20453h);
            int i10 = Build.VERSION.SDK_INT;
            b();
            if (i10 >= 34) {
                d();
            }
            ActivityOptions activityOptions = this.f20449d;
            return new c(this.f20446a, activityOptions != null ? activityOptions.toBundle() : null);
        }

        public final void b() {
            String strA = b.a();
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            Bundle bundleExtra = this.f20446a.hasExtra("com.android.browser.headers") ? this.f20446a.getBundleExtra("com.android.browser.headers") : new Bundle();
            if (bundleExtra.containsKey("Accept-Language")) {
                return;
            }
            bundleExtra.putString("Accept-Language", strA);
            this.f20446a.putExtra("com.android.browser.headers", bundleExtra);
        }

        public final void c(IBinder iBinder, PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            bundle.putBinder("android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.f20446a.putExtras(bundle);
        }

        public final void d() {
            if (this.f20449d == null) {
                this.f20449d = a.a();
            }
            C0362c.a(this.f20449d, this.f20455j);
        }

        public d e(boolean z10) {
            this.f20446a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", z10 ? 1 : 0);
            return this;
        }
    }

    public c(Intent intent, Bundle bundle) {
        this.f20444a = intent;
        this.f20445b = bundle;
    }

    public void a(Context context, Uri uri) {
        this.f20444a.setData(uri);
        i0.a.n(context, this.f20444a, this.f20445b);
    }
}
