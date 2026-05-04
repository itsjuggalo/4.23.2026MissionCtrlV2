package x9;

import android.app.Application;
import android.view.LayoutInflater;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ea.i f24703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u9.k f24704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Application f24705c;

    public q(ea.i iVar, u9.k kVar, Application application) {
        this.f24703a = iVar;
        this.f24704b = kVar;
        this.f24705c = application;
    }

    public u9.k a() {
        return this.f24704b;
    }

    public ea.i b() {
        return this.f24703a;
    }

    public LayoutInflater c() {
        return (LayoutInflater) this.f24705c.getSystemService("layout_inflater");
    }
}
