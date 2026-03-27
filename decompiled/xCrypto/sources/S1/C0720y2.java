package S1;

import android.content.Context;
import com.google.android.gms.common.internal.AbstractC0945x;
import com.google.android.gms.common.internal.C0938p;
import com.google.android.gms.common.internal.C0944w;
import com.google.android.gms.common.internal.C0947z;
import com.google.android.gms.common.internal.InterfaceC0946y;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: S1.y2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0720y2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static C0720y2 f5052d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0658q3 f5053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0946y f5054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f5055c = new AtomicLong(-1);

    public C0720y2(Context context, C0658q3 c0658q3) {
        this.f5054b = AbstractC0945x.b(context, C0947z.a().b("measurement:api").a());
        this.f5053a = c0658q3;
    }

    public static C0720y2 a(C0658q3 c0658q3) {
        if (f5052d == null) {
            f5052d = new C0720y2(c0658q3.e(), c0658q3);
        }
        return f5052d;
    }

    public final synchronized void b(int i4, int i5, long j4, long j5, int i6) {
        final long jA = this.f5053a.f().a();
        AtomicLong atomicLong = this.f5055c;
        if (atomicLong.get() != -1 && jA - atomicLong.get() <= 1800000) {
            return;
        }
        this.f5054b.a(new C0944w(0, Arrays.asList(new C0938p(36301, i5, 0, j4, j5, null, null, 0, i6)))).addOnFailureListener(new OnFailureListener() { // from class: S1.x2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final /* synthetic */ void onFailure(Exception exc) {
                this.f5039a.c(jA, exc);
            }
        });
    }

    public final /* synthetic */ void c(long j4, Exception exc) {
        this.f5055c.set(j4);
    }
}
