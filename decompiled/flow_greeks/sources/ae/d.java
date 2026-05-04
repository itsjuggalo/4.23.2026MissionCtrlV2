package ae;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class d implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final cd.k f770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final cd.k f771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f772e;

    public d(Class cls, Map map, cd.k kVar, cd.k kVar2, List list) {
        this.f768a = cls;
        this.f769b = map;
        this.f770c = kVar;
        this.f771d = kVar2;
        this.f772e = list;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        return f.o(this.f768a, this.f769b, this.f770c, this.f771d, this.f772e, obj, method, objArr);
    }
}
