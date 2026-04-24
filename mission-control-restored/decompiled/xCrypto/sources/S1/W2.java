package S1;

import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Objects;
import u.C1857e;

/* JADX INFO: loaded from: classes.dex */
public final class W2 extends C1857e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0554d3 f4272a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W2(C0554d3 c0554d3, int i4) {
        super(20);
        Objects.requireNonNull(c0554d3);
        this.f4272a = c0554d3;
    }

    @Override // u.C1857e
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        String str = (String) obj;
        AbstractC0940s.e(str);
        return this.f4272a.o(str);
    }
}
