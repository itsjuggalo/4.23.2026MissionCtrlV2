package j2;

import android.content.Context;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: renamed from: j2.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0741q implements OnSuccessListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f7723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f7724c;

    public C0741q(P3.u uVar, TaskCompletionSource taskCompletionSource, Context context, int i) {
        this.f7722a = i;
        switch (i) {
            case 1:
                this.f7723b = taskCompletionSource;
                this.f7724c = context;
                Objects.requireNonNull(uVar);
                break;
            case 2:
                this.f7723b = taskCompletionSource;
                this.f7724c = context;
                Objects.requireNonNull(uVar);
                break;
            default:
                this.f7723b = taskCompletionSource;
                this.f7724c = context;
                Objects.requireNonNull(uVar);
                break;
        }
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* synthetic */ void onSuccess(Object obj) {
        switch (this.f7722a) {
            case 0:
                this.f7723b.setResult((U) obj);
                P3.u.p(this.f7724c);
                break;
            case 1:
                this.f7723b.setResult((U) obj);
                P3.u.p(this.f7724c);
                break;
            default:
                this.f7723b.setResult((U) obj);
                P3.u.p(this.f7724c);
                break;
        }
    }
}
