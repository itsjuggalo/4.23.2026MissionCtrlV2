package androidx.profileinstaller;

import D3.m;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import w0.ExecutorC2893k;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InterfaceC0196c f12138a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final InterfaceC0196c f12139b = new b();

    public class a implements InterfaceC0196c {
        @Override // androidx.profileinstaller.c.InterfaceC0196c
        public void a(int i8, Object obj) {
        }

        @Override // androidx.profileinstaller.c.InterfaceC0196c
        public void b(int i8, Object obj) {
        }
    }

    public class b implements InterfaceC0196c {
        @Override // androidx.profileinstaller.c.InterfaceC0196c
        public void a(int i8, Object obj) {
            Log.d("ProfileInstaller", i8 != 1 ? i8 != 2 ? i8 != 3 ? i8 != 4 ? i8 != 5 ? "" : "DIAGNOSTIC_PROFILE_IS_COMPRESSED" : "DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_REF_PROFILE_EXISTS" : "DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_CURRENT_PROFILE_EXISTS");
        }

        @Override // androidx.profileinstaller.c.InterfaceC0196c
        public void b(int i8, Object obj) {
            String str;
            switch (i8) {
                case 1:
                    str = "RESULT_INSTALL_SUCCESS";
                    break;
                case 2:
                    str = "RESULT_ALREADY_INSTALLED";
                    break;
                case 3:
                    str = "RESULT_UNSUPPORTED_ART_VERSION";
                    break;
                case 4:
                    str = "RESULT_NOT_WRITABLE";
                    break;
                case 5:
                    str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                    break;
                case 6:
                    str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                    break;
                case 7:
                    str = "RESULT_IO_EXCEPTION";
                    break;
                case 8:
                    str = "RESULT_PARSE_EXCEPTION";
                    break;
                case 9:
                default:
                    str = "";
                    break;
                case 10:
                    str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                    break;
                case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                    str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                    break;
            }
            if (i8 == 6 || i8 == 7 || i8 == 8) {
                Log.e("ProfileInstaller", str, (Throwable) obj);
            } else {
                Log.d("ProfileInstaller", str);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.profileinstaller.c$c, reason: collision with other inner class name */
    public interface InterfaceC0196c {
        void a(int i8, Object obj);

        void b(int i8, Object obj);
    }

    public static boolean b(File file) {
        return new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
    }

    public static void c(Context context, Executor executor, InterfaceC0196c interfaceC0196c) {
        b(context.getFilesDir());
        g(executor, interfaceC0196c, 11, null);
    }

    public static boolean d(PackageInfo packageInfo, File file, InterfaceC0196c interfaceC0196c) {
        File file2 = new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
        if (!file2.exists()) {
            return false;
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file2));
            try {
                long j8 = dataInputStream.readLong();
                dataInputStream.close();
                boolean z7 = j8 == packageInfo.lastUpdateTime;
                if (z7) {
                    interfaceC0196c.b(2, null);
                }
                return z7;
            } finally {
            }
        } catch (IOException unused) {
            return false;
        }
    }

    public static void f(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    public static void g(Executor executor, final InterfaceC0196c interfaceC0196c, final int i8, final Object obj) {
        executor.execute(new Runnable() { // from class: x0.e
            @Override // java.lang.Runnable
            public final void run() {
                interfaceC0196c.b(i8, obj);
            }
        });
    }

    public static boolean h(AssetManager assetManager, String str, PackageInfo packageInfo, File file, String str2, Executor executor, InterfaceC0196c interfaceC0196c) {
        androidx.profileinstaller.b bVar = new androidx.profileinstaller.b(assetManager, executor, interfaceC0196c, str2, "dexopt/baseline.prof", "dexopt/baseline.profm", new File(new File("/data/misc/profiles/cur/0", str), "primary.prof"));
        if (!bVar.e()) {
            return false;
        }
        boolean zN = bVar.i().m().n();
        if (zN) {
            f(packageInfo, file);
        }
        return zN;
    }

    public static void i(Context context) {
        j(context, new ExecutorC2893k(), f12138a);
    }

    public static void j(Context context, Executor executor, InterfaceC0196c interfaceC0196c) {
        k(context, executor, interfaceC0196c, false);
    }

    public static void k(Context context, Executor executor, InterfaceC0196c interfaceC0196c, boolean z7) {
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        boolean z8 = false;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (z7 || !d(packageInfo, filesDir, interfaceC0196c)) {
                Log.d("ProfileInstaller", "Installing profile for " + context.getPackageName());
                if (h(assets, packageName, packageInfo, filesDir, name, executor, interfaceC0196c) && z7) {
                    z8 = true;
                }
            } else {
                Log.d("ProfileInstaller", "Skipping profile installation for " + context.getPackageName());
            }
            d.c(context, z8);
        } catch (PackageManager.NameNotFoundException e8) {
            interfaceC0196c.b(7, e8);
            d.c(context, false);
        }
    }

    public static void l(Context context, Executor executor, InterfaceC0196c interfaceC0196c) {
        try {
            f(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
            g(executor, interfaceC0196c, 10, null);
        } catch (PackageManager.NameNotFoundException e8) {
            g(executor, interfaceC0196c, 7, e8);
        }
    }
}
