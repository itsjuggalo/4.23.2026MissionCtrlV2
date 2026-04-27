package P3;

import N3.C0734o;
import android.app.Application;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: P3.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0778n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f6416a;

    public C0778n(Application application) {
        this.f6416a = application;
    }

    public C0734o a(Executor executor) {
        return new C0734o(executor);
    }

    public Application b() {
        return this.f6416a;
    }
}
