package J5;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(IllegalAccessException cause) {
        super("Cannot obtain the delegate of a non-accessible property. Use \"isAccessible = true\" to make the property accessible", cause);
        AbstractC2304t.f(cause, "cause");
    }
}
