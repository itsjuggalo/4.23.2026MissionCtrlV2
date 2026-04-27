package t5;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class Y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f23613a = new ArrayList();

    public Y a(Object obj) {
        this.f23613a.add(String.valueOf(obj));
        return this;
    }

    public Y b(String str, Object obj) {
        this.f23613a.add(str + com.amazon.a.a.o.b.f.f9990b + obj);
        return this;
    }

    public String toString() {
        return this.f23613a.toString();
    }
}
