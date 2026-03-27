package K3;

import android.app.Application;
import android.view.LayoutInflater;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final R3.i f4762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H3.k f4763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Application f4764c;

    public q(R3.i iVar, H3.k kVar, Application application) {
        this.f4762a = iVar;
        this.f4763b = kVar;
        this.f4764c = application;
    }

    public H3.k a() {
        return this.f4763b;
    }

    public R3.i b() {
        return this.f4762a;
    }

    public LayoutInflater c() {
        return (LayoutInflater) this.f4764c.getSystemService("layout_inflater");
    }
}
