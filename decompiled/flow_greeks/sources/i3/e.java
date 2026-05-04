package i3;

import java.io.File;
import k3.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e implements a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g3.d f11591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g3.h f11593c;

    public e(g3.d dVar, Object obj, g3.h hVar) {
        this.f11591a = dVar;
        this.f11592b = obj;
        this.f11593c = hVar;
    }

    @Override // k3.a.b
    public boolean a(File file) {
        return this.f11591a.a(this.f11592b, file, this.f11593c);
    }
}
