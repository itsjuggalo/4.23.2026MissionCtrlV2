package S2;

import java.io.File;
import java.io.IOException;

/* JADX INFO: renamed from: S2.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0918z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Y2.g f7638b;

    public C0918z(String str, Y2.g gVar) {
        this.f7637a = str;
        this.f7638b = gVar;
    }

    public boolean a() {
        try {
            return b().createNewFile();
        } catch (IOException e8) {
            P2.g.f().e("Error creating marker: " + this.f7637a, e8);
            return false;
        }
    }

    public final File b() {
        return this.f7638b.g(this.f7637a);
    }

    public boolean c() {
        return b().exists();
    }

    public boolean d() {
        return b().delete();
    }
}
