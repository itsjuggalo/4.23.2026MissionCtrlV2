package io.flutter.plugins.firebase.messaging;

import A.b;
import N1.A;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import f.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import k4.C0782h;
import k4.C0783i;
import k4.l;
import k4.m;
import k4.n;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends Service {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f7229f = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final HashMap f7230k = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f7231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f7232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f7233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7234d = false;
    public final ArrayList e = new ArrayList();

    public static n b(Context context, ComponentName componentName, boolean z6, int i, boolean z7) {
        n c0782h;
        A a6 = new A(25);
        HashMap map = f7230k;
        n nVar = (n) map.get(a6);
        if (nVar != null) {
            return nVar;
        }
        if (Build.VERSION.SDK_INT < 26 || z7) {
            c0782h = new C0782h(context, componentName);
        } else {
            if (!z6) {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            c0782h = new m(context, componentName, i);
        }
        map.put(a6, c0782h);
        return c0782h;
    }

    public final void a(boolean z6) {
        if (this.f7233c == null) {
            this.f7233c = new d(this);
            n nVar = this.f7232b;
            if (nVar != null && z6) {
                nVar.d();
            }
            d dVar = this.f7233c;
            ((ExecutorService) dVar.f6383c).execute(new b(dVar, 21));
        }
    }

    public final void c() {
        ArrayList arrayList = this.e;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.f7233c = null;
                    ArrayList arrayList2 = this.e;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        a(false);
                    } else if (!this.f7234d) {
                        this.f7232b.c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        l lVar = this.f7231a;
        if (lVar != null) {
            return lVar.getBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f7231a = new l(this);
            this.f7232b = null;
        }
        this.f7232b = b(this, new ComponentName(this, getClass()), false, 0, true);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        d dVar = this.f7233c;
        if (dVar != null) {
            ((a) dVar.f6384d).c();
        }
        synchronized (this.e) {
            this.f7234d = true;
            this.f7232b.c();
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i6) {
        this.f7232b.e();
        synchronized (this.e) {
            ArrayList arrayList = this.e;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new C0783i(this, intent, i6));
            a(true);
        }
        return 3;
    }
}
