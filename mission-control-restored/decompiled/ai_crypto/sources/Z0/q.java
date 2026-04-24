package Z0;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class q implements V4.l, V4.n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f5699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f5700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Activity f5701e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5702f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map f5703g;

    public interface a {
        void a(int i7);
    }

    public interface b {
        void a(Map map);
    }

    public interface c {
        void a(boolean z7);
    }

    public q(Context context) {
        this.f5699c = context;
    }

    public final int a() {
        List listC = u.c(this.f5699c, 21);
        if (listC != null && !listC.isEmpty()) {
            return 1;
        }
        Log.d("permissions_handler", "Bluetooth permission missing in manifest");
        return 0;
    }

    public final int b() {
        if (Build.VERSION.SDK_INT < 33) {
            return F.p.e(this.f5699c).a() ? 1 : 0;
        }
        if (this.f5699c.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0) {
            return 1;
        }
        return u.b(this.f5701e, "android.permission.POST_NOTIFICATIONS");
    }

    public void c(int i7, a aVar) {
        aVar.a(d(i7));
    }

    public final int d(int i7) {
        if (i7 == 17) {
            return b();
        }
        if (i7 == 21) {
            return a();
        }
        if ((i7 == 30 || i7 == 28 || i7 == 29) && Build.VERSION.SDK_INT < 31) {
            return a();
        }
        if ((i7 == 37 || i7 == 0) && !e()) {
            return 0;
        }
        List<String> listC = u.c(this.f5699c, i7);
        if (listC == null) {
            Log.d("permissions_handler", "No android specific permissions needed for: " + i7);
            return 1;
        }
        if (listC.size() == 0) {
            Log.d("permissions_handler", "No permissions found in manifest for: " + listC + i7);
            return (i7 != 22 || Build.VERSION.SDK_INT >= 30) ? 0 : 2;
        }
        if (this.f5699c.getApplicationInfo().targetSdkVersion >= 23) {
            HashSet hashSet = new HashSet();
            for (String str : listC) {
                if (i7 == 16) {
                    String packageName = this.f5699c.getPackageName();
                    PowerManager powerManager = (PowerManager) this.f5699c.getSystemService("power");
                    if (powerManager == null || !powerManager.isIgnoringBatteryOptimizations(packageName)) {
                        hashSet.add(0);
                    } else {
                        hashSet.add(1);
                    }
                } else if (i7 == 22) {
                    if (Build.VERSION.SDK_INT < 30) {
                        hashSet.add(2);
                    }
                    hashSet.add(Integer.valueOf(Environment.isExternalStorageManager() ? 1 : 0));
                } else if (i7 == 23) {
                    hashSet.add(Integer.valueOf(Settings.canDrawOverlays(this.f5699c) ? 1 : 0));
                } else if (i7 == 24) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        hashSet.add(Integer.valueOf(this.f5699c.getPackageManager().canRequestPackageInstalls() ? 1 : 0));
                    }
                } else if (i7 == 27) {
                    hashSet.add(Integer.valueOf(((NotificationManager) this.f5699c.getSystemService("notification")).isNotificationPolicyAccessGranted() ? 1 : 0));
                } else if (i7 == 34) {
                    if (Build.VERSION.SDK_INT >= 31) {
                        hashSet.add(Integer.valueOf(((AlarmManager) this.f5699c.getSystemService("alarm")).canScheduleExactAlarms() ? 1 : 0));
                    } else {
                        hashSet.add(1);
                    }
                } else if (i7 == 9 || i7 == 32) {
                    int iCheckSelfPermission = G.a.checkSelfPermission(this.f5699c, str);
                    if ((Build.VERSION.SDK_INT >= 34 ? G.a.checkSelfPermission(this.f5699c, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED") : iCheckSelfPermission) == 0 && iCheckSelfPermission == -1) {
                        hashSet.add(3);
                    } else if (iCheckSelfPermission == 0) {
                        hashSet.add(1);
                    } else {
                        hashSet.add(Integer.valueOf(u.b(this.f5701e, str)));
                    }
                } else if (G.a.checkSelfPermission(this.f5699c, str) != 0) {
                    hashSet.add(Integer.valueOf(u.b(this.f5701e, str)));
                }
            }
            if (!hashSet.isEmpty()) {
                return u.j(hashSet).intValue();
            }
        }
        return 1;
    }

    public final boolean e() {
        List listC = u.c(this.f5699c, 37);
        boolean z7 = listC != null && listC.contains("android.permission.WRITE_CALENDAR");
        boolean z8 = listC != null && listC.contains("android.permission.READ_CALENDAR");
        if (z7 && z8) {
            return true;
        }
        if (!z7) {
            Log.d("permissions_handler", "android.permission.WRITE_CALENDAR missing in manifest");
        }
        if (!z8) {
            Log.d("permissions_handler", "android.permission.READ_CALENDAR missing in manifest");
        }
        return false;
    }

    public final void f(String str, int i7) {
        if (this.f5701e == null) {
            return;
        }
        Intent intent = new Intent(str);
        if (!str.equals("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS")) {
            intent.setData(Uri.parse("package:" + this.f5701e.getPackageName()));
        }
        this.f5701e.startActivityForResult(intent, i7);
        this.f5702f++;
    }

    public void g(List list, b bVar, Z0.b bVar2) {
        if (this.f5702f > 0) {
            bVar2.a("PermissionHandler.PermissionManager", "A request for permissions is already running, please wait for it to finish before doing another request (note that you can request multiple permissions at the same time).");
            return;
        }
        if (this.f5701e == null) {
            Log.d("permissions_handler", "Unable to detect current Activity.");
            bVar2.a("PermissionHandler.PermissionManager", "Unable to detect current Android Activity.");
            return;
        }
        this.f5700d = bVar;
        this.f5703g = new HashMap();
        this.f5702f = 0;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (d(num.intValue()) != 1) {
                List listC = u.c(this.f5701e, num.intValue());
                if (listC != null && !listC.isEmpty()) {
                    int i7 = Build.VERSION.SDK_INT;
                    if (num.intValue() == 16) {
                        f("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS", 209);
                    } else if (i7 >= 30 && num.intValue() == 22) {
                        f("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION", 210);
                    } else if (num.intValue() == 23) {
                        f("android.settings.action.MANAGE_OVERLAY_PERMISSION", 211);
                    } else if (i7 >= 26 && num.intValue() == 24) {
                        f("android.settings.MANAGE_UNKNOWN_APP_SOURCES", 212);
                    } else if (num.intValue() == 27) {
                        f("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS", 213);
                    } else if (i7 >= 31 && num.intValue() == 34) {
                        f("android.settings.REQUEST_SCHEDULE_EXACT_ALARM", 214);
                    } else if (num.intValue() != 37 && num.intValue() != 0) {
                        arrayList.addAll(listC);
                        this.f5702f += listC.size();
                    } else if (e()) {
                        arrayList.add("android.permission.WRITE_CALENDAR");
                        arrayList.add("android.permission.READ_CALENDAR");
                        this.f5702f += 2;
                    } else {
                        this.f5703g.put(num, 0);
                    }
                } else if (!this.f5703g.containsKey(num)) {
                    this.f5703g.put(num, 0);
                    if (num.intValue() != 22 || Build.VERSION.SDK_INT >= 30) {
                        this.f5703g.put(num, 0);
                    } else {
                        this.f5703g.put(num, 2);
                    }
                }
            } else if (!this.f5703g.containsKey(num)) {
                this.f5703g.put(num, 1);
            }
        }
        if (arrayList.size() > 0) {
            F.a.a(this.f5701e, (String[]) arrayList.toArray(new String[0]), 24);
        }
        b bVar3 = this.f5700d;
        if (bVar3 == null || this.f5702f != 0) {
            return;
        }
        bVar3.a(this.f5703g);
    }

    public void h(Activity activity) {
        this.f5701e = activity;
    }

    public void i(int i7, c cVar, Z0.b bVar) {
        Activity activity = this.f5701e;
        if (activity == null) {
            Log.d("permissions_handler", "Unable to detect current Activity.");
            bVar.a("PermissionHandler.PermissionManager", "Unable to detect current Android Activity.");
            return;
        }
        List listC = u.c(activity, i7);
        if (listC == null) {
            Log.d("permissions_handler", "No android specific permissions needed for: " + i7);
            cVar.a(false);
            return;
        }
        if (!listC.isEmpty()) {
            cVar.a(F.a.b(this.f5701e, (String) listC.get(0)));
            return;
        }
        Log.d("permissions_handler", "No permissions found in manifest for: " + i7 + " no need to show request rationale");
        cVar.a(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // V4.l
    public boolean onActivityResult(int i7, int i8, Intent intent) {
        int i9;
        int iCanScheduleExactAlarms;
        Activity activity = this.f5701e;
        boolean z7 = false;
        z7 = false;
        if (activity == null) {
            return false;
        }
        if (this.f5703g == null) {
            this.f5702f = 0;
            return false;
        }
        if (i7 == 209) {
            String packageName = this.f5699c.getPackageName();
            PowerManager powerManager = (PowerManager) this.f5699c.getSystemService("power");
            if (powerManager != null && powerManager.isIgnoringBatteryOptimizations(packageName)) {
                z7 = true;
            }
            i9 = 16;
            iCanScheduleExactAlarms = z7;
        } else if (i7 == 210) {
            if (Build.VERSION.SDK_INT < 30) {
                return false;
            }
            i9 = 22;
            iCanScheduleExactAlarms = Environment.isExternalStorageManager();
        } else if (i7 == 211) {
            i9 = 23;
            iCanScheduleExactAlarms = Settings.canDrawOverlays(activity);
        } else if (i7 == 212) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            i9 = 24;
            iCanScheduleExactAlarms = activity.getPackageManager().canRequestPackageInstalls();
        } else if (i7 == 213) {
            i9 = 27;
            iCanScheduleExactAlarms = ((NotificationManager) activity.getSystemService("notification")).isNotificationPolicyAccessGranted();
        } else {
            if (i7 != 214) {
                return false;
            }
            i9 = 34;
            iCanScheduleExactAlarms = Build.VERSION.SDK_INT >= 31 ? ((AlarmManager) activity.getSystemService("alarm")).canScheduleExactAlarms() : true;
        }
        this.f5703g.put(Integer.valueOf(i9), Integer.valueOf(iCanScheduleExactAlarms));
        int i10 = this.f5702f - 1;
        this.f5702f = i10;
        b bVar = this.f5700d;
        if (bVar != null && i10 == 0) {
            bVar.a(this.f5703g);
        }
        return true;
    }

    @Override // V4.n
    public boolean onRequestPermissionsResult(int i7, String[] strArr, int[] iArr) {
        int iG;
        if (i7 != 24) {
            this.f5702f = 0;
            return false;
        }
        if (this.f5703g == null) {
            return false;
        }
        if (strArr.length == 0 && iArr.length == 0) {
            Log.w("permissions_handler", "onRequestPermissionsResult is called without results. This is probably caused by interfering request codes. If you see this error, please file an issue in flutter-permission-handler, including a list of plugins used by this application: https://github.com/Baseflow/flutter-permission-handler/issues");
            return false;
        }
        List listAsList = Arrays.asList(strArr);
        int iIndexOf = listAsList.indexOf("android.permission.WRITE_CALENDAR");
        if (iIndexOf >= 0) {
            int iK = u.k(this.f5701e, "android.permission.WRITE_CALENDAR", iArr[iIndexOf]);
            this.f5703g.put(36, Integer.valueOf(iK));
            int iIndexOf2 = listAsList.indexOf("android.permission.READ_CALENDAR");
            if (iIndexOf2 >= 0) {
                Integer numI = u.i(Integer.valueOf(iK), Integer.valueOf(u.k(this.f5701e, "android.permission.READ_CALENDAR", iArr[iIndexOf2])));
                numI.intValue();
                this.f5703g.put(37, numI);
                this.f5703g.put(0, numI);
            }
        }
        for (int i8 = 0; i8 < strArr.length; i8++) {
            String str = strArr[i8];
            if (!str.equals("android.permission.WRITE_CALENDAR") && !str.equals("android.permission.READ_CALENDAR") && (iG = u.g(str)) != 20) {
                int i9 = iArr[i8];
                if (iG == 8) {
                    this.f5703g.put(8, u.i((Integer) this.f5703g.get(8), Integer.valueOf(u.k(this.f5701e, str, i9))));
                } else if (iG == 7) {
                    if (!this.f5703g.containsKey(7)) {
                        this.f5703g.put(7, Integer.valueOf(u.k(this.f5701e, str, i9)));
                    }
                    if (!this.f5703g.containsKey(14)) {
                        this.f5703g.put(14, Integer.valueOf(u.k(this.f5701e, str, i9)));
                    }
                } else if (iG == 4) {
                    int iK2 = u.k(this.f5701e, str, i9);
                    if (!this.f5703g.containsKey(4)) {
                        this.f5703g.put(4, Integer.valueOf(iK2));
                    }
                } else if (iG == 3) {
                    int iK3 = u.k(this.f5701e, str, i9);
                    if (Build.VERSION.SDK_INT < 29 && !this.f5703g.containsKey(4)) {
                        this.f5703g.put(4, Integer.valueOf(iK3));
                    }
                    if (!this.f5703g.containsKey(5)) {
                        this.f5703g.put(5, Integer.valueOf(iK3));
                    }
                    this.f5703g.put(Integer.valueOf(iG), Integer.valueOf(iK3));
                } else if (iG == 9 || iG == 32) {
                    this.f5703g.put(Integer.valueOf(iG), Integer.valueOf(d(iG)));
                } else if (!this.f5703g.containsKey(Integer.valueOf(iG))) {
                    this.f5703g.put(Integer.valueOf(iG), Integer.valueOf(u.k(this.f5701e, str, i9)));
                }
            }
        }
        int length = this.f5702f - iArr.length;
        this.f5702f = length;
        b bVar = this.f5700d;
        if (bVar == null || length != 0) {
            return true;
        }
        bVar.a(this.f5703g);
        return true;
    }
}
