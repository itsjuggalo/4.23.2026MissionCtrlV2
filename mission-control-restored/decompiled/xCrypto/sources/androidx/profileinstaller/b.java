package androidx.profileinstaller;

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
import m0.AbstractC1597c;
import m0.C1596b;
import m0.k;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AssetManager f7831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f7832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.InterfaceC0113c f7833c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final File f7835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f7836f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f7837g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f7838h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public C1596b[] f7840j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte[] f7841k;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f7839i = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f7834d = d();

    public b(AssetManager assetManager, Executor executor, c.InterfaceC0113c interfaceC0113c, String str, String str2, String str3, File file) {
        this.f7831a = assetManager;
        this.f7832b = executor;
        this.f7833c = interfaceC0113c;
        this.f7836f = str;
        this.f7837g = str2;
        this.f7838h = str3;
        this.f7835e = file;
    }

    public static byte[] d() {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 > 34) {
            return null;
        }
        switch (i4) {
        }
        return null;
    }

    public static boolean j() {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 > 34) {
            return false;
        }
        if (i4 != 24 && i4 != 25) {
            switch (i4) {
            }
            return false;
        }
        return true;
    }

    public final b b(C1596b[] c1596bArr, byte[] bArr) {
        InputStream inputStreamG;
        try {
            inputStreamG = g(this.f7831a, this.f7838h);
        } catch (FileNotFoundException e4) {
            this.f7833c.b(9, e4);
        } catch (IOException e5) {
            this.f7833c.b(7, e5);
        } catch (IllegalStateException e6) {
            this.f7840j = null;
            this.f7833c.b(8, e6);
        }
        if (inputStreamG == null) {
            if (inputStreamG != null) {
                inputStreamG.close();
            }
            return null;
        }
        try {
            this.f7840j = k.q(inputStreamG, k.o(inputStreamG, k.f13513b), bArr, c1596bArr);
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
        if (!this.f7839i) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    public boolean e() {
        if (this.f7834d == null) {
            k(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (!this.f7835e.exists()) {
            try {
                this.f7835e.createNewFile();
            } catch (IOException unused) {
                k(4, null);
                return false;
            }
        } else if (!this.f7835e.canWrite()) {
            k(4, null);
            return false;
        }
        this.f7839i = true;
        return true;
    }

    public final InputStream f(AssetManager assetManager) {
        try {
            return g(assetManager, this.f7837g);
        } catch (FileNotFoundException e4) {
            this.f7833c.b(6, e4);
            return null;
        } catch (IOException e5) {
            this.f7833c.b(7, e5);
            return null;
        }
    }

    public final InputStream g(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e4) {
            String message = e4.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f7833c.a(5, null);
            }
            return null;
        }
    }

    public b h() {
        b bVarB;
        c();
        if (this.f7834d != null) {
            InputStream inputStreamF = f(this.f7831a);
            if (inputStreamF != null) {
                this.f7840j = i(inputStreamF);
            }
            C1596b[] c1596bArr = this.f7840j;
            if (c1596bArr != null && j() && (bVarB = b(c1596bArr, this.f7834d)) != null) {
                return bVarB;
            }
        }
        return this;
    }

    public final C1596b[] i(InputStream inputStream) {
        try {
            try {
                try {
                    try {
                        C1596b[] c1596bArrW = k.w(inputStream, k.o(inputStream, k.f13512a), this.f7836f);
                        try {
                            inputStream.close();
                            return c1596bArrW;
                        } catch (IOException e4) {
                            this.f7833c.b(7, e4);
                            return c1596bArrW;
                        }
                    } catch (IOException e5) {
                        this.f7833c.b(7, e5);
                        return null;
                    }
                } catch (IllegalStateException e6) {
                    this.f7833c.b(8, e6);
                    inputStream.close();
                    return null;
                }
            } catch (IOException e7) {
                this.f7833c.b(7, e7);
                inputStream.close();
                return null;
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e8) {
                this.f7833c.b(7, e8);
            }
            throw th;
        }
    }

    public final void k(final int i4, final Object obj) {
        this.f7832b.execute(new Runnable() { // from class: m0.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f13485a.f7833c.b(i4, obj);
            }
        });
    }

    public b l() {
        ByteArrayOutputStream byteArrayOutputStream;
        C1596b[] c1596bArr = this.f7840j;
        byte[] bArr = this.f7834d;
        if (c1596bArr != null && bArr != null) {
            c();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    k.E(byteArrayOutputStream, bArr);
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e4) {
                this.f7833c.b(7, e4);
            } catch (IllegalStateException e5) {
                this.f7833c.b(8, e5);
            }
            if (!k.B(byteArrayOutputStream, bArr, c1596bArr)) {
                this.f7833c.b(5, null);
                this.f7840j = null;
                byteArrayOutputStream.close();
                return this;
            }
            this.f7841k = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            this.f7840j = null;
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean m() {
        byte[] bArr = this.f7841k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f7835e);
                    try {
                        AbstractC1597c.l(byteArrayInputStream, fileOutputStream);
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
                this.f7841k = null;
                this.f7840j = null;
            }
        } catch (FileNotFoundException e4) {
            k(6, e4);
            return false;
        } catch (IOException e5) {
            k(7, e5);
            return false;
        }
    }
}
