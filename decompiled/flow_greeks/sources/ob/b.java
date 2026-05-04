package ob;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import dd.r;
import dd.s;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.database.FlutterFirebaseDatabaseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kg.c0;
import kg.z;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements MethodChannel.MethodCallHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PackageManager f17700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ActivityManager f17701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ContentResolver f17702c;

    public b(PackageManager packageManager, ActivityManager activityManager, ContentResolver contentResolver) {
        t.f(packageManager, "packageManager");
        t.f(activityManager, "activityManager");
        t.f(contentResolver, "contentResolver");
        this.f17700a = packageManager;
        this.f17701b = activityManager;
        this.f17702c = contentResolver;
    }

    public final List a() {
        FeatureInfo[] systemAvailableFeatures = this.f17700a.getSystemAvailableFeatures();
        t.e(systemAvailableFeatures, "getSystemAvailableFeatures(...)");
        ArrayList arrayList = new ArrayList();
        for (FeatureInfo featureInfo : systemAvailableFeatures) {
            if (featureInfo.name != null) {
                arrayList.add(featureInfo);
            }
        }
        ArrayList arrayList2 = new ArrayList(s.u(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((FeatureInfo) it.next()).name);
        }
        return arrayList2;
    }

    public final boolean b() {
        String BRAND = Build.BRAND;
        t.e(BRAND, "BRAND");
        if (z.J(BRAND, "generic", false, 2, null)) {
            String DEVICE = Build.DEVICE;
            t.e(DEVICE, "DEVICE");
            if (z.J(DEVICE, "generic", false, 2, null)) {
                return true;
            }
        }
        String FINGERPRINT = Build.FINGERPRINT;
        t.e(FINGERPRINT, "FINGERPRINT");
        if (z.J(FINGERPRINT, "generic", false, 2, null)) {
            return true;
        }
        t.e(FINGERPRINT, "FINGERPRINT");
        if (z.J(FINGERPRINT, FlutterFirebaseDatabaseException.UNKNOWN_ERROR_CODE, false, 2, null)) {
            return true;
        }
        String HARDWARE = Build.HARDWARE;
        t.e(HARDWARE, "HARDWARE");
        if (c0.P(HARDWARE, "goldfish", false, 2, null)) {
            return true;
        }
        t.e(HARDWARE, "HARDWARE");
        if (c0.P(HARDWARE, "ranchu", false, 2, null)) {
            return true;
        }
        String MODEL = Build.MODEL;
        t.e(MODEL, "MODEL");
        if (c0.P(MODEL, "google_sdk", false, 2, null)) {
            return true;
        }
        t.e(MODEL, "MODEL");
        if (c0.P(MODEL, "Emulator", false, 2, null)) {
            return true;
        }
        t.e(MODEL, "MODEL");
        if (c0.P(MODEL, "Android SDK built for x86", false, 2, null)) {
            return true;
        }
        String MANUFACTURER = Build.MANUFACTURER;
        t.e(MANUFACTURER, "MANUFACTURER");
        if (c0.P(MANUFACTURER, "Genymotion", false, 2, null)) {
            return true;
        }
        String PRODUCT = Build.PRODUCT;
        t.e(PRODUCT, "PRODUCT");
        if (c0.P(PRODUCT, "sdk", false, 2, null)) {
            return true;
        }
        t.e(PRODUCT, "PRODUCT");
        if (c0.P(PRODUCT, "vbox86p", false, 2, null)) {
            return true;
        }
        t.e(PRODUCT, "PRODUCT");
        if (c0.P(PRODUCT, "emulator", false, 2, null)) {
            return true;
        }
        t.e(PRODUCT, "PRODUCT");
        return c0.P(PRODUCT, "simulator", false, 2, null);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        t.f(call, "call");
        t.f(result, "result");
        if (!call.method.equals("getDeviceInfo")) {
            result.notImplemented();
            return;
        }
        HashMap map = new HashMap();
        map.put("board", Build.BOARD);
        map.put("bootloader", Build.BOOTLOADER);
        map.put("brand", Build.BRAND);
        map.put("device", Build.DEVICE);
        map.put("display", Build.DISPLAY);
        map.put("fingerprint", Build.FINGERPRINT);
        map.put("hardware", Build.HARDWARE);
        map.put(DiagnosticsTracker.HOST_KEY, Build.HOST);
        map.put(DiagnosticsEntry.ID_KEY, Build.ID);
        map.put("manufacturer", Build.MANUFACTURER);
        map.put("model", Build.MODEL);
        map.put("product", Build.PRODUCT);
        int i10 = Build.VERSION.SDK_INT;
        String string = Settings.Global.getString(this.f17702c, "device_name");
        if (string == null) {
            string = "";
        }
        map.put("name", string);
        String[] strArr = Build.SUPPORTED_32_BIT_ABIS;
        map.put("supported32BitAbis", r.n(Arrays.copyOf(strArr, strArr.length)));
        String[] strArr2 = Build.SUPPORTED_64_BIT_ABIS;
        map.put("supported64BitAbis", r.n(Arrays.copyOf(strArr2, strArr2.length)));
        String[] strArr3 = Build.SUPPORTED_ABIS;
        map.put("supportedAbis", r.n(Arrays.copyOf(strArr3, strArr3.length)));
        map.put("tags", Build.TAGS);
        map.put("type", Build.TYPE);
        map.put("isPhysicalDevice", Boolean.valueOf(!b()));
        map.put("systemFeatures", a());
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        map.put("freeDiskSize", Long.valueOf(statFs.getFreeBytes()));
        map.put("totalDiskSize", Long.valueOf(statFs.getTotalBytes()));
        HashMap map2 = new HashMap();
        map2.put("baseOS", Build.VERSION.BASE_OS);
        map2.put("previewSdkInt", Integer.valueOf(Build.VERSION.PREVIEW_SDK_INT));
        map2.put("securityPatch", Build.VERSION.SECURITY_PATCH);
        map2.put("codename", Build.VERSION.CODENAME);
        map2.put("incremental", Build.VERSION.INCREMENTAL);
        map2.put("release", Build.VERSION.RELEASE);
        map2.put("sdkInt", Integer.valueOf(i10));
        map.put(DiagnosticsEntry.VERSION_KEY, map2);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        this.f17701b.getMemoryInfo(memoryInfo);
        map.put("isLowRamDevice", Boolean.valueOf(memoryInfo.lowMemory));
        map.put("physicalRamSize", Long.valueOf(memoryInfo.totalMem / 1048576));
        map.put("availableRamSize", Long.valueOf(memoryInfo.availMem / 1048576));
        result.success(map);
    }
}
