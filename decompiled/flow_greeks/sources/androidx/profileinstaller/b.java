package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.c;
import i2.j;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AssetManager f2544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f2545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.InterfaceC0037c f2546c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final File f2548e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f2549f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f2550g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f2551h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public i2.b[] f2553j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte[] f2554k;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2552i = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f2547d = d();

    public b(AssetManager assetManager, Executor executor, c.InterfaceC0037c interfaceC0037c, String str, String str2, String str3, File file) {
        this.f2544a = assetManager;
        this.f2545b = executor;
        this.f2546c = interfaceC0037c;
        this.f2549f = str;
        this.f2550g = str2;
        this.f2551h = str3;
        this.f2548e = file;
    }

    public static byte[] d() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 > 34) {
            return null;
        }
        switch (i10) {
        }
        return null;
    }

    public static boolean j() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 > 34) {
            return false;
        }
        if (i10 != 25) {
            switch (i10) {
            }
            return false;
        }
        return true;
    }

    public final b b(i2.b[] bVarArr, byte[] bArr) {
        InputStream inputStreamG;
        try {
            inputStreamG = g(this.f2544a, this.f2551h);
        } catch (FileNotFoundException e10) {
            this.f2546c.b(9, e10);
        } catch (IOException e11) {
            this.f2546c.b(7, e11);
        } catch (IllegalStateException e12) {
            this.f2553j = null;
            this.f2546c.b(8, e12);
        }
        if (inputStreamG == null) {
            if (inputStreamG != null) {
                inputStreamG.close();
            }
            return null;
        }
        try {
            this.f2553j = j.q(inputStreamG, j.o(inputStreamG, j.f11556b), bArr, bVarArr);
            inputStreamG.close();
            return this;
        } catch (Throwable th) {
            try {
                inputStreamG.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void c() {
        if (!this.f2552i) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    public boolean e() {
        if (this.f2547d == null) {
            k(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (!this.f2548e.exists()) {
            try {
                this.f2548e.createNewFile();
            } catch (IOException unused) {
                k(4, null);
                return false;
            }
        } else if (!this.f2548e.canWrite()) {
            k(4, null);
            return false;
        }
        this.f2552i = true;
        return true;
    }

    public final InputStream f(AssetManager assetManager) {
        try {
            return g(assetManager, this.f2550g);
        } catch (FileNotFoundException e10) {
            this.f2546c.b(6, e10);
            return null;
        } catch (IOException e11) {
            this.f2546c.b(7, e11);
            return null;
        }
    }

    public final InputStream g(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e10) {
            String message = e10.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f2546c.a(5, null);
            }
            return null;
        }
    }

    public b h() {
        b bVarB;
        c();
        if (this.f2547d != null) {
            InputStream inputStreamF = f(this.f2544a);
            if (inputStreamF != null) {
                this.f2553j = i(inputStreamF);
            }
            i2.b[] bVarArr = this.f2553j;
            if (bVarArr != null && j() && (bVarB = b(bVarArr, this.f2547d)) != null) {
                return bVarB;
            }
        }
        return this;
    }

    public final i2.b[] i(InputStream inputStream) {
        try {
            try {
                try {
                    i2.b[] bVarArrW = j.w(inputStream, j.o(inputStream, j.f11555a), this.f2549f);
                    try {
                        inputStream.close();
                        return bVarArrW;
                    } catch (IOException e10) {
                        this.f2546c.b(7, e10);
                        return bVarArrW;
                    }
                } catch (IllegalStateException e11) {
                    this.f2546c.b(8, e11);
                    return null;
                }
            } catch (IOException e12) {
                this.f2546c.b(7, e12);
                return null;
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException e13) {
                this.f2546c.b(7, e13);
            }
        }
    }

    public final void k(final int i10, final Object obj) {
        this.f2545b.execute(new Runnable() { // from class: i2.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f11528a.f2546c.b(i10, obj);
            }
        });
    }

    public b l() {
        ByteArrayOutputStream byteArrayOutputStream;
        i2.b[] bVarArr = this.f2553j;
        byte[] bArr = this.f2547d;
        if (bVarArr != null && bArr != null) {
            c();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    j.E(byteArrayOutputStream, bArr);
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e10) {
                this.f2546c.b(7, e10);
            } catch (IllegalStateException e11) {
                this.f2546c.b(8, e11);
            }
            if (!j.B(byteArrayOutputStream, bArr, bVarArr)) {
                this.f2546c.b(5, null);
                this.f2553j = null;
                byteArrayOutputStream.close();
                return this;
            }
            this.f2554k = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            this.f2553j = null;
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean m() {
        byte[] bArr = this.f2554k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f2548e);
                    try {
                        i2.c.l(byteArrayInputStream, fileOutputStream);
                        k(1, null);
                        fileOutputStream.close();
                        byteArrayInputStream.close();
                        return true;
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } finally {
                this.f2554k = null;
                this.f2553j = null;
            }
        } catch (FileNotFoundException e10) {
            k(6, e10);
            return false;
        } catch (IOException e11) {
            k(7, e11);
            return false;
        }
    }
}
