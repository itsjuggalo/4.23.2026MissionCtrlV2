package f;

import android.content.Context;
import android.content.Intent;
import e.C1656a;
import e.f;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: f.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1728d extends AbstractC1725a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17345a = new a(null);

    /* JADX INFO: renamed from: f.d$a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    @Override // f.AbstractC1725a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, f input) {
        AbstractC2304t.f(context, "context");
        AbstractC2304t.f(input, "input");
        Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", input);
        AbstractC2304t.e(intentPutExtra, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
        return intentPutExtra;
    }

    @Override // f.AbstractC1725a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public C1656a c(int i8, Intent intent) {
        return new C1656a(i8, intent);
    }
}
