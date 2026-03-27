package g;

import android.content.Context;
import android.content.Intent;
import f.C1534a;
import f.C1540g;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class i extends AbstractC1624a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14240a = new a(null);

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    @Override // g.AbstractC1624a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, C1540g input) {
        r.f(context, "context");
        r.f(input, "input");
        Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", input);
        r.e(intentPutExtra, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
        return intentPutExtra;
    }

    @Override // g.AbstractC1624a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public C1534a c(int i7, Intent intent) {
        return new C1534a(i7, intent);
    }
}
