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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y.d f2557a = y.d.G();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f2558b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f2559c = null;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {
        public static PackageInfo a(PackageManager packageManager, Context context) {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2561b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f2562c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f2563d;

        public b(int i10, int i11, long j10, long j11) {
            this.f2560a = i10;
            this.f2561b = i11;
            this.f2562c = j10;
            this.f2563d = j11;
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
                dataOutputStream.writeInt(this.f2560a);
                dataOutputStream.writeInt(this.f2561b);
                dataOutputStream.writeLong(this.f2562c);
                dataOutputStream.writeLong(this.f2563d);
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
                if (this.f2561b == bVar.f2561b && this.f2562c == bVar.f2562c && this.f2560a == bVar.f2560a && this.f2563d == bVar.f2563d) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f2561b), Long.valueOf(this.f2562c), Integer.valueOf(this.f2560a), Long.valueOf(this.f2563d));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f2565b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f2566c;

        public c(int i10, boolean z10, boolean z11) {
            this.f2564a = i10;
            this.f2566c = z11;
            this.f2565b = z10;
        }
    }

    public static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? a.a(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static c b(int i10, boolean z10, boolean z11) {
        c cVar = new c(i10, z10, z11);
        f2559c = cVar;
        f2557a.y(cVar);
        return f2559c;
    }

    public static c c(Context context, boolean z10) {
        b bVarA;
        int i10;
        c cVar;
        if (!z10 && (cVar = f2559c) != null) {
            return cVar;
        }
        synchronized (f2558b) {
            if (!z10) {
                try {
                    c cVar2 = f2559c;
                    if (cVar2 != null) {
                        return cVar2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            int i11 = Build.VERSION.SDK_INT;
            int i12 = 0;
            if (i11 >= 28 && i11 != 30) {
                File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                long length = file.length();
                boolean z11 = file.exists() && length > 0;
                File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                long length2 = file2.length();
                boolean z12 = file2.exists() && length2 > 0;
                try {
                    long jA = a(context);
                    File file3 = new File(context.getFilesDir(), "profileInstalled");
                    if (file3.exists()) {
                        try {
                            bVarA = b.a(file3);
                        } catch (IOException unused) {
                            return b(131072, z11, z12);
                        }
                    } else {
                        bVarA = null;
                    }
                    if (bVarA != null && bVarA.f2562c == jA && (i10 = bVarA.f2561b) != 2) {
                        i12 = i10;
                    } else if (z11) {
                        i12 = 1;
                    } else if (z12) {
                        i12 = 2;
                    }
                    if (z10 && z12 && i12 != 1) {
                        i12 = 2;
                    }
                    if (bVarA != null && bVarA.f2561b == 2 && i12 == 1 && length < bVarA.f2563d) {
                        i12 = 3;
                    }
                    int i13 = i12;
                    b bVar = new b(1, i13, jA, length2);
                    if (bVarA == null || !bVarA.equals(bVar)) {
                        try {
                            bVar.b(file3);
                        } catch (IOException unused2) {
                            i13 = 196608;
                        }
                    }
                    return b(i13, z11, z12);
                } catch (PackageManager.NameNotFoundException unused3) {
                    return b(65536, z11, z12);
                }
            }
            return b(262144, false, false);
        }
    }
}
