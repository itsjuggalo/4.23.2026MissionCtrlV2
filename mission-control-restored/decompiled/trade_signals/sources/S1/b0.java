package S1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import w.C2882a;

/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f7395a = Collections.synchronizedMap(new C2882a());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7396b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f7397c;

    public final AbstractC0875g c(String str, Class cls) {
        return (AbstractC0875g) cls.cast(this.f7395a.get(str));
    }

    public final void d(String str, AbstractC0875g abstractC0875g) {
        if (this.f7395a.containsKey(str)) {
            throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
        }
        this.f7395a.put(str, abstractC0875g);
        if (this.f7396b > 0) {
            new e2.f(Looper.getMainLooper()).post(new a0(this, abstractC0875g, str));
        }
    }

    public final void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Iterator it = this.f7395a.values().iterator();
        while (it.hasNext()) {
            ((AbstractC0875g) it.next()).a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final void f(int i8, int i9, Intent intent) {
        Iterator it = this.f7395a.values().iterator();
        while (it.hasNext()) {
            ((AbstractC0875g) it.next()).e(i8, i9, intent);
        }
    }

    public final void g(Bundle bundle) {
        this.f7396b = 1;
        this.f7397c = bundle;
        for (Map.Entry entry : this.f7395a.entrySet()) {
            ((AbstractC0875g) entry.getValue()).f(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public final void h() {
        this.f7396b = 5;
        Iterator it = this.f7395a.values().iterator();
        while (it.hasNext()) {
            ((AbstractC0875g) it.next()).g();
        }
    }

    public final void i() {
        this.f7396b = 3;
        Iterator it = this.f7395a.values().iterator();
        while (it.hasNext()) {
            ((AbstractC0875g) it.next()).h();
        }
    }

    public final void j(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        for (Map.Entry entry : this.f7395a.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((AbstractC0875g) entry.getValue()).i(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    public final void k() {
        this.f7396b = 2;
        Iterator it = this.f7395a.values().iterator();
        while (it.hasNext()) {
            ((AbstractC0875g) it.next()).j();
        }
    }

    public final void l() {
        this.f7396b = 4;
        Iterator it = this.f7395a.values().iterator();
        while (it.hasNext()) {
            ((AbstractC0875g) it.next()).k();
        }
    }
}
