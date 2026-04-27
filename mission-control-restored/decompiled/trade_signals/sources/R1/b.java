package R1;

import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public class b extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Status f7095a;

    public b(Status status) {
        super(status.d() + ": " + (status.e() != null ? status.e() : ""));
        this.f7095a = status;
    }

    public Status a() {
        return this.f7095a;
    }
}
