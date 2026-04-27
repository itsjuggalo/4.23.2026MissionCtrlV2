package W0;

import Y0.a;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class e implements a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final U0.d f9046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f9047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final U0.h f9048c;

    public e(U0.d dVar, Object obj, U0.h hVar) {
        this.f9046a = dVar;
        this.f9047b = obj;
        this.f9048c = hVar;
    }

    @Override // Y0.a.b
    public boolean a(File file) {
        return this.f9046a.a(this.f9047b, file, this.f9048c);
    }
}
