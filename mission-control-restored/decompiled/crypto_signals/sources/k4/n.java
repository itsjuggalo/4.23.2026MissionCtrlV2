package k4;

import android.content.ComponentName;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ComponentName f7914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7916c;

    public n(ComponentName componentName) {
        this.f7914a = componentName;
    }

    public abstract void a(Intent intent);

    public final void b(int i) {
        if (!this.f7915b) {
            this.f7915b = true;
            this.f7916c = i;
        } else {
            if (this.f7916c == i) {
                return;
            }
            StringBuilder sbO = a3.d.o("Given job ID ", i, " is different than previous ");
            sbO.append(this.f7916c);
            throw new IllegalArgumentException(sbO.toString());
        }
    }

    public void c() {
    }

    public void d() {
    }

    public void e() {
    }
}
