package S1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.internal.AbstractC1294n;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: renamed from: S1.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0875g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0876h f7425a;

    public AbstractC0875g(InterfaceC0876h interfaceC0876h) {
        this.f7425a = interfaceC0876h;
    }

    public static InterfaceC0876h c(C0874f c0874f) {
        if (c0874f.d()) {
            return c0.m(c0874f.b());
        }
        if (c0874f.c()) {
            return Z.d(c0874f.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    public static InterfaceC0876h d(Activity activity) {
        return c(new C0874f(activity));
    }

    public Activity b() {
        Activity activityB = this.f7425a.b();
        AbstractC1294n.j(activityB);
        return activityB;
    }

    public abstract void e(int i8, int i9, Intent intent);

    public void g() {
    }

    public void h() {
    }

    public void j() {
    }

    public void k() {
    }

    public void f(Bundle bundle) {
    }

    public void i(Bundle bundle) {
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }
}
