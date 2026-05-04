package com.google.android.gms.common.internal;

import android.util.Log;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f5667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f5669c;

    public c1(c cVar, Object obj) {
        Objects.requireNonNull(cVar);
        this.f5669c = cVar;
        this.f5667a = obj;
        this.f5668b = false;
    }

    public abstract void a(Object obj);

    public final void b() {
        Object obj;
        synchronized (this) {
            try {
                obj = this.f5667a;
                if (this.f5668b) {
                    String string = toString();
                    StringBuilder sb2 = new StringBuilder(string.length() + 47);
                    sb2.append("Callback proxy ");
                    sb2.append(string);
                    sb2.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb2.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj != null) {
            a(obj);
        }
        synchronized (this) {
            this.f5668b = true;
        }
        c();
    }

    public final void c() {
        d();
        c cVar = this.f5669c;
        synchronized (cVar.zzj()) {
            cVar.zzj().remove(this);
        }
    }

    public final void d() {
        synchronized (this) {
            this.f5667a = null;
        }
    }
}
