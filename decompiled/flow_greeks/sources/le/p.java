package le;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class p implements pd.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f15636a;

    public p(q qVar) {
        this.f15636a = qVar;
    }

    @Override // pd.k
    public Object invoke(Object obj) {
        return Boolean.valueOf(q.S(this.f15636a, (Method) obj));
    }
}
