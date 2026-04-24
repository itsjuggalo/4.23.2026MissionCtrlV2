package io.flutter.plugins.urllauncher;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import io.flutter.plugins.urllauncher.Messages;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import t.AbstractC2728b;
import t.C2729c;

/* JADX INFO: loaded from: classes.dex */
final class UrlLauncher implements Messages.UrlLauncherApi {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "UrlLauncher";
    private Activity activity;
    private final Context applicationContext;
    private final IntentResolver intentResolver;

    public interface IntentResolver {
        String getHandlerComponentName(Intent intent);
    }

    public UrlLauncher(final Context context) {
        this(context, new IntentResolver() { // from class: io.flutter.plugins.urllauncher.f
            @Override // io.flutter.plugins.urllauncher.UrlLauncher.IntentResolver
            public final String getHandlerComponentName(Intent intent) {
                return UrlLauncher.lambda$new$0(context, intent);
            }
        });
    }

    private static boolean containsRestrictedHeader(Map<String, String> map) {
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String lowerCase = it.next().toLowerCase(Locale.US);
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

    private void ensureActivity() {
        if (this.activity == null) {
            throw new Messages.FlutterError("NO_ACTIVITY", "Launching a URL requires a foreground activity.", null);
        }
    }

    private static Bundle extractBundle(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            bundle.putString(str, map.get(str));
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$new$0(Context context, Intent intent) {
        ComponentName componentNameResolveActivity = intent.resolveActivity(context.getPackageManager());
        if (componentNameResolveActivity == null) {
            return null;
        }
        return componentNameResolveActivity.toShortString();
    }

    private static boolean openCustomTab(Context context, Uri uri, Bundle bundle, Messages.BrowserOptions browserOptions) {
        C2729c c2729cA = new C2729c.d().e(browserOptions.getShowTitle().booleanValue()).a();
        c2729cA.f23275a.putExtra("com.android.browser.headers", bundle);
        try {
            c2729cA.a(context, uri);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    @Override // io.flutter.plugins.urllauncher.Messages.UrlLauncherApi
    public Boolean canLaunchUrl(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        return this.intentResolver.getHandlerComponentName(intent) == null ? Boolean.FALSE : Boolean.valueOf(!"{com.android.fallback/com.android.fallback.Fallback}".equals(r3));
    }

    @Override // io.flutter.plugins.urllauncher.Messages.UrlLauncherApi
    public void closeWebView() {
        this.applicationContext.sendBroadcast(new Intent(WebViewActivity.ACTION_CLOSE));
    }

    @Override // io.flutter.plugins.urllauncher.Messages.UrlLauncherApi
    public Boolean launchUrl(String str, Map<String, String> map) {
        ensureActivity();
        try {
            this.activity.startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse(str)).putExtra("com.android.browser.headers", extractBundle(map)));
            return Boolean.TRUE;
        } catch (ActivityNotFoundException unused) {
            return Boolean.FALSE;
        }
    }

    @Override // io.flutter.plugins.urllauncher.Messages.UrlLauncherApi
    public Boolean openUrlInApp(String str, Boolean bool, Messages.WebViewOptions webViewOptions, Messages.BrowserOptions browserOptions) {
        ensureActivity();
        Bundle bundleExtractBundle = extractBundle(webViewOptions.getHeaders());
        if (bool.booleanValue() && !containsRestrictedHeader(webViewOptions.getHeaders())) {
            if (openCustomTab(this.activity, Uri.parse(str), bundleExtractBundle, browserOptions)) {
                return Boolean.TRUE;
            }
        }
        try {
            this.activity.startActivity(WebViewActivity.createIntent(this.activity, str, webViewOptions.getEnableJavaScript().booleanValue(), webViewOptions.getEnableDomStorage().booleanValue(), bundleExtractBundle));
            return Boolean.TRUE;
        } catch (ActivityNotFoundException unused) {
            return Boolean.FALSE;
        }
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override // io.flutter.plugins.urllauncher.Messages.UrlLauncherApi
    public Boolean supportsCustomTabs() {
        return Boolean.valueOf(AbstractC2728b.a(this.applicationContext, Collections.emptyList()) != null);
    }

    public UrlLauncher(Context context, IntentResolver intentResolver) {
        this.applicationContext = context;
        this.intentResolver = intentResolver;
    }
}
