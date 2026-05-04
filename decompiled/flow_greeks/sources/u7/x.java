package u7;

import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a8.g f22389b;

    public x(String str, a8.g gVar) {
        this.f22388a = str;
        this.f22389b = gVar;
    }

    public boolean a() {
        try {
            return b().createNewFile();
        } catch (IOException e10) {
            r7.g.f().e("Error creating marker: " + this.f22388a, e10);
            return false;
        }
    }

    public final File b() {
        return this.f22389b.g(this.f22388a);
    }

    public boolean c() {
        return b().exists();
    }

    public boolean d() {
        return b().delete();
    }
}
