package h3;

import e3.C1478g;
import java.io.File;
import java.io.IOException;

/* JADX INFO: renamed from: h3.D, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1673D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n3.g f14737b;

    public C1673D(String str, n3.g gVar) {
        this.f14736a = str;
        this.f14737b = gVar;
    }

    public boolean a() {
        try {
            return b().createNewFile();
        } catch (IOException e7) {
            C1478g.f().e("Error creating marker: " + this.f14736a, e7);
            return false;
        }
    }

    public final File b() {
        return this.f14737b.g(this.f14736a);
    }

    public boolean c() {
        return b().exists();
    }

    public boolean d() {
        return b().delete();
    }
}
