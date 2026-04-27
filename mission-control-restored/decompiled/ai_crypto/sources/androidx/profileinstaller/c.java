package androidx.profileinstaller;

import B0.k;
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
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InterfaceC0135c f7951a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final InterfaceC0135c f7952b = new b();

    public class a implements InterfaceC0135c {
        @Override // androidx.profileinstaller.c.InterfaceC0135c
        public void a(int i7, Object obj) {
        }

        @Override // androidx.profileinstaller.c.InterfaceC0135c
        public void b(int i7, Object obj) {
        }
    }

    public class b implements InterfaceC0135c {
        @Override // androidx.profileinstaller.c.InterfaceC0135c
        public void a(int i7, Object obj) {
            Log.d("ProfileInstaller", i7 != 1 ? i7 != 2 ? i7 != 3 ? i7 != 4 ? i7 != 5 ? "" : "DIAGNOSTIC_PROFILE_IS_COMPRESSED" : "DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_REF_PROFILE_EXISTS" : "DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_CURRENT_PROFILE_EXISTS");
        }

        @Override // androidx.profileinstaller.c.InterfaceC0135c
        public void b(int i7, Object obj) {
            String str;
            switch (i7) {
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
                case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                default:
                    str = "";
                    break;
                case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                    break;
                case 11:
                    str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                    break;
            }
            if (i7 == 6 || i7 == 7 || i7 == 8) {
                Log.e("ProfileInstaller", str, (Throwable) obj);
            } else {
                Log.d("ProfileInstaller", str);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.profileinstaller.c$c, reason: collision with other inner class name */
    public interface InterfaceC0135c {
        void a(int i7, Object obj);

        void b(int i7, Object obj);
    }

    public static boolean b(File file) {
        return new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
    }

    public static void c(Context context, Executor executor, InterfaceC0135c interfaceC0135c) {
        b(context.getFilesDir());
        g(executor, interfaceC0135c, 11, null);
    }

    public static boolean d(PackageInfo packageInfo, File file, InterfaceC0135c interfaceC0135c) {
        File file2 = new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
        if (!file2.exists()) {
            return false;
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file2));
            try {
                long j7 = dataInputStream.readLong();
                dataInputStream.close();
                boolean z7 = j7 == packageInfo.lastUpdateTime;
                if (z7) {
                    interfaceC0135c.b(2, null);
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

    public static void g(Executor executor, final InterfaceC0135c interfaceC0135c, final int i7, final Object obj) {
        executor.execute(new Runnable() { // from class: C0.e
            @Override // java.lang.Runnable
            public final void run() {
                interfaceC0135c.b(i7, obj);
            }
        });
    }

    public static boolean h(AssetManager assetManager, String str, PackageInfo packageInfo, File file, String str2, Executor executor, InterfaceC0135c interfaceC0135c) {
        androidx.profileinstaller.b bVar = new androidx.profileinstaller.b(assetManager, executor, interfaceC0135c, str2, "dexopt/baseline.prof", "dexopt/baseline.profm", new File(new File("/data/misc/profiles/cur/0", str), "primary.prof"));
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
        j(context, new k(), f7951a);
    }

    public static void j(Context context, Executor executor, InterfaceC0135c interfaceC0135c) {
        k(context, executor, interfaceC0135c, false);
    }

    public static void k(Context context, Executor executor, InterfaceC0135c interfaceC0135c, boolean z7) {
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        boolean z8 = false;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (!z7 && d(packageInfo, filesDir, interfaceC0135c)) {
                Log.d("ProfileInstaller", "Skipping profile installation for " + context.getPackageName());
                d.c(context, false);
                return;
            }
            Log.d("ProfileInstaller", "Installing profile for " + context.getPackageName());
            if (h(assets, packageName, packageInfo, filesDir, name, executor, interfaceC0135c) && z7) {
                z8 = true;
            }
            d.c(context, z8);
        } catch (PackageManager.NameNotFoundException e7) {
            interfaceC0135c.b(7, e7);
            d.c(context, false);
        }
    }

    public static void l(Context context, Executor executor, InterfaceC0135c interfaceC0135c) {
        try {
            f(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
            g(executor, interfaceC0135c, 10, null);
        } catch (PackageManager.NameNotFoundException e7) {
            g(executor, interfaceC0135c, 7, e7);
        }
    }
}
