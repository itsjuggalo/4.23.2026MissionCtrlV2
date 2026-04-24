package G4;

import F5.AbstractC0556n;
import F5.AbstractC0557o;
import V4.i;
import V4.j;
import android.app.ActivityManager;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements j.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PackageManager f2499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ActivityManager f2500d;

    public c(PackageManager packageManager, ActivityManager activityManager) {
        r.f(packageManager, "packageManager");
        r.f(activityManager, "activityManager");
        this.f2499c = packageManager;
        this.f2500d = activityManager;
    }

    public final List a() {
        FeatureInfo[] systemAvailableFeatures = this.f2499c.getSystemAvailableFeatures();
        r.e(systemAvailableFeatures, "getSystemAvailableFeatures(...)");
        ArrayList arrayList = new ArrayList();
        for (FeatureInfo featureInfo : systemAvailableFeatures) {
            if (featureInfo.name != null) {
                arrayList.add(featureInfo);
            }
        }
        ArrayList arrayList2 = new ArrayList(AbstractC0557o.q(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((FeatureInfo) it.next()).name);
        }
        return arrayList2;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b() {
        /*
            r6 = this;
            java.lang.String r0 = android.os.Build.BRAND
            java.lang.String r1 = "BRAND"
            kotlin.jvm.internal.r.e(r0, r1)
            java.lang.String r1 = "generic"
            r2 = 0
            r3 = 2
            r4 = 0
            boolean r0 = Z5.t.y(r0, r1, r2, r3, r4)
            if (r0 == 0) goto L1f
            java.lang.String r0 = android.os.Build.DEVICE
            java.lang.String r5 = "DEVICE"
            kotlin.jvm.internal.r.e(r0, r5)
            boolean r0 = Z5.t.y(r0, r1, r2, r3, r4)
            if (r0 != 0) goto Lb5
        L1f:
            java.lang.String r0 = android.os.Build.FINGERPRINT
            java.lang.String r5 = "FINGERPRINT"
            kotlin.jvm.internal.r.e(r0, r5)
            boolean r1 = Z5.t.y(r0, r1, r2, r3, r4)
            if (r1 != 0) goto Lb5
            kotlin.jvm.internal.r.e(r0, r5)
            java.lang.String r1 = "unknown"
            boolean r0 = Z5.t.y(r0, r1, r2, r3, r4)
            if (r0 != 0) goto Lb5
            java.lang.String r0 = android.os.Build.HARDWARE
            java.lang.String r1 = "HARDWARE"
            kotlin.jvm.internal.r.e(r0, r1)
            java.lang.String r5 = "goldfish"
            boolean r5 = Z5.u.D(r0, r5, r2, r3, r4)
            if (r5 != 0) goto Lb5
            kotlin.jvm.internal.r.e(r0, r1)
            java.lang.String r1 = "ranchu"
            boolean r0 = Z5.u.D(r0, r1, r2, r3, r4)
            if (r0 != 0) goto Lb5
            java.lang.String r0 = android.os.Build.MODEL
            java.lang.String r1 = "MODEL"
            kotlin.jvm.internal.r.e(r0, r1)
            java.lang.String r5 = "google_sdk"
            boolean r5 = Z5.u.D(r0, r5, r2, r3, r4)
            if (r5 != 0) goto Lb5
            kotlin.jvm.internal.r.e(r0, r1)
            java.lang.String r5 = "Emulator"
            boolean r5 = Z5.u.D(r0, r5, r2, r3, r4)
            if (r5 != 0) goto Lb5
            kotlin.jvm.internal.r.e(r0, r1)
            java.lang.String r1 = "Android SDK built for x86"
            boolean r0 = Z5.u.D(r0, r1, r2, r3, r4)
            if (r0 != 0) goto Lb5
            java.lang.String r0 = android.os.Build.MANUFACTURER
            java.lang.String r1 = "MANUFACTURER"
            kotlin.jvm.internal.r.e(r0, r1)
            java.lang.String r1 = "Genymotion"
            boolean r0 = Z5.u.D(r0, r1, r2, r3, r4)
            if (r0 != 0) goto Lb5
            java.lang.String r0 = android.os.Build.PRODUCT
            java.lang.String r1 = "PRODUCT"
            kotlin.jvm.internal.r.e(r0, r1)
            java.lang.String r5 = "sdk"
            boolean r5 = Z5.u.D(r0, r5, r2, r3, r4)
            if (r5 != 0) goto Lb5
            kotlin.jvm.internal.r.e(r0, r1)
            java.lang.String r5 = "vbox86p"
            boolean r5 = Z5.u.D(r0, r5, r2, r3, r4)
            if (r5 != 0) goto Lb5
            kotlin.jvm.internal.r.e(r0, r1)
            java.lang.String r5 = "emulator"
            boolean r5 = Z5.u.D(r0, r5, r2, r3, r4)
            if (r5 != 0) goto Lb5
            kotlin.jvm.internal.r.e(r0, r1)
            java.lang.String r1 = "simulator"
            boolean r0 = Z5.u.D(r0, r1, r2, r3, r4)
            if (r0 == 0) goto Lb6
        Lb5:
            r2 = 1
        Lb6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: G4.c.b():boolean");
    }

    @Override // V4.j.c
    public void onMethodCall(i call, j.d result) {
        String serial;
        r.f(call, "call");
        r.f(result, "result");
        if (!call.f5332a.equals("getDeviceInfo")) {
            result.c();
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
        int i7 = Build.VERSION.SDK_INT;
        String[] strArr = Build.SUPPORTED_32_BIT_ABIS;
        map.put("supported32BitAbis", AbstractC0556n.j(Arrays.copyOf(strArr, strArr.length)));
        String[] strArr2 = Build.SUPPORTED_64_BIT_ABIS;
        map.put("supported64BitAbis", AbstractC0556n.j(Arrays.copyOf(strArr2, strArr2.length)));
        String[] strArr3 = Build.SUPPORTED_ABIS;
        map.put("supportedAbis", AbstractC0556n.j(Arrays.copyOf(strArr3, strArr3.length)));
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
        map2.put("sdkInt", Integer.valueOf(i7));
        map.put(DiagnosticsEntry.VERSION_KEY, map2);
        map.put("isLowRamDevice", Boolean.valueOf(this.f2500d.isLowRamDevice()));
        if (i7 >= 26) {
            try {
                serial = Build.getSerial();
            } catch (SecurityException unused) {
                serial = "unknown";
            }
            map.put("serialNumber", serial);
        } else {
            map.put("serialNumber", Build.SERIAL);
        }
        result.a(map);
    }
}
