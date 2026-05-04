package ae;

import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public class b implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f765a;

    public b(Map map) {
        this.f765a = map;
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return Integer.valueOf(f.j(this.f765a));
    }
}
