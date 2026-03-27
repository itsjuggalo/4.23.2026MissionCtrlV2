package X5;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class p implements B5.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f9437a;

    public p(q qVar) {
        this.f9437a = qVar;
    }

    @Override // B5.k
    public Object invoke(Object obj) {
        return Boolean.valueOf(q.T(this.f9437a, (Method) obj));
    }
}
