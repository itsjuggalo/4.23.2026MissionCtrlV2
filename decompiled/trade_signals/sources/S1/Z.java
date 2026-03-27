package S1;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class Z extends Fragment implements InterfaceC0876h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap f7386b = new WeakHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f7387a = new b0();

    public static Z d(Activity activity) {
        Z z7;
        WeakHashMap weakHashMap = f7386b;
        WeakReference weakReference = (WeakReference) weakHashMap.get(activity);
        if (weakReference != null && (z7 = (Z) weakReference.get()) != null) {
            return z7;
        }
        try {
            Z z8 = (Z) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (z8 == null || z8.isRemoving()) {
                z8 = new Z();
                activity.getFragmentManager().beginTransaction().add(z8, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            weakHashMap.put(activity, new WeakReference(z8));
            return z8;
        } catch (ClassCastException e8) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e8);
        }
    }

    @Override // S1.InterfaceC0876h
    public final AbstractC0875g a(String str, Class cls) {
        return this.f7387a.c(str, cls);
    }

    @Override // S1.InterfaceC0876h
    public final Activity b() {
        return getActivity();
    }

    @Override // S1.InterfaceC0876h
    public final void c(String str, AbstractC0875g abstractC0875g) {
        this.f7387a.d(str, abstractC0875g);
    }

    @Override // android.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        this.f7387a.e(str, fileDescriptor, printWriter, strArr);
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i8, int i9, Intent intent) {
        super.onActivityResult(i8, i9, intent);
        this.f7387a.f(i8, i9, intent);
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7387a.g(bundle);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f7387a.h();
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f7387a.i();
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f7387a.j(bundle);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f7387a.k();
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f7387a.l();
    }
}
