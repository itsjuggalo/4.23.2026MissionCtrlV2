package P2;

import P2.C0217o;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.IOException;
import k2.C0763i;
import s1.C0994k;
import u4.AbstractC1225g;
import u4.InterfaceC1227i;
import u4.a0;
import w4.AbstractC1319b;
import w4.Z;
import w4.a2;

/* JADX INFO: renamed from: P2.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0217o implements V, Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f2473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f2474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f2475d;
    public Object e;

    @Override // w4.Z
    public boolean c() {
        return this.f2472a;
    }

    @Override // w4.Z
    public void close() {
        this.f2472a = true;
        s3.D.p("Lack of request message. GET request is only supported for unary requests", ((byte[]) this.f2475d) != null);
        ((x4.j) ((AbstractC1319b) this.e)).f11544o.d((u4.Z) this.f2473b, (byte[]) this.f2475d);
        this.f2475d = null;
        this.f2473b = null;
    }

    @Override // P2.V
    public void d() {
        C0994k c0994k = (C0994k) this.f2475d;
        if (c0994k != null) {
            c0994k.C();
        }
    }

    @Override // w4.Z
    public void e(B4.a aVar) {
        s3.D.p("writePayload should not be called multiple times", ((byte[]) this.f2475d) == null);
        try {
            this.f2475d = W1.g.b(aVar);
            a2 a2Var = (a2) this.f2474c;
            for (AbstractC1225g abstractC1225g : a2Var.f11175a) {
                abstractC1225g.i(0);
            }
            byte[] bArr = (byte[]) this.f2475d;
            long length = bArr.length;
            long length2 = bArr.length;
            for (AbstractC1225g abstractC1225g2 : a2Var.f11175a) {
                abstractC1225g2.j(0, length, length2);
            }
            long length3 = ((byte[]) this.f2475d).length;
            AbstractC1225g[] abstractC1225gArr = a2Var.f11175a;
            for (AbstractC1225g abstractC1225g3 : abstractC1225gArr) {
                abstractC1225g3.k(length3);
            }
            long length4 = ((byte[]) this.f2475d).length;
            for (AbstractC1225g abstractC1225g4 : abstractC1225gArr) {
                abstractC1225g4.l(length4);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public com.google.android.gms.common.api.internal.G f() {
        return new com.google.android.gms.common.api.internal.G((a0) this.f2475d, (String) this.e, (B4.b) this.f2473b, (B4.b) this.f2474c, this.f2472a);
    }

    public synchronized void g() {
        try {
            if (this.f2472a) {
                return;
            }
            Boolean boolI = i();
            this.f2475d = boolI;
            if (boolI == null) {
                J2.b bVar = new J2.b() { // from class: e3.n
                    @Override // J2.b
                    public final void a(J2.a aVar) {
                        C0217o c0217o = this.f6156a;
                        if (c0217o.h()) {
                            Z.B b3 = FirebaseMessaging.f5500l;
                            ((FirebaseMessaging) c0217o.e).k();
                        }
                    }
                };
                this.f2474c = bVar;
                C0763i c0763i = (C0763i) ((J2.d) this.f2473b);
                c0763i.b(c0763i.f7855c, bVar);
            }
            this.f2472a = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean h() {
        Boolean bool;
        try {
            g();
            bool = (Boolean) this.f2475d;
        } catch (Throwable th) {
            throw th;
        }
        return bool != null ? bool.booleanValue() : ((FirebaseMessaging) this.e).f5503a.k();
    }

    public Boolean i() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Z1.h hVar = ((FirebaseMessaging) this.e).f5503a;
        hVar.a();
        Context context = hVar.f3962a;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.messaging", 0);
        if (sharedPreferences.contains("auto_init")) {
            return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                return null;
            }
            return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Override // P2.V
    public void start() {
        if (((r) this.e).f2482b.f1899a != -1) {
            this.f2475d = ((U2.f) this.f2473b).b(U2.e.f3136k, this.f2472a ? r.f2480d : r.f2479c, new E3.d(this, 3));
        }
    }

    @Override // w4.Z
    public void flush() {
    }

    @Override // w4.Z
    public void a(int i) {
    }

    @Override // w4.Z
    public Z b(InterfaceC1227i interfaceC1227i) {
        return this;
    }
}
