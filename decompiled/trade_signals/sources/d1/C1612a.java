package d1;

import android.content.res.Resources;
import q1.AbstractC2628k;

/* JADX INFO: renamed from: d1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1612a implements U0.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final U0.j f16772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources f16773b;

    public C1612a(Resources resources, U0.j jVar) {
        this.f16773b = (Resources) AbstractC2628k.d(resources);
        this.f16772a = (U0.j) AbstractC2628k.d(jVar);
    }

    @Override // U0.j
    public W0.v a(Object obj, int i8, int i9, U0.h hVar) {
        return y.f(this.f16773b, this.f16772a.a(obj, i8, i9, hVar));
    }

    @Override // U0.j
    public boolean b(Object obj, U0.h hVar) {
        return this.f16772a.b(obj, hVar);
    }
}
