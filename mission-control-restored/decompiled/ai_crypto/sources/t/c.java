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
import t.C2647a;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f23085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f23086b;

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
    public static class C0362c {
        public static void a(ActivityOptions activityOptions, boolean z7) {
            activityOptions.setShareIdentityEnabled(z7);
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList f23089c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ActivityOptions f23090d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ArrayList f23091e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public SparseArray f23092f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Bundle f23093g;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f23096j;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f23087a = new Intent("android.intent.action.VIEW");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C2647a.C0361a f23088b = new C2647a.C0361a();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f23094h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f23095i = true;

        public c a() {
            if (!this.f23087a.hasExtra("android.support.customtabs.extra.SESSION")) {
                c(null, null);
            }
            ArrayList<? extends Parcelable> arrayList = this.f23089c;
            if (arrayList != null) {
                this.f23087a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<? extends Parcelable> arrayList2 = this.f23091e;
            if (arrayList2 != null) {
                this.f23087a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f23087a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f23095i);
            this.f23087a.putExtras(this.f23088b.a().a());
            Bundle bundle = this.f23093g;
            if (bundle != null) {
                this.f23087a.putExtras(bundle);
            }
            if (this.f23092f != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.f23092f);
                this.f23087a.putExtras(bundle2);
            }
            this.f23087a.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.f23094h);
            int i7 = Build.VERSION.SDK_INT;
            b();
            if (i7 >= 34) {
                d();
            }
            ActivityOptions activityOptions = this.f23090d;
            return new c(this.f23087a, activityOptions != null ? activityOptions.toBundle() : null);
        }

        public final void b() {
            String strA = b.a();
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            Bundle bundleExtra = this.f23087a.hasExtra("com.android.browser.headers") ? this.f23087a.getBundleExtra("com.android.browser.headers") : new Bundle();
            if (bundleExtra.containsKey("Accept-Language")) {
                return;
            }
            bundleExtra.putString("Accept-Language", strA);
            this.f23087a.putExtra("com.android.browser.headers", bundleExtra);
        }

        public final void c(IBinder iBinder, PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            bundle.putBinder("android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.f23087a.putExtras(bundle);
        }

        public final void d() {
            if (this.f23090d == null) {
                this.f23090d = a.a();
            }
            C0362c.a(this.f23090d, this.f23096j);
        }

        public d e(boolean z7) {
            this.f23087a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", z7 ? 1 : 0);
            return this;
        }
    }

    public c(Intent intent, Bundle bundle) {
        this.f23085a = intent;
        this.f23086b = bundle;
    }

    public void a(Context context, Uri uri) {
        this.f23085a.setData(uri);
        G.a.startActivity(context, this.f23085a, this.f23086b);
    }
}
