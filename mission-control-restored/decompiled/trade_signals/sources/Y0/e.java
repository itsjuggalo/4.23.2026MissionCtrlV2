package Y0;

import S0.b;
import Y0.a;
import android.util.Log;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class e implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f9502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f9503c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public S0.b f9505e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f9504d = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f9501a = new j();

    public e(File file, long j8) {
        this.f9502b = file;
        this.f9503c = j8;
    }

    public static a c(File file, long j8) {
        return new e(file, j8);
    }

    @Override // Y0.a
    public void a(U0.f fVar, a.b bVar) {
        S0.b bVarD;
        String strB = this.f9501a.b(fVar);
        this.f9504d.a(strB);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + strB + " for for Key: " + fVar);
            }
            try {
                bVarD = d();
            } catch (IOException e8) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e8);
                }
            }
            if (bVarD.T(strB) != null) {
                return;
            }
            b.c cVarQ = bVarD.Q(strB);
            if (cVarQ == null) {
                throw new IllegalStateException("Had two simultaneous puts for: " + strB);
            }
            try {
                if (bVar.a(cVarQ.f(0))) {
                    cVarQ.e();
                }
                cVarQ.b();
            } catch (Throwable th) {
                cVarQ.b();
                throw th;
            }
        } finally {
            this.f9504d.b(strB);
        }
    }

    @Override // Y0.a
    public File b(U0.f fVar) {
        String strB = this.f9501a.b(fVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + strB + " for for Key: " + fVar);
        }
        try {
            b.e eVarT = d().T(strB);
            if (eVarT != null) {
                return eVarT.a(0);
            }
            return null;
        } catch (IOException e8) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e8);
            return null;
        }
    }

    public final synchronized S0.b d() {
        try {
            if (this.f9505e == null) {
                this.f9505e = S0.b.W(this.f9502b, 1, 1, this.f9503c);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f9505e;
    }
}
