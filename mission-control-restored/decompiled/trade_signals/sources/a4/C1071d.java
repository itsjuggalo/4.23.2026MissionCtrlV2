package a4;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: renamed from: a4.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1071d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile C1071d f9961b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f9962a = new HashSet();

    public static C1071d a() {
        C1071d c1071d = f9961b;
        if (c1071d == null) {
            synchronized (C1071d.class) {
                try {
                    c1071d = f9961b;
                    if (c1071d == null) {
                        c1071d = new C1071d();
                        f9961b = c1071d;
                    }
                } finally {
                }
            }
        }
        return c1071d;
    }

    public Set b() {
        Set setUnmodifiableSet;
        synchronized (this.f9962a) {
            setUnmodifiableSet = Collections.unmodifiableSet(this.f9962a);
        }
        return setUnmodifiableSet;
    }
}
