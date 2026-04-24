package o5;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import io.flutter.plugins.urllauncher.WebViewActivity;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import o5.AbstractC2323a;
import t.c;

/* JADX INFO: renamed from: o5.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2330h implements AbstractC2323a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f20223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f20224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Activity f20225c;

    /* JADX INFO: renamed from: o5.h$a */
    public interface a {
        String a(Intent intent);
    }

    public C2330h(Context context, a aVar) {
        this.f20223a = context;
        this.f20224b = aVar;
    }

    public static boolean t(Map map) {
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            String lowerCase = ((String) it.next()).toLowerCase(Locale.US);
            lowerCase.hashCode();
            switch (lowerCase) {
                case "accept":
                case "content-language":
                case "content-type":
                case "accept-language":
                    break;
                default:
                    return true;
            }
        }
        return false;
    }

    public static Bundle v(Map map) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            bundle.putString(str, (String) map.get(str));
        }
        return bundle;
    }

    public static /* synthetic */ String w(Context context, Intent intent) {
        ComponentName componentNameResolveActivity = intent.resolveActivity(context.getPackageManager());
        if (componentNameResolveActivity == null) {
            return null;
        }
        return componentNameResolveActivity.toShortString();
    }

    public static boolean x(Context context, Uri uri, Bundle bundle, AbstractC2323a.C0332a c0332a) {
        t.c cVarA = new c.d().e(c0332a.b().booleanValue()).a();
        cVarA.f23085a.putExtra("com.android.browser.headers", bundle);
        try {
            cVarA.a(context, uri);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    @Override // o5.AbstractC2323a.d
    public Boolean c(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        return this.f20224b.a(intent) == null ? Boolean.FALSE : Boolean.valueOf(!"{com.android.fallback/com.android.fallback.Fallback}".equals(r3));
    }

    @Override // o5.AbstractC2323a.d
    public Boolean j() {
        return Boolean.valueOf(t.b.a(this.f20223a, Collections.emptyList()) != null);
    }

    @Override // o5.AbstractC2323a.d
    public Boolean o(String str, Boolean bool, AbstractC2323a.e eVar, AbstractC2323a.C0332a c0332a) {
        u();
        Bundle bundleV = v(eVar.d());
        if (bool.booleanValue() && !t(eVar.d())) {
            if (x(this.f20225c, Uri.parse(str), bundleV, c0332a)) {
                return Boolean.TRUE;
            }
        }
        try {
            this.f20225c.startActivity(WebViewActivity.a(this.f20225c, str, eVar.c().booleanValue(), eVar.b().booleanValue(), bundleV));
            return Boolean.TRUE;
        } catch (ActivityNotFoundException unused) {
            return Boolean.FALSE;
        }
    }

    @Override // o5.AbstractC2323a.d
    public void p() {
        this.f20223a.sendBroadcast(new Intent("close action"));
    }

    @Override // o5.AbstractC2323a.d
    public Boolean q(String str, Map map) {
        u();
        try {
            this.f20225c.startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse(str)).putExtra("com.android.browser.headers", v(map)));
            return Boolean.TRUE;
        } catch (ActivityNotFoundException unused) {
            return Boolean.FALSE;
        }
    }

    public final void u() {
        if (this.f20225c == null) {
            throw new AbstractC2323a.b("NO_ACTIVITY", "Launching a URL requires a foreground activity.", null);
        }
    }

    public void y(Activity activity) {
        this.f20225c = activity;
    }

    public C2330h(final Context context) {
        this(context, new a() { // from class: o5.g
            @Override // o5.C2330h.a
            public final String a(Intent intent) {
                return C2330h.w(context, intent);
            }
        });
    }
}
