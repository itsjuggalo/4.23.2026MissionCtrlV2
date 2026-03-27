package q2;

import i2.C0655a;
import java.util.Objects;

/* JADX INFO: renamed from: q2.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0931j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0655a f9184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0930i f9185b;

    public C0931j(C0655a c0655a, w2.c cVar) {
        this.f9184a = c0655a;
        this.f9185b = new C0930i(cVar);
    }

    public final void a(String str) {
        C0930i c0930i = this.f9185b;
        synchronized (c0930i) {
            if (!Objects.equals(c0930i.f9182b, str)) {
                C0930i.a(c0930i.f9181a, str, c0930i.f9183c);
                c0930i.f9182b = str;
            }
        }
    }
}
