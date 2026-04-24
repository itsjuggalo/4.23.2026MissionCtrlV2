package X3;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile d f5490b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f5491a = new HashSet();

    public static d a() {
        d dVar = f5490b;
        if (dVar == null) {
            synchronized (d.class) {
                try {
                    dVar = f5490b;
                    if (dVar == null) {
                        dVar = new d();
                        f5490b = dVar;
                    }
                } finally {
                }
            }
        }
        return dVar;
    }

    public Set b() {
        Set setUnmodifiableSet;
        synchronized (this.f5491a) {
            setUnmodifiableSet = Collections.unmodifiableSet(this.f5491a);
        }
        return setUnmodifiableSet;
    }
}
