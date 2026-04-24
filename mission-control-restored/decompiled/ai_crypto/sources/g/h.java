package g;

import android.content.Context;
import android.content.Intent;
import f.C1534a;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class h extends AbstractC1624a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14239a = new a(null);

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    @Override // g.AbstractC1624a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, Intent input) {
        r.f(context, "context");
        r.f(input, "input");
        return input;
    }

    @Override // g.AbstractC1624a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public C1534a c(int i7, Intent intent) {
        return new C1534a(i7, intent);
    }
}
