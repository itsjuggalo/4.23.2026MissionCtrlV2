package M5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import o5.InterfaceC2483k;

/* JADX INFO: loaded from: classes2.dex */
public class d implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f5391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f5392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2483k f5393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC2483k f5394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f5395e;

    public d(Class cls, Map map, InterfaceC2483k interfaceC2483k, InterfaceC2483k interfaceC2483k2, List list) {
        this.f5391a = cls;
        this.f5392b = map;
        this.f5393c = interfaceC2483k;
        this.f5394d = interfaceC2483k2;
        this.f5395e = list;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        return f.o(this.f5391a, this.f5392b, this.f5393c, this.f5394d, this.f5395e, obj, method, objArr);
    }
}
