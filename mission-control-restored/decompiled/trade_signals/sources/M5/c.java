package M5;

import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f5389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f5390b;

    public c(Class cls, Map map) {
        this.f5389a = cls;
        this.f5390b = map;
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return f.l(this.f5389a, this.f5390b);
    }
}
