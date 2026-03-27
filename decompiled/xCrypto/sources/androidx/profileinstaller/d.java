package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.concurrent.futures.e;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f7844a = e.n();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f7845b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f7846c = null;

    public static class a {
        public static PackageInfo a(PackageManager packageManager, Context context) {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7847a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7848b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f7849c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f7850d;

        public b(int i4, int i5, long j4, long j5) {
            this.f7847a = i4;
            this.f7848b = i5;
            this.f7849c = j4;
            this.f7850d = j5;
        }

        public static b a(File file) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } finally {
            }
        }

        public void b(File file) throws IOException {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f7847a);
                dataOutputStream.writeInt(this.f7848b);
                dataOutputStream.writeLong(this.f7849c);
                dataOutputStream.writeLong(this.f7850d);
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
            if (obj != null && (obj instanceof b)) {
                b bVar = (b) obj;
                if (this.f7848b == bVar.f7848b && this.f7849c == bVar.f7849c && this.f7847a == bVar.f7847a && this.f7850d == bVar.f7850d) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f7848b), Long.valueOf(this.f7849c), Integer.valueOf(this.f7847a), Long.valueOf(this.f7850d));
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f7852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f7853c;

        public c(int i4, boolean z4, boolean z5) {
            this.f7851a = i4;
            this.f7853c = z5;
            this.f7852b = z4;
        }
    }

    public static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? a.a(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static c b(int i4, boolean z4, boolean z5) {
        c cVar = new c(i4, z4, z5);
        f7846c = cVar;
        f7844a.set(cVar);
        return f7846c;
    }

    public static c c(Context context, boolean z4) {
        b bVarA;
        int i4;
        c cVar;
        if (!z4 && (cVar = f7846c) != null) {
            return cVar;
        }
        synchronized (f7845b) {
            if (!z4) {
                try {
                    c cVar2 = f7846c;
                    if (cVar2 != null) {
                        return cVar2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            int i5 = Build.VERSION.SDK_INT;
            int i6 = 0;
            if (i5 >= 28 && i5 != 30) {
                File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                long length = file.length();
                boolean z5 = file.exists() && length > 0;
                File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                long length2 = file2.length();
                boolean z6 = file2.exists() && length2 > 0;
                try {
                    long jA = a(context);
                    File file3 = new File(context.getFilesDir(), "profileInstalled");
                    if (file3.exists()) {
                        try {
                            bVarA = b.a(file3);
                        } catch (IOException unused) {
                            return b(131072, z5, z6);
                        }
                    } else {
                        bVarA = null;
                    }
                    if (bVarA != null && bVarA.f7849c == jA && (i4 = bVarA.f7848b) != 2) {
                        i6 = i4;
                    } else if (z5) {
                        i6 = 1;
                    } else if (z6) {
                        i6 = 2;
                    }
                    if (z4 && z6 && i6 != 1) {
                        i6 = 2;
                    }
                    if (bVarA != null && bVarA.f7848b == 2 && i6 == 1 && length < bVarA.f7850d) {
                        i6 = 3;
                    }
                    int i7 = i6;
                    b bVar = new b(1, i7, jA, length2);
                    if (bVarA == null || !bVarA.equals(bVar)) {
                        try {
                            bVar.b(file3);
                        } catch (IOException unused2) {
                            i7 = 196608;
                        }
                    }
                    return b(i7, z5, z6);
                } catch (PackageManager.NameNotFoundException unused3) {
                    return b(65536, z5, z6);
                }
            }
            return b(262144, false, false);
        }
    }
}
