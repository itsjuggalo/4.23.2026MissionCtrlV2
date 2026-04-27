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
import v.C2761d;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2761d f7953a = C2761d.w();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f7954b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f7955c = null;

    public static class a {
        public static PackageInfo a(PackageManager packageManager, Context context) {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7957b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f7958c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f7959d;

        public b(int i7, int i8, long j7, long j8) {
            this.f7956a = i7;
            this.f7957b = i8;
            this.f7958c = j7;
            this.f7959d = j8;
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
                dataOutputStream.writeInt(this.f7956a);
                dataOutputStream.writeInt(this.f7957b);
                dataOutputStream.writeLong(this.f7958c);
                dataOutputStream.writeLong(this.f7959d);
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
            return this.f7957b == bVar.f7957b && this.f7958c == bVar.f7958c && this.f7956a == bVar.f7956a && this.f7959d == bVar.f7959d;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f7957b), Long.valueOf(this.f7958c), Integer.valueOf(this.f7956a), Long.valueOf(this.f7959d));
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f7961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f7962c;

        public c(int i7, boolean z7, boolean z8) {
            this.f7960a = i7;
            this.f7962c = z8;
            this.f7961b = z7;
        }
    }

    public static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? a.a(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static c b(int i7, boolean z7, boolean z8) {
        c cVar = new c(i7, z7, z8);
        f7955c = cVar;
        f7953a.s(cVar);
        return f7955c;
    }

    public static c c(Context context, boolean z7) {
        b bVarA;
        int i7;
        c cVar;
        if (!z7 && (cVar = f7955c) != null) {
            return cVar;
        }
        synchronized (f7954b) {
            if (!z7) {
                try {
                    c cVar2 = f7955c;
                    if (cVar2 != null) {
                        return cVar2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            int i8 = Build.VERSION.SDK_INT;
            int i9 = 0;
            if (i8 >= 28 && i8 != 30) {
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
                    if (bVarA != null && bVarA.f7958c == jA && (i7 = bVarA.f7957b) != 2) {
                        i9 = i7;
                    } else if (z8) {
                        i9 = 1;
                    } else if (z9) {
                        i9 = 2;
                    }
                    if (z7 && z9 && i9 != 1) {
                        i9 = 2;
                    }
                    if (bVarA != null && bVarA.f7957b == 2 && i9 == 1 && length < bVarA.f7959d) {
                        i9 = 3;
                    }
                    b bVar = new b(1, i9, jA, length2);
                    if (bVarA == null || !bVarA.equals(bVar)) {
                        try {
                            bVar.b(file3);
                        } catch (IOException unused2) {
                            i9 = 196608;
                        }
                    }
                    return b(i9, z8, z9);
                } catch (PackageManager.NameNotFoundException unused3) {
                    return b(65536, z8, z9);
                }
            }
            return b(262144, false, false);
        }
    }
}
