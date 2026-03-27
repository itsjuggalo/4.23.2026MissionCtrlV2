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
import x0.AbstractC2942c;
import x0.AbstractC2949j;
import x0.C2941b;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AssetManager f12127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f12128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.InterfaceC0196c f12129c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final File f12131e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f12132f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f12133g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f12134h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public C2941b[] f12136j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte[] f12137k;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f12135i = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f12130d = d();

    public b(AssetManager assetManager, Executor executor, c.InterfaceC0196c interfaceC0196c, String str, String str2, String str3, File file) {
        this.f12127a = assetManager;
        this.f12128b = executor;
        this.f12129c = interfaceC0196c;
        this.f12132f = str;
        this.f12133g = str2;
        this.f12134h = str3;
        this.f12131e = file;
    }

    public static byte[] d() {
        int i8 = Build.VERSION.SDK_INT;
        if (i8 > 34) {
            return null;
        }
        switch (i8) {
        }
        return null;
    }

    public static boolean k() {
        int i8 = Build.VERSION.SDK_INT;
        if (i8 > 34) {
            return false;
        }
        if (i8 != 25) {
            switch (i8) {
            }
            return false;
        }
        return true;
    }

    public final b b(C2941b[] c2941bArr, byte[] bArr) {
        c.InterfaceC0196c interfaceC0196c;
        int i8;
        InputStream inputStreamH;
        try {
            inputStreamH = h(this.f12127a, this.f12134h);
        } catch (FileNotFoundException e8) {
            e = e8;
            interfaceC0196c = this.f12129c;
            i8 = 9;
            interfaceC0196c.b(i8, e);
        } catch (IOException e9) {
            e = e9;
            interfaceC0196c = this.f12129c;
            i8 = 7;
            interfaceC0196c.b(i8, e);
        } catch (IllegalStateException e10) {
            e = e10;
            this.f12136j = null;
            interfaceC0196c = this.f12129c;
            i8 = 8;
            interfaceC0196c.b(i8, e);
        }
        if (inputStreamH == null) {
            if (inputStreamH != null) {
                inputStreamH.close();
            }
            return null;
        }
        try {
            this.f12136j = AbstractC2949j.q(inputStreamH, AbstractC2949j.o(inputStreamH, AbstractC2949j.f24134b), bArr, c2941bArr);
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
        if (!this.f12135i) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    public boolean e() {
        if (this.f12130d == null) {
            l(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (!this.f12131e.exists()) {
            try {
                this.f12131e.createNewFile();
            } catch (IOException unused) {
                l(4, null);
                return false;
            }
        } else if (!this.f12131e.canWrite()) {
            l(4, null);
            return false;
        }
        this.f12135i = true;
        return true;
    }

    public final InputStream f(AssetManager assetManager) {
        c.InterfaceC0196c interfaceC0196c;
        int i8;
        try {
            return h(assetManager, this.f12133g);
        } catch (FileNotFoundException e8) {
            e = e8;
            interfaceC0196c = this.f12129c;
            i8 = 6;
            interfaceC0196c.b(i8, e);
            return null;
        } catch (IOException e9) {
            e = e9;
            interfaceC0196c = this.f12129c;
            i8 = 7;
            interfaceC0196c.b(i8, e);
            return null;
        }
    }

    public final /* synthetic */ void g(int i8, Object obj) {
        this.f12129c.b(i8, obj);
    }

    public final InputStream h(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e8) {
            String message = e8.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f12129c.a(5, null);
            }
            return null;
        }
    }

    public b i() {
        b bVarB;
        c();
        if (this.f12130d == null) {
            return this;
        }
        InputStream inputStreamF = f(this.f12127a);
        if (inputStreamF != null) {
            this.f12136j = j(inputStreamF);
        }
        C2941b[] c2941bArr = this.f12136j;
        return (c2941bArr == null || !k() || (bVarB = b(c2941bArr, this.f12130d)) == null) ? this : bVarB;
    }

    public final C2941b[] j(InputStream inputStream) {
        try {
            try {
                try {
                    try {
                        C2941b[] c2941bArrW = AbstractC2949j.w(inputStream, AbstractC2949j.o(inputStream, AbstractC2949j.f24133a), this.f12132f);
                        try {
                            inputStream.close();
                            return c2941bArrW;
                        } catch (IOException e8) {
                            this.f12129c.b(7, e8);
                            return c2941bArrW;
                        }
                    } catch (IOException e9) {
                        this.f12129c.b(7, e9);
                        return null;
                    }
                } catch (IllegalStateException e10) {
                    this.f12129c.b(8, e10);
                    inputStream.close();
                    return null;
                }
            } catch (IOException e11) {
                this.f12129c.b(7, e11);
                inputStream.close();
                return null;
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e12) {
                this.f12129c.b(7, e12);
            }
            throw th;
        }
    }

    public final void l(final int i8, final Object obj) {
        this.f12128b.execute(new Runnable() { // from class: x0.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f24106a.g(i8, obj);
            }
        });
    }

    public b m() {
        c.InterfaceC0196c interfaceC0196c;
        int i8;
        ByteArrayOutputStream byteArrayOutputStream;
        C2941b[] c2941bArr = this.f12136j;
        byte[] bArr = this.f12130d;
        if (c2941bArr != null && bArr != null) {
            c();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    AbstractC2949j.E(byteArrayOutputStream, bArr);
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e8) {
                e = e8;
                interfaceC0196c = this.f12129c;
                i8 = 7;
                interfaceC0196c.b(i8, e);
            } catch (IllegalStateException e9) {
                e = e9;
                interfaceC0196c = this.f12129c;
                i8 = 8;
                interfaceC0196c.b(i8, e);
            }
            if (!AbstractC2949j.B(byteArrayOutputStream, bArr, c2941bArr)) {
                this.f12129c.b(5, null);
                this.f12136j = null;
                byteArrayOutputStream.close();
                return this;
            }
            this.f12137k = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            this.f12136j = null;
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean n() {
        byte[] bArr = this.f12137k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f12131e);
                    try {
                        AbstractC2942c.l(byteArrayInputStream, fileOutputStream);
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
                this.f12137k = null;
                this.f12136j = null;
            }
        } catch (FileNotFoundException e8) {
            l(6, e8);
            return false;
        } catch (IOException e9) {
            l(7, e9);
            return false;
        }
    }
}
