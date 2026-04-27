package k4;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;

/* JADX INFO: renamed from: k4.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0782h extends n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f7901d;
    public final PowerManager.WakeLock e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PowerManager.WakeLock f7902f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f7903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7904h;

    public C0782h(Context context, ComponentName componentName) {
        super(componentName);
        this.f7901d = context.getApplicationContext();
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
        this.e = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
        PowerManager.WakeLock wakeLockNewWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
        this.f7902f = wakeLockNewWakeLock2;
        wakeLockNewWakeLock2.setReferenceCounted(false);
    }

    @Override // k4.n
    public final void a(Intent intent) {
        Intent intent2 = new Intent(intent);
        intent2.setComponent(this.f7914a);
        if (this.f7901d.startService(intent2) != null) {
            synchronized (this) {
                try {
                    if (!this.f7903g) {
                        this.f7903g = true;
                        if (!this.f7904h) {
                            this.e.acquire(60000L);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // k4.n
    public final void c() {
        synchronized (this) {
            try {
                if (this.f7904h) {
                    if (this.f7903g) {
                        this.e.acquire(60000L);
                    }
                    this.f7904h = false;
                    this.f7902f.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // k4.n
    public final void d() {
        synchronized (this) {
            try {
                if (!this.f7904h) {
                    this.f7904h = true;
                    this.f7902f.acquire(600000L);
                    this.e.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // k4.n
    public final void e() {
        synchronized (this) {
            this.f7903g = false;
        }
    }
}
