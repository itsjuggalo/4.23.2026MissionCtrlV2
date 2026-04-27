package M2;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class Y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f2062a = new ArrayList();

    public Y a(Object obj) {
        this.f2062a.add(String.valueOf(obj));
        return this;
    }

    public Y b(String str, Object obj) {
        this.f2062a.add(str + com.amazon.a.a.o.b.f.f8805b + obj);
        return this;
    }

    public String toString() {
        return this.f2062a.toString();
    }
}
