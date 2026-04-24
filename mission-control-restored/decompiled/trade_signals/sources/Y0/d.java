package Y0;

import Y0.a;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class d implements a.InterfaceC0155a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f9499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f9500b;

    public interface a {
        File a();
    }

    public d(a aVar, long j8) {
        this.f9499a = j8;
        this.f9500b = aVar;
    }

    @Override // Y0.a.InterfaceC0155a
    public Y0.a a() {
        File fileA = this.f9500b.a();
        if (fileA == null) {
            return null;
        }
        if (fileA.isDirectory() || fileA.mkdirs()) {
            return e.c(fileA, this.f9499a);
        }
        return null;
    }
}
