package f;

import android.content.Context;
import android.content.Intent;
import e.C1219a;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: f.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1240c extends AbstractC1238a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11519a = new a(null);

    /* JADX INFO: renamed from: f.c$a */
    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public a() {
        }
    }

    @Override // f.AbstractC1238a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, Intent input) {
        r.f(context, "context");
        r.f(input, "input");
        return input;
    }

    @Override // f.AbstractC1238a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public C1219a c(int i4, Intent intent) {
        return new C1219a(i4, intent);
    }
}
