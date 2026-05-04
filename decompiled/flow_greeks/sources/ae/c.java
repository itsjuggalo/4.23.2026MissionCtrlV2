package ae;

import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public class c implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f767b;

    public c(Class cls, Map map) {
        this.f766a = cls;
        this.f767b = map;
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return f.l(this.f766a, this.f767b);
    }
}
