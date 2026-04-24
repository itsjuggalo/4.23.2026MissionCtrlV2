package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import y.C2967d;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2967d f12140a = C2967d.N();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f12141b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f12142c = null;

    public static class a {
        public static PackageInfo a(PackageManager packageManager, Context context) {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f12143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f12144b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f12145c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f12146d;

        public b(int i8, int i9, long j8, long j9) {
            this.f12143a = i8;
            this.f12144b = i9;
            this.f12145c = j8;
            this.f12146d = j9;
        }

        public static b a(File file) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } catch (Throwable th) {
                try {
                    dataInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        public void b(File file) throws IOException {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f12143a);
                dataOutputStream.writeInt(this.f12144b);
                dataOutputStream.writeLong(this.f12145c);
                dataOutputStream.writeLong(this.f12146d);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f12144b == bVar.f12144b && this.f12145c == bVar.f12145c && this.f12143a == bVar.f12143a && this.f12146d == bVar.f12146d;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f12144b), Long.valueOf(this.f12145c), Integer.valueOf(this.f12143a), Long.valueOf(this.f12146d));
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f12147a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f12148b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f12149c;

        public c(int i8, boolean z7, boolean z8) {
            this.f12147a = i8;
            this.f12149c = z8;
            this.f12148b = z7;
        }
    }

    public static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return (Build.VERSION.SDK_INT >= 33 ? a.a(packageManager, context) : packageManager.getPackageInfo(context.getPackageName(), 0)).lastUpdateTime;
    }

    public static c b(int i8, boolean z7, boolean z8) {
        c cVar = new c(i8, z7, z8);
        f12142c = cVar;
        f12140a.J(cVar);
        return f12142c;
    }

    public static c c(Context context, boolean z7) {
        b bVarA;
        int i8;
        c cVar;
        if (!z7 && (cVar = f12142c) != null) {
            return cVar;
        }
        synchronized (f12141b) {
            if (!z7) {
                try {
                    c cVar2 = f12142c;
                    if (cVar2 != null) {
                        return cVar2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            int i9 = Build.VERSION.SDK_INT;
            int i10 = 0;
            if (i9 >= 28 && i9 != 30) {
                File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                long length = file.length();
                boolean z8 = file.exists() && length > 0;
                File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                long length2 = file2.length();
                boolean z9 = file2.exists() && length2 > 0;
                try {
                    long jA = a(context);
                    File file3 = new File(context.getFilesDir(), "profileInstalled");
                    if (file3.exists()) {
                        try {
                            bVarA = b.a(file3);
                        } catch (IOException unused) {
                            return b(131072, z8, z9);
                        }
                    } else {
                        bVarA = null;
                    }
                    if (bVarA != null && bVarA.f12145c == jA && (i8 = bVarA.f12144b) != 2) {
                        i10 = i8;
                    } else if (z8) {
                        i10 = 1;
                    } else if (z9) {
                        i10 = 2;
                    }
                    if (z7 && z9 && i10 != 1) {
                        i10 = 2;
                    }
                    if (bVarA != null && bVarA.f12144b == 2 && i10 == 1 && length < bVarA.f12146d) {
                        i10 = 3;
                    }
                    b bVar = new b(1, i10, jA, length2);
                    if (bVarA == null || !bVarA.equals(bVar)) {
                        try {
                            bVar.b(file3);
                        } catch (IOException unused2) {
                            i10 = 196608;
                        }
                    }
                    return b(i10, z8, z9);
                } catch (PackageManager.NameNotFoundException unused3) {
                    return b(65536, z8, z9);
                }
            }
            return b(262144, false, false);
        }
    }
}
