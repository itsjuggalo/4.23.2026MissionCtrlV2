package k3;

import android.util.Log;
import e3.a;
import java.io.File;
import java.io.IOException;
import k3.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f14498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f14499c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e3.a f14501e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f14500d = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f14497a = new j();

    public e(File file, long j10) {
        this.f14498b = file;
        this.f14499c = j10;
    }

    public static a c(File file, long j10) {
        return new e(file, j10);
    }

    @Override // k3.a
    public void a(g3.f fVar, a.b bVar) {
        String strB = this.f14497a.b(fVar);
        this.f14500d.a(strB);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + strB + " for for Key: " + fVar);
            }
            try {
                e3.a aVarD = d();
                if (aVarD.c0(strB) == null) {
                    a.c cVarZ = aVarD.Z(strB);
                    if (cVarZ == null) {
                        throw new IllegalStateException("Had two simultaneous puts for: " + strB);
                    }
                    try {
                        if (bVar.a(cVarZ.f(0))) {
                            cVarZ.e();
                        }
                        cVarZ.b();
                    } catch (Throwable th) {
                        cVarZ.b();
                        throw th;
                    }
                }
            } catch (IOException e10) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e10);
                }
            }
        } finally {
            this.f14500d.b(strB);
        }
    }

    @Override // k3.a
    public File b(g3.f fVar) throws Throwable {
        String strB = this.f14497a.b(fVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + strB + " for for Key: " + fVar);
        }
        try {
            a.e eVarC0 = d().c0(strB);
            if (eVarC0 != null) {
                return eVarC0.a(0);
            }
            return null;
        } catch (IOException e10) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e10);
            return null;
        }
    }

    public final synchronized e3.a d() {
        try {
            if (this.f14501e == null) {
                this.f14501e = e3.a.e0(this.f14498b, 1, 1, this.f14499c);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f14501e;
    }
}
