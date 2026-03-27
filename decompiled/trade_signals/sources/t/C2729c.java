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
import t.C2727a;

/* JADX INFO: renamed from: t.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2729c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f23275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f23276b;

    /* JADX INFO: renamed from: t.c$a */
    public static class a {
        public static ActivityOptions a() {
            return ActivityOptions.makeBasic();
        }
    }

    /* JADX INFO: renamed from: t.c$b */
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
    public static class C0401c {
        public static void a(ActivityOptions activityOptions, boolean z7) {
            activityOptions.setShareIdentityEnabled(z7);
        }
    }

    /* JADX INFO: renamed from: t.c$d */
    public static final class d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList f23279c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ActivityOptions f23280d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ArrayList f23281e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public SparseArray f23282f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Bundle f23283g;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f23286j;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f23277a = new Intent("android.intent.action.VIEW");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C2727a.C0400a f23278b = new C2727a.C0400a();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f23284h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f23285i = true;

        public C2729c a() {
            if (!this.f23277a.hasExtra("android.support.customtabs.extra.SESSION")) {
                c(null, null);
            }
            ArrayList<? extends Parcelable> arrayList = this.f23279c;
            if (arrayList != null) {
                this.f23277a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<? extends Parcelable> arrayList2 = this.f23281e;
            if (arrayList2 != null) {
                this.f23277a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f23277a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f23285i);
            this.f23277a.putExtras(this.f23278b.a().a());
            Bundle bundle = this.f23283g;
            if (bundle != null) {
                this.f23277a.putExtras(bundle);
            }
            if (this.f23282f != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.f23282f);
                this.f23277a.putExtras(bundle2);
            }
            this.f23277a.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.f23284h);
            int i8 = Build.VERSION.SDK_INT;
            b();
            if (i8 >= 34) {
                d();
            }
            ActivityOptions activityOptions = this.f23280d;
            return new C2729c(this.f23277a, activityOptions != null ? activityOptions.toBundle() : null);
        }

        public final void b() {
            String strA = b.a();
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            Bundle bundleExtra = this.f23277a.hasExtra("com.android.browser.headers") ? this.f23277a.getBundleExtra("com.android.browser.headers") : new Bundle();
            if (bundleExtra.containsKey("Accept-Language")) {
                return;
            }
            bundleExtra.putString("Accept-Language", strA);
            this.f23277a.putExtra("com.android.browser.headers", bundleExtra);
        }

        public final void c(IBinder iBinder, PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            bundle.putBinder("android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.f23277a.putExtras(bundle);
        }

        public final void d() {
            if (this.f23280d == null) {
                this.f23280d = a.a();
            }
            C0401c.a(this.f23280d, this.f23286j);
        }

        public d e(boolean z7) {
            this.f23277a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", z7 ? 1 : 0);
            return this;
        }
    }

    public C2729c(Intent intent, Bundle bundle) {
        this.f23275a = intent;
        this.f23276b = bundle;
    }

    public void a(Context context, Uri uri) {
        this.f23275a.setData(uri);
        I.a.m(context, this.f23275a, this.f23276b);
    }
}
