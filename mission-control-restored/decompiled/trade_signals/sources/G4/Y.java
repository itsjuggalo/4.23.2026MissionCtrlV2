package G4;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class Y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f2650a = new ArrayList();

    public Y a(Object obj) {
        this.f2650a.add(String.valueOf(obj));
        return this;
    }

    public Y b(String str, Object obj) {
        this.f2650a.add(str + com.amazon.a.a.o.b.f.f14101b + obj);
        return this;
    }

    public String toString() {
        return this.f2650a.toString();
    }
}
