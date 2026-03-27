package F2;

import X2.AbstractC0769p;
import X2.AbstractC0770q;
import android.app.ActivityManager;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.firebase.firestore.BuildConfig;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.r;
import r3.AbstractC1753A;
import r3.x;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements MethodChannel.MethodCallHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PackageManager f435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ActivityManager f436b;

    public c(PackageManager packageManager, ActivityManager activityManager) {
        r.f(packageManager, "packageManager");
        r.f(activityManager, "activityManager");
        this.f435a = packageManager;
        this.f436b = activityManager;
    }

    public final List a() {
        FeatureInfo[] systemAvailableFeatures = this.f435a.getSystemAvailableFeatures();
        r.e(systemAvailableFeatures, "getSystemAvailableFeatures(...)");
        ArrayList arrayList = new ArrayList();
        for (FeatureInfo featureInfo : systemAvailableFeatures) {
            if (featureInfo.name != null) {
                arrayList.add(featureInfo);
            }
        }
        ArrayList arrayList2 = new ArrayList(AbstractC0770q.q(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((FeatureInfo) it.next()).name);
        }
        return arrayList2;
    }

    public final boolean b() {
        String BRAND = Build.BRAND;
        r.e(BRAND, "BRAND");
        if (x.C(BRAND, "generic", false, 2, null)) {
            String DEVICE = Build.DEVICE;
            r.e(DEVICE, "DEVICE");
            if (x.C(DEVICE, "generic", false, 2, null)) {
                return true;
            }
        }
        String FINGERPRINT = Build.FINGERPRINT;
        r.e(FINGERPRINT, "FINGERPRINT");
        if (x.C(FINGERPRINT, "generic", false, 2, null)) {
            return true;
        }
        r.e(FINGERPRINT, "FINGERPRINT");
        if (x.C(FINGERPRINT, "unknown", false, 2, null)) {
            return true;
        }
        String HARDWARE = Build.HARDWARE;
        r.e(HARDWARE, "HARDWARE");
        if (AbstractC1753A.I(HARDWARE, "goldfish", false, 2, null)) {
            return true;
        }
        r.e(HARDWARE, "HARDWARE");
        if (AbstractC1753A.I(HARDWARE, "ranchu", false, 2, null)) {
            return true;
        }
        String MODEL = Build.MODEL;
        r.e(MODEL, "MODEL");
        if (AbstractC1753A.I(MODEL, "google_sdk", false, 2, null)) {
            return true;
        }
        r.e(MODEL, "MODEL");
        if (AbstractC1753A.I(MODEL, "Emulator", false, 2, null)) {
            return true;
        }
        r.e(MODEL, "MODEL");
        if (AbstractC1753A.I(MODEL, "Android SDK built for x86", false, 2, null)) {
            return true;
        }
        String MANUFACTURER = Build.MANUFACTURER;
        r.e(MANUFACTURER, "MANUFACTURER");
        if (AbstractC1753A.I(MANUFACTURER, "Genymotion", false, 2, null)) {
            return true;
        }
        String PRODUCT = Build.PRODUCT;
        r.e(PRODUCT, "PRODUCT");
        if (AbstractC1753A.I(PRODUCT, "sdk", false, 2, null)) {
            return true;
        }
        r.e(PRODUCT, "PRODUCT");
        if (AbstractC1753A.I(PRODUCT, "vbox86p", false, 2, null)) {
            return true;
        }
        r.e(PRODUCT, "PRODUCT");
        if (AbstractC1753A.I(PRODUCT, BuildConfig.TARGET_BACKEND, false, 2, null)) {
            return true;
        }
        r.e(PRODUCT, "PRODUCT");
        return AbstractC1753A.I(PRODUCT, "simulator", false, 2, null);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        String serial;
        r.f(call, "call");
        r.f(result, "result");
        if (!call.method.equals("getDeviceInfo")) {
            result.notImplemented();
            return;
        }
        HashMap map = new HashMap();
        map.put("board", Build.BOARD);
        map.put("bootloader", Build.BOOTLOADER);
        map.put("brand", Build.BRAND);
        map.put("device", Build.DEVICE);
        map.put(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, Build.DISPLAY);
        map.put("fingerprint", Build.FINGERPRINT);
        map.put("hardware", Build.HARDWARE);
        map.put(DiagnosticsTracker.HOST_KEY, Build.HOST);
        map.put(DiagnosticsEntry.ID_KEY, Build.ID);
        map.put("manufacturer", Build.MANUFACTURER);
        map.put("model", Build.MODEL);
        map.put("product", Build.PRODUCT);
        int i4 = Build.VERSION.SDK_INT;
        String[] strArr = Build.SUPPORTED_32_BIT_ABIS;
        map.put("supported32BitAbis", AbstractC0769p.j(Arrays.copyOf(strArr, strArr.length)));
        String[] strArr2 = Build.SUPPORTED_64_BIT_ABIS;
        map.put("supported64BitAbis", AbstractC0769p.j(Arrays.copyOf(strArr2, strArr2.length)));
        String[] strArr3 = Build.SUPPORTED_ABIS;
        map.put("supportedAbis", AbstractC0769p.j(Arrays.copyOf(strArr3, strArr3.length)));
        map.put("tags", Build.TAGS);
        map.put("type", Build.TYPE);
        map.put("isPhysicalDevice", Boolean.valueOf(!b()));
        map.put("systemFeatures", a());
        HashMap map2 = new HashMap();
        map2.put("baseOS", Build.VERSION.BASE_OS);
        map2.put("previewSdkInt", Integer.valueOf(Build.VERSION.PREVIEW_SDK_INT));
        map2.put("securityPatch", Build.VERSION.SECURITY_PATCH);
        map2.put("codename", Build.VERSION.CODENAME);
        map2.put("incremental", Build.VERSION.INCREMENTAL);
        map2.put("release", Build.VERSION.RELEASE);
        map2.put("sdkInt", Integer.valueOf(i4));
        map.put(DiagnosticsEntry.VERSION_KEY, map2);
        map.put("isLowRamDevice", Boolean.valueOf(this.f436b.isLowRamDevice()));
        if (i4 >= 26) {
            try {
                serial = Build.getSerial();
            } catch (SecurityException unused) {
                serial = "unknown";
            }
            map.put("serialNumber", serial);
        } else {
            map.put("serialNumber", Build.SERIAL);
        }
        result.success(map);
    }
}
