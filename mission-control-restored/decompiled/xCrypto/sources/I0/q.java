package I0;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import w.AbstractC1897a;
import x.AbstractC1909a;

/* JADX INFO: loaded from: classes.dex */
public final class q implements PluginRegistry.ActivityResultListener, PluginRegistry.RequestPermissionsResultListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Activity f846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map f848e;

    public interface a {
        void onSuccess(int i4);
    }

    public interface b {
        void a(Map map);
    }

    public interface c {
        void a(boolean z4);
    }

    public q(Context context) {
        this.f844a = context;
    }

    public final int a() {
        List listC = u.c(this.f844a, 21);
        if (listC != null && !listC.isEmpty()) {
            return 1;
        }
        Log.d("permissions_handler", "Bluetooth permission missing in manifest");
        return 0;
    }

    public final int b() {
        if (Build.VERSION.SDK_INT < 33) {
            return w.p.e(this.f844a).a() ? 1 : 0;
        }
        if (this.f844a.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0) {
            return 1;
        }
        return u.b(this.f846c, "android.permission.POST_NOTIFICATIONS");
    }

    public void c(int i4, a aVar) {
        aVar.onSuccess(d(i4));
    }

    public final int d(int i4) {
        if (i4 == 17) {
            return b();
        }
        if (i4 == 21) {
            return a();
        }
        if ((i4 == 30 || i4 == 28 || i4 == 29) && Build.VERSION.SDK_INT < 31) {
            return a();
        }
        if ((i4 == 37 || i4 == 0) && !e()) {
            return 0;
        }
        List<String> listC = u.c(this.f844a, i4);
        if (listC == null) {
            Log.d("permissions_handler", "No android specific permissions needed for: " + i4);
            return 1;
        }
        if (listC.size() == 0) {
            Log.d("permissions_handler", "No permissions found in manifest for: " + listC + i4);
            return (i4 != 22 || Build.VERSION.SDK_INT >= 30) ? 0 : 2;
        }
        if (this.f844a.getApplicationInfo().targetSdkVersion >= 23) {
            HashSet hashSet = new HashSet();
            for (String str : listC) {
                if (i4 == 16) {
                    String packageName = this.f844a.getPackageName();
                    PowerManager powerManager = (PowerManager) this.f844a.getSystemService("power");
                    if (powerManager == null || !powerManager.isIgnoringBatteryOptimizations(packageName)) {
                        hashSet.add(0);
                    } else {
                        hashSet.add(1);
                    }
                } else if (i4 == 22) {
                    if (Build.VERSION.SDK_INT < 30) {
                        hashSet.add(2);
                    }
                    hashSet.add(Integer.valueOf(Environment.isExternalStorageManager() ? 1 : 0));
                } else if (i4 == 23) {
                    hashSet.add(Integer.valueOf(Settings.canDrawOverlays(this.f844a) ? 1 : 0));
                } else if (i4 == 24) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        hashSet.add(Integer.valueOf(this.f844a.getPackageManager().canRequestPackageInstalls() ? 1 : 0));
                    }
                } else if (i4 == 27) {
                    hashSet.add(Integer.valueOf(((NotificationManager) this.f844a.getSystemService("notification")).isNotificationPolicyAccessGranted() ? 1 : 0));
                } else if (i4 == 34) {
                    if (Build.VERSION.SDK_INT >= 31) {
                        hashSet.add(Integer.valueOf(((AlarmManager) this.f844a.getSystemService("alarm")).canScheduleExactAlarms() ? 1 : 0));
                    } else {
                        hashSet.add(1);
                    }
                } else if (i4 == 9 || i4 == 32) {
                    int iCheckSelfPermission = AbstractC1909a.checkSelfPermission(this.f844a, str);
                    if ((Build.VERSION.SDK_INT >= 34 ? AbstractC1909a.checkSelfPermission(this.f844a, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED") : iCheckSelfPermission) == 0 && iCheckSelfPermission == -1) {
                        hashSet.add(3);
                    } else if (iCheckSelfPermission == 0) {
                        hashSet.add(1);
                    } else {
                        hashSet.add(Integer.valueOf(u.b(this.f846c, str)));
                    }
                } else if (AbstractC1909a.checkSelfPermission(this.f844a, str) != 0) {
                    hashSet.add(Integer.valueOf(u.b(this.f846c, str)));
                }
            }
            if (!hashSet.isEmpty()) {
                return u.j(hashSet).intValue();
            }
        }
        return 1;
    }

    public final boolean e() {
        List listC = u.c(this.f844a, 37);
        boolean z4 = listC != null && listC.contains("android.permission.WRITE_CALENDAR");
        boolean z5 = listC != null && listC.contains("android.permission.READ_CALENDAR");
        if (z4 && z5) {
            return true;
        }
        if (!z4) {
            Log.d("permissions_handler", "android.permission.WRITE_CALENDAR missing in manifest");
        }
        if (!z5) {
            Log.d("permissions_handler", "android.permission.READ_CALENDAR missing in manifest");
        }
        return false;
    }

    public final void f(String str, int i4) {
        if (this.f846c == null) {
            return;
        }
        Intent intent = new Intent(str);
        if (!str.equals("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS")) {
            intent.setData(Uri.parse("package:" + this.f846c.getPackageName()));
        }
        this.f846c.startActivityForResult(intent, i4);
        this.f847d++;
    }

    public void g(List list, b bVar, I0.b bVar2) {
        if (this.f847d > 0) {
            bVar2.a("PermissionHandler.PermissionManager", "A request for permissions is already running, please wait for it to finish before doing another request (note that you can request multiple permissions at the same time).");
            return;
        }
        if (this.f846c == null) {
            Log.d("permissions_handler", "Unable to detect current Activity.");
            bVar2.a("PermissionHandler.PermissionManager", "Unable to detect current Android Activity.");
            return;
        }
        this.f845b = bVar;
        this.f848e = new HashMap();
        this.f847d = 0;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (d(num.intValue()) != 1) {
                List listC = u.c(this.f846c, num.intValue());
                if (listC != null && !listC.isEmpty()) {
                    int i4 = Build.VERSION.SDK_INT;
                    if (num.intValue() == 16) {
                        f("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS", 209);
                    } else if (i4 >= 30 && num.intValue() == 22) {
                        f("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION", 210);
                    } else if (num.intValue() == 23) {
                        f("android.settings.action.MANAGE_OVERLAY_PERMISSION", 211);
                    } else if (i4 >= 26 && num.intValue() == 24) {
                        f("android.settings.MANAGE_UNKNOWN_APP_SOURCES", 212);
                    } else if (num.intValue() == 27) {
                        f("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS", 213);
                    } else if (i4 >= 31 && num.intValue() == 34) {
                        f("android.settings.REQUEST_SCHEDULE_EXACT_ALARM", 214);
                    } else if (num.intValue() != 37 && num.intValue() != 0) {
                        arrayList.addAll(listC);
                        this.f847d += listC.size();
                    } else if (e()) {
                        arrayList.add("android.permission.WRITE_CALENDAR");
                        arrayList.add("android.permission.READ_CALENDAR");
                        this.f847d += 2;
                    } else {
                        this.f848e.put(num, 0);
                    }
                } else if (!this.f848e.containsKey(num)) {
                    this.f848e.put(num, 0);
                    if (num.intValue() != 22 || Build.VERSION.SDK_INT >= 30) {
                        this.f848e.put(num, 0);
                    } else {
                        this.f848e.put(num, 2);
                    }
                }
            } else if (!this.f848e.containsKey(num)) {
                this.f848e.put(num, 1);
            }
        }
        if (arrayList.size() > 0) {
            AbstractC1897a.c(this.f846c, (String[]) arrayList.toArray(new String[0]), 24);
        }
        b bVar3 = this.f845b;
        if (bVar3 == null || this.f847d != 0) {
            return;
        }
        bVar3.a(this.f848e);
    }

    public void h(Activity activity) {
        this.f846c = activity;
    }

    public void i(int i4, c cVar, I0.b bVar) {
        Activity activity = this.f846c;
        if (activity == null) {
            Log.d("permissions_handler", "Unable to detect current Activity.");
            bVar.a("PermissionHandler.PermissionManager", "Unable to detect current Android Activity.");
            return;
        }
        List listC = u.c(activity, i4);
        if (listC == null) {
            Log.d("permissions_handler", "No android specific permissions needed for: " + i4);
            cVar.a(false);
            return;
        }
        if (!listC.isEmpty()) {
            cVar.a(AbstractC1897a.f(this.f846c, (String) listC.get(0)));
            return;
        }
        Log.d("permissions_handler", "No permissions found in manifest for: " + i4 + " no need to show request rationale");
        cVar.a(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public boolean onActivityResult(int i4, int i5, Intent intent) {
        int i6;
        int iCanScheduleExactAlarms;
        Activity activity = this.f846c;
        boolean z4 = false;
        z4 = false;
        if (activity == null) {
            return false;
        }
        if (this.f848e == null) {
            this.f847d = 0;
            return false;
        }
        if (i4 == 209) {
            String packageName = this.f844a.getPackageName();
            PowerManager powerManager = (PowerManager) this.f844a.getSystemService("power");
            if (powerManager != null && powerManager.isIgnoringBatteryOptimizations(packageName)) {
                z4 = true;
            }
            i6 = 16;
            iCanScheduleExactAlarms = z4;
        } else if (i4 == 210) {
            if (Build.VERSION.SDK_INT < 30) {
                return false;
            }
            i6 = 22;
            iCanScheduleExactAlarms = Environment.isExternalStorageManager();
        } else if (i4 == 211) {
            i6 = 23;
            iCanScheduleExactAlarms = Settings.canDrawOverlays(activity);
        } else if (i4 == 212) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            i6 = 24;
            iCanScheduleExactAlarms = activity.getPackageManager().canRequestPackageInstalls();
        } else if (i4 == 213) {
            i6 = 27;
            iCanScheduleExactAlarms = ((NotificationManager) activity.getSystemService("notification")).isNotificationPolicyAccessGranted();
        } else {
            if (i4 != 214) {
                return false;
            }
            i6 = 34;
            iCanScheduleExactAlarms = Build.VERSION.SDK_INT >= 31 ? ((AlarmManager) activity.getSystemService("alarm")).canScheduleExactAlarms() : true;
        }
        this.f848e.put(Integer.valueOf(i6), Integer.valueOf(iCanScheduleExactAlarms));
        int i7 = this.f847d - 1;
        this.f847d = i7;
        b bVar = this.f845b;
        if (bVar != null && i7 == 0) {
            bVar.a(this.f848e);
        }
        return true;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener
    public boolean onRequestPermissionsResult(int i4, String[] strArr, int[] iArr) {
        int iG;
        if (i4 != 24) {
            this.f847d = 0;
            return false;
        }
        if (this.f848e == null) {
            return false;
        }
        if (strArr.length == 0 && iArr.length == 0) {
            Log.w("permissions_handler", "onRequestPermissionsResult is called without results. This is probably caused by interfering request codes. If you see this error, please file an issue in flutter-permission-handler, including a list of plugins used by this application: https://github.com/Baseflow/flutter-permission-handler/issues");
            return false;
        }
        List listAsList = Arrays.asList(strArr);
        int iIndexOf = listAsList.indexOf("android.permission.WRITE_CALENDAR");
        if (iIndexOf >= 0) {
            int iK = u.k(this.f846c, "android.permission.WRITE_CALENDAR", iArr[iIndexOf]);
            this.f848e.put(36, Integer.valueOf(iK));
            int iIndexOf2 = listAsList.indexOf("android.permission.READ_CALENDAR");
            if (iIndexOf2 >= 0) {
                Integer numI = u.i(Integer.valueOf(iK), Integer.valueOf(u.k(this.f846c, "android.permission.READ_CALENDAR", iArr[iIndexOf2])));
                numI.intValue();
                this.f848e.put(37, numI);
                this.f848e.put(0, numI);
            }
        }
        for (int i5 = 0; i5 < strArr.length; i5++) {
            String str = strArr[i5];
            if (!str.equals("android.permission.WRITE_CALENDAR") && !str.equals("android.permission.READ_CALENDAR") && (iG = u.g(str)) != 20) {
                int i6 = iArr[i5];
                if (iG == 8) {
                    this.f848e.put(8, u.i((Integer) this.f848e.get(8), Integer.valueOf(u.k(this.f846c, str, i6))));
                } else if (iG == 7) {
                    if (!this.f848e.containsKey(7)) {
                        this.f848e.put(7, Integer.valueOf(u.k(this.f846c, str, i6)));
                    }
                    if (!this.f848e.containsKey(14)) {
                        this.f848e.put(14, Integer.valueOf(u.k(this.f846c, str, i6)));
                    }
                } else if (iG == 4) {
                    int iK2 = u.k(this.f846c, str, i6);
                    if (!this.f848e.containsKey(4)) {
                        this.f848e.put(4, Integer.valueOf(iK2));
                    }
                } else if (iG == 3) {
                    int iK3 = u.k(this.f846c, str, i6);
                    if (Build.VERSION.SDK_INT < 29 && !this.f848e.containsKey(4)) {
                        this.f848e.put(4, Integer.valueOf(iK3));
                    }
                    if (!this.f848e.containsKey(5)) {
                        this.f848e.put(5, Integer.valueOf(iK3));
                    }
                    this.f848e.put(Integer.valueOf(iG), Integer.valueOf(iK3));
                } else if (iG == 9 || iG == 32) {
                    this.f848e.put(Integer.valueOf(iG), Integer.valueOf(d(iG)));
                } else if (!this.f848e.containsKey(Integer.valueOf(iG))) {
                    this.f848e.put(Integer.valueOf(iG), Integer.valueOf(u.k(this.f846c, str, i6)));
                }
            }
        }
        int length = this.f847d - iArr.length;
        this.f847d = length;
        b bVar = this.f845b;
        if (bVar == null || length != 0) {
            return true;
        }
        bVar.a(this.f848e);
        return true;
    }
}
