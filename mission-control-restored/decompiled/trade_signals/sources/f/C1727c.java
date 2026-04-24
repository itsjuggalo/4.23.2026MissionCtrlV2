package f;

import android.content.Context;
import android.content.Intent;
import e.C1656a;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: f.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1727c extends AbstractC1725a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17344a = new a(null);

    /* JADX INFO: renamed from: f.c$a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    @Override // f.AbstractC1725a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, Intent input) {
        AbstractC2304t.f(context, "context");
        AbstractC2304t.f(input, "input");
        return input;
    }

    @Override // f.AbstractC1725a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public C1656a c(int i8, Intent intent) {
        return new C1656a(i8, intent);
    }
}
