package M5;

import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public class b implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f5388a;

    public b(Map map) {
        this.f5388a = map;
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return Integer.valueOf(f.j(this.f5388a));
    }
}
