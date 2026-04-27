package androidx.profileinstaller;

import C0.j;
import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AssetManager f7940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f7941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.InterfaceC0135c f7942c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final File f7944e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f7945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f7946g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f7947h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public C0.b[] f7949j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte[] f7950k;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f7948i = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f7943d = d();

    public b(AssetManager assetManager, Executor executor, c.InterfaceC0135c interfaceC0135c, String str, String str2, String str3, File file) {
        this.f7940a = assetManager;
        this.f7941b = executor;
        this.f7942c = interfaceC0135c;
        this.f7945f = str;
        this.f7946g = str2;
        this.f7947h = str3;
        this.f7944e = file;
    }

    public static byte[] d() {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 > 34) {
            return null;
        }
        switch (i7) {
        }
        return null;
    }

    public static boolean k() {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 > 34) {
            return false;
        }
        if (i7 != 24 && i7 != 25) {
            switch (i7) {
            }
            return false;
        }
        return true;
    }

    public final b b(C0.b[] bVarArr, byte[] bArr) {
        InputStream inputStreamH;
        try {
            inputStreamH = h(this.f7940a, this.f7947h);
        } catch (FileNotFoundException e7) {
            this.f7942c.b(9, e7);
        } catch (IOException e8) {
            this.f7942c.b(7, e8);
        } catch (IllegalStateException e9) {
            this.f7949j = null;
            this.f7942c.b(8, e9);
        }
        if (inputStreamH == null) {
            if (inputStreamH != null) {
                inputStreamH.close();
            }
            return null;
        }
        try {
            this.f7949j = j.q(inputStreamH, j.o(inputStreamH, j.f891b), bArr, bVarArr);
            inputStreamH.close();
            return this;
        } catch (Throwable th) {
            try {
                inputStreamH.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void c() {
        if (!this.f7948i) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    public boolean e() {
        if (this.f7943d == null) {
            l(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (!this.f7944e.exists()) {
            try {
                this.f7944e.createNewFile();
            } catch (IOException unused) {
                l(4, null);
                return false;
            }
        } else if (!this.f7944e.canWrite()) {
            l(4, null);
            return false;
        }
        this.f7948i = true;
        return true;
    }

    public final InputStream f(AssetManager assetManager) {
        try {
            return h(assetManager, this.f7946g);
        } catch (FileNotFoundException e7) {
            this.f7942c.b(6, e7);
            return null;
        } catch (IOException e8) {
            this.f7942c.b(7, e8);
            return null;
        }
    }

    public final /* synthetic */ void g(int i7, Object obj) {
        this.f7942c.b(i7, obj);
    }

    public final InputStream h(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e7) {
            String message = e7.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f7942c.a(5, null);
            }
            return null;
        }
    }

    public b i() {
        b bVarB;
        c();
        if (this.f7943d == null) {
            return this;
        }
        InputStream inputStreamF = f(this.f7940a);
        if (inputStreamF != null) {
            this.f7949j = j(inputStreamF);
        }
        C0.b[] bVarArr = this.f7949j;
        return (bVarArr == null || !k() || (bVarB = b(bVarArr, this.f7943d)) == null) ? this : bVarB;
    }

    public final C0.b[] j(InputStream inputStream) {
        try {
            try {
                try {
                    try {
                        C0.b[] bVarArrW = j.w(inputStream, j.o(inputStream, j.f890a), this.f7945f);
                        try {
                            inputStream.close();
                            return bVarArrW;
                        } catch (IOException e7) {
                            this.f7942c.b(7, e7);
                            return bVarArrW;
                        }
                    } catch (IOException e8) {
                        this.f7942c.b(7, e8);
                        return null;
                    }
                } catch (IllegalStateException e9) {
                    this.f7942c.b(8, e9);
                    inputStream.close();
                    return null;
                }
            } catch (IOException e10) {
                this.f7942c.b(7, e10);
                inputStream.close();
                return null;
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e11) {
                this.f7942c.b(7, e11);
            }
            throw th;
        }
    }

    public final void l(final int i7, final Object obj) {
        this.f7941b.execute(new Runnable() { // from class: C0.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f863a.g(i7, obj);
            }
        });
    }

    public b m() {
        ByteArrayOutputStream byteArrayOutputStream;
        C0.b[] bVarArr = this.f7949j;
        byte[] bArr = this.f7943d;
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
            } catch (IOException e7) {
                this.f7942c.b(7, e7);
            } catch (IllegalStateException e8) {
                this.f7942c.b(8, e8);
            }
            if (!j.B(byteArrayOutputStream, bArr, bVarArr)) {
                this.f7942c.b(5, null);
                this.f7949j = null;
                byteArrayOutputStream.close();
                return this;
            }
            this.f7950k = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            this.f7949j = null;
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean n() {
        byte[] bArr = this.f7950k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f7944e);
                    try {
                        C0.c.l(byteArrayInputStream, fileOutputStream);
                        l(1, null);
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
                this.f7950k = null;
                this.f7949j = null;
            }
        } catch (FileNotFoundException e7) {
            l(6, e7);
            return false;
        } catch (IOException e8) {
            l(7, e8);
            return false;
        }
    }
}
