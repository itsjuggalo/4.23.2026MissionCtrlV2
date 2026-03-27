package Y3;

import Z3.p;
import Z3.q;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class h implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3657c;

    public /* synthetic */ h(int i, Object obj, Object obj2) {
        this.f3655a = i;
        this.f3657c = obj;
        this.f3656b = obj2;
    }

    @Override // Z3.p
    public final void a(Object obj, String str, String str2) {
        switch (this.f3655a) {
            case 0:
                Log.e("RestorationChannel", "Error " + str + " while sending restoration data to framework: " + str2);
                break;
            default:
                ((R3.g) this.f3656b).a(((q) ((d) this.f3657c).f3629b).f4017c.c(obj, str, str2));
                break;
        }
    }

    @Override // Z3.p
    public final void b() {
        switch (this.f3655a) {
            case 0:
                break;
            default:
                ((R3.g) this.f3656b).a(null);
                break;
        }
    }

    @Override // Z3.p
    public final void c(Object obj) {
        switch (this.f3655a) {
            case 0:
                ((i) this.f3657c).f3661d = (byte[]) this.f3656b;
                break;
            default:
                ((R3.g) this.f3656b).a(((q) ((d) this.f3657c).f3629b).f4017c.a(obj));
                break;
        }
    }

    private final void d() {
    }
}
