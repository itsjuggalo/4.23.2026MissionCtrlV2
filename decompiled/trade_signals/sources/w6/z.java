package w6;

import I6.S;
import R5.H;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class z extends C2934b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final S f24101c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(List value, S type) {
        super(value, new y(type));
        AbstractC2304t.f(value, "value");
        AbstractC2304t.f(type, "type");
        this.f24101c = type;
    }

    public static final S c(S s8, H it) {
        AbstractC2304t.f(it, "it");
        return s8;
    }

    public final S e() {
        return this.f24101c;
    }
}
